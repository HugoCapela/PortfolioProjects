USE cinema_booking_system;

CREATE TABLE bookings (

	id INT AUTO_INCREMENT PRIMARY KEY,
    screening_id INT NOT NULL,
    customer_id INT NOT NULL,
    FOREIGN KEY (screening_id) REFERENCES screenings(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

SHOW TABLES;

DESCRIBE bookings;