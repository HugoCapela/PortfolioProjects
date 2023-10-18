USE cinema_booking_system;

SELECT * FROM films;

SELECT MAX(length_min) FROM films;

SELECT name, MAX(length_min) FROM films;
/* doesn't work
returns 12 values (from the select name) or 1 value (from the max function) ???
this is done with the group by function. see later example
*/

SELECT MIN(length_min) FROM films;