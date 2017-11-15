window.onload = function () {
    $(".modal").hide();
    document.getElementById("divPass").style.display = "none";
    $("#pwd1").focus(function () {
        document.getElementById("divPass").style.display = "block";
    });
    $("#pwd1").blur(function () {
        document.getElementById("divPass").style.display = "none";
    });
    $("#pwd2").focus(function () {
        document.getElementById("divPass").style.display = "block";
    });
    $("#pwd2").blur(function () {
        document.getElementById("divPass").style.display = "none";
    });

    $("#pwd1").keyup(function () {
        var myInput = document.getElementById("pwd1");
        var letter = document.getElementById("letter");
        var capital = document.getElementById("capital");
        var number = document.getElementById("number");
        var length = document.getElementById("length");
        // Validate lowercase letters
        var lowerCaseLetters = /[a-z]/g;
        if (myInput.value.match(lowerCaseLetters)) {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
        } else {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        // Validate capital letters
        var upperCaseLetters = /[A-Z]/g;
        if (myInput.value.match(upperCaseLetters)) {
            capital.classList.remove("invalid");
            capital.classList.add("valid");
        } else {
            capital.classList.remove("valid");
            capital.classList.add("invalid");
        }

        // Validate numbers
        var numbers = /[0-9]/g;
        if (myInput.value.match(numbers)) {
            number.classList.remove("invalid");
            number.classList.add("valid");
        } else {
            number.classList.remove("valid");
            number.classList.add("invalid");
        }

        // Validate length
        if (myInput.value.length >= 8) {
            length.classList.remove("invalid");
            length.classList.add("valid");
        } else {
            length.classList.remove("valid");
            length.classList.add("invalid");
        }

    });

    $("#pwd2").keyup(function () {
        var myInput = document.getElementById("pwd1");
        var pass2 = document.getElementById("pwd2");
        var con = document.getElementById("coin");

        //validate coincidence
        if (myInput.value == pass2.value) {
            con.classList.remove("invalid");
            con.classList.add("valid");
        } else {
            con.classList.remove("valid");
            con.classList.add("invalid");
        }
    });

}

function mostrar() {
    $(".modal").show();
}

function validarRegistro() {
    var myInput = document.getElementById("pwd1");
    var pass2 = document.getElementById("pwd2");
    var identificador = document.getElementById("identificador");
    var colegio = document.getElementById("colegio");
    var correo = document.getElementById("pwd3");

    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;
    var emailValues = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if ((identificador.value != "") && (colegio.value != "") && (myInput.value != "") && (pass2.value != "") && (correo.value != "")) {
        if (myInput.value.match(lowerCaseLetters)) {
            if (myInput.value.match(upperCaseLetters)) {
                if (myInput.value.match(numbers)) {
                    if (myInput.value.length >= 8) {
                        if (correo.value.match(emailValues)) {
                            if (myInput.value == pass2.value) {

                                var parametros = {
                                    "identificador": identificador.value,
                                    "colegio": colegio.value,
                                    "pwd2": pass2.value,
                                    "pwd3": correo.value

                                };
                                $.ajax({
                                    data: parametros,
                                    url: "Registro",
                                    type: "POST"

                                }).done(function (response) {
                                    console.log(response);
                                    var valor = response;
                                    if (valor == true) {
                                        alert("Usuario registrado satisfactoriamente, por favor verifique su correo para terminar el registro");
                                    } else {
                                        if (valor == false) {
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
                            alert("Ingrese un correo electrónico válido");
                        }
                    } else {
                        alert("La clave debe tener mínimo 8 carácteres");
                    }
                } else {
                    alert("La clave debe contener al menos un número");
                }
            } else {
                alert("La clave debe contener al menos una letra mayúscula");
            }
        } else {
            alert("La clave debe contener al menos una letra minúscula");
        }
    } else {
        alert("Debe llenar los campos solicitados para poder registrarse");
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
                if (data.estado != "true") {
                    alert("Por favor realice la verificación por correo");
                } else {
                    if (data.tipo == "Estudiante" || data.tipo == "Docente") {
                        window.location.href = "Usuario/homeUser.jsp";
                    }
                    if (data.tipo == "Directivo" || data.tipo == "Administrativo") {
                        window.location.href = "Admin/homeAdmin.jsp";
                    }

                }

            }
        });
    } else {
        alert("Usuario y/o contraseña incorrectos");
        alert("Esta seguro de que ya se ha registrado");
    }


}





