(:1. Muestra todos los antihéroes que tienen una fuerza mayor a la media. muéstralo con XPATH y FLWOR.:)

(:for $x in doc("Antiheroes.xml")/antiheroes/antiheroe
where $x/fuerza>avg(/antiheroes/antiheroe/fuerza)
return $x/nombre:)

(:2. Muestra los antihéroes clasificados por Poder en una tabla HTML, mostrando el nombre, el poder y la fuerza.:)

(:<html>
  <body>
    <h1>Tabla de Antiheroes</h1>
    <table border="1">
      <tr>
        <th>Nombre</th>
        <th>Poder</th>
        <th>Fuerza</th>
      </tr>
      {
        for $x in doc("Antiheroes.xml")/antiheroes/antiheroe
        order by $x/poder
        return
          <tr>
            <td>{$x/nombre}</td>
            <td>{$x/poder}</td>
            <td>{$x/fuerza}</td>
          </tr>
      }
    </table>
  </body>
</html>
:)

(:3. Realizar una inserción de un nuevo antihéroe.:)

(:insert node <antiheroe id="AH-0007">
  <nombre>Bob Esponja</nombre>
  <codigo>AH-0007</codigo>
  <sexo>H</sexo>
  <poder>Regeneracion</poder>
  <fuerza>1</fuerza>
  <comentario>Vive en una piña debajo del mar.</comentario>
  </antiheroe>
as last into doc("Antiheroes.xml")/antiheroes:)

(:4. Modifica la fuerza de todos incrementándola en un 10%.:)

(:for $x in doc("Antiheroes.xml")/antiheroes/antiheroe
return ($x/antiheroe, $x/fuerza * 1.1):)

(:5. Elimina el antihéroe con menos fuerza.:)

(:delete node
doc("Antiheroes.xml")/antiheroes/antiheroe[2]:)

(:6. Mostar con XPATH el nombre del antihéroe con la fuerza más alta.:)

(:/antiheroes/antiheroe[fuerza = max(/antiheroes/antiheroe/fuerza)]/nombre:)

(:7. Mostar con FLWOR el nombre del antihéroe con menor fuerza.:)

(:for $x in doc("Antiheroes.xml")/antiheroes/antiheroe
where $x/fuerza=min(/antiheroes/antiheroe/fuerza)
return $x/nombre:)

(:8. Mostrar el nombre, el poder y la fuerza con un 5% menos.:)

(:for $x in doc("Antiheroes.xml")/antiheroes/antiheroe
return ($x/nombre, $x/poder, $x/fuerza * 0.95):)

(:9. Mostrar una lista en HTML con el título, poder y su fuerza.:)

(:<html>
  <body>
    <h1>Tabla de Antiheroes</h1>
    <table border="1">
      <tr>
        <th>Poder</th>
        <th>Fuerza</th>
      </tr>
      {
        for $x in doc("Antiheroes.xml")/antiheroes/antiheroe
        return
          <tr>
            <td>{$x/poder}</td>
            <td>{$x/fuerza}</td>
          </tr>
      }
    </table>
  </body>
</html>
:)

(:10. Modifica el poder de un superhéroe.:)

(:replace value of node
doc("Antiheroes.xml")/antiheroes/antiheroe[1]/poder with "Bromista":)
