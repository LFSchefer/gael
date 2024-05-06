DROP TABLE IF EXISTS person_allergie;
DROP TABLE IF EXISTS person_medication;
DROP TABLE IF EXISTS medicalrecords;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS firestations;
DROP TABLE IF EXISTS medications;
DROP TABLE IF EXISTS allergies;

CREATE TABLE persons (
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	address varchar NOT NULL,
	city varchar NOT NULL,
	zip varchar NOT NULL,
	phone varchar NOT NULL,
	email varchar NOT NULL,
	CONSTRAINT persons_pkey PRIMARY KEY (firstname,lastname)
);

CREATE TABLE firestations (
	address varchar NOT NULL,
	station varchar NOT NULL,
	CONSTRAINT firestation_pkey PRIMARY KEY (address) 
);

CREATE TABLE medicalrecords  (
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	birthdate varchar NOT NULL,
	CONSTRAINT medicalrecords_pkey PRIMARY KEY (firstname,lastname)
);

CREATE TABLE medications (
	medication_name varchar PRIMARY KEY
);

CREATE TABLE allergies (
	allergies_name varchar PRIMARY KEY
);

CREATE TABLE person_medication (
	id serial PRIMARY KEY,
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	medication_name varchar NOT NULL,
	CONSTRAINT name_mediacalrecord_fkey FOREIGN KEY (firstname, lastname) REFERENCES medicalrecords(firstname,lastname),
	CONSTRAINT medication_fkey FOREIGN KEY (medication_name) REFERENCES  medications(medication_name)
);

CREATE TABLE person_allergie (
	id serial PRIMARY KEY,
	firstname varchar NOT NULL,
	lastname varchar NOT NULL,
	allergie_name varchar NOT NULL,
	CONSTRAINT name_allergie_fkey FOREIGN KEY (firstname, lastname) REFERENCES medicalrecords(firstname,lastname),
	CONSTRAINT allergies_fkey FOREIGN KEY (allergie_name) REFERENCES  allergies(allergies_name)
);