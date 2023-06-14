<%-- 
    Document   : Citas
    Created on : 17/11/2022, 03:28:24 PM
    Author     : Rody Fernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="description" content="Mecadustria">
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
        <div  class="modal fullscreen-modal fade mt-5"  data-bs-toggle="modal" id="ventana1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> 


            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h3 class="modal-title"> Registrar Cita </h3>


                    </div>
                    <form id="formRegistroCita"  action="Validar"  method="get">   

                        <div class="modal-body">

                            <div class="row mx-2">
                                <div class="col">
                                    <div class="form-group">
                                        <label>Fecha Cita</label>
                                        <input type="date" name="txtInicio"  class="form-control" >
                                    </div>
                                </div>

                            </div> 
                            <div class="row mx-2">
                                <div class="col">
                                    <div class="form-group">
                                        <label>Rango horario</label>
                                        <select id="cborHorario" name="cborHorario" class="form-control">
                                            <option selected>Seleccione</option>
                                            <option value="1">9 AM - 10 AM</option>
                                            <option value="2">10 AM - 11 AM</option>
                                            <option value="3">11 AM - 12 AM</option>
                                            <option value="4">12 AM - 1 PM</option>
                                            <option value="5">2 PM - 3 PM</option>
                                            <option value="6">3 PM - 4 PM</option>
                                            <option value="7">4 PM - 5 PM</option>
                                        </select>
                                    </div>
                                </div>    

                            </div> 

                            <div class="row mx-2">
                                <div class="col">
                                    <div class="form-group">
                                        <label>Asesor</label>                                                   
                                        <select name="cboAsesor" id="cboAsesor" class="form-control" required>
                                            <option value="" selected>Seleccione</option>
                                            <c:forEach items="${asesor}" var="as">
                                                <option value="${as.getIdAsesor()}">
                                                    ${as.getNombre()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>    

                            </div> 

                            <div class="row mx-2">
                                <div class="col">
                                    <label>Motivo Reserva</label>
                                    <select id="cbomotivo" name="cbomotivo" class="form-control">
                                        <option selected>Seleccione</option>
                                        <option value="1">FABRICACION DE CADENAS ESPECIALES</option>
                                        <option value="2">ACABADOS DE PIÑONES</option>
                                        <option value="3">FABRICACION DE MAQUINARIA</option>
                                        <option value="4">INSTALACION DE SISTEMAS</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="row mx-2 mb-4 align-content-center">
                            <div class="form-group">
                                <div class="col">

                                    <input type="submit" name="accion" value="RegistrarCita" class="btn btn-info">
                                    <c:if test="${not empty requestScope.error}">
                                        <div class="alert alert-danger" role="alert">
                                            <script>
                                                Swal.fire({
                                                    icon: 'error',
                                                    title: 'Error al guardar la cita',
                                                })

                                            </script>
                                            ${requestScope.error}
                                        </div>
                                    </c:if>
                                    <c:if test="${not empty requestScope.mensaje}">
                                        <div class="alert alert-success" role="alert">
                                            <script>

                                                Swal.fire({
                                                    icon: 'success',
                                                    title: 'Cita registrada correctamente!',
                                                    text: 'El asesor te indicará el enlace para la reunión!',
                                                })

                                            </script>
                                            ${requestScope.mensaje}
                                        </div>
                                    </c:if>
                                    <button type="button" class="btn btn-secondary " data-dismiss="modal" aria-hidden="true">Cerrar</button>
                                </div>

                            </div>
                        </div>
                    </form>
                </div>


            </div>





        </div>

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
                                                    <th>Cliente</th>
                                                    <th>Documento</th>
                                                    <th>Asesor</th>
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
