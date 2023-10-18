USE coffee_store;

SELECT * FROM products;

-- HOW TO UPDATE DATA ON A TABLE

UPDATE <table_name>
SET <column_name> = 'value1'
WHERE <column-name> = 'value2';

UPDATE products
SET coffee_origin = 'Sri Lanka'
WHERE id = 7;

SET SQL_SAFE_UPDATES=0;

UPDATE products
SET price = 3.25, coffee_origin = 'Ethiopia'
WHERE name = 'Americano';

UPDATE products
SET coffee_origin = 'Colombia'
WHERE coffee_origin = 'Brazil';