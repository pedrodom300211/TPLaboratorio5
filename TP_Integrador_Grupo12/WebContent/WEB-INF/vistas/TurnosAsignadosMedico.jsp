<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Turnos asignados</title> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body class="p-3 m-0 border-0 bd-example m-0 border-0">
	
	<header>
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
	      <div class="container-fluid">
	        <a class="navbar-brand" href="#">Clinica Medica</a>
	        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarNavDropdown">
	          <ul class="navbar-nav">
	            <li class="nav-item">
	              <form class="form-inline" action="redireccionar_Inicio_Medico.html" method="get">
	              <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
	                <input type="submit" name="BtnInicio" value="Inicio" class="nav-link btn-link">
	              </form>
	            </li> 
	            <li class="nav-item">
	              <form class="form-inline" action="redireccionar_Ver_Turnos.html" method="get">
	              <input type="hidden" name="txtNombre" value=${nombreUsuario}>
	                <input type="submit" name="BtnVerListadoTurnos" value="Ver Listado de Turnos" class="nav-link btn-link">
	              </form>
	            </li>
	            <%-- 
	            <li class="nav-item">
	              <form class="form-inline" action="redireccionar_Turnos_Asignados.html" method="get">
	              <input type="hidden" name="txtNombre" value=${nombreUsuario}>
	                <input type="submit" name="BtnVerTurnosAsignados" value="Ir a Turnos Asignados" class="nav-link btn-link">
	              </form>
	            </li>
	            --%>
	            <li class="nav-item">
	              <form class="form-inline" action="redireccionar_LogIn_Inicio.html" method="get">
	              <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
	                <input type="submit" name="BtnCerrarSesion" value="Cerrar Sesion" class="nav-link btn-link">
	              </form>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </nav>
	</header>   
	
	<h2>Usuario: ${nombreUsuario}</h2>
	
	<br> Turno: ${turno.id} 
	<br> Legajo del medico: ${turno.medico.legajo} 
	<br> Fecha: ${turno.fecha} 
	<br> Horario: ${turno.hora} 
	<br> DNI del paciente: ${turno.paciente.DNI} 
	<br>
	<br>
	
	<form action="ActualizarTurno.html" method="get">
	<input type="hidden" name="txtNombre" value=${nombreUsuario}>
		<input type="hidden" name="turnoId" value="${turno.id}">
	
        <input type="radio" name="rbAsistencia" value="presente" id="presente" onclick="mostrarObservacion()" required
            <c:if test="${turno.estado == 'presente'}">checked </c:if> >
        Presente

        <input type="radio"name="rbAsistencia" value="ausente" id="ausente" onclick="mostrarObservacion()" required
            <c:if test="${turno.estado == 'ausente'}">checked</c:if>>
        Ausente

    <div id="observacion" style="display: none;">
	<br> Observacion de consulta:
	<br>
	<input type="text" name="txtObservacion" value="${turno.observacion}">
	</div>
	
	<br>
	<input type="submit" name="BtnGuardar" value="Guardar">
	</form>
	
	<script>
	function mostrarObservacion() {
        var presenteRadio = document.getElementById("presente");
        var observacionDiv = document.getElementById("observacion");

        if (presenteRadio.checked) {
            observacionDiv.style.display = "block";
        } else {
            observacionDiv.style.display = "none";
        }
    }

    mostrarObservacion();
	</script>
	
	<c:choose>
	    <c:when test="${Filas == 0}">
	        <p style="color:green;">Guardado con éxito.</p>
	    </c:when>
	    <c:when test="${Filas == -1}">
	        <p style="color:red;">Elija una opción.</p>
	    </c:when>
	</c:choose>
	
</body>
</html>