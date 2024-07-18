<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Inicio Medico</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="p-3 m-0 border-0 bd-example m-0 border-0">

	<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid" style="justify-content: center;">
        <a class="navbar-brand" href="#">Clinica Medica</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>
	</header>   
	
	<h1>Bienvenido, ${nombreUsuario}</h1><br>
	
	<form action="redireccionar_Ver_Turnos.html" method="get">
	<input type="hidden" name="txtNombre" value=${nombreUsuario}>
		<input type="submit" name="BtnVerListadoTurnos"
			value="Ver Listado de Turnos">
	</form><br>
	
	<%--
	<form action="redireccionar_Turnos_Asignados.html" method="get">
		<input type="hidden" name="txtNombre" value=${nombreUsuario}>
		<input type="submit" name="BtnVerTurnosAsignados" value="Ir a Turnos Asignados">
	</form><br>
	 --%>
	<form action="redireccionar_LogIn_Inicio.html" method="get">
		<input type="submit" name="BtnCerrarSesion" value="Cerrar Sesion">
	</form>
	
</body>
</html>