<?php
$host = "localhost";
$user = "root";
$pass = "root";
$db_name = "padel";

function conectar(){
	$con = mysqli_connect($GLOBALS["host"], $GLOBALS["user"], $GLOBALS["pass"]) or die("Error al conectar con la base de datos");
    mysqli_select_db($con, $GLOBALS["db_name"]);
    return $con;
}

//USUARIOS
function obtener_usuarios($con, $nombre_usuario, $password){
	$resultado = mysqli_query($con, "select * from usuario where nombre='$nombre_usuario' AND pass='$password';");
	return $resultado; 
}

function obtener_usuarios_no_administradores($con){
	$resultado = mysqli_query($con, "select * from usuario where tipo=1;");
	return $resultado; 
}

function obtener_usuarios_no_administrador($con, $id_usuario){
	$resultado = mysqli_query($con, "select * from usuario where id_usuario=$id_usuario;");
	return $resultado; 
}

function crear_usuario($con, $nombre, $password){
    mysqli_query($con, "insert into usuario values(0, '$nombre', '$password', 1)");
}

function borrar_usuarios($con, $codigos){
	$consulta = "delete from usuario where id_usuario in (";
	foreach($codigos as $codigo){
		$consulta = $consulta.$codigo.", ";
	}
	$consulta = $consulta."0)";
	mysqli_query($con, $consulta);
}

function modificar_usuario($con, $id_usuario, $nombre, $password){
	$consulta = "update usuario set nombre='$nombre', pass='$password' where id_usuario=$id_usuario";
	mysqli_query($con, $consulta);
}

//PISTAS
function obtener_pistas($con){
	$resultado = mysqli_query($con, "select * from pista;");
	return $resultado; 
}

function obtener_pista($con, $id_pista){
	$resultado = mysqli_query($con, "select * from pista where id_pista=$id_pista;");
	return $resultado; 
}

function borrar_pistas($con, $codigos){
	$consulta = "delete from pista where id_pista in (";
	foreach($codigos as $codigo){
		$consulta = $consulta.$codigo.", ";
	}
	$consulta = $consulta."0)";
	mysqli_query($con, $consulta);
}

function modificar_pista($con, $id_pista, $nombre){
	$consulta = "update pista set nombre='$nombre' where id_pista=$id_pista";
	mysqli_query($con, $consulta);
}

function crear_pista($con, $nombre){
    mysqli_query($con, "insert into pista values(0, '$nombre')");
}

//RESERVAS
function obtener_reservas($con){
	$resultado = mysqli_query($con, "select * from reserva;");
	return $resultado; 
}

function borrar_reservas($con, $codigos){
	$consulta = "delete from reserva where id_reserva in (";
	foreach($codigos as $codigo){
		$consulta = $consulta.$codigo.", ";
	}
	$consulta = $consulta."0)";
	mysqli_query($con, $consulta);
}

function borrar_todas_reservas($con){
	$consulta = "delete from reserva";
	mysqli_query($con, $consulta);
}

function obtener_reservas_usuario($con, $id_usuario){
	$resultado = mysqli_query($con, "select * from reserva where usuario=$id_usuario;");
	return $resultado; 
}

function verificar_reserva($con, $id_pista, $turno){
	$resultado = mysqli_query($con, "select * from reserva where pista='$id_pista' AND turno='$turno';");
	return $resultado; 
}

function crear_reserva($con, $id_pista, $id_usuario, $turno){
	mysqli_query($con, "insert into reserva values(0, '$id_usuario', '$id_pista', $turno)");
}

//OTROS
function obtener_num_filas($resultado){
	return mysqli_num_rows($resultado);
}

function obtener_resultados($resultado){
	return mysqli_fetch_array($resultado);
}

function cerrar_conexion($con){
	mysqli_close($con);
}
?>