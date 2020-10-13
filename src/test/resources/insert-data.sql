INSERT INTO client (id, cnh, cpf, date_of_birth, email, last_name, name)
	VALUES
	(200, 74059739713, '13998601783', now(),
	'manuel.silva@hotmail.com', 'Silva', 'Manuel');

INSERT INTO address (id, city, complement, neighborhood, state, street, zipcode, client_id)
	VALUES
	(200, 'rio de janeiro', 'teste', 'bras de pina',
	'rio de janeiro', 'rua a', '21012-409', 200);