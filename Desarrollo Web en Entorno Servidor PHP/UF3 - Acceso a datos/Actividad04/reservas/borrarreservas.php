<?php
require("../database.php");
$con = conectar();
if($codigos = $_POST["borrar"]){
    borrar_reservas($con, $codigos);
}
if($codigos = $_POST["borrar_todas"]){
    borrar_todas_reservas($con);
}
cerrar_conexion($con);
header("Location: ../admin.php");
?>