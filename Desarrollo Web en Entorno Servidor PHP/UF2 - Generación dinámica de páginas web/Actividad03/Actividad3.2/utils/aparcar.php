<?php
function aparcar_coche_pequenio(){
    $index = 0;
    $flag = 0;
    while ($index < 10) {
        if ($_SESSION["parking"]["pequenio"][$index] == 0) {
            $_SESSION["parking"]["pequenio"][$index] = 1;
            echo "Coche pequeño aparcado en la plaza " .$index + 1.; echo " del parking pequeño";
            $flag++;
            break;
        }
        $index++;
    }
    if($flag == 0){
        $index = 0;
        while ($index < 14) {
            if ($_SESSION["parking"]["grande"][$index] == 0) {
                $_SESSION["parking"]["grande"][$index] = 1;
                echo "Coche pequeño aparcado en la plaza " .$index + 1.; echo " del parking grande";
                $flag++;
                break;
            }
            $index++;
        }
        if($flag == 0){
            echo "<p style='color:red'>El parking esta completo</p>";
        }
    }
}

function aparcar_coche_grande(){
    $index = 0;
    $flag = 0;
    while ($index < 14){
        if ($_SESSION["parking"]["grande"][$index] == 0) {
            $_SESSION["parking"]["grande"][$index] = 1;
            echo "Coche grande aparcado en la plaza " .$index + 1.; echo " del parking grande";
            $flag++;
            break;
        }
        $index++;
    }
    if($flag == 0){
        echo "<p style='color:red'>El parking esta completo</p>";
    }
}
?>