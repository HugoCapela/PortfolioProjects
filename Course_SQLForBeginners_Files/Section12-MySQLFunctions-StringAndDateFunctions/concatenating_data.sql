USE cinema_booking_system;

-- CONCATENATE

-- SELECT CONCAT(column1, column2) AS new_column_name FROM table;

SELECT CONCAT(first_name, last_name) AS full_name FROM customers;
-- concatenation has no space between the 2 names

SELECT CONCAT(first_name, " ", last_name) AS full_name FROM customers;
-- concatenation now has a space between the 2 names
-- this is concatenating 3 strings

SELECT CONCAT(first_name, " ", last_name, " ", email) AS full_name FROM customers;
-- this is actually concatenating 5 strings = 3 columns and 2 'spaces'

SELECT CONCAT("This is ", first_name, " ", last_name, "'s email: ", email) AS customers_email FROM customers;