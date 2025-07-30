-- Proveedores
INSERT INTO supplier (id, name, phone, address, date) VALUES
(1, 'Proveedor A', '3000000001', 'Calle 10 #1-10', CURRENT_DATE),
(2, 'Proveedor B', '3000000002', 'Calle 20 #2-20', CURRENT_DATE),
(3, 'Proveedor C', '3000000003', 'Calle 30 #3-30', CURRENT_DATE),
(4, 'Proveedor D', '3000000004', 'Calle 40 #4-40', CURRENT_DATE),
(5, 'Proveedor E', '3000000005', 'Calle 50 #5-50', CURRENT_DATE),
(6, 'Proveedor F', '3000000006', 'Calle 60 #6-60', CURRENT_DATE),
(7, 'Proveedor G', '3000000007', 'Calle 70 #7-70', CURRENT_DATE),
(8, 'Proveedor H', '3000000008', 'Calle 80 #8-80', CURRENT_DATE),
(9, 'Proveedor I', '3000000009', 'Calle 90 #9-90', CURRENT_DATE),
(10, 'Proveedor J', '3000000010', 'Calle 100 #10-100', CURRENT_DATE);

-- Productos
INSERT INTO product (id, name, price, stock, supplier_id) VALUES
(1, 'Laptop Dell', 1200.00, 10, 1),
(2, 'Monitor Samsung', 450.50, 15, 2),
(3, 'Mouse Logitech', 25.00, 50, 3),
(4, 'Teclado Redragon', 40.99, 30, 4),
(5, 'Memoria USB 32GB', 10.00, 100, 5),
(6, 'Disco SSD 1TB', 99.90, 20, 6),
(7, 'Procesador Ryzen 7', 300.00, 12, 7),
(8, 'Tarjeta madre ASUS', 150.00, 8, 8),
(9, 'Cámara Web HD', 35.75, 25, 9),
(10, 'Silla Gamer', 199.99, 5, 10);

-- Clientes
INSERT INTO client (id, name, email, phone) VALUES
(1, 'Ana Torres', 'ana@example.com', '3100000001'),
(2, 'Luis Pérez', 'luis@example.com', '3100000002'),
(3, 'Marta Gómez', 'marta@example.com', '3100000003'),
(4, 'Carlos Ruiz', 'carlos@example.com', '3100000004'),
(5, 'Elena Ríos', 'elena@example.com', '3100000005'),
(6, 'Jorge Díaz', 'jorge@example.com', '3100000006'),
(7, 'Lucía Márquez', 'lucia@example.com', '3100000007'),
(8, 'Pedro Hernández', 'pedro@example.com', '3100000008'),
(9, 'Isabel Moreno', 'isabel@example.com', '3100000009'),
(10, 'Raúl Castro', 'raul@example.com', '3100000010');
