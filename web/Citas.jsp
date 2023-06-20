
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="description" content="MundoSalud">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>CRUD Citas</title>
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


        <!-- Modal -->


    <!--Termina modal--> 

    <!-- Inicio panel -->

    <div class="content">
        <div class="page-inner">
            <div class="page-header mt-5">
                <h4 class="page-title ml-3">Citas</h4>
                <ul class="breadcrumbs">
                    <li class="nav-home">
                        <a href="#">
                            <i class="flaticon-home"></i>
                        </a>
                    </li>
                    <li class="separator">
                        <i class="flaticon-right-arrow"></i>
                    </li>


                    <li class="nav-item">
                        <a href="#">Citas</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <div class="col-md-12 mt-4">
                    <div class="card">

                        <div class="card-header">

                            <div class="d-flex align-items-center">

                                <h4 class="card-title my-3">Listado de Citas</h4>

                            </div>

                            <div class="card-tools">
                                
                            </div>

                            <div class="card-body">

                                <div class="table-responsive">
                                    <table id="add-row" class="display table table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Fecha reserva</th>
                                                <th>Paciente</th>
                                                <th>Documento</th>
                                                <th>Medico</th>
                                                <th>Motivo</th>
                                                <th>Estado</th>
                                                <th>Enlace Meet</th>
                                                <th>Rango Horario</th>
                                                <th class="text-center">Acción</th>
                                            </tr>
                                        </thead>

                                        <tbody>

                                            <c:forEach var="ci" items="${citas}">
                                                <tr>
                                                    <td>${ci.getIdCita()}</td>
                                                    <td>${ci.getInicio()}</td>
                                                    <td>${ci.getNombreCliente()}</td>
                                                    <td>${ci.getDocuCliente()}</td>
                                                    <td>${ci.getNombreAsesor()}</td>
                                                    <td>${ci.getNombreMotivo()}</td>
                                                    <td>${ci.getNombreEstado()}</td> 
                                                    <td>${ci.getEnlaceMeet()}</td>
                                                    <td>${ci.getHoraRango()}</td>
                                                    <td>
                                                        <a href="Validar?accion=EditarCitas&idCita=${ci.getIdCita()}&nomEstado=${ci.getNombreEstado()}&nomAsesor=${ci.getNombreAsesor()}&enlaceMeet=${ci.getEnlaceMeet()}">
                                                        <button class="btn btn-link btn-primary btn-lg" data-toggle="modal"><i class="fa fa-edit" aria-hidden="true"></i></button></a>
                                                    </td>
                                                </tr> 
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <!-- Termina panel -->


    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>
