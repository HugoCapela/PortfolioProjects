USE cinema_booking_system;

-- Which 5 customers made the most bookings in October 2017
SELECT * FROM bookings b, customers c
WHERE b.customer_id = c.id;

SELECT customer_id, COUNT(*) AS no_bookings FROM bookings
GROUP BY customer_id
ORDER BY no_bookings DESC
LIMIT 5;

SELECT c.first_name, c.last_name, custom.no_bookings FROM (
	SELECT customer_id, COUNT(*) AS no_bookings FROM bookings
	GROUP BY customer_id
	ORDER BY no_bookings DESC
	LIMIT 5
) custom, customers c
WHERE custom.customer_id = c.id;

-- Course Solution
SELECT c.first_name, c.last_name, COUNT(b.id) AS no_bookings FROM bookings b
JOIN customers c ON c.id = b.customer_id
GROUP BY c.first_name, c.last_name
ORDER BY no_bookings DESC
LIMIT 5;