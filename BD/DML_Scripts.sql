USE MiscelaneaBellavista;

INSERT INTO categorias (nombre, descripcion) VALUES
('Bebidas', 'Gaseosas, jugos, aguas y bebidas en general'),
('Snacks y Pasabocas', 'Papas, chitos, snacks salados y dulces'),
('Abarrotes', 'Arroz, aceite, granos, enlatados y básicos de despensa'),
('Aseo Personal', 'Jabones, shampoo, cepillos y cuidado personal'),
('Aseo del Hogar', 'Detergentes, limpiadores y productos de limpieza'),
('Dulces y Chocolates', 'Chocolatinas, caramelos, bombones y golosinas'),
('Lácteos', 'Leche, yogurt, quesos y derivados'),
('Panadería', 'Pan, ponqués y productos de panadería'),
('Papelería', 'Cuadernos, esferos y útiles escolares/oficina'),
('Cigarrillos y Licores', 'Cigarrillos, cervezas y licores');

INSERT INTO proveedores (ruc, nombre, vendedor, telefono, direccion, razon_social) VALUES
(900111222, 'Postobón S.A.', 'Carlos Ramírez', '3101234567', 'Cra 45 #12-30, Manizales', 'Postobón Sociedad Anónima'),
(900222333, 'Bavaria S.A.', 'Diana López', '3112345678', 'Av. Industrial #20-15, Manizales', 'Bavaria Sociedad Anónima'),
(900333444, 'Nutresa Alimentos', 'Jorge Salazar', '3123456789', 'Cll 30 #8-45, Pereira', 'Grupo Nutresa S.A.'),
(900444555, 'Alpina Productos Alimenticios', 'Marcela Gómez', '3134567890', 'Zona Franca, Manizales', 'Alpina Productos Alimenticios S.A.'),
(900555666, 'Distribuidora La Económica', 'Andrés Zapata', '3145678901', 'Cra 23 #45-10, Manizales', 'La Económica S.A.S.'),
(900666777, 'Colgate-Palmolive Distribución', 'Paula Restrepo', '3156789012', 'Cll 15 #22-08, Pereira', 'Colgate-Palmolive Colombia S.A.'),
(900777888, 'Familia Sancela', 'Luis Herrera', '3167890123', 'Cra 10 #33-20, Manizales', 'Productos Familia Sancela S.A.'),
(900888999, 'Distribuciones El Mayorista', 'Sandra Ortiz', '3178901234', 'Cll 8 #40-12, Manizales', 'El Mayorista Distribuciones S.A.S.');

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('BEB001','Coca-Cola 400ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Postobón S.A.'), 120, 1600.00, 1900.00, DATE_SUB(NOW(), INTERVAL 500 DAY)),
('BEB002','Coca-Cola 1.5L', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Postobón S.A.'), 80, 3800.00, 4500.00, DATE_SUB(NOW(), INTERVAL 500 DAY)),
('BEB003','Postobón Manzana 400ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Postobón S.A.'), 100, 1500.00, 1800.00, DATE_SUB(NOW(), INTERVAL 480 DAY)),
('BEB004','Agua Cristal 600ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Postobón S.A.'), 150, 1200.00, 1500.00, DATE_SUB(NOW(), INTERVAL 470 DAY)),
('BEB005','Jugo Hit Naranja 300ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Postobón S.A.'), 90, 1700.00, 2000.00, DATE_SUB(NOW(), INTERVAL 450 DAY)),
('BEB006','Gatorade 500ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 60, 3200.00, 3800.00, DATE_SUB(NOW(), INTERVAL 430 DAY)),
('BEB007','Té Hatsu 400ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Postobón S.A.'), 70, 2200.00, 2600.00, DATE_SUB(NOW(), INTERVAL 410 DAY)),
('BEB008','Café Sello Rojo 250g', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 45, 7500.00, 8900.00, DATE_SUB(NOW(), INTERVAL 400 DAY)),
('BEB009','Milo Bebida 200ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 65, 2000.00, 2400.00, DATE_SUB(NOW(), INTERVAL 390 DAY)),
('BEB010','Cerveza Poker 330ml', (SELECT id FROM categorias WHERE nombre='Bebidas'), (SELECT id FROM proveedores WHERE nombre='Bavaria S.A.'), 200, 2100.00, 2500.00, DATE_SUB(NOW(), INTERVAL 380 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('SNK001','Papas Margarita 35g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 100, 1600.00, 1900.00, DATE_SUB(NOW(), INTERVAL 460 DAY)),
('SNK002','Doritos Nacho 55g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 90, 2300.00, 2700.00, DATE_SUB(NOW(), INTERVAL 440 DAY)),
('SNK003','Chitos 40g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 110, 1400.00, 1700.00, DATE_SUB(NOW(), INTERVAL 420 DAY)),
('SNK004','Platanitos Nacional 30g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 85, 1500.00, 1800.00, DATE_SUB(NOW(), INTERVAL 400 DAY)),
('SNK005','Maní Moto 40g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 70, 1300.00, 1600.00, DATE_SUB(NOW(), INTERVAL 380 DAY)),
('SNK006','Detodito 30g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 95, 1400.00, 1700.00, DATE_SUB(NOW(), INTERVAL 360 DAY)),
('SNK007','Tostacos 45g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 60, 1800.00, 2100.00, DATE_SUB(NOW(), INTERVAL 340 DAY)),
('SNK008','Chicharrones Nacional 35g', (SELECT id FROM categorias WHERE nombre='Snacks y Pasabocas'), (SELECT id FROM proveedores WHERE nombre='Distribuidora La Económica'), 55, 1500.00, 1800.00, DATE_SUB(NOW(), INTERVAL 320 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('ABA001','Arroz Diana 500g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 150, 2400.00, 2800.00, DATE_SUB(NOW(), INTERVAL 500 DAY)),
('ABA002','Aceite Gourmet 500ml', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 80, 6500.00, 7600.00, DATE_SUB(NOW(), INTERVAL 480 DAY)),
('ABA003','Azúcar Manuelita 1kg', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 100, 3200.00, 3800.00, DATE_SUB(NOW(), INTERVAL 460 DAY)),
('ABA004','Sal Refisal 500g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 90, 1200.00, 1500.00, DATE_SUB(NOW(), INTERVAL 440 DAY)),
('ABA005','Lentejas Diana 500g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 70, 3600.00, 4200.00, DATE_SUB(NOW(), INTERVAL 420 DAY)),
('ABA006','Fríjol Diana 500g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 65, 3800.00, 4500.00, DATE_SUB(NOW(), INTERVAL 400 DAY)),
('ABA007','Atún Van Camps 160g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 85, 5200.00, 6100.00, DATE_SUB(NOW(), INTERVAL 380 DAY)),
('ABA008','Sardinas Van Camps 425g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 60, 6800.00, 8000.00, DATE_SUB(NOW(), INTERVAL 360 DAY)),
('ABA009','Pasta La Muñeca 250g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 100, 1900.00, 2300.00, DATE_SUB(NOW(), INTERVAL 340 DAY)),
('ABA010','Chocolate Corona 500g', (SELECT id FROM categorias WHERE nombre='Abarrotes'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 55, 8500.00, 10000.00, DATE_SUB(NOW(), INTERVAL 320 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('ASP001','Jabón Rey 300g', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 90, 2600.00, 3100.00, DATE_SUB(NOW(), INTERVAL 470 DAY)),
('ASP002','Shampoo Head&Shoulders 200ml', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 45, 9500.00, 11200.00, DATE_SUB(NOW(), INTERVAL 450 DAY)),
('ASP003','Crema Dental Colgate 75ml', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 100, 3800.00, 4500.00, DATE_SUB(NOW(), INTERVAL 430 DAY)),
('ASP004','Cepillo Dental Colgate', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 120, 2200.00, 2600.00, DATE_SUB(NOW(), INTERVAL 410 DAY)),
('ASP005','Desodorante Rexona 50ml', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 60, 6800.00, 8000.00, DATE_SUB(NOW(), INTERVAL 390 DAY)),
('ASP006','Jabón Protex 90g', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 100, 2000.00, 2400.00, DATE_SUB(NOW(), INTERVAL 370 DAY)),
('ASP007','Toallas Higiénicas Nosotras x10', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Familia Sancela'), 70, 4200.00, 5000.00, DATE_SUB(NOW(), INTERVAL 350 DAY)),
('ASP008','Papel Higiénico Familia x4', (SELECT id FROM categorias WHERE nombre='Aseo Personal'), (SELECT id FROM proveedores WHERE nombre='Familia Sancela'), 130, 5200.00, 6100.00, DATE_SUB(NOW(), INTERVAL 330 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('ASH001','Fabuloso 500ml', (SELECT id FROM categorias WHERE nombre='Aseo del Hogar'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 80, 4200.00, 5000.00, DATE_SUB(NOW(), INTERVAL 460 DAY)),
('ASH002','Detergente Ariel 500g', (SELECT id FROM categorias WHERE nombre='Aseo del Hogar'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 70, 6500.00, 7600.00, DATE_SUB(NOW(), INTERVAL 440 DAY)),
('ASH003','Jabón Rey Multiusos 1kg', (SELECT id FROM categorias WHERE nombre='Aseo del Hogar'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 60, 6800.00, 8000.00, DATE_SUB(NOW(), INTERVAL 420 DAY)),
('ASH004','Límpido Blanqueador 500ml', (SELECT id FROM categorias WHERE nombre='Aseo del Hogar'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 65, 3200.00, 3800.00, DATE_SUB(NOW(), INTERVAL 400 DAY)),
('ASH005','Esponjilla Brillo x3', (SELECT id FROM categorias WHERE nombre='Aseo del Hogar'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 100, 2400.00, 2800.00, DATE_SUB(NOW(), INTERVAL 380 DAY)),
('ASH006','Bolsas de Basura x10', (SELECT id FROM categorias WHERE nombre='Aseo del Hogar'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 120, 3500.00, 4100.00, DATE_SUB(NOW(), INTERVAL 360 DAY)),
('ASH007','Ambientador Glade Spray', (SELECT id FROM categorias WHERE nombre='Aseo del Hogar'), (SELECT id FROM proveedores WHERE nombre='Colgate-Palmolive Distribución'), 45, 8900.00, 10500.00, DATE_SUB(NOW(), INTERVAL 340 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('DUL001','Chocolatina Jet', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 200, 1200.00, 1500.00, DATE_SUB(NOW(), INTERVAL 490 DAY)),
('DUL002','Bon Bon Bum', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 300, 400.00, 500.00, DATE_SUB(NOW(), INTERVAL 470 DAY)),
('DUL003','Chocolatina Corona', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 180, 1300.00, 1600.00, DATE_SUB(NOW(), INTERVAL 450 DAY)),
('DUL004','Bocadillo Veleño x6', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 100, 2200.00, 2600.00, DATE_SUB(NOW(), INTERVAL 430 DAY)),
('DUL005','Trululu Fresa', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 250, 500.00, 600.00, DATE_SUB(NOW(), INTERVAL 410 DAY)),
('DUL006','Mentos Menta', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 150, 2000.00, 2400.00, DATE_SUB(NOW(), INTERVAL 390 DAY)),
('DUL007','Chicle Trident', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 220, 1800.00, 2100.00, DATE_SUB(NOW(), INTERVAL 370 DAY)),
('DUL008','Galletas Festival', (SELECT id FROM categorias WHERE nombre='Dulces y Chocolates'), (SELECT id FROM proveedores WHERE nombre='Nutresa Alimentos'), 130, 1600.00, 1900.00, DATE_SUB(NOW(), INTERVAL 350 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('LAC001','Leche Alpina 1L', (SELECT id FROM categorias WHERE nombre='Lácteos'), (SELECT id FROM proveedores WHERE nombre='Alpina Productos Alimenticios'), 90, 3800.00, 4500.00, DATE_SUB(NOW(), INTERVAL 460 DAY)),
('LAC002','Yogurt Alpina 200g', (SELECT id FROM categorias WHERE nombre='Lácteos'), (SELECT id FROM proveedores WHERE nombre='Alpina Productos Alimenticios'), 100, 2200.00, 2600.00, DATE_SUB(NOW(), INTERVAL 440 DAY)),
('LAC003','Queso Campesino Alpina 250g', (SELECT id FROM categorias WHERE nombre='Lácteos'), (SELECT id FROM proveedores WHERE nombre='Alpina Productos Alimenticios'), 55, 7500.00, 8900.00, DATE_SUB(NOW(), INTERVAL 420 DAY)),
('LAC004','Avena Alpina 200ml', (SELECT id FROM categorias WHERE nombre='Lácteos'), (SELECT id FROM proveedores WHERE nombre='Alpina Productos Alimenticios'), 80, 2000.00, 2400.00, DATE_SUB(NOW(), INTERVAL 400 DAY)),
('LAC005','Kumis Alpina 1L', (SELECT id FROM categorias WHERE nombre='Lácteos'), (SELECT id FROM proveedores WHERE nombre='Alpina Productos Alimenticios'), 65, 5200.00, 6100.00, DATE_SUB(NOW(), INTERVAL 380 DAY)),
('LAC006','Arequipe Alpina 250g', (SELECT id FROM categorias WHERE nombre='Lácteos'), (SELECT id FROM proveedores WHERE nombre='Alpina Productos Alimenticios'), 50, 4500.00, 5300.00, DATE_SUB(NOW(), INTERVAL 360 DAY)),
('LAC007','Mantequilla Alpina 250g', (SELECT id FROM categorias WHERE nombre='Lácteos'), (SELECT id FROM proveedores WHERE nombre='Alpina Productos Alimenticios'), 45, 6200.00, 7300.00, DATE_SUB(NOW(), INTERVAL 340 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('PAN001','Pan Tajado Bimbo', (SELECT id FROM categorias WHERE nombre='Panadería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 60, 5500.00, 6500.00, DATE_SUB(NOW(), INTERVAL 430 DAY)),
('PAN002','Pan Perro Caliente x4', (SELECT id FROM categorias WHERE nombre='Panadería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 55, 3200.00, 3800.00, DATE_SUB(NOW(), INTERVAL 410 DAY)),
('PAN003','Ponqué Ramo Gala', (SELECT id FROM categorias WHERE nombre='Panadería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 40, 3800.00, 4500.00, DATE_SUB(NOW(), INTERVAL 390 DAY)),
('PAN004','Galletas Ramo Chocolate', (SELECT id FROM categorias WHERE nombre='Panadería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 90, 1300.00, 1600.00, DATE_SUB(NOW(), INTERVAL 370 DAY)),
('PAN005','Arepa Blanca x5', (SELECT id FROM categorias WHERE nombre='Panadería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 70, 4200.00, 5000.00, DATE_SUB(NOW(), INTERVAL 350 DAY)),
('PAN006','Tostadas Bimbo', (SELECT id FROM categorias WHERE nombre='Panadería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 50, 4800.00, 5700.00, DATE_SUB(NOW(), INTERVAL 330 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('PAP001','Cuaderno Norma 100h', (SELECT id FROM categorias WHERE nombre='Papelería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 80, 4200.00, 5000.00, DATE_SUB(NOW(), INTERVAL 400 DAY)),
('PAP002','Esfero Kilométrico Azul', (SELECT id FROM categorias WHERE nombre='Papelería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 150, 900.00, 1100.00, DATE_SUB(NOW(), INTERVAL 380 DAY)),
('PAP003','Lápiz Mirado #2', (SELECT id FROM categorias WHERE nombre='Papelería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 200, 600.00, 800.00, DATE_SUB(NOW(), INTERVAL 360 DAY)),
('PAP004','Borrador Nata', (SELECT id FROM categorias WHERE nombre='Papelería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 130, 500.00, 700.00, DATE_SUB(NOW(), INTERVAL 340 DAY)),
('PAP005','Colbón Escolar 250g', (SELECT id FROM categorias WHERE nombre='Papelería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 60, 3200.00, 3800.00, DATE_SUB(NOW(), INTERVAL 320 DAY)),
('PAP006','Marcador Sharpie Negro', (SELECT id FROM categorias WHERE nombre='Papelería'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 70, 2800.00, 3300.00, DATE_SUB(NOW(), INTERVAL 300 DAY));

INSERT INTO productos (codigo, nombre, categoria_id, proveedor_id, stock, precio_neto, precio_bruto, fecha) VALUES
('CYL001','Cerveza Águila 330ml', (SELECT id FROM categorias WHERE nombre='Cigarrillos y Licores'), (SELECT id FROM proveedores WHERE nombre='Bavaria S.A.'), 220, 2000.00, 2400.00, DATE_SUB(NOW(), INTERVAL 470 DAY)),
('CYL002','Cerveza Club Colombia 330ml', (SELECT id FROM categorias WHERE nombre='Cigarrillos y Licores'), (SELECT id FROM proveedores WHERE nombre='Bavaria S.A.'), 180, 2600.00, 3100.00, DATE_SUB(NOW(), INTERVAL 450 DAY)),
('CYL003','Aguardiente Antioqueño 375ml', (SELECT id FROM categorias WHERE nombre='Cigarrillos y Licores'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 70, 18500.00, 21800.00, DATE_SUB(NOW(), INTERVAL 430 DAY)),
('CYL004','Ron Viejo de Caldas 375ml', (SELECT id FROM categorias WHERE nombre='Cigarrillos y Licores'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 60, 19500.00, 23000.00, DATE_SUB(NOW(), INTERVAL 410 DAY)),
('CYL005','Cigarrillos Marlboro Caja', (SELECT id FROM categorias WHERE nombre='Cigarrillos y Licores'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 100, 8500.00, 10000.00, DATE_SUB(NOW(), INTERVAL 390 DAY)),
('CYL006','Cigarrillos Boston Caja', (SELECT id FROM categorias WHERE nombre='Cigarrillos y Licores'), (SELECT id FROM proveedores WHERE nombre='Distribuciones El Mayorista'), 90, 6800.00, 8000.00, DATE_SUB(NOW(), INTERVAL 370 DAY));

INSERT INTO clientes (nombre, telefono, correo, fecha) VALUES
('Juan Pérez Gómez', '3011234567', 'juan.perez@gmail.com', DATE_SUB(NOW(), INTERVAL 500 DAY)),
('María Rodríguez López', '3022345678', 'maria.rodriguez@gmail.com', DATE_SUB(NOW(), INTERVAL 480 DAY)),
('Carlos Gutiérrez Ruiz', '3033456789', 'carlos.gutierrez@gmail.com', DATE_SUB(NOW(), INTERVAL 470 DAY)),
('Ana Martínez Castro', '3044567890', 'ana.martinez@gmail.com', DATE_SUB(NOW(), INTERVAL 460 DAY)),
('Luis Fernández Ríos', '3055678901', 'luis.fernandez@gmail.com', DATE_SUB(NOW(), INTERVAL 450 DAY)),
('Diana Torres Vélez', '3066789012', 'diana.torres@gmail.com', DATE_SUB(NOW(), INTERVAL 440 DAY)),
('Jorge Ramírez Ospina', '3077890123', 'jorge.ramirez@gmail.com', DATE_SUB(NOW(), INTERVAL 430 DAY)),
('Paula Gómez Salazar', '3088901234', 'paula.gomez@gmail.com', DATE_SUB(NOW(), INTERVAL 420 DAY)),
('Andrés Zapata Muñoz', '3099012345', 'andres.zapata@gmail.com', DATE_SUB(NOW(), INTERVAL 410 DAY)),
('Sandra Ortiz Pérez', '3100123456', 'sandra.ortiz@gmail.com', DATE_SUB(NOW(), INTERVAL 400 DAY)),
('Camilo Herrera Díaz', '3111234567', 'camilo.herrera@gmail.com', DATE_SUB(NOW(), INTERVAL 390 DAY)),
('Laura Restrepo Cano', '3122345678', 'laura.restrepo@gmail.com', DATE_SUB(NOW(), INTERVAL 380 DAY)),
('Felipe Salazar Vargas', '3133456789', 'felipe.salazar@gmail.com', DATE_SUB(NOW(), INTERVAL 370 DAY)),
('Natalia Cardona Uribe', '3144567890', 'natalia.cardona@gmail.com', DATE_SUB(NOW(), INTERVAL 360 DAY)),
('Mauricio López Henao', '3155678901', 'mauricio.lopez@gmail.com', DATE_SUB(NOW(), INTERVAL 350 DAY)),
('Claudia Vélez Marín', '3166789012', 'claudia.velez@gmail.com', DATE_SUB(NOW(), INTERVAL 340 DAY)),
('Ricardo Muñoz Aguirre', '3177890123', 'ricardo.munoz@gmail.com', DATE_SUB(NOW(), INTERVAL 330 DAY)),
('Sofía Castaño Ramírez', '3188901234', 'sofia.castano@gmail.com', DATE_SUB(NOW(), INTERVAL 320 DAY)),
('Óscar Villegas Quintero', '3199012345', 'oscar.villegas@gmail.com', DATE_SUB(NOW(), INTERVAL 310 DAY)),
('Valentina Osorio Franco', '3200123456', 'valentina.osorio@gmail.com', DATE_SUB(NOW(), INTERVAL 300 DAY)),
('Julián Aguirre Bedoya', '3211234567', 'julian.aguirre@gmail.com', DATE_SUB(NOW(), INTERVAL 280 DAY)),
('Daniela Correa Zuluaga', '3222345678', 'daniela.correa@gmail.com', DATE_SUB(NOW(), INTERVAL 260 DAY)),
('Esteban Marín Loaiza', '3233456789', 'esteban.marin@gmail.com', DATE_SUB(NOW(), INTERVAL 240 DAY)),
('Isabel Franco Rendón', '3244567890', 'isabel.franco@gmail.com', DATE_SUB(NOW(), INTERVAL 220 DAY)),
('Tomás Bedoya Arango', '3255678901', 'tomas.bedoya@gmail.com', DATE_SUB(NOW(), INTERVAL 200 DAY)),
('Mariana Zuluaga Pineda', '3266789012', 'mariana.zuluaga@gmail.com', DATE_SUB(NOW(), INTERVAL 180 DAY)),
('Sebastián Rendón Trujillo', '3277890123', 'sebastian.rendon@gmail.com', DATE_SUB(NOW(), INTERVAL 150 DAY)),
('Gabriela Arango Ceballos', '3288901234', 'gabriela.arango@gmail.com', DATE_SUB(NOW(), INTERVAL 120 DAY)),
('Nicolás Pineda Gaviria', '3299012345', 'nicolas.pineda@gmail.com', DATE_SUB(NOW(), INTERVAL 90 DAY)),
('Alejandra Trujillo Escobar', '3300123456', 'alejandra.trujillo@gmail.com', DATE_SUB(NOW(), INTERVAL 60 DAY));


DROP PROCEDURE IF EXISTS sp_generar_ventas;

DELIMITER $$

CREATE PROCEDURE sp_generar_ventas(IN total_ventas INT, IN dias_atras INT)
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE j INT DEFAULT 0;
    DECLARE v_fecha DATETIME;
    DECLARE v_cliente INT UNSIGNED;
    DECLARE v_vendedor INT UNSIGNED;
    DECLARE v_venta_id INT UNSIGNED;
    DECLARE v_total DECIMAL(10,2);
    DECLARE v_lineas INT;
    DECLARE v_producto_id INT UNSIGNED;
    DECLARE v_precio DECIMAL(10,2);
    DECLARE v_cantidad INT;
    DECLARE v_mes INT;

    WHILE i < total_ventas DO
        SET v_fecha = DATE_SUB(DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * dias_atras) DAY), INTERVAL FLOOR(RAND() * 14) HOUR);
        SET v_mes = MONTH(v_fecha);

        SET v_cliente = NULL;
        IF RAND() < 0.85 THEN
            SELECT id INTO v_cliente FROM clientes ORDER BY RAND() LIMIT 1;
        END IF;

        SET v_vendedor = NULL;
        SELECT id INTO v_vendedor FROM usuarios ORDER BY RAND() LIMIT 1;

        SET v_total = 0;
        INSERT INTO ventas (cliente_id, vendedor_id, total, fecha) VALUES (v_cliente, v_vendedor, 0, v_fecha);
        SET v_venta_id = LAST_INSERT_ID();

        -- Entre 1 y 4 líneas por venta, con boost en diciembre (temporada alta)
        SET v_lineas = 1 + FLOOR(RAND() * 4);
        IF v_mes = 12 THEN
            SET v_lineas = v_lineas + FLOOR(RAND() * 3);
        END IF;

        SET j = 0;
        WHILE j < v_lineas DO
            SELECT id, precio_bruto INTO v_producto_id, v_precio FROM productos ORDER BY RAND() LIMIT 1;

            SET v_cantidad = 1 + FLOOR(RAND() * 5);
            IF v_mes = 12 THEN
                SET v_cantidad = v_cantidad + FLOOR(RAND() * 3);
            END IF;

            INSERT INTO detalle_ventas (codigo_producto, cantidad, precio, id_venta)
            VALUES (v_producto_id, v_cantidad, v_precio, v_venta_id);

            SET v_total = v_total + (v_precio * v_cantidad);
            SET j = j + 1;
        END WHILE;

        UPDATE ventas SET total = v_total WHERE id = v_venta_id;

        SET i = i + 1;
    END WHILE;
END$$

DELIMITER ;

CALL sp_generar_ventas(600, 450);

DROP PROCEDURE IF EXISTS sp_generar_ventas;

SELECT 'categorias' AS tabla, COUNT(*) AS registros FROM categorias
UNION ALL SELECT 'proveedores', COUNT(*) FROM proveedores
UNION ALL SELECT 'productos', COUNT(*) FROM productos
UNION ALL SELECT 'clientes', COUNT(*) FROM clientes
UNION ALL SELECT 'ventas', COUNT(*) FROM ventas
UNION ALL SELECT 'detalle_ventas', COUNT(*) FROM detalle_ventas;