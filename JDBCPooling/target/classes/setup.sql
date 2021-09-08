CREATE TABLE heros (
	hero_id SERIAL PRIMARY KEY,
	hero_name VARCHAR(50)
);

INSERT INTO heros(hero_name)
	VALUES ('Ant-Man'),
			('The Falcon');