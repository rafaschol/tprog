<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<%@ page import="logica.DataUsuario" %>
<html>
<head>
  <!-- Meta tags -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Stylesheets -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <link rel="stylesheet" href="css/base.css">
  <link rel="stylesheet" href="css/list-page.css">
  
  <!-- Icons -->
  <script src="https://kit.fontawesome.com/45d333caf9.js" crossorigin="anonymous"></script>
  
  <title>Inicio | Entrenemos.uy</title>
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <div class="container-fluid">
      <button class="btn btn-primary rounded-circle me-3 sidebar-toggler">
        <i class="fas fa-caret-right sidebar-toggler-show" style="font-size: 1.2rem; padding: 0 2.4px;"></i>
        <i class="fas fa-caret-left sidebar-toggler-hide" style="font-size: 1.2rem; padding: 0 2.4px;"></i>
      </button>
      <a class="navbar-brand" href="inicio">Entrenemos<span class="fw-bold">.uy</span></a>

      <!-- Profile (logged-in) -->
      <% if (session.getAttribute("usuarioLogueado") != null) { %>
      <div class="navbar-profile me-3 me-lg-0">
        <a href="usuario_socio_detail.html">
          <img class="rounded-circle" src="${ usuarioLogueado.getFoto() }" alt="foto de perfil">
        </a>
      </div>
      <% } %>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse pt-3 pt-lg-0 text-center" id="navbarNav">
        <form action="#" method="GET" class="ms-auto me-lg-3 mb-2 mb-lg-0">
          <div class="input-group">
            <input class="form-control form-control-dark" type="search" placeholder="Buscar">
            <button class="btn btn-primary" type="submit"><i class="fas fa-search"></i></button>
          </div>
        </form>

        <!-- Logged-out buttons -->
        <% if (session.getAttribute("usuarioLogueado") == null) { %>
        <div class="navbar-buttons">
          <a href="register.html" class="btn btn-outline-light me-2">Registrarme</a>
          <a href="login" class="btn btn-primary">Iniciar sesión</a>
        </div>
        <% } %>
        
      </div>

    </div>
  </nav>
    
  <div class="d-flex container-fluid page-wrapper px-0">

    <!-- Sidebar -->
    <aside class="sidebar border-end bg-white p-3">
      <ul class="list-unstyled mt-3 ps-0">
        <li class="mb-1">
          <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#instituciones-submenu" aria-expanded="true">Instituciones</button>
          <div class="collapse show" id="instituciones-submenu">
            <ul class="list-unstyled pb-1 small sidebar-submenu">
              <li><a href="actividad_list.html" class="link-dark rounded">Instituto Natural</a></li>
              <li><a href="actividad_list.html" class="link-dark rounded">Fuerza Bruta</a></li>
              <li><a href="actividad_list.html" class="link-dark rounded">Telón</a></li>
              <li><a href="actividad_list.html" class="link-dark rounded">Olympic</a></li>
            </ul>
          </div>
        </li>
        <li class="mb-1">
          <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#categorias-submenu" aria-expanded="true">Categorías</button>
          <div class="collapse show" id="categorias-submenu">
            <ul class="list-unstyled pb-1 small sidebar-submenu">
              <li><a href="actividad_list.html" class="link-dark rounded">Al aire libre</a></li>
              <li><a href="actividad_list.html" class="link-dark rounded">Deportes</a></li>
              <li><a href="actividad_list.html" class="link-dark rounded">Fitness</a></li>
              <li><a href="actividad_list.html" class="link-dark rounded">Gimnasia</a></li>
            </ul>
          </div>
        </li>
        <li class="mb-1">
          <a href="usuario_list.html" class="btn sidebar-submenu-button align-items-center rounded" id="personas">Personas</a>
        </li>
        
        
        <% if (session.getAttribute("usuarioLogueado") != null) { %>
        <li class="border-top my-3"></li>
        <li class="mb-1">
          <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#cuenta-submenu" aria-expanded="true">Cuenta</button>
          <div class="collapse show" id="cuenta-submenu">
            <ul class="list-unstyled pb-1 small sidebar-submenu">
              <li><a href="usuario_socio_detail.html" class="link-dark rounded">Mi perfil</a></li>
              
              <% DataUsuario usr = (DataUsuario)session.getAttribute("usuarioLogueado"); %>
              <% if (usr.getTipoUsuario().equals("Socio")) { %>
              <li><a href="registro_clase.html" class="link-dark rounded">Registrarme a clase</a></li>
              <li><a href="comprar_cuponera.html" class="link-dark rounded">Comprar una cuponera</a></li>
              
              <% } else { %>
              <li><a href="actividad_create.html" class="link-dark rounded">Crear una actividad deportiva</a></li>
              <li><a href="clase_create.html" class="link-dark rounded">Crear una clase</a></li>
              <% } %>
              
              
              <li><a href="logout" class="link-dark rounded">Cerrar sesión</a></li>
            </ul>
          </div>
        </li>
        <% } %>
        
        
        
      </ul>
    </aside>

    <!-- Page content -->
    <main class="main-content">
      <div id="index-page" class="container-fluid p-4 results-page">
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/voleibol.jpg" alt="actividad deportiva" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">Voleibol</h5>
              <p class="card-text">Voleibol en todas sus formas</p>
              <a href="actividad_detail.html" class="btn btn-primary">Ver más</a>
            </div>
          </div>
        </div>
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/atletismo.jpg" alt="actividad deportiva" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">Atletismo</h5>
              <p class="card-text">100m , 200m, postas y carreras con obstaculos.</p>
              <a href="actividad_detail.html" class="btn btn-primary">Ver más</a>
            </div>
          </div>
        </div>
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/basquetbol.jpg" alt="actividad deportiva" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">Basquetbol</h5>
              <p class="card-text">Basquetbol para todos.</p>
              <a href="actividad_detail.html" class="btn btn-primary">Ver más</a>
            </div>
          </div>
        </div>
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/pelota.jpg" alt="cuponera" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">Pelota</h5>
              <p class="card-text">Deportes con pelota.</p>
              <a href="cuponera_detail.html" class="btn btn-primary">Ver más</a>
            </div>
          </div>
        </div>

      </div>
    </main>
    
  </div>
  
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/sidebar.js"></script>
  
</body>
</html>