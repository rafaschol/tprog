<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
  <div class="container-fluid">
    <button class="btn btn-primary rounded-circle me-3 sidebar-toggler">
      <i class="fas fa-caret-right sidebar-toggler-show" style="font-size: 1.2rem; padding: 0 2.4px;"></i>
      <i class="fas fa-caret-left sidebar-toggler-hide" style="font-size: 1.2rem; padding: 0 2.4px;"></i>
    </button>
    <a class="navbar-brand" href="">Entrenemos<span class="fw-bold">.uy</span></a>

    <!-- Profile (logged-in) -->
    <% if (session.getAttribute("usuarioLogueado") != null) { %>
    <div class="navbar-profile me-3 me-lg-0">
      <a href="usuarios/${usuarioLogueado.getNickname()}">
        <img class="rounded-circle" src="${ usuarioLogueado.getFoto() }" alt="foto de perfil">
      </a>
    </div>
    <% } %>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse pt-3 pt-lg-0 text-center" id="navbarNav">
      <form action="buscar" method="GET" class="ms-auto me-lg-3 mb-2 mb-lg-0">
        <div class="input-group">
          <input class="form-control form-control-dark" type="search" placeholder="Buscar" name="q">
          <button class="btn btn-primary" type="submit"><i class="fas fa-search"></i></button>
        </div>
      </form>

      <!-- Logged-out buttons -->
      <% if (session.getAttribute("usuarioLogueado") == null) { %>
      <div class="navbar-buttons">
        <a href="registro" class="btn btn-outline-light me-2">Registrarme</a>
        <a href="ingresar" class="btn btn-primary">Iniciar sesión</a>
      </div>
      <% } %>
      
    </div>

  </div>
</nav>