function botonbienvenida() {
    var nombre = prompt("Introduce tu nombre:");
    console.log("¡Hola " + nombre + "!");
}

function botonarray() {
    var numeros = ["5", "3", "2", "4", "1"];
    for (let index = 0; index < numeros.length; index++) {
        const element = numeros[index];
        console.log(element);
    }
}

function botonfactorial() {
    var numerointroducido = prompt("Introduce un número:");
    var numerofactorial = numerointroducido;
    var resultado = 1;
    while (numerofactorial > 0) {
        var resultado = resultado * numerofactorial;
        numerofactorial--;
    }
    console.log("El factorial de " + numerointroducido + " es: " + resultado);
}

function botonedad() {
    var edad = prompt("Introduce tu edad:");
    if (edad > 17) {
        alert("Eres mayor de edad");
    } else {
        alert("Eres menor de edad");
    }
}