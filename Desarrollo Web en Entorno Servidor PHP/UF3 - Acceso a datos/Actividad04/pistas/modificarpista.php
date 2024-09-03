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
	modificar_pista($con, $_SESSION["id_pista"], $nombre);
	header("Location: ../admin.php");
}
else{
	$id_pista = $_GET["id"];
	$_SESSION["id_pista"] = $id_pista;
	$resultado = obtener_pista($con, $id_pista);
	$num_filas = obtener_num_filas($resultado);
	if($num_filas==0){
		header("Location: ../admin.php");
	}
	else{
		$datos_pista = obtener_resultados($resultado);
		extract($datos_pista);
		echo "<form method='post' action='".$_SERVER['PHP_SELF']."'>
				Nombre:<input type='text' name='nombre' value='$nombre'/>";

        echo "<input type='submit' name='modificar' value='Modificar'></form>";
	}
}
cerrar_conexion($con);
?>