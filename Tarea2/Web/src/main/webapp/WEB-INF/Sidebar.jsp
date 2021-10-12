<%@ page import="logica.DataUsuario" %>
<aside class="sidebar border-end bg-white p-3">
  <ul class="list-unstyled mt-3 ps-0">
    <li class="mb-1">
      <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#instituciones-submenu" aria-expanded="true">Instituciones</button>
      <div class="collapse show" id="instituciones-submenu">
        <ul class="list-unstyled pb-1 small sidebar-submenu">
          <li><a href="actividad_list.html" class="link-dark rounded">Instituto Natural</a></li>
          <li><a href="actividad_list.html" class="link-dark rounded">Fuerza Bruta</a></li>
          <li><a href="actividad_list.html" class="link-dark rounded">Tel�n</a></li>
          <li><a href="actividad_list.html" class="link-dark rounded">Olympic</a></li>
        </ul>
      </div>
    </li>
    <li class="mb-1">
      <button class="btn sidebar-submenu-button align-items-center rounded" data-bs-toggle="collapse" data-bs-target="#categorias-submenu" aria-expanded="true">Categor�as</button>
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
      <a href="usuarios" class="btn sidebar-submenu-button align-items-center rounded" id="personas">Personas</a>
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
          <li><a href="clases/registro" class="link-dark rounded">Registrarme a clase</a></li>
          <li><a href="cuponeras/comprar" class="link-dark rounded">Comprar una cuponera</a></li>
          
          <% } else { %>
          <li><a href="actividades/nueva" class="link-dark rounded">Crear una actividad deportiva</a></li>
          <li><a href="clases/nueva" class="link-dark rounded">Crear una clase</a></li>
          <% } %>
          
          
          <li><a href="salir" class="link-dark rounded">Cerrar sesi�n</a></li>
        </ul>
      </div>
    </li>
    <% } %>
    
    
    
  </ul>
</aside>