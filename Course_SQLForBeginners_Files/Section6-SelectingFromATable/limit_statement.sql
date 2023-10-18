USE coffee_store;

SELECT * FROM customers
LIMIT 5;

SELECT * FROM customers
LIMIT 5 OFFSET 5;

SELECT * FROM customers
LIMIT 10 OFFSET 5;

SELECT * FROM customers
ORDER BY last_name
LIMIT 10;