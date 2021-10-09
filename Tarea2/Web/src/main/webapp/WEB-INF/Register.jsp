<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
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
  
  <title>Registro | Entrenemos.uy</title>
</head>
<body>
    
  <!-- Form page -->
  <main class="form-page tab-page" id="register-page">

    <form method="post" class="text-center py-5 px-4 m-3 bg-white shadow rounded" method="POST">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light" id="registro-label">Registro</h5> 
      <div class="border-top my-4"></div>
      <div class="form-tab active">
        <button class="btn btn-lg btn-outline-primary w-100 mt-2" id="socio-button">Registrarme como socio</button>
        <button class="btn btn-lg btn-primary w-100 mt-2" id="profesor-button">Registrarme como profesor</button>
      </div>
      <div class="form-tab">
        <div class="form-floating mb-3">
          <input type="email" class="form-control" name="correo" id="emailInput" placeholder="Correo electrónico" required>
          <label for="emailInput">Correo electrónico</label>
        </div>
        <div class="form-floating mb-3">
          <input type="password" class="form-control" name="contrasena" id="passwordInput" placeholder="Contraseña">
          <label for="passwordInput">Contraseña</label>
        </div>
        <div class="form-floating mb-3">
          <input type="password" class="form-control" id="passwordConfirmInput" placeholder="Confirmación de la contraseña">
          <label for="passwordConfirmInput">Confirmación de la contraseña</label>
        </div>
      </div>
      <div class="form-tab">
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="nombre" id="nombreInput" placeholder="Nombre">
          <label for="nombreInput">Nombre</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="apellido" id="apellidoInput" placeholder="Apellido">
          <label for="apellidoInput">Apellido</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="nombreUsuario" id="nombreUsuarioInput" placeholder="Nombre de usuario">
          <label for="nombreUsuarioInput">Nombre de usuario</label>
        </div>
        <div class="form-floating mb-3">
          <input type="date" class="form-control" name="nacimiento" id="nacimientoInput" placeholder="Fecha de nacimiento">
          <label for="nacimientoInput">Fecha de nacimiento</label>
        </div>
      </div>
      <div id="profesor-tab">
        <div class="form-floating mb-3">
          <select class="form-select" name="institucion" id="institucionSelect">
            <option selected disabled hidden>Selecciona una institución</option>
            <option value="Fuerza Bruta">Fuerza Bruta</option>
            <option value="Telón">Telón</option>
          </select>
          <label for="institucionSelect">Institución</label>
        </div>
        <div class="form-floating mb-3">
          <textarea class="form-control" name="descripcion" id="descripcionTextArea" placeholder="Descripción"></textarea>
          <label for="descripcionTextArea">Descripción</label>
        </div>
        <div class="form-floating mb-3">
          <textarea class="form-control" name="biografia" id="biografiaTextArea" placeholder="Biografía"></textarea>
          <label for="biografiaTextArea">Biografía</label>
        </div>
        <div class="form-floating mb-3">
          <input type="url" class="form-control" name="sitioWeb" id="sitioWebInput" placeholder="Sitio web">
          <label for="sitioWebInput">Sitio web</label>
        </div>
      </div>
      <button class="btn btn-secondary rounded-circle" id="prev-button">
        <i class="fas fa-arrow-left" style="padding: 5px 0;"></i>
      </button>
      <button class="btn btn-lg btn-primary w-100 mt-2" id="next-button">Siguiente</button>
      <button type="submit" class="btn btn-lg btn-primary w-100 mt-2" id="register-button">Registrarme</button>
      <p class="mt-3" id="registered-text">¿Ya estás registrado? <a href="login.html" class="text-decoration-none">Entrar</a></p>
    </form>

  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/register-form.js"></script>
  
</body>
</html>