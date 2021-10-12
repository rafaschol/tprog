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
  
  <title>Comprar cuponera | Entrenemos.uy</title>
</head>
<body>
    
  <!-- Form page -->
  <main class="form-page tab-page" id="login-page">

    <form class="text-center py-5 px-4 m-3 bg-white shadow rounded">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light">Comprar cuponera</h5>
      <div class="border-top my-4"></div>
      <div class="form-floating mb-3">
        <select class="form-select" name="cuponera" id="cuponeraSelect">
          <option selected disabled hidden>Selecciona una cuponera</option>
          <option value="Pelota">Pelota ($10.680)</option>
        </select>
        <label for="cuponeraSelect">Cuponera</label>
      </div>
      <button type="submit" class="btn btn-lg btn-primary w-100 mt-2">Comprar</button>
    </form>
  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  
</body>
</html>