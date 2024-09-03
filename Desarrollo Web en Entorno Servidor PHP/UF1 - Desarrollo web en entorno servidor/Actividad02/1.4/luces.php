<?php
    if(isset($_POST['enviar'])){
        $cadena = $_POST["cadena"];
        $errores = 0;
        if(empty($cadena)){
            echo "<p style='color:red'>Debes introducir numeros separados por comas</p>";
            $errores++;
        }
        if($errores == 0){
            $secuencia = explode(",", $cadena);
            //Queria practicar
            for($i = 0; $i<count($secuencia); $i++){
                if($secuencia[$i] < 0 || $secuencia[$i] > 7){
                    echo "<p style='color:red'>Los valores solo pueden estar entre 0 y 7</p>";
                    $errores++;
                    break;
                }
            }
            /* if($errores == 0){
                foreach($secuencia as $interruptor){
                    echo "$interruptor";
                }
            } */
            if($errores == 0){
                $luces = [false, false, false, false, false, false, false, false];
                foreach($secuencia as $interruptor){
// DE ESTA MANERA NO ME DEJA!!
/*                     if($luces[$interruptor] == false){
                        $luces[$interruptor] = true;
                    }
                    if($luces[$interruptor] == true){
                        $luces[$interruptor] = false;
                    } */
                    $luces[$interruptor] = !$luces[$interruptor];
                }
                foreach($luces as $luz){
                    if($luz == false){
                        echo "false, ";
                    }
                    if($luz == true){
                        echo "true, ";
                    }
                }
            }  
        }
    }
?>