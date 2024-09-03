<?php
    if(isset($_POST['enviar'])){
        $diaSemana = $_POST["dia-semana"];
        $errores = 0;
        if(empty($diaSemana)){
            echo "<p style='color:red'>Debes seleccionar un dia de la semana</p>";
            $errores++;
        }
        if($errores == 0){
            $menu = array("Lunes" => "Spaghetti a la bolognesa", "Martes" => "Ensaladilla rusa", "Miercoles" => "Salmón a la parrilla", "Jueves" => "Burritos de carne", "Viernes" => "Pizza casera", "Sabado" => "Sopa", "Domingo" => "Pollo asado");
	        foreach($menu as $clave => $valor){
                if($clave == $diaSemana){
		            echo "$clave => $valor<br>";
                }
	        }
        }
    }
?>