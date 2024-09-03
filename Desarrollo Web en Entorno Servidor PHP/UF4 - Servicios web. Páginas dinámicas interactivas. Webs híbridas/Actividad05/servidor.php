<?php
require_once("lib/nusoap.php");
require_once("datos.php");

//CONFIGURCIÓN DEL SERVIDOR
$namespace = "http://localhost/actividades/Actividad05/servidor.php";
$server = new soap_server();
$server->configureWSDL("Mi super servicio web", $namespace);
$server->soap_defencoding = "UTF-8";

//FUNCIONES DEL SERVIDOR
function insertarGrupos($nombre, $genero){
	$con = mysqli_connect($GLOBALS['host'], $GLOBALS['username'], $GLOBALS['pass'], $GLOBALS['dbname']);
	mysqli_query($con, "insert into grupo values(0, '$nombre', '$genero')");
	mysqli_close($con);
}

function mostrarGeneros(){
	$misGeneros = array();
	$con = mysqli_connect($GLOBALS['host'], $GLOBALS['username'], $GLOBALS['pass'], $GLOBALS['dbname']);
	$generos = mysqli_query($con, "select * from genero");
	while($genero = mysqli_fetch_assoc($generos)){
		$misGeneros[] = $genero;
	}
	mysqli_close($con);
	return $misGeneros;
}

function mostrarGrupos($genero){
	$misGrupos = array();
	$con = mysqli_connect($GLOBALS['host'], $GLOBALS['username'], $GLOBALS['pass'], $GLOBALS['dbname']);
	$grupos = mysqli_query($con, "select nombre from grupo where genero=$genero;");
	while($grupo = mysqli_fetch_assoc($grupos)){
		$misGrupos[] = $grupo;
	}
	mysqli_close($con);
	return $misGrupos; 
}

//DEFINICIÓN DE TIPOS COMPLEJOS
$server->wsdl->addComplexType(
	'Genero',					//name
	'complexType',			//typeClass
	'struct',				//PHPClass: array | struct (array asociativo)
	'all',				//compositor: sequence | all | choice
	'',						//restrictionBase
	array(					//elements
		'id_genero'=>array('name'=>'id_genero', 'type'=>'xsd:int'),
		'nombre'=>array('name'=>'nombre', 'type'=>'xsd:string'))
);

$server->wsdl->addComplexType(
	'ArrayGeneros',
	'complexType',
	'array',
	'',
	'SOAP-ENC:Array',
	array(),
	array(array('ref'=>'SOAP-ENC:arrayType', 'wsdl:arrayType'=>'tns:Genero[]'))
);

$server->wsdl->addComplexType(
	'Grupo',					//name
	'complexType',			//typeClass
	'struct',				//PHPClass: array | struct (array asociativo)
	'all',				//compositor: sequence | all | choice
	'',						//restrictionBase
	array(					//elements
		'id_grupo'=>array('name'=>'id_grupo', 'type'=>'xsd:int'),
		'nombre'=>array('name'=>'nombre', 'type'=>'xsd:string'),
		'genero'=>array('name'=>'genero', 'type'=>'xsd:int'))
);

$server->wsdl->addComplexType(
	'ArrayGrupos',
	'complexType',
	'array',
	'',
	'SOAP-ENC:Array',
	array(),
	array(array('ref'=>'SOAP-ENC:arrayType', 'wsdl:arrayType'=>'tns:Grupo[]'))
);

//REGISTRO DE FUNCIONES EN EL SERVIDOR
$server->register(
	'insertarGrupos',								//Nombre de la función a ejecutar
	array('nombre' =>'xsd:string', 'genero'=>'xsd:int'),									//Parámetros de entrada
	array(),				//Valores devueltos
	$namespace,
	false,										//soapaction
	'rpc',										//Cómo se envían los mensajes
	'encoded',									//Serialización
	'Función que inserta nuevos grupos de música en la base de datos'
);

$server->register(
	'mostrarGeneros',										//Nombre de la función a ejecutar
	array(),		//Parámetros de entrada
	array('return'=>'tns:ArrayGeneros'),					//Valores devueltos
	$namespace,
	false,										//soapaction
	'rpc',										//Cómo se envían los mensajes
	'encoded',									//Serialización
	'Función que devuelve un array con todos los géneros de la base de datos'
);

$server->register(
	'mostrarGrupos',										//Nombre de la función a ejecutar
	array('genero'=>'xsd:int'),		//Parámetros de entrada
	array('return'=>'tns:ArrayGrupos'),					//Valores devueltos
	$namespace,
	false,										//soapaction
	'rpc',										//Cómo se envían los mensajes
	'encoded',									//Serialización
	'Función que devuelve un array con todos los nombres de los grupos que coinciden con el género pasado por parámetro'
);

$server->service(file_get_contents("php://input"));
?>