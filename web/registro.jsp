
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie-edge">
        <title>Registrate</title>
        <link rel="icon" href="assets/img/icon.png" type="image/x-icon"/>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/css/all.min.css">
        <link rel="stylesheet" href="assets/css/sweetalert.css">
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </head>
    <body>      
        <!--  <img class="wave"src="../assets/img/wave.png" alt="">  -->
        <div class="contenedor">
            <div class="img">
                <img src="assets/img/logoMundoSalud.png" alt="">
            </div>
            <div class="contenido-login">

                <form id="formRegistro"  action="Validar"  method="get" >

                    <h2>Registrate</h2>

                    <div class="input-div nit">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">

                            <input type="text"  name="name"  required placeholder="Ingrese su nombre completo">
                        </div>
                    </div>

                    <div class="input-div nit">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">

                            <input type="number"  name="dni"  required placeholder="Ingrese su documento de identidad">
                        </div>
                    </div>

                    <div class="input-div nit">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">

                            <input type="email" name="email"  required placeholder="Ingrese su correo">
                        </div>
                    </div>

                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">

                            <input type="password" placeholder="Contraseña"  name="clave" required >
                        </div>
                    </div>

                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">

                            <input type="password" placeholder="Confirmar contraseña"  name="clave2" required >
                        </div>
                    </div>

                    <div class="input-div nit">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">

                            <input type="number"  name="telef"  required placeholder="Ingrese su teléfono">
                        </div>
                    </div>
                    <div class="input-div nit">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">

                            <input type="text"  name="raso"  required placeholder="Ingrese su razón social">
                        </div>
                    </div>
                    <div class="input-div nit">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">

                            <input type="number"  name="ruc"  required placeholder="Ingrese su RUC">
                        </div>
                    </div>

                    <input type="submit" name="accion" id="registro" class="btn" value="Registrar">
                    <a href="index.jsp"><input type="button" class="btn" value="Regresar"></a>

                    <c:if test="${not empty requestScope.error}">
                        <script>
                            Swal.fire({
                                icon: 'error',
                                title: 'Error al registrar!',
                                text: 'Hubo problemas al registrar',
                            })
                        </script>
                        ${requestScope.error}
                    </c:if>
                    <c:if test="${not empty requestScope.mensaje}">
                        <script>

                            Swal.fire({
                                icon: 'success',
                                title: 'Paciente registrado correctamente!',
                                text: 'Puedes iniciar sesion ahora mismo!',
                            })

                        </script>
                    </c:if>

                </form>


            </div>
        </div>

    </body>

</html>
<script src="assets/js/jquery.js"></script>
<script src="assets/js/sweetalert.min.js"></script>
<!-- Js personalizado -->
<script src="assets/js/operaciones.js"></script>
