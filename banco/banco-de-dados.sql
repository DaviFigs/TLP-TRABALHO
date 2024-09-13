CREATE TABLE Medico (
	id SERIAL PRIMARY KEY NOT NULL,
	nome varchar(50) NOT NULL,
	num_crm int NOT NULL,
	especialidade varchar(20) NOT NULL
);
	
CREATE TABLE Paciente (
	id SERIAL PRIMARY KEY NOT NULL,
	nome varchar(50) NOT NULL,
	cod_sus int NOT NULL,
	cpf varchar(14) NOT NULL
);
	
CREATE TABLE Centro_Cirurgico (
	id SERIAL PRIMARY KEY NOT NULL
);

CREATE TABLE Reserva (
	id SERIAL PRIMARY KEY,
	data_hora timestamp NOT NULL,
	id_centrocirurgico int REFERENCES Centro_Cirurgico(id) NOT NULL
);

CREATE TABLE Cirurgia(
	id SERIAL PRIMARY KEY,
	id_paciente int REFERENCES Paciente(id) NOT NULL,
	id_medico int REFERENCES Medico(id) NOT NULL,
	id_reserva int REFERENCES Reserva(id) NOT NULL
);


insert into medico values(default, 'jane', 123, 'neurologista');
insert into medico values(default, 'isa', 123, 'obstetra');
insert into medico values(default, 'lopes', 123, 'pediatra');

insert into paciente values(default, 'gutemberg', 111, '111.123.123.12');
insert into paciente values(default, 'davi', 222, '123.222.123.12');
insert into paciente values(default, 'chaparro', 333, '333.123.123.12');

insert into centro_cirurgico values(default);
insert into centro_cirurgico values(default);
insert into centro_cirurgico values(default);

insert into reserva values(default, '2024-09-10 12:30:00', 1);
insert into reserva values(default, '2024-09-10 08:30:00', 2);
insert into reserva values(default, '2024-09-10 11:30:00', 3);

insert into reserva values(default, '2024-09-22 17:30:00', 1);
insert into reserva values(default, '2024-09-22 11:30:00', 2);
insert into reserva values(default, '2024-09-22 14:30:00', 3);

insert into cirurgia values(default, 1,1,1);
insert into cirurgia values(default, 2,2,2);
insert into cirurgia values(default, 3,3,3);

insert into cirurgia values(default, 1,1,4);
insert into cirurgia values(default, 2,2,5);
insert into cirurgia values(default, 3,3,6);
