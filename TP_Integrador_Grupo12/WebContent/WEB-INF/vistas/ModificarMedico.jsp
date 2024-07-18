<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="frgp.utn.edu.ar.entidad.Especialidad"%>
<%@page import="java.util.ArrayList"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<title>Modificar Medico</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

 <script type="text/javascript">
        function setButtonState(habilitar) {
            var boton = document.getElementById("BtnMedicoModificar");
            boton.disabled = !habilitar;
        }
        
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
                        option.value = localidad.nombre;
                        option.textContent = localidad.nombre;
                        localidadSelect.appendChild(option);
                    });
                }
            });

            // Establecer la provincia desde ObjMedico
            const provinciaSeleccionada = "${ObjMedico.getProvincia()}";
            if (provinciaSeleccionada) {
                provinciaSelect.value = provinciaSeleccionada;
                // Disparar el evento change manualmente para cargar las localidades
                provinciaSelect.dispatchEvent(new Event('change'));
            }
        
		     // Seleccionar localidad de objMedico
		        const selectedLocalidad = "${ObjMedico.getLocalidad()}";
		        localidadSelect.value = selectedLocalidad;
        }); 
         
    </script>

</head>
<body class="p-3 m-0 border-0 bd-example m-0 border-0" onload="setButtonState(${habilitarBoton})">

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
                  <input type="hidden" name="txtUsuario" value="${nombreUsuario}">
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
    
     Bienvenido Admin a Modificar Medico<br>
	<h2>Usuario: ${nombreUsuario}</h2>
	
	<form action="Buscar_Medico_Modificar.html" method="get">
		<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
		Ingrese el Legajo del medico a Modificar:<input type="number"
			name="txtLegajoMedicoModificar" placeholder="000000" Value=${ObjMedico.legajo}><input
			type="submit" name="BuscarMedicoModificar" value="buscar">
			</form>
			<br>
			
		<c:if test="${not empty ObjMedico}">
			<form action="Modificar_Medico.html" method="get">
			<input type="hidden" name="txtUsuario" value=${nombreUsuario}>
			
			<input type="hidden" name="LegajoMedicoAModificar" Value=${ObjMedico.legajo}>
			
		Ingrese el Nombre del medico:<input type="text"
			name="txtNombreMedicoModificar" placeholder="Nombre" Value=${ObjMedico.nombre} required><br>
			
		Ingrese el Apellido del medico:<input type="text"
			name="txtApellidoMedicoModificar" placeholder="Apellido" Value=${ObjMedico.apellido} required><br>
			
		<label>Ingrese el Sexo del médico:</label>
		<input type="radio" name="RadioSexoModificarMedico" value="Hombre" id="radioHombre" required>
		<label for="radioHombre">Hombre</label>
		<input type="radio" name="RadioSexoModificarMedico" value="Mujer" id="radioMujer">
		<label for="radioMujer">Mujer</label>
	    <br>
	    
		Ingrese la Fecha de Nacimiento del medico:<input type="date"
			name="txtFechaNacimientoMedicoModificar" placeholder="01/01/2001" Value=${ObjMedico.fechaNacimiento} required><br>
		Ingrese la Direccion del medico:<input type="text"
			name="txtDireccionMedicoModificar" placeholder="Direccion 123" Value="${ObjMedico.direccion}" required><br>
			
		<label for="provincia">Provincia:</label>
		<select id="provincia" name="provincia" required>
		    <option value="">Seleccione una provincia</option>
		</select>
		
		<label for="localidad">Localidad:</label>
		<select id="localidad" name="localidad" required>
		    <option value="">Seleccione una localidad</option>
		</select>
		<br>
		<label for="correoElectronico">Ingrese el Correo Electrónico:</label>
		<input 
		    type="email" 
		    id="correoElectronico" 
		    name="txtCorreoElectronicoMedicoModificar" 
		    placeholder="ejemplo@gmail.com" 
		    value="${ObjMedico.correoElectronico}" 
		    required>
		<br>
			Ingrese el Telefono del medico:<input type="number" name="txtTelefonoMedicoModificar"
			placeholder="1111111111" Value=${ObjMedico.telefono} required><br>
			
			Ingrese los dias que trabaja el medico:<br> 
			Lunes<input type="checkbox" name="chDiasTrabajaMedicoModificar" value="Lunes">
			Martes<input type="checkbox" name="chDiasTrabajaMedicoModificar" value="Martes">
			Miercoles<input type="checkbox" name="chDiasTrabajaMedicoModificar" value="Miercoles">
			Jueves<input type="checkbox" name="chDiasTrabajaMedicoModificar" value="Jueves">
			Viernes<input type="checkbox" name="chDiasTrabajaMedicoModificar" value="Viernes">
			Sabado<input type="checkbox" name="chDiasTrabajaMedicoModificar" value="Sabado">
			Domingo<input type="checkbox" name="chDiasTrabajaMedicoModificar" value="Domingo"><br>
		
		
			Ingrese el horario en el que el medico trabaja:
			<select name="txtHorarioMedicoModificar" id="Horario1">
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
			<select name="txtHorarioMedicoModificar2" id="Horario2">
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
			<select id="ddlEspecialidad" name="ddlEspecialidad">
			    <c:forEach var="especialidad" items="${listaEspecialidades}">
			        <option value="${especialidad.id}">${especialidad.nombre}</option>
			    </c:forEach>
			</select>
			<script>
				document.ready = document.getElementById("ddlEspecialidad").value = ${ObjMedico.getEspecialidad().getId()};
			    document.ready = document.getElementById("Horario1").value = "${HorarioInicio}";
			    document.ready = document.getElementById("Horario2").value = "${HorarioFin}";
			    
			 	// Convertir la lista de días de trabajo en un array de JavaScript
	            var diasTrabajo = "${listaDiasTrabajo}".split(",");
	            // Obtener todos los checkboxes por su nombre
	            var checkboxDias = document.getElementsByName("chDiasTrabajaMedicoModificar");
	            // Iterar sobre cada checkbox y marcar los días de trabajo
	            Array.from(checkboxDias).forEach(function(checkbox) {
	                if (diasTrabajo.includes(checkbox.value)) {
	                    checkbox.checked = true;
	                }
	            });
	            
	        	 // Seleccionar el botón de radio adecuado
	         	var sexoMedico = "${ObjMedico.getSexo()}";
	         	if (sexoMedico === "Hombre") {
	                document.getElementById("radioHombre").checked = true;
	            } else if (sexoMedico === "Mujer") {
	                document.getElementById("radioMujer").checked = true;
	            }
	         	
	        
			</script>


		<br> Ingrese el Nombre para el usuario del medico:<input
			type="text" name="txtNombreUsuarioMedicoModificar" Value=${ObjUsuario.nombreUsuario}><br>
		Ingrese la contraseña para el usuario del medico:<input type="text"
			name="txtPassUsuarioMedicoModificar1" Value=${ObjUsuario.contrasenaUsuario}><br>
		Confirme la contraseña:<input type="text"
			name="txtContraseñaUsuarioMedicoModificar2" Value=${ObjUsuario.contrasenaUsuario}><br> <input
			type="submit" name="BtnMedicoModificar" value="Modificar" id="BtnMedicoModificar" disabled>
			
	</form>
 </c:if>
<c:choose>
 <c:when test="${Filas == 1}">
        <p style="color:green;">Medico Modificado con éxito.</p>
    </c:when>
   
    <c:when test="${Filas == -1}">
        <p style="color:red;">Ese Medico no existe.</p>
    </c:when>
    <c:when test="${Filas == -2}">
        <p style="color:red;">Complete los campos.</p>
    </c:when>
    <c:when test="${Filas == -3}">
        <p style="color:red;">Fecha invalida</p>
    </c:when>
</c:choose>
</body>
</html>