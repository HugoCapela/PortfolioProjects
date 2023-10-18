USE coffee_store;

-- 1. From the customers table, select distinct last names and order alphabetically from A-Z
SELECT DISTINCT last_name FROM customers ORDER BY last_name;

-- 2. From the orders table, select the first 3 orders placed by customer with id 1, in February 2017
SELECT * FROM orders
WHERE customer_id = 1
AND order_time BETWEEN '2017-02-01' AND '2017-02-28'
ORDER BY order_time ASC
LIMIT 3;

-- 3. From the products table, select the name, price and coffee origin but
-- rename the price to retail_price in the results set
SELECT name, price AS retail_price, coffee_origin FROM products;