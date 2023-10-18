USE cinema_booking_system;

SELECT YEAR('2018-06-05');
SELECT YEAR('2018-06-05 07:42:45');

SELECT start_time FROM screenings;

SELECT YEAR(start_time) FROM screenings;

SELECT * FROM screenings
WHERE YEAR(start_time) = '2017';