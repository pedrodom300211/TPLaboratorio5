<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Baja Paciente</title> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
        function confirmarEliminar() {
            return confirm("¿Estás seguro de que quieres eliminar este Paciente?");
        }
    </script>

</head>

	<body class="p-3 m-0 border-0 bd-example m-0 border-0">
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Clinica Medica</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item">
              <form class="form-inline" action="redireccionar_Inicio_Admin.html" method="get">
              <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                
                <input type="submit" name="BtnInicio" value="Inicio" class="nav-link btn-link">
              </form>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Pacientes
              </a>
              <ul class="dropdown-menu">
                <li>
                  <form class="form-inline" action="redireccionar_Alta_Paciente_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="BtnDarAltaPaciente" value="Dar Alta Paciente" class="dropdown-item">
                  </form>
                </li>
                <li>
                  <form class="form-inline" action="redireccionar_Baja_Paciente_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="BtnDarBajaPaciente" value="Dar Baja Paciente" class="dropdown-item">
                  </form>
                </li>
                <li>
                  <form class="form-inline" action="redireccionar_Modificar_Paciente_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="BtnModificarPaciente" value="Modificar Paciente" class="dropdown-item">
                  </form>
                </li>
                <li>
                  <form class="form-inline" action="redireccionar_Listado_Paciente_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="ListadoPacientes" value="Listar Pacientes" class="dropdown-item">
                  </form>
                </li>
              </ul>
            </li>        
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Medicos
              </a>
              <ul class="dropdown-menu">
                <li>
                  <form class="form-inline" action="redireccionar_Alta_Medico_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="BtnDarAltaMedico" value="Dar Alta Medico" class="dropdown-item">
                  </form>
                </li>
                <li>
                  <form class="form-inline" action="redireccionar_Baja_Medico_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="BtnDarBajaMedico" value="Dar Baja Medico" class="dropdown-item">
                  </form>
                </li>
                <li>
                  <form class="form-inline" action="redireccionar_Modificar_Medico_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="BtnModificarMedico" value="Modificar Medico" class="dropdown-item">
                  </form>
                </li>
                <li>
                  <form class="form-inline" action="redireccionar_Listado_Medico_Menu_Admin.html" method="get">
                  <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                    <input type="submit" name="ListadoMedicos" value="Listar Medicos" class="dropdown-item">
                  </form>
                </li>
              </ul>
            </li>
            <li class="nav-item">
              <form class="form-inline" action="redireccionar_Asiganr_Turnos_Menu_Admin.html" method="get">
              <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                <input type="submit" name="BtnAsignarTurno" value="Asignar Turno" class="nav-link btn-link">
              </form>
            </li>
            <li class="nav-item">
              <form class="form-inline" action="redireccionar_Informe_Menu_Admin.html" method="get">
              <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                <input type="submit" name="BtnInforme" value="Listar Informe" class="nav-link btn-link">
              </form>
            </li>
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
    
		Bienvenido Admin a Baja Paciente<br>
		<h2>Usuario: ${nombreUsuario}</h2>
		
		Ingrese el DNI del paciente a dar de baja:
		
		<form action="Baja_Paciente.html" method="get">
			<input type="number" name="txtDNIBajaPaciente" placeholder="00000000">
			<br>
			<input type="submit" name="btnBajaPaciente"
				value="Dar de Baja Paciente" onclick="return confirmarEliminar();">
		</form>
	</body>
</form>

 <c:choose>
    <c:when test="${Filas == 1}">
        <p style="color:green;">Paciente eliminado con éxito.</p>
    </c:when>
    <c:when test="${Filas == -1}">
        <p style="color:red;">Ese Paciente no existe.</p>
    </c:when>
    <c:when test="${Filas == -2}">
        <p style="color:red;">Complete los campos.</p>
    </c:when>
</c:choose>
</html>