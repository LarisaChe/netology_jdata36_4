-- changeset lache:1
CREATE TABLE jdata36.user (
		id SERIAL PRIMARY KEY,
		name VARCHAR(32) NOT NULL,
		surname VARCHAR(32) NOT NULL,
		phone_number VARCHAR(15),
		city VARCHAR(150)
);
-- rollback drop table jdata36.user;

-- changeset lache:2
ALTER TABLE jdata36.user DROP COLUMN city;
-- rollback

-- changeset lache:3
CREATE TABLE jdata36.product (
		id SERIAL PRIMARY KEY,
		name VARCHAR(100) NOT NULL,
		amount numeric CHECK (amount > 0)
);
-- rollback drop table jdata36.product;
