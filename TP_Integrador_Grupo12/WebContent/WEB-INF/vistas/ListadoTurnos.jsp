<%@page import="frgp.utn.edu.ar.entidad.Turno"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Listado de turnos</title>
	
    <script>
        function mostrarOpciones() {
            var filtroPrincipal = document.getElementById("filtroPrincipal").value;
            var filtroEstado = document.getElementById("filtroEstado");
            var filtroPaciente = document.getElementById("filtroPaciente");

            if (filtroPrincipal === "Estado") {
                filtroEstado.style.display = "block";
                filtroPaciente.style.display = "none";
            } else if (filtroPrincipal === "Paciente") {
                filtroEstado.style.display = "none";
                filtroPaciente.style.display = "block";
            } else {
                filtroEstado.style.display = "none";
                filtroPaciente.style.display = "none";
            }
        }
    </script>


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
	            </li><%--
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

<form action="redireccionar_Ver_Turnos.html" method="get">
        <input type="hidden" name="txtNombre" value="${nombreUsuario}">
        
            <input type="submit" value="Mostrar todos"
            name="BtnVerListadoTurnos">
        </form>
        
  <form action="ListadoTurnosFiltrarDosFiltros.html" method="get">
		<input type="hidden" name="txtNombre" value="${nombreUsuario}">
        
        <select name="filtroPrincipal" id="filtroPrincipal" onchange="mostrarOpciones()">
            <option value=""></option>
            <option value="Paciente">DNI Paciente</option>
            <option value="Estado">Estado</option>
        </select>

    <select name="filtroEstado" id="filtroEstado" style="display: none;">
    	<option value=""></option>
        <option value="Pendiente">Pendiente</option>
        <option value="Ausente">Ausente</option>
        <option value="Presente">Presente</option>
    </select>
    <input type="text" name="filtroPaciente" id="filtroPaciente" placeholder="Filtrar Paciente" style="display: none;">
    
    <input type="submit" value="Filtrar" name="BotonFiltrarTurnos">
    </form> 
        <br>       
        <% 
        ArrayList<Turno> Lista = null;
        if(request.getAttribute("ListaT")!=null){
            Lista = (ArrayList<Turno>) request.getAttribute("ListaT");
        }%>

        <table border="1" id="tablaTurnos" class="display">
            <thead>
                <tr>
                    <th>Estado</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Médico</th>
                    <th>Paciente</th>
                    <th>DNI Paciente</th>
                    <th>Observaciones</th>
                    
                </tr>
            </thead>
            <tbody>
                <%if(Lista != null)
                    for(Turno turno : Lista){ %>
                <tr>
                    <td><%=turno.getEstado()%></td>
                    <td><%=turno.getFecha()%></td>
                    <td><%=turno.getHora()%></td>
                    <td><%=turno.getMedico().getApellido()+", "+ turno.getMedico().getNombre()%></td>
                    <td><%=turno.getPaciente().getApellido()+", "+turno.getPaciente().getNombre()%></td>
                    <td><%=turno.getPaciente().getDNI()%></td>
                    <td><%=turno.getObservacion()%></td>
                    <td>
                    <form action="SeleccionarTurno.html" method="get">
                     <input type="hidden" name="txtNombre" value=${nombreUsuario}>
                        	<input type="hidden" name="btnTurnoId" value="<%= turno.getId() %>">
                            <input type="submit" name="action" value="Seleccionar">
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>  

    <script>
    $(document).ready(function() {
        $('#tablaTurnos').DataTable({
        	"dom": 'lrtip' ,// Oculta el cuadro de búsqueda
            language: {
                url: '//cdn.datatables.net/plug-ins/2.0.8/i18n/es-AR.json',
            },
        });
    });
</script>
</body>
</html>
