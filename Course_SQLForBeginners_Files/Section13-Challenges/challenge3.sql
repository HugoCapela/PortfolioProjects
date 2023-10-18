USE cinema_booking_system;

-- How many bookings did the film 'Jigsaw' have in October 2017
SELECT * FROM bookings;
SELECT * FROM screenings;

SELECT COUNT(*) FROM bookings b
JOIN screenings s ON b.screening_id = s.id
JOIN films f ON s.film_id = f.id
WHERE f.name = 'Jigsaw';

-- Course solution
SELECT COUNT(*) AS no_bookings FROM bookings
WHERE screening_id IN
(SELECT id FROM screenings
WHERE film_id = 5);

-- Other solution
SELECT count(b.id) AS total_bookings
FROM bookings b, screenings s, films f
WHERE b.screening_id = s.id
AND s.film_id = f.id
AND f.name = 'Jigsaw';