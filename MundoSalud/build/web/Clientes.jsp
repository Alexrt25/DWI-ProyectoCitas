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
                    <h4 class="page-title ml-3">Pacientes</h4>
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
                            <a href="#">Pacientes</a>
                        </li>
                    </ul>
                </div>

                <div class="row">
                    <div class="col-md-12 mt-4">
                        <div class="card">
                            <div class="card-header">
                                <div class="d-flex align-items-center">
                                    <h4 class="card-title my-3">Listado de Pacientes</h4>
                                </div>

                                <!--<div class="card-tools">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ventana1">
                                        Nuevo
                                    </button>
                                </div>-->

                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="add-row" class="display table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">Id</th>
                                                    <th class="text-center">Nombre</th>
                                                    <th class="text-center">Doc Identidad</th>
                                                    <th class="text-center">Correo</th>
                                                    <th class="text-center">Telefono</th>
                                                    <th class="text-center">Razon Social</th>
                                                    <th class="text-center">RUC</th>
                                                    <th class="text-center">Estado</th>
                                                    <th class="text-center">Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody  id="clientesList">
                                                <c:forEach var="us" items="${clientes}">
                                                    <tr>
                                                        <td id="id" class="id">${us.getIdCliente()}</td>
                                                        <td id="nombre">${us.getNombre()}</td>
                                                        <td id="documento">${us.getDocumentoIdentidad()}</td>
                                                        <td id="correo">${us.getCorreo()}</td>
                                                        <td id="correo">${us.getTelefono()}</td>
                                                        <td id="razonS">${us.getRazonSocial()}</td>
                                                        <td id="ruc">${us.getRUC()}</td>
                                                        <td id="estN" >${us.getEstadoUsuarioNombre()}</td>
                                                        <td>
                                                            <div class="d-inline-flex">
                                                                <a href="Validar?accion=EditarCliente&idCliente=${us.getIdCliente()}&nomCliente=${us.getNombre()}&docuCliente=${us.getDocumentoIdentidad()}&correoCliente=${us.getCorreo()}&rsCliente=${us.getRazonSocial()}&rucCliente=${us.getRUC()}&tlfCliente=${us.getTelefono()}">
                                                                    <button class="btn btn-link btn-primary btn-lg" data-toggle="modal"><i class="fa fa-edit" aria-hidden="true"></i></button></a>
                                                                <!--<a href="Validar?accion=EliminarCliente&idCliente=${us.getIdCliente()}">
                                                                    <button class="btn btn-link btn-danger btn-lg" data-toggle="modal"><i class="fa fa-times" aria-hidden="true"></i></button></a>-->
                                                            </div>
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

                    <div class="modal fade mt-5" id="ventana1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> 

                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h3 class="modal-title"> Registrar un nuevo pacientes </h3>
                                </div>
                                <div class="modal-body">

                                    <form id="formRegistro"  action="Validar"  method="get" >
                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input type="text" name="txtNombre" id="txtNombre" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Documento de Identidad</label>
                                            <input type="text" name="txtDocumento" id="txtDocumento" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Correo</label>
                                            <input type="text" name="txtCorreo" id="txtCorreo" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Telefono</label>
                                            <input type="text" name="txtTelefono" id="txtTelefono"  class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Razon Social</label>
                                            <input type="text" name="txtRazonSocial" id="txtRazonSocial"  class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>RUC</label>
                                            <input type="text" name="txtRuc"  id="txtRuc"  class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Contraseña</label>
                                            <input type="password" name="txtPaswd"  id="txtPaswd"  class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Repita Contraseña</label>
                                            <input type="password" name="txtPaswd2"  id="txtPaswd2"  class="form-control" required >
                                        </div>
                                        <br>
                                        <div class="text-center">
                                            <input type="submit" name="accion" value="RegistrarCliente" class="btn btn-info">
                                            <button type="button" class="btn btn-secondary " data-dismiss="modal" aria-hidden="true">Cerrar</button>
                                        </div>
                                        <div class="row">
                                            <c:if test="${not empty requestScope.error}">
                                                <div class="alert alert-danger" role="alert">
                                                      <script>
                                                    Swal.fire({
                                                        icon: 'error',
                                                        title: 'Error al guardar el cliente',
                                                    })

                                                </script>
                                                    ${requestScope.error}
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty requestScope.mensaje}">
                                                <div class="alert alert-success" role="alert">
                                                    ${requestScope.mensaje}
                                                     <script>
                                            
                                                    Swal.fire({
                                                        icon: 'success',
                                                        title: 'Paciente registrado correctamente!',
                                                        text: 'Ya puede iniciar sesion!',
                                                    })

                                                </script>
                                                </div>
                                            </c:if>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>    
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

        <script type="text/javascript">

                                                                    $("#TableCliente td:nth-child(1)").click(function (event)
                                                                    {
                                                                        alert("hola");
                                                                        event.preventDefault();
                                                                        var $td = $(this).closest('tr').children('td');
                                                                        var currentCellText = $td.eq(0).text();

                                                                        // more code
                                                                    });

        </script>

    </body>
</html>