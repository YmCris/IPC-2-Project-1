<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Página JSP con Bootstrap</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
            <div class="container">
                <a class="navbar-brand fw-bold" href="#">MiApp JSP</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu"
                        aria-controls="menu" aria-expanded="false" aria-label="Menú de navegación">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" href="#">Inicio</a></li>
                        <li class="nav-item"><a class="nav-link" href="#cards">Servicios</a></li>
                        <li class="nav-item"><a class="nav-link" href="#tabla">Datos</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contacto">Contacto</a></li>
                    </ul>
                    <button class="btn btn-outline-light ms-3" data-bs-toggle="modal" data-bs-target="#modalLogin">Iniciar Sesión</button>
                </div>
            </div>
        </nav>

        <!-- Hero Section -->
        <header class="bg-primary text-white text-center py-5">
            <div class="container">
                <h1 class="display-4 fw-bold">Bienvenido a MiApp JSP</h1>
                <p class="lead">Una interfaz moderna construida con Bootstrap 5 y JSP</p>
                <a href="#cards" class="btn btn-light btn-lg mt-3">Explorar</a>
            </div>
        </header>


        <!-- Formulario con campo de texto -->
        <section id="contacto" class="py-5 bg-light">
            <div class="container">
                <h2 class="text-center">Contáctanos</h2>
                <p class="text-center mb-4">Escríbenos un mensaje y te responderemos pronto</p>

                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <form method="post" action="procesarMensaje.jsp">
                            <!-- Campo de texto simple -->
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Tu nombre</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Escribe tu nombre" required>
                            </div>

                            <!-- Campo de texto grande (textarea) -->
                            <div class="mb-3">
                                <label for="mensaje" class="form-label">Tu mensaje</label>
                                <textarea class="form-control" id="mensaje" name="mensaje" rows="4" placeholder="Escribe tu mensaje aquí..." required></textarea>
                            </div>

                            <!-- Botón enviar -->
                            <button type="submit" class="btn btn-primary w-100">Enviar mensaje</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <!-- Campo de texto con valor predeterminado -->
        <div class="mb-3">
            <label for="nombre" class="form-label">Tu nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre"
                   value="Juan Pérez" required>
        </div>

        <!-- Textarea con texto predeterminado -->
        <div class="mb-3">
            <label for="mensaje" class="form-label">Tu mensaje</label>
            <textarea class="form-control" id="mensaje" name="mensaje" rows="4" required>
Hola, este es un mensaje predeterminado que el usuario puede editar.
            </textarea>
        </div>


        <section class="py-5 bg-white">
            <div class="container">
                <!-- Título principal -->
                <h1 class="display-4 fw-bold text-center mb-4">Bienvenido a Mi Aplicación</h1>

                <!-- Subtítulo -->
                <h2 class="h4 text-primary mb-3">Características principales</h2>

                <!-- Texto descriptivo -->
                <p class="lead">
                    Nuestra aplicación está diseñada para ofrecer una experiencia rápida, segura y moderna.
                    Todo el frontend está hecho con <strong>Bootstrap 5</strong>, asegurando un diseño responsivo y elegante.
                </p>

                <!-- Otro subtítulo -->
                <h2 class="h4 text-success mt-4 mb-3">Por qué elegirnos</h2>

                <!-- Texto normal -->
                <p>
                    Confiamos en la tecnología JSP para garantizar rendimiento en el backend
                    y en las bibliotecas de Bootstrap para lograr una interfaz atractiva.
                    Así combinamos lo mejor de ambos mundos: <em>potencia y diseño</em>.
                </p>
            </div>
        </section>

        <!-- carrusel de imagenes -->
        <section class="py-5 bg-dark">
            <div class="container">
                <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner rounded shadow">
                        <div class="carousel-item active">
                            <img src="https://picsum.photos/1200/400?1" class="d-block w-100" alt="Imagen 1">
                        </div>
                        <div class="carousel-item">
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


        <!--  seccion de testimonios -->
        <section class="py-5 bg-light">
            <div class="container">
                <h2 class="text-center mb-5">Lo que dicen nuestros usuarios</h2>
                <div class="row g-4">
                    <div class="col-md-4">
                        <div class="card shadow-sm border-0 h-100">
                            <div class="card-body text-center">
                                <p class="fst-italic">"Excelente plataforma, muy fácil de usar."</p>
                                <h6 class="fw-bold mt-3">- Ana Pérez</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow-sm border-0 h-100">
                            <div class="card-body text-center">
                                <p class="fst-italic">"Me ayudó a mejorar la productividad de mi equipo."</p>
                                <h6 class="fw-bold mt-3">- Luis Gómez</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow-sm border-0 h-100">
                            <div class="card-body text-center">
                                <p class="fst-italic">"La seguridad es excelente, confío plenamente."</p>
                                <h6 class="fw-bold mt-3">- María López</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- acordeon de preguntas frecuentes -->
        <section class="py-5 bg-white">
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

        <!-- breakcrumbs migas de pan-->
        <nav aria-label="breadcrumb" class="bg-light p-3 rounded shadow-sm">
            <ol class="breadcrumb mb-0">
                <li class="breadcrumb-item"><a href="#">Inicio</a></li>
                <li class="breadcrumb-item"><a href="#">Usuarios</a></li>
                <li class="breadcrumb-item active" aria-current="page">Detalle</li>
            </ol>
        </nav>

        <!-- List Groups (listas con estilo) -->
        <div class="list-group shadow-sm">
            <a href="#" class="list-group-item list-group-item-action active">Perfil</a>
            <a href="#" class="list-group-item list-group-item-action">Configuración</a>
            <a href="#" class="list-group-item list-group-item-action">Notificaciones</a>
            <a href="#" class="list-group-item list-group-item-action">Cerrar Sesión</a>
        </div>


        <!-- Sidebar (offcanvas menu) -->
        <!-- Botón -->
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#sidebarMenu">
            Abrir Menú
        </button>

        <!-- Sidebar -->
        <div class="offcanvas offcanvas-start" tabindex="-1" id="sidebarMenu">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title">Menú</h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="list-unstyled">
                    <li><a href="#" class="d-block mb-2">Inicio</a></li>
                    <li><a href="#" class="d-block mb-2">Servicios</a></li>
                    <li><a href="#" class="d-block mb-2">Usuarios</a></li>
                    <li><a href="#" class="d-block">Contacto</a></li>
                </ul>
            </div>
        </div>

        <!-- Badges en botones o textos -->
        <button type="button" class="btn btn-secondary">
            Notificaciones <span class="badge bg-danger">5</span>
        </button>

        <!-- Jumbotron (versión moderna con bg-light y display) -->
        <section class="p-5 mb-4 bg-light rounded-3 shadow-sm">
            <div class="container py-5">
                <h1 class="display-5 fw-bold">¡Descubre nuestra nueva función!</h1>
                <p class="col-md-8 fs-5">
                    Ahora puedes gestionar tus proyectos en tiempo real con estadísticas actualizadas y reportes automáticos.
                </p>
                <button class="btn btn-primary btn-lg">Saber más</button>
            </div>
        </section>

        <!-- Dropdowns mejorados -->
        <div class="dropdown">
            <button class="btn btn-outline-dark dropdown-toggle" type="button" data-bs-toggle="dropdown">
                Opciones
            </button>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#"><i class="bi bi-person"></i> Perfil</a></li>
                <li><a class="dropdown-item" href="#"><i class="bi bi-gear"></i> Configuración</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item text-danger" href="#"><i class="bi bi-box-arrow-right"></i> Salir</a></li>
            </ul>
        </div>

        <!-- barra de progreso -->
        <section class="py-5 bg-light">
            <div class="container">
                <h2 class="text-center mb-4">Nuestro progreso</h2>
                <div class="mb-3">
                    <label class="form-label">Usuarios activos</label>
                    <div class="progress">
                        <div class="progress-bar bg-success" style="width: 75%;">75%</div>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Proyectos completados</label>
                    <div class="progress">
                        <div class="progress-bar bg-info" style="width: 60%;">60%</div>
                    </div>
                </div>
            </div>
        </section>


        <!-- Cards Section -->
        <section id="cards" class="py-5">
            <div class="container">
                <div class="row g-4">
                    <div class="col-md-4">
                        <div class="card shadow border-0 h-100">
                            <div class="card-body text-center">
                                <i class="bi bi-speedometer2 fs-1 text-primary"></i>
                                <h5 class="card-title mt-3">Rendimiento</h5>
                                <p class="card-text">Procesa datos rápidamente gracias a la optimización del backend en JSP.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow border-0 h-100">
                            <div class="card-body text-center">
                                <i class="bi bi-shield-lock fs-1 text-success"></i>
                                <h5 class="card-title mt-3">Seguridad</h5>
                                <p class="card-text">Autenticación y control de acceso garantizando la protección de tus datos.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card shadow border-0 h-100">
                            <div class="card-body text-center">
                                <i class="bi bi-cloud-check fs-1 text-info"></i>
                                <h5 class="card-title mt-3">Escalabilidad</h5>
                                <p class="card-text">Diseñado para crecer con tu negocio sin perder eficiencia.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Tabla de datos -->
        <section id="tabla" class="py-5 bg-white">
            <div class="container">
                <h2 class="mb-4 text-center">Usuarios Registrados</h2>
                <div class="table-responsive shadow-sm">
                    <table class="table table-hover table-bordered align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Rol</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                // Ejemplo de lista en el backend
                                class Usuario {

                                    int id;
                                    String nombre;
                                    String email;
                                    String rol;

                                    Usuario(int id, String nombre, String email, String rol) {
                                        this.id = id;
                                        this.nombre = nombre;
                                        this.email = email;
                                        this.rol = rol;
                                    }
                                }
                                java.util.List<Usuario> usuarios = new java.util.ArrayList<>();
                                usuarios.add(new Usuario(1, "Ana Pérez", "ana@example.com", "Admin"));
                                usuarios.add(new Usuario(2, "Luis Gómez", "luis@example.com", "Usuario"));
                                usuarios.add(new Usuario(3, "María López", "maria@example.com", "Usuario"));

                                for (Usuario u : usuarios) {
                            %>
                            <tr>
                                <td><%= u.id%></td>
                                <td><%= u.nombre%></td>
                                <td><%= u.email%></td>
                                <td><span class="badge bg-primary"><%= u.rol%></span></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>

        <!-- Contacto -->
        <section id="contacto" class="py-5 bg-light">
            <div class="container text-center">
                <h2>Contáctanos</h2>
                <p class="mb-4">Estamos aquí para ayudarte</p>
                <a href="mailto:soporte@miapp.com" class="btn btn-primary btn-lg">Enviar Correo</a>
            </div>
        </section>

        <!-- Modal Login -->
        <div class="modal fade" id="modalLogin" tabindex="-1" aria-labelledby="modalLoginLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content shadow-lg">
                    <div class="modal-header bg-dark text-white">
                        <h5 class="modal-title" id="modalLoginLabel">Iniciar Sesión</h5>
                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="login.jsp">
                            <div class="mb-3">
                                <label class="form-label">Usuario</label>
                                <input type="text" name="usuario" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Contraseña</label>
                                <input type="password" name="clave" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer class="bg-dark text-white text-center py-3">
            <div class="container">
                <p class="mb-0">&copy; 2025 MiApp JSP - Todos los derechos reservados</p>
            </div>
        </footer>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Bootstrap Icons -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
    </body>
</html>
