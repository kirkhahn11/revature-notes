-- This is the script where I'm going to create the tables for my app 

-- Creating custom types
DROP TYPE IF EXISTS kirkh.user_role CASCADE; 
CREATE TYPE kirkh.user_role AS ENUM ('Admin', 'Employee', 'Customer');

-- This is just a demo our project does not to be exactly the same ;)
DROP TABLE IF EXISTS kirkh.users CASCADE;
CREATE TABLE kirkh.users(
	id SERIAL PRIMARY KEY,
	username VARCHAR(50) NOT NULL UNIQUE,
	pwd VARCHAR(50) NOT NULL,
	user_role kirkh.user_role NOT NULL
);

DROP TABLE IF EXISTS kirkh.accounts CASCADE;
CREATE TABLE kirkh.accounts (
	id SERIAL PRIMARY KEY,
	balance NUMERIC(50, 2) DEFAULT 0,
	acc_owner INTEGER NOT NULL REFERENCES kirkh.users(id),
	active BOOLEAN DEFAULT FALSE 
);

-- MUTLIPLICITY == many to many relationship
-- Bob has 2 accounts 
-- Bob's id is 5004
-- 67 (acc id... .owner id is 5004)
-- 9008 (acc id... owner id is also 5004)
DROP TABLE IF EXISTS kirkh.users_account_jt CASCADE;
CREATE TABLE kirkh.users_account_jt (
	acc_owner INTEGER NOT NULL REFERENCES kirkh.users(id),
	account INTEGER NOT NULL REFERENCES kirkh.accounts(id)
);

-- this table represents pending applications 
DROP TABLE IF EXISTS kirkh.applications CASCADE;
CREATE TABLE kirkh.applications(
	id SERIAL PRIMARY KEY,
	app_owner INTEGER NOT NULL REFERENCES kirkh.users(id)
);

INSERT INTO kirkh.users(username, pwd, "user_role")
	VALUES('Larry', 'secret', 'Employee'),
			('Mary', '1234', 'Customer')
			
INSERT INTO kirkh.accounts (balance, acc_owner) 
	VALUES (100.15, 1)
	
INSERT INTO kirkh.accounts (balance, acc_owner)
	VALUES (500, 5), (1000, 6);
	
SELECT * FROM kirkh.accounts
SELECT * FROM kirkh.users 

INSERT INTO kirkh.users_account_jt 
	VALUES (1, 1), (5, 2), (6, 3)
	
SELECT * FROM kirkh.users_account_jt 

--JOIN from the accounts table and the users_account_jt WHERE the accowner_id is the same as the userId

SELECT kirkh.accounts.id, kirkh.accounts.balance FROM kirkh.accounts
	INNER JOIN kirkh.users_account_jt 
		ON kirkh.accounts.id = kirkh.users_account_jt.account
			WHERE kirkh.users_account_jt.acc_owner = 5;