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
  <main class="form-page tab-page">

    <form class="text-center py-5 px-4 m-3 bg-white shadow rounded" method="POST">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light">Nueva actividad deportiva</h5>
      <div class="border-top my-4"></div>
      <div class="form-tab active">
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="nombre" id="nombreInput" placeholder="Nombre">
          <label for="nombreInput">Nombre</label>
        </div>
        <div class="form-floating mb-3">
          <textarea class="form-control" name="descripcion" id="descripcionTextArea" placeholder="DescripciÃ³n"></textarea>
          <label for="descripcionTextArea">DescripciÃ³n</label>
        </div>
        <div class="form-floating mb-3">
          <input type="number" class="form-control" name="duracion" id="duracionInput" placeholder="DuraciÃ³n (minutos)" value="60" min="1">
          <label for="duracionInput">DuraciÃ³n (minutos)</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="costo" id="costoInput" placeholder="Costo ($)">
          <label for="costoInput">Costo ($)</label>
        </div>
      </div>
      <div class="form-tab">
        <label for="institucionSelect" class="d-block mb-3 text-start">Selecciona una o mÃ¡s categorÃ­as</label>
        <select class="form-select mb-3" multiple name="categorias" id="categoriasSelect">
          <option selected disabled hidden>Selecciona una o mÃ¡s categorÃ­as</option>
          <c:forEach items="${categorias}" var="categoria">
          	<option value="${categoria}">${categoria}</option>
 	      </c:forEach>
        </select>
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