$(document).ready(function(){

    $("#botonenviar").click(function(){

        event.preventDefault();

        if($("#nombre").val() == ""){
            alert("El campo Nombre no puede estar vacío.");
            $("#nombre").focus();
        }
        else if($("#apellidos").val() == ""){
            alert("El campo Apellidos no puede estar vacío.");
            $("#apellidos").focus();
        }
        else if($("#email").val() == ""){
            alert("El campo E-mail no puede estar vacío.");
            $("#email").focus();
        }
        else if($("#email").val().indexOf("@") == -1){
            alert("El campo E-mail debe contener una '@'.");
            $("#email").focus();
        }
        else {
            $("#formdata").submit();
        }
    })
})