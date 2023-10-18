USE coffee_store;

SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM orders;

SELECT p.name, p.price, c.first_name, c.last_name, o.order_time FROM products p
JOIN orders o ON p.id = o.product_id
JOIN customers c ON c.id = o.customer_id;

SELECT p.name, p.price, c.first_name, c.last_name, o.order_time FROM products p
JOIN orders o ON p.id = o.product_id
JOIN customers c ON c.id = o.customer_id
WHERE c.last_name = 'Martin'
ORDER BY o.order_time;