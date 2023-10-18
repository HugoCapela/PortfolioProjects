USE cinema_booking_system;

-- 1. Concatenate the film names and length from the films table
SELECT CONCAT(name, ": ", length_min) AS film_info FROM films;

-- 2. Extract the customers email from the 5th character onwards
SELECT SUBSTRING(email, 5) AS email_short FROM customers;

-- 3. Select the customers first name in lower case and their  last name in upper case
-- for each customer with a last name of 'Smith'
SELECT LOWER(first_name) AS first_name, UPPER(last_name) AS last_name FROM customers
WHERE last_name = 'Smith';

-- 4. Select the last 3 letters of each film name from the films table
SELECT SUBSTRING(name, -3) AS last_letters FROM films;

-- 5. Concatenate the first three letters in the first_name and last_name columns
-- together from the customers table
SELECT CONCAT( SUBSTRING(first_name,1,3)," ",SUBSTRING(last_name,1,3) ) AS short_name FROM customers;
