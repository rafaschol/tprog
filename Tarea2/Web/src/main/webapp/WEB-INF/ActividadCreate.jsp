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
  
  <title>Nueva actividad deportiva | Entrenemos.uy</title>
</head>
<body>
    
  <!-- Form page -->
  <main class="form-page tab-page" >

    <form class="text-center py-5 px-4 m-3 bg-white shadow rounded" method="post" enctype="multipart/form-data" id="multitab-form" data-tab="${dataTab}" data-pagetype="actividad">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light">Nueva actividad deportiva</h5>
      <div class="border-top my-4"></div>
      <div class="form-tab">
        <div class="form-floating mb-3">
          <input type="text" class="form-control${ actividadRepetida != null ? ' is-invalid' : '' }" name="nombre" id="nombreInput" placeholder="Nombre" value="${nombre != null ? nombre : ''}" aria-describedly="invalidUsername" required>
          <label for="nombreInput">Nombre</label>
          <c:if test="${actividadRepetida}">
            <div id="invalidUsername" class="invalid-feedback d-block">
	          Ya existe una actividad con ese nombre.
	       </div>
        </c:if>
        </div>
        <div class="form-floating mb-3">
          <textarea class="form-control" name="descripcion" id="descripcionTextArea" placeholder="Descripci??n" required>${descripcion != null ? descripcion : ''}</textarea>
          <label for="descripcionTextArea">Descripci??n</label>
        </div>
        <div class="form-floating mb-3">
          <input type="number" class="form-control" name="duracion" id="duracionInput" placeholder="Duraci??n (minutos)" value="${duracion != null ? duracion : '60'}" min="1" required>
          <label for="duracionInput">Duraci??n (minutos)</label>
        </div>
        <div class="form-floating mb-3">
          <input type="number" class="form-control" name="costo" id="costoInput" placeholder="Costo ($)" value="${costo != null ? costo : ''}" required>
          <label for="costoInput">Costo ($)</label>
        </div>
      </div>
      <div class="form-tab">
        <label for="institucionSelect" class="d-block mb-3 text-start">Selecciona una o m??s categor??as</label>
        <select class="form-select mb-3" multiple name="categorias" id="categoriasSelect" required>
          <c:forEach items="${categorias}" var="categoria">
          	<option value="${categoria}">${categoria}</option>
 	      </c:forEach>
        </select>
      </div>
      <div class="form-tab">
        <div class="mb-3">
          <label for="fotoFile" class="form-label">Foto de la actividad deportiva</label>
          <input class="form-control" type="file" name="foto" id="fotoFile" accept="image/png, image/jpeg">
        </div>
      </div>
      <button class="btn btn-secondary rounded-circle" id="prev-button">
        <i class="fas fa-arrow-left" style="padding: 5px 0;"></i>
      </button>
      <button class="btn btn-lg btn-primary w-100 mt-2" id="next-button">Siguiente</button>  
      <button type="submit" class="btn btn-lg btn-primary w-100 mt-2" id="submit-button">Crear</button>
    </form>

  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/form-tabs.js"></script>
  
</body>
</html>