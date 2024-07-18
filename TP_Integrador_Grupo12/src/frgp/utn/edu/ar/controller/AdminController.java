package frgp.utn.edu.ar.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;

@Controller
public class AdminController {
	
	@RequestMapping("Alta_Medico_Menu_Admin.html")
	public ModelAndView eventoAltaMedico(String txtUsuario,String txtNombreMedicoAlta, String txtApellidoMedicoAlta,
			String RadioSexoAltaMedico, String txtFechaNacimientoMedicoAlta, String txtDireccionMedicoAlta, String localidad,
			String provincia, String txtCorreoElectronicoMedicoAlta, String txtTelefonoMedicoAlta, String chDiasAltaMedico,
			String ddlHorarioMedicoAlta, String especialidad, String txtNombreUsuarioMedicoAlta,
			String txtContrasenaUsuarioMedicoAlta1, String txtContrasenaUsuarioMedicoAlta2) {
		ModelAndView MV = new ModelAndView();
		
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		
		//////
		int filas=0;
		Medico medico = (Medico) appContext.getBean("beanMedico");
		 Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
		 Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
		 MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		 String Contraseña1=txtContrasenaUsuarioMedicoAlta1;
		 String Contraseña2=txtContrasenaUsuarioMedicoAlta2;
			LocalDate fechaActual = LocalDate.now();
			LocalDate fechaIngresada = LocalDate.parse(txtFechaNacimientoMedicoAlta, DateTimeFormatter.ISO_LOCAL_DATE);
			 EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
			ArrayList<Especialidad> listaEspecialidades = (ArrayList<Especialidad>) especialidadNegocio.ReadAll();
			MV.addObject("listaEspecialidades", listaEspecialidades);
			
		 
		 
		 
		 
		if(		especialidad=="" ||
				txtNombreMedicoAlta==""||txtApellidoMedicoAlta==""|| 
				txtFechaNacimientoMedicoAlta==""||txtDireccionMedicoAlta=="" || localidad=="" || provincia=="" || txtCorreoElectronicoMedicoAlta=="" || txtTelefonoMedicoAlta==""|| 
						ddlHorarioMedicoAlta==""|| txtNombreUsuarioMedicoAlta==""|| txtContrasenaUsuarioMedicoAlta1==""|| txtContrasenaUsuarioMedicoAlta2=="")
		 {filas=-1;
		 	MV.addObject("Filas", filas);
			MV.setViewName("AltaMedico");
			return MV;
		 }else if(!Contraseña1.equals(Contraseña2)) {
			 filas=-4;
			 	MV.addObject("Filas", filas);
				MV.setViewName("AltaMedico");
				return MV;
		 } 
		 else if(fechaIngresada.isAfter(fechaActual)){
			 filas=-3;
			 	MV.addObject("Filas", filas);
				MV.setViewName("AltaMedico");
				return MV; 
			 
		 }else{ 
			 int idEspecialidad= Integer.parseInt(especialidad);

			 usuario.setNombreUsuario(txtNombreUsuarioMedicoAlta);
			 usuario.setContrasenaUsuario(txtContrasenaUsuarioMedicoAlta1);
			 usuario.setIsAdmin(false);
			 usuario.setEstado(true);
			 Especialidad=especialidadNegocio.ReadOne(idEspecialidad);
			 
			
		    	
		    	medico.setUsuario(usuario);
		    	medico.setNombre(txtNombreMedicoAlta);
		    	medico.setApellido(txtApellidoMedicoAlta);
		    	medico.setSexo(RadioSexoAltaMedico);
		    	medico.setFechaNacimiento(txtFechaNacimientoMedicoAlta);
		    	medico.setDireccion(txtDireccionMedicoAlta);
		    	medico.setLocalidad(localidad);
		    	medico.setProvincia(provincia);
		    	
		    	medico.setCorreoElectronico(txtCorreoElectronicoMedicoAlta);
		    	medico.setTelefono(txtTelefonoMedicoAlta);
		    	medico.setEspecialidad(Especialidad);
		    	medico.setEstado(true);
		    	medico.setDiasTrabaja(chDiasAltaMedico);
		    	medico.setHorario(ddlHorarioMedicoAlta);
		    	
		 
		
		
		 
		 medicoNegocio.Add(medico);
		 filas=1;
		 MV.addObject("Filas", filas);
			MV.setViewName("AltaMedico");
			return MV;
	 }
		
		 
	
		//////
		
		
		
	
	}  
	

	
	@RequestMapping("Baja_Medico.html")
	public ModelAndView eventoBajaMedico(String txtUsuario,Integer txtLegajoBajaMedico) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		//////
		int filas=0;
	 	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		Medico medicoAEliminar = (Medico) appContext.getBean("beanMedico");
	 
		 if(txtLegajoBajaMedico==null) {
			 
			 filas=-2;
			 MV.addObject("Filas", filas);
			 MV.setViewName("BajaMedico");
			 return MV;
		 }else if(txtLegajoBajaMedico!=0)
		  {	
			
			medicoAEliminar=medicoNegocio.ReadOne(txtLegajoBajaMedico);
			
		        
		        if (medicoAEliminar == null) {
		            filas = -1; 
		            MV.addObject("Filas", filas);
					MV.setViewName("BajaMedico");
					return MV;
		        }
		        
			if(medicoAEliminar.getEstado()==false) {
				///ya se borro
				 filas=-1;
				 MV.addObject("Filas", filas);
					MV.setViewName("BajaMedico");
					return MV;
			}else {
			medicoNegocio.Delete(medicoAEliminar);
		 filas=1;
		 MV.addObject("Filas", filas);
			MV.setViewName("BajaMedico");
			return MV;
		 }
		  }
		 
		 return MV;
	
	}
	
	
	@RequestMapping("Buscar_Medico_Modificar.html")
	public ModelAndView eventoBuscarMedicoModificar(String txtUsuario,Integer txtLegajoMedicoModificar) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
     	ArrayList<Especialidad> listaEspecialidades = (ArrayList<Especialidad>) especialidadNegocio.ReadAll();
     	
     	MV.addObject("listaEspecialidades", listaEspecialidades);
		//////
		int filas=0;
	 	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		Medico medicoAModificar = (Medico) appContext.getBean("beanMedico");
		Especialidad especialidadDelMedico = (Especialidad)appContext.getBean("beanEspecialidad");
		Usuario UsuarioDelMedico = (Usuario) appContext.getBean("beanUsuario");
		 boolean habilitarBoton = false;
		 if(txtLegajoMedicoModificar==null) {
			 
			 filas=-2;
			 MV.addObject("Filas", filas);
			 MV.setViewName("ModificarMedico");
			 return MV;
		 }else if(txtLegajoMedicoModificar!=0)
		  {	
			
			 medicoAModificar=medicoNegocio.ReadOne(txtLegajoMedicoModificar);
			 
			 if(medicoAModificar==null) {
				 filas=-1;
				 MV.addObject("Filas", filas);
					MV.setViewName("ModificarMedico");
					return MV; 
			 }
			 
			if(medicoAModificar.getEstado()==false||txtLegajoMedicoModificar==1||medicoAModificar==null) {
				///ya se borro
				 filas=-1;
				 MV.addObject("Filas", filas);
					MV.setViewName("ModificarMedico");
					return MV;
			}else {
				especialidadDelMedico.setId(medicoAModificar.getEspecialidad().getId());
				UsuarioDelMedico.setNombreUsuario(medicoAModificar.getUsuario().getNombreUsuario());
				UsuarioDelMedico.setContrasenaUsuario(medicoAModificar.getUsuario().getContrasenaUsuario());
				 
				 MV.addObject("ObjUsuario", UsuarioDelMedico);
				 MV.addObject("ObjMedico", medicoAModificar);
				 MV.addObject("HorarioInicio", medicoAModificar.getHorario().split(",")[0].toString());
				 MV.addObject("HorarioFin", medicoAModificar.getHorario().split(",")[1].toString());
				 MV.addObject("listaDiasTrabajo",medicoAModificar.getDiasTrabaja());
				 MV.addObject("Filas", filas);
				 MV.setViewName("ModificarMedico");
			
			habilitarBoton=true;
			MV.addObject("habilitarBoton", habilitarBoton);
			return MV;
		 }
			
		  }
		 
		 return MV;
	
	}
	
	
	@RequestMapping("Modificar_Medico.html")
	public ModelAndView eventoModificarMedico(String txtUsuario,String LegajoMedicoAModificar , String txtNombreMedicoModificar,
			String txtApellidoMedicoModificar, String RadioSexoModificarMedico, String txtFechaNacimientoMedicoModificar, 
			String txtDireccionMedicoModificar, String localidad,String provincia, String txtCorreoElectronicoMedicoModificar,
			String txtTelefonoMedicoModificar, String chDiasTrabajaMedicoModificar, String txtHorarioMedicoModificar,
			String txtHorarioMedicoModificar2, String ddlEspecialidad,String txtNombreUsuarioMedicoModificar, 
			String txtPassUsuarioMedicoModificar1,String txtPassUsuarioMedicoModificar2 ){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		int legajo = Integer.parseInt(LegajoMedicoAModificar);
		int filas=0;
		String Horario=txtHorarioMedicoModificar+","+txtHorarioMedicoModificar2;
		Medico medico = (Medico) appContext.getBean("beanMedico");
		Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
    	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio"); 
    	LocalDate fechaActual = LocalDate.now();
		LocalDate fechaIngresada = LocalDate.parse(txtFechaNacimientoMedicoModificar, DateTimeFormatter.ISO_LOCAL_DATE);
		
			 
			 	if(localidad==""|| provincia=="" ||ddlEspecialidad=="" || RadioSexoModificarMedico==null||txtFechaNacimientoMedicoModificar==null||chDiasTrabajaMedicoModificar==null) {
			 		
			 		filas=-2;
			 		 MV.addObject("Filas", filas);
						MV.setViewName("ModificarMedico");
					return MV;	
			 	}else if(fechaIngresada.isAfter(fechaActual)){
			 		filas=-3;
			 		 MV.addObject("Filas", filas);
						MV.setViewName("ModificarMedico");
					return MV;	
			 	}else {
									
				 usuario.setNombreUsuario(txtNombreUsuarioMedicoModificar);
				 usuario.setContrasenaUsuario(txtPassUsuarioMedicoModificar1);
				 usuario.setEstado(true);
				 usuario.setIsAdmin(false);
				 EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio)appContext.getBean("beanEspecialidadNegocio");
				 Especialidad especialidad = especialidadNegocio.ReadOne(Integer.parseInt(ddlEspecialidad));
				 	medico.setEspecialidad(especialidad);
			    	medico.setLegajo(legajo);
			    	medico.setUsuario(usuario);
			    	medico.setNombre(txtNombreMedicoModificar);
			    	medico.setApellido(txtApellidoMedicoModificar);
			    	medico.setSexo(RadioSexoModificarMedico);
			    	medico.setFechaNacimiento(txtFechaNacimientoMedicoModificar);
			    	medico.setDireccion(txtDireccionMedicoModificar);
			    	medico.setLocalidad(localidad);
			    	medico.setProvincia(provincia);
			    	medico.setCorreoElectronico(txtCorreoElectronicoMedicoModificar);
			    	medico.setTelefono(txtTelefonoMedicoModificar);
			    	medico.setEstado(true);
			    	medico.setDiasTrabaja(chDiasTrabajaMedicoModificar);
			    	medico.setHorario(Horario);
			    	
			    medicoNegocio.Update(medico);
		
				
				
			filas =1;
			 	}
			 MV.addObject("Filas", filas);
				MV.setViewName("ModificarMedico");
			return MV;	
		
		
	}
	
	@RequestMapping("ListadoMedicoMostrarTodo.html")
	public ModelAndView ListarMedicoMostrarTodo(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
     	ArrayList<Medico> lista = (ArrayList<Medico>) NegocioMed.ReadAll();
     	
     	
     	 MV.addObject("listaM", lista);
     	
         
		MV.setViewName("ListadoMedicos");
		return MV;
	}
	
	@RequestMapping("ListadoMedicoFiltrarLike.html")
	public ModelAndView ListarMedicoLike(String txtUsuario,String txtLegajoFiltradoMedico) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
     	ArrayList<Medico> lista;
     	int filas=0;

		
		if(txtLegajoFiltradoMedico.isEmpty()||(!txtLegajoFiltradoMedico.matches("[0-9]+"))) {
			lista=null;
			filas=-2;
			MV.addObject("filas", filas);
		}else {
		
		int num = Integer.parseInt(txtLegajoFiltradoMedico);
		lista = NegocioMed.ObtenerMedicoFiltrados(num);
		 MV.addObject("listaM", lista);
			
			filas=0;
			MV.addObject("filas", filas);
		}
		MV.setViewName("ListadoMedicos");
		return MV;
		
	}
	
	@RequestMapping("ListadoMedicoFiltrarDosFiltros.html")
	public ModelAndView ListarMedicoLike(String txtUsuario,String txtPrimerValorMedico, String txtSimboloMEdicoFiltrado,String txtSegundoValorMedicos) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
     	ArrayList<Medico> lista;
     	int filas=0;

     	if(txtSegundoValorMedicos==""||(!txtSegundoValorMedicos.matches("[0-9]+"))) {
			lista=null;
			filas=-2;
			MV.addObject("filas", filas);
		}else {
		
		String num = txtPrimerValorMedico;
		String simbolo=txtSimboloMEdicoFiltrado;
		int segundoValor=Integer.parseInt(txtSegundoValorMedicos);
		
		lista = NegocioMed.ObtenerMedicoFiltradosConDobleFiltro(num, simbolo, segundoValor);
		MV.addObject("listaM", lista);
		filas=0;
		MV.addObject("filas", filas);
		
		
		}
    	
    	
    	
     	MV.setViewName("ListadoMedicos");
		return MV;
		
	}
	
	//ABML Pacientes
	@RequestMapping("Alta_Paciente_Menu_Admin.html")
	public ModelAndView eventoAltaPaciente(String localidad,String provincia,String txtUsuario,String txtNombrePacienteAlta, String txtApellidoPacienteAlta, Integer txtDNIPacienteAlta, String txtTelefonoPacienteAlta, String txtDireccionPacienteAlta, String txtFechaNacimientoPacienteAlta, String txtCorreoElectronicoPacienteAlta) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaIngresada = LocalDate.parse(txtFechaNacimientoPacienteAlta, DateTimeFormatter.ISO_LOCAL_DATE);
		
		int filas=0;
		 Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
		 PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		if(txtNombrePacienteAlta == "" || txtApellidoPacienteAlta == ""|| String.valueOf(txtDNIPacienteAlta).isEmpty()
				|| txtTelefonoPacienteAlta == ""|| txtDireccionPacienteAlta == "" 
				|| localidad == "" ||
				provincia == "" || txtFechaNacimientoPacienteAlta == ""|| 
				txtCorreoElectronicoPacienteAlta == "")
		 {filas=-1;
		 	MV.addObject("Filas", filas);
			MV.setViewName("AltaPaciente");
			return MV;
		 }else if(! (pacienteNegocio.ReadOne(txtDNIPacienteAlta)==null)) {
			 ///DNI ya existe
			 filas=-2;
			 MV.addObject("Filas", filas);
			 MV.setViewName("AltaPaciente");
			 return MV;
		 } 
		 else if(fechaIngresada.isAfter(fechaActual)){
			 filas=-3;
			 MV.addObject("Filas", filas);
			 MV.setViewName("AltaPaciente");
			 return MV;	 
		 }else {
		 
		///los sets 
			 
			 	paciente.setNombre(txtNombrePacienteAlta);
			 	paciente.setApellido(txtApellidoPacienteAlta);
			 	paciente.setDNI(txtDNIPacienteAlta);
			 	paciente.setTelefono(txtTelefonoPacienteAlta);
			 	paciente.setDireccion(txtDireccionPacienteAlta);
			 	paciente.setLocalidad(localidad);
			 	paciente.setProvincia(provincia);
			 	paciente.setFechaNacimiento(txtFechaNacimientoPacienteAlta);
			 	paciente.setCorreoElectronico(txtCorreoElectronicoPacienteAlta);
		    	paciente.setEstado(true);
		    
			 	pacienteNegocio.add(paciente);
		 filas=1;
		 MV.addObject("Filas", filas);
		 MV.setViewName("AltaPaciente");
		 return MV;
		 }
	}
	
	@RequestMapping("Baja_Paciente.html")
	public ModelAndView eventoBajaPaciente(String txtUsuario,Integer txtDNIBajaPaciente) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
	    ModelAndView MV = new ModelAndView();
	    MV.addObject("nombreUsuario", txtUsuario);
	    MV.setViewName("BajaPaciente");

	    int filas = 0;
	    PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");

	    if (txtDNIBajaPaciente == null) {
	        filas = -2; 
	    } else {
	        Paciente pacienteAEliminar = pacienteNegocio.ReadOne(txtDNIBajaPaciente);
	        if (pacienteAEliminar == null) {
	            filas = -1; 
	        } else {
	            pacienteNegocio.Delete(pacienteAEliminar);
	            filas = 1; 
	        }
	    }

	    MV.addObject("Filas", filas);
	    return MV;
	}
	
	
	
	@RequestMapping("Buscar_Paciente_Modificar.html")
	public ModelAndView eventoBuscarPacienteModificar(String txtUsuario,Integer txtDNIPacienteModificar) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		Paciente pacienteAModificar = (Paciente) appContext.getBean("beanPaciente");
	    ModelAndView MV = new ModelAndView();
	    MV.addObject("nombreUsuario", txtUsuario);
	    MV.setViewName("ModificarPaciente");
	    boolean habilitarBoton = false;
	    int filas = 0;
	    PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");

	    if (txtDNIPacienteModificar == null) {
	        filas = -2; 
	    } else {
	         pacienteAModificar = pacienteNegocio.ReadOne(txtDNIPacienteModificar);
	        if (pacienteAModificar == null ||pacienteAModificar.getEstado()==false) {
	            filas = -1; 
	        } else {
	            MV.addObject("ObjPaciente", pacienteAModificar);
	            habilitarBoton = true;
	        }
	    }

	    MV.addObject("Filas", filas);
	    MV.addObject("habilitarBoton", habilitarBoton);
	    return MV;
	}
	
	
	@RequestMapping("ListadoPacienteMostrarTodo.html")
	public ModelAndView ListarPacienteMostrarTodo(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 PacienteNegocio PacienteMed = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
     	ArrayList<Paciente> lista = (ArrayList<Paciente>) PacienteMed.ReadAll();
     	
     	
     	 MV.addObject("listaP", lista);
     	
         
		MV.setViewName("ListadoPacientes");
		return MV;
	}
	
	@RequestMapping("ListadoPacienteFiltrarLike.html")
	public ModelAndView ListarPacienteLike(String txtUsuario,String txtDNIFiltradoPaciente) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 PacienteNegocio PacienteNeg = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
     	ArrayList<Paciente> lista;
     	int filas=0;

		
		if(txtDNIFiltradoPaciente.isEmpty()||(!txtDNIFiltradoPaciente.matches("[0-9]+"))) {
			lista=null;
			filas=-2;
			MV.addObject("filas", filas);
    
		}else {
		
		int num = Integer.parseInt(txtDNIFiltradoPaciente);
		lista =PacienteNeg.ObtenerPacientesFiltrados(num);
		filas=0;
		 MV.addObject("listaP", lista);
		 MV.addObject("filas", filas);
			
			
		}
		MV.setViewName("ListadoPacientes");
		return MV;
		
	}
	
	
	

	
	
	@RequestMapping("ListadoPacientesFiltrarDosFiltros.html")
	public ModelAndView ListarPacienteDosFiltros(String txtUsuario,String txtPrimerValor, String txtSimboloPacienteFiltrado,String txtSegundoValorPaciente) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		PacienteNegocio PacienteNeg = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
     	ArrayList<Paciente> lista;
    	int filas=0;

     	if(txtPrimerValor==""||(!txtSegundoValorPaciente.matches("[0-9]+"))) {
			lista=null;
			filas=-2;
			MV.addObject("filas", filas);
    
    
		}else {
		
		String num = txtPrimerValor;
		String simbolo=txtSimboloPacienteFiltrado;
		int segundoValor=Integer.parseInt(txtSegundoValorPaciente);
		
		lista = PacienteNeg.ObtenerPacientesFiltradosConDobleFiltro(num, simbolo, segundoValor);
		filas=0;
		MV.addObject("listaP", lista);
		MV.addObject("filas", filas);
		
		 
		
			
		
		}
    	
    	
    	
     	MV.setViewName("ListadoPacientes");
		return MV;
		
	}
	@RequestMapping("Modificar_Paciente.html")
	public ModelAndView eventoModificarPaciente(String txtUsuario,String DNIPacienteModificar , String txtNombrePacienteModificar,
			String txtApellidoPacienteModificar, String txtTelefonoPacienteModificar, String txtDireccionPacienteModificar,
			String localidad, String provincia, String txtFechaNacimientoPacienteModificar
			, String txtCorreoElectronicoPacienteModificar){
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		LocalDate fechaActual = LocalDate.now();
	     LocalDate fechaIngresada = LocalDate.parse(txtFechaNacimientoPacienteModificar, DateTimeFormatter.ISO_LOCAL_DATE);
		int DNI= Integer.parseInt(DNIPacienteModificar);
		int filas=0;
		Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
		PacienteNegocio PacienteNeg = (PacienteNegocio) appContext.getBean("beanPacienteNegocio"); 
		
			 if(txtFechaNacimientoPacienteModificar.isEmpty() ){
				 
					filas =-2; 
				 
			 }else if(fechaIngresada.isAfter(fechaActual)){
				 filas =-3;  
			 }else {
			 		paciente.setDNI(DNI);
					paciente.setNombre(txtNombrePacienteModificar);
					paciente.setApellido(txtApellidoPacienteModificar);
					paciente.setTelefono(txtTelefonoPacienteModificar);
					paciente.setDireccion(txtDireccionPacienteModificar);
					paciente.setLocalidad(localidad);
					paciente.setProvincia(provincia);
					paciente.setFechaNacimiento(txtFechaNacimientoPacienteModificar);
					paciente.setCorreoElectronico(txtCorreoElectronicoPacienteModificar);
					paciente.setEstado(true);
					System.out.println(paciente.toString());
			    	PacienteNeg.Update(paciente);
			    	
			    	filas =1;
			 }
			 MV.addObject("Filas", filas);
				MV.setViewName("ModificarPaciente");
			return MV;	
	}
	
	
	////
	
	
	@RequestMapping("Alta_Turno_Menu_Admin.html")
	public ModelAndView eventoAltaTurno(String txtUsuario,String ValorDDL, String txtLegajoMedicoTurno,
			Date dFechaTurno, String ddlHorarios, String txtDNIPacienteTurno, String txtObservacionTurno) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		//////
		int filas=0;
		Medico medico = (Medico) appContext.getBean("beanMedico");
		 Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
		 Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
		 Turno turno = (Turno) appContext.getBean("beanTurno");
		 Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
		 TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
		 EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
		 PacienteNegocio PacienteNeg = (PacienteNegocio) appContext.getBean("beanPacienteNegocio"); 
		 MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	     ArrayList<Especialidad> listaEspecialidades = (ArrayList<Especialidad>) especialidadNegocio.ReadAll();
	     LocalDate fechaActual = LocalDate.now();
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	     String StringfechaIngresada = formatter.format(dFechaTurno);
	     LocalDate fechaIngresada = LocalDate.parse(StringfechaIngresada, DateTimeFormatter.ISO_LOCAL_DATE);
	   
		 
		 if(txtLegajoMedicoTurno.isEmpty()||txtDNIPacienteTurno.isEmpty())
		 {
			 filas=-1;
			 MV.addObject("especialidades", listaEspecialidades);
		 	MV.addObject("Filas", filas);
			
		 } 
		 else if(PacienteNeg.ReadOne(Integer.parseInt(txtDNIPacienteTurno))==null) {
			 filas=-2;
			 MV.addObject("especialidades", listaEspecialidades);
			 	MV.addObject("Filas", filas);
			 
			 }else if(fechaIngresada.isBefore(fechaActual)){
				 
				 filas=-3;
				 MV.addObject("especialidades", listaEspecialidades);
				 	MV.addObject("Filas", filas);
			 }else if(!turnoNegocio.ValidarFechaHoraMedico(StringfechaIngresada, ddlHorarios, txtLegajoMedicoTurno)){
				 filas=-4;
				 MV.addObject("especialidades", listaEspecialidades);
				 	MV.addObject("Filas", filas);
				 
			 }else {
				medico= medicoNegocio.ReadOne(Integer.parseInt(txtLegajoMedicoTurno));
				paciente=PacienteNeg.ReadOne(Integer.parseInt(txtDNIPacienteTurno));
			

		    	turno.setMedico(medico);
		    	turno.setFecha(dFechaTurno);
		    	turno.setHora(ddlHorarios);
		    	turno.setPaciente(paciente);
		    	turno.setEstado("Pendiente");
		    	turno.setObservacion(txtObservacionTurno);
		    	turno.setEstadoTurno(true);
		    	turnoNegocio.AddTurno(turno);
		    	filas=1;
		    	MV.addObject("Filas", filas);
		    	
		    	MV.addObject("especialidades", listaEspecialidades);
		    	
	 }
		
		 
		 MV.setViewName("AsignacionTurnos");
		return MV;
		//////
		
		
		
	
	} 
	
	
	@RequestMapping("Buscar_Medico_Especialidad.html")
	public ModelAndView BuscarMedicoXEspecialidad(String txtUsuario,String ddlEspecialidadMedicoTurno ) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		 EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
	     ArrayList<Especialidad> listaEspecialidades = (ArrayList<Especialidad>) especialidadNegocio.ReadAll();
		 
     	ArrayList<Medico> lista;
     	int ddlEspecialidadMedicoTurnoSeleccionado = Integer.parseInt(ddlEspecialidadMedicoTurno);
     	lista=medicoNegocio.ObtenerMedicoxEspecialidad(ddlEspecialidadMedicoTurnoSeleccionado);
     	MV.addObject("ddlEspecialidadMedicoTurnoSeleccionado", ddlEspecialidadMedicoTurnoSeleccionado);
     	MV.addObject("medicosXespecialidad", lista);
     	MV.addObject("especialidades", listaEspecialidades);
     	MV.setViewName("AsignacionTurnos");
		return MV;
		
	}
	
	}
	
