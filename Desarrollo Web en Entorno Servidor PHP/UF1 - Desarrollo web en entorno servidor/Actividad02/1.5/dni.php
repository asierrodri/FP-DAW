<?php
    if(isset($_POST['enviar'])){
        $dni = $_POST["dni"];
        $errores = 0;
        if(empty($dni)){
            echo "<p style='color:red'>Debes introducir tus numeros del DNI</p>";
            $errores++;
        }
        //No estoy seguro pero he visto que tiene que tener 8 digitos
        if(strlen($dni) < 8 || strlen($dni) > 8){
            echo "<p style='color:red'>Tu DNI debe tener 8 digitos</p>";
            $errores++;
        }
        if($errores == 0){
            $letras = ['T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'];
            $resto = $dni % 23;
            echo "La letra de tu DNI es $letras[$resto] y tu DNI quedaria: $dni-$letras[$resto]";
        }
    }
?>