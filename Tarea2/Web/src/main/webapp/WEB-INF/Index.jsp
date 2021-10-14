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
  <link rel="stylesheet" href="css/list-page.css">
  
  <!-- Icons -->
  <script src="https://kit.fontawesome.com/45d333caf9.js" crossorigin="anonymous"></script>
  
  <title>Inicio | Entrenemos.uy</title>
</head>
<body>

  <jsp:include page="Navbar.jsp" />
    
  <div class="d-flex container-fluid page-wrapper px-0">

	<jsp:include page="Sidebar.jsp" />

    <!-- Page content -->
    <main class="main-content">
      <div id="index-page" class="container-fluid p-4 results-page">
      
      
        <c:forEach items="${actividades}" var="actividad">
	        <div class="card shadow mb-3">
	          <div class="card-content-wrapper">
	            <img src="${actividad.getFoto() != null ? actividad.getFoto() :  'img/default.jpg'}" alt="sin foto Actividad" class="img-fluid rounded-start">
	            <div class="card-body">
	              <div class="badge bg-info badge-elemento">Actividad deportiva</div>
	              <h5 class="card-title">${actividad.getNombre()}</h5>
	              <p class="card-text">${actividad.getDescripcion()}</p>
	              <a href="actividades/${actividad.getNombre()}" class="btn btn-primary">Ver más</a>
	            </div>
	          </div>
	        </div>
        </c:forEach>
        
        <c:forEach items="${cuponeras}" var="cuponera">
	        <div class="card shadow mb-3">
	          <div class="card-content-wrapper">
	            <img src="${cuponera.getFoto() != null ? cuponera.getFoto() :  'img/default.jpg'}" alt="sin foto Cuponera" class="img-fluid rounded-start">
	            <div class="card-body">
                  <div class="badge bg-warning badge-elemento">Cuponera</div>
	              <h5 class="card-title">${cuponera.getNombre()}</h5>
	              <p class="card-text">${cuponera.getDescripcion()}</p>
	              <a href="cuponeras/${cuponera.getNombre()}" class="btn btn-primary">Ver más</a>
	            </div>
	          </div>
	        </div>
        </c:forEach>

      </div>
    </main>
    
  </div>
  
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/sidebar.js"></script>
  
</body>
</html>