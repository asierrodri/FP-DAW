<?php
require_once("personaje.php");
class Mago extends Personaje{
	private $secretos_descubiertos;
	private $hechizos_lanzados;

	function __construct($marca, $modelo, $potencia, $secretos_descubiertos, $hechizos_lanzados){
		parent::__construct($marca, $modelo, $potencia);
		$this->secretos_descubiertos = $secretos_descubiertos;
		$this->hechizos_lanzados = $hechizos_lanzados;
		$this->puntos = ($secretos_descubiertos * 5) + ($hechizos_lanzados * 10);
	}

	function getsecretos_descubiertos(){
		return $this->secretos_descubiertos;
	}

	function setsecretos_descubiertos($secretos_descubiertos){
		$this->secretos_descubiertos = $secretos_descubiertos;
	}

	function gethechizos_lanzados(){
		return $this->hechizos_lanzados;
	}

	function sethechizos_lanzados($hechizos_lanzados){
		$this->hechizos_lanzados = $hechizos_lanzados;
	}

	function calcularPuntos($secretos_descubiertos, $hechizos_lanzados) {
        $this->puntos = ($secretos_descubiertos * 5) + ($hechizos_lanzados * 10);
    }

	function __toString(){
		return "Mago: ".parent::__toString()." | Secretos descubiertos: ".$this->secretos_descubiertos." | Hechizos lanzados: ".$this->hechizos_lanzados."<br> | Puntos ganados: ".$this->puntos."<br>";
	}
}
?>