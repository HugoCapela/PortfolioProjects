USE coffee_store;

SELECT * FROM products
WHERE price = 3.00
AND coffee_origin = 'Colombia';

SELECT * FROM products
WHERE price = 3.00
OR coffee_origin = 'Colombia';