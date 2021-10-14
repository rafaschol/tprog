<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
          <img src="${usuario.getFoto()}" alt="foto de perfil" class="img-fluid rounded">
          <div class="p-3">
            <h1>${usuario.getNombre()}  ${usuario.getApellido()}<span class="text-muted fw-light">(${usuario.getNickname()})</span></h1>
            <p class="lead text-muted mb-1">
              ${usuario.getEmail()} &#8212;
              <a href="#" class="text-decoration-none text-reset me-1"><span class="fw-bold">${nSeguidos}</span> seguidos</a>
              <a href="#" class="text-decoration-none text-reset"><span class="fw-bold">${nSeguidores}</span> seguidores</a>
            </p>
            <c:if test="${uLogueado && (not suCuenta)}">
            	<button class="btn btn-primary mt-3" id="seguir-button">Seguir</button>
            </c:if>
          </div>
        </div>

        <div class="user-tabs border rounded p-3">

          <nav>
            <div class="nav nav-pills mb-3" id="nav-tab" role="tablist">
              <button class="nav-link active" id="nav-perfil-tab" data-bs-toggle="tab" data-bs-target="#nav-perfil" type="button" role="tab" aria-controls="nav-perfil" aria-selected="true">Perfil</button>
              <button class="nav-link" id="nav-clases-tab" data-bs-toggle="tab" data-bs-target="#nav-clases" type="button" role="tab" aria-controls="nav-clases" aria-selected="false">Clases</button>
              <c:if test = "${esProfesor}">
	              <button class="nav-link" id="nav-actividades-aceptadas-tab" data-bs-toggle="tab" data-bs-target="#nav-actividades-aceptadas" type="button" role="tab" aria-controls="nav-actividades-aceptadas" aria-selected="false">Actividades deportivas</button>
	              <button class="nav-link" id="nav-actividades-sin-aceptar-tab" data-bs-toggle="tab" data-bs-target="#nav-actividades-sin-aceptar" type="button" role="tab" aria-controls="nav-actividades-sin-aceptar" aria-selected="false">Actividades deportivas (sin aceptar)</button>
	          </c:if>
	          <c:if test="${esSocio && suCuenta}">
	          	<button class="nav-link" id="nav-cuponeras-tab" data-bs-toggle="tab" data-bs-target="#nav-cuponeras" type="button" role="tab" aria-controls="nav-cuponeras" aria-selected="false">Cuponeras</button>
	          </c:if>
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
                    <input type="text" readonly class="form-control-plaintext" name="nombreUsuario" id="nombreUsuarioInput" value="${usuario.getNickname()}">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="nombreInput" class="col-sm-3 col-form-label">Nombre</label>
                  <div class="col-10 col-sm-7">
                    <input type="text" readonly class="form-control-plaintext" name="nombre" id="nombreInput" value="${usuario.getNombre()}">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="apellidoInput" class="col-sm-3 col-form-label">Apellido</label>
                  <div class="col-10 col-sm-7">
                    <input type="text" readonly class="form-control-plaintext" name="apellido" id="apellidoInput" value="${usuario.getApellido()}">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="correoInput" class="col-sm-3 col-form-label">Correo electrÃ³nico</label>
                  <div class="col-10 col-sm-7">
                    <input type="email" readonly class="form-control-plaintext" name="correo" id="correoInput" value="${usuario.getEmail()}">
                  </div>
                </div>
                <div class="row mb-1 perfil-group">
                  <label for="nacimientoInput" class="col-sm-3 col-form-label">Fecha de nacimiento</label>
                  <div class="col-10 col-sm-7">
                    <jsp:useBean id="date" class="java.util.Date"/>
                    <input type="text" readonly class="form-control-plaintext" path="dueDate" class= "date" name = "dueDate" value = "<fmt:formatDate value="${usuario.getFechaNacimiento()}" pattern="MM/dd/yyyy" />"/>
                  </div>
                </div>
              </form>
            </div>

            <!-- Tab de clases -->
            <div class="tab-pane fade" id="nav-clases" role="tabpanel" aria-labelledby="nav-clases-tab">
              <div class="list-group list-group-flush">
               <c:forEach items="${clases}" var="clase">
	                <a href="clases/${clase.getNombre()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src="${clase.getImagen() != null ? clase.getImagen() :  'img/default.jpg'}" alt="clase">
	                  ${clase.getNombre()}
	                </a>
                </c:forEach>
                
              </div>
            </div>
            
            <c:if test="${esSocio && suCuenta}">
	             <!-- Tab de cuponeras -->
	            <div class="tab-pane fade" id="nav-cuponeras" role="tabpanel" aria-labelledby="nav-cuponeras-tab">
	              <div class="list-group list-group-flush">
	              <c:forEach items="${cuponeras}" var="cuponera">
	                <a href="cuponeras/${cuponera.getNombre()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src="${cuponera.getFoto() != null ? cuponera.getFoto() :  'img/default.jpg'}" alt="cuponera">
	                  ${cuponera.getNombre()}
	                </a>
	              </c:forEach>
	              </div>
	            </div>
            </c:if>
            
           
	         
	            <!-- Tabs de actividades deportivas -->
            <div class="tab-pane fade" id="nav-actividades-aceptadas" role="tabpanel" aria-labelledby="nav-actividades-aceptadas-tab">
              <div class="list-group list-group-flush">
              <c:forEach items="${actividades}" var="vidad">
                <a href="actividad_detail.html" class="list-group-item">
                  <img class="rounded-circle me-2" src="img/voleibol.jpg" alt="cuponera">
                  Voleibol
                </a>
                </c:forEach>
              </div>
            </div>

            <div class="tab-pane fade" id="nav-actividades-sin-aceptar" role="tabpanel" aria-labelledby="nav-actividades-sin-aceptar-tab">
              <div class="list-group list-group-flush">
              <c:forEach items="${actividadesPendientes}" var="vidad">
	                <a href="actividad_detail.html" class="list-group-item d-flex align-items-center">
	                  <img class="rounded-circle me-2" src="img/voleibol_ii.jpg" alt="cuponera">
	                  Voleibol II
	                  <span class="badge bg-danger ms-auto p-2">Rechazada</span>
	                </a>
               </c:forEach>
              </div>
            </div>
	      
            <!-- Tabs de seguidos y seguidores -->
            <div class="tab-pane fade" id="nav-seguidos" role="tabpanel" aria-labelledby="nav-seguidos-tab">
              <div class="list-group list-group-flush">
              <c:forEach items="${seguidos}" var="seguido">
	                <a href="usuarios/${seguido.getNombre()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src="${seguido.getFoto() != null ? seguido.getFoto() :  'img/default.jpg'}" alt="usuario">
	                  ${seguido.getNombre()}
	                </a>
               </c:forEach>
              </div>
            </div>

            <div class="tab-pane fade" id="nav-seguidores" role="tabpanel" aria-labelledby="nav-seguidores-tab">
              <div class="list-group list-group-flush">
               <c:forEach items="${seguidores}" var="seguidor">
	                <a href="usuarios/${seguidor.getNombre()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src="${seguidor.getFoto() != null ? seguidor.getFoto() :  'img/default.jpg'}" alt="usuario">
	                  ${seguidor.getNombre()}
	                </a>
               </c:forEach>
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