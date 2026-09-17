CREATE DATABASE IF NOT EXISTS MiscelaneaBellavista;

USE MiscelaneaBellavista;

CREATE TABLE IF NOT EXISTS config (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_empresa VARCHAR(200) NOT NULL,
    ruc VARCHAR(20) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    razon_social VARCHAR(200) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuarios (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    pass VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS clientes (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS proveedores (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ruc BIGINT NOT NULL UNIQUE,
    nombre VARCHAR(200) NOT NULL,
    vendedor VARCHAR(200) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    razon_social VARCHAR(200) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS categorias (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS productos (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(30) NOT NULL UNIQUE,
    nombre VARCHAR(200) NOT NULL,
    categoria_id INT UNSIGNED,
    proveedor_id INT UNSIGNED,
    stock INT UNSIGNED NOT NULL DEFAULT 0,
    precio_neto DECIMAL(10,2) NOT NULL,
    precio_bruto DECIMAL(10,2) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    costo_promedio DECIMAL(10,2) NULL COMMENT 'Costo ponderado real de compra',
    tasa_iva DECIMAL(5,2) NOT NULL DEFAULT 19.00 COMMENT 'Porcentaje de IVA aplicable (0, 5, 19)',
    fecha_caducidad DATE NULL COMMENT 'NULL si el producto no vence',
    unidad_medida VARCHAR(20) NOT NULL DEFAULT 'unidad' COMMENT 'unidad, kg, litro, caja, etc.',
    stock_minimo INT UNSIGNED NOT NULL DEFAULT 0 COMMENT 'Umbral para alertas de reabastecimiento',
    FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS codigos_barras (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    codigo_barra VARCHAR(50) NOT NULL UNIQUE,
    producto_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ventas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT UNSIGNED,
    vendedor VARCHAR(100) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    subtotal DECIMAL(10,2) NULL COMMENT 'Total antes de impuestos',
    iva_total DECIMAL(10,2) NULL COMMENT 'Suma del IVA de todas las líneas',
    descuento_total DECIMAL(10,2) NOT NULL DEFAULT 0,
    estado ENUM('completada','anulada') NOT NULL DEFAULT 'completada',
    forma_pago ENUM('efectivo','tarjeta','transferencia') NOT NULL DEFAULT 'efectivo',
    numero_factura VARCHAR(20) NULL COMMENT 'Consecutivo interno propio',
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS detalle_ventas (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    codigo_producto INT UNSIGNED NOT NULL,
    cantidad INT UNSIGNED NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    id_venta INT UNSIGNED NOT NULL,
    FOREIGN KEY (codigo_producto) REFERENCES productos(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_venta) REFERENCES ventas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS devoluciones (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_venta INT UNSIGNED NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_venta) REFERENCES ventas(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS detalle_devolucion (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_devolucion INT UNSIGNED NOT NULL,
    producto_id INT UNSIGNED NOT NULL,
    cantidad INT UNSIGNED NOT NULL,
    FOREIGN KEY (id_devolucion) REFERENCES devoluciones(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS compras (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    proveedor_id INT UNSIGNED NOT NULL,
    usuario_id INT UNSIGNED NULL COMMENT 'Quién registró la compra',
    numero_factura_proveedor VARCHAR(50) NULL COMMENT 'Número de factura que emitió el proveedor',
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    subtotal DECIMAL(10,2) NOT NULL DEFAULT 0,
    iva_total DECIMAL(10,2) NOT NULL DEFAULT 0,
    total DECIMAL(10,2) NOT NULL DEFAULT 0,
    estado ENUM('registrada','anulada') NOT NULL DEFAULT 'registrada',
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
        ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS detalle_compras (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_compra INT UNSIGNED NOT NULL,
    producto_id INT UNSIGNED NOT NULL,
    cantidad INT UNSIGNED NOT NULL,
    costo_unitario DECIMAL(10,2) NOT NULL,
    iva_linea DECIMAL(10,2) NOT NULL DEFAULT 0,
    subtotal_linea DECIMAL(10,2) NOT NULL COMMENT 'cantidad * costo_unitario, guardado como snapshot',
    FOREIGN KEY (id_compra) REFERENCES compras(id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id)
        ON DELETE CASCADE ON UPDATE CASCADE
);