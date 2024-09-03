<?php
session_start();
require("database.php");
$con = conectar();
?>

<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            width: 300px;
            margin: 20px auto;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        fieldset {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 15px;
        }

        legend {
            font-weight: bold;
            color: #333;
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
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<form method="POST" action="".$_SERVER['PHP_SELF']."">
        <fieldset>
            <legend>Inicio de sesión Padel</legend>
            Nombre de usuario: <input type="text" name="nombre_usuario"><br>
            Contraseña: <input type="password" name="password"><br>
        </fieldset>
        <input type="submit" name="enviar"/>
	</form>
</body>
</html>

<?php
if(isset($_POST["enviar"])){
    $nombre_usuario = $_POST['nombre_usuario'];
    $password = $_POST['password'];
    $resultado = obtener_usuarios($con, $nombre_usuario, $password);
    if($resultado && obtener_num_filas($resultado) > 0){
        $fila = obtener_resultados($resultado);
        extract($fila);
        if($tipo == 0){
            $_SESSION['usuario_administrador'] = true;
            header("Location: admin.php?id=$id_usuario");
        }
        else{
            $_SESSION['usuario'] = true;
            header("Location: user.php?id=$id_usuario");
        }
    }
    else{
        echo "Usuario o contraseña incorrectos";
    }
}
cerrar_conexion($con);
?>