<?php
require 'utils/functions.php';
require 'includes/header.html';

if(isset($_POST['enviar'])){
    $name = $_POST["name"];
    $year = $_POST["year"];
    $weight = $_POST["weight"];
    $height = $_POST["height"];
    if(empty($name) || empty($year) || empty($weight) || empty($height)){
        echo "<p style='color:red'>Debes introducir todos los datos</p>";
    }
    else{
        echo "Hola $name,<br>";
        $edad = mayor_edad($year);
        if($edad < 18){
            echo "Lo sentimos, esta página es para mayores de edad";
        }
        else{
            echo "Rondas los $edad años.<br><br>";
            $imc = calculo_imc($weight, $height);
            $str = imc_status($imc);
            echo "Tu IMC es de $imc. Según tu IMC, este es tu estado: $str";
        }
    }
}

require 'includes/footer.html';
?>