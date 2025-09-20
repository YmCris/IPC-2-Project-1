<%-- 
    Document   : user-menu
    Created on : Sep 19, 2025, 3:14:04 PM
    Author     : YmCris
    JSP user-menu es el JSP encargado de mostrar 
--%>

<!-- RECURCOS IMPORTANTES DEL JSP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- ESTRUCTURA DEL HTML -->
<html>
    <!-- HEADER -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor de congresos</title>
        <jsp:include page="/includes/resources.jsp"/>
        <jsp:include page="/includes/participant/header.jsp"/>
    </head>
    <!-- BODY -->
    <body class="bg-light">
        <main>
            <div class="container">
                <div class="row">
                    <c:if test="${newUser != null}">
                        <div class="card">
                            <div class="card-header">
                                ${msg}
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
