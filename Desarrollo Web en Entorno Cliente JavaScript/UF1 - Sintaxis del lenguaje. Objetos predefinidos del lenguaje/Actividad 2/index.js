crearCookie("nombre", "Juan", 7);

function crearCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    let expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }

function abrirNuevaVentana(url, nombre) {
    window.open (url,nombre,"scrollbars=no,width=200");
}

function cambiarColorDeFondo() {
    var listaColores = ['red', 'blue', 'yellow', 'purple', 'pink']
    var valores = Math.floor(Math.random() * listaColores.length);
    var color = listaColores[valores];
    document.body.style.backgroundColor = color;
}