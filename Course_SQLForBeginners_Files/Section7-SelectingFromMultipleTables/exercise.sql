USE coffee_store;

-- 1. Select the order id and customers phone number for all orders of product id 4
SELECT o.id, c.phone_number FROM orders o
JOIN customers c ON o.customer_id = c.id
WHERE o.product_id = 4;

-- 2. Select product name and order time for filter coffees sold
-- between January 15th 2017 and February 14th 2017
SELECT p.name, o.order_time FROM products p
JOIN orders o ON p.id = o.product_id
WHERE p.name = 'Filter'
AND o.order_time BETWEEN '2017-01-15' AND '2017-02-14';

-- 3. Select the product name and price and order time for all orders from females in January 2017
SELECT p.name, p.price, o.order_time FROM products p
JOIN orders o ON p.id = o.product_id
JOIN customers c ON o.customer_id = c.id
WHERE c.gender = 'F'
AND o.order_time BETWEEN '2017-01-01' AND '2017-01-31';