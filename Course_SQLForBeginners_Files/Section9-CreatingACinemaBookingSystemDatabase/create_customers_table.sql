USE cinema_booking_system;

CREATE TABLE customers (

	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45),
    last_name VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE
);

SHOW TABLES;

DESCRIBE customers;