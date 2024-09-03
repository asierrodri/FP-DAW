create database if not exists grupos_musica;
use grupos_musica;
create table if not exists genero (
  id_genero int auto_increment primary key,
  nombre varchar(100)
);

create table if not exists grupo (
  id_grupo int auto_increment primary key,
  nombre varchar(100),
  genero int,
  foreign key (genero) REFERENCES genero(id_genero) ON DELETE CASCADE
);

insert into genero values(0, 'Pop'),
insert into genero values(0, 'Rock'),
insert into genero values(0, 'Jazz'),
insert into genero values(0, 'Hip-Hop'),
insert into genero values(0, 'Reggae'),
insert into genero values(0, 'Cásica'),
insert into genero values(0, 'Electronica'),
insert into genero values(0, 'Metal'),
insert into genero values(0, 'Inide'),
insert into genero values(0, 'Punk'),
insert into genero values(0, 'Salsa'),
insert into genero values(0, 'Flamenco'),