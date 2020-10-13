CREATE TABLE IF NOT EXISTS client (
	id int8 NOT NULL,
	cnh varchar(255) NULL,
	cpf varchar(255) NULL,
	date_of_birth timestamp NULL,
	email varchar(255) NULL,
	last_name varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT client_pkey PRIMARY KEY (id)
);
