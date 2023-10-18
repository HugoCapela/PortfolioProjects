USE cinema_booking_system;

CREATE TABLE seats (

	id INT AUTO_INCREMENT PRIMARY KEY,
    seat_row CHAR(1) NOT NULL,
    seat_number INT NOT NULL,
    room_id INT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

SHOW TABLES;

DESCRIBE seats;