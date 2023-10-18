USE cinema_booking_system;

SELECT id, start_time FROM screenings
WHERE film_id IN
	(SELECT id FROM films
	WHERE length_min > 120)
;

SELECT id FROM films
WHERE length_min > 120;

SELECT * FROM customers;
SELECT * FROM bookings;

SELECT first_name, last_name, email FROM customers
WHERE id IN
	(SELECT customer_id FROM bookings
    WHERE screening_id = 1)
;

SELECT customer_id FROM bookings
WHERE screening_id = 1;