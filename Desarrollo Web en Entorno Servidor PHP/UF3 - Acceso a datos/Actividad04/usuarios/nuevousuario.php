<?php
require("../database.php");
$con = conectar();
$nombre = $_POST["nombre"];
$password = $_POST["password"];
crear_usuario($con, $nombre, $password);
cerrar_conexion($con);
header("Location: ../admin.php");
?>