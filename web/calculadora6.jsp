<%-- 
    Rody Fernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="description" content="Mecadustria">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>MECADUSTRIA CALCULADORAS</title>
        <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
        <link rel="icon" href="assets/img/icon.png" type="image/x-icon" />

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

        <!--	<div class="wrapper">-->
        <div class="content">
            <div class="page-inner">
                <div class="page-header">
                    <h4 class="page-title">Calculadoras</h4>
                    <!--						<ul class="breadcrumbs">
                                                                            <li class="nav-home">
                                                                                    <a href="#">
                                                                                            <i class="flaticon-home"></i>
                                                                                    </a>
                                                                            </li>
                                                                            <li class="separator">
                                                                                    <i class="flaticon-right-arrow"></i>
                                                                            </li>
                    
                    
                                                                            <li class="nav-item">
                                                                                    <a href="#">Calculadoras</a>
                                                                            </li>
                                                                            <li class="separator">
                                                                                    <i class="flaticon-right-arrow"></i>
                                                                            </li>
                                                                            <li class="nav-item">
                                                                                    <a href="#">Longitud de cadena</a>
                                                                            </li>
                                                                    </ul>-->
                </div>
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <br />
                            <h4 class="page-title text-center"><strong>Calculadora de acoplamiento idóneo</strong> </h4>
                            <div class="card-header text-center">
                                <div class="align-items-center">
                                    <div class="card-title">Determine el acoplamiento idóneo para su sistema</div>
                                </div>
                                <br />
                                <div class="border-top border-dark border-1">
                                    <div class="col">
                                        <div class="card-title">Ingrese los datos requeridos</div>
                                        <br>
                                        <form action="Calculadora6Servlet" method="post">
                                        <div class="mx-5 my-3">
                                            <label class="text-left">Tipo de motor</label>
                                            <select class="form-control input-solid" name="motor" id="motor" required="">
                                                <option value="1">Motor eléctrico o motor de turbina</option>
                                                <option value="2">Motor a vapor o motor a gasolina hasta 4 cilindros</option>
                                                <option value="3">Motor petrolero o motor a gasolina de más de 4 cilindros</option>
                                            </select>
                                        </div>
                                        <div class="mx-5 my-3">
                                            <label class="text-left">Tipo de carga</label>
                                            <select class="form-control input-solid" name="carga" id="carga" required="">
                                                <option value="1">Fluctuación baja, impacto bajo, bajo torque inicial, no hay rotación inversa</option>
                                                <option value="2">Fluctuación media, impacto mediano y no hay rotación inversa (Carga estándar)</option>
                                                <option value="3">Fluctuación alta, impacto alto, rotacion inversa, carga al inicio</option>
                                            </select>
                                        </div>
                                        <div class="mx-5 my-3">
                                            <label class="text-left">Potencia del motor (HP)</label>
                                            <input name="potenciaMotor" id="potenciaMotor" type="number" class="form-control">
                                        </div>	
                                        <div class="mx-5 my-3">
                                            <label class="text-left"># RPM del motor</label>
                                            <input name="rpmMotor" id="rpmMotor" type="number" class="form-control">
                                        </div>
                                            <input class="btn btn-info" type="submit" name="Procesar" />
                                        </form>
                                    </div>
                                    
                                </div>
                                <!--Aqui-->

                                <!--Aqui-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Termina panel -->
        <!-- End Custom template -->
        <script>
            var potenciaMotor = document.querySelector('#potenciaMotor');
            var rpmMotor = document.querySelector('#rpmMotor');
            var resultado = document.querySelector('span');
            var carga = document.getElementById("carga");
            var motor = document.getElementById("motor");
            
            const CARGA_A = {
                1: 1.0,
                2: 1.5,
                3: 2.0
            };
            
            const MOTOR_A = {
                1: 1.0,
                2: 1.5,
                3: 2.0
            };
            
            function calcular() {
                
                resultadoOperacion = (50 * parseInt(potenciaMotor.value) * (CARGA_A[parseFloat(carga.value)]*MOTOR_A[parseFloat(motor.value)])) / parseInt(rpmMotor.value);
                resultado.innerHTML = "La potencia nominal del sistema es " + resultadoOperacion.toFixed(2) + " kW. Las RPM del eje motriz son " + parseInt(rpmMotor.value) + "</br>Con los valores obtenidos verifique el acoplamiento idóneo en la imagen.";
            }
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



