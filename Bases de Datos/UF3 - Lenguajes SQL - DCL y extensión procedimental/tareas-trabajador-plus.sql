SET SERVEROUTPUT ON;
CREATE TABLESPACE APLICACION_TAREAS
DATAFILE 'aplicacion_tareas.dbf'
SIZE 20M AUTOEXTEND ON;
ALTER SESSION SET "_ORACLE_SCRIPT"=true;
CREATE USER admintareas
IDENTIFIED BY "1234"
DEFAULT TABLESPACE APLICACION_TAREAS;
GRANT DBA TO admintareas;

-- La empresa para la que estamos trabajando nos ha pedido una pequeña aplicación para controlar las tareas que debe realizar cada trabajador y si se han realizado o no. Por lo que decidimos crear una aplicación para solucionar el problema.

/*Ejercicio 1: (0,5 puntos)
Crearemos una tabla llamada tareas para ir guardando todas aquellas tareas que se van asignando.
De cada tarea guardaremos la siguiente información:
•	Codigo varchar2(6) clave principal
•	nombre varchar2(30)
•	descripcion varchar2(200)
•	usuario varchar2(30)
•	fecha DATE
•	realizada(S/N) varchar2(1)
•	horas number

Un ejemplo de tarea podría ser: Ana Mora nos comenta que el día 12/10/2024 tiene una reunión con el ayuntamiento.

        Añade 5 registros a la tabla de tareas.
*/
CREATE TABLE tareas (
    codigo VARCHAR2(6) PRIMARY KEY,
    nombre VARCHAR2(30),
    descripcion VARCHAR2(200),
    usuario VARCHAR2(30),
    fecha DATE,
    realizada CHAR(1) CHECK (realizada IN ('S', 'N')),
    horas NUMBER
);

INSERT INTO tareas VALUES ('01', 'Reunión con Ayuntamiento', 'Discutir proyectos de desarrollo', 'Ana Mora', TO_DATE('12/10/2024', 'DD/MM/YYYY'), 'N', 2);
INSERT INTO tareas VALUES ('02', 'Preparación informe', 'Elaborar informe mensual', 'Juan Pérez', TO_DATE('15/10/2024', 'DD/MM/YYYY'), 'S', 3);
INSERT INTO tareas VALUES ('03', 'Entrevista candidato', 'Conducir entrevista para posición de desarrollador', 'María López', TO_DATE('18/10/2024', 'DD/MM/YYYY'), 'N', 1.5);
INSERT INTO tareas VALUES ('04', 'Revisión de código', 'Revisar código del nuevo módulo', 'Carlos García', TO_DATE('20/10/2024', 'DD/MM/YYYY'), 'N', 2);
INSERT INTO tareas VALUES ('05', 'Planificación de proyecto', 'Definir hitos y tareas para el nuevo proyecto', 'Laura Martínez', TO_DATE('22/10/2024', 'DD/MM/YYYY'), 'N', 4);

/*Ejercicio 2: (1 punto)
Realizar un procedimiento llamado “mostrarTarea”, que muestre por pantalla todos los datos de una determinada tarea, dado su identificador. Para llamar a este procedimiento utilizaremos una instrucción del tipo:

	mostrarTarea(‘01’);
*/

CREATE OR REPLACE PROCEDURE mostrarTarea(v_codigo VARCHAR2)
IS
    v_nombre tareas.nombre%TYPE;
    v_descripcion tareas.descripcion%TYPE;
    v_usuario tareas.usuario%TYPE;
    v_fecha tareas.fecha%TYPE;
    v_realizada tareas.realizada%TYPE;
    v_horas tareas.horas%TYPE;
BEGIN
    SELECT nombre, descripcion, usuario, fecha, realizada, horas
    INTO v_nombre, v_descripcion, v_usuario, v_fecha, v_realizada, v_horas
    FROM tareas
    WHERE codigo = v_codigo;
    
    dbms_output.put_line('Nombre: ' || v_nombre);
    dbms_output.put_line('Descripción: ' || v_descripcion);
    dbms_output.put_line('Usuario: ' || v_usuario);
    dbms_output.put_line('Fecha: ' || v_fecha);
    dbms_output.put_line('Realizada: ' || v_realizada);
    dbms_output.put_line('Horas: ' || v_horas);
END mostrarTarea;

DECLARE
    v_codigo VARCHAR2(6) := '05';
BEGIN
    mostrarTarea(v_codigo);
END;

/*Ejercicio 3: (2 puntos)
Realizar un procedimiento llamado “finTarea”, para marcar una tarea como solucionada y añadir las horas destinadas a la tarea. A este procedimiento le pasaremos el código de la tarea y las horas. Después de actualizar, el procedimiento nos mostrará los datos de la Tarea que acaba de modificar. Para llamar a este procedimiento utilizaremos una instrucción del tipo:

		finTarea(‘01’,5);
*/

CREATE OR REPLACE PROCEDURE finTarea(v_codigo VARCHAR2, v_horas NUMBER)
IS
    v_nombre tareas.nombre%TYPE;
    v_descripcion tareas.descripcion%TYPE;
    v_usuario tareas.usuario%TYPE;
    v_fecha tareas.fecha%TYPE;
    v_realizada tareas.realizada%TYPE;
    v_horas_anteriores tareas.horas%TYPE;
BEGIN
    SELECT nombre, descripcion, usuario, fecha, realizada, horas
    INTO v_nombre, v_descripcion, v_usuario, v_fecha, v_realizada, v_horas_anteriores
    FROM tareas
    WHERE codigo = v_codigo;
    
    UPDATE tareas
    SET realizada = 'S', horas = v_horas_anteriores + v_horas
    WHERE codigo = v_codigo;
    
    dbms_output.put_line('Tarea Actilizada');
    dbms_output.put_line('Código: ' || v_codigo);
    dbms_output.put_line('Nombre: ' || v_nombre);
    dbms_output.put_line('Descripción: ' || v_descripcion);
    dbms_output.put_line('Usuario: ' || v_usuario);
    dbms_output.put_line('Fecha: ' || v_fecha);
    dbms_output.put_line('Realizada: ' || 'S');
    dbms_output.put_line('Horas Anteriores: ' || v_horas_anteriores);
    dbms_output.put_line('Horas Nuevas: ' || v_horas);
END finTarea;

DECLARE
    v_codigo VARCHAR2(6) := '01';
    v_horas VARCHAR2(6) := 5;
BEGIN
    finTarea(v_codigo, v_horas);
END;

/*Ejercicio 4: (3 puntos)
Realizar un procedimiento llamado “tareasPendientes”, que muestre por pantalla los datos de las tareas que están pendientes de realizar. Para llamar a este procedimiento utilizaremos una instrucción del tipo:

	tareasPendientes();
*/

CREATE OR REPLACE PROCEDURE tareasPendientes
IS
BEGIN
    FOR tarea IN (
        SELECT nombre, descripcion, usuario, fecha, realizada, horas
        FROM tareas
        WHERE realizada = 'N'
    )
    LOOP  
        dbms_output.put_line('Nombre: ' || tarea.nombre);
        dbms_output.put_line('Descripción: ' || tarea.descripcion);
        dbms_output.put_line('Usuario: ' || tarea.usuario);
        dbms_output.put_line('Fecha: ' || tarea.fecha);
        dbms_output.put_line('Realizada: ' || tarea.realizada);
        dbms_output.put_line('Horas: ' || tarea.horas);
        dbms_output.put_line('----------------------------');
    END LOOP;
END tareasPendientes;

BEGIN
    tareasPendientes();
END;

/*Ejercicio 5: (3,5 puntos)
Realizar un disparador llamado “totalTareasUsuario”, para mostrar por consola el número total de tareas de cada usuario. Este disparador se ejecutará después de que se realice una operación de inserción o de actualización en la tabla de tareas.
*/

CREATE OR REPLACE TRIGGER totalTareasUsuario
AFTER INSERT OR UPDATE ON tareas
FOR EACH ROW
DECLARE
    v_total_tareas NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_total_tareas
    FROM tareas
    WHERE usuario = :NEW.usuario;

    dbms_output.put_line('Total de tareas para el usuario ' || :NEW.usuario || ': ' || v_total_tareas);
END totalTareasUsuario;