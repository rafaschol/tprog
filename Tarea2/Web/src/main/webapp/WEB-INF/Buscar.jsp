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
    <link rel="stylesheet" href="css/search.css">
  
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
        
        <c:if test="${busqueda != null}">
          <h2 class="display-6 mb-3">Resultados de "${busqueda}"</h2>
        </c:if>
        
        <div class="filter-tags">
          <c:if test="${institucion != null}">
            <div class="alert tag alert-primary alert-dismissible small mb-0" role="alert">
              ${institucion}
              <button type="button" class="btn-close"></button>
            </div>
          </c:if>
          <c:if test="${categoria != null}">
            <div class="alert tag alert-primary alert-dismissible small mb-0" role="alert">
              ${categoria}
              <button type="button" class="btn-close"></button>
            </div>
          </c:if>
        </div>
        
        <c:if test="${busqueda != null || institucion != null || categoria != null}">
          <div class="border-top my-4"></div>
        </c:if>
        
        <div class="card shadow mb-3">
          <div class="card-content-wrapper">
            <img src="img/voleibol.jpg" alt="actividad deportiva" class="img-fluid rounded-start">
            <div class="card-body">
              <h5 class="card-title">Voleibol</h5>
              <p class="card-text">Voleibol en todas sus formas</p>
              <a href="actividades/Voleibol" class="btn btn-primary">Ver más</a>
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