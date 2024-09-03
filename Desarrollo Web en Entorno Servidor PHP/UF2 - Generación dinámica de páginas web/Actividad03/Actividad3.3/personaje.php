<?php
class Personaje{
	protected $nombre;
	protected $especie;
	protected $experiencia;

	function __construct($nombre, $especie, $experiencia){
		$this->nombre = $nombre;
		$this->especie = $especie;
		$this->experiencia = $experiencia;
	}

	function getnombre(){
		return $this->nombre;
	}

	function setnombre($nombre){
		$this->nombre = $nombre;
	}

	function getespecie(){
		return $this->especie;
	}

	function setespecie($especie){
		$this->especie = $especie;
	}

	function getexperiencia(){
		return $this->experiencia;
	}

	function setexperiencia($experiencia){
		$this->experiencia = $experiencia;
	}

	function __toString(){
		return "Nombre: ".$this->nombre." | Especie: ".$this->especie." | Experiencia: ".$this->experiencia."<br>";
	}
}
?>