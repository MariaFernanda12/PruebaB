<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Library Soft</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link href="../CSS/layout.css" rel="stylesheet" type="text/css" media="all">
        <script type="text/javascript" src="../scripts/jquery.min.js"></script>
        <script type="text/javascript" src="../scripts/scriptHome.js"></script>
        <link href="../CSS/mystyle.css" rel="stylesheet" type="text/css">
        <link rel="shortcut icon" href="../Images/icono.png">   
        <script>
            var etiqueta;
            $(document).ready(function () {
                $(".modal").hide();
            });
            function mostrar() {
                $(".modal").show();
            }
            window.setTimeout("document.getElementById('contenedor_carga').style.display='none';", 1500);
            $(document).ready(function () {
                obtenerData();
            });
            function obtenerData() {
                var indic = 1;
                $.ajax({
                    type: 'GET'
                    , url: "../BuscarElementoPorNombre"
                    , async: true
                    , cache: false
                    , success: function (resp) {
                        $.each(resp, function (indice, inventario) {
                            $("#tabla").append($("<tr id='" + indic + "' onclick='pp(this);'> ").append(("<td>" + inventario.etiqueta + "</td>" + "<td>" + inventario.nombre + "</td>" + "<td>" + inventario.cantidadDisponible + "</td>" + "<td>" + inventario.ubicacion + "</td>" + "<td>" + inventario.propiedad + "</td>" + "<td>" + inventario.responsable + "</td>" + "<td>" + inventario.area + "</td>" + "<td>" + inventario.colegio + "</td>")))
                            indic++;
                        });
                    }
                });
            }
            function pp(x) {
                var y = x.rowIndex;
                var parametros = {
                    "identificador": y
                };
                $.ajax({
                    data: parametros,
                    url: "../Reservas",
                    type: "POST"
                }).done(function (response) {
                    console.log(response);
                    var cantidad = response.cantidadDisponible;
                    window.location.href = "#about";
                    document.getElementById('element').innerHTML = response.etiqueta;
                    etiqueta = response.etiqueta;
                    document.getElementById('nombreLibro').innerHTML = response.nombre;
                    document.getElementById('cantidad').innerHTML = response.cantidadDisponible;
                    var input = document.getElementById("campo1");
                    input.setAttribute("max", cantidad);
                    mostrar();
                    getUser2();
                });
            }
            function Buscar() {
                var tableReg = document.getElementById('tabla');
                var searchText = document.getElementById('Busqueda').value.toLowerCase();
                var cellsOfRow = "";
                var found = false;
                var compareWith = "";
                for (var i = 1; i < tableReg.rows.length; i++)
                {
                    cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
                    found = false;
                    // Recorremos todas las celdas
                    for (var j = 0; j < cellsOfRow.length && !found; j++)
                    {
                        compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                        // Buscamos el texto en el contenido de la celda
                        if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1))
                        {
                            found = true;
                        }
                    }
                    if (found)
                    {
                        tableReg.rows[i].style.display = '';
                    } else {
                        tableReg.rows[i].style.display = 'none';
                    }
                }
            }
            function getUser2() {
                $.ajax({
                    url: "../Sesion",
                    type: "GET"
                }).done(function (response) {
                    console.log(response);
                    if (response == "false") {
                        window.location.href = "index.html";
                    } else {
                        document.getElementById('ident2').innerHTML = response.identificador;
                        document.getElementById('nombre2').innerHTML = response.nombreSol;
                        document.getElementById('curso2').innerHTML = response.cursoArea;
                    }
                });
            }
            function Reserva(fechaRes, cantidad) {
                $.ajax({
                    url: "../Sesion",
                    type: "GET"
                }).done(function (response) {
                    console.log(response);
                    if (response == "false") {
                        window.location.href = "index.html";
                    } else {
                        idSol = response.identificador;
                        curso = response.cursoArea;
                    }
                });
                var parametros = {
                    "idElm": etiqueta,
                    "fechaRes": fechaRes,
                    "cantidad": cantidad
                };
                $.ajax({
                    data: parametros,
                    url: "../Reservas",
                    type: "GET"
                }).done(function (response) {
                    console.log(response);
                    if (response != false) {
                        alert("No se pudo realizar la reserva");
                    } else {
                        alert("Reserva realizada satisfactoriamente");
                        window.location.href = "historial.html";
                    }
                });
            }
        </script>
    </head>
    <body id="top">
        <div id="contenedor_carga">
            <img src="../Images/titulo1.png" alt="Not-Found">
            <div id="carga"></div>
            <div class="tag">
                <p>Cargando...</p>
            </div>
        </div>
        <div class="wrapper row0">
            <div class="page-container">
                <div id="topbar" class="hoc clear">
                    <ul>
                        <li><p>Usuario:</p></li>
                        <li><p id="ident"></p></li>
                        <li><p id="nombre"></p></li>
                        <li><p id="col"></p></li>
                        <li><p id="curso"></p></li>
                        <li><a onclick="closeSesion();" title="Cerrar Sesión"><i class="fa fa-lg fa-power-off"></i></a></li>
                        <li><a href="perfil.jsp"  title="Mi Perfil"><img alt="NotFound" id="imageUser" /></a></li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="wrapper row1">
            <header id="header" class="hoc clear">
                <div id="logo" class="fl_center">
                    <a href="homeUser.html"><img id="imagenPrincipal" src="../Images/titulo1.png" alt=""></a>
                </div>

            </header>
        </div>
        <div id="a" class="bgded" style="background-image:url('../Images/background4.jpg');">
            <div class="wrapper row2">
                <nav id="mainav" class="hoc clear"> 
                    <ul class="clear">
                        <li><a href="homeUser.jsp">Home</a></li>                       
                        <li><a href="Listados.html">Inventario Disponible</a></li>
                        <li class="active"><a href="reservas.jsp">Reservas</a></li>
                        <li><a href="historial.html">Historial</a></li>
                        <li><a href="Busquedas.html">Busquedas</a></li>
                        <li><a href="#">Convenios</a></li>
                    </ul>
                </nav>
            </div>
            <div class="wrapper overlay">
                <div id="breadcrumb" class="hoc clear"> 
                    <h1 style="font-size: 62px">Reservas</h1>
                </div>
            </div>

            <div class="wrapper row3">
                <main class="hoc container clear"> 
                    <div class="content">
                        <div>
                            <input id="Busqueda"  onkeyup="Buscar()" class="btmspace-15" type="text" style="width: 70%; margin-left: 15%; text-align: center;"  placeholder="Busca el Library soft">
                        </div>
                        <table border="1" id="tabla">
                            <thead>
                                <tr>
                                    <th>Etiqueta</th>
                                    <th>Nombre</th>
                                    <th>CantidadDisponible</th>
                                    <th>Ubicacion</th>
                                    <th>Propiedad</th>
                                    <th>Responsable</th> 
                                    <th>Area</th>
                                    <th>Colegio</th>

                                </tr>
                            </thead>

                        </table>
                    </div>
                </main>
            </div>
        </div>
        <span id="start" class="target"></span>
        <span id="about" class="target"></span>
        <div class="modal" style="overflow: auto">
            <div class="content">
                <div class="reserv">

                    <h1 class="heading">Reservar en Library-Soft</h1>
                    <p style="color: black; text-align: center; font-size: 22px;">inventario:</p>
                    <p style="color: black; text-align: center" id="nombreLibro"></p>
                    <p style="color: black; text-align: center; font-size: 22px;">Id del libro:</p>
                    <p style="color: black; text-align: center" id="element"></p>
                    <p style="color: black; text-align: center; font-size: 22px;">Reservado por:</p>                   
                    <p style="color: black; text-align: center" id="nombre2"></p>
                    <p style="color: black; text-align: center" id="ident2"></p>
                    <p style="color: black; text-align: center; font-size: 22px;">Curso:</p>     
                    <p style="color: black; text-align: center" id="curso2"></p>
                    <p style="color: black; text-align: center; font-size: 22px;">Cantidad Disponible:</p>   
                    <p style="color: black; text-align: center" id="cantidad"></p>
                    <input id="campo1" type="number" min="1" placeholder="Cantidad a reservar" onkeydown="return false">
                    <p style="color: black; text-align: center; font-size: 22px;">Fecha de entrega:</p> 
                    <input id="campo2" type="date" placeholder="Fecha solicitada">
                    <button id="ingresar" onclick="Reserva($('#campo2').val(), $('#campo1').val());" type="button">Reservar</button>

                </div>
                <a class="close-btn" href="#start"><i class=" fa fa-lg fa-times-circle"></i></a>
            </div>
        </div>

        <div class="wrapper row5">
            <div id="copyright" class="hoc clear">
                <p>LibrarySoft &copy; 2017 - Todos los derechos reservados - <a href="#">www.librarysoft.com.co</a></p>
            </div>
        </div>
        <a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
        <!-- JAVASCRIPTS -->
        <script language="JavaScript" type="text/javascript" src="../scripts/jquery.min.js"></script>
        <script language="JavaScript" type="text/javascript" src="../scripts/jquery.backtotop.js"></script>
        <script language="JavaScript" type="text/javascript" src="../scripts/jquery.mobilemenu.js"></script> 
    </body>
</html>