<?php
require("../database.php");
$con = conectar();
$nombre = $_POST["nombre"];
crear_pista($con, $nombre);
cerrar_conexion($con);
header("Location: ../admin.php");
?>