<?php
require 'utils/aparcar.php';
require 'utils/retirar.php';

if(!isset($_SESSION['parking'])){
    $_SESSION['parking'] = array();
    $_SESSION['parking']['pequenio'] = [0,0,0,0,0,0,0,0,0,0];
    $_SESSION['parking']['grande'] = [0,0,0,0,0,0,0,0,0,0,0,0,0,0];
}

if(isset($_POST["enviar"])){
    if(isset($_POST["operacion"])){
        $operacion = $_POST['operacion'];
        if($operacion == "aparcar"){
            if(isset($_POST['tamanio_coche'])){
                $tamanio_coche = $_POST['tamanio_coche'];
                if($tamanio_coche == "coche_pequenio"){
                    aparcar_coche_pequenio();
                }
                if($tamanio_coche == "coche_grande"){
                    aparcar_coche_grande();
                }
            }
        }
    }
    if(isset($_POST["operacion"])){
        $operacion = $_POST['operacion'];
        if($operacion == "retirar"){
            if(isset($_POST['tamanio_plaza'])){
                $tamanio_plaza = $_POST['tamanio_plaza'];
                if($tamanio_plaza == "plaza_pequenia"){
                    retirar_coche_pequenio();
                }
                if($tamanio_plaza == "plaza_grande"){
                    retirar_coche_grande();
                }
            }
        }
    }
    else{
        echo "<p style='color:red'>Debes seleccionar una operacion</p>";
    }
}
?>