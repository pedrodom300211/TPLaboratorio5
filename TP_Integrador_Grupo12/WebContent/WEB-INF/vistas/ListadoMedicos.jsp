<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="frgp.utn.edu.ar.entidad.Medico"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Listado Medicos</title> 
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

<style>
.grid-container {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	gap: 10px;
	padding: 10px;
}

.grid-item {
	background-color: #f1f1f1;
	border: 1px solid #ccc;
	padding: 20px;
	text-align: center;
}
</style>
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

	Bienvenido Admin a Listado Medicos<br>
	<h2>Usuario: ${nombreUsuario}</h2>


	Ingrese el Legajo que desea:
	


		<form action="ListadoMedicoFiltrarLike.html" method="get">
		<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
			<input type="number" name="txtLegajoFiltradoMedico"> <input
			type="submit" value="Filtrar" name="BotonFiltrarLegajoMedico">
		</form>
		
		<form action="ListadoMedicoMostrarTodo.html" method="get">
		<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
			<input type="submit" value="Mostrar todos"
			name="BotonMostrarTodoMedicos">
		</form>
			
			 &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		&nbsp; &nbsp; 
		<form action="ListadoMedicoFiltrarDosFiltros.html" method="get">
		<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
		<select name="txtPrimerValorMedico" id="Valor1">
			<option value="Legajo">Legajo</option>
			<option value="Telefono">Telefono</option>

		</select> <select name="txtSimboloMEdicoFiltrado" id="Simbolo">
			<option value="=">=</option>
			<option value=">">></option>
			<option value=">=">>=</option>
			<option value="<"><</option>
			<option value="<="><=</option>
		</select> <input type="text" name="txtSegundoValorMedicos"> <input
			type="submit" value="Filtrar" name="BotonFiltrarValorMedicos">
		<br>
			<c:choose>
<c:when test="${filas == 0}">
        <p style="color:red;"></p>
    </c:when>
    <c:when test="${filas == -2}">
        <p style="color:red;">Complete los campos.</p>
    </c:when>
</c:choose><br>

		<% 
        ArrayList<Medico> Lista = null;
        if(request.getAttribute("listaM")!=null){
            Lista = (ArrayList<Medico>) request.getAttribute("listaM");
        }%>


		<table border="1" id="tablaMedicos" class="display">
			<thead>
				<tr>
					<th>Legajo</th>
					<th>Usuario</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Sexo</th>
					<th>Fecha de nacimiento</th>
					<th>Direccion</th>
					<th>Localidad</th>
					<th>Provincia</th>
					<th>Correo electronico</th>
					<th>Telefono</th>
					<th>Especialidad</th>
					<th>Dias Trabaja</th>
					<th>Horario</th>
					<th>Estado</th>
				</tr>
			</thead>
			<tbody>
				<%if(Lista != null)
                    for(Medico medico : Lista){ %>
				<tr>

					<td><%=medico.getLegajo()%> <input type="hidden" name="Legajo"
						value="<%=medico.getLegajo()%>"></td>


					<td><%=medico.getUsuario().getNombreUsuario()%></td>
					<td><%=medico.getNombre()%></td>
					<td><%=medico.getApellido()%></td>
					<td><%=medico.getSexo()%></td>
					<td><%=medico.getFechaNacimiento()%></td>
					<td><%=medico.getDireccion()%></td>
					<td><%=medico.getLocalidad()%></td>
					<td><%=medico.getProvincia()%></td>
					<td><%=medico.getCorreoElectronico()%></td>
					<td><%=medico.getTelefono()%></td>
					<td><%=medico.getEspecialidad().getNombre()%></td>
					<td><%=medico.getDiasTrabaja()%></td>
					<td><%=medico.getHorario()%></td>
					<td><%=medico.getEstado()%></td>


				</tr>
				<% } %>
			</tbody>
		</table>
	</form>
	<script>
	$(document).ready(function() {
        $('#tablaMedicos').DataTable({
        	"dom": 'lrtip' ,// Oculta el cuadro de búsqueda
            language: {
                url: '//cdn.datatables.net/plug-ins/2.0.8/i18n/es-AR.json',
            },
        });
    });
</script>
</body>
</html>