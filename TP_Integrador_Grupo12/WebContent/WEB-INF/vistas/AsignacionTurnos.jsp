<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Asignacion de turnos</title> 
<style>
    /* oculta ddlHorarios*/
    #ddlHorarios {
      display: none;
    }
  </style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.ready = document.getElementById("ddlEspecialidadMedicoTurno").value = "${ddlEspecialidadMedicoTurnoSeleccionado}";
		
        var medicoSelect = document.getElementById("ddlMedicoTurno"); //ddl de medicos 
        var horarioMedico = document.getElementById("horarioMedico"); //etiqueta p que va a mostrar los horarios del medico
        var horarios = document.getElementById("ddlHorarios").options; //todos los horarios
        var fechaInput = document.getElementById("dFechaTurno");
		
        medicoSelect.addEventListener("change", function() {
            var selectedOption = medicoSelect.options[medicoSelect.selectedIndex];
            var horario = selectedOption.getAttribute("data-horario"); //horarios del med. seleccionado
            var horarioParts = horario.split(",");
            var diasTrabaja = selectedOption.getAttribute("data-dias"); //dias de trabajo del medico
			
            horarioMedico.textContent = "Horario del médico seleccionado: " + horarioParts[0] + " - " + horarioParts[1];
            diasMedico.textContent = "Dias de atención del médico seleccionado: "+diasTrabaja;
            
            if (horario) {
                var inicio = parseInt(horarioParts[0].split(':')[0], 10);
                var fin = parseInt(horarioParts[1].split(':')[0], 10);
                horarioMedico.textContent = "Horario del médico seleccionado: " + horarioParts[0] + " - " + horarioParts[1];

                // Mostrar y ocultar opciones de horarios según el horario del médico
                for (let i = 0; i < horarios.length; i++) {
                    var value = parseInt(horarios[i].value.split(':')[0], 10);
                    if (value >= inicio && value <= fin) {
                        horarios[i].hidden = false;
                    } else {
                        horarios[i].hidden = true;
                    }
                }
            } else {
                horarioMedico.textContent = "";
            }
        });

        fechaInput.addEventListener("change", function() {
            var selectedOption = medicoSelect.options[medicoSelect.selectedIndex];
            var diasTrabaja = selectedOption.getAttribute("data-dias");
            var valorFecha = fechaInput.value;

         // Crear un objeto Date en UTC con el valor del campo de fecha
         	var fecha = new Date(Date.parse(valorFecha + 'T00:00:00Z'));
            var diaSemana = fecha.toLocaleDateString('es-ES', { weekday: 'long', timeZone: 'UTC' }).normalize("NFD").replace(/[\u0300-\u036f]/g, "");
            if (diasTrabaja && diasTrabaja.toUpperCase().includes(diaSemana.toUpperCase())) {
            	var selectHorarios = document.getElementById('ddlHorarios');
                  selectHorarios.style.display = 'block'; // Mostrar el select
            } else {
                alert("El médico no trabaja el día seleccionado.");
            }
        });
        
    });
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
    
	Bienvenido Admin a Asignacion de turnos<br>
	<h2>Usuario: ${nombreUsuario}</h2>
	
	Ingrese la especialidad del medico:
<form action="Buscar_Medico_Especialidad.html" method="get">
        <input type="hidden" name="txtUsuario" value="${nombreUsuario}">
        
        <select name="ddlEspecialidadMedicoTurno" id="ddlEspecialidadMedicoTurno" required>
            <option value="">Seleccione una especialidad</option>
            <c:forEach var="especialidad" items="${especialidades}">
                <option value="${especialidad.id}">${especialidad.nombre}</option>
            </c:forEach>
        </select>
        
        <input type="submit" value="Buscar médico" name="btnBuscarMedicoxEspecialidad">
    </form>
	<br>
	 
<form action="Alta_Turno_Menu_Admin.html" method="get" id="formTurno">
 <input type="hidden" name="txtUsuario" value=${nombreUsuario}>
             
Ingrese el medico:
  <input type="hidden" name="ValorDDL" value="${especialidad.id}">
    <select name="txtLegajoMedicoTurno" id="ddlMedicoTurno" required>
        <option value="" disabled selected>Seleccione un médico</option>
        <c:forEach var="medico" items="${medicosXespecialidad}">
            <option value="${medico.legajo}" data-horario="${medico.horario}" data-dias="${medico.diasTrabaja}">
                ${medico.nombre}, ${medico.apellido}
            </option>
        </c:forEach>
    </select>
<br>
<p id="diasMedico"></p>
<p id="horarioMedico"></p>


    <label for="dFechaTurno">Ingrese una fecha:</label>
    <input type="date" id="dFechaTurno" name="dFechaTurno" placeholder="00/00/0000" required>
    <select id="ddlHorarios" name="ddlHorarios">
        <option value="" disabled selected>Seleccione un horario</option>
        <option value="00:00">00:00</option>
        <option value="01:00">01:00</option>
        <option value="02:00">02:00</option>
        <option value="03:00">03:00</option>
        <option value="04:00">04:00</option>
        <option value="05:00">05:00</option>
        <option value="06:00">06:00</option>
        <option value="07:00">07:00</option>
        <option value="08:00">08:00</option>
        <option value="09:00">09:00</option>
        <option value="10:00">10:00</option>
        <option value="11:00">11:00</option>
        <option value="12:00">12:00</option>
        <option value="13:00">13:00</option>
        <option value="14:00">14:00</option>
        <option value="15:00">15:00</option>
        <option value="16:00">16:00</option>
        <option value="17:00">17:00</option>
        <option value="18:00">18:00</option>
        <option value="19:00">19:00</option>
        <option value="20:00">20:00</option>
        <option value="21:00">21:00</option>
        <option value="22:00">22:00</option>
        <option value="23:00">23:00</option>
    </select>
	<br>
	Ingrese el DNI del paciente:
	<input type="number" name="txtDNIPacienteTurno" placeholder="00000000" required>
	
	<br>
	Ingrese si desea aclarar una observacion:
	<input type="text" name="txtObservacionTurno" >
	<br>

	<input type="submit" name="BtnAsignarTurno" value="Asignar Turno">
	</form>
	
	<c:choose>
    <c:when test="${Filas == 1}">
        <p style="color:green;">Turno registrado con éxito.</p>
    </c:when>
    <c:when test="${Filas == -1}">
        <p style="color:red;">Complete los campos.</p>
    </c:when>
     <c:when test="${Filas == -2}">
        <p style="color:red;">No Existe ese Paciente</p>
    </c:when>
      <c:when test="${Filas == -3}">
        <p style="color:red;">Ingrese una fecha valida</p>
    </c:when>
    <c:when test="${Filas == -4}">
        <p style="color:red;">Medico no disponible a esa hora ese dia</p>
    </c:when>
    <c:when test="${Filas == -5}">
        <p style="color:red;">Ingrese una especialidad valida</p>
    </c:when>
</c:choose>
</body>
</html>