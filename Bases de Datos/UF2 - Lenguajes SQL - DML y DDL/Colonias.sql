-- By Asier Rodriguez Murua
/*MODELO RELACIONAL
CLIENTE(IdCliente, Nombre, personacontacto, tipo, NIF, mail, telefono)
CASA(IdCasa, Nombre, Direccion, Telefono, Categoria)
HABITACION(NumHabitacion, Baño, Precio, Tipo)
ACTIVIDAD(IdActividad, Nombre, Nivel, Descripcion)
RESERVA(Cod_cliente, Cod_casa, f_reserva, f_entrada, f_salida, regimen)
HORARIO_ACTIVIDAD(cod_casa, cod_actividad, Dia)
*/

-- Creamos la base de datos
CREATE DATABASE COLONIAS;
USE COLONIAS;

-- Creamos las tablas
CREATE TABLE CLIENTE(
IdCliente INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
nombre VARCHAR(50),
personacontacto VARCHAR(100),
NIF VARCHAR(15),
mail VARCHAR(50),
telefono VARCHAR(15),
tipo VARCHAR(15) DEFAULT 'escuela' CHECK (tipo IN ('escuela', 'particular'))
);

CREATE TABLE CASA(
IdCasa INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
nombre VARCHAR(50),
direccion VARCHAR(200),
telefono VARCHAR(15),
categoria CHAR(1) CHECK (categoria IN ('A', 'B', 'C', 'D', 'E'))
);

CREATE TABLE HABITACION(
NumHabitacion INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
baño CHAR(1) CHECK (baño IN ('S', 'N')),
precio DECIMAL(10, 2) CHECK (precio > 0),
tipo CHAR(1) DEFAULT 'D' CHECK (tipo IN ('I', 'D', 'T', 'C')),
casa INT,
CONSTRAINT fk_habitacion_casa FOREIGN KEY (casa) REFERENCES CASA(IdCasa)
);

CREATE TABLE ACTIVIDAD(
IdActividad INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
nombre VARCHAR(25),
descripcion TEXT,
nivel INT CHECK (nivel IN(1,2,3,4,5))
);

CREATE TABLE RESERVA(
cod_cliente INT,
cod_casa INT,
f_reserva DATE,
f_entrada DATE,
f_salida DATE CHECK (f_salida > f_entrada),
regimen CHAR(2) DEFAULT 'PC' CHECK (regimen IN ('SA', 'AD', 'MP', 'PC')),
CONSTRAINT pk_reserva PRIMARY KEY (cod_casa, cod_cliente),
CONSTRAINT fk_reserva_cliente FOREIGN KEY (cod_cliente) REFERENCES CLIENTE(IdCliente),
CONSTRAINT fk_reserva_casa FOREIGN KEY (cod_casa) REFERENCES CASA(IdCasa));

CREATE TABLE HORARIO_ACTIVIDAD(
cod_casa INT,
cod_actividad INT,
dia VARCHAR(15) CHECK (dia IN ('Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo')),
CONSTRAINT pk_horario_actividad PRIMARY KEY (cod_casa, cod_actividad, dia),
CONSTRAINT fk_horario_actividad_actividad FOREIGN KEY (cod_actividad) REFERENCES ACTIVIDAD(IdActividad),
CONSTRAINT fk_horario_actividad_casa FOREIGN KEY (cod_casa) REFERENCES CASA(IdCasa)
);

-- Indices
CREATE FULLTEXT INDEX descripcion_actividad ON ACTIVIDAD(descripcion);
CREATE UNIQUE INDEX nif_cliente ON CLIENTE(NIF);