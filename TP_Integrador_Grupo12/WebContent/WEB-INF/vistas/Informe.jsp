<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="frgp.utn.edu.ar.entidad.Turno"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Informes</title>
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
    
    Bienvenido Admin a Informes<br>
    <h2>Usuario: ${nombreUsuario}</h2>

<h1>Bienvenido Admin a Informe</h1><br>
<form action="Informe_Busqueda_Turnos_Fecha.html" method="get">
<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                
Turnos Desde 
        <input type="date" name="txtFechaDesdeFiltrado">
        Hasta 
        <input type="date" name="txtFechaHastaFiltrado">
        <input type="submit" value="Filtrar" name="BotonFiltrarTurnosFechaCreacion">
        </form>
        <form action="Informe_Turnos_Mostrar_Todo.html" method="get">
        <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
        <input type="submit" value="Mostrar todos" name="BotonMostrarTodoReporte">
        <br>
        </form>
       <c:choose>
    <c:when test="${Filas == -1}">
        <p style="color:red;">Hay campos inválidos.</p>
    </c:when>
</c:choose><br>
 <% 
        ArrayList<Turno> Lista = null;
        if(request.getAttribute("ListaT")!=null){
            Lista = (ArrayList<Turno>) request.getAttribute("ListaT");
        }%>

        <table border="1" id="tablaTurnosInforme" class="display">
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
                    
                </tr>
                <% } %>
            </tbody>
        </table>



<h1>Porcentajes:</h1>	

<h4>-Turnos en estado Presente: <%= request.getAttribute("countPresente") %> </h4>
<h4>-Turnos en estado Ausente: <%= request.getAttribute("countAusente") %> </h4>
<h4>-Porcentaje de turnos en estado Presente: <%= request.getAttribute("porcentajePresente") %> %</h4>
<h4>-Porcentaje de turnos en estado Ausente: <%= request.getAttribute("porcentajeAusente") %> %</h4>

<script>
    $(document).ready(function() {
        $('#tablaTurnosInforme').DataTable({
        	"dom": 'lrtip' ,// Oculta el cuadro de búsqueda
            language: {
                url: '//cdn.datatables.net/plug-ins/2.0.8/i18n/es-AR.json',
            },
        });
    });
</script>
</body>
</html>