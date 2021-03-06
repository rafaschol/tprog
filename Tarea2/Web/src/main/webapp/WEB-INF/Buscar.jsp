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
        
        <div class="d-flex justify-content-between mb-3">
          <h3 class="mb-0">Resultados${busqueda != null ? ' de ' : ''}<c:if test="${busqueda != null}"><span class="fw-bold">${busqueda}</span></c:if></h3>
          <div class="d-flex align-items-center">
            <p class="mb-0 small">${fn:length(resultados)} resultados</p>
            <div class="border-start border-secondary mx-4 h-50"></div>
            <label class="me-2 col-form-label col-form-label-sm" for="sortControl">Ordenar por</label>
            <select class="form-select form-select-sm w-auto" id="sortControl">
              <option${orden == null ? ' selected' : ''} value="default">Por defecto</option>
              <option${orden == 'name' ? ' selected' : ''} value="name">Nombre</option>
              <option${orden == 'new' ? ' selected' : ''} value="new">M??s recientes</option>
            </select>
          </div>
        </div>
        
        <div class="filter-tags">
          <c:if test="${institucion != null}">
            <div class="alert tag alert-primary alert-dismissible small mb-0 institucion-tag" role="alert">
              ${institucion}
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
          </c:if>
          <c:if test="${categoria != null}">
            <div class="alert tag alert-primary alert-dismissible small mb-0 categoria-tag" role="alert">
              ${categoria}
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
          </c:if>
        </div>
        
        <div class="border-top my-4"></div>
        
        <c:forEach items="${resultados}" var="resultado">
          <div class="card shadow mb-3">
            <div class="card-content-wrapper">
              <img src="${resultado.getFoto()}" alt="${resultado.getNombre()}" class="img-fluid rounded-start">
              <div class="card-body">
                <div class="badge ${resultado.getTipo() == 'Cuponera' ? 'bg-warning' : 'bg-info'} badge-elemento fw-light">${resultado.getTipo()}</div>
                <h5 class="card-title">${resultado.getNombre()}</h5>
                <p class="card-text">${resultado.getDescripcion()}</p>
                <a href="${resultado.getTipo() == 'Cuponera' ? 'cuponeras' : 'actividades'}/${resultado.getNombre()}" class="btn btn-primary">Ver m??s</a>
              </div>
            </div>
          </div>
        </c:forEach>

      </div>
    </main>
    
  </div>
  
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/sidebar.js"></script>
  <script src="js/search.js"></script>
  
</body>
</html>