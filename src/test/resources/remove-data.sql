delete from address;
delete from client;

ALTER SEQUENCE seq_id_address RESTART WITH 1;
ALTER SEQUENCE seq_id_client RESTART WITH 1;