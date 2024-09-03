<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            width: 300px;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            border: none;
            padding: 10px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>

<?php
session_start();
require("../database.php");
$con = conectar();




if(isset($_POST['modificar'])){
	$nombre = $_POST['nombre'];
    $password = $_POST['password'];
	modificar_usuario($con, $_SESSION["id_usuario"], $nombre, $password);
	header("Location: ../admin.php");
}
else{
	$id_usuario = $_GET["id"];
	$_SESSION["id_usuario"] = $id_usuario;
	$resultado = obtener_usuarios_no_administrador($con, $id_usuario);
	$num_filas = obtener_num_filas($resultado);
	if($num_filas==0){
		header("Location: ../admin.php");
	}
	else{
		$datos_usuario = obtener_resultados($resultado);
		extract($datos_usuario);
		echo "<form method='post' action='".$_SERVER['PHP_SELF']."'>
				Nombre:<input type='text' name='nombre' value='$nombre'/><br>
				Contraseña:<input type='password' name='password' value='$pass'/>";

        echo "<input type='submit' name='modificar' value='Modificar'></form>";
	}
}
cerrar_conexion($con);
?>