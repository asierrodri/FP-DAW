<?php
function retirar_coche_pequenio(){
    if(empty($_POST['numero_plaza'])){
        echo "<p style='color:red'>Debes elegir el numero de plaza</p>";;
        exit;
    }
    $numero_plaza = $_POST['numero_plaza'];
    if ($_SESSION["parking"]["pequenio"][$numero_plaza - 1] == 1) {
        $_SESSION["parking"]["pequenio"][$numero_plaza - 1] = 0;
        echo "Coche retirado de la plaza $numero_plaza del parking pequeño";
    }
    else{
        echo "<p style='color:red'>No hay ningun coche aparcado en la plaza $numero_plaza del parking pequeño</p>";
    }
}

function retirar_coche_grande(){
    if(empty($_POST['numero_plaza'])){
        echo "<p style='color:red'>Debes elegir el numero de plaza</p>";;
        exit;
    }
    $numero_plaza = $_POST['numero_plaza'];
    if ($_SESSION["parking"]["grande"][$numero_plaza - 1] == 1) {
        $_SESSION["parking"]["grande"][$numero_plaza - 1] = 0;
        echo "Coche retirado de la plaza $numero_plaza del parking grande";
    }
    else{
        echo "<p style='color:red'>No hay ningun coche aparcado en la plaza $numero_plaza del parking grande</p>";
    }
}
?>