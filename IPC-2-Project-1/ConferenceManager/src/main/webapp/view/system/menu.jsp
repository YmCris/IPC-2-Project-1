<%-- 
    Document   : menu
    Created on : Sep 18, 2025, 11:03:40 AM
    Author     : YmCris
    JSP menu es el JSP encargado de mostrar 
--%>

<!-- RECURCOS IMPORTANTES DEL JSP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- ESTRUCTURA DEL HTML -->
<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Conference Manager</title>
    <jsp:include page="/includes/resources.jsp"/>
    <!-- Navbar -->
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
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                </ul>
            </div>
        </div>
</header>