<?php
function cargarClases($nombre_clase){
	require_once($nombre_clase.".php");
}
spl_autoload_register("cargarClases");

$personajes = array();
$personajes[0] = new Guerrero("Urhan", "Humano", "50", "20", "5");
$personajes[1] = new Mago("Ejamar", "Elfo", "250", "15", "20");
$personajes[2] = new Explorador("Oruxeor", "Enano", "100", "2", "1");

foreach($personajes as $personaje){
	if($personaje instanceof Guerrero){
		echo "Datos del Guerrero<br>";
	}
	else if($personaje instanceof Mago){
		echo "Datos del Mago<br>";
	}
    else{
        echo 'Datos del Explorador<br>';
    }
	echo $personaje."<br>";
}

?>