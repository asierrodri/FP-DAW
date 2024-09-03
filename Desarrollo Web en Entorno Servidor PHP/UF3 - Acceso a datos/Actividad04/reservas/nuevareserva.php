<?php
require("../database.php");
$con = conectar();
if(!isset($_POST["pista"])){
    header("Location: ../user.php");
}
$id_pista = $_POST["pista"];
$turno = $_POST["turno"];
$id_usuario = $_GET["id"];
$resultado = verificar_reserva($con, $id_pista, $turno);
if($resultado && obtener_num_filas($resultado) > 0){
    header("Location: ../user.php?mensaje=No hay disponibilidad en ese turno");
}
else{
    crear_reserva($con, $id_pista, $id_usuario, $turno);
    header("Location: ../user.php");
}
cerrar_conexion($con);
?>