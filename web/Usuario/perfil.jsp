
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
        <script type="text/javascript" src="../scripts/scriptPerfil.js"></script>        
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
                        <li><a href="#miPerfil"  title="Mi Perfil"><img alt="NotFound" id="imageUser" src="index.jsp"/></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="wrapper row1">
            <header id="header" class="hoc clear">
                <div id="logo" class="fl_center">
                    <a href="homeUser.jsp"><img id="imagenPrincipal" src="../Images/titulo1.png" alt=""></a>
                </div>

            </header>
        </div>
        <section id="miPerfil">
            <div id="i" class="bgded" style="background-image:url('../Images/background3.jpg');"> 
                <div class="wrapper row2">
                    <nav id="mainav" class="hoc clear"> 
                        <ul class="clear">
                            <li><a href="homeUser.jsp">Home</a></li>                       
                            <li><a href="#" onclick="showListados();">Inventario Disponible</a></li>
                            <li><a href="reservas.jsp">Reservas</a></li>
                            <li><a href="#">Historial</a></li>
                            <li><a href="Busquedas.html">Busquedas</a></li>
                            <li><a href="#">Convenios</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="wrapper overlay">
                    <div id="breadcrumb" class="hoc clear"> 
                        <h1 style="font-size: 62px">Mi Perfil</h1>
                    </div>
                </div>

            </div>
            <div id="perfil"  class="wrapper row3">
                <table>
                    <thead>                    
                        <tr>  
                            <td><img alt="NotFound" id="ima" src="index.jsp"/></td>
                        </tr>

                    </thead>                            
                </table>
                <table>
                    <thead>                   
                        <tr>                                             
                            <td>ID: </td>
                            <td id="1"></td>
                        </tr>
                        <tr>                                             
                            <td>Contraseña: </td>
                            <td id="6"></td>
                        </tr>
                        <tr>                                             
                            <td>Nombre: </td>
                            <td id="2"></td>
                        </tr>

                        <tr>                                             
                            <td>Colegio: </td>
                            <td id="3"></td>
                        </tr>
                        <tr>                                             
                            <td>Tipo de Usuario: </td>
                            <td id="4"></td>
                        </tr>

                        <tr>                                             
                            <td>Curso: </td>
                            <td id="5"></td>
                        </tr> 
                    </thead>                            
                </table>
                <br>
                <br>
                <a style="margin: 10px;" class="btn" href="#Password" onclick="activeChangePassword();">Cambiar Clave</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a style="margin: 10px;" class="btn" href="#Fotico" onclick="activeChangeImage();">Cambiar Imagen de Usuario</a>

                <br>
                <br>
            </div>


            <!--Cambiar foto-->

            <div id="Fotico" class="wrapper row3">



                <form action="../uploadServlet" method="POST" enctype="multipart/form-data">
                    <input style="margin: 10px; display: inline-block; padding: 8px 18px 10px; text-transform: uppercase;" type="file" name="photo" size="50">
                    <br>
                    <input class="btn" style="margin: 15px; " type="submit" value="SUBIR ARCHIVO">
                </form>

            </div>

            <!--Cambiar Clave-->
            <div id="Password" class="wrapper row3">
                <h1 class="heading">Cambiar clave en Library-Soft</h1>
                <br>
                <input id="campo1" type="text" placeholder="Contraseña Antigua">
                <input id="campo2" type="text" placeholder="Nueva Contraseña">
                <input id="campo3" type="text" placeholder="Repita Nueva Contraseña">
                <button class="btn" style="margin: 10px;" id="cambiar" onclick="changePassword();" type="button">CAMBIAR</button>
            </div>
        </section>      
        
        
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
