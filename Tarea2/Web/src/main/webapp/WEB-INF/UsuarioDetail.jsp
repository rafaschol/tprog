<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<!DOCTYPE html>
<html>
<head>
  <!-- Meta tags -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />

  <!-- Stylesheets -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <link rel="stylesheet" href="css/base.css">
  <link rel="stylesheet" href="css/detail-page.css">
  
  <!-- Icons -->
  <script src="https://kit.fontawesome.com/45d333caf9.js" crossorigin="anonymous"></script>
  
  <title>sergiop | Entrenemos.uy</title>
</head>
<body>
  
  <jsp:include page="Navbar.jsp" />
    
  <div class="d-flex container-fluid page-wrapper px-0">

    <jsp:include page="Sidebar.jsp" />

    <!-- Page content -->
    <main class="main-content bg-white" id="user-page">

      <section class="details p-3">

        <div class="details-main mb-4">
          <img src="img/sergiop.jpg" alt="foto de perfil" class="img-fluid rounded">
          <div class="p-3">
            <h1>Sergio Perez <span class="text-muted fw-light">(sergiop)</span></h1>
            <p class="lead text-muted mb-1">
              sergi@gmail.com.uy &#8212;
              <a href="#" class="text-decoration-none text-reset me-1"><span class="fw-bold">3</span> seguidos</a>
              <a href="#" class="text-decoration-none text-reset"><span class="fw-bold">2</span> seguidores</a>
            </p>
            <button class="btn btn-primary mt-3" id="seguir-button">Seguir</button>
          </div>
        </div>

        <div class="user-tabs border rounded p-3">

          <nav>
            <div class="nav nav-pills mb-3" id="nav-tab" role="tablist">
              <button class="nav-link active" id="nav-perfil-tab" data-bs-toggle="tab" data-bs-target="#nav-perfil" type="button" role="tab" aria-controls="nav-perfil" aria-selected="true">Perfil</button>
              <button class="nav-link" id="nav-clases-tab" data-bs-toggle="tab" data-bs-target="#nav-clases" type="button" role="tab" aria-controls="nav-clases" aria-selected="false">Clases</button>
              <button class="nav-link" id="nav-seguidos-tab" data-bs-toggle="tab" data-bs-target="#nav-seguidos" type="button" role="tab" aria-controls="nav-seguidos" aria-selected="false">Seguidos</button>
              <button class="nav-link" id="nav-seguidores-tab" data-bs-toggle="tab" data-bs-target="#nav-seguidores" type="button" role="tab" aria-controls="nav-seguidores" aria-selected="false">Seguidores</button>
            </div>
          </nav>
          <div class="tab-content" id="nav-tabContent">

            <!-- Tab de perfil -->
            <div class="tab-pane fade show active py-2 px-3" id="nav-perfil" role="tabpanel" aria-labelledby="nav-home-tab">
              <form>
                <div class="row mb-1 perfil-group">
                  <label for="nombreUsuarioInput" class="col-sm-3 col-form-label">Nombre de usuario</label>
                  <div class="col-10 col-sm-7">
                    <input type="text" readonly class="form-control-plaintext" name="nombreUsuario" id="nombreUsuarioInput" value="sergiop">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="nombreInput" class="col-sm-3 col-form-label">Nombre</label>
                  <div class="col-10 col-sm-7">
                    <input type="text" readonly class="form-control-plaintext" name="nombre" id="nombreInput" value="Sergio">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="apellidoInput" class="col-sm-3 col-form-label">Apellido</label>
                  <div class="col-10 col-sm-7">
                    <input type="text" readonly class="form-control-plaintext" name="apellido" id="apellidoInput" value="Perez">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="correoInput" class="col-sm-3 col-form-label">Correo electrÃ³nico</label>
                  <div class="col-10 col-sm-7">
                    <input type="email" readonly class="form-control-plaintext" name="correo" id="correoInput" value="sergi@gmail.com.uy">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="nacimientoInput" class="col-sm-3 col-form-label">Fecha de nacimiento</label>
                  <div class="col-10 col-sm-7">
                    <input type="date" readonly class="form-control-plaintext" name="nacimiento" id="nacimientoInput" value="1950-01-28">
                  </div>
                </div>
              </form>
            </div>

            <!-- Tab de clases -->
            <div class="tab-pane fade" id="nav-clases" role="tabpanel" aria-labelledby="nav-clases-tab">
              <div class="list-group list-group-flush">
                <a href="clases/calistenia" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/calistenia.jpg" alt="clase">
                  Calistenia
                </a>
                <a href="clases/voleibol" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/voleibol_clase.jpg" alt="clase">
                  Voleibol
                </a>
                <a href="clases/mariposa" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/mariposa.jpg" alt="clase">
                  Mariposa
                </a>
                <a href="clases/boxeo_ii" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/boxeo_ii.jpg" alt="clase">
                  Boxeo II
                </a>
                <a href="clases/musculos_para_boxeo" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/musculos_para_boxeo.jpg" alt="clase">
                  MÃºsculos para boxeo
                </a>
                <a href="clases/basquet_i" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/basquet_i.jpg" alt="clase">
                  Basquet I
                </a>
              </div>
            </div>

            <!-- Tabs de seguidos y seguidores -->
            <div class="tab-pane fade" id="nav-seguidos" role="tabpanel" aria-labelledby="nav-seguidos-tab">
              <div class="list-group list-group-flush">
                <a href="usuarios/euge" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/euge.jpg" alt="usuario">
                  euge
                </a>
                <a href="usuarios/andy" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/andy.jpg" alt="usuario">
                  andy
                </a>
                <a href="usuarios/clazar" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/clazar.jpg" alt="usuario">
                  clazar
                </a>
              </div>
            </div>

            <div class="tab-pane fade" id="nav-seguidores" role="tabpanel" aria-labelledby="nav-seguidores-tab">
              <div class="list-group list-group-flush">
                <a href="usuarios/m1k4" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/m1k4.jpg" alt="usuario">
                  m1k4
                </a>
                <a href="usuarios/denis" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/denis.jpg" alt="usuario">
                  denis
                </a>
              </div>
            </div>

          </div>
        </div>          
      </section>

    </main>
  </div>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/sidebar.js"></script>
  <script src="js/usuario-detail.js"></script>
  
</body>
</html>