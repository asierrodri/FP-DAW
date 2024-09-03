-- 1.	Crea un tablespace de datos de nombre “TBL_tareas” con un espacio de 200MB. Muestra una lista de todos los tablespaces junto con su tamaño.

CREATE TABLESPACE TBL_tareas
DATAFILE 'tbl_tareas.dbf'
SIZE 200M
AUTOEXTEND ON;

SELECT tablespace_name,SUM(BYTES)
FROM dba_data_files
GROUP BY tablespace_name;

-- 2.	Crea un usuario llamado “supervisor” que tenga todos los privilegios en el sistema Oracle. Asigna el rol dba a este usuario.

ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE USER supervisor
IDENTIFIED BY "supervisor"
DEFAULT TABLESPACE TBL_tareas
QUOTA UNLIMITED ON TBL_tareas;

GRANT ALL PRIVILEGES TO supervisor;

-- 3.	Crearemos una tabla llamada tareas para ir guardando todas aquellas que se van asignado.

/*De cada tarea guardaremos la siguiente información:
•	Codigo varchar(6) clave principal
•	nombre varchar(30)
•	descripcion varchar(200)
•	usuario varchar(30)
•	fecha DATE
•	realizada(S/N) varchar(1)
•	horas number

Un ejemplo de tarea podría ser: Ana Mora nos comenta el día 12/10/2024 tiene una reunión con el ayuntamiento.

Añade 5 registros inventados a la tabla de tareas.*/

CREATE TABLE tareas (
    codigo VARCHAR2(6) PRIMARY KEY,
    nombre VARCHAR2(30),
    descripcion VARCHAR2(200),
    usuario VARCHAR2(30),
    fecha DATE,
    realizada CHAR(1) CHECK (realizada IN ('S', 'N')),
    horas NUMBER
);

INSERT INTO tareas VALUES ('T001', 'Reunión con Ayuntamiento', 'Discutir proyectos de desarrollo', 'Ana Mora', TO_DATE('12/10/2024', 'DD/MM/YYYY'), 'N', 2);
INSERT INTO tareas VALUES ('T002', 'Preparación informe', 'Elaborar informe mensual', 'Juan Pérez', TO_DATE('15/10/2024', 'DD/MM/YYYY'), 'S', 3);
INSERT INTO tareas VALUES ('T003', 'Entrevista candidato', 'Conducir entrevista para posición de desarrollador', 'María López', TO_DATE('18/10/2024', 'DD/MM/YYYY'), 'N', 1.5);
INSERT INTO tareas VALUES ('T004', 'Revisión de código', 'Revisar código del nuevo módulo', 'Carlos García', TO_DATE('20/10/2024', 'DD/MM/YYYY'), 'N', 2);
INSERT INTO tareas VALUES ('T005', 'Planificación de proyecto', 'Definir hitos y tareas para el nuevo proyecto', 'Laura Martínez', TO_DATE('22/10/2024', 'DD/MM/YYYY'), 'N', 4);

-- 4.	Crea los siguientes usuarios.

-- a.	Usuario ‘gestor’: Dispondrá de los privilegios necesarios para llevar a cabo cualquier operación sobre las tablas de la base de datos. 

CREATE USER gestor
IDENTIFIED BY "gestor";

GRANT ALL PRIVILEGES TO gestor;

-- b.	Usuario ‘administrativo’.  En la tabla de tareas puede leer, modificar e insertar, pero no puede borrar los datos.

CREATE USER administrativo
IDENTIFIED BY "administrativo";

GRANT SELECT, INSERT, UPDATE ON tareas TO administrativo;

-- c.	Usuario ‘tecnico’. Tiene acceso para insertar y leer las tareas. Solo puede modificar las columnas realizada y las horas.

CREATE USER tecnico
IDENTIFIED BY "tecnico";

GRANT INSERT, SELECT, UPDATE (realizada, horas) ON tareas TO tecnico;

-- 5.	Comprueba que se han asignado correctamente los permisos accediendo a las tablas/vistas correspondientes del diccionario de datos. (capturas de pantalla).

SELECT * FROM DBA_SYS_PRIVS
WHERE GRANTEE='GESTOR';

SELECT * FROM DBA_TAB_PRIVS
WHERE GRANTEE='ADMINISTRATIVO';

SELECT * FROM DBA_TAB_PRIVS
WHERE GRANTEE='TECNICO';

-- 6.	Quita el permiso de insertar en la tabla de tareas al usuario técnico.

REVOKE INSERT ON tareas FROM tecnico;

-- 7.	Crea un rol llamado roltareas que pueda iniciar una sesión interactiva en el entorno de Oracle y pueda leer solo los datos de la tabla tareas.

CREATE ROLE roltareas;

GRANT SELECT ON tareas TO roltareas;

-- 8.	Crea un usuario con tu nombre y le asignas el roltareas.

CREATE USER asier
IDENTIFIED BY "asier";

GRANT roltareas TO asier;

-- 9.	Crea un perfil de usuario llamado perfiltareas que tenga un tiempo máximo de conexión de 30 minutos, tres conexiones simultáneas y que le obligue a cambiar la contraseña cada 30 días. Asigna el perfil al usuario con tu nombre.

CREATE PROFILE perfiltareas LIMIT
    SESSIONS_PER_USER 3
    CONNECT_TIME 30
    PASSWORD_LIFE_TIME 30;
    
ALTER USER asier
PROFILE perfiltareas;

-- 10.	Borra el perfil, los usuarios, el rol y el tablespace junto con sus datos.

DROP USER gestor CASCADE;
DROP USER administrativo CASCADE;
DROP USER tecnico CASCADE;
DROP USER asier CASCADE;
DROP PROFILE perfiltareas;
DROP ROLE roltareas;
DROP TABLESPACE TBL_tareas INCLUDING CONTENTS AND DATAFILES;