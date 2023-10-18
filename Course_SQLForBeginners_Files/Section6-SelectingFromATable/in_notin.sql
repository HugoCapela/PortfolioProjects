USE coffee_store;

-- When we want more than one value, we use IN or NOT IN

SELECT * FROM customers
WHERE last_name IN ('Taylor', 'Bluth', 'Armstrong');


SELECT * FROM customers
WHERE first_name NOT IN ('Katie', 'George', 'John');
