<%-- 
    Document   : user-created
    Created on : Sep 18, 2025, 10:52:31 PM
    Author     : YmCris
    JSP user-created es el JSP encargado de mostrar 
--%>

<!-- RECURCOS IMPORTANTES DEL JSP -->
<%@page import="backend.user.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- ESTRUCTURA DEL HTML -->
<html>
    <!-- HEADER -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario creado</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <!-- BODY -->
    <body>
        <main>
            <jsp:include page="/includes/header.jsp"/>
            <div class="container">
                <div class="row">
                    <c:if test="${newUser != null}">
                        <div class="card">
                            <div class="card-header">
                                ${newUser.name}
                            </div>
                            <div class="card-body">
                                <h5 class="card-title">${newUser.dpi}</h5>
                                <p class="card-text">Contraseña: ${newUser.password} - Email ${newUser.email}</p>
                                <a href="#" class="btn btn-primary">Listado de eventos</a>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${newUser == null}">
                        <div class="alert alert-danger d-flex align-items-center">
                            <i class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2"></i>
                            <div>
                                ${error}!!!
                            </div> 
                        </div>
                    </c:if>
                </div>
            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>
