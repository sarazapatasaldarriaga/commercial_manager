-- SUPPLIERS
INSERT INTO supplier (id, name, phone, address, date) VALUES
(1, 'Proveedor Alfa', '3001234567', 'Calle 1 #10-10', CURRENT_DATE),
(2, 'Proveedor Beta', '3002345678', 'Carrera 5 #22-33', CURRENT_DATE),
(3, 'Proveedor Gamma', '3003456789', 'Av. Siempre Viva 742', CURRENT_DATE),
(4, 'Proveedor Delta', '3004567890', 'Calle 45 #10-20', CURRENT_DATE),
(5, 'Proveedor Épsilon', '3005678901', 'Transversal 12 #3-45', CURRENT_DATE),
(6, 'Proveedor Zeta', '3006789012', 'Diagonal 7 #23-10', CURRENT_DATE),
(7, 'Proveedor Eta', '3007890123', 'Av. Las Palmas 123', CURRENT_DATE),
(8, 'Proveedor Theta', '3008901234', 'Cra 50 #10-50', CURRENT_DATE),
(9, 'Proveedor Iota', '3009012345', 'Calle 60 #45-23', CURRENT_DATE),
(10, 'Proveedor Kappa', '3009123456', 'Cra 90 #11-22', CURRENT_DATE);

-- PRODUCTS
INSERT INTO product (id, name, price, stock, supplier_id) VALUES
(1, 'Producto A', 12000.0, 100, 1),
(2, 'Producto B', 8500.5, 150, 2),
(3, 'Producto C', 9900.0, 200, 3),
(4, 'Producto D', 15000.0, 75, 4),
(5, 'Producto E', 2500.0, 300, 5),
(6, 'Producto F', 1200.0, 500, 6),
(7, 'Producto G', 30000.0, 60, 7),
(8, 'Producto H', 5000.0, 110, 8),
(9, 'Producto I', 7999.9, 90, 9),
(10, 'Producto J', 20000.0, 40, 10);

-- CLIENTS
INSERT INTO client (id, name, email, phone) VALUES
(1, 'Juan Pérez', 'juan@example.com', '3001230001'),
(2, 'Ana Gómez', 'ana@example.com', '3001230002'),
(3, 'Luis Torres', 'luis@example.com', '3001230003'),
(4, 'Marta Ruiz', 'marta@example.com', '3001230004'),
(5, 'Carlos Díaz', 'carlos@example.com', '3001230005'),
(6, 'Laura López', 'laura@example.com', '3001230006'),
(7, 'Pedro Castro', 'pedro@example.com', '3001230007'),
(8, 'Sofía Ríos', 'sofia@example.com', '3001230008'),
(9, 'Diego Mora', 'diego@example.com', '3001230009'),
(10, 'Lucía Vega', 'lucia@example.com', '3001230010');

-- SALES
INSERT INTO sale (id, date, client_id) VALUES
(1, CURRENT_TIMESTAMP, 1),
(2, CURRENT_TIMESTAMP, 2),
(3, CURRENT_TIMESTAMP, 3),
(4, CURRENT_TIMESTAMP, 4),
(5, CURRENT_TIMESTAMP, 5),
(6, CURRENT_TIMESTAMP, 6),
(7, CURRENT_TIMESTAMP, 7),
(8, CURRENT_TIMESTAMP, 8),
(9, CURRENT_TIMESTAMP, 9),
(10, CURRENT_TIMESTAMP, 10);

-- SALE ITEMS
INSERT INTO sale_item (id, sale_id, product_id, quantity, price) VALUES
(1, 1, 1, 2, 24000.0),
(2, 1, 2, 1, 8500.5),
(3, 2, 3, 3, 29700.0),
(4, 3, 4, 1, 15000.0),
(5, 4, 5, 5, 12500.0),
(6, 5, 6, 10, 12000.0),
(7, 6, 7, 1, 30000.0),
(8, 7, 8, 4, 20000.0),
(9, 8, 9, 2, 15999.8),
(10, 9, 10, 1, 20000.0);
