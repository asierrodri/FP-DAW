<html>
<head><title>Asier Rodriguez Murua</title>
</head>
<body>
<?php
	//Creado por Asier Rodriguez Murua

	/*1.1.	Escribir un programa en PHP que contenga una variable
	que guardará la edad de una persona en años. El programa debe
	decir si la persona se encuentra en edad de trabajar (entre 16
	y 65, guarda estos valores en constantes) y cuántos años
	faltarían para la jubilación.*/

	//Constantes
	define("EDAD_MINIMA",16);
	define("EDAD_MAXIMA",65);

	//Edad de la persona
	$edad = 25;

	//Condiciones
	if ($edad >= EDAD_MINIMA && $edad <= EDAD_MAXIMA) {
		echo "La persona se encuentra en edad de trabajar y ";
		$añosJubilacion = EDAD_MAXIMA - $edad;
		echo "le quedan $añosJubilacion años para jubilarse<br>";
	}

	else if ($edad < EDAD_MINIMA) {
		echo "La persona es demasiado joven para trabajar<br>";
	}

	else {
		echo "La persona ya está jubilada<br>";
	}

	/*1.2.	En una escuela tenemos tres clases y queremos saber la
	cantidad	de pupitres que necesitamos tener en total. Dependerá
	del número de alumnos	por aula. Hay que tener en cuenta que en
	cada pupitre caben 2 alumnos. Haz un programa en PHP en que se
	definan tres variables que contengan el número de alumnos que hay
	en cada clase, y muestre el número total de pupitres que
	necesitaremos.*/

	//Alumnos por clase
	$clase1 = 6;
	$clase2 = 45;
	$clase3 = 643;

	//Cantidad de pupitres
	$cantidadPupitres1 = round($clase1/2, 0, PHP_ROUND_HALF_UP);
	$cantidadPupitres2 = round($clase2/2, 0, PHP_ROUND_HALF_UP);
	$cantidadPupitres3 = round($clase3/2, 0, PHP_ROUND_HALF_UP);
	$pupitresTotales = $cantidadPupitres1 + $cantidadPupitres2 + $cantidadPupitres3;

	echo "La cantidad de pupitres que necesitamos en total son $pupitresTotales pupitres<br>";

	/*1.3.	Escribir un programa que guarde en tres variables los
	coeficientes de una ecuación de segundo grado. Debe guardar en
	otras dos variables los resultados, y mostrarlos por pantalla. Para
	hacer la raíz cuadrada, usar la función de PHP sqrt (número).*/

	//Ecuación de segundo grado ax^2 + bx + c = 0
	$a = 45;
	$b = 2;
	$c = 1;

	//Discriminante b^2 - 4ac
	$d = $b*$b - 4*$a*$c;

	if ($d > 0){
	//x = (-b +/-√(b^2 - 4ac)) / 2a
		$x1 = (-$b + sqrt($b*$b - 4*$a*$c))/2*$a;
		$x2 = (-$b - sqrt($b*$b - 4*$a*$c))/2*$a;
		echo "El resultado positivo sería $x1 y el negativo $x2<br>";
	}
	else if ($d == 0){
	//x = -b/2a
		$x1 = -$b/2*$a;
		echo "El resultado es $x1<br>";
	}
	else {
		echo "El resultado no es real<br>";
	}

	/*1.4.	Queremos saber si una pizza redonda es más grande que una
	rectangular. Crea un programa en que se declaren 3 variables: una
	para el radio de la pizza redonda, y las otras dos para el ancho y
	el alto de la pizza ractangular. El programa debe calcular qué
	pizza es más grande y mostrarnos un mensaje diferente para cada uno
	de los siguientes casos:
		•	La pizza redonda es más grande que la rectangular.
		•	La pizza rectangular es más grande que la redonda.
		•	Las dos pizzas son igual de grandes.*/

	$radioPizzaRedonda = 3;
	$anchoPizzaRectangular = 12;
	$altoPizzaRectangular = 2;

	//Área de un circulo a =  πr²
	$areaPizzaRedonda = M_PI * $radioPizzaRedonda * $radioPizzaRedonda;

	//Área de un rectangulo lxa
	$areaPizzaRectangular = $anchoPizzaRectangular * $altoPizzaRectangular;

	//Diferencia
	if ($areaPizzaRedonda > $areaPizzaRectangular) {
		echo "La pizza redonda es más grande que la rectangular.<br>";
	}
	else if ($areaPizzaRedonda < $areaPizzaRectangular) {
		echo "La pizza rectangular es más grande que la redonda.<br>";
	}
	else {
		echo "Las dos pizzas son igual de grandes.<br>";
	}

	/*1.5.	Una persona quiere saber si puede pagar el alquiler de un precio del centro de la ciudad. Sabemos que esta persona trabaja 7 horas diarias durante 5 días a la semana (guarda esta información en constantes). Crea un programa que guarde en tres variables lo que cobra la persona por una hora de trabajo, el precio del alquiler mensual, y los gastos aproximados mensuales que tiene esta persona en otros conceptos. El programa debe calcular si la persona puede permitirse pagar el alquiler, o no. Supón que el mes son 4 semanas.*/

	//Constantes
	define("HORAS_DIARIAS",7);
	define("DIAS_SEMANA",5);

	//Variables
	$horaTrabajo = 6;
	$precioAlquiler = 850;
	$gastoSemana = 250;

	//Sueldo y gastos mensuales
	$sueldo = (HORAS_DIARIAS * $horaTrabajo * DIAS_SEMANA) * 4;
	$gastoMensual = $precioAlquiler + $gastoSemana;

	//¿Puede permitirse el alquiler?
	if ($sueldo >= $gastoMensual) {
		echo "La persona puede permitirse pagar el alquiler<br>";
	}

	else {
		echo "La persona no puede permitirse pagar el alquiler<br>";

	}

?>
</body>
</html>