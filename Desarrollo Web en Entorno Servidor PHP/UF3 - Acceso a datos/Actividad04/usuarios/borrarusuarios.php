<?php
require("../database.php");
$con = conectar();
$codigos = $_POST["borrar"];
borrar_usuarios($con, $codigos);
cerrar_conexion($con);
header("Location: ../admin.php");
?>