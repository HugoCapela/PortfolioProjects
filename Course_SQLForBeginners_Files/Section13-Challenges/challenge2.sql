USE cinema_booking_system;

-- Which film had the most screenings in October 2017
/*
SELECT MAX(t.num_screen) FROM (
SELECT f.name, COUNT(s.id) AS num_screen FROM screenings s
JOIN films f ON s.film_id = f.id
GROUP BY f.name) t;
*/

SELECT f.name, COUNT(s.film_id) AS showings FROM screenings s
JOIN films f ON f.id = s.film_id
GROUP BY film_id
ORDER BY showings DESC
LIMIT 1;