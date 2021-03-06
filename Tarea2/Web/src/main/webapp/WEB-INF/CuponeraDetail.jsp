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
  
  <title>${cuponera.getNombre()} | Entrenemos.uy</title>
</head>
<body>
   
  <jsp:include page="Navbar.jsp" />
    
  <div class="d-flex container-fluid page-wrapper px-0">

    <jsp:include page="Sidebar.jsp" />

    <!-- Page content -->
    <main class="main-content bg-white">
      <div class="row g-0">

        <section class="details col-12 col-lg-8 p-3">
          <div class="details-main mb-3">
              <img src="${cuponera.getFoto()}" alt="${cuponera.getNombre()}" class="img-fluid rounded">
              <div class="p-3">
                <h1 class="mb-3">${cuponera.getNombre()}</h1>
                <p>${cuponera.getDescripcion()}.</p>
              </div>
          </div>
          <div class="border-top my-4"></div>
          <h4 class="fw-light">Detalles</h4>
          <table class="table table-borderless">
          <jsp:useBean id="date" class="java.util.Date"/>
          
            <tr>
              <td><i class="fas fa-percent rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px 9.6px;"></i>Descuento: <span class="fw-bold ms-1">${String.format("%.1f", descuento)}%</span></td>
            </tr>
            <tr>
              <td><i class="far fa-calendar-plus rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px 9.6px;"></i>Per??odo: <span class="fw-bold ms-1"><fmt:formatDate value="${cuponera.getFechaIni().toGregorianCalendar().getTime()}" type="date"  dateStyle = "short" timeStyle = "short" /> - <fmt:formatDate value="${cuponera.getFechaFin().toGregorianCalendar().getTime()}" type="date"  dateStyle = "short" timeStyle = "short" /></span></td>
            </tr>
            <tr>
              <td><i class="fas fa-dollar-sign rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px 12.6px;"></i>Costo total: <span class="fw-bold ms-1">$${String.format("%.0f", cuponera.getCosto())}</span></td>
            </tr>
            <tr>
              <td><i class="far fa-calendar rounded-circle me-2" style="font-size: 1.2rem; padding: 8.4px 9.6px"></i>Fecha de alta: <span class="fw-bold ms-1"><fmt:formatDate value="${cuponera.getFechaAlta().toGregorianCalendar().getTime()}" type="date"  dateStyle = "short" timeStyle = "short" /></span></td>
            </tr>
          </table>
          <div class="border-top my-4"></div>
          <p><span class="fw-bold">Categor??as: </span>
            <c:forEach items="${categorias}" var="categoria" varStatus="loop">
            	 <a  href="buscar?cat=${categoria}" class="text-decoration-none">${categoria}</a>${!loop.last ? ', ' : ''}
             </c:forEach>
          </p>
          <div class="border-top my-4 d-lg-none"></div>
        </section>
        
        <aside class="detail-sidebar col-lg-4 px-3 pb-3 py-lg-3">
          <div class="card">
            <div class="card-header">
              Actividades deportivas
            </div>
            <div class="list-group list-group-flush">
             <c:forEach items="${actividades}" var="actividad">
              <a href="actividades/${actividad.getNombre()}" class="list-group-item">
                <img class="rounded-circle me-2" src="${actividad.getFoto()}" alt="${actividad.getNombre()}">
                ${actividad.getNombre()}
              </a>
              </c:forEach>
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