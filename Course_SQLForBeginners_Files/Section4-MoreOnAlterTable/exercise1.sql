USE test;

DESCRIBE addresses;
DESCRIBE people;
DESCRIBE pets;

-- 1. Add a primary key to the id fields in the pets and people tables.
ALTER TABLE addresses 
ADD PRIMARY KEY (id);

ALTER TABLE pets 
ADD PRIMARY KEY (id);

-- 2. Add a foreing key to the owner_id field in the pets table referencing the id field in the people table
ALTER TABLE pets 
ADD CONSTRAINT FK_PetsOwner
FOREIGN KEY (owner_id) REFERENCES people(id);

ALTER TABLE people 
ADD CONSTRAINT FK_PeopleAddress
FOREIGN KEY (address_id) REFERENCES addresses(id);

-- 3. Add a column named email to the people table
ALTER TABLE people ADD COLUMN email VARCHAR(20);

-- 4. Add a unique constraint to the email column in the people table
ALTER TABLE people ADD constraint u_email UNIQUE (email);

-- 5. Rename the name column in the pets table to 'first_name'
ALTER TABLE pets CHANGE `name` `first_name` VARCHAR(20);

-- 6. Change the postcode data type to CHAR(7) in the addresses table
ALTER TABLE addresses MODIFY postcode CHAR(7);