package frgp.utn.edu.ar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;

@Controller
public class PaginaController {
	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
	
	
	@RequestMapping("redireccionar_LogIn_Inicio.html")
	public ModelAndView eventoRedireccionarPagLogIn() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("LogIn");
		return MV;
	}
	
	@RequestMapping("redireccionar_Inicio_Admin.html")
	public ModelAndView eventoRedireccionarInicioAdmin(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("InicioAdmin");
		return MV;
	}
	
	@RequestMapping("redireccionar_Inicio_Medico.html")
	public ModelAndView eventoRedireccionarInicioMedico(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("InicioMedico");
		return MV;
	}
	
	@RequestMapping("redireccionar_Alta_Paciente_Menu_Admin.html")
	public ModelAndView eventoRedireccionarAltaPaciente(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("AltaPaciente");
		return MV;
	}
	
	@RequestMapping("redireccionar_Baja_Paciente_Menu_Admin.html")
	public ModelAndView eventoRedireccionarBajaPaciente(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("BajaPaciente");
		return MV;
	}
	
	@RequestMapping("redireccionar_Modificar_Paciente_Menu_Admin.html")
	public ModelAndView eventoRedireccionarModificarPaciente(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("ModificarPaciente");
		return MV;
	}
	
	@RequestMapping("redireccionar_Listado_Paciente_Menu_Admin.html")
	public ModelAndView eventoRedireccionarListarPaciente(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 PacienteNegocio PacienteMed = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
     	ArrayList<Paciente> lista = (ArrayList<Paciente>) PacienteMed.ReadAll();
     	
     	
     	 MV.addObject("listaP", lista);
     	
         
		MV.setViewName("ListadoPacientes");
		return MV;
	}
	
	
	
	@RequestMapping("redireccionar_Alta_Medico_Menu_Admin.html")
	public ModelAndView eventoRedireccionarAltaMedico(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
     	ArrayList<Especialidad> listaEspecialidades = (ArrayList<Especialidad>) especialidadNegocio.ReadAll();
     	
     	MV.addObject("listaEspecialidades", listaEspecialidades);
		MV.setViewName("AltaMedico");
		return MV;
	}
	
	
	
	@RequestMapping("redireccionar_Baja_Medico_Menu_Admin.html")
	public ModelAndView eventoRedireccionarBajaMedico(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("BajaMedico");
		return MV;
	}
	
	
	@RequestMapping("redireccionar_Modificar_Medico_Menu_Admin.html")
	public ModelAndView eventoRedireccionarModificarMedico(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("ModificarMedico");
		return MV;
	}
	
	
	
	@RequestMapping("redireccionar_Listado_Medico_Menu_Admin.html")
	public ModelAndView eventoRedireccionarListarMedico(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
     	ArrayList<Medico> lista = (ArrayList<Medico>) NegocioMed.ReadAll();
     	
     	
     	 MV.addObject("listaM", lista);
     	
         
		MV.setViewName("ListadoMedicos");
		return MV;
	}
	
	@RequestMapping("redireccionar_Asiganr_Turnos_Menu_Admin.html")
	public ModelAndView eventoRedireccionarAsignarTurnos(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
		  List<Especialidad> especialidades = especialidadNegocio.ReadAll();
	        MV.addObject("especialidades", especialidades);
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("AsignacionTurnos");
		return MV;
	}
	
	@RequestMapping("redireccionar_Informe_Menu_Admin.html")
	public ModelAndView eventoRedireccionarInforme(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		MV.setViewName("Informe");
		return MV;
	}

	@RequestMapping("redireccionar_Turnos_Asignados.html")
	public ModelAndView eventoRedireccionarVerTurnosAsignadosMedico(String txtNombre) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtNombre);
		MV.setViewName("TurnosAsignadosMedico");
		return MV;
	}
	
	
	@RequestMapping("redireccionar_Ver_Turnos.html")
	public ModelAndView eventoVerTurnos(String txtNombre) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtNombre);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		TurnoNegocio turnoNegocio = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
		ArrayList<Turno> lista =(ArrayList<Turno>)turnoNegocio.ReadAllxUsuario(txtNombre);
		MV.addObject("ListaT",lista);
		
		((ClassPathXmlApplicationContext) appContext).close(); // Cierra appContext
        
		MV.setViewName("ListadoTurnos");
		return MV;
	}
	
	@RequestMapping("ListadoTurnosFiltrarDosFiltros.html")
	public ModelAndView eventoVerTurnosFiltrados(String txtNombre, String filtroEstado, String filtroPaciente, String btnTurnoId){
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtNombre);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
					System.out.println("Estado: "+filtroEstado+", paciente: "+filtroPaciente);
		TurnoNegocio turnoNegocio = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
		ArrayList<Turno> lista=null;
		if (filtroEstado!="") {
			lista =(ArrayList<Turno>)turnoNegocio.ReadAllXEstadoTurno(filtroEstado, txtNombre);
		} else if(filtroPaciente!=""){
			lista =(ArrayList<Turno>)turnoNegocio.ReadAllXDniPaciente(filtroPaciente,txtNombre);
		}
		
		MV.addObject("ListaT",lista);
		
		((ClassPathXmlApplicationContext) appContext).close(); // Cierra appContext
        
		MV.setViewName("ListadoTurnos");
		return MV;
	}
	
	@RequestMapping("SeleccionarTurno.html")
	public ModelAndView eventoSeleccionarTurno(String txtNombre,int btnTurnoId){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		TurnoNegocio turnoNegocio = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
		Turno turno = (Turno)appContext.getBean("beanTurno");
		turno = turnoNegocio.ReadOne(btnTurnoId);
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtNombre);
		MV.addObject("turno",turno);
		MV.setViewName("TurnosAsignadosMedico");
		return MV;
}
	
	
	
	@RequestMapping("Informe_Busqueda_Turnos_Fecha.html")
	public ModelAndView eventoVerTurnosFiltradosPorFecha(String txtUsuario,String txtNombre, String txtFechaDesdeFiltrado, String txtFechaHastaFiltrado) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
					
		TurnoNegocio turnoNegocio = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
		ArrayList<Turno> lista=null;
		int filas=0;
		if (txtFechaDesdeFiltrado.isEmpty()||txtFechaHastaFiltrado.isEmpty()) {
			 	filas=-4;
			 	MV.addObject("Filas", filas);
		} else{
			lista =(ArrayList<Turno>)turnoNegocio.ReadAllXDosFechasTurno( txtFechaDesdeFiltrado, txtFechaHastaFiltrado);
		}
		
		int countPresente = 0;
	    if (lista != null) {
	        for (Turno turno : lista) {
	            if ("presente".equalsIgnoreCase(turno.getEstado())) {
	                countPresente++;
	            }
	        }
	    }
	    
	    int countAusente = 0;
	    if (lista != null) {
	        for (Turno turno : lista) {
	            if ("ausente".equalsIgnoreCase(turno.getEstado())) {
	                countAusente++;
	            }
	        }
	    }
	    
	    int totalTurnos = (lista != null) ? lista.size() : 0;
	    double porcentajePresente = (totalTurnos > 0) ? (countPresente * 100.0 / totalTurnos) : 0;
	    double porcentajeAusente = (totalTurnos > 0) ? (countAusente * 100.0 / totalTurnos) : 0;

	    
	    MV.addObject("countPresente", countPresente);
	    MV.addObject("countAusente", countAusente);
		MV.addObject("ListaT",lista);
		MV.addObject("porcentajePresente", porcentajePresente);
		MV.addObject("porcentajeAusente", porcentajeAusente);
		
		((ClassPathXmlApplicationContext) appContext).close(); // Cierra appContext
        
		MV.setViewName("Informe");
		return MV;
	}
	
	@RequestMapping("Informe_Turnos_Mostrar_Todo.html")
	public ModelAndView eventoReadAllTrunos(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
					
		TurnoNegocio turnoNegocio = (TurnoNegocio)appContext.getBean("beanTurnoNegocio");
		ArrayList<Turno> lista=null;
		
			lista =(ArrayList<Turno>)turnoNegocio.ReadAll();
		
		
			int countPresente = 0;
		    if (lista != null) {
		        for (Turno turno : lista) {
		            if ("presente".equalsIgnoreCase(turno.getEstado())) {
		                countPresente++;
		            }
		        }
		    }
		    
		    int countAusente = 0;
		    if (lista != null) {
		        for (Turno turno : lista) {
		            if ("ausente".equalsIgnoreCase(turno.getEstado())) {
		                countAusente++;
		            }
		        }
		    }
		    
		    int totalTurnos = (lista != null) ? lista.size() : 0;
		    double porcentajePresente = (totalTurnos > 0) ? (countPresente * 100.0 / totalTurnos) : 0;
		    double porcentajeAusente = (totalTurnos > 0) ? (countAusente * 100.0 / totalTurnos) : 0;

		    
		    MV.addObject("countPresente", countPresente);
		    MV.addObject("countAusente", countAusente);
			MV.addObject("ListaT",lista);
			MV.addObject("porcentajePresente", porcentajePresente);
			MV.addObject("porcentajeAusente", porcentajeAusente);
		
		((ClassPathXmlApplicationContext) appContext).close(); 
        
		MV.setViewName("Informe");
		return MV;
	}
	
	@RequestMapping("ActualizarTurno.html")
	public ModelAndView eventoActualizarTurno(String txtNombre, String rbAsistencia, String txtObservacion, int turnoId) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtNombre);
		Turno turno = (Turno) appContext.getBean("beanTurno");
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
		turno = turnoNegocio.ReadOne(turnoId);
		
		int filas = 0;
		
		if(rbAsistencia != null) {
		turno.setEstado(rbAsistencia);
		turno.setObservacion(txtObservacion);
		MV.addObject("Filas", filas);
		} else {
			filas = -1;
			MV.addObject("Filas", filas);
			MV.setViewName("TurnosAsignadosMedico");
			return MV;
		}
		
		turnoNegocio.UpdateTurno(turno);
		
		MV.setViewName("TurnosAsignadosMedico");
		return MV;
	}
	
}
