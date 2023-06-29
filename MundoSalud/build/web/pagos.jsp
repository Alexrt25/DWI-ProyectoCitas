<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="description" content="MundoSalud">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>PAGO ONLINE</title>
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
                    <h4 class="page-title ml-3">PAGO ONLINE</h4>
                </div>
                <div class="row">
                    <div class="col-md-12 mt-4">
                        <div class="card">
                            <div class="card-header">
                                <div class="d-flex align-items-center">
                                    <h4 class="card-title my-3">PAGO ONLINE</h4>
                                </div>

                            </div>
                            <div class="card-body">
                                <form id="formRegistro"  action="Validar"  method="get" >
                                    <div class="form-group">
                                        <label>Paciente:</label>
                                        <input type="text" name="txtPaciente" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Doc Identidad:</label>
                                        <input type="text" name="txtDocIdentidad" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Cita:</label>
                                        <input type="text" name="txtCita" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Correo:</label>
                                        <input type="text" name="txtCorreo" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Teléfono:</label>
                                        <input type="text" name="txtTelefono" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <form id="formRegistro"  action="Validar"  method="get" >
    <div class="form-group">
        <label>Paciente:</label>
        <input type="text" name="txtPaciente" class="form-control">
    </div>
    <div class="form-group">
        <label>Doc Identidad:</label>
        <input type="text" name="txtDocIdentidad" class="form-control">
    </div>
    <div class="form-group">
        <label>Cita:</label>
        <input type="text" name="txtCita" class="form-control">
    </div>
    <div class="form-group">
        <label>Correo:</label>
        <input type="text" name="txtCorreo" class="form-control">
    </div>
    <div class="form-group">
        <label>Teléfono:</label>
        <input type="text" name="txtTelefono" class="form-control">
    </div>
    <div class="form-group">
        <label>Fecha de Registro:</label>
        <input type="text" name="txtFechaRegistro" class="form-control">
    </div>
    <div class="form-group">
        <label>Monto:</label>
        <input type="text" name="txtMonto" class="form-control">
    </div>
    <div class="row mt-4">
        <div class="col-md-6">
       <button type="button" class="btn btn-danger" onclick="redirectToPagos()">Pagar</button>

<script>
  // Función para redirigir a pagos.jsp
  function redirectToPagos() {
    window.location.href = "PAGADO.jsp";
  }
</script>
        </div>
        <a href="Controlador?menu=Citas&accion=Listar" target="myFrame">
            <button type="button" class="btn btn-secondary " aria-hidden="true" >Cerrar</button>
        </a>
    </div>
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
    let boton = document.getElementById("bftfa");
    boton.addEventListener("click", (event) => {
        event.preventDefault();
        Swal.fire({
            icon: 'success',
            title: 'Paciente actualizado correctamente!',
            text: 'Paciente fue actualizado con éxito!',
        }).then(function () {
            document.getElementById("accion").click();
            return false;
            window.location = "Controlador?menu=Clientes&accion=Listar";
        })
    });
</script>
</body>
</html>
