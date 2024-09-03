<?php
function visualizar_estado_parking(){
    echo '<br>Estado del parking:<br>';
    echo 'Parking pequeño: ';
    foreach($_SESSION['parking']['pequenio'] as $parking_pequenio){
        if($parking_pequenio == 0){
            echo "libre, ";
        }
        if($parking_pequenio == 1){
            echo "ocupado, ";
        }
    }
    echo '<br>';
    echo 'Parking grande: ';
    foreach($_SESSION['parking']['grande'] as $parking_grande){
        if($parking_grande == 0){
            echo "libre, ";
        }
        if($parking_grande == 1){
            echo "ocupado, ";
        }
    }
}
?>