<?php
session_start();

if (!isset($_SESSION['usuario'])) {
    header("Location: registro.html");
    exit;
}

$usuario = $_SESSION['usuario'];
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro Exitoso</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>¡Registro Exitoso!</h1>
    <p>¡Felicitaciones! Tu registro ha sido exitoso.</p>
    <ul>
        <li><strong>Nombre: </strong><?php echo($usuario['nombre']); ?></li>
        <li><strong>Apellido: </strong><?php echo($usuario['apellido']); ?></li>
        <li><strong>Correo Electrónico: </strong><?php echo($usuario['correo']); ?></li>
    </ul>
    <p>Gracias por registrarte. Disfruta de nuestros servicios.</p>

    <a href="registro.html">Inicio</a>
</body>
</html>
