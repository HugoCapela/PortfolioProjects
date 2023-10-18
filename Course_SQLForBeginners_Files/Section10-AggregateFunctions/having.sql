USE cinema_booking_system;

SELECT * FROM bookings;

SELECT customer_id, screening_id, COUNT(id) FROM bookings
GROUP BY customer_id, screening_id
WHERE customer_id = 10;
/* when grouping by data
	instead of WHERE we need to use HAVING
*/

SELECT customer_id, screening_id, COUNT(id) FROM bookings
GROUP BY customer_id, screening_id
HAVING customer_id = 10;