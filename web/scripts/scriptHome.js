$(document).ready(function () {
    getUser();

});
function getUser() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if ($.isEmptyObject(response)) {
            window.location.href = "../index.html";
        } else {
            document.getElementById('ident').innerHTML = response.identificador;
            document.getElementById('nombre').innerHTML = response.nombreSol;
            document.getElementById('col').innerHTML = response.colegio;
            document.getElementById('curso').innerHTML = response.cursoArea;
            var imagen = document.getElementById("imageUser");
            imagen.src = response.imagen;
        }
    });
}
function closeSesion() {
    $.ajax({
        url: "../CloseSesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "../index.html";
        }
    });
}






