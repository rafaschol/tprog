<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Meta tags -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Stylesheets -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <link rel="stylesheet" href="css/base.css">
  <link rel="stylesheet" href="css/index.css">
  
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
      <a class="navbar-brand" href="#">Entrenemos<span class="fw-bold">.uy</span></a>

      <!-- Profile (logged-in) -->
      <% if (request.getSession().getAttribute("loggedUser") != null) { %>
      <div class="navbar-profile me-3 me-lg-0">
        <a href="#">
          <img class="rounded-circle" src="img/profile.jpg" alt="profile">
        </a>
      </div>
      <% } %>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
      </button>      
      <div class="collapse navbar-collapse pt-3 pt-lg-0 text-center" id="navbarNav">
        <form action="search.html" method="GET" class="ms-auto me-lg-3 mb-2 mb-lg-0">
          <div class="input-group">
            <input class="form-control form-control-dark" type="search" placeholder="Buscar">
            <button class="btn btn-primary" type="submit"><i class="fas fa-search"></i></button>
          </div>
        </form>

        <!-- Logged-out buttons -->
        <% if (request.getSession().getAttribute("loggedUser") == null) { %>
        <div class="navbar-buttons">
          <a href="register.html" class="btn btn-outline-light me-2">Registrarme</a>
          <a href="login" class="btn btn-primary">Iniciar sesi�n</a>
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
          <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#instituciones-submenu" aria-expanded="false">Instituciones</button>
          <div class="collapse" id="instituciones-submenu">
            <ul class="list-unstyled pb-1 small sidebar-submenu">
              <li><a href="#" class="link-dark rounded">Instituto Natural</a></li>
              <li><a href="#" class="link-dark rounded">Fuerza Bruta</a></li>
              <li><a href="#" class="link-dark rounded">Tel�n</a></li>
              <li><a href="#" class="link-dark rounded">Olympic</a></li>
            </ul>
          </div>
        </li>
        <li class="mb-1">
          <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#categorias-submenu" aria-expanded="false">Categor�as</button>
          <div class="collapse" id="categorias-submenu">
            <ul class="list-unstyled pb-1 small sidebar-submenu">
              <li><a href="#" class="link-dark rounded">Al aire libre</a></li>
              <li><a href="#" class="link-dark rounded">F�tbol</a></li>
              <li><a href="#" class="link-dark rounded">Fitness</a></li>
              <li><a href="#" class="link-dark rounded">Gimnasia</a></li>
            </ul>
          </div>
        </li>
        <li class="border-top my-3"></li>
        <li class="mb-1">
          <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#cuenta-submenu" aria-expanded="false">Cuenta</button>
          <div class="collapse" id="cuenta-submenu">
            <ul class="list-unstyled pb-1 small sidebar-submenu">
              <li><a href="#" class="link-dark rounded">Mi perfil</a></li>
              <li><a href="#" class="link-dark rounded">Registrarme a clase</a></li>
              <li><a href="#" class="link-dark rounded">Cerrar sesi�n</a></li>
            </ul>
          </div>
        </li>
      </ul>
    </aside>

    <!-- Page content -->
    <main class="main-content">
      <div id="index-page" class="container-fluid p-4 results-page">
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/futbol.jpg" alt="example image" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">F�tbol</h5>
              <p class="card-text">El f�tbol es ampliamente considerado el deporte m�s popular del mundo, pues lo practican unas 270 millones de personas.</p>
              <a href="#" class="btn btn-primary">Ver m�s</a>
            </div>
          </div>
        </div>
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/basquetbol.jpg" alt="example image" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">B�squetbol</h5>
              <p class="card-text">El b�squetbol es un deporte de equipo, jugado entre dos conjuntos de cinco jugadores cada uno durante cuatro per�odos o cuartos de diez minutos cada uno.</p>
              <a href="#" class="btn btn-primary">Ver m�s</a>
            </div>
          </div>
        </div>
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/tenis.jpg" alt="example image" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">Tenis</h5>
              <p class="card-text">El tenis es un deporte de raqueta practicado sobre una pista rectangular, delimitada por l�neas y dividida por una red.</p>
              <a href="#" class="btn btn-primary">Ver m�s</a>
            </div>
          </div>
        </div>
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/example.png" alt="example image" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">F�tbol</h5>
              <p class="card-text">Victor es un apasionado de los m�sculos. Sus clases son organizadas en funci�n de distintos aparatos y pesas con el objetivo de desarrollar m�sculos.</p>
              <a href="#" class="btn btn-primary">Ver m�s</a>
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