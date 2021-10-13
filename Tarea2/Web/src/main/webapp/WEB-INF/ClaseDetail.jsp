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
  
  <title>Voleibol | Entrenemos.uy</title>
</head>
<body>
  
  <jsp:include page="Navbar.jsp" />
    
  <div class="d-flex container-fluid page-wrapper px-0">

    <jsp:include page="Sidebar.jsp" />

    <!-- Page content -->
    <main class="main-content bg-white" id="clase-page">

      <section class="details p-3">
        <div class="details-main mb-3">
          <img src="${clase.getImagen() != null ? clase.getImagen()  :  'img/default.jpg'}" alt="clase" class="img-fluid rounded">
          <div class="p-3">
            <h1 class="mb-3">${clase.getNombre()}</h1>
            <p class="lead mb-1">Clase de 
              <a href="actividades/${clase.getActividad()}" class="text-decoration-none">${clase.getActividad()}</a>
            </p>
            <p class="lead mb-1">Dictada por  
              <a href="profesores/${clase.getProfesor()}" class="text-decoration-none">${clase.getProfesor()}</a>
            </p>
            <a href="clases/registro?id=${clase.getNombre()}" class="btn btn-primary mt-3">Registrarme a la clase</a>
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
        </table>
      </section>
    </main>

  </div>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/sidebar.js"></script>
  
</body>
</html>