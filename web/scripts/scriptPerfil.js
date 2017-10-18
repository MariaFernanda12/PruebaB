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
            alert("Clave cambiada satisfactoriamente");

        });
        mostrarPerfil();

    } else {
        alert("Debe llenar los campos para poder cambiar la contraseña");
    }


}


