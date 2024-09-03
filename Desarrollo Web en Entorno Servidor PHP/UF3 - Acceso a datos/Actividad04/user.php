<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #333;
        color: white;
        padding: 10px;
        text-align: center;
    }

    section {
        width: 80%;
        margin: 20px auto;
    }

    h2, h3 {
        color: #333;
    }

    p {
        color: #777;
    }

    form {
        margin-top: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table, th, td {
        border: 1px solid #ccc;
    }

    th {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
    }

    td, th {
        padding: 8px;
        text-align: left;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        cursor: pointer;
        border: none;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .logout {
        position: absolute;
        top: 10px;
        right: 10px;
        color: white;
        text-decoration: none;
        background-color: #4CAF50;
        padding: 5px 10px;
        border-radius: 5px;
    }

    select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
</style>

<?php
session_start();
if(!isset($_SESSION['usuario']) || $_SESSION['usuario'] !== true){
    header("Location: index.php");
}

if(empty($_SESSION["id_usuario"]))
{
    $id_usuario = $_GET["id"];
    $_SESSION["id_usuario"] = $id_usuario;
}

require("database.php");
$con = conectar();
$resultado = obtener_usuarios_no_administrador($con, $_SESSION['id_usuario']);
$num_filas = obtener_num_filas($resultado);
$datos_usuario = obtener_resultados($resultado);
extract($datos_usuario);
echo "<h2>Panel de $nombre</h2>";
echo "<a class='logout' href='logout.php'>Logout</a>";
if(isset($_POST["logout"])){
    header("Location: index.php");
}

$reservas = obtener_reservas_usuario($con, $_SESSION['id_usuario']);
$num_filas_reservas = obtener_num_filas($reservas);
if($num_filas_reservas == 0){
	echo "<p>No se encuentran reservas</p>";
}
else{
	echo "<form method='post' action='reservas/borrarreservas_usuario.php'>
		<table>
			<td>Pista</td><td>Turno</td><td>Borrar</td></tr>";
		while($fila = obtener_resultados($reservas)){
			extract($fila);
			echo "<tr><td>$pista</td>";
            if($turno == 0){
                echo "<td>Mañana</td>";
            }
            else if($turno == 1){
                echo "<td>Mediodía</td>";
            }
            else{
                echo "<td>Tarde</td>";
            }
            echo "<td><input type='checkbox' name='borrar[]' value='$id_reserva'></td></tr>";
		}
	echo "<tr><td colspan='5' style='text-align:right'><input type='submit' value='Borrar'/></td></tr>";
	echo "</table></form>";
}
echo "<hr>";
$pistas = obtener_pistas($con);
echo "<h3>Reservar pista</h3>";
echo "<form method='post' action='reservas/nuevareserva.php?id=" . $_SESSION["id_usuario"] . "'>
Pista:<select name='pista'>";
while($fila = obtener_resultados($pistas)){
	extract($fila);
	echo "<option value='$id_pista'>$nombre</option>";
}
echo "</select><br>";
echo "Turno:<select name='turno'>;
<option value=0>Mañana</option>;
<option value=1>Mediodía</option>;
<option value=2>Tarde</option>;
<input type='submit' value='Reservar'></form>";
if(isset($_GET["mensaje"])){
    $mensaje = $_GET["mensaje"];
    echo "<p style='color: red;'>$mensaje</p>";
}
cerrar_conexion($con);
?>