<?php
    if(isset($_POST['enviar'])){
        $numero1 = $_POST["numero1"];
        $numero2 = $_POST["numero2"];
        $errores = 0;
        if(empty($numero1)){
            echo "<p style='color:red'>Debes rellenar el primer numero</p>";
            $errores++;
        }
        if(empty($numero2)){
            echo "<p style='color:red'>Debes rellenar el segundo numero</p>";
            $errores++;
        }
        if(!isset($_POST["operaciones"])){
            echo "<p style='color:red'>Debes seleccionar una operacion</p>";
            $errores++;
        }
        if($errores == 0){
            foreach($_POST["operaciones"] as $operacion){
                if($operacion == "suma"){
                    $resultado = $numero1 + $numero2;
                }
                if($operacion == "resta"){
                    $resultado = $numero1 - $numero2;
                }
                if($operacion == "multiplicacion"){
                    $resultado = $numero1 * $numero2;
                }
                if($operacion == "division"){
                    $resultado = $numero1 / $numero2;
                }
                echo "El resultado de la $operacion es $resultado";
            }
        }
    }
?>