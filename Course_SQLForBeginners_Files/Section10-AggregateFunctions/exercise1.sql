USE cinema_booking_system;

-- 1. How many bookings did customer id 10 make in October 2017
SELECT COUNT(*) FROM bookings
WHERE customer_id = 10;

-- 2. Count the number of screenings for Blade Runner 2049 in October 2017
SELECT COUNT(*) FROM screenings s
JOIN films f ON s.film_id = f.id
WHERE f.name = 'Blade Runner 2049';

-- 3. Count the number of unique customers who made a booking in October 2017
SELECT COUNT(DISTINCT(customer_id)) FROM bookings;