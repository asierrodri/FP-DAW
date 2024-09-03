-- 2.	Añade un nuevo tablespace llamado bd_tunombre con un tamaño de 100 MB.  El fichero se llamará bdtunombre.dbf

CREATE TABLESPACE bd_asier
DATAFILE 'bdasier.dbf'
SIZE 100M
AUTOEXTEND ON;

-- 4.	Añade 100 MB al tablespace anterior. 

ALTER DATABASE
DATAFILE 'bdasier.dbf'
RESIZE 100M;

-- 6.	Añade 200 MB al tablespace en un fichero llamado bdtunombre-extra.dbf

ALTER TABLESPACE bd_asier
ADD datafile 'bdasier-extra.dbf'
SIZE 200M
AUTOEXTEND ON;

-- 7.	Muestra el tamaño total del tablespace bd_tunombre.

SELECT tablespace_name,SUM(BYTES)
FROM dba_data_files
GROUP BY tablespace_name
HAVING tablespace_name='BD_ASIER';

--8.	Adjunta una captura del directorio del disco donde se guardan los ficheros de datos.

-- C:\app\asier\product\21c\dbhomeXE\database

-- 9.	Borra el tablespace creado.

DROP TABLESPACE bd_asier
INCLUDING CONTENTS AND DATAFILES;

-- 10.	Lista los tablespaces existentes.

SELECT * FROM dba_tablespaces;