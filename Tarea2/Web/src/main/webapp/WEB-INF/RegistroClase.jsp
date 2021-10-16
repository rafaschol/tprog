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
  
  <title>Registro a clase | Entrenemos.uy</title>
</head>
<body>
    
  <!-- Form page -->
  <main class="form-page tab-page">

    <form class="text-center py-5 px-4 m-3 bg-white shadow rounded" method="POST">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light">Registro a clase</h5>
      <div class="border-top my-4"></div>
      <div class="form-tab active">
        <div class="form-floating mb-3">
          <select class="form-select" name="actividad" id="actividadSelect">
            <option selected disabled hidden>Selecciona una actividad deportiva</option>
            <option value="Voleibol">Voleibol</option>
            <option value="Atletismo">Atletismo</option>
            <option value="Basquetbol">Basquetbol</option>
          </select>
          <label for="actividadSelect">Actividad deportiva</label>
        </div>
        <div class="form-floating mb-3">
          <select class="form-select" name="clase" id="claseSelect">
            <option selected disabled hidden>Selecciona una clase</option>
            <option value="Voleibol">Voleibol</option>
            <option value="Atletismo">Atletismo</option>
            <option value="Basquetbol">Basquetbol</option>
          </select>
          <label for="claseSelect">Clase</label>
        </div>
      </div>
      <div class="form-tab">
        <div class="mb-2">
          <input type="radio" class="btn-check" name="tipoRegistro" id="registroNormal" autocomplete="off" checked>
          <label class="btn btn-outline-secondary w-100" for="registroNormal">Registro normal</label>
        </div>
        <div class="mb-3">
          <input type="radio" class="btn-check" name="tipoRegistro" id="registroCuponera" autocomplete="off">
          <label class="btn btn-outline-secondary w-100" for="registroCuponera">Registro con cuponera</label>
        </div>
        <div class="form-floating mb-3">
          <select class="form-select" name="cuponera" id="cuponeraSelect" disabled>
            <option selected disabled hidden>Selecciona una cuponera</option>
             <c:forEach items="${cuponeras}" var="cuponera">
           	 	<option value="Pelota">${cuponera}</option>
             </c:forEach>
          </select>
          <label for="cuponeraSelect">Cuponera</label>
        </div>
      </div>
      <button class="btn btn-secondary rounded-circle" id="prev-button">
        <i class="fas fa-arrow-left" style="padding: 5px 0;"></i>
      </button>
      <button class="btn btn-lg btn-primary w-100 mt-2" id="next-button">Siguiente</button>  
      <button type="submit" class="btn btn-lg btn-primary w-100 mt-2" id="submit-button">Registrarme</button> 
    </form>

  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/form-tabs.js"></script>
  <script src="js/registro-clase.js"></script>
  
</body>
</html>