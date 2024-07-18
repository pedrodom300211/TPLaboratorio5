<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="frgp.utn.edu.ar.entidad.Especialidad"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Alta Medico</title> 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
<script>
const datos = {
	    provincias: [
	        { id: 1, nombre: "Buenos Aires" },
	        { id: 2, nombre: "Cordoba" },
	        { id: 3, nombre: "Santa Fe" },
	        { id: 4, nombre: "Mendoza" }
	    ],
	    localidades: {
	        1: [
	            { id: 101, nombre: "La Plata" },
	            { id: 102, nombre: "Escobar" },
	            { id: 103, nombre: "Tigre" },
	            { id: 104, nombre: "Mar del Plata" }
	        ],
	        2: [
	            { id: 201, nombre: "Cordoba Capital" },
	            { id: 202, nombre: "Villa Carlos Paz" }
	        ],
	        3: [
	            { id: 301, nombre: "Rosario" },
	            { id: 302, nombre: "Santa Fe Capital" }
	        ],
	        4: [
	            { id: 401, nombre: "Mendoza Capital" },
	            { id: 402, nombre: "Godoy Cruz" }
	        ]
	    }
	};

document.addEventListener("DOMContentLoaded", function() {
    const provinciaSelect = document.getElementById("provincia");
    const localidadSelect = document.getElementById("localidad");

    // Cargar provincias
    datos.provincias.forEach(provincia => {
        const option = document.createElement("option");
        option.value = provincia.nombre; 
        option.textContent = provincia.nombre;
        provinciaSelect.appendChild(option);
    });

    // Evento de cambio en provincia
    provinciaSelect.addEventListener("change", function() {
        const selectedProvinciaId = datos.provincias.find(p => p.nombre === provinciaSelect.value)?.id;
        localidadSelect.innerHTML = '<option value="">Seleccione una localidad</option>'; // Reset localidades

        if (selectedProvinciaId) {
            datos.localidades[selectedProvinciaId].forEach(localidad => {
                const option = document.createElement("option");
                option.value = localidad.nombre; // Set value as the name
                option.textContent = localidad.nombre;
                localidadSelect.appendChild(option);
            });
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
    
    Bienvenido Admin a Alta Medico<br>
    <h2>Usuario:  ${nombreUsuario}</h2>

<div class="contenedorAltaMedico">
	<form action="Alta_Medico_Menu_Admin.html" method="get">
		<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
                
		Ingrese el Nombre del medico:<input type="text"
			name="txtNombreMedicoAlta" placeholder="Nombre" required><br>
		Ingrese el Apellido del medico:<input type="text"
			name="txtApellidoMedicoAlta" placeholder="Apellido" required><br>
		Ingrese el Sexo del medico: Hombre<input type="radio"
			name="RadioSexoAltaMedico" value="Hombre" required>Mujer
			
			<input
			type="radio" name="RadioSexoAltaMedico" value="Mujer"><br>
		
		Ingrese la Fecha de Nacimiento del medico:<input type="date"
			name="txtFechaNacimientoMedicoAlta" placeholder="01/01/2001"required><br>
		
		Ingrese la Direccion del medico:<input type="text"
			
			name="txtDireccionMedicoAlta" placeholder="Direccion 123"required><br>
			
		<label for="provincia">Provincia:</label>
	    <select id="provincia" name="provincia" required>
	        <option value="">Seleccione una provincia</option>
	    </select>
	
	    <label for="localidad">Localidad:</label>
	    <select id="localidad" name="localidad" required>
	        <option value="">Seleccione una localidad</option>
	    </select>
	    <br>
		Ingrese correo electronico del medico:<input type="email"
			name="txtCorreoElectronicoMedicoAlta" placeholder="ejemplo@gmail.com" required><br>
		Ingrese el Telefono del medico:<input type="number"
			name="txtTelefonoMedicoAlta" placeholder="1111111111" required><br>
			
		Ingrese los dias que trabaja el medico: Lunes
		<input type="checkbox" name="chDiasAltaMedico" value="Lunes" >
		Martes<input type="checkbox" name="chDiasAltaMedico" value="Martes">
		Miercoles<input type="checkbox" name="chDiasAltaMedico" value="Miercoles">
		Jueves<input type="checkbox" name="chDiasAltaMedico" value="Jueves">
		Viernes<input type="checkbox" name="chDiasAltaMedico" value="Viernes">
		Sabado<input type="checkbox" name="chDiasAltaMedico" value="Sabado">
		Domingo<input type="checkbox" name="chDiasAltaMedico" value="Domingo"><br>
		
		Ingrese el horario de inicio de trabajo:
		 <select name="ddlHorarioMedicoAlta" id="Horario" required>
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
	
								
	</select><br>
	
	Ingrese el horario de fin de trabajo:
	<select name="ddlHorarioMedicoAlta" id="Horario" required>
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
	
	</select><br>
	
		Ingrese la especialidad del medico:
		<% 
        ArrayList<Especialidad> Lista = null;
        if(request.getAttribute("listaEspecialidades")!=null){
            Lista = (ArrayList<Especialidad>) request.getAttribute("listaEspecialidades");
        }%>
			 <select name="especialidad" required>
			    <c:forEach var="especialidad" items="${listaEspecialidades}">
			        <option value="${especialidad.id}">${especialidad.nombre}</option>
			    </c:forEach>
			</select>
		<br> 
		Ingrese el Nombre para el usuario del medico:<input type="text" name="txtNombreUsuarioMedicoAlta" required><br>
		Ingrese la contraseña para el usuario del medico:<input type="password"name="txtContrasenaUsuarioMedicoAlta1" required><br>
		Confirme la contraseña:<input type="password" name="txtContrasenaUsuarioMedicoAlta2" required><br>

		<input type="submit" name="BtnDarAltaMedico" value="Dar Alta Medico" class="Boton">
	</form>
	
	<c:choose>
    <c:when test="${Filas == 1}">
        <p style="color:green;">Medico registrado con éxito.</p>
    </c:when>
    <c:when test="${Filas == -1}">
        <p style="color:red;">Medico no agregado, hay campos inválidos.</p>
    </c:when>
     <c:when test="${Filas == -3}">
        <p style="color:red;">Fecha invalida.</p>
    </c:when>
    <c:when test="${Filas == -4}">
        <p style="color:red;">Las contraseñas no coinciden.</p>
    </c:when>
</c:choose>
</div>
</body>
</html>