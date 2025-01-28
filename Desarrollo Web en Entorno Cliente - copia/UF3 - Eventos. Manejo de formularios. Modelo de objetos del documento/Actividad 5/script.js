document.getElementById("mi-formulario").addEventListener('submit', function (event) {
    event.preventDefault();
    validar();
})

function guardarReservaEnCookie() {
    let formulario = document.forms['mi-formulario'];
    let nombre = formulario['nombre'].value;
    let clase = formulario['clase'].value;
    let fecha = formulario['fecha'].value;

    
    document.cookie = `reservaNombre=${nombre}; path=/; max-age=3600`;
    document.cookie = `reservaClase=${clase}; path=/; max-age=3600`;
    document.cookie = `reservaFecha=${fecha}; path=/; max-age=3600`;

    console.log("Reserva guardada en cookies.");
    leerReservaDeCookie();
}

function validar() {
    let formulario = document.forms['mi-formulario'];

    let nombre = formulario['nombre'].value;

    if(!nombre.match(/^[A-Za-z\s]+$/)){
        document.getElementById("nombre-error").innerText = "El nombre solo puede contener letras.";
        return false;
    } else {
        document.getElementById("nombre-error").innerText = "";
    }
    alert("Reserva realizada con éxito");
    guardarReservaEnCookie();
}

function leerReservaDeCookie() {
    let cookies = document.cookie.split("; ");
    let reservaNombre = "";
    let reservaClase = "";
    let reservaFecha = "";

    cookies.forEach(cookie => {
        let [key, value] = cookie.split("=");
        if (key === "reservaNombre") {
            reservaNombre = value;
        } else if (key === "reservaClase") {
            reservaClase = value;
        } else if (key === "reservaFecha") {
            reservaFecha = value;
        }
    });

    if (reservaNombre || reservaClase || reservaFecha) {
        let reservasContenedor = document.getElementById("reservas-contenedor");
        let resultado = document.createElement("div");
        resultado.className = "reserva";
        resultado.innerHTML = `
            <ul>
                <li>Nombre: ${reservaNombre}, Clase: ${reservaClase}, Fecha: ${reservaFecha}</li>
            </ul>
        `;
        reservasContenedor.appendChild(resultado); 
    }
}
window.onload = leerReservaDeCookie;

function eliminarReserva() {
    let reservasContenedor = document.getElementById("reservas-contenedor");
    reservasContenedor.innerHTML = "";

    document.cookie = "reservaNombre=; path=/; max-age=0";
    document.cookie = "reservaClase=; path=/; max-age=0";
    document.cookie = "reservaFecha=; path=/; max-age=0";

    console.log("Reserva eliminada.");

}
