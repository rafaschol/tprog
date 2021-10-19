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
  <link rel="stylesheet" href="css/form-page.css">
  
  <!-- Icons -->
  <script src="https://kit.fontawesome.com/45d333caf9.js" crossorigin="anonymous"></script>
  
  <title>Nueva clase | Entrenemos.uy</title>
</head>
<body>
    
  <!-- Form page -->
  <main class="form-page">

    <form class="text-center py-5 px-4 m-3 bg-white shadow rounded" method="post" id="class-form" enctype="multipart/form-data">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light">Nueva clase</h5>
      <div class="border-top my-4"></div>
      <div class="form-floating mb-3">
        <select class="form-select" name="actividad" id="actividadSelect" required>
          <option ${nombreActividad != null ? '' : 'selected '}disabled hidden>Selecciona una actividad deportiva</option>
          <c:forEach items="${actividades}" var="actividad">
          <option ${nombreActividad != null && nombreActividad  == actividad ? 'selected ' : ''}
                value="${actividad}">${actividad}</option>
          </c:forEach>
        </select>
        <label for="actividadSelect">Actividad deportiva</label>
      </div>
      <div class="form-floating mb-3">
        <input type="text" class="form-control${ claseRepetida != null ? ' is-invalid' : '' }" name="nombre" id="nombreInput" placeholder="Nombre" required aria-describedly="invalidUsername" value=${nombre != null ? nombre : ''}>
        <label for="nombreInput">Nombre</label>
        <c:if test="${claseRepetida}">
            <div id="invalidUsername" class="invalid-feedback">
	          Ya existe una clase con ese nombre.
	        </div>
        </c:if>
      </div>
      
      <div class="form-floating mb-3" style="display: flex; gap: 15px; height:100%; margin-bottom: 0px !important;">
        <div class="form-floating mb-3">
        <input type="date" class="form-control" name="fecha" id="FechaInput" placeholder="Fecha" required >
        <label for="FechaInput">Fecha</label>
        </div>
          <div class="form-floating mb-3" style="width:100%;">
        <input type="time" class="form-control" name="hora" id="HoraInput" placeholder="Hora" required>
        <label for="HoraInput">Hora</label>
        </div>
      </div>
      <div class="form-floating mb-3">
        <input type="number" class="form-control" name="minSocios" id="minSociosInput" placeholder="MÃ­nimo de socios" value="${minSocios != null ? minSocios : '0'}" min="0" required>
        <label for="minSociosInput">MÃ­nimo de socios</label>
      </div>
      <div class="form-floating mb-3">
        <input type="number" class="form-control" name="maxSocios" id="maxSociosInput" placeholder="MÃ¡ximo de socios" value="${maxSocios!= null ? maxSocios : '1'}" min="1" required>
        <label for="maxSociosInput">MÃ¡ximo de socios</label>
      </div>
      <div class="form-floating mb-3">
        <input type="text" class="form-control" name="url" id="urlInput" placeholder="Link de la clase" >
        <label for="urlInput">Link de la clase</label>
      </div>
      <div class="mb-3">
          <label for="fotoFile" class="form-label">Foto de la Clase</label>
          <input class="form-control" type="file" name="foto" id="fotoFile" accept="image/png, image/jpeg">
     </div>
      <button type="submit" id="create-button" class="btn btn-lg btn-primary w-100 mt-2">Crear</button>
    </form>

  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/class-form.js"></script>
  
</body>
</html>