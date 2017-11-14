$(document).ready(function () {
    mostrarPerfil();
    document.getElementById("Fotico").style.display = "none";
    document.getElementById("Password").style.display = "none";
});

function mostrarPerfil() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        document.getElementById('1').innerHTML = response.identificador;
        document.getElementById('2').innerHTML = response.nombreSol;
        document.getElementById('3').innerHTML = response.colegio;
        document.getElementById('4').innerHTML = response.tipo;
        document.getElementById('5').innerHTML = response.cursoArea;
        var imagen =  document.getElementById("ima");
        imagen.src = response.imagen;

    });

}
function activeChangeImage() {
    document.getElementById("Fotico").style.display = "block";
    $("#Password").hide();
}
function activeChangePassword() {
    document.getElementById("Password").style.display = "block";
    $("#Fotico").hide();
}
function changePassword() {

    if (($('#campo1').val() != "") && ($('#campo2').val() != "") && ($('#campo3').val() != "")) {
        var parametros = {
            "valor1": $('#campo1').val(),
            "valor2": $('#campo2').val(),
            "valor3": $('#campo3').val()
        };

        $.ajax({
            data: parametros,
            url: "../changePassword",
            type: "POST"

        }).done(function (data) {
            console.log(data);
            var usuario = data[0];
            var newPass = data[1];
            updateSession(usuario, newPass);
            alert("Clave cambiada satisfactoriamente");
            window.location.href = "perfil.jsp";


        });


    } else {
        alert("Debe llenar los campos para poder cambiar la contraseña");
    }


}
function updateSession(usuario, clave) {

    var parametros = {
        "valor1": usuario,
        "valor2": clave
    };


    $.ajax({
        data: parametros,
        url: "../Inicio",
        type: "POST"

    }).done(function (data) {
        console.log(data);
    });
}






