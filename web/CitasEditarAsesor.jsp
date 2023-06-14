<%-- 
    Document   : CitasEditar
    Created on : 13 dic. 2022, 20:17:14
    Author     : lisbetmoron
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

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
            document.getElementById('txtEnlaceMeet').disabled = true;
        </script>

        <!-- CSS Files -->
        <!-- <link rel="stylesheet" type="text/css" href="assets/css/style.css"> -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/atlantis.min.css">

        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link rel="stylesheet" href="assets/css/demo.css">
    </head>

    <body>
        <div class="content">

            <div class="page-inner">

                <div class="page-header mt-5">
                    <h4 class="page-title ml-3">Editar Citas</h4>
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
                                    <h4 class="card-title my-3">Editar Citas</h4>
                                </div>

                            </div>
                            <div class="card-body">
                                <form id="formRegistro"  action="Validar"  method="get" >

                                    <div class="form-row">
                                        <label>ID</label>
                                        <input type="text" name="txtId" id="txtId" class="form-control" value="<%= request.getParameter("idCita")%>" readonly>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6"><!-- comment -->
                                            <label>Estado Actual</label>
                                            <input type="text" name="txtEstadoActual" id="txtEstadoActual" class="form-control" value="<%= request.getParameter("nomEstado")%>" readonly>                                    
                                        </div>
                                        <div class="form-group col-md-6"><!-- comment -->
                                            <label>Nuevo Estado</label>
                                            <select id="cboNuevoEstado" name="cboNuevoEstado" class="form-control" onchange="habilitaEnlace()" required>
                                                <option value="" selected>Seleccione</option>
                                                <option value="1">PENDIENTE</option>
                                                <option value="2">APROBADO</option>
                                                <option value="3">RECHAZADO</option>
                                            </select> 
                                        </div>
                                    </div>


                                    <div class="form-row">
                                        <label>Enlace Meet</label>
                                        <input type="text" name="txtEnlaceMeet" id="txtEnlaceMeet" class="form-control" value="<%= request.getParameter("enlaceMeet")%>" disabled >
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <input type="hidden" name="cboNuevoAsesor" id="cboNuevoAsesor" class="form-control" value="<%= request.getParameter("idAsesor")%>">                                               
                                        </div>

                                    </div>
                                    <button id="bftfa" name="bftfa" class="btn btn-primary">Actualizar</button>

                                    <button type="submit" id="accion" hidden="true" name="accion" value="ActualizarCitasAsesor"  class="btn btn-primary"></button>
                                    <a href="Controlador?menu=CitasAsesor&accion=Listar" target="myFrame">
                                    <button type="button" class="btn btn-secondary" >Cerrar</button>
                                    </a>


                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

        <script>
                                                function habilitaEnlace()
                                                {
                                                    var estadoActual = document.getElementById('cboNuevoEstado').value;

                                                    if (estadoActual === '2') {
                                                        document.getElementById('txtEnlaceMeet').disabled = false;

                                                    } else {
                                                        document.getElementById('txtEnlaceMeet').disabled = true;
                                                        document.getElementById('txtEnlaceMeet').value = "";
                                                    }


                                                }
                                      let boton = document.getElementById("bftfa");
            boton.addEventListener("click", (event) => {
                event.preventDefault();
                Swal.fire({
                    icon: 'success',
                    title: 'Cita actualizada correctamente!',
                    text: 'La cita fue actualizada con éxito!',

                }).then(function () {
                    document.getElementById("accion").click();
                    return false;
                  window.location = "Controlador?menu=CitasAsesor&accion=Listar&idAsesor=${usuario.getIdUsuario()}";
                })
            });
        </script>
    </body>
</html>
