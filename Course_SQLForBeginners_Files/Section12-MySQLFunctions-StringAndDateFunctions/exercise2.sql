USE cinema_booking_system;

-- 1. Select the film id and start time from the screenings table for the
-- date of 20th of October 2017
SELECT film_id, start_time FROM screenings
WHERE DATE(start_time) = '2017-10-20';

-- 2. Select all the data from the screenings table for the
-- start time between the 6th and 13th of October 2017
SELECT * FROM screenings
WHERE DATE(start_time) BETWEEN '2017-10-06' AND '2017-10-13';

-- 3. Select all the data from the screenings table for October 2017
SELECT * FROM screenings
WHERE YEAR(start_time) = '2017'
AND MONTH(start_time) = '10';