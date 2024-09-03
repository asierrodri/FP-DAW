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
</style>

<?php
session_start();
if(!isset($_SESSION['usuario_administrador']) || $_SESSION['usuario_administrador'] !== true){
    header("Location: index.php");
}

require("database.php");
$con = conectar();
echo "<h2>Panel de administrador</h2>";
echo "<a class='logout' href='logout.php'>Logout</a>";
if(isset($_POST["logout"])){
    header("Location: index.php");
}

//Tabla usuarios
echo "<h3>Usuarios</h3>";
$resultado = obtener_usuarios_no_administradores($con);
$num_filas = obtener_num_filas($resultado);
if($num_filas == 0){
	echo "<p>No se encuentran usuarios</p>";
}
else{
	echo "<form method='post' action='usuarios/borrarusuarios.php'>
		<table>
			<tr><td>ID</td><td>Nombre</td><td>Contraseña</td><td>Modificar</td><td>Borrar</td></tr>";
		while($fila = obtener_resultados($resultado)){
			extract($fila);
			echo "<tr><td>$id_usuario</td><td>$nombre</td><td>$pass</td><td><a href='usuarios/modificarusuario.php?id=$id_usuario'>Modificar</a></td><td><input type='checkbox' name='borrar[]' value='$id_usuario'></td></tr>";
		}
	echo "<tr><td colspan='5' style='text-align:right'><input type='submit' value='Borrar'/></td></tr>";
	echo "</table></form>";
}

//Dar de alta usuarios
echo "<hr>";
echo "<h3>Dar de alta usuario</h3>";
echo "<form method='post' action='usuarios/nuevousuario.php'>
		Nombre:<input type='text' name='nombre'><br>
		Contraseña:<input type='password' name='password'><br>";
		echo "<input type='submit' value='Crear'></form>";

//Pistas de padel
echo "<hr>";
echo "<h3>Pistas de Pádel</h3>";
$resultado = obtener_pistas($con);
$num_filas = obtener_num_filas($resultado);
if($num_filas == 0){
	echo "<p>No se encuentran pistas</p>";
}
else{
	echo "<form method='post' action='pistas/borrarpistas.php'>
		<table>
			<tr><td>ID</td><td>Nombre</td><td>Modificar</td><td>Borrar</td></tr>";
		while($fila = obtener_resultados($resultado)){
			extract($fila);
			echo "<tr><td>$id_pista</td><td>$nombre</td><td><a href='pistas/modificarpista.php?id=$id_pista'>Modificar</a></td><td><input type='checkbox' name='borrar[]' value='$id_pista'></td></tr>";
		}
	echo "<tr><td colspan='5' style='text-align:right'><input type='submit' value='Borrar'/></td></tr>";
	echo "</table></form>";
}

//Dar de alta pistas de padel
echo "<hr>";
echo "<h3>Dar de alta pista de pádel</h3>";
echo "<form method='post' action='pistas/nuevapista.php'>
		Nombre:<input type='text' name='nombre'><br>";
		echo "<input type='submit' value='Crear'></form>";

//Reservas
echo "<hr>";
echo "<h3>Reservas</h3>";
$resultado = obtener_reservas($con);
$num_filas = obtener_num_filas($resultado);
if($num_filas == 0){
	echo "<p>No se encuentran reservas</p>";
}
else{
	echo "<form method='post' action='reservas/borrarreservas.php'>
		<table>
			<tr><td>ID</td><td>ID_Usuario</td><td>ID_Pista</td><td>Turno</td><td>Borrar</td></tr>";
		while($fila = obtener_resultados($resultado)){
			extract($fila);
			echo "<tr><td>$id_reserva</td><td>$usuario</td><td>$pista</td>";
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
	echo "<tr><td colspan='5' style='text-align:right'><input type='submit' value='Borrar todas' name='borrar_todas'/></td></tr>";
	echo "</table></form>";
}
cerrar_conexion($con);
?>