<?php
    if(isset($_POST['enviar'])){
        $palindromo = $_POST["palindromo"];
        $errores = 0;
        if(empty($palindromo)){
            echo "<p style='color:red'>Debes introducir cualquier texto</p>";
            $errores++;
        }
        if($errores == 0)
        {
            $palindromo = trim($palindromo);
            if ($palindromo == strrev($palindromo)){
                echo "El texto SI es un palíndromo";
            }
            else{
                echo "El texto NO es un palíndromo";
            }
        }
    }
?>