USE cinema_booking_system;

SELECT * FROM reserved_seat;

SELECT booking_id, COUNT(seat_id) FROM reserved_seat
GROUP BY booking_id;

SELECT MAX(no_seats) FROM 
(SELECT booking_id, COUNT(seat_id) AS no_seats FROM reserved_seat
GROUP BY booking_id) b;
-- The "b" is the name given to the derived table. It can be whatever
-- This (look down) is called a derived table 
SELECT booking_id, COUNT(seat_id) AS no_seats FROM reserved_seat
GROUP BY booking_id;

SELECT AVG(no_seats), MAX(no_seats) FROM 
(SELECT booking_id, COUNT(seat_id) AS no_seats FROM reserved_seat
GROUP BY booking_id) b;