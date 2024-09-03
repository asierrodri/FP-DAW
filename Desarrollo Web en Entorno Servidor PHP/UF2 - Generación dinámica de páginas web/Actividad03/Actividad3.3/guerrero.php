<?php
require_once("personaje.php");
class Guerrero extends Personaje{
	private $enemigos_abatidos;
	private $danio_sufrido;

	function __construct($marca, $modelo, $potencia, $enemigos_abatidos, $danio_sufrido){
		parent::__construct($marca, $modelo, $potencia);
		$this->enemigos_abatidos = $enemigos_abatidos;
		$this->danio_sufrido = $danio_sufrido;
		$this->puntos = ($enemigos_abatidos * 10) + ($danio_sufrido * 5);
	}

	function getenemigos_abatidos(){
		return $this->enemigos_abatidos;
	}

	function setenemigos_abatidos($enemigos_abatidos){
		$this->enemigos_abatidos = $enemigos_abatidos;
	}

	function getdanio_sufrido(){
		return $this->danio_sufrido;
	}

	function setdanio_sufrido($danio_sufrido){
		$this->danio_sufrido = $danio_sufrido;
	} 

	function calcularPuntos($enemigos_abatidos, $danio_sufrido) {
        $this->puntos = ($enemigos_abatidos * 10) + ($danio_sufrido * 5);
    }

	function __toString(){
		return "Guerrero: ".parent::__toString()." | Enemigos abatidos: ".$this->enemigos_abatidos." | Daño sufrido: ".$this->danio_sufrido."<br> | Puntos ganados: ".$this->puntos."<br>";
	}
}
?>