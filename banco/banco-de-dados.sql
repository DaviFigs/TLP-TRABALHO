select centro_cirurgico.id, cirurgia.id,cirurgia.id_medico, cirurgia.id_paciente, reserva.data_hora from centro_cirurgico
inner join reserva on reserva.id_centrocirurgico = centro_cirurgico.id
inner join cirurgia on cirurgia.id_reserva = reserva.id
where centro_cirurgico.id = 1;

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


insert into medico values(default, 'destefani', 123, 'neurologista');
insert into paciente values(default, 'gutemberg', 123, '123.123.123.12');
insert into centro_cirurgico values(default);
insert into reserva values(default, '2024-09-10 14:30:00', 1);
insert into cirurgia values(default, 1,1,1);

insert into medico values(default, 'jane', 1234, 'obstetra');
insert into paciente values(default, 'giovana', 1234, '124.124.124.23');
insert into centro_cirurgico values(default);
insert into reserva values(default, '2024-09-10 11:30:00', 1);
insert into cirurgia values(default, 2,2,2);

insert into reserva values(default, '2024-09-14 16:30:00', 2);
insert into cirurgia values(default, 2,1,3);

drop table medico, paciente, centrocirurgico, reserva, cirurgia;

