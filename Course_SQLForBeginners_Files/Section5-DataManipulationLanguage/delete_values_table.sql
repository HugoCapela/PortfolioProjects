USE example;

CREATE TABLE people (

	id INT auto_increment primary key,
    name varchar(30),
    age INT,
    gender ENUM('M','F')
);

SELECT * FROM people;

insert into people (name, age, gender)
values ('Emma',21,'F'),
('John',30,'M'),
('Thomas',27,'M'),
('Chris',44,'M'),
('Sally',23,'F'),
('Frank',55,'M');

-- DELETE FROM TABLE WHERE name(column_name) IS EQUAL TO 'John'(value);
DELETE FROM people
WHERE name = 'John';

-- DELETE every 'F'(value) from gender(column_name)
DELETE FROM people
WHERE gender = 'F';

-- DELETE EVERY DATA FROM A TABLE
DELETE FROM people;