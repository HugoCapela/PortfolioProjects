USE coffee_store;

-- For numbers
SELECT * FROM products
ORDER BY price ASC;

SELECT * FROM products
ORDER BY price DESC;

SELECT * FROM products
ORDER BY price;

-- For strings
SELECT * FROM customers
ORDER BY last_name ASC;

SELECT * FROM customers
ORDER BY last_name DESC;

SELECT * FROM customers
ORDER BY last_name;

SELECT * FROM orders
WHERE customer_id = 1
ORDER BY order_time ASC;

SELECT * FROM orders
WHERE customer_id = 1
ORDER BY order_time DESC;

SELECT * FROM orders
WHERE customer_id = 1
ORDER BY order_time;