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
require_once("datos_conexion.php");
$con = mysqli_connect($host, $username, $password, $dbname) or die("No se ha podido conectar con la base de datos");
$tipos = mysqli_query($con, "select distinct tipo from locales");
$poblaciones = mysqli_query($con, "select distinct poblacion from locales");

echo "<form method='POST' action='mapa.php'>

<fieldset>
<legend>Elige tipo de local y poblacion:</legend>
Tipo: <select name='tipo'><br>";
while($tipo = mysqli_fetch_array($tipos)){
	extract($tipo);
    echo "<option value='$tipo'>$tipo</option>";
}
echo "</select><br>

poblacion: <select name='poblacion'><br>";
while($poblacion = mysqli_fetch_array($poblaciones)){
	extract($poblacion);
    echo "<option value='$poblacion'>$poblacion</option>";
}
echo "</select><br>
</fieldset>

<input type='submit' value='Ver Mapa' name='Enviar'/>
</form>";

?>