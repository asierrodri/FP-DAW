<?php
session_start();
?>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            width: 300px;
            margin: 20px auto;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        fieldset {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 15px;
        }

        legend {
            font-weight: bold;
            color: #333;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
	<form method="POST" action="".$_SERVER['PHP_SELF']."">
        <fieldset>
            <legend>Parking</legend>
            Aparcar coche<input type="radio" value="aparcar" name="operacion"/><br>
            Retirar coche<input type="radio" value="retirar" name="operacion"/><br>
            Visualizar estado del parking<input type="radio" value="visualizar" name="operacion"/><br>
        </fieldset>

<?php
if(isset($_POST['operacion']) && ($_POST['operacion'] == 'aparcar')){
		echo '<fieldset>';
        echo '<legend>Aparchar coche</legend>';
        echo 'Coche grande<input type="radio" value="coche_grande" name="tamanio_coche"/><br>';
        echo 'Coche pequeño<input type="radio" value="coche_pequenio" name="tamanio_coche"/><br>';
        echo '</fieldset>';
}
?>

<?php
if(isset($_POST['operacion']) && ($_POST['operacion'] == 'retirar')){
		echo '<fieldset>';
        echo '<legend>Retirar coche</legend>';
        echo 'Plaza grande<input type="radio" value="plaza_grande" name="tamanio_plaza"/><br>';
        echo 'Plaza pequeña<input type="radio" value="plaza_pequenia" name="tamanio_plaza"/><br>';
        echo 'Numero de plaza<input type="number" name="numero_plaza" min="1" max="14"/><br>';
        echo '</fieldset>';
}
?>

		<input type="submit" name="enviar"/>

	</form>

<?php
require 'utils/visualizar.php';

if (isset($_POST['enviar'])) {
    if (isset($_POST['operacion']) && $_POST['operacion'] == 'visualizar') {
        visualizar_estado_parking();
    }
}
?>
</body>
</html>