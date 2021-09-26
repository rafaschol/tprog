<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Meta tags -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <!-- Stylesheets -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <link rel="stylesheet" href="css/base.css">
  <link rel="stylesheet" href="css/form-page.css">
  
  <!-- Icons -->
  <script src="https://kit.fontawesome.com/45d333caf9.js" crossorigin="anonymous"></script>
  
  <title>Iniciar sesión | Entrenemos.uy</title>
</head>
<body>

  <!-- Form page -->
  <main class="form-page" id="login-page">

    <form method="post" class="text-center py-5 px-4 m-3 bg-white shadow rounded">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light">Iniciar sesión</h5>
      <div class="border-top my-4"></div>
      <div class="form-floating mb-3">
        <input type="email" class="form-control${ loginError != null ? ' is-invalid' : '' }" id="emailInput" name="email" placeholder="Correo electrónico" aria-describedly="invalidUsername">
        <label for="emailInput">Correo electrónico</label>
        <% if (request.getAttribute("loginError") != null) { %>
       	<div id="invalidUsername" class="invalid-feedback">
	      El nombre de usuario o la contraseña son incorrectos.
	    </div>
	    <% } %>
      </div>
      <div class="form-floating mb-3">
        <input type="password" class="form-control${ loginError ? ' is-invalid' : '' }" id="passwordInput" name="password" placeholder="Contraseña" aria-describedby="invalidPassword">
        <label for="passwordInput">Contraseña</label>
        <% if (request.getAttribute("loginError") != null) { %>
       	<div id="invalidPassword" class="invalid-feedback">
	      El nombre de usuario o la contraseña son incorrectos.
	    </div>
	    <% } %>
      </div>
      <button type="submit" class="btn btn-lg btn-primary w-100 mt-2">Iniciar sesión</button>
      <p class="mt-3">¿No tienes una cuenta? <a href="register.html" class="text-decoration-none">Regístrate</a></p>
    </form>

  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>
</html>