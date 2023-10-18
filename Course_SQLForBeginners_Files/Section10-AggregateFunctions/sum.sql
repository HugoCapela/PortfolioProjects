USE cinema_booking_system;

SELECT * FROM rooms;

SELECT SUM(no_seats) FROM rooms;

SELECT SUM(*) FROM rooms;
/* doesn't work 
it has to be a numeric column */

SELECT SUM(no_seats) FROM rooms
WHERE id > 1;