CREATE TABLE person (
	name VARCHAR(32) NOT NULL,
	surname VARCHAR(32) NOT NULL,
	age SMALLINT NOT NULL CHECK (age >= 0),
	phone_number VARCHAR(15),
	city_of_living VARCHAR(100),
	PRIMARY KEY (name, surname, age)
);