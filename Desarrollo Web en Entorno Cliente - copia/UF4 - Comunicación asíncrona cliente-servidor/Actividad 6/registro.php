<?php
session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nombre = ($_POST['nombre']);
    $apellido = ($_POST['apellido']);
    $correo = ($_POST['correo']);
    $password = ($_POST['password']);
    $confirmar_password = ($_POST['confirmar_password']);

    $errores = [];

    if (strlen($nombre) < 2) {
        $errores[] = "El nombre debe tener al menos 2 caracteres.";
    }

    if (strlen($apellido) < 2) {
        $errores[] = "El apellido debe tener al menos 2 caracteres.";
    }

    if (!filter_var($correo, FILTER_VALIDATE_EMAIL)) {
        $errores[] = "El correo electrónico no tiene un formato válido.";
    }

    if (strlen($password) < 6) {
        $errores[] = "La contraseña debe tener al menos 6 caracteres.";
    }

    if ($password !== $confirmar_password) {
        $errores[] = "Las contraseñas no coinciden.";
    }

    if (!empty($errores)) {
        echo json_encode([
            "success" => false,
            "errors" => $errores
        ]);
        exit;
    }

    $_SESSION['usuario'] = [
        'nombre' => $nombre,
        'apellido' => $apellido,
        'correo' => $correo
    ];

    echo json_encode(["success" => true]);
    exit;
}
?>
