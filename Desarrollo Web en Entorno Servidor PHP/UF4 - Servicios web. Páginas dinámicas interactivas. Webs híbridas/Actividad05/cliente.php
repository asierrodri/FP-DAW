<?php
require_once("lib/nusoap.php");

$client = new soapclient('http://localhost/actividades/Actividad05/servidor.php?wsdl');

?>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #333;
        color: white;
        padding: 10px;
        text-align: center;
    }

    section {
        width: 80%;
        margin: 20px auto;
    }

    h2, h3 {
        color: #333;
    }

    p {
        color: #777;
    }

    form {
        margin-top: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table, th, td {
        border: 1px solid #ccc;
    }

    th {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
    }

    td, th {
        padding: 8px;
        text-align: left;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        cursor: pointer;
        border: none;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .logout {
        position: absolute;
        top: 10px;
        right: 10px;
        color: white;
        text-decoration: none;
        background-color: #4CAF50;
        padding: 5px 10px;
        border-radius: 5px;
    }

    select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
</style>

<?php
echo "<form method='POST' action='servidor.php'>
<fieldset>
<legend>Agregar grupos</legend>
Nombre del Grupo: <input type='text' name='grupo'><br>
Género: <select name='genero'><br>";
$result = $client->mostrarGeneros();
foreach($result as $genero){
        echo "<option value='$genero->id_genero'>$genero->nombre</option>";
}
echo "</select><br>
</fieldset>
<input type='submit' value='Añadir' name='Añadir'/>
</form>";

if (isset($_POST["Añadir"])){
    $generoSeleccionado = $_POST['genero'];
    $nombreGrupo = $_POST['grupo'];
    $client->insertarGrupos($nombreGrupo, $generoSeleccionado);
}

echo "<h3>Grupos por Género</h3>";
echo "<form method='POST' action='servidor.php'>";
echo "Género:<select name='genero'>";
$result = $client->mostrarGeneros();
foreach($result as $genero){
    echo "<option value='$genero->id_genero'>$genero->nombre</option>";
}
echo "</select><br>";
echo "<input type='submit' value='Mostrar' name='Mostrar'/></form>";
echo "<br/>";

if (isset($_POST["Mostrar"])){
    $generoSeleccionado = $_POST['genero'];
    $result = $client->mostrarGrupos($generoSeleccionado);
    echo "<table border='1'>";
    foreach($result as $grupo){
	echo "<tr><td>$grupo->nombre</td></tr>";
    }
echo "</table>";
}
?>