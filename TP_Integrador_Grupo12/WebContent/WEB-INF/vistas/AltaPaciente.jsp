<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                option.value = localidad.nombre;
                option.textContent = localidad.nombre;
                localidadSelect.appendChild(option);
            });
        }
    });
});

    </script>
<title>Alta Paciente</title>

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
 Bienvenido Admin a Alta Paciente<br>
	<h2>Usuario: ${nombreUsuario}</h2>
	<form action="Alta_Paciente_Menu_Admin.html" method="post" onsubmit="return validarFormulario()">
		<br> Ingrese el Nombre del paciente:<input type="text"
			name="txtNombrePacienteAlta" placeholder="Nombre" required><br>
		Ingrese el Apellido del paciente:<input type="text"
			name="txtApellidoPacienteAlta" placeholder="Apellido" required><br>
		Ingrese el DNI del paciente:<input type="number"
			name="txtDNIPacienteAlta" placeholder="00000000" required><br>
		Ingrese el Telefono del paciente:<input type="number"
			name="txtTelefonoPacienteAlta" placeholder="1111111111" required><br>
		Ingrese la Direccion del paciente:<input type="text"
			name="txtDireccionPacienteAlta" placeholder="Direccion 123" required>
		<br>
		<label for="provincia">Provincia:</label>
	    <select id="provincia" name="provincia" required>
	        <option value="">Seleccione una provincia</option>
	    </select>
	
	    <label for="localidad">Localidad:</label>
	    <select id="localidad" name="localidad" required>
	        <option value="">Seleccione una localidad</option>
	    </select>

    <br>	
		Ingrese la Fecha de Nacimiento del paciente:<input type="date"
			name="txtFechaNacimientoPacienteAlta" placeholder="01/01/2001" required><br>
		Ingrese correo electronico del paciente:<input type="email"
			name="txtCorreoElectronicoPacienteAlta"
			placeholder="ejemplo@gmail.com" required><br> 
			
		<input type="submit" name="BtnDarAltaPaciente" value="Dar Alta Paciente">

	</form>

	<c:choose>
    <c:when test="${Filas == 1}">
        <p style="color:green;">Paciente registrado con éxito.</p>
    </c:when>
    <c:when test="${Filas == -1}">
        <p style="color:red;">Paciente no agregado, hay campos inválidos.</p>
    </c:when>
    <c:when test="${Filas == -2}">
        <p style="color:red;">DNI invalido, ya existe un Paciente con ese DNI.</p>
    </c:when>
     <c:when test="${Filas == -3}">
        <p style="color:red;">Fecha invalida.</p>
    </c:when>
    
</c:choose>

</body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
