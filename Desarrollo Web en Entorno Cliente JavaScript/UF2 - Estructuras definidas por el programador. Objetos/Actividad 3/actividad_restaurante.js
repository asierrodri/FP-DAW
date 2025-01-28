/**EJERCICIO2: Crea una nueva clase llamada "Plato" para almacenar: el nombre del plato, su descripción, el precio y una función "getHTML()" que al ejecutarse retorne un código HTML con la información del plato en forma de tarjeta.**/

class Plato {
    constructor(nombre, descripcion, precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    getHTML() {
        return `
                    <div class="plato">
                        <h3>${this.nombre}</h3>
                        <p>${this.descripcion}</p>
                        <span class="precio">${this.precio}€</span>
                    </div>
                `;
    }
}

/**EJERCICIO3: Una vez realizada la clase "Plato", deberá ser capaz de validar el siguiente código: */

let plato1 = new Plato("Hamburguesa", "Deliciosa hamburguesa con carne jugosa y queso derretido", 10);
console.log(plato1.getHTML());

/**EJERCICIO4: Crea un objeto "Menu" que almacene: el nombre del menú, una array vacía de platos, una función que reciba un plato y lo añada a su array, y una función que retorne un código HTML con los datos del menú y los platos asociados, tal y como se ha hecho en el ejercicio 2. */

class Menu {
    constructor(nombre) {
        this.nombre = nombre;
        this.platos = [];
    }

    addPlato(plato) {
        this.platos.push(plato);
    }

    getHTML() {
        let platosHTML = "";
        this.platos.forEach(plato => {
            platosHTML += plato.getHTML();
        });

        return `
            <div class="menu">
                <h2>${this.nombre}</h2>
                <div class="platos">${platosHTML}</div>
            </div>
        `;
    }
}

/**EJERCICIO5: Una vez realizada la clase "Menu", deberá ser capaz de validar el siguiente código: */

let menu1 = new Menu("Menú del día");
menu1.addPlato(plato1);
console.log(menu1.getHTML());

/**EJERCICIO6: Crea un array global llamado "platosDisponibles" para almacenar todos los platos disponibles y añádele el plato creado anteriormente y otro plato nuevo. */

var platosDisponibles = [];

platosDisponibles.push(plato1);

let plato2 = new Plato("Pizza", "Sabrosa pizza con una variedad de ingredientes frescos", 12.5);

platosDisponibles.push(plato2);
menu1.addPlato(plato2);

console.log(platosDisponibles[0].getHTML());
console.log(platosDisponibles[1].getHTML());

/**EJERCICIO7: Programa que una vez cargada la web llame a una función "mostrarPlatos()" que muestre en el HTML todos los platos que contiene "platosDisponibles". */

function mostrarPlatos() {
    var platosHTML ="";
    platosDisponibles.forEach(plato => {
        platosHTML += plato.getHTML();
    });
    document.getElementById("platos").innerHTML = platosHTML;
    selectPlatos();
}
mostrarPlatos();

/**EJERCICIO8: Crea un array asociativo global llamado "menusDisponibles" para almacenar todos los menús creados según su nombre y añádele el menú creado anteriormente. */

var menusDisponibles = {};

menusDisponibles[menu1.nombre] = menu1;

/**EJERCICIO9: Programa que una vez cargada la web llame a una función "mostrarMenus()" que muestre en el HTML todos los menús (con sus platos asociados) que contiene "menusDisponibles". */

function mostrarMenus() {
    var menusHTML = "";
    for (let menu in menusDisponibles) {
        menusHTML += menusDisponibles[menu].getHTML();
        }
    document.getElementById("menus").innerHTML = menusHTML;
}
mostrarMenus();

/**EJERCICIO10: Crea la estructura HTML que se muestra a continuación y programa el botón "AÑADIR PLATO" para que añada a "platosDisponibles" un nuevo plato con el nombre, descripción y precio indicados, y actualice visualmente todos los platos disponibles (llama a "mostrarPlatos()"). */

function addPlato() {
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;
    var precio = document.getElementById("precio").value;

    let plato = new Plato(nombre, descripcion, precio);

    platosDisponibles.push(plato);

    mostrarPlatos();
}

/**EJERCICIO11: Crea la estructura HTML que se muestra a continuación y programa el botón "ELIMINAR" para que borre del array "platosDisponibles" el plato seleccionado según su posición y actualice visualmente todos los platos disponibles (llama a "mostrarPlatos()"). */

function selectPlatos() {
    var select = document.getElementById("selectPlatos");
    select.innerHTML = "";

    platosDisponibles.forEach((plato, index) => {
        var option = document.createElement("option");
        option.value = index;
        option.textContent = `${plato.nombre}`;
        select.appendChild(option);
    });
}

function deletePlato() {
    var select = document.getElementById("selectPlatos");
    var index = select.value;

    platosDisponibles.splice(index, 1);
    mostrarPlatos();
}

/**EJERCICIO12: Crea la estructura HTML que se muestra a continuación y programa el botón "AÑADIR MENÚ" para que añada a "menusDisponibles" un nuevo menú con el nombre indicado y actualice visualmente todos los menús disponibles (llama a "mostrarMenus()"). */

function addMenu() {
    var nombreMenu = document.getElementById("nombreMenu").value;

    let menu = new Menu(nombreMenu);

    menusDisponibles[nombreMenu] = menu;

    mostrarMenus();
}