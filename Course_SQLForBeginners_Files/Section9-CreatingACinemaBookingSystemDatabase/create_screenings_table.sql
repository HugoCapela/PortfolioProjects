USE cinema_booking_system;

CREATE TABLE screenings (

	id INT AUTO_INCREMENT PRIMARY KEY,
    film_id INT NOT NULL,
    room_id INT NOT NULL,
    start_time DATETIME NOT NULL,
    FOREIGN KEY (film_id) REFERENCES films(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

SHOW TABLES;

DESCRIBE screenings;