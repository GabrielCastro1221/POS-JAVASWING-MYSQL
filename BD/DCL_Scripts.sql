CREATE USER IF NOT EXISTS 'app_login'@'%' IDENTIFIED BY 'LoginBellavista2026!';
GRANT SELECT (id, nombre, correo, pass, rol, telefono)
    ON MiscelaneaBellavista.usuarios TO 'app_login'@'%';

CREATE USER IF NOT EXISTS 'app_admin'@'%' IDENTIFIED BY 'AdminBellavista2026!';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.clientes       TO 'app_admin'@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.proveedores    TO 'app_admin'@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.categorias     TO 'app_admin'@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.productos      TO 'app_admin'@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.ventas         TO 'app_admin'@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.detalle_ventas TO 'app_admin'@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.config         TO 'app_admin'@'%';
GRANT SELECT, INSERT, UPDATE, DELETE ON MiscelaneaBellavista.usuarios       TO 'app_admin'@'%';

CREATE USER IF NOT EXISTS 'app_vendedor'@'%' IDENTIFIED BY 'VendedorBellavista2026!';

GRANT SELECT ON MiscelaneaBellavista.categorias  TO 'app_vendedor'@'%';
GRANT SELECT ON MiscelaneaBellavista.proveedores TO 'app_vendedor'@'%';
GRANT SELECT ON MiscelaneaBellavista.codigos_barras TO 'app_vendedor'@'%';
GRANT SELECT ON MiscelaneaBellavista.config TO 'app_login'@'%';
GRANT SELECT ON MiscelaneaBellavista.config TO 'app_vendedor'@'%';
GRANT SELECT ON MiscelaneaBellavista.productos TO 'app_vendedor'@'%';

GRANT UPDATE (stock) ON MiscelaneaBellavista.productos TO 'app_vendedor'@'%';

GRANT SELECT, INSERT, UPDATE ON MiscelaneaBellavista.clientes TO 'app_vendedor'@'%';

GRANT SELECT, INSERT ON MiscelaneaBellavista.ventas         TO 'app_vendedor'@'%';
GRANT SELECT, INSERT ON MiscelaneaBellavista.detalle_ventas TO 'app_vendedor'@'%';

SHOW GRANTS FOR 'app_login'@'%';
SHOW GRANTS FOR 'app_admin'@'%';
SHOW GRANTS FOR 'app_vendedor'@'%';