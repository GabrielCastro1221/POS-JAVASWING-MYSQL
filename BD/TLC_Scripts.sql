USE MiscelaneaBellavista;

DROP PROCEDURE IF EXISTS sp_registrar_venta;

DELIMITER $$

CREATE PROCEDURE sp_registrar_venta(
    IN  p_cliente_id INT UNSIGNED,
    IN  p_vendedor    VARCHAR(100),
    IN  p_items       JSON,
    OUT p_venta_id    INT UNSIGNED,
    OUT p_mensaje     VARCHAR(255)
)
proc_venta: BEGIN
    DECLARE v_total        DECIMAL(10,2) DEFAULT 0;
    DECLARE v_cantidad_items INT;
    DECLARE v_idx          INT DEFAULT 0;
    DECLARE v_producto_id  INT UNSIGNED;
    DECLARE v_cantidad     INT UNSIGNED;
    DECLARE v_stock_actual INT UNSIGNED;
    DECLARE v_precio       DECIMAL(10,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SET p_venta_id = NULL;
        GET DIAGNOSTICS CONDITION 1 p_mensaje = MESSAGE_TEXT;
    END;

    START TRANSACTION;

    INSERT INTO ventas (cliente_id, vendedor, total, fecha)
    VALUES (p_cliente_id, p_vendedor, 0, NOW());

    SET p_venta_id = LAST_INSERT_ID();
    SET v_cantidad_items = JSON_LENGTH(p_items);
    SET v_idx = 0;

    WHILE v_idx < v_cantidad_items DO
        SET v_producto_id = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].producto_id')));
        SET v_cantidad     = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].cantidad')));

        SELECT stock, precio_bruto INTO v_stock_actual, v_precio
        FROM productos
        WHERE id = v_producto_id
        FOR UPDATE;

        IF v_stock_actual IS NULL THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Producto no encontrado';
        END IF;

        IF v_stock_actual < v_cantidad THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Stock insuficiente para uno de los productos';
        END IF;

        UPDATE productos
        SET stock = stock - v_cantidad
        WHERE id = v_producto_id;

        INSERT INTO detalle_ventas (codigo_producto, cantidad, precio, id_venta)
        VALUES (v_producto_id, v_cantidad, v_precio, p_venta_id);

        SET v_total = v_total + (v_precio * v_cantidad);
        SET v_idx = v_idx + 1;
    END WHILE;

    UPDATE ventas SET total = v_total WHERE id = p_venta_id;

    COMMIT;
    SET p_mensaje = 'Venta registrada con éxito';
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS sp_anular_venta;

DELIMITER $$

CREATE PROCEDURE sp_anular_venta(
    IN  p_venta_id INT UNSIGNED,
    OUT p_mensaje  VARCHAR(255)
)
proc_anular: BEGIN
    DECLARE v_existe INT DEFAULT 0;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        GET DIAGNOSTICS CONDITION 1 p_mensaje = MESSAGE_TEXT;
    END;

    START TRANSACTION;

    SELECT COUNT(*) INTO v_existe FROM ventas WHERE id = p_venta_id;

    IF v_existe = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'La venta no existe';
    END IF;

    UPDATE productos p
    JOIN detalle_ventas dv ON dv.codigo_producto = p.id
    SET p.stock = p.stock + dv.cantidad
    WHERE dv.id_venta = p_venta_id;

    DELETE FROM ventas WHERE id = p_venta_id;

    COMMIT;
    SET p_mensaje = 'Venta anulada y stock restaurado con éxito';
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS sp_registrar_devolucion;

DELIMITER $$

CREATE PROCEDURE sp_registrar_devolucion(
    IN  p_venta_id  INT UNSIGNED,
    IN  p_items     JSON,
    OUT p_mensaje   VARCHAR(255)
)
proc_devolucion: BEGIN
    DECLARE v_devolucion_id     INT UNSIGNED;
    DECLARE v_cantidad_items    INT;
    DECLARE v_idx               INT DEFAULT 0;
    DECLARE v_producto_id       INT UNSIGNED;
    DECLARE v_cantidad_devuelta INT UNSIGNED;
    DECLARE v_cantidad_vendida  INT UNSIGNED;
    DECLARE v_precio            DECIMAL(10,2);
    DECLARE v_detalle_id        INT UNSIGNED;

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        GET DIAGNOSTICS CONDITION 1 p_mensaje = MESSAGE_TEXT;
    END;

    START TRANSACTION;

    IF NOT EXISTS (SELECT 1 FROM ventas WHERE id = p_venta_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La venta no existe';
    END IF;

    INSERT INTO devoluciones (id_venta, fecha) VALUES (p_venta_id, NOW());
    SET v_devolucion_id = LAST_INSERT_ID();

    SET v_cantidad_items = JSON_LENGTH(p_items);
    SET v_idx = 0;

    WHILE v_idx < v_cantidad_items DO
        SET v_producto_id       = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].producto_id')));
        SET v_cantidad_devuelta = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].cantidad')));

        SET v_detalle_id = NULL;

        SELECT id, cantidad, precio INTO v_detalle_id, v_cantidad_vendida, v_precio
        FROM detalle_ventas
        WHERE id_venta = p_venta_id AND codigo_producto = v_producto_id
        FOR UPDATE;

        IF v_detalle_id IS NULL THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Ese producto no pertenece a esta venta';
        END IF;

        IF v_cantidad_devuelta > v_cantidad_vendida THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'No puedes devolver más unidades de las que se vendieron';
        END IF;

        INSERT INTO detalle_devolucion (id_devolucion, producto_id, cantidad)
        VALUES (v_devolucion_id, v_producto_id, v_cantidad_devuelta);

        UPDATE productos
        SET stock = stock + v_cantidad_devuelta
        WHERE id = v_producto_id;

        IF v_cantidad_devuelta = v_cantidad_vendida THEN
            DELETE FROM detalle_ventas WHERE id = v_detalle_id;
        ELSE
            UPDATE detalle_ventas
            SET cantidad = cantidad - v_cantidad_devuelta
            WHERE id = v_detalle_id;
        END IF;

        UPDATE ventas
        SET total = total - (v_precio * v_cantidad_devuelta)
        WHERE id = p_venta_id;

        SET v_idx = v_idx + 1;
    END WHILE;

    COMMIT;
    SET p_mensaje = 'Devolución registrada correctamente';
END$$

DELIMITER ;

DROP PROCEDURE IF EXISTS sp_registrar_compra;

DELIMITER $$

CREATE PROCEDURE sp_registrar_compra(
    IN  p_proveedor_id  INT UNSIGNED,
    IN  p_usuario_id    INT UNSIGNED,
    IN  p_numero_factura VARCHAR(50),
    IN  p_items         JSON,
    OUT p_compra_id     INT UNSIGNED,
    OUT p_mensaje       VARCHAR(255)
)
proc_compra: BEGIN
    DECLARE v_subtotal_total   DECIMAL(10,2) DEFAULT 0;
    DECLARE v_iva_total        DECIMAL(10,2) DEFAULT 0;
    DECLARE v_cantidad_items   INT;
    DECLARE v_idx              INT DEFAULT 0;

    DECLARE v_producto_id      INT UNSIGNED;
    DECLARE v_cantidad         INT UNSIGNED;
    DECLARE v_costo_unitario   DECIMAL(10,2);
    DECLARE v_tasa_iva         DECIMAL(5,2);
    DECLARE v_iva_linea        DECIMAL(10,2);
    DECLARE v_subtotal_linea   DECIMAL(10,2);

    DECLARE v_stock_actual     INT UNSIGNED;
    DECLARE v_costo_prom_actual DECIMAL(10,2);
    DECLARE v_nuevo_costo_prom  DECIMAL(10,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SET p_compra_id = NULL;
        GET DIAGNOSTICS CONDITION 1 p_mensaje = MESSAGE_TEXT;
    END;

    START TRANSACTION;

    IF NOT EXISTS (SELECT 1 FROM proveedores WHERE id = p_proveedor_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El proveedor no existe';
    END IF;

    INSERT INTO compras (proveedor_id, usuario_id, numero_factura_proveedor, fecha, subtotal, iva_total, total)
    VALUES (p_proveedor_id, p_usuario_id, p_numero_factura, NOW(), 0, 0, 0);

    SET p_compra_id = LAST_INSERT_ID();
    SET v_cantidad_items = JSON_LENGTH(p_items);
    SET v_idx = 0;

    WHILE v_idx < v_cantidad_items DO
        SET v_producto_id    = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].producto_id')));
        SET v_cantidad       = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].cantidad')));
        SET v_costo_unitario = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].costo_unitario')));
        SET v_tasa_iva       = JSON_UNQUOTE(JSON_EXTRACT(p_items, CONCAT('$[', v_idx, '].tasa_iva')));

        IF NOT EXISTS (SELECT 1 FROM productos WHERE id = v_producto_id) THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Uno de los productos no existe';
        END IF;

        SET v_subtotal_linea = v_cantidad * v_costo_unitario;
        SET v_iva_linea = v_subtotal_linea * (v_tasa_iva / 100);

        INSERT INTO detalle_compras (id_compra, producto_id, cantidad, costo_unitario, iva_linea, subtotal_linea)
        VALUES (p_compra_id, v_producto_id, v_cantidad, v_costo_unitario, v_iva_linea, v_subtotal_linea);

        SELECT stock, costo_promedio INTO v_stock_actual, v_costo_prom_actual
        FROM productos
        WHERE id = v_producto_id
        FOR UPDATE;

        IF v_costo_prom_actual IS NULL OR v_stock_actual = 0 THEN
            SET v_nuevo_costo_prom = v_costo_unitario;
        ELSE
            SET v_nuevo_costo_prom =
                ((v_stock_actual * v_costo_prom_actual) + (v_cantidad * v_costo_unitario))
                / (v_stock_actual + v_cantidad);
        END IF;

        UPDATE productos
        SET stock = stock + v_cantidad,
            costo_promedio = v_nuevo_costo_prom
        WHERE id = v_producto_id;

        SET v_subtotal_total = v_subtotal_total + v_subtotal_linea;
        SET v_iva_total = v_iva_total + v_iva_linea;

        SET v_idx = v_idx + 1;
    END WHILE;

    UPDATE compras
    SET subtotal = v_subtotal_total,
        iva_total = v_iva_total,
        total = v_subtotal_total + v_iva_total
    WHERE id = p_compra_id;

    COMMIT;
    SET p_mensaje = 'Compra registrada correctamente';
END$$

DELIMITER ;

