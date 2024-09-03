<?php
session_start();
require("../database.php");
$con = conectar();
if($codigos = $_POST["borrar"]){
    borrar_reservas($con, $codigos);
    header("Location: ../user.php");
}
cerrar_conexion($con);
?>