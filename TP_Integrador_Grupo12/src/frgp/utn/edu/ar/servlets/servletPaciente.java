package frgp.utn.edu.ar.servlets;

import java.io.IOException;
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
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;

/**
 * Servlet implementation class servletPaciente
 */
@WebServlet("/servletPaciente")
public class servletPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPaciente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		if(request.getParameter("BtnDarAltaPaciente")!=null) {
			int filas=0;
			 Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
			 PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
			if(request.getParameter("txtNombrePacienteAlta")=="" ||request.getParameter("txtApellidoPacienteAlta")==""|| request.getParameter("txtDNIPacienteAlta").isEmpty()
					|| request.getParameter("txtTelefonoPacienteAlta")==""|| request.getParameter("txtDireccionPacienteAlta")=="" 
					|| request.getParameter("txtLocalidadPacienteAlta")=="" ||
					request.getParameter("txtProvinciaPacienteAlta")=="" || request.getParameter("txtFechaNacimientoPacienteAlta")==""|| 
					request.getParameter("txtCorreoElectronicoPacienteAlta")=="")
			 {filas=-1;
			 }else if(! (pacienteNegocio.ReadOne(Integer.parseInt(request.getParameter("txtDNIPacienteAlta")))==null)) {
				 ///DNI ya existe
				 filas=-2;
			 } 
			 else {
			 
			///los sets 
				 
				 	paciente.setNombre(request.getParameter("txtNombrePacienteAlta"));
				 	paciente.setApellido(request.getParameter("txtApellidoPacienteAlta"));
				 	paciente.setDNI(Integer.parseInt(request.getParameter("txtDNIPacienteAlta")));
				 	paciente.setTelefono(request.getParameter("txtTelefonoPacienteAlta"));
				 	paciente.setDireccion(request.getParameter("txtDireccionPacienteAlta"));
				 	paciente.setLocalidad(request.getParameter("txtLocalidadPacienteAlta"));
				 	paciente.setProvincia(request.getParameter("txtProvinciaPacienteAlta"));
				 	paciente.setFechaNacimiento(request.getParameter("txtFechaNacimientoPacienteAlta"));
				 	paciente.setCorreoElectronico(request.getParameter("txtCorreoElectronicoPacienteAlta"));
			    	paciente.setEstado(true);
			    
			    	
			 
			
			
			 
				 	pacienteNegocio.add(paciente);
			 filas=1;
			 }
			 request.setAttribute("cantFilas", filas);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/AltaPaciente.jsp");
		     rd.forward(request, response);
    		
    		 
    		 
    	
		}
		
		 if(request.getParameter("btnBajaPaciente")!=null)
		 {	int filas=0;
		 	Paciente pacienteAEliminar = (Paciente) appContext.getBean("beanPaciente");
		 	PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		 	if(request.getParameter("txtDNIBajaPaciente").isEmpty()) {
		 		filas = -2;
		 	}
		 	else if(request.getParameter("txtDNIBajaPaciente")!=null&&request.getParameter("txtDNIBajaPaciente").matches("[0-9]+")) {	
		 		pacienteAEliminar=pacienteNegocio.ReadOne(Integer.parseInt(request.getParameter("txtDNIBajaPaciente")));
				 if(pacienteAEliminar.getEstado()==false) {
					filas =-1; 
				 }else if(filas==0){
				 pacienteNegocio.Delete(pacienteAEliminar);
			 filas=1;}
			 }
			 request.setAttribute("cantFilas", filas);
			 
			 RequestDispatcher rd = request.getRequestDispatcher("/BajaPaciente.jsp");
		     rd.forward(request, response);
		     
			 
		}
		 
		 
		 
		 if(request.getParameter("Param")!=null) {
			 Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
			 PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	        	ArrayList<Paciente> lista = (ArrayList<Paciente>) pacienteNegocio.ReadAll();
	        	
	        	
	        	request.setAttribute("listaP", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoPacientes.jsp");
	            rd.forward(request, response);
		 }
		 
		 
		 if(request.getParameter("BotonMostrarTodoPaciente")!=null) {
			 PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	        	ArrayList<Paciente> lista = (ArrayList<Paciente>) pacienteNegocio.ReadAll();
	        	
	        	request.setAttribute("listaP", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoPacientes.jsp");
	            rd.forward(request, response);
		 }
		 
		 
		 if(request.getParameter("BtnModificarPaciente")!=null)
			{
				int legajo = Integer.parseInt(request.getParameter("txtDNIPacienteModificar"));
				int filas=0;
				 Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
				 PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
				 	paciente.setNombre(request.getParameter("txtNombrePacienteModificar"));
				 	paciente.setApellido(request.getParameter("txtApellidoPacienteModificar"));
				 	paciente.setDNI(Integer.parseInt(request.getParameter("txtDNIPacienteModificar")));
				 	paciente.setTelefono(request.getParameter("txtTelefonoPacienteModificar"));
				 	paciente.setDireccion(request.getParameter("txtDireccionPacienteModificar"));
				 	paciente.setLocalidad(request.getParameter("txtLocalidadPacienteModificar"));
				 	paciente.setProvincia(request.getParameter("txtProvinciaPacienteModificar"));
				 	paciente.setFechaNacimiento(request.getParameter("txtFechaNacimientoPacienteModificar"));
				 	paciente.setCorreoElectronico(request.getParameter("txtCorreoElectronicoPacienteModificar"));
			    	paciente.setEstado(true);
			    	pacienteNegocio.Update(paciente);
					    	
						
						
					filas =1;
						request.setAttribute("cantFilas", filas);
			        	RequestDispatcher rd = request.getRequestDispatcher("/ModificarPaciente.jsp");
					    rd.forward(request, response);
				 
				
				
				
			}	
		 
		 if(request.getParameter("BotonFiltrarDNIPaciente")!=null) {
				ArrayList<Paciente> lista;
				if(request.getParameter("txtDNIFiltradoPaciente")==""||(!request.getParameter("txtDNIFiltradoPaciente").matches("[0-9]+"))) {
					lista=null;
					
				}else {
				 PacienteNegocio pacienteNogocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
	    		int num = Integer.parseInt(request.getParameter("txtDNIFiltradoPaciente"));
	    		lista = pacienteNogocio.ObtenerPacientesFiltrados(num);
				}
	        	request.setAttribute("listaP", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoPacientes.jsp");
	            rd.forward(request, response);
	    		 
	    		 
	    	}
		 
		 
		 if(request.getParameter("BotonFiltrarValorPacientes")!=null) {
				ArrayList<Paciente> lista;
				if(request.getParameter("txtSegundoValorPaciente").isEmpty()||(!request.getParameter("txtSegundoValorPaciente").matches("[0-9]+"))) {
					lista=null;
		    
				}else {
				PacienteNegocio pacienteNogocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
				String num = request.getParameter("txtPrimerValor");
	    		String simbolo=request.getParameter("txtSimboloPacienteFiltrado");
	    		int segundoValor=Integer.parseInt(request.getParameter("txtSegundoValorPaciente"));
	    		lista = pacienteNogocio.ObtenerPacientesFiltradosConDobleFiltro(num, simbolo, segundoValor);
				}
	        	request.setAttribute("listaP", lista);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("/ListadoPacientes.jsp");
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
