<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="frgp.utn.edu.ar.entidad.Paciente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Listado Pacientes</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<!-- DataTables JS -->
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>

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
    
	Bienvenido Admin a Listado Paciente <br>
	<h2>Usuario: ${nombreUsuario}</h2>
	
	Ingrese el DNI que desea:
	<form action="ListadoPacienteFiltrarLike.html" method="get">
	<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
		<input type="text" name="txtDNIFiltradoPaciente"> <input
			type="submit" value="Filtrar" name="BotonFiltrarDNIPaciente">
			</form>
			<form action="ListadoPacienteMostrarTodo.html">
			<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
		<input type="submit" value="Mostrar todos"
			name="BotonMostrarTodoPaciente"> 
			</form>
			<form action="ListadoPacientesFiltrarDosFiltros.html">
			<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
			<select	name="txtPrimerValor" id="Valor1">
			<option value="DNI">DNI</option>
			<option value="Telefono">Telefono</option>
		</select> <select name="txtSimboloPacienteFiltrado" id="Simbolo">
			<option value="=">=</option>
			<option value=">">></option>
			<option value=">=">>=</option>
			<option value="<"><</option>
			<option value="<="><=</option>
		</select> <input type="text" name="txtSegundoValorPaciente"> <input
			type="submit" value="Filtrar" name="BotonFiltrarValorPacientes">
	</form>
	<c:choose>
<c:when test="${filas == 0}">
        <p style="color:red;"></p>
    </c:when>
    <c:when test="${filas == -2}">
        <p style="color:red;">Complete los campos.</p>
    </c:when>
</c:choose><br>

	<% 
    ArrayList<Paciente> Lista = null;
    if(request.getAttribute("listaP")!=null){
        Lista = (ArrayList<Paciente>) request.getAttribute("listaP");
    }
%>

	<table id="tablaPacientes" border="1" class="display">
		<thead>
			<tr>
				<th>DNI</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Correo electronico</th>
				<th>Direccion</th>
				<th>Fecha de nacimiento</th>
				<th>Localidad</th>
				<th>Provincia</th>
				<th>Telefono</th>
			</tr>
		</thead>
		<tbody>
			<% if(Lista != null) for(Paciente paciente : Lista){ %>
			<tr>
				<td><%=paciente.getDNI()%></td>
				<td><%=paciente.getNombre()%></td>
				<td><%=paciente.getApellido()%></td>
				<td><%=paciente.getCorreoElectronico()%></td>
				<td><%=paciente.getDireccion()%></td>
				<td><%=paciente.getFechaNacimiento()%></td>
				<td><%=paciente.getLocalidad()%></td>
				<td><%=paciente.getProvincia()%></td>
				<td><%=paciente.getTelefono()%></td>
			</tr>
			<% } %>
		</tbody>
	</table>


	<script>
	$(document).ready(function() {
        $('#tablaPacientes').DataTable({
        	"dom": 'lrtip' ,// Oculta el cuadro de búsqueda
            language: {
                url: '//cdn.datatables.net/plug-ins/2.0.8/i18n/es-AR.json',
            },
        });
    });
</script>


</body>
</html>