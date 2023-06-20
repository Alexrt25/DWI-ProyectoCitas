
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h4 class="page-title ml-3">Medicos</h4>
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
                            <a href="#">Medicos</a>
                        </li>
                    </ul>
                </div>

                <div class="row">
                    <div class="col-md-12 mt-4">
                        <div class="card">
                            <div class="card-header">
                                <div class="d-flex align-items-center">
                                    <h4 class="card-title my-3">Listado de Medicos</h4>
                                </div>

                                <div class="card-tools">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ventana1">
                                        Nuevo
                                    </button>
                                </div>

                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="add-row" class="display table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>Nombre</th>
                                                    <th>Doc Identidad</th>
                                                    <th>Correo</th>
                                                    <th>Telefono</th>
                                                    <th>Estado</th>
                                                    <th>Acciones</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="us" items="${asesor}">
                                                    <tr>
                                                        <td>${us.getIdAsesor()}</td>
                                                        <td>${us.getNombre()}</td>
                                                        <td>${us.getDocumentoIdentidad()}</td>
                                                        <td>${us.getCorreo()}</td>
                                                        <td>${us.getTelefono()}</td>
                                                        <td id="estN" >${us.getEstadoUsuarioNombre()}</td>
                                                        <td>
                                                            <div class="d-inline-flex">
                                                                <a href="Validar?accion=EditarAsesor&idAsesor=${us.getIdAsesor()}&nomAsesor=${us.getNombre()}&docuAsesor=${us.getDocumentoIdentidad()}&correoAsesor=${us.getCorreo()}&tlfAsesor=${us.getTelefono()}">
                                                                    <button class="btn btn-link btn-primary btn-lg" data-toggle="modal"><i class="fa fa-edit" aria-hidden="true"></i></button></a>
                                                                <a href="Validar?accion=EliminarAsesor&idAsesor=${us.getIdAsesor()}">
                                                                    <button class="btn btn-link btn-danger btn-lg" name ="deleteAsesorFinal" id="deleteAsesorFinal" data-toggle="modal"><i class="fa fa-times" aria-hidden="true"></i></button>
                                                                </a>
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
                                    <h3 class="modal-title"> Registrar Medico </h3> 
                                </div>
                                <div class="modal-body">

                                    <form id="formRegistro"  action="Validar"  method="get" >
                                        <div class="form-group">
                                            <label>Nombre</label>
                                            <input type="text" name="txtNombre" maxlength="50" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Documento de Identidad</label>
                                            <input type="number" name="txtDocumento" maxlength="8"  minlength="7" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Correo</label>
                                            <input type="email" name="txtCorreo" maxlength="50" minlength="10" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Telefono</label>
                                        </div>
                                        <div class="form-group">
                                            <input type="number" name="txtTelefono" maxlength="9" minlength="7" class="form-control" required> 
                                        </div>
                                        <br>
                                        <div class="text-center">
                                            <input type="submit" name="accion" value="RegistrarAsesor" class="btn btn-info">
                                            <button type="button" class="btn btn-secondary " data-dismiss="modal" aria-hidden="true">Cerrar</button>
                                        </div>
                                        <div class="row">
                                            <c:if test="${not empty requestScope.error}">
                                                <div class="alert alert-danger" role="alert">
                                                      <script>
                                                Swal.fire({
                                                    icon: 'error',
                                                    title: 'Error al crear el medico',
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
                                                    title: 'Medico registrado correctamente!',
                                                    text: 'El medico ya se encuentra activo!',
                                                })

                                            </script>
                                                    ${requestScope.mensaje}
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
        <script>
            let boton = document.getElementById("deleteAsesor");
            boton.addEventListener("click", (event) => {
                event.preventDefault();
                const swalWithBootstrapButtons = Swal.mixin({
                    customClass: {
                        confirmButton: 'btn btn-success',
                        cancelButton: 'btn btn-danger'
                    },
                    buttonsStyling: false
                })
                swalWithBootstrapButtons.fire({
                    title: '¿Seguro quieres eliminar este registro?',
                    text: "No puedes revertir esta opción!",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonText: 'Si, eliminalo!',
                    cancelButtonText: 'No, cancela!',
                    reverseButtons: true
                }).then((result) => {
                    if (result.isConfirmed) {
                        swalWithBootstrapButtons.fire(
                                '!Registro eliminado!',
                                'El registro fue eliminado.',
                                'success'
                                )
                        document.getElementById("deleteAsesorFinal").click();
                        return false;
                        window.location = "Controlador?menu=Citas&accion=Listar";

                    } else if (
                            /* Read more about handling dismissals below */
                            result.dismiss === Swal.DismissReason.cancel
                            ) {
                        swalWithBootstrapButtons.fire(
                                'Cancelado',
                                'Tu registro se mantiene :)',
                                'error'
                                )
                    }
                })
            });

        </script>
    </body>
</html>