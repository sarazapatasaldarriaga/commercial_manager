-- SUPPLIERS
INSERT INTO supplier (name, phone, address, date) VALUES
('Tech Solutions S.A.', '3001234567', 'Calle 12 #45-67', CURRENT_DATE),
('Innovatech Ltda.', '3002345678', 'Carrera 7 #22-10', CURRENT_DATE),
('Global IT Services', '3003456789', 'Av. Las Américas 120', CURRENT_DATE),
('Data Systems Corp.', '3004567890', 'Calle 50 #15-40', CURRENT_DATE),
('NextGen Technologies', '3005678901', 'Diagonal 8 #33-22', CURRENT_DATE),
('Cybernetics Co.', '3006789012', 'Cra 25 #10-50', CURRENT_DATE),
('Smart Solutions', '3007890123', 'Av. 100 #12-15', CURRENT_DATE),
('Digital Innovators', '3008901234', 'Calle 80 #5-10', CURRENT_DATE),
('Cloudware Inc.', '3009012345', 'Cra 90 #22-30', CURRENT_DATE),
('TechnoWare Ltd.', '3009123456', 'Av. Principal #45-55', CURRENT_DATE),
('Alpha Networks', '3009234567', 'Calle 7 #20-20', CURRENT_DATE),
('Beta Soft', '3009345678', 'Carrera 8 #10-12', CURRENT_DATE),
('Quantum Solutions', '3009456789', 'Av. Central 75', CURRENT_DATE),
('NexTech Corp.', '3009567890', 'Diagonal 17 #40-50', CURRENT_DATE),
('Matrix Systems', '3009678901', 'Calle 10 #30-45', CURRENT_DATE),
('ByteWorks', '3009789012', 'Cra 40 #10-22', CURRENT_DATE),
('Innovative Labs', '3009890123', 'Av. Innovación 25', CURRENT_DATE),
('DataCore', '3009901234', 'Calle 15 #18-20', CURRENT_DATE),
('Tech Hub', '3009912345', 'Carrera 5 #5-10', CURRENT_DATE),
('Pixel Technologies', '3009923456', 'Diagonal 12 #22-33', CURRENT_DATE),
('Cloud Nine Solutions', '3009934567', 'Av. 90 #44-55', CURRENT_DATE),
('SoftWorks', '3009945678', 'Calle 25 #15-40', CURRENT_DATE),
('CyberDynamics', '3009956789', 'Cra 33 #12-15', CURRENT_DATE),
('NextWave Technologies', '3009967890', 'Av. 77 #10-10', CURRENT_DATE);



-- PRODUCTS
INSERT INTO product (name, price, stock, supplier_id) VALUES
('Producto A', 12000.0, 100, 1),
('Producto B', 8500.0, 150, 2),
('Producto C', 9900.0, 200, 3),
('Producto D', 15000.0, 7, 4),
('Producto E', 2500.0, 300, 5),
('Producto F', 1200.0, 500, 6),
('Producto G', 30000.0, 60, 7),
('Producto H', 5000.0, 1, 8),
('Producto I', 7999.90, 90, 9),
('Producto J', 20000.0, 40, 10);

-- CLIENTS
INSERT INTO client (name, email, phone) VALUES
('Juan Pérez', 'juan@example.com', '3001230001'),
('Ana Gómez', 'ana@example.com', '3001230002'),
('Luis Torres', 'luis@example.com', '3001230003'),
('Marta Ruiz', 'marta@example.com', '3001230004'),
('Carlos Díaz', 'carlos@example.com', '3001230005'),
('Laura López', 'laura@example.com', '3001230006'),
('Pedro Castro', 'pedro@example.com', '3001230007'),
('Sofía Ríos', 'sofia@example.com', '3001230008'),
('Diego Mora', 'diego@example.com', '3001230009'),
('Lucía Vega', 'lucia@example.com', '3001230010');

-- SALES
INSERT INTO sale (date, client_id) VALUES
(CURRENT_TIMESTAMP, 1),
(CURRENT_TIMESTAMP, 2),
(CURRENT_TIMESTAMP, 3),
(CURRENT_TIMESTAMP, 4),
(CURRENT_TIMESTAMP, 5),
(CURRENT_TIMESTAMP, 6),
(CURRENT_TIMESTAMP, 7),
(CURRENT_TIMESTAMP, 8),
(CURRENT_TIMESTAMP, 9),
(CURRENT_TIMESTAMP, 10);

-- SALE ITEMS
INSERT INTO sale_item (sale_id, product_id, quantity, price) VALUES
(1, 1, 2, 24000.0),
(1, 2, 1, 8500.5),
(2, 3, 3, 29700.0),
(3, 4, 1, 15000.0),
(4, 5, 5, 12500.0),
(5, 6, 10, 12000.0),
(6, 7, 1, 30000.0),
(7, 8, 4, 20000.0),
(8, 9, 2, 15999.8),
(9, 10, 1, 20000.0);
