$(document).ready(function () {
    $(".modal").hide();

});

function mostrar() {
    $(".modal").show();
}

function validarRegistro(identificador, pwd1, pwd2, colegio, correo) {
    if ((identificador != "") && (colegio != "") && (pwd1 != "") && (pwd2 != "") && (correo != "")) {
        if (pwd1 == pwd2) {
            var parametros = {
                "identificador": identificador,
                "colegio": colegio,
                "pwd2": pwd2,
                "pwd3":correo

            };
            $.ajax({
                data: parametros,
                url: "Registro",
                type: "POST"

            }).done(function (response) {
                console.log(response);
                var valor = [];
                valor = response;
                if (valor[0] == true) {
                    alert("Usuario registrado satisfactoriamente ahora puede iniciar sesión");
                    window.location.href = "#about";
                } else {
                    if (valor[0] == false) {
                        alert("Usted no se encuentra asociado a esta institución");
                    } else {
                        alert("Problemas durante el registro");
                    }
                }
            });

        } else {
            alert("Las claves no coinciden");
        }
    } else {
        alert("Debe llenar los campos");
    }
}

function iniciarSesion() {

    var parametros = {
        "valor1": $('#campo1').val(),
        "valor2": $('#campo2').val()
    };

    if ($('#campo2').val() != "null") {


        $.ajax({
            data: parametros,
            url: "Inicio",
            type: "POST"

        }).done(function (data) {
            console.log(data);
            if ($.isEmptyObject(data)) {
                alert("Usuario y/o contraseña incorrectos");
            } else {
                if (data.tipo == "Estudiante" || data.tipo == "Docente") {
                    window.location.href = "Usuario/homeUser.jsp";
                }
                if (data.tipo == "Directivo" || data.tipo == "Administrativo") {
                    window.location.href = "Admin/homeAdmin.jsp";
                }
            }
        });
    }else{
        alert("Usuario y/o contraseña incorrectos");
        alert("Esta seguro de que ya se ha registrado");
    }
    

}
