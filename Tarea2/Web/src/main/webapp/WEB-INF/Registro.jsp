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
  
  <title>Registro | Entrenemos.uy</title>
</head>
<body>
    
  <!-- Form page -->
  <main class="form-page tab-page" id="register-page">

    <form method="post" class="text-center py-5 px-4 m-3 bg-white shadow rounded" id="register-form" enctype="multipart/form-data" data-tab="${dataTab}" data-usertype="${userType != null ? userType : ''}">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light" id="registro-label">Registro</h5> 
      <div class="border-top my-4"></div>
      <div class="form-tab">
        <button class="btn btn-lg btn-outline-primary w-100 mt-2" id="socio-button">Registrarme como socio</button>
        <button class="btn btn-lg btn-primary w-100 mt-2" id="profesor-button">Registrarme como profesor</button>
      </div>
      <div class="form-tab">
        <div class="form-floating mb-3">
          <input type="email" class="form-control${ mailRepetido != null ? ' is-invalid' : '' }" name="correo" id="emailInput" placeholder="Correo electrónico" required aria-describedly="invalidUsername"
              value=${correo != null ? correo : ''}>
          <label for="emailInput">Correo electrónico</label>
          <c:if test="${mailRepetido}">
            <div id="invalidUsername" class="invalid-feedback">
	          Ya existe un usuario registrado con ese mail.
	        </div>
          </c:if>
        </div>
        <div class="form-floating mb-3">
          <input type="password" class="form-control" name="contrasena" id="passwordInput" placeholder="Contraseña" required>
          <label for="passwordInput">Contraseña</label>
        </div>
        <div class="form-floating mb-3">
          <input type="password" class="form-control" id="passwordConfirmInput" placeholder="Confirmación de la contraseña">
          <label for="passwordConfirmInput">Confirmación de la contraseña</label>
        </div>
      </div>
      <div class="form-tab">
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="nombre" id="nombreInput" placeholder="Nombre" required value="${nombre != null ? nombre : ''}">
          <label for="nombreInput">Nombre</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="apellido" id="apellidoInput" placeholder="Apellido" required value="${apellido != null ? apellido : ''}">
          <label for="apellidoInput">Apellido</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control${ usuarioRepetido != null ? ' is-invalid' : '' }" name="nombreUsuario" id="nombreUsuarioInput" placeholder="Nombre de usuario" required aria-describedly="invalidUsername"
              value="${nombreUsuario != null ? nombreUsuario : ''}">
          <label for="nombreUsuarioInput">Nombre de usuario</label>
          <c:if test="${usuarioRepetido}">
            <div id="invalidUsername" class="invalid-feedback">
	          Ese nombre de usuario está ocupado.
	        </div>
          </c:if>
        </div>
        <div class="form-floating mb-3">
          <input type="date" class="form-control" name="nacimiento" id="nacimientoInput" placeholder="Fecha de nacimiento" required value="${nacimiento != null ? nacimiento : ''}">
          <label for="nacimientoInput">Fecha de nacimiento</label>
        </div>
      </div>
      <div id="profesor-tab">
        <div class="form-floating mb-3">
          <select class="form-select" name="institucion" id="institucionSelect">
            <option ${ institucion == null ? 'selected ' : '' }disabled hidden>Selecciona una institución</option>
            <c:forEach items="${instituciones}" var="ins">
            <option ${institucion != null && institucion == ins.getNombre() ? 'selected ' : ''} value="${ins.getNombre()}">${ins.getNombre()}</option>
            </c:forEach>
          </select>
          <label for="institucionSelect">Institución</label>
        </div>
        <div class="form-floating mb-3">
          <textarea class="form-control" name="descripcion" id="descripcionTextArea" placeholder="Descripción">${descripcion != null ? descripcion : ''}</textarea>
          <label for="descripcionTextArea">Descripción</label>
        </div>
        <div class="form-floating mb-3">
          <textarea class="form-control" name="biografia" id="biografiaTextArea" placeholder="Biografía">${biografia != null ? biografia : ''}</textarea>
          <label for="biografiaTextArea">Biografía</label>
        </div>
        <div class="form-floating mb-3">
          <input type="text" class="form-control" name="sitioWeb" id="sitioWebInput" placeholder="Sitio web" value="${sitioWeb != null ? sitioWeb : ''}">
          <label for="sitioWebInput">Sitio web</label>
        </div>
      </div>
      <div class="form-tab">
        <div class="mb-3">
          <label for="fotoFile" class="form-label">Foto de perfil</label>
          <input class="form-control" type="file" name="foto" id="fotoFile" accept="image/png, image/jpeg">
        </div>
      </div>
      <button class="btn btn-secondary rounded-circle" id="prev-button">
        <i class="fas fa-arrow-left" style="padding: 5px 0;"></i>
      </button>
      <button class="btn btn-lg btn-primary w-100 mt-2" id="next-button">Siguiente</button>
      <button type="submit" class="btn btn-lg btn-primary w-100 mt-2" id="register-button">Registrarme</button>
      <p class="mt-3" id="registered-text">¿Ya estás registrado? <a href="ingresar" class="text-decoration-none">Entrar</a></p>
    </form>

  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/register-form.js"></script>
  
</body>
</html>