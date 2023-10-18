USE cinema_booking_system;

SELECT * FROM customers;

SELECT COUNT(*) FROM customers;
SELECT COUNT(last_name) FROM customers;
SELECT COUNT(first_name) FROM customers;

SELECT COUNT(*) FROM customers
WHERE last_name = 'Smith';

SELECT COUNT(*) FROM customers
WHERE first_name IS NULL;