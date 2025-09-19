<%-- 
    Document   : log-in
    Created on : Sep 18, 2025, 4:47:48 PM
    Author     : YmCris
    JSP log-in es el JSP encargado de mostrar 
--%>

<!-- RECURCOS IMPORTANTES DEL JSP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- ESTRUCTURA DEL HTML -->
<html>
    <!-- HEADER -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
        <jsp:include page="/includes/resources.jsp"/>
        <jsp:include page="/includes/header.jsp"/>
    </head>
    <!-- BODY -->
    <body class="bg-light">
        <section id="contacto" class="py-5 bg-light">
            <div class="container">
                <h2 class="text-center"><b>Iniciar Sesión</b></h2>
                <p class="text-center mb-4">Inicia sesión con tu nombre de usuario y contraseña</p>
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <form method="post" action="procesarMensaje.jsp">
                            <div class="mb-3">
                                <label><b>DPI</b></label>
                                <input type="text" class="form-control" id="dpi" name="dpi" placeholder="Nombre de usuario" required="">
                            </div>
                            <div class="mb-3">
                                <label><b>Contraseña</b></label>
                                <input type="text" class="form-control" id="contraseña" name="contraseña" placeholder="Contraseña" required="">
                            </div>
                            <div class="d-flex flex-column align-items-center">
                                <button type="submit" class="btn btn-primary w-100 mb-2">Iniciar Sesión</button>
                                <button class="btn btn-secondary mb-2">¿Olvidaste la contraseña?</button>
                                <button class="btn btn-secondary  mb-2">Registrarse</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
