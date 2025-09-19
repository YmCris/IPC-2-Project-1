<%-- 
    Document   : sign-up
    Created on : Sep 18, 2025, 5:10:23 PM
    Author     : YmCris
    JSP sign-up es el JSP encargado de mostrar 
--%>

<!-- RECURCOS IMPORTANTES DEL JSP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- ESTRUCTURA DEL HTML -->
<html>
    <!-- HEADER -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <jsp:include page="/includes/resources.jsp"/>
        <jsp:include page="/includes/header.jsp"/>
    </head>
    <!-- BODY -->
    <body class="bg-light">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <h2 class="text-center"><b>Registrarse</b></h2>
                        <p class="text-center">Llena todos los campos necesarios para poder ingresar al sistema</p>
                        <form class="needs-validation" method="POST" action="${pageContext.servletContext.contextPath}/mvc/system/sign-up-servlet">
                            <div class="mb-3">
                                <label><b>Nombre de Usuario</b></label>
                                <input type="text" class="form-control" id="name" name="name" placeholder="Nombre de usuario" required>
                            </div>
                            <div class="mb-3">
                                <label><b>DPI o Pasaporte</b></label>
                                <input type="text" class="form-control" id="dpi" name="dpi" placeholder="DPI" required>
                            </div>
                            <div class="mb-3">
                                <label><b>Teléfono</b></label>
                                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Teléfono" required>
                            </div>
                            <div class="mb-3">
                                <label><b>Correo</b></label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Correo" required>
                            </div>
                            <div class="mb-3">
                                <label><b>Contraseña</b></label>
                                <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
                            </div>
                            <%!
                                /*
                                <div class="mb-3">
                                <label><b>Foto de perfil</b></label>
                                <input type="file" class="form-control" id="photo" name="photo">
                                </div>
                                 */
                            %>
                            <div class="mb-3">
                                <label><b>Nombre de la Institución</b></label>
                                <input type="text" class="form-control" id="institution" name="institution" placeholder="Institución">
                            </div>
                            <div class="col-md-3">
                                <label for="tipo" class="form-label"><b>¿Es extranjero?</b></label>
                                <div>
                                    <select id="foreign" name="foreign" class="form-control">
                                        <option value="TRUE">SI</option>
                                        <option value="FALSE">NO</option>
                                    </select>
                                </div>
                            </div>
                            <div class="text-center">
                                <button class="btn btn-primary btn-lg" type="submit">Registrarse</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>
