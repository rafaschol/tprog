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
  
  <title>${usuario.getNickname()} | Entrenemos.uy</title>
</head>
<body>
  
  <jsp:include page="Navbar.jsp" />
    
  <div class="d-flex container-fluid page-wrapper px-0">

    <jsp:include page="Sidebar.jsp" />

    <!-- Page content -->
    <main class="main-content bg-white" id="user-page">

      <section class="details p-3">

        <div class="details-main mb-4">
          <img src="${usuario.getFoto()}" alt="${usuario.getNombre()}" class="img-fluid rounded">
          <div class="p-3">
            <h1>${usuario.getNombre()} ${usuario.getApellido()}<span class="text-muted fw-light"> (${usuario.getNickname()})</span></h1>
            <p class="lead text-muted mb-1">
              ${usuario.getEmail()} &#8212;
              <a href="#" class="text-decoration-none text-reset me-1"><span class="fw-bold">${nSeguidos}</span> seguidos</a>
              <a href="#" class="text-decoration-none text-reset"><span class="fw-bold">${nSeguidores}</span> seguidores</a>
            </p>
            <c:if test="${uLogueado && (not suCuenta)}">
              <form action="usuarios/seguir" method="post">
                <input type="hidden" name="seguir" value="${!siguiendolo}">
                <input type="hidden" name="usuario" value="${usuario.getNickname()}">
                <button class="btn mt-3 ${siguiendolo ? 'btn-outline-primary siguiendo' : 'btn-primary'}" id="seguir-button">${siguiendolo ? 'Siguiendo' : 'Seguir'}</button>
              </form>
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
	               <c:if test = "${esProfesor && suCuenta}">
	              	<button class="nav-link" id="nav-actividades-sin-aceptar-tab" data-bs-toggle="tab" data-bs-target="#nav-actividades-sin-aceptar" type="button" role="tab" aria-controls="nav-actividades-sin-aceptar" aria-selected="false">Actividades deportivas (sin aceptar)</button>
	              </c:if>
	          </c:if>
	          <c:if test="${esSocio && suCuenta}">
	          	<button class="nav-link" id="nav-cuponeras-tab" data-bs-toggle="tab" data-bs-target="#nav-cuponeras" type="button" role="tab" aria-controls="nav-cuponeras" aria-selected="false">Cuponeras</button>
	          	<button class="nav-link" id="nav-premios-tab" data-bs-toggle="tab" data-bs-target="#nav-premios" type="button" role="tab" aria-controls="nav-premios" aria-selected="false">Premios ganados</button>
	          </c:if>
              <button class="nav-link" id="nav-seguidos-tab" data-bs-toggle="tab" data-bs-target="#nav-seguidos" type="button" role="tab" aria-controls="nav-seguidos" aria-selected="false">Seguidos</button>
              <button class="nav-link" id="nav-seguidores-tab" data-bs-toggle="tab" data-bs-target="#nav-seguidores" type="button" role="tab" aria-controls="nav-seguidores" aria-selected="false">Seguidores</button>
            </div>
          </nav>
          <div class="tab-content" id="nav-tabContent">

            <!-- Tab de perfil Socio -->
             <c:if test="${esSocio}">
	            <div class="tab-pane fade show active py-2 px-3" id="nav-perfil" role="tabpanel" aria-labelledby="nav-home-tab">
	              <form method="post">
	                <div class="row mb-1 perfil-group">
	                  <label for="nombreUsuarioInput" class="col-6 col-sm-4 col-form-label">Nombre de usuario</label>
	                  <div class="col-6">
	                    <input type="text" readonly class="form-control-plaintext" name="nombreUsuario" id="nombreUsuarioInput" value="${usuario.getNickname()}">
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group" id="nombreGroup">
	                  <label for="nombreInput" class="col-6 col-sm-4 col-form-label">Nombre</label>
	                  <div class="col-6">
	                    <input type="text" class="form-control-plaintext editable-field" readonly name="nombre" id="nombreInput" value="${usuario.getNombre()}" required>
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group" id="apellidoGroup">
	                  <label for="apellidoInput" class="col-6 col-sm-4 col-form-label">Apellido</label>
	                  <div class="col-6">
	                    <input type="text" class="form-control-plaintext editable-field" readonly name="apellido" id="apellidoInput" value="${usuario.getApellido()}" required>
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group">
	                  <label for="correoInput" class="col-6 col-sm-4 col-form-label">Correo electr??nico</label>
	                  <div class="col-6">
	                    <input type="email" readonly class="form-control-plaintext" name="correo" id="correoInput" value="${usuario.getEmail()}">
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group" id="nacimientoGroup">
	                  <label for="nacimientoInput" class="col-6 col-sm-4 col-form-label">Fecha de nacimiento</label>
	                  <div class="col-6">
	                    <input type="date" readonly class="form-control-plaintext editable-field" id="nacimiento" name="nacimiento" value="${nacimiento}">
	                  </div>
	                </div>

					<c:if test="${esSocio && suCuenta}">
		                <div class="text-center">
		                  <button class="btn btn-primary mt-3 edit" id="edit-button">Editar perfil</button>
		                </div>
	                </c:if>
	              </form>
	            </div>
	          </c:if>
            
            
            <!-- Tab de perfil Profesor -->
           <c:if test="${esProfesor}">
	            <div class="tab-pane fade show active py-2 px-3" id="nav-perfil" role="tabpanel" aria-labelledby="nav-home-tab">
	              <form method="post">
	                <div class="row mb-1 perfil-group">
	                  <label for="nombreUsuarioInput" class="col-6 col-sm-4 col-form-label">Nombre de usuario</label>
	                  <div class="col-6">
	                    <input type="text" readonly class="form-control-plaintext" name="nombreUsuario" id="nombreUsuarioInput" value="${usuario.getNickname()}">
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group" id="nombreGroup">
	                  <label for="nombreInput" class="col-6 col-sm-4 col-form-label">Nombre</label>
	                  <div class="col-6">
	                    <input type="text" class="form-control-plaintext editable-field" readonly name="nombre" id="nombreInput" value="${usuario.getNombre()}" required>
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group" id="apellidoGroup">
	                  <label for="apellidoInput" class="col-6 col-sm-4 col-form-label">Apellido</label>
	                  <div class="col-6">
	                    <input type="text" class="form-control-plaintext editable-field" readonly name="apellido" id="apellidoInput" value="${usuario.getApellido()}" required>
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group">
	                  <label for="correoInput" class="col-6 col-sm-4 col-form-label">Correo electr??nico</label>
	                  <div class="col-6">
	                    <input type="email" readonly class="form-control-plaintext" name="correo" id="correoInput" value="${usuario.getEmail()}">
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group" id="nacimientoGroup">
	                  <label for="nacimientoInput" class="col-6 col-sm-4 col-form-label">Fecha de nacimiento</label>
	                  <div class="col-6">
	                    <input type="date" readonly class="form-control-plaintext editable-field" id="nacimiento" name="nacimiento" value="${nacimiento}">
	                  </div>
	                </div>
	                <div class="row mb-1 perfil-group">
	                  <label for="institucionInput" class="col-6 col-sm-4 col-form-label">Instituci??n</label>
	                  <div class="col-6">
	                    <input type="text" readonly class="form-control-plaintext" name="institucion" id="institucionInput" value="${usuario.getInstitucion()}">
	                  </div>
	                </div>
	
	                <div class="row mb-1 perfil-group" id="descripcionGroup">
	                  <label for="descripcionInput" class="col-6 col-sm-4 col-form-label">Descripci??n</label>
	                  <div class="col-6">
	                    <textarea class="form-control-plaintext editable-field" readonly name="descripcion" id="descripcionInput" required>${usuario.getDescripcion()}</textarea>
	                  </div>
	                </div>
	
	                <div class="row mb-1 perfil-group" id="biografiaGroup">
	                  <label for="biografiaInput" class="col-6 col-sm-4 col-form-label">Biograf??a</label>
	                  <div class="col-6">
	                    <textarea class="form-control-plaintext editable-field" readonly name="biografia" id="biografiaInput">${usuario.getBiografia()}</textarea>
	                  </div>
	                </div>
	
	                <div class="row mb-1 perfil-group" id="sitioWebGroup">
	                  <label for="sitioWebInput" class="col-6 col-sm-4 col-form-label">Sitio web</label>
	                  <div class="col-6">
	                    <input type="text" class="form-control-plaintext editable-field" readonly name="sitioWeb" id="sitioWebInput" value="${usuario.getSitioWeb()}">
	                  </div>
	                </div>
					<c:if test="${suCuenta}">
		                <div class="text-center">
		                  <button class="btn btn-primary mt-3 edit" id="edit-button">Editar perfil</button>
		                </div>
	                </c:if>
	              </form>
	            </div>
            
            </c:if>
            

            <!-- Tab de clases -->
            <div class="tab-pane fade" id="nav-clases" role="tabpanel" aria-labelledby="nav-clases-tab">
              <div class="list-group list-group-flush">
               <jsp:useBean id="dateFechaCompra" class="java.util.Date"/>
               <c:forEach items="${clases}" var="clase">
	                <a href="clases/${clase.getNombre()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src="${clase.getImagen()}" alt="${clase.getNombre()}">
	                  ${clase.getNombre()} <c:if test="${esSocio && suCuenta}">(Comprada por $${clase.getPrecioCompra()} el ${clase.getFechaCompra().toGregorianCalendar().getTime().getDate()}/${clase.getFechaCompra().toGregorianCalendar().getTime().getMonth()+1}/${clase.getFechaCompra().toGregorianCalendar().getTime().getYear()+1900})  </c:if>
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
	                  <img class="rounded-circle me-2" src="${cuponera.getFoto()}" alt="${cuponera.getNombre()}">
	                  ${cuponera.getNombre()}
	                </a>
	              </c:forEach>
	              </div>
	            </div>
	            
	            <!-- Tab de premios ganados -->
                <div class="tab-pane fade" id="nav-premios" role="tabpanel" aria-labelledby="nav-premios-tab">
                  <div class="list-group list-group-flush">
                    <a href="#" class="list-group-item">
                      <img class="rounded-circle me-2" src="img/andy.jpg" alt="premio">
                      carama??ola
                    </a>
                  </div>
                </div>
            </c:if>
          
           
	        <c:if test="${esProfesor}">
		            <!-- Tabs de actividades deportivas -->
	            <div class="tab-pane fade" id="nav-actividades-aceptadas" role="tabpanel" aria-labelledby="nav-actividades-aceptadas-tab">
	              <div class="list-group list-group-flush">
	              <c:forEach items="${actividades}" var="actividad">
	                <a href="actividades/${actividad.getNombre()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src=" ${actividad.getFoto()}" alt="${actividad.getNombre()}">
	                  ${actividad.getNombre()}
	                </a>
	                </c:forEach>
	              </div>
	            </div>
	 		<c:if test="${esProfesor && ( suCuenta)}">
	            <div class="tab-pane fade" id="nav-actividades-sin-aceptar" role="tabpanel" aria-labelledby="nav-actividades-sin-aceptar-tab">
	              <div class="list-group list-group-flush">
	              <c:forEach items="${actividadesPendientes}" var="actividad">
		                <a href="actividades/${actividad.getNombre()}?profesor=${usuario.getNickname()}" class="list-group-item d-flex align-items-center">
		                  <img class="rounded-circle me-2" src="${actividad.getFoto()}" alt="${actividad.getNombre()}">
		                  ${actividad.getNombre()}
		                  <span class="badge bg-${actividad.getEstado() == 'Rechazada' ? 'danger' : 'info'} ms-auto p-2">${actividad.getEstado()}</span>
		                </a>
	               </c:forEach>
	              </div>
	            </div>
	          </c:if>
	      </c:if>
            <!-- Tabs de seguidos y seguidores -->
            <div class="tab-pane fade" id="nav-seguidos" role="tabpanel" aria-labelledby="nav-seguidos-tab">
              <div class="list-group list-group-flush">
              <c:forEach items="${seguidos}" var="seguido">
	                <a href="usuarios/${seguido.getNickname()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src="${seguido.getFoto()}" alt="${seguido.getNickname()}">
	                  ${seguido.getNombre()}
	                </a>
               </c:forEach>
              </div>
            </div>

            <div class="tab-pane fade" id="nav-seguidores" role="tabpanel" aria-labelledby="nav-seguidores-tab">
              <div class="list-group list-group-flush">
               <c:forEach items="${seguidores}" var="seguidor">
	                <a href="usuarios/${seguidor.getNickname()}" class="list-group-item">
	                  <img class="rounded-circle me-2" src="${seguidor.getFoto()}" alt="${seguidor.getNickname()}">
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
  <script> document.getElementById('nacimiento').max = new Date().toISOString().split("T")[0];</script>
  
  <c:if test="${uLogueado && (not suCuenta)}"><script src="js/usuario-detail.js"></script></c:if>
  <c:if test="${(esSocio || esProfesor) && suCuenta}"></c:if> <script src="js/edit-perfil.js"></script>
  
</body>
</html>