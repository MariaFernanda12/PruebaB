<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>LibrarySoft</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <script src="../scripts/jquery.min.js"></script>
        <link href="../CSS/mystyle.css" rel="stylesheet">
        <link href="../CSS/style.css" rel="stylesheet">
        <link href="../CSS/layout.css" rel="stylesheet" type="text/css" media="all">             
        <script type="text/javascript" src="../scripts/scriptHome.js"></script>
        <link rel="shortcut icon" href="../Images/icono.png">        
        <script>
            window.setTimeout("document.getElementById('contenedor_carga').style.display='none';", 1500);
        </script>
    </head>

    <body id="top">
        <div id="contenedor_carga">
            <img src="../Images/titulo1.png" alt="">
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
                        <li><a href="perfil.jsp"  title="Mi Perfil"><img alt="NotFound" id="imageUser"/></a></li>
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
        <div id="a" class="bgded" style="background-image:url('../Images/background2.jpg');">
            <div class="wrapper row2">
                <nav id="mainav" class="hoc clear"> 
                    <ul class="clear">
                        <li class="active"><a href="homeUser.jsp">Home</a></li>                       
                        <li><a href="Listados.html">Inventario Disponible</a></li>
                        <li><a href="reservas.jsp">Reservas</a></li>
                        <li><a href="historial.html">Historial</a></li>
                        <li><a href="Busquedas.html">Busquedas</a></li>
                        <li><a href="#">Convenios</a></li>
                    </ul>
                </nav>
            </div>
            <div class="wrapper overlay">
                <article id="pageintro" class="hoc clear">
                    <h2 class="heading">Library-Soft para estudiantes y docentes</h2>
                    <p>Verifica tu actividad en Library-Soft .</p>
                    <footer><a class="btn" href="#">Bibliotecas</a></footer>
                </article>
            </div>
        </div>
        <div id="b" class="wrapper row3">
            <section class="hoc container clear" id="beneficios">
                <div class="sectiontitle">
                    <h6 class="heading">Library-Soft</h6>
                </div>
                <ul class="nospace group elements">
                    <li class="one_third first">
                        <article><a href="#"><i class="fa fa-eye"></i></a>
                            <h6 class="heading">Inventario disponible</h6>
                            <p>Revisa el inventario disponible al que puedes acceder [&hellip;]</p>
                            <footer><a href="listados.html">Go &raquo;</a></footer>
                        </article>
                    </li>
                    <li class="one_third">
                        <article><a href="#"><i class="fa fa-calendar"></i></a>
                            <h6 class="heading">Reserva libros o elementos</h6>
                            <p>Reserva un libro o elemento para poder tener prioridad sobre el  [&hellip;]</p>
                            <footer><a href="#">Go &raquo;</a></footer>
                        </article>
                    </li>
                    <li class="one_third">
                        <article><a href="#"><i class="fa fa-history"></i></a>
                            <h6 class="heading">Historial</h6>
                            <p>Revisa tu historial de prestamos activos, prestamos terminados y devoluciones [&hellip;]</p>
                            <footer><a href="#">Go &raquo;</a></footer>
                        </article>
                    </li>
                    <li class="one_third first">
                        <article><a href="#"><i class="fa fa-search"></i></a>
                            <h6 class="heading">Busquedas de libros o elementos</h6>
                            <p>Busca un libro o un elemento dentro del inventario, consulta disponibilidad y mucho más [&hellip;]</p>
                            <footer><a href="#">Go &raquo;</a></footer>
                        </article>
                    </li>
                    <li class="one_third">
                        <article><a href="#"><i class="fa fa-link"></i></a>
                            <h6 class="heading">Revisa los convenios de tu colegio</h6>
                            <p>Accede a otros libros que no posee tu institución gracias a los enlaces y convenios [&hellip;]</p>
                            <footer><a href="#">Go &raquo;</a></footer>
                        </article>
                    </li>

                </ul>
            </section>
        </div>
        <div id="c" class="wrapper bgded overlay light" style="background-image:url('../Images/black.png');">
            <figure class="hoc clear">
                <ul class="nospace group logos">
                    <li class="one_quarter first">
                        <img class="images" src="../Images/1.jpg" alt="">
                    </li>
                    <li class="one_quarter">
                        <img class="images" src="../Images/2.jpg" alt="">
                    </li>
                    <li class="one_quarter">
                        <img class="images" src="../Images/3.jpg" alt="">
                    </li>
                    <li class="one_quarter">
                        <img class="images" src="../Images/4.jpg" alt="">
                    </li>
                </ul>
            </figure>
        </div>
        <div id="d" class="wrapper row4">
            <footer id="footer" class="hoc clear">
                <div class="one_third first" style="text-align: center">
                    <h6 class="heading">Visita nuestras redes sociales</h6>
                    <ul class="faico clear">
                        <li><a class="faicon-facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a class="faicon-twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a class="faicon-linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a class="faicon-google-plus" href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a class="faicon-youtube" href="#"><i class="fa fa-youtube-play"></i></a></li>
                    </ul>
                </div>

                <div class="fl_right">
                    <h6 class="heading">Contáctanos</h6>
                    <br>
                    <ul class="linklist" style="text-align: left; margin-left: 0;">
                        <li><i class="fa fa-envelope-o"></i> librarysoftcol@gmail.com</li>
                    </ul>
                    <br>
                    <p style="padding: 0; text-align: left; font-size: 17px">Escribenos y asociate a nuestra red</p>
                    <br>
                    <form method="post" action="#" id="contacto">
                        <fieldset>
                            <input class="btmspace-15" type="text" value="" placeholder="Nombre o institución">
                            <input class="btmspace-15" type="text" value="" placeholder="Correo electrónico">
                            <textarea rows="4" cols="50" class="btmspace-15" name="comment" form="contacto" placeholder="Escriba su mensaje aquí..."></textarea>
                            <button type="submit" value="submit">Enviar</button>
                        </fieldset>
                    </form>
                </div>
            </footer>
        </div>




        <!--Footer-->

        <div class="wrapper row5">
            <div id="copyright" class="hoc clear">
                <p>LibrarySoft &copy; 2017 - Todos los derechos reservados - <a href="#">www.librarysoft.com.co</a></p>
            </div>
        </div>
        <a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

        <!--end Footer  -->

        <script language="JavaScript" type="text/javascript" src="../scripts/jquery.min.js"></script>
        <script language="JavaScript" type="text/javascript" src="../scripts/jquery.backtotop.js"></script>
        <script language="JavaScript" type="text/javascript" src="../scripts/jquery.mobilemenu.js"></script> 

    </body>    


</html>




