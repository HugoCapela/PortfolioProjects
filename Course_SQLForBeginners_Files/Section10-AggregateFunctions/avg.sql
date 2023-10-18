USE cinema_booking_system;

SELECT * FROM films;

SELECT AVG(length_min) FROM films;

SELECT AVG(length_min) FROM films
WHERE length_min > 120;