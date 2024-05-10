DELETE FROM person_allergie;
DELETE FROM person_medication;
DELETE FROM firestations ;
DELETE FROM persons;
DELETE FROM medicalrecords ;
DELETE FROM medications ;
DELETE FROM allergies ;

INSERT INTO firestations (address, station) VALUES
( '1509 Culver St', '3' ),
( '29 15th St','2' ),
( '834 Binoc Ave', '3' ),
( '644 Gershwin Cir', '1' ),
( '748 Townings Dr', '3' ),
( '112 Steppes Pl', '3' ),
( '489 Manchester St', '4' ),
( '892 Downing Ct', '2' ),
( '908 73rd St', '1' ),
( '115 Steppes Pl', '4' ),
( '947 E. Rose Dr', '1' ),
( '742 Townings Dr', '3' ),
( '951 LoneTree Rd', '2' );

SELECT * FROM firestations f ;

INSERT INTO persons (firstname, lastname, address, city, zip, phone, email) VALUES
( 'John', 'Boyd', '1509 Culver St', 'Culver', '97451', '841-874-6512', 'jaboyd@email.com' ),
( 'Jacob', 'Boyd', '1509 Culver St', 'Culver', '97451', '841-874-6513', 'drk@email.com' ),
( 'Tenley', 'Boyd', '1509 Culver St', 'Culver', '97451', '841-874-6512', 'tenz@email.com' ),
( 'Roger', 'Boyd', '1509 Culver St', 'Culver', '97451', '841-874-6512', 'jaboyd@email.com' ),
( 'Felicia', 'Boyd', '1509 Culver St', 'Culver', '97451', '841-874-6544', 'jaboyd@email.com' ),
( 'Jonanathan', 'Marrack', '29 15th St', 'Culver', '97451', '841-874-6513', 'drk@email.com' ),
( 'Tessa', 'Carman', '834 Binoc Ave', 'Culver', '97451', '841-874-6512', 'tenz@email.com' ),
( 'Peter', 'Duncan', '644 Gershwin Cir', 'Culver', '97451', '841-874-6512', 'jaboyd@email.com' ),
( 'Foster', 'Shepard', '748 Townings Dr', 'Culver', '97451', '841-874-6544', 'jaboyd@email.com' ),
( 'Tony', 'Cooper', '112 Steppes Pl', 'Culver', '97451', '841-874-6874', 'tcoop@ymail.com' ),
( 'Lily', 'Cooper', '489 Manchester St', 'Culver', '97451', '841-874-9845', 'lily@email.com' ),
( 'Sophia', 'Zemicks', '892 Downing Ct', 'Culver', '97451', '841-874-7878', 'soph@email.com' ),
( 'Warren', 'Zemicks', '892 Downing Ct', 'Culver', '97451', '841-874-7512', 'ward@email.com' ),
( 'Zach', 'Zemicks', '892 Downing Ct', 'Culver', '97451', '841-874-7512', 'zarc@email.com' ),
( 'Reginold', 'Walker', '908 73rd St', 'Culver', '97451', '841-874-8547', 'reg@email.com' ),
( 'Jamie', 'Peters', '908 73rd St', 'Culver', '97451', '841-874-7462', 'jpeter@email.com' ),
( 'Ron', 'Peters', '112 Steppes Pl', 'Culver', '97451', '841-874-8888', 'jpeter@email.com' ),
( 'Allison', 'Boyd', '112 Steppes Pl', 'Culver', '97451', '841-874-9888', 'aly@imail.com' ),
( 'Brian', 'Stelzer', '947 E. Rose Dr', 'Culver', '97451', '841-874-7784', 'bstel@email.com' ),
( 'Shawna', 'Stelzer', '947 E. Rose Dr', 'Culver', '97451', '841-874-7784', 'ssanw@email.com' ),
( 'Kendrik', 'Stelzer', '947 E. Rose Dr', 'Culver', '97451', '841-874-7784', 'bstel@email.com' ),
( 'Clive', 'Ferguson', '748 Townings Dr', 'Culver', '97451', '841-874-6741', 'clivfd@ymail.com' ),
( 'Eric', 'Cadigan', '951 LoneTree Rd', 'Culver', '97451', '841-874-7458', 'gramps@email.com' );

SELECT * FROM persons p ;

INSERT INTO medicalrecords (firstname,lastname,birthdate) VALUES
( 'John', 'Boyd', '03/06/1984' ),
( 'Jacob', 'Boyd', '03/06/1989' ),
( 'Tenley', 'Boyd', '02/18/2012'),
( 'Roger', 'Boyd', '09/06/2017'),
( 'Felicia', 'Boyd','01/08/1986'),
( 'Jonanathan', 'Marrack', '01/03/1989' ),
( 'Tessa', 'Carman', '02/18/2012'),
( 'Peter', 'Duncan', '09/06/2000'),
( 'Foster', 'Shepard', '01/08/1980'),
( 'Tony', 'Cooper', '03/06/1994'),
( 'Lily', 'Cooper', '03/06/1994'),
( 'Sophia', 'Zemicks', '03/06/1988' ),
( 'Warren', 'Zemicks', '03/06/1985'),
( 'Zach', 'Zemicks', '03/06/2017' ),
( 'Reginold', 'Walker', '08/30/1979' ),
( 'Jamie', 'Peters', '03/06/1982' ),
( 'Ron', 'Peters', '04/06/1965' ),
( 'Allison', 'Boyd', '03/15/1965' ),
( 'Brian', 'Stelzer', '12/06/1975'),
( 'Shawna', 'Stelzer', '07/08/1980'),
( 'Kendrik', 'Stelzer', '03/06/2014' ),
( 'Clive', 'Ferguson', '03/06/1994' ),
( 'Eric', 'Cadigan', '08/06/1945' );

SELECT * FROM medicalrecords m ;

INSERT INTO medications (medication_name) VALUES
('aznol:350mg'),
('hydrapermazol:100mg'),
('pharmacol:5000mg'),
('terazine:10mg'),
('noznazol:250mg'),
('tetracyclaz:650mg'),
('hydrapermazol:300mg'),
('dodoxadin:30mg'),
('aznol:60mg'),
('hydrapermazol:900mg'),
('terazine:500mg'),
('thradox:700mg'),
('aznol:200mg'),
('ibupurin:200mg'),
('hydrapermazol:400mg'),
('noxidian:100mg'),
('pharmacol:2500mg'),
('tradoxidine:400mg');

SELECT * FROM medications m ;

INSERT INTO allergies (allergies_name) VALUES
('nillacilan'),
('peanut'),
('xilliathal'),
('shellfish'),
('aznol'),
('illisoxian');

SELECT * FROM allergies a ;

INSERT INTO person_medication (firstname, lastname, medication_name) VALUES
('John','Boyd','aznol:350mg'),
('John','Boyd','hydrapermazol:100mg'),
('Jacob','Boyd','pharmacol:5000mg'),
('Jacob','Boyd','terazine:10mg'),
('Jacob','Boyd','noznazol:250mg'),
('Felicia','Boyd', 'tetracyclaz:650mg'),
('Tony','Cooper','hydrapermazol:300mg'),
('Tony','Cooper','dodoxadin:30mg'),
('Sophia','Zemicks','aznol:60mg'),
('Sophia','Zemicks','hydrapermazol:900mg'),
('Sophia','Zemicks','pharmacol:5000mg'),
('Sophia','Zemicks','terazine:500mg'),
('Reginold','Walker','thradox:700mg'),
('Allison','Boyd','aznol:200mg'),
('Brian','Stelzer','ibupurin:200mg'),
('Brian','Stelzer','hydrapermazol:400mg'),
('Kendrik','Stelzer','noxidian:100mg'),
('Kendrik','Stelzer','pharmacol:2500mg'),
('Eric','Cadigan','tradoxidine:400mg');

SELECT * FROM person_medication pm ;

INSERT INTO person_allergie (firstname, lastname, allergie_name) VALUES
('John','Boyd','nillacilan'),
('Tenley','Boyd','peanut'),
('Felicia','Boyd','xilliathal'),
('Peter','Duncan','shellfish'),
('Tony','Cooper','shellfish'),
('Sophia','Zemicks','peanut'),
('Sophia','Zemicks','shellfish'),
('Sophia','Zemicks','aznol'),
('Reginold','Walker','illisoxian'),
('Allison','Boyd','nillacilan'),
('Brian','Stelzer','nillacilan');

SELECT * FROM person_allergie;
