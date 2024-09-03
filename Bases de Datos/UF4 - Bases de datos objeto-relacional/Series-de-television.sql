/*Se quiere diseñar una Base de Datos Objeto Relacional para almacenar las series de televisión con sus respectivos episodios.
Crearemos un tablespace con el nombre BDyvuestronombre de 100MB. De cada episodio, queremos guardar la temporada, el número de episodio y el nombre. Y de las series queremos almacenar un código que las identifica, el título, el país y el género de la serie.

Implementaremos el problema de dos formas diferentes.
•	Utilizando nested tables.
•	Utilizando ref y deref manteniendo la integridad referencial.

En ambos casos debemos:
1.	Creación de todos los tipos y tablas asociadas.
2.	Inserción de datos en todas las tablas.
3.	Consultar los episodios de una determinada serie.
4.	Consultar el primer episodio de la primera temporada de cada serie.
*/

---------------- REF Y DEREF ----------------

SET SERVEROUTPUT ON;

-- 1. Creación de tipos y tablas --
CREATE TABLESPACE BDasier DATAFILE 'BDasier.dbf' SIZE 100M;

CREATE OR REPLACE TYPE TipoSerie AS OBJECT (
    codigo number,
    titulo varchar2(100),
    pais varchar2(50),
    genero varchar2(50)
);

CREATE OR REPLACE TYPE TipoEpisodio AS OBJECT (
    temporada number,
    numero number,
    nombre varchar2(100),
    series REF TipoSerie
);

CREATE TABLE Series OF TipoSerie (
codigo primary key
);

CREATE TABLE Episodios OF TipoEpisodio;


-- 2. Inserción de datos --
INSERT INTO Series VALUES (1, 'La casa de papel', 'España', 'Accion');
INSERT INTO Series VALUES (2, 'Breaking Bad', 'USA', 'Drama');

INSERT INTO Episodios VALUES (1, 1, 'El final del camino', (SELECT REF(s) FROM Series s WHERE s.codigo = 1));
INSERT INTO Episodios VALUES (1, 2, 'El espectaculo de la vida', (SELECT REF(s) FROM Series s WHERE s.codigo = 1));
INSERT INTO Episodios VALUES (2, 1, 'El principio', (SELECT REF(s) FROM Series s WHERE s.codigo = 1));
INSERT INTO Episodios VALUES (2, 2, 'El horror', (SELECT REF(s) FROM Series s WHERE s.codigo = 1));
INSERT INTO Episodios VALUES (1, 1, 'El gato esta en la bolsa...', (SELECT REF(s) FROM Series s WHERE s.codigo = 2));
INSERT INTO Episodios VALUES (1, 2, '...y la bolsa esta en el rio', (SELECT REF(s) FROM Series s WHERE s.codigo = 2));
INSERT INTO Episodios VALUES (2, 1, 'El perro', (SELECT REF(s) FROM Series s WHERE s.codigo = 2));
INSERT INTO Episodios VALUES (2, 2, 'El gato', (SELECT REF(s) FROM Series s WHERE s.codigo = 2));

-- 3.	Consultar los episodios de una determinada serie. --
SELECT temporada, numero, nombre, DEREF(series).codigo FROM Episodios WHERE DEREF(series).codigo = 2;

-- 4.	Consultar el primer episodio de la primera temporada de cada serie. --
SELECT temporada, numero, nombre, DEREF(series).codigo FROM Episodios WHERE temporada = 1 AND numero = 1;


---------------- NESTED TABLE ----------------
SET SERVEROUTPUT ON;

-- 1. Creación de tipos y tablas --
CREATE TABLESPACE BDasier DATAFILE 'BDasier.dbf' SIZE 100M;

CREATE OR REPLACE TYPE TipoEpisodio AS OBJECT (
    temporada number,
    numero number,
    nombre varchar2(100)
);
CREATE OR REPLACE TYPE TipoEpisodioLista AS TABLE OF TipoEpisodio;

CREATE TABLE TipoSerie (
    codigo number primary key,
    titulo varchar2(100),
    pais varchar2(50),
    genero varchar2(50),
    episodios TipoEpisodioLista
) NESTED TABLE episodios STORE AS TablaEpisodios;

-- 2. Inserción de datos --
INSERT INTO TipoSerie VALUES (1, 'La casa de papel', 'España', 'Accion', TipoEpisodioLista(
    TipoEpisodio(1, 1, 'El final del camino'),
    TipoEpisodio(1, 2, 'El espectaculo de la vida'),
    TipoEpisodio(2, 1, 'El principio'),
    TipoEpisodio(2, 2, 'El horror')));
INSERT INTO TipoSerie VALUES (2, 'Breaking Bad', 'USA', 'Drama', TipoEpisodioLista(
    TipoEpisodio(1, 1, 'El gato esta en la bolsa...'),
    TipoEpisodio(1, 2, '...y la bolsa esta en el rio'),
    TipoEpisodio(2, 1, 'El perro'),
    TipoEpisodio(2, 2, 'El gato')));

-- 3.	Consultar los episodios de una determinada serie. --
SELECT codigo, titulo, e.* FROM TipoSerie, TABLE(episodios) e WHERE codigo = 2;

-- 4.	Consultar el primer episodio de la primera temporada de cada serie. --
SELECT codigo, titulo, e.* FROM TipoSerie, TABLE(episodios) e WHERE temporada = 1 AND numero = 1;