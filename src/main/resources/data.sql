-- Script SQL para poblar la base de datos del proyecto Integrador
-- Solo se ejecuta si la tabla product está vacía
-- Basado en las entidades reales: Product, Order, OrderLine

-- Verificar si la base de datos ya tiene datos, si los tiene, no insertar nada
-- En MySQL puedes usar una variable para verificar

-- ==========================================
-- INSERTAR PRODUCTOS DE EJEMPLO (solo si no existen)
-- ==========================================

-- Productos con solo los campos que existen en tu entidad Product
INSERT IGNORE INTO product (name, price, stock) VALUES ('iPhone 15 Pro', 1299.99, 25);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Samsung Galaxy S24', 999.99, 30);
INSERT IGNORE INTO product (name, price, stock) VALUES ('MacBook Air M3', 1499.99, 15);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Dell XPS 13', 1199.99, 20);
INSERT IGNORE INTO product (name, price, stock) VALUES ('iPad Pro 12.9', 1099.99, 18);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Smart TV LG 55 4K', 699.99, 12);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Cafetera Nespresso', 199.99, 35);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Aspiradora Dyson V15', 449.99, 8);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Air Fryer Philips', 129.99, 22);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Nike Air Max 270', 149.99, 45);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Adidas Ultraboost 22', 179.99, 38);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Levis 501 Jeans', 89.99, 60);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Camiseta Nike', 29.99, 80);
INSERT IGNORE INTO product (name, price, stock) VALUES ('PlayStation 5', 499.99, 10);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Xbox Series X', 499.99, 12);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Nintendo Switch OLED', 349.99, 25);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Gaming Chair DXRacer', 299.99, 15);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Mouse Gaming Logitech', 79.99, 50);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Teclado Mecanico', 159.99, 30);
INSERT IGNORE INTO product (name, price, stock) VALUES ('Monitor 4K Samsung', 399.99, 18);

-- ==========================================
-- INSERTAR ÓRDENES DE EJEMPLO (solo si no existen)
-- ==========================================

-- Órdenes simples (solo ID, sin campos adicionales)
INSERT IGNORE INTO orders (id) VALUES (1);
INSERT IGNORE INTO orders (id) VALUES (2);
INSERT IGNORE INTO orders (id) VALUES (3);
INSERT IGNORE INTO orders (id) VALUES (4);

-- ==========================================
-- INSERTAR LÍNEAS DE ORDEN (solo si no existen)
-- ==========================================

-- Orden 1: Setup Apple
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (1, 1, 1);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (3, 1, 1);

-- Orden 2: Gaming setup completo  
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (14, 2, 1);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (17, 2, 1);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (18, 2, 1);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (19, 2, 1);

-- Orden 3: Oficina en casa
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (4, 3, 1);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (20, 3, 1);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (7, 3, 1);

-- Orden 4: Compra de ropa y accesorios
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (10, 4, 2);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (11, 4, 1);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (12, 4, 3);
INSERT IGNORE INTO order_line (product_id, order_id, quantity) VALUES (13, 4, 5);
