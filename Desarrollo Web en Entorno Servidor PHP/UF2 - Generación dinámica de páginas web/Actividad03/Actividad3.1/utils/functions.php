<?php
function mayor_edad($year){
    $edad = date('Y') - $year;
    return $edad;
}

function calculo_imc($weight, $height){
    $imc = $weight / ($height * $height);
    return sprintf("%.2f", $imc);
}

function imc_status($imc){
    if ($imc < 18.5){
        return "Peso insuficiente";
    }
    else if ($imc >= 18.5 && $imc <= 25){
        return "Peso normal";
    }
    else if ($imc >= 25 && $imc <= 50){
        return "Sobrepeso";
    }
    else {
        return "Obesidad";
    }
}
?>