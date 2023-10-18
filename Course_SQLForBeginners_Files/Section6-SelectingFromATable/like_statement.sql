USE coffee_store;

/*

%   any number of characters
_   just one character

*/

-- In Strings
SELECT * FROM customers
WHERE last_name LIKE 'W%';

SELECT * FROM customers
WHERE last_name LIKE '%o%';

SELECT * FROM customers
WHERE first_name LIKE '_o_';

-- In int
SELECT * FROM products
WHERE price LIKE '3%';
