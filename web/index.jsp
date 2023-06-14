<%-- 
    Document   : login
    Created on : 15 nov. 2022, 23:42:39
    Author     : lisbetmoron Test
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie-edge">
        <title>Login</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/css/all.min.css">
        <link rel="stylesheet" href="assets/css/sweetalert.css">
        <link rel="icon" href="assets/img/icono_logo.ico" type="image/x-icon"/>
        <script src="assets/js/sweetalert.min.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/a81368914c.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    </head>

    <body>
        <!--  <img class="wave"src="../assets/img/wave.png" alt="">  -->
        <div class="contenedor">
            <div class="img">
                <img src="assets/img/logoMecadustria.svg" alt="">
            </div>
            <div class="contenido-login">
                <form action="Validar"  method="post" >
                    <h2>Login</h2>
                    <div class="input-div nit">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            <input type="text"  name="txtcorreo"  autocomplete="off" placeholder="CORREO" required>
                        </div>
                    </div>
                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            <input type="password" name="txtcontrasenia"  placeholder="CONTRASEÑA" required>
                        </div>
                    </div>
                    
                    <button class="btn"  name='accion' type="submit" value="Ingresar">Iniciar sesion</button> 


                    <c:if test="${not empty requestScope.error}">
                            <script>
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Error al iniciar sesión',
                                    text: 'Usuario y/o clave incorrecto o no se encuentra activo!. Comunicarse con citas@mecadustria.com',
                                })
                            </script>
                    </c:if>

                    <div class="row">
                        <div class="col-md-6 col-sm-4">
                            <span>¿Aún no tienes una cuenta?</span>
                        </div>
                        <div class="col-md-3 col-sm-4">
                            <a href="registro.jsp" id="registrate_nuevo_a">Registrate</a>
                        </div>
                    </div>
                </form>
                <div id="msg_error" class="alert alert-danger" role="alert" style="display: none"></div>
            </div>
        </div>

        <script src="assets/js/jquery.js"></script>

        <!-- Js personalizado -->
    </body>
</html>
