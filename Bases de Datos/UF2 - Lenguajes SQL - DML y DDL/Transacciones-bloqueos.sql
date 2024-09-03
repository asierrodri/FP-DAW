drop database if exists transacciones;
CREATE DATABASE if not exists transacciones; 
use transacciones;

CREATE TABLE personas (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30) NOT NULL,
  mail VARCHAR(30) NOT NULL
);
-- añadir datos a personas
INSERT INTO personas VALUES(1,'Pedro Martinez', 'pmartinez@gmail.com');
INSERT INTO personas VALUES(2,'Isabel Luque','iluque@gmail.com');
INSERT INTO personas VALUES(3,'Susana Iglesias','siglesias@gmail.com');

-- 1.	Inicia una transacción añade a la tabla personas tus datos y después realizas un rollback ¿Qué ha sucedido?

START TRANSACTION;
INSERT INTO personas VALUES(0, 'Asier Rodriguez', 'asier.rodriguez18@gmail.com');
ROLLBACK;
SELECT * FROM PERSONAS;

-- 2.	Inicia una transacción añade a la tabla personas un registro y después realizas un commit. ¿Qué ha sucedido en este caso?

START TRANSACTION;
INSERT INTO personas VALUES(0, 'Asier Rodriguez', 'asier.rodriguez18@gmail.com');
COMMIT;
SELECT * FROM PERSONAS;

-- 3.	Inicia una transacción, modifica el nombre de la primera persona por el tuyo. Define un paso de control llamado PASO1. Borra todos los registros exceptuando el primero. Haz un ROLLBACK al PASO1, y luego realiza un COMMIT. Comprueba y comenta que ha sucedido.

START TRANSACTION;
UPDATE personas
SET nombre = 'Asier'
WHERE codigo = 1;
SAVEPOINT PASO1;
DELETE FROM personas
WHERE codigo <> 1;

-- 4.	Explica la diferencia entre bloquear para escritura y lectura. Bloquea la tabla personas primero para escritura y luego para lectura. Intenta modificar alguna fila de datos. Comprobar y comentar los resultados.

LOCK TABLE personas WRITE;
UPDATE personas
SET nombre = 'Jose'
WHERE codigo = 1;
UNLOCK TABLES;
COMMIT;

LOCK TABLE personas READ;
UPDATE personas
SET nombre = 'Jose'
WHERE codigo = 1;
UNLOCK TABLES;
COMMIT;
