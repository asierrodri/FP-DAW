<?php
require_once("datos_conexion.php");
$con = mysqli_connect($host, $username, $password, $dbname) or die("No se ha podido conectar con la base de datos");
if (isset($_POST['tipo']) && isset($_POST['poblacion'])) {
    $tipo = $_POST['tipo'];
    $poblacion = $_POST['poblacion'];
}
$result = mysqli_query($con, "select * from locales where poblacion='$poblacion' and tipo='$tipo'");
$coordenadas = mysqli_query($con, "select coordenadas from locales where poblacion='$poblacion' and tipo='$tipo'");
?>

<html>
  <head>
    <title>Simple Map</title>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

    <link rel="stylesheet" type="text/css" href="./style.css" />
    <script type="text/javascript">
    	function initMap() {
		  const myLatLng = { lat: 40.416775, lng: -3.703790 };
		  const map = new google.maps.Map(document.getElementById("map"), {
		    zoom: 6,
		    center: myLatLng,
		  });

		  let misMarcadores = [];

		  <?php
		  	while($local = mysqli_fetch_array($result)){
		  		extract($local);
		  		echo "misMarcadores.push(['".$nombre."', '".$poblacion."', ".$coordenadas.", '".$tipo."']);";
		  	}
		  ?>

		  const infowindow = new google.maps.InfoWindow();

		  misMarcadores.forEach(([title, poblacion, position, type]) => {
		  	const marker = new google.maps.Marker({
			    position,
			    map,
			    title,
			  });

			  marker.addListener("click", () => {
			  	infowindow.setContent("<h3>"+title+"</h3><p>"+poblacion+"<br> "+type+"</p>");
			    infowindow.open({
			      anchor: marker,
			      map,
			    });
				fetchWeatherInfo(poblacion);
			  });
		  });
		  fetchWeatherInfo('<?php echo $poblacion; ?>');
		}

		function fetchWeatherInfo(poblacion) {
  const apiEndpoint = `https://api.openweathermap.org/data/2.5/weather?q=${poblacion}&appid=<?php echo "545a459e3e754bf15eef4eeb3ec9350d"; ?>`;
  fetch(apiEndpoint)
    .then(response => response.json())
    .then(data => {
      const weatherInfo = {
        temperature: data.main.temp,
        description: data.weather[0].description,
        icon: data.weather[0].icon,
      };

      displayWeatherInfo(weatherInfo);
    })
    .catch(error => {
      console.error('Error fetching weather data:', error);
    });
}

function displayWeatherInfo(weatherInfo) {
  const weatherContainer = document.getElementById("weather-info");

  const temperatureCelsius = (weatherInfo.temperature - 273.15).toFixed(2);

  const temperatureElement = document.createElement("p");
  temperatureElement.textContent = `Temperatura: ${temperatureCelsius} °C`;

  const descriptionElement = document.createElement("p");
  descriptionElement.textContent = `Descripcion: ${weatherInfo.description}`;

  const iconElement = document.createElement("img");
  iconElement.src = `https://openweathermap.org/img/w/${weatherInfo.icon}.png`;
  iconElement.alt = "Weather Icon";

  weatherContainer.innerHTML = '';

  weatherContainer.appendChild(temperatureElement);
  weatherContainer.appendChild(descriptionElement);
  weatherContainer.appendChild(iconElement);
}


		window.initMap = initMap;
    </script>
  </head>
  <body>
    <div id="map"></div>
	<div id="weather-info"></div>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD5WcPrK8nmVAGc8drXoH6qBe3BQ6dG9qI&callback=initMap&v=weekly"
      defer></script>
  </body>
</html>