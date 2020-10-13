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

CREATE TABLE IF NOT EXISTS address (
    id int8 NOT NULL,
    city varchar(255) NULL,
    complement varchar(255) NULL,
    neighborhood varchar(255) NULL,
    state varchar(255) NULL,
    street varchar(255) NULL,
    zipcode varchar(255) NULL,
    client_id int8 NULL,
    CONSTRAINT address_pkey PRIMARY KEY (id),
    CONSTRAINT fk7156ty2o5atyuy9f6kuup9dna FOREIGN KEY (client_id) REFERENCES client(id)
);
