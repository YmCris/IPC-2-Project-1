<%-- 
    Document   : Header
    Created on : Sep 7, 2025, 3:26:51 AM
    Author     : cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Conference Manager</title>
    <jsp:include page="/includes/resources.jsp"/>
    <nav class="navbar navbar-expand-lg bg-body">
        <div class="container-fluid">
            <button
                data-mdb-collapse-init
                class="navbar-toggler"
                type="button"
                data-mdb-target="#navbarExample01"
                aria-controls="navbarExample01"
                aria-expanded="false"
                aria-label="Toggle navigation"
                >
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cambiar descripción del sistema</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cambiar porcentaje de comisión</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Agregar administrador del sistema</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Eliminar administrador del sistema</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cerrar sesión</a>
                    </li>
                </ul>
            </div>
        </div>
</header>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
