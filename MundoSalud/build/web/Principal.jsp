<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="description" content="MundoSalud">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>MUNDO SALUD CITAS</title>
        <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
        <link rel="icon" href="assets/img/icon.png" type="image/x-icon"/>

        <!-- Fonts and icons -->
        <script src="assets/js/plugin/webfont/webfont.min.js"></script>
        <script>
            WebFont.load({
                google: {"families": ["Lato:300,400,700,900"]},
                custom: {"families": ["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands", "simple-line-icons"], urls: ['assets/css/fonts.min.css']},
                active: function () {
                    sessionStorage.fonts = true;
                }
            });
        </script>

        <!-- CSS Files -->
        <!-- <link rel="stylesheet" type="text/css" href="assets/css/style.css"> -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/atlantis.min.css">

        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link rel="stylesheet" href="assets/css/demo.css">
    </head>
    <body>
        <div class="wrapper">
            
            <!-- Header principal -->    
                <div class="main-header">
                    <!-- Logo Header -->
                    <div class="logo-header" >
                        <a href="#" class="logo">
                            <img src="assets/img/logoMundoSalud.png" alt="MundoSalud En-Línea" class="adml navbar-brand">
                        </a>
                        <button class="navbar-toggler sidenav-toggler ml-auto" type="button" data-toggle="collapse" data-target="collapse" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon">
                                <i class="icon-menu"></i>
                            </span>
                        </button>
                        <button class="topbar-toggler more"><i class="icon-options-vertical"></i></button>
                        <div class="nav-toggle">
                            <button class="btn btn-toggle toggle-sidebar">
                                <i class="icon-menu"></i>
                            </button>
                        </div>
                    </div>
                    <!-- End Logo Header -->

                    <!-- Navbar Header -->
                    <nav class="navbar navbar-header navbar-expand-lg" data-background-color="blue2">
                        <div class="container-fluid">
                            <div class="collapse" id="search-nav">
                                <form class="navbar-left navbar-form nav-search mr-md-3">
                                    <!--                                
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <button type="submit" class="btn btn-search pr-1">
                                                <i class="fa fa-search search-icon"></i>
                                            </button>
                                        </div>
                                        <input type="text" placeholder="Buscar." class="form-control">
                                    </div>
                                    -->
                                </form>
                            </div>

                            <ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
                                <!--                            
                                <li class="nav-item toggle-nav-search hidden-caret">
                                    <a class="nav-link" data-toggle="collapse" href="#search-nav" role="button" aria-expanded="false" aria-controls="search-nav">
                                        <i class="fa fa-search"></i>
                                    </a>
                                </li>
                                <li class="nav-item dropdown hidden-caret">
                                    <a class="nav-link dropdown-toggle" href="#" id="messageDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fa fa-envelope"></i>
                                    </a>
                                    <ul class="dropdown-menu messages-notif-box animated fadeIn" aria-labelledby="messageDropdown">
                                        <li>
                                            <div class="dropdown-title d-flex justify-content-between align-items-center">
                                                Mensajes 									
                                                <a href="#" class="small">Marcar como leídos</a>
                                            </div>
                                        </li>
                                        <li> </li>
                                        <li>
                                            <a class="see-all" href="javascript:void(0);">Ver todos los mensajes<i class="fa fa-angle-right"></i> </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown hidden-caret">
                                    <a class="nav-link dropdown-toggle" href="#" id="notifDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fa fa-bell"></i>
                                        <span class="notification">0</span>
                                    </a>
                                    <ul class="dropdown-menu notif-box animated fadeIn" aria-labelledby="notifDropdown">
                                        <li>
                                            <div class="dropdown-title">Tienes 0 nuevas notificaciones</div>
                                        </li>
                                        <li></li>
                                        <li>
                                            <a class="see-all" href="javascript:void(0);">Ver todas las notificaciones<i class="fa fa-angle-right"></i> </a>
                                        </li>
                                    </ul>
                                </li>
                                -->

                                <li class="nav-item dropdown hidden-caret">
                                    <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#" aria-expanded="false">
                                        <div class="avatar-sm">
                                            <img src="assets/img/fotoUser.png" alt="..." class="avatar-img rounded-circle">
                                        </div>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user animated fadeIn">
                                        <!-- <div class="dropdown-user-scroll scrollbar-outer"> -->
                                        <li>
                                            <div class="user-box">
                                                <div class="avatar-lg"><img src="assets/img/fotoUser.png" alt="image profile" class="avatar-img rounded"></div>
                                                <div class="u-text">
                                                    <h4>${usuario.getNombre()}</h4>
                                                    <p class="text-muted">${usuario.getCorreo()}</p>
                                                    <p class="text-muted">${usuario.getNombrePerfil()}</p>
                                                    <!-- <p class="text-muted">${usuario.getIdPerfil()}</p> -->
                                                    <form action="Validar" method="POST">
                                                        <button name="accion" class="btn btn-xs btn-primary btn-sm" value="Salir">Cerrar Sesión</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <!-- 
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Mi Perfil</a>

                                            <div class="dropdown-divider"></div>
                                            <form action="Validar" method="POST">
                                                <button name="accion" class="btn btn-xs btn-primary btn-sm" value="Salir">Salir</button>
                                            </form>
                                            -->
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <!-- End Navbar -->
                </div>

            <!-- Sidebar / Barra lateral -->
            <div class="sidebar sidebar-style-2">			
                <div class="sidebar-wrapper scrollbar scrollbar-inner">
                    <div class="sidebar-content">
                        <div class="user">
                            <div class="avatar-sm float-left mr-2">
                                <img src="assets/img/fotoUser.png" alt="..." class="avatar-img rounded-circle">
                            </div>
                            <div class="info">
                                <a data-toggle="collapse" href="#collapseExample" aria-expanded="true">
                                    <span>
                                        <span class="user-level">${usuario.getNombre()}</span>
                                        <span class="user-level">${usuario.getCorreo()}</span>
                                    </span>
                                </a>
                                <div class="clearfix"></div>
                                <div class="collapse in" id="collapseExample">
                                    <ul class="nav">
                                       <!--     <li>
                                                <a href="#profile">
                                                    <span class="link-collapse">My Profile</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#edit">
                                                    <span class="link-collapse">Edit Profile</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#settings">
                                                    <span class="link-collapse">Settings</span>
                                                </a>
                                            </li> -->
                                        <li>
                                            <div class="dropdown-divider"></div>
                                            <form action="Validar" method="POST">
                                                <button name="accion" class="dropdown-item" value="Salir">Cerrar Sesión</button>
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- Panel administrativo -->
                        <ul class="nav nav-primary">
                            <li class="nav-item">
                                <c:if test="${usuario.getIdPerfil()==1}">
                                    <a href="Controlador?menu=Citas&accion=Listar" target="myFrame">
                                        <i class="fas fa-home"></i>
                                        <p>Citas</p>
                                    </a>
                                </c:if>
                            </li>
                            <li class="nav-item">
                                <c:if test="${usuario.getIdPerfil()==2}">
                                    <a href="Controlador?menu=CitasAsesor&accion=Listar&idAsesor=${usuario.getIdUsuario()}" target="myFrame">
                                        <i class="fas fa-home"></i>
                                        <p>Citas</p>
                                    </a>
                                </c:if>
                            </li>
                            <li class="nav-item">
                                <c:if test="${usuario.getIdPerfil()==3}">
                                    <a href="Controlador?menu=CitasCliente&accion=Listar&idCliente=${usuario.getIdUsuario()}&nombre=${usuario.getNombre()}" target="myFrame">
                                        <i class="fas fa-home"></i>
                                        <p>Citas</p>
                                    </a>
                                </c:if>
                            </li>
                            <li class="nav-item">
                                <!<!-- Verificar session -->
                                <c:if test="${usuario.getIdPerfil()==1}">
                                    <a href="Controlador?menu=Clientes&accion=Listar" target="myFrame">
                                        <i class="fas fa-layer-group"></i>
                                        <p>Pacientes</p>
                                    </a>
                                </c:if>
                            </li>
                            <li class="nav-item">
                                <!<!-- Verificar session -->
                                <c:if test="${usuario.getIdPerfil()==2}">
                                    <a href="Controlador?menu=ClientesVistaAsesor&accion=Listar" target="myFrame">
                                        <i class="fas fa-layer-group"></i>
                                        <p>Pacientes</p>
                                    </a>
                                </c:if>
                            </li>
                            <li class="nav-item">
                                <c:if test="${usuario.getIdPerfil()==1}">
                                    <a href="Controlador?menu=Asesores&accion=Listar" target="myFrame">
                                        <i class="fas fa-male"></i>
                                        <p>Médicos</p>
                                    </a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- End Sidebar / Fin de la barra lateral -->

            <div class="main-panel row h-100">
                <div class="my-auto mx-auto">
                    <img src="assets/img/logoMundoSalud.png" alt=""/>
                </div>
                <iframe name="myFrame" style="position: absolute;z-index: 10;top: 0; left: 0;height: 100%; width: 100%; border: none">
                </iframe>
            </div>
        <!-- End Custom template -->
        </div>
        
        <script type="text/javascript">
            
            window.onload=function(){
            document.getElementById("test").click();
            };

        </script>
        
        <!--   Core JS Files   -->
        <script src="assets/js/core/jquery.3.2.1.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <script src="assets/js/core/bootstrap.min.js"></script>

        <!-- jQuery UI -->
        <script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
        <script src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

        <!-- jQuery Scrollbar -->
        <script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>


        <!-- Chart JS -->
        <script src="assets/js/plugin/chart.js/chart.min.js"></script>

        <!-- jQuery Sparkline -->
        <script src="assets/js/plugin/jquery.sparkline/jquery.sparkline.min.js"></script>

        <!-- Chart Circle -->
        <script src="assets/js/plugin/chart-circle/circles.min.js"></script>

        <!-- Datatables -->
        <script src="assets/js/plugin/datatables/datatables.min.js"></script>

        <!-- Bootstrap Notify -->


        <!-- jQuery Vector Maps -->
        <script src="assets/js/plugin/jqvmap/jquery.vmap.min.js"></script>
        <script src="assets/js/plugin/jqvmap/maps/jquery.vmap.world.js"></script>

        <!-- Sweet Alert -->
        <script src="assets/js/plugin/sweetalert/sweetalert.min.js"></script>

        <!-- Atlantis JS -->
        <script src="assets/js/atlantis.min.js"></script>

        <!-- Atlantis DEMO methods, don't include it in your project! -->
        <script src="assets/js/setting-demo.js"></script>
        <script src="assets/js/demo.js"></script>
        <script>
            Circles.create({
                id: 'circles-1',
                radius: 45,
                value: 60,
                maxValue: 100,
                width: 7,
                text: Prueba,
                colors: ['#f1f1f1', '#FF9E27'],
                duration: 400,
                wrpClass: 'circles-wrp',
                textClass: 'circles-text',
                styleWrapper: true,
                styleText: true
            })

            Circles.create({
                id: 'circles-2',
                radius: 45,
                value: 70,
                maxValue: 100,
                width: 7,
                text: Prueba,
                colors: ['#f1f1f1', '#2BB930'],
                duration: 400,
                wrpClass: 'circles-wrp',
                textClass: 'circles-text',
                styleWrapper: true,
                styleText: true
            })

            Circles.create({
                id: 'circles-3',
                radius: 45,
                value: 40,
                maxValue: 100,
                width: 7,
                text: Prueba,
                colors: ['#f1f1f1', '#F25961'],
                duration: 400,
                wrpClass: 'circles-wrp',
                textClass: 'circles-text',
                styleWrapper: true,
                styleText: true
            })

            var totalIncomeChart = document.getElementById('totalIncomeChart').getContext('2d');

            var mytotalIncomeChart = new Chart(totalIncomeChart, {
                type: 'bar',
                data: {
                    labels: ["S", "M", "T", "W", "T", "F", "S", "S", "M", "T"],
                    datasets: [{
                            label: "Total Income",
                            backgroundColor: '#ff9e27',
                            borderColor: 'rgb(23, 125, 255)',
                            data: [6, 4, 9, 5, 4, 6, 4, 3, 8, 10],
                        }],
                },
                options: {
                    responsive: true,
                    maintainAspectRatio: false,
                    legend: {
                        display: false,
                    },
                    scales: {
                        yAxes: [{
                                ticks: {
                                    display: false //this will remove only the label
                                },
                                gridLines: {
                                    drawBorder: false,
                                    display: false
                                }
                            }],
                        xAxes: [{
                                gridLines: {
                                    drawBorder: false,
                                    display: false
                                }
                            }]
                    },
                }
            });

            $('#lineChart').sparkline([105, 103, 123, 100, 95, 105, 115], {
                type: 'line',
                height: '70',
                width: '100%',
                lineWidth: '2',
                lineColor: '#ffa534',
                fillColor: 'rgba(255, 165, 52, .14)'
            });
        </script>
    </body>
</html>