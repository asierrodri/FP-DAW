document.getElementById("mi-formulario").addEventListener('submit', function (event) {
    event.preventDefault();
    validar();
})

function validar() {
    let formulario = document.forms['mi-formulario'];

    let nombre = formulario['nombre'].value;
    let apellido = formulario['apellido'].value;
    let correo = formulario['correo'].value;
    let password = formulario['password'].value;
    let confirmar_password = formulario['confirmar_password'].value;

    let formularioValido = true;

    document.querySelectorAll('#mi-formulario span').forEach(span => span.textContent = '');

    if (nombre.length < 2) {
        document.querySelector('#nombre + span').textContent = "El nombre debe tener al menos 2 caracteres.";
        formularioValido = false;
    }

    if (apellido.length < 2) {
        document.querySelector('#apellido + span').textContent = "El apellido debe tener al menos 2 caracteres.";
        formularioValido = false;
    }

    let correoRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!correoRegex.test(correo)) {
        document.querySelector('#correo + span').textContent = "El correo electrónico no tiene un formato válido.";
        formularioValido = false;
    }

    if (password.length < 6) {
        document.querySelector('#password + span').textContent = "La contraseña debe tener al menos 6 caracteres.";
        formularioValido = false;
    }

    if (password !== confirmar_password) {
        document.querySelector('#confirmar_password + span').textContent = "Las contraseñas no coinciden.";
        formularioValido = false;
    }


    if (formularioValido) {
        const xhr = new XMLHttpRequest();
        const formData = new FormData(formulario);

        xhr.open("POST", "registro.php", true);

        xhr.onload = function () {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);

                if (response.success) {
                    window.location.href = "registro_exitoso.php";
                }
            }
        };
        xhr.onerror = function () {
            console.error("Error al intentar conectarse al servidor.");
        };
        xhr.send(formData);
    }
}