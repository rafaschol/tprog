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
  <link rel="stylesheet" href="css/form-page.css">
  
  <!-- Icons -->
  <script src="https://kit.fontawesome.com/45d333caf9.js" crossorigin="anonymous"></script>
  
  <title>Registro a clase | Entrenemos.uy</title>
</head>
<body>
    
  <!-- Form page -->
  <main class="form-page tab-page">

    <form class="text-center py-5 px-4 m-3 bg-white shadow rounded" id="registro-clase-form" method="${dataTab == 0 ? 'get' : 'post'}" data-tab="${dataTab}">
      <h3>Entrenemos<span class="fw-bold">.uy</span></h3>
      <h5 class="fw-light">Registro a clase</h5>
      <div class="border-top my-4"></div>
      
      <c:if test="${dataTab == 0}">
      <div class="form-floating mb-3">
        <select class="form-select required" name="actividad" id="actividadSelect" required>
          <option ${actividadSeleccionada != null ? '' : 'selected '}disabled hidden>Selecciona una actividad deportiva</option>
          <c:forEach items="${actividades}" var="actividad">
            <option ${actividadSeleccionada != null && actividadSeleccionada == actividad.getNombre() ? 'selected ' : ''}
                value="${actividad.getNombre()}">${actividad.getNombre()}</option>
          </c:forEach>
        </select>
        <label for="actividadSelect">Actividad deportiva</label>
      </div>
      <div class="form-floating mb-3">
        <select class="form-select" name="clase" id="claseSelect" "<c:if test="${actividadSeleccionada != null}"> required  </c:if>>
          <option selected disabled hidden>Selecciona una clase</option>
          <c:forEach items="${clases}" var="clase">
            <option value="${clase.getNombre()}">${clase.getNombre()}</option>
          </c:forEach>
        </select>
        <label for="claseSelect">Clase</label>
      </div>
      </c:if>
      
      <c:if test="${dataTab == 1}">
      <div class="form-floating mb-3">
  		<input type="text" readonly class="form-control" name="clase" id="claseInput" value="${claseSeleccionada}">
 	    <label for="claseInput">Clase seleccionada:</label>
      </div>
       <jsp:useBean id="date" class="java.util.Date"/>
      <div class="row g-2 mb-3">
	    <div class="col-md-6">
            <div class="form-floating ">
		  		<input type="text" readonly class="form-control" name="clase" id="claseInput" value="<fmt:formatDate value="${clase.getFecha()}" type="date"  dateStyle = "short" timeStyle = "short" />">
		 	    <label for="claseInput">Fecha:</label>
	 	    </div>
	 	 </div>
	     
	     <div class="col-md-6">
            <div class="form-floating ">
		  		<input type="text" readonly class="form-control" name="clase" id="claseInput" value="<fmt:formatDate value="${clase.getFecha()}" type="time"  dateStyle = "short" timeStyle = "short" />">
		 	    <label for="claseInput">Hora:</label>
	        </div>
	    </div>
      </div>
      
      <div class="mb-2">
        <input type="radio" class="btn-check" name="tipoRegistro" value="normal" id="registroNormal" autocomplete="off"<c:if test="${selector != 1}"> checked  </c:if> >
        <label class="btn btn-outline-secondary w-100" for="registroNormal">Registro normal</label>
      </div>
      <div class="mb-3">
        <input type="radio" class="btn-check" name="tipoRegistro" value="cuponera" id="registroCuponera" autocomplete="off"<c:if test="${selector == 1}"> checked  </c:if> >
        <label class="btn btn-outline-secondary w-100" for="registroCuponera">Registro con cuponera</label>
      </div>
      <div class="form-floating mb-3">
        <select class="form-select" name="cuponera" id="cuponeraSelect" disabled required>
          <option ${nombreCuponera != null ? '' : 'selected '} disabled hidden>Selecciona una cuponera</option>
           <c:forEach items="${cuponeras}" var="cuponera">
         	 	<option ${nombreCuponera != null && nombreCuponera  == cuponera ? 'selected ' : ''}
         	 	 value="Pelota">${cuponera}</option>
           </c:forEach>
        </select>
        <label for="cuponeraSelect">Cuponera</label>
      </div>
      </c:if>  
      <button type="submit" class="btn btn-lg btn-primary w-100 mt-2">${dataTab == 0 ? 'Seleccionar clase' : 'Registrarme a la clase' }</button>
       <c:if test="${SocioRegistrado}">
        
            <div id="invalidUsername" class="invalid-feedback d-block">
	          Ya estas registrado a esta clase.
	        </div>
        </c:if>
         <c:if test="${CuposAgotados}">
        
            <div id="invalidUsername" class="invalid-feedback d-block">
	         No quedan cupos disponibles para esta clase.
	        </div>
        </c:if>
         <c:if test="${ClasesRestantes}">
        
            <div id="invalidUsername" class="invalid-feedback d-block">
	          Ya agotaste las clases restantes en esta cuponera.
	        </div>
        </c:if>
         <c:if test="${CuponeraVencida}">
        
            <div id="invalidUsername" class="invalid-feedback d-block">
	          La cuponera ya venció.
	        </div>
        </c:if>
    </form>

  </main>
    
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
  <script src="js/registro-clase.js"></script>
  
</body>
</html>