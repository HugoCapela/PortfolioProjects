USE cinema_booking_system;

-- Which film was shown in the Chaplin room most often in October 2017
SELECT * FROM rooms;
SELECT * FROM screenings;

SELECT f.name, COUNT(s.room_id) AS no_screenings FROM rooms r
JOIN screenings s ON r.id = s.room_id
JOIN films f ON s.film_id = f.id
WHERE r.name = 'Chaplin'
GROUP BY f.name
ORDER BY no_screenings DESC
LIMIT 1;

-- Course Solution
SELECT * FROM films;
SELECT * FROM rooms;
SELECT * FROM screenings;

SELECT f.name, COUNT(r.name) AS no_screenings FROM films f
JOIN screenings s ON f.id = s.film_id
JOIN rooms r ON r.id = s.room_id
WHERE r.name = 'Chaplin'
GROUP BY f.name
ORDER BY no_screenings DESC
LIMIT 1;