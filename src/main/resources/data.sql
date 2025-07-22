-- Script SQL para poblar la base de datos del proyecto Integrador
-- Se ejecuta automáticamente al iniciar Spring Boot
-- Basado en las entidades reales: Product, Order, OrderLine

-- ==========================================
-- INSERTAR PRODUCTOS DE EJEMPLO
-- ==========================================

-- Productos con solo los campos que existen en tu entidad Product
INSERT INTO product (name, price, stock) VALUES ('iPhone 15 Pro', 1299.99, 25);
INSERT INTO product (name, price, stock) VALUES ('Samsung Galaxy S24', 999.99, 30);
INSERT INTO product (name, price, stock) VALUES ('MacBook Air M3', 1499.99, 15);
INSERT INTO product (name, price, stock) VALUES ('Dell XPS 13', 1199.99, 20);
INSERT INTO product (name, price, stock) VALUES ('iPad Pro 12.9', 1099.99, 18);
INSERT INTO product (name, price, stock) VALUES ('Smart TV LG 55 4K', 699.99, 12);
INSERT INTO product (name, price, stock) VALUES ('Cafetera Nespresso', 199.99, 35);
INSERT INTO product (name, price, stock) VALUES ('Aspiradora Dyson V15', 449.99, 8);
INSERT INTO product (name, price, stock) VALUES ('Air Fryer Philips', 129.99, 22);
INSERT INTO product (name, price, stock) VALUES ('Nike Air Max 270', 149.99, 45);
INSERT INTO product (name, price, stock) VALUES ('Adidas Ultraboost 22', 179.99, 38);
INSERT INTO product (name, price, stock) VALUES ('Levis 501 Jeans', 89.99, 60);
INSERT INTO product (name, price, stock) VALUES ('Camiseta Nike', 29.99, 80);
INSERT INTO product (name, price, stock) VALUES ('PlayStation 5', 499.99, 10);
INSERT INTO product (name, price, stock) VALUES ('Xbox Series X', 499.99, 12);
INSERT INTO product (name, price, stock) VALUES ('Nintendo Switch OLED', 349.99, 25);
INSERT INTO product (name, price, stock) VALUES ('Gaming Chair DXRacer', 299.99, 15);
INSERT INTO product (name, price, stock) VALUES ('Mouse Gaming Logitech', 79.99, 50);
INSERT INTO product (name, price, stock) VALUES ('Teclado Mecanico', 159.99, 30);
INSERT INTO product (name, price, stock) VALUES ('Monitor 4K Samsung', 399.99, 18);

-- ==========================================
-- INSERTAR ÓRDENES DE EJEMPLO  
-- ==========================================

-- Órdenes simples (solo ID, sin campos adicionales)
INSERT INTO orders (id) VALUES (1);
INSERT INTO orders (id) VALUES (2);
INSERT INTO orders (id) VALUES (3);
INSERT INTO orders (id) VALUES (4);

-- ==========================================
-- INSERTAR LÍNEAS DE ORDEN
-- ==========================================

-- Orden 1: Setup Apple
INSERT INTO order_line (product_id, order_id, quantity) VALUES (1, 1, 1);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (3, 1, 1);

-- Orden 2: Gaming setup completo  
INSERT INTO order_line (product_id, order_id, quantity) VALUES (14, 2, 1);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (17, 2, 1);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (18, 2, 1);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (19, 2, 1);

-- Orden 3: Oficina en casa
INSERT INTO order_line (product_id, order_id, quantity) VALUES (4, 3, 1);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (20, 3, 1);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (7, 3, 1);

-- Orden 4: Compra de ropa y accesorios
INSERT INTO order_line (product_id, order_id, quantity) VALUES (10, 4, 2);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (11, 4, 1);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (12, 4, 3);
INSERT INTO order_line (product_id, order_id, quantity) VALUES (13, 4, 5);
