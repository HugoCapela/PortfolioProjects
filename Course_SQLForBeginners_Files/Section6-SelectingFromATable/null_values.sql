USE coffee_store;

SELECT * FROM customers
WHERE phone_number IS NULL;

SELECT * FROM customers
WHERE phone_number IS NOT NULL;