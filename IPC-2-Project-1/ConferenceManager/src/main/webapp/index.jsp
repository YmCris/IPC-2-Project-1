<%-- 
    Document   : index
    Created on : Sep 18, 2025, 10:50:48 AM
    Author     : YmCris
    JSP index es el JSP encargado de mostrar el inicio de la aplicación web
--%>

<%@page import="dababase.DBCreation"%>
<!-- RECURCOS IMPORTANTES DEL JSP -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- ESTRUCTURA DEL HTML -->
<html>
    <!-- HEADER -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conference Manager</title>
        <jsp:include page="/includes/resources.jsp"/>
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom"> <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none"> <svg class="bi me-2" width="40" height="32" aria-hidden="true"><use xlink:href="#bootstrap"></use></svg> <span class="fs-4"><b>GESTOR DE CONGRESOS</b></span> </a> <ul class="nav nav-pills"> <li class="nav-item"><a href="view/system/log-in.jsp" class="nav-link active" aria-current="page">Iniciar Sesión</a></li> <li class="nav-item"><a href="view/system/sign-up.jsp" class="nav-link">Registrarse</a></li></ul> </header>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <!-- BODY -->
    <body class="bg-light">
        <!--MAIN-->
        <main>
            <section >
                <div class="container">
                    <br>
                    <h3 class="display-4 fw-bold  mb-4">Descripción</h3>
                    <p class="lead">
                        Este es un programa para poder gestionar congresos, tanto participantes como organizadores se sentiran familiarizados.
                        El programa cuenta con una gran serie de funciones e interfaz descriptiva que le será de utilizad para el uso del programa.
                        Algunas de las principales funcionalidades que destacan a este software de la competencia son las siguientes:
                        <a href="prueba/pruebaBootstrap.jsp">Ver elemento de prueba</a>
                    </p>
                </div>
            </section>
            <section id="cards">
                <div class="container">
                    <div class="row g-4">
                        <div class="col-md-4">
                            <div class="card shadow border-0 h-100">
                                <div class="card-body text-center">
                                    <i class="bi bi-speedometer2 fs-1 text-primary"></i>
                                    <h5 class="card-title mt-3">Rendimiento</h5>
                                    <p class="card-text">El sistema esta optimizado utilizando las mejores tecnologías actuales para una mejor experienciaí</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card shadow border-0 h-100">
                                <div class="card-body text-center">
                                    <i class="bi bi-shield-lock fs-1 text-success"></i>
                                    <!-- icono de seguridad -->
                                    <h5 class="card-title mt-3">Seguridad</h5>
                                    <p class="card-text">La protección e integridad de los datos de todos los usuarios y congresos están totalmente protegidosá</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card shadow border-0 h-100">
                                <div class="card-body text-center">
                                    <i class="bi bi-cloud-check fs-1 text-info"></i>
                                    <!-- icono de funcionalidades -->
                                    <h5 class="card-title mt-3">Funcionalidades</h5>
                                    <p class="card-text">La gran cantidad de funcionalidades que ofrece el programa y su sencillez para utilizarlas son altamente útiles</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="py-5 bg-light">
                <div class="container">
                    <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-inner rounded shadow">
                            <h3 class="display-4 fw-bold  mb-4">Funciones del programa</h3>
                            <div class="carousel-item">
                                <img src="https://picsum.photos/1200/400?1" class="d-block w-100" alt="Imagen 1">
                            </div>
                            <div class="carousel-item active">
                                <img src="https://picsum.photos/1200/400?2" class="d-block w-100" alt="Imagen 2">
                            </div>
                            <div class="carousel-item">
                                <img src="https://picsum.photos/1200/400?3" class="d-block w-100" alt="Imagen 3">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon"></span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                            <span class="carousel-control-next-icon"></span>
                        </button>
                    </div>
                </div>
            </section>
            <section class="py-5 bg-light">
                <div class="container">
                    <h2 class="text-center mb-4">Preguntas Frecuentes</h2>
                    <div class="accordion" id="faqAccordion">
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#faq1">
                                    ¿Cómo puedo registrarme?
                                </button>
                            </h2>
                            <div id="faq1" class="accordion-collapse collapse show" data-bs-parent="#faqAccordion">
                                <div class="accordion-body">
                                    Solo haz clic en <strong>"Crear cuenta"</strong> en la parte superior y completa tus datos.
                                </div>
                            </div>
                        </div>
                        <div class="accordion-item">
                            <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#faq2">
                                    ¿Dónde están almacenados mis datos?
                                </button>
                            </h2>
                            <div id="faq2" class="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                                <div class="accordion-body">
                                    Tus datos están protegidos en servidores seguros con encriptación avanzada.
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <jsp:include page="/includes/footer.jsp"/>
        </main>

    </body>
</html>