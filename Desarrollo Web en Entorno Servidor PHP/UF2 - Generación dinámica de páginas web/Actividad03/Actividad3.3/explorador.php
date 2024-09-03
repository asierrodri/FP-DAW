<?php
require_once("personaje.php");
class Explorador extends Personaje{
	private $objetivos_descubiertos;
	private $veces_sin_ser_descubierto;

	function __construct($marca, $modelo, $potencia, $objetivos_descubiertos, $veces_sin_ser_descubierto){
		parent::__construct($marca, $modelo, $potencia);
		$this->objetivos_descubiertos = $objetivos_descubiertos;
		$this->veces_sin_ser_descubierto = $veces_sin_ser_descubierto;
        $this->puntos = ($objetivos_descubiertos * 10) + ($veces_sin_ser_descubierto * 5);
	}

	function getobjetivos_descubiertos(){
		return $this->objetivos_descubiertos;
	}

	function setobjetivos_descubiertos($objetivos_descubiertos){
		$this->objetivos_descubiertos = $objetivos_descubiertos;
	}

	function getveces_sin_ser_descubierto(){
		return $this->veces_sin_ser_descubierto;
	}

	function setveces_sin_ser_descubierto($veces_sin_ser_descubierto){
		$this->veces_sin_ser_descubierto = $veces_sin_ser_descubierto;
	}

    function calcularPuntos($enemigos_abatidos, $danio_sufrido) {
        $this->puntos = ($objetivos_descubiertos * 10) + ($veces_sin_ser_descubierto * 5);
    }

	function __toString(){
		return "Explorador: ".parent::__toString()." | Objetivos descubiertos: ".$this->objetivos_descubiertos." | Veces sin ser descubierto: ".$this->veces_sin_ser_descubierto."<br> | Puntos ganados: ".$this->puntos."<br>";
	}
}
?>