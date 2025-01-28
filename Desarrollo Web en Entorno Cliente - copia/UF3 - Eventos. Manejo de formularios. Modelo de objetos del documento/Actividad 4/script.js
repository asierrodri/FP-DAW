function agregarAlumno() {

    var formulario = document.forms[0];

    var nombre = formulario["nombre"].value;
    var edad = formulario["edad"].value;
    var curso = formulario["curso"].value;

    if (nombre == "" || edad == "" || curso == "") {
        alert("Hay que rellenar todos los campos")
    }
    else {
        var listaAlumno = document.createElement("li");
        listaAlumno.textContent = nombre + " - " + edad + " años - " + curso + "º curso";
    
        document.querySelector("#lista-alumnos").appendChild(listaAlumno);
    
        formulario["nombre"].value = "";
        formulario["edad"].value = "";
        formulario["curso"].value = "";
    }
}

function eliminarAlumno() {
    document.querySelector("#lista-alumnos").firstChild.remove();
}

var elementoActual = 0;
function navegarElementos(direccion) {
    var listaAlumnos = document.querySelector('#lista-alumnos');

    if (elementoActual == 0) {
        elementoActual = listaAlumnos.firstElementChild;
        elementoActual.style.backgroundColor = 'white';
        return;
    }

    elementoActual.style.backgroundColor = '';

    var siguienteElemento = elementoActual.nextElementSibling;
    var anteriorElemento = elementoActual.previousElementSibling;

    if (direccion === 'siguiente') {
        elementoActual = siguienteElemento || listaAlumnos.firstElementChild;
    } else if (direccion === 'anterior') {
        elementoActual = anteriorElemento || listaAlumnos.lastElementChild;;
    }

    elementoActual.style.backgroundColor = 'white';
}