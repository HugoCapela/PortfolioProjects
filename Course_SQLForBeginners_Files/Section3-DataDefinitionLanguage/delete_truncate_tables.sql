
CREATE DATABASE example;

USE example;

CREATE TABLE test (

	id INT auto_increment primary key,
    name VARCHAR(30),
    age INT
);

SELECT * FROM test;
SHOW TABLES;

-- HOW TO DELETE TABLES FROM A DATABASE
-- deletes the entire table from database
DROP TABLE test;

-- HOW TO TRUNCATE TABLES FROM A DATABASE
-- eliminates all data from the table
-- what truncate does is:
-- drop the table from the database and
-- immediately create a new table with the same name and columns as before
-- with 0 data in it
TRUNCATE TABLE test;