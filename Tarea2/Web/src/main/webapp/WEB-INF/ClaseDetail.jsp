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
  
  <title>${clase.getNombre()} | Entrenemos.uy</title>
</head>
<body>
  
  <jsp:include page="Navbar.jsp" />
    
  <div class="d-flex container-fluid page-wrapper px-0">

    <jsp:include page="Sidebar.jsp" />

    <!-- Page content -->
    <main class="main-content bg-white" id="clase-page">
      <div class="row g-0">

        <section class="details col-12 col-lg-8 p-3">
          <div class="details-main mb-3">
            <img src="${clase.getImagen()}" alt="${clase.getNombre()}" class="img-fluid rounded">
            <div class="p-3">
              <h1 class="mb-3">${clase.getNombre()}</h1>
              <p class="lead mb-1">Clase de 
                <a href="actividades/${clase.getActividad()}" class="text-decoration-none">${clase.getActividad()}</a>
              </p>
              <p class="lead mb-1">Dictada por  
                <a href="usuarios/${clase.getProfesor()}" class="text-decoration-none">${clase.getProfesor()}</a>
              </p>
              <c:if test="${esSocio && noExpiro}">
                <a href="clases/registro?clase=${clase.getNombre()}"  class="btn btn-primary mt-3">Registrarme a la clase</a>
              </c:if>
            </div>
          </div>
          <div class="border-top my-4"></div>
          <h4 class="fw-light">Detalles</h4>
          <jsp:useBean id="date" class="java.util.Date"/>
          <table class="table table-borderless">
            <tr>
              <td><i class="far fa-calendar rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px 9.6px"></i>Fecha: <span class="fw-bold ms-1"><fmt:formatDate value="${clase.getFecha()}" type="date"  dateStyle = "short" timeStyle = "short" /></span></td>
            </tr>
            <tr>
              <td><i class="far fa-clock rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px"></i>Hora: <span class="fw-bold ms-1"><fmt:formatDate value="${clase.getFecha()}" type="time"  dateStyle = "short" timeStyle = "short" /></span></td>
            </tr>
            <tr>
              <td><i class="fas fa-link rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px;"></i>URL: <span class="fw-bold ms-1">${clase.getURL()} </span></td>
            </tr>
            <tr>
              <td><i class="fas fa-gift rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px"></i>Premio: <span class="fw-bold ms-1">guantillas (2)</span></td>
            </tr>
          </table>
        </section>
        
        <aside class="detail-sidebar col-lg-4 px-3 pb-3 py-lg-3">
          <div class="ratio ratio-4x3 mb-3">
            <iframe src="https://www.youtube.com/embed/_IMil1Lj-Z8" title="YouTube video" allowfullscreen></iframe>
          </div>
          <div class="border-top my-4"></div>
          <div class="card mb-3">
            <div class="card-header">
              Socios ganadores del sorteo
            </div>
            <div class="list-group list-group-flush">
              <a href="clase_detail.html" class="list-group-item">
                <img class="rounded-circle me-2" src="img/andy.jpg" alt="socio">
                andy
              </a>
              <a href="clase_detail.html" class="list-group-item">
                <img class="rounded-circle me-2" src="img/denis.jpg" alt="socio">
                denis
              </a>
              <a href="clase_detail.html" class="list-group-item">
                <img class="rounded-circle me-2" src="img/Emi71.jpg" alt="socio">
                Emi71
              </a>
            </div>
          </div>
        </aside>
      
      </div>
    </main>

  </div>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/sidebar.js"></script>
  
</body>
</html>