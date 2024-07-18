package frgp.utn.edu.ar.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImp.DaoMedico;
import frgp.utn.edu.ar.daoImp.daoHibernate;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;


/**
 * Servlet implementation class servletMedico
 */
@WebServlet("/servletMedico")
public class servletMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletMedico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		if(request.getParameter("BtnDarAltaMedico")!=null) {
			int filas=0;
			Medico medico = (Medico) appContext.getBean("beanMedico");
			 Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
			 Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
			 MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
			 String Contraseña1=request.getParameter("txtContrasenaUsuarioMedicoAlta1");
			 String Contraseña2=request.getParameter("txtContrasenaUsuarioMedicoAlta2");
			 System.out.println("Contraseña 1: "+Contraseña1+ " Contraseña 2: "+Contraseña2);
			 
			 
			 
			 
			if(request.getParameter("txtLegajoMedicoAlta")=="" ||request.getParameter("txtNombreMedicoAlta")==""|| request.getParameter("txtApellidoMedicoAlta")==""|| 
					request.getParameter("txtFechaNacimientoMedicoAlta")==""|| request.getParameter("txtDireccionMedicoAlta")=="" || request.getParameter("txtLocalidadMedicoAlta")=="" || request.getParameter("txtCorreoElectronicoMedicoAlta")=="" || request.getParameter("txtTelefonoMedicoAlta")==""|| 
					request.getParameter("txtDiasTrabajaMedicoAlta")==""|| request.getParameter("txtHorarioMedicoAlta")==""|| request.getParameter("txtNombreUsuarioMedicoAlta")==""|| request.getParameter("txtContrasenaUsuarioMedicoAlta1")==""|| request.getParameter("txtContrasenaUsuarioMedicoAlta2")=="")
			 {filas=-1;
			 }else if(!Contraseña1.equals(Contraseña2)) {
				 filas=-4;
			 } 
			 else { 
			 
			
				 
				 usuario.setNombreUsuario(request.getParameter("txtNombreUsuarioMedicoAlta"));
				 usuario.setContrasenaUsuario(request.getParameter("txtContraseñaUsuarioMedicoAlta1"));
				 usuario.setIsAdmin(false);
				 usuario.setEstado(true);
				 Especialidad.setNombre(request.getParameter("ddlEspecialidadMedicoAlta"));
				 Especialidad.setId(1);
				 Especialidad.setEstado(true);
			    	
			    	medico.setUsuario(usuario);
			    	medico.setNombre(request.getParameter("txtNombreMedicoAlta"));
			    	medico.setApellido(request.getParameter("txtApellidoMedicoAlta"));
			    	medico.setSexo(request.getParameter("RadioSexoAltaMedico"));
			    	medico.setFechaNacimiento(request.getParameter("txtFechaNacimientoMedicoAlta"));
			    	medico.setDireccion(request.getParameter("txtDireccionMedicoAlta"));
			    	medico.setLocalidad(request.getParameter("txtLocalidadMedicoAlta"));
			    	medico.setCorreoElectronico(request.getParameter("txtCorreoElectronicoMedicoAlta"));
			    	medico.setTelefono(request.getParameter("txtTelefonoMedicoAlta"));
			    	medico.setEspecialidad(Especialidad);
			    	medico.setEstado(true);
			    	medico.setDiasTrabaja(request.getParameter("txtDiasTrabajaMedicoAlta"));
			    	medico.setHorario(request.getParameter("txtHorarioMedicoAlta"));
			    	
			 
			
			
			 
			 medicoNegocio.Add(medico);
			 filas=1;
		 }
			 request.setAttribute("cantFilas", filas);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/AltaMedico.jsp");
		     rd.forward(request, response);
    		
    		 
    		 
    	}
		
		  
			 
			

		 
		
		 if(request.getParameter("btnBajaMedico")!=null)
		 {	int filas=0;
		 	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
			Medico medicoAEliminar = (Medico) appContext.getBean("beanMedico");
		 
			 if(request.getParameter("txtLegajoBajaMedico").isEmpty()) {
				 
				 filas=-2;
			 }else if(request.getParameter("txtLegajoBajaMedico")!=null&&request.getParameter("txtLegajoBajaMedico").matches("[0-9]+"))
			  {	
				
				medicoAEliminar=medicoNegocio.ReadOne(Integer.parseInt(request.getParameter("txtLegajoBajaMedico")));
				if(medicoAEliminar.getEstado()==false) {
					///ya se borro
					 filas=-1;
				}else {
				medicoNegocio.Delete(medicoAEliminar);
			 filas=1;}
			  }
			 request.setAttribute("cantFilas", filas);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/BajaMedico.jsp");
		     rd.forward(request, response);		 
			 
		 }
		 if(request.getParameter("BtnMedicoModificar")!=null)
			{
				int legajo = Integer.parseInt(request.getParameter("txtLegajoMedicoModificar"));
				int filas=0;
				Medico medico = (Medico) appContext.getBean("beanMedico");
				 Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
		    		Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
				 MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio"); 
				
					 
					 	
											
						 usuario.setNombreUsuario(request.getParameter("txtNombreUsuarioMedicoModificar"));
						 usuario.setContrasenaUsuario(request.getParameter("txtContraseñaUsuarioMedicoModificar1"));
						 usuario.setEstado(true);
						 usuario.setIsAdmin(false);
						 Especialidad.setNombre(request.getParameter("ddlEspecialidadMedicoModificar"));
						 Especialidad.setId(1);
						 Especialidad.setEstado(true);
					    	medico.setLegajo(legajo);
					    	medico.setUsuario(usuario);
					    	medico.setNombre(request.getParameter("txtNombreMedicoModificar"));
					    	medico.setApellido(request.getParameter("txtApellidoMedicoModificar"));
					    	medico.setSexo(request.getParameter("RadioSexoModificarMedico"));
					    	medico.setFechaNacimiento(request.getParameter("txtFechaNacimientoMedicoModificar"));
					    	medico.setDireccion(request.getParameter("txtDireccionMedicoModificar"));
					    	medico.setLocalidad(request.getParameter("txtLocalidadMedicoModificar"));
					    	medico.setCorreoElectronico(request.getParameter("txtCorreoElectronicoMedicoModificar"));
					    	medico.setTelefono(request.getParameter("txtTelefonoMedicoModificar"));
					    	medico.setEspecialidad(Especialidad);
					    	medico.setEstado(true);
					    	medico.setDiasTrabaja(request.getParameter("txtDiasTrabajaMedicoModificar"));
					    	medico.setHorario(request.getParameter("txtHorarioMedicoModificar"));
					    medicoNegocio.Update(medico);
				
						
						
					filas =1;
						request.setAttribute("cantFilas", filas);
			        	RequestDispatcher rd = request.getRequestDispatcher("/ModificarMedico.jsp");
					    rd.forward(request, response);
				 
				
				
				
			}	
			
		 
		 
		//if(request.getParameter("BotonAceptarLogin")!=null){ 
		 if(request.getParameter("Param")!=null) {
			 Medico medico = (Medico) appContext.getBean("beanMedico");
			 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	        	ArrayList<Medico> lista = (ArrayList<Medico>) NegocioMed.ReadAll();
	        	
	        	
	        	request.setAttribute("listaM", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoMedicos.jsp");
	            rd.forward(request, response);
		 }
		 
		 
		 if(request.getParameter("BotonMostrarTodoMedicos")!=null) {
			 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	        	ArrayList<Medico> lista = (ArrayList<Medico>) NegocioMed.ReadAll();
	        	
	        	request.setAttribute("listaM", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoMedicos.jsp");
	            rd.forward(request, response);
		 }
		 if(request.getParameter("BotonFiltrarLegajoMedico")!=null) {
				ArrayList<Medico> lista;
				if(request.getParameter("txtLegajoFiltradoMedico").isEmpty()||(!request.getParameter("txtLegajoFiltradoMedico").matches("[0-9]+"))) {
					lista=null;
		    
				}else {
				 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	    		int num = Integer.parseInt(request.getParameter("txtLegajoFiltradoMedico"));
	    		lista = NegocioMed.ObtenerMedicoFiltrados(num);
				}
	        	request.setAttribute("listaM", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoMedicos.jsp");
	            rd.forward(request, response);
	    		 
	    		 
	    	}
		 
		 
		 if(request.getParameter("BotonFiltrarValorMedicos")!=null) {
				ArrayList<Medico> lista;
				if(request.getParameter("txtSegundoValorMedicos")==""||(!request.getParameter("txtSegundoValorMedicos").matches("[0-9]+"))) {
					lista=null;
		    
				}else {
				 MedicoNegocio NegocioMed = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
				String num = request.getParameter("txtPrimerValorPaciente");
	    		String simbolo=request.getParameter("txtSimboloMEdicoFiltrado");
	    		int segundoValor=Integer.parseInt(request.getParameter("txtSegundoValorMedicos"));
	    		System.out.println("Primer Valor: "+num+"Seimbolo: "+simbolo+"Segundo Valor: "+segundoValor);
	    		lista = NegocioMed.ObtenerMedicoFiltradosConDobleFiltro(num, simbolo, segundoValor);
				}
	        	request.setAttribute("listaM", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoMedicos.jsp");
	            rd.forward(request, response);
	    		 
	    		 
	    	}
		 
		 
		 
		 
		 
		 
		 if(request.getParameter("BtnAsignarTurno")!=null) {
				int filas=0;
				Medico medico = (Medico) appContext.getBean("beanMedico");
				Turno turno = (Turno) appContext.getBean("beanTurno");
				Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
				 //Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
				 //Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
				 TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
				 String Contraseña1=request.getParameter("txtContrasenaUsuarioMedicoAlta1");
				 String Contraseña2=request.getParameter("txtContrasenaUsuarioMedicoAlta2");
				 System.out.println("Contraseña 1: "+Contraseña1+ " Contraseña 2: "+Contraseña2);
				 
				 
				 
				 
				if(request.getParameter("txtLegajoMedicoTurno")=="" ||request.getParameter("txtDNIPacienteTurno")=="")
				 {filas=-1;
				 }else if(!Contraseña1.equals(Contraseña2)) {
					 filas=-4;
				 } 
				 else { 
				 
				
					 
					// usuario.setNombreUsuario(request.getParameter("txtNombreUsuarioMedicoAlta"));
					//usuario.setContrasenaUsuario(request.getParameter("txtContraseñaUsuarioMedicoAlta1"));
					 //usuario.setIsAdmin(false);
					 //usuario.setEstado(true);
					 medico.setLegajo(Integer.parseInt(request.getParameter("txtLegajoMedicoTurno")));
					 paciente.setDNI(Integer.parseInt(request.getParameter("txtDNIPacienteTurno")));
					 //Especialidad.setId(1);
					 //Especialidad.setEstado(true);
				    	
				    	turno.setMedico(medico);
				    	turno.setFecha(Date.valueOf(request.getParameter("dFechaTurno")));
				    	turno.setHora(request.getParameter("dtHorarioTurno"));
				    	turno.setPaciente(paciente);
				    	
				    	
				 
				
				
				 
				 turnoNegocio.AddTurno(turno);
				 filas=1;
			 }
				 request.setAttribute("cantFilas", filas);
				 
				 RequestDispatcher rd = request.getRequestDispatcher("/AsigancionTurnos.jsp");
			     rd.forward(request, response);
	    		
	    		 
	    		 
	    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
