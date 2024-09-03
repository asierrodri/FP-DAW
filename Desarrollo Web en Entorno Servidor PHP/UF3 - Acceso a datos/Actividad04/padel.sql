create database if not exists padel;
use padel;
create table if not exists usuario (
  id_usuario int auto_increment primary key,
  nombre varchar(255),
  pass varchar(255),
  tipo int CHECK (tipo IN (0, 1))
);

insert into usuario values (0, "admin", "adminpass", 0);

create table if not exists pista (
  id_pista int auto_increment primary key,
  nombre varchar(255)
);

create table if not exists reserva (
  id_reserva int auto_increment primary key,
  usuario int,
  pista int,
  turno int check (turno in (0, 1, 2)),
  foreign key (usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE,
  foreign key (pista) REFERENCES pista(id_pista) ON DELETE CASCADE
);