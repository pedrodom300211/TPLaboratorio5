package frgp.utn.edu.ar.main;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.daoImp.daoHibernate;
import frgp.utn.edu.ar.entidad.Especialidad;
//import frgp.utn.edu.ar.daoImp.daoHibernate;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnoNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

public class Main {

	public static void main(String[] args) {
		
		
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		//Alta Usuario

		UsuarioNegocio UsuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
		
    	Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombreUsuario("admin");
    	usuario.setContrasenaUsuario("admin");
    	usuario.setIsAdmin(true);
    	usuario.setEstado(true);
    	UsuarioNegocio.Add(usuario);
    	System.out.println(usuario.toString());
    	System.out.println("//////////////////////////////////////////");
    	
		Usuario usuario1 = (Usuario) appContext.getBean("beanUsuario");
		usuario1.setNombreUsuario("Roberto");
		usuario1.setContrasenaUsuario("Roberto");
		usuario1.setEstado(true);
		usuario1.setIsAdmin(false);
		UsuarioNegocio.Add(usuario1);
    	
		
    	Usuario usuario2 = (Usuario) appContext.getBean("beanUsuario");
    	usuario2.setNombreUsuario("MatiasL");
    	usuario2.setContrasenaUsuario("MATLOP123");
    	usuario2.setEstado(true);
    	usuario2.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario2);
    	
    	Usuario usuario3 = (Usuario) appContext.getBean("beanUsuario");
    	usuario3.setNombreUsuario("Gonzalo123");
    	usuario3.setContrasenaUsuario("Gonza123");
    	usuario3.setEstado(true);
    	usuario3.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario3);
    	
    	Usuario usuario4 = (Usuario) appContext.getBean("beanUsuario");
    	usuario4.setNombreUsuario("LuciaGonzales");
    	usuario4.setContrasenaUsuario("LuGonzales345");
    	usuario4.setEstado(true);
    	usuario4.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario4);
    	
    	Usuario usuario5 = (Usuario) appContext.getBean("beanUsuario");
    	usuario5.setNombreUsuario("LucasB");
    	usuario5.setContrasenaUsuario("LB4312");
    	usuario5.setEstado(true); 
    	usuario5.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario5);
    	
    	Usuario usuario6 = (Usuario) appContext.getBean("beanUsuario");
    	usuario6.setNombreUsuario("Pedro");
    	usuario6.setContrasenaUsuario("Pedrito567");
    	usuario6.setEstado(true);
    	usuario6.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario6);
    	
    	Usuario usuario7 = (Usuario) appContext.getBean("beanUsuario");
    	usuario7.setNombreUsuario("Juana");
    	usuario7.setContrasenaUsuario("Juana2001");
    	usuario7.setEstado(true);
    	usuario7.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario7);
    	
    	Usuario usuario8 = (Usuario) appContext.getBean("beanUsuario");
    	usuario8.setNombreUsuario("Rocio");
    	usuario8.setContrasenaUsuario("RocioCastle");
    	usuario8.setEstado(true);
    	usuario8.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario8);
    	
    	Usuario usuario9 = (Usuario) appContext.getBean("beanUsuario");
    	usuario9.setNombreUsuario("Belen");
    	usuario9.setContrasenaUsuario("Belen123");
    	usuario9.setEstado(true);
    	usuario9.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario9);
    	
    	Usuario usuario10 = (Usuario) appContext.getBean("beanUsuario");
    	usuario10.setNombreUsuario("Fermin");
    	usuario10.setContrasenaUsuario("Fermin123");
    	usuario10.setEstado(true);
    	usuario10.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario10);
    	
    	Usuario usuario11 = (Usuario) appContext.getBean("beanUsuario");
    	usuario11.setNombreUsuario("RobertoUSR");
    	usuario11.setContrasenaUsuario("Robert321");
    	usuario11.setEstado(true);
    	usuario11.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario11);
    	
    	Usuario usuario12 = (Usuario) appContext.getBean("beanUsuario");
    	usuario12.setNombreUsuario("FelipeG");
    	usuario12.setContrasenaUsuario("Feli123");
    	usuario12.setEstado(true);
    	usuario12.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario12);
    	
    	Usuario usuario13 = (Usuario) appContext.getBean("beanUsuario");
    	usuario13.setNombreUsuario("AlfredoA");
    	usuario13.setContrasenaUsuario("Alfredo007");
    	usuario13.setEstado(true);
    	usuario13.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario13);
    	
    	Usuario usuario14 = (Usuario) appContext.getBean("beanUsuario");
    	usuario14.setNombreUsuario("RobertoM");
    	usuario14.setContrasenaUsuario("Roberto1998");
    	usuario14.setEstado(true);
    	usuario14.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario14);
    	
    	Usuario usuario15 = (Usuario) appContext.getBean("beanUsuario");
    	usuario15.setNombreUsuario("LucasR");
    	usuario15.setContrasenaUsuario("Luquitas");
    	usuario15.setEstado(true);
    	usuario15.setIsAdmin(false);
    	UsuarioNegocio.Add(usuario15);
    	

		//Alta de pacientes
		PacienteNegocio PacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		
		Paciente paciente1 = (Paciente) appContext.getBean("beanPaciente");		
    	paciente1.setApellido("Figueroa");
    	paciente1.setNombre("Carlos");
    	paciente1.setCorreoElectronico("jcfigueroa@gmail.com");
    	paciente1.setDireccion("Lavalle 828");
    	paciente1.setDNI(37763043);
    	paciente1.setFechaNacimiento("1983-06-08");
    	paciente1.setLocalidad("La Plata");
    	paciente1.setNombre("Juan Carlos");
    	paciente1.setProvincia("Buenos Aires");
    	paciente1.setTelefono("1157441561");
    	paciente1.setEstado(true);
    	PacienteNegocio.add(paciente1);
    	
    	Paciente paciente2 = (Paciente) appContext.getBean("beanPaciente");
        paciente2.setNombre("MarÃ­a");
        paciente2.setApellido("GonzÃ¡lez");
        paciente2.setFechaNacimiento("1990-09-15");
        paciente2.setDNI(40567890);
        paciente2.setDireccion("Av. Rivadavia 123");
        paciente2.setLocalidad("Cordoba Capital");
        paciente2.setProvincia("Cordoba");
        paciente2.setTelefono("1122334455");
        paciente2.setCorreoElectronico("maria.gonzalez@gmail.com");
        paciente2.setEstado(true);
        PacienteNegocio.add(paciente2);

        Paciente paciente3 = (Paciente) appContext.getBean("beanPaciente");
        paciente3.setNombre("Pedro");
        paciente3.setApellido("SÃ¡nchez");
        paciente3.setFechaNacimiento("1985-03-20");
        paciente3.setDNI(35678901);
        paciente3.setDireccion("Calle San MartÃ­n 456");
        paciente3.setLocalidad("Rosario");
        paciente3.setProvincia("Santa Fe");
        paciente3.setTelefono("1122334455");
        paciente3.setCorreoElectronico("pedro.sanchez@gmail.com");
        paciente3.setEstado(true);
        PacienteNegocio.add(paciente3);

        Paciente paciente4 = (Paciente) appContext.getBean("beanPaciente");
        paciente4.setNombre("Laura");
        paciente4.setApellido("MartÃ­nez");
        paciente4.setFechaNacimiento("1978-07-10");
        paciente4.setDNI(30123456);
        paciente4.setDireccion("Av. Belgrano 789");
        paciente4.setLocalidad("Mar del Plata");
        paciente4.setProvincia("Buenos Aires");
        paciente4.setTelefono("1122334455");
        paciente4.setCorreoElectronico("laura.martinez@gmail.com");
        paciente4.setEstado(true);
        PacienteNegocio.add(paciente4);
        
        Paciente paciente5 = (Paciente) appContext.getBean("beanPaciente");
        paciente5.setNombre("Jose");
        paciente5.setApellido("Ramirez");
        paciente5.setFechaNacimiento("1964-05-11");
        paciente5.setDNI(20120450);
        paciente5.setDireccion("Av. Alsina 789");
        paciente5.setLocalidad("Villa Carlos Paz");
        paciente5.setProvincia("Cordoba");
        paciente5.setTelefono("1122334455");
        paciente5.setCorreoElectronico("jo.ra@gmail.com");
        paciente5.setEstado(true);
        PacienteNegocio.add(paciente5);
        
        Paciente paciente6 = (Paciente) appContext.getBean("beanPaciente");
        paciente6.setNombre("Ezequiel");
        paciente6.setApellido("Zeballos");
        paciente6.setFechaNacimiento("2000-01-01");
        paciente6.setDNI(30120333);
        paciente6.setDireccion("Av. juaresa 789");
        paciente6.setLocalidad("La Plata");
        paciente6.setProvincia("Buenos Aires");
        paciente6.setTelefono("1122334455");
        paciente6.setCorreoElectronico("ez.ze@gmail.com");
        paciente6.setEstado(true);
        PacienteNegocio.add(paciente6);
        
        Paciente paciente7 = (Paciente) appContext.getBean("beanPaciente");
        paciente7.setNombre("Sergio");
        paciente7.setApellido("Romero");
        paciente7.setFechaNacimiento("2005-05-07");
        paciente7.setDNI(35820431);
        paciente7.setDireccion("Av. Baranga 786");
        paciente7.setLocalidad("Tigre");
        paciente7.setProvincia("Buenos Aires");
        paciente7.setTelefono("1122334455");
        paciente7.setCorreoElectronico("se.ro@gmail.com");
        paciente7.setEstado(true);
        PacienteNegocio.add(paciente7);
        
        Paciente paciente8 = (Paciente) appContext.getBean("beanPaciente");
        paciente8.setNombre("Martina");
        paciente8.setApellido("Miguelasa");
        paciente8.setFechaNacimiento("2001-06-21");
        paciente8.setDNI(35820555);
        paciente8.setDireccion("Av. Crargas 755");
        paciente8.setLocalidad("Escobar");
        paciente8.setProvincia("Buenos Aires");
        paciente8.setTelefono("1122334455");
        paciente8.setCorreoElectronico("ma.mi@gmail.com");
        paciente8.setEstado(true);
        PacienteNegocio.add(paciente8);
        
        Paciente paciente9 = (Paciente) appContext.getBean("beanPaciente");
        paciente9.setNombre("Carlos");
        paciente9.setApellido("Fernandez");
        paciente9.setFechaNacimiento("1990-04-15");
        paciente9.setDNI(34850670);
        paciente9.setDireccion("Calle Falsa 123");
        paciente9.setLocalidad("Rosario");
        paciente9.setProvincia("Santa Fe");
        paciente9.setTelefono("1122334466");
        paciente9.setCorreoElectronico("carlos.fernandez@gmail.com");
        paciente9.setEstado(true);
        PacienteNegocio.add(paciente9);

        Paciente paciente10 = (Paciente) appContext.getBean("beanPaciente");
        paciente10.setNombre("Lucia");
        paciente10.setApellido("Gonzalez");
        paciente10.setFechaNacimiento("1985-11-08");
        paciente10.setDNI(32987654);
        paciente10.setDireccion("Av. Libertador 456");
        paciente10.setLocalidad("Mendoza Capital");
        paciente10.setProvincia("Mendoza");
        paciente10.setTelefono("1122334477");
        paciente10.setCorreoElectronico("lucia.gonzalez@gmail.com");
        paciente10.setEstado(true);
        PacienteNegocio.add(paciente10);

        Paciente paciente11 = (Paciente) appContext.getBean("beanPaciente");
        paciente11.setNombre("Jorge");
        paciente11.setApellido("Martinez");
        paciente11.setFechaNacimiento("1978-09-30");
        paciente11.setDNI(31567890);
        paciente11.setDireccion("Calle Nueva 789");
        paciente11.setLocalidad("Villa Carlos Paz");
        paciente11.setProvincia("Cordoba");
        paciente11.setTelefono("1122334488");
        paciente11.setCorreoElectronico("jorge.martinez@gmail.com");
        paciente11.setEstado(true);
        PacienteNegocio.add(paciente11);
        
        Paciente paciente12 = (Paciente) appContext.getBean("beanPaciente");
        paciente12.setNombre("Jorge");
        paciente12.setApellido("Gonzales");
        paciente12.setFechaNacimiento("1980-05-15");
        paciente12.setDNI(34567890);
        paciente12.setDireccion("Calle 123");
        paciente12.setLocalidad("Tigre");
        paciente12.setProvincia("Buenos Aires");
        paciente12.setTelefono("123456789");
        paciente12.setCorreoElectronico("felipegomez@gmail.com");
        paciente12.setEstado(true);
        PacienteNegocio.add(paciente12);
        
        Paciente paciente13 = (Paciente) appContext.getBean("beanPaciente");
        paciente13.setNombre("Damian");
        paciente13.setApellido("Martinez");
        paciente13.setFechaNacimiento("1975-08-20");
        paciente13.setDNI(35567890);
        paciente13.setDireccion("Avenida 456");
        paciente13.setLocalidad("Tigre");
        paciente13.setProvincia("Buenos Aires");
        paciente13.setTelefono("987654321");
        paciente13.setCorreoElectronico("alfredoarias@gmail.com");
        paciente13.setEstado(true);
        PacienteNegocio.add(paciente13);
        
        Paciente paciente14 = (Paciente) appContext.getBean("beanPaciente");
        paciente14.setNombre("Lionel");
        paciente14.setApellido("Messi");
        paciente14.setFechaNacimiento("1988-12-30");
        paciente14.setDNI(36567890);
        paciente14.setDireccion("Boulevard 789");
        paciente14.setLocalidad("Villa Carlos Paz");
        paciente14.setProvincia("Cordoba");
        paciente14.setTelefono("567890123");
        paciente14.setCorreoElectronico("robertomartinez@gmail.com");
        paciente14.setEstado(true);
        PacienteNegocio.add(paciente14);
        
        Paciente paciente15 = (Paciente) appContext.getBean("beanPaciente");
        paciente15.setNombre("Julian");
        paciente15.setApellido("Alvarez");
        paciente15.setFechaNacimiento("1992-03-22");
        paciente15.setDNI(37567890);
        paciente15.setDireccion("Plaza 1010");
        paciente15.setLocalidad("Villa Carlos Paz");
        paciente15.setProvincia("Cordoba");
        paciente15.setTelefono("432109876");
        paciente15.setCorreoElectronico("lucasrodriguez@gmail.com");
        paciente15.setEstado(true);
        PacienteNegocio.add(paciente15);
        
        // especialidad
        	EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
        	
    		Especialidad Especialidad1 = (Especialidad) appContext.getBean("beanEspecialidad");
    		Especialidad1.setNombre("Cardiologia");
    		
    		Especialidad1.setEstado(true);
    		
	    	Especialidad especialidad2 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad2.setNombre("Anestesiología");
	    	especialidad2.setEstado(true);
	    	
	    	Especialidad especialidad3 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad3.setNombre("Dermatología");
	    	especialidad3.setEstado(true);
	
	    	Especialidad especialidad4 = (Especialidad) appContext.getBean("beanEspecialidad");
	  
	    	especialidad4.setNombre("Pediatría");
	    	especialidad4.setEstado(true);
	
	    	Especialidad especialidad5 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad5.setNombre("Gastroenterología");
	    	especialidad5.setEstado(true);
	
	    	Especialidad especialidad6 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad6.setNombre("Neurología");
	    	especialidad6.setEstado(true);
	
	    	Especialidad especialidad7 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad7.setNombre("Oftalmología");
	    	especialidad7.setEstado(true);
	
	    	
	    	////
	    	Especialidad especialidad8 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad8.setNombre("Oncología");
	    	especialidad8.setEstado(true);
	    	
	
	    	Especialidad especialidad9 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad9.setNombre("Psiquiatría");
	    	especialidad9.setEstado(true);
	
	    	Especialidad especialidad10 = (Especialidad) appContext.getBean("beanEspecialidad");
	    	
	    	especialidad10.setNombre("Traumatología");
	    	especialidad10.setEstado(true);
	    	
	    
	    	
	    	//medico
	    	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
	    	
			Medico Medico1 = (Medico) appContext.getBean("beanMedico");	
			
			Medico1.setUsuario(usuario);
	    	Medico1.setNombre("Admin");
	    	Medico1.setApellido("Admin");
	    	Medico1.setSexo("Mujer");
	    	Medico1.setFechaNacimiento("2000-10-10");
	    	Medico1.setDireccion("Admin");
	    	Medico1.setLocalidad("La Plata");
	    	Medico1.setProvincia("Buenos Aires");
	    	Medico1.setCorreoElectronico("Admin");
	    	Medico1.setTelefono("Admin");
	    	Medico1.setEspecialidad(especialidad2);
	    	Medico1.setDiasTrabaja("Lunes");
	    	Medico1.setHorario("09:00,17:00");
	    	Medico1.setEstado(false);
	    	
	    	medicoNegocio.Add(Medico1);	
			
			Medico medico2 = (Medico) appContext.getBean("beanMedico");
			medico2.setUsuario(usuario2);
	    	medico2.setNombre("Matias");
	    	medico2.setApellido("Lopez");
	    	medico2.setSexo("Hombre");
	    	medico2.setFechaNacimiento("1977-11-23");
	    	medico2.setDireccion("Casa del papa");
	    	medico2.setLocalidad("Escobar");
	    	medico2.setProvincia("Buenos Aires");
	    	medico2.setCorreoElectronico("ML@gmail.com");
	    	medico2.setTelefono("123456789");
	    	medico2.setEspecialidad(especialidad7);
	    	medico2.setEstado(true);
	    	medico2.setDiasTrabaja("Martes");
	    	medico2.setHorario("09:00,17:00");
	    	System.out.println("USuario Dentro del Medico:");
	    	System.out.println(medico2.getUsuario().getIsAdmin());
	    	medicoNegocio.Add(medico2);
	    	
	    	Medico medico3 = (Medico) appContext.getBean("beanMedico");
	    	medico3.setUsuario(usuario3);
	    	medico3.setNombre("Gonzalo");
	    	medico3.setApellido("Martinez");
	    	medico3.setSexo("Hombre");
	    	medico3.setFechaNacimiento("2018-12-09");
	    	medico3.setDireccion("Bernabeu");
	    	medico3.setLocalidad("Godoy Cruz");
	    	medico3.setProvincia("Mendoza");
	    	medico3.setCorreoElectronico("yvaeltercero@gmail.com");
	    	medico3.setTelefono("1155227834");
	    	medico3.setEspecialidad(especialidad5);
	    	medico3.setEstado(true);
	    	medico3.setDiasTrabaja("Jueves");
	    	medico3.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico3);
	    	
	    	Medico medico4 = (Medico) appContext.getBean("beanMedico");
	    	medico4.setUsuario(usuario4);
	    	medico4.setNombre("Lucia");
	    	medico4.setApellido("Gonzalez");
	    	medico4.setSexo("Mujer");
	    	medico4.setFechaNacimiento("2000-07-03");
	    	medico4.setDireccion("Montes de oca 1900");
	    	medico4.setLocalidad("Villa Carlos Paz");
	    	medico4.setProvincia("Cordoba");
	    	medico4.setCorreoElectronico("LG@gmail.com");
	    	medico4.setTelefono("1155782643");
	    	medico4.setEspecialidad(especialidad4);
	    	medico4.setEstado(true);
	    	medico4.setDiasTrabaja("Miercoles");
	    	medico4.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico4);
	    	
	    	Medico medico5 = (Medico) appContext.getBean("beanMedico");
	    	medico5.setUsuario(usuario5);
	    	medico5.setNombre("Lucas");
	    	medico5.setApellido("Barrios");
	    	medico5.setSexo("Hombre");
	    	medico5.setFechaNacimiento("2001-06-06");
	    	medico5.setDireccion("Avenida Italia 1455");
	    	medico5.setLocalidad("Escobar");
	    	medico5.setProvincia("Buenos Aires");
	    	medico5.setCorreoElectronico("lucas.barrios@gmail.com");
	    	medico5.setTelefono("1164853157");
	    	medico5.setEspecialidad(especialidad6);
	    	medico5.setEstado(true);
	    	medico5.setDiasTrabaja("Lunes");
	    	medico5.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico5);
	    	
	    	Medico medico6 = (Medico) appContext.getBean("beanMedico");
	    	medico6.setUsuario(usuario6);
	    	medico6.setNombre("Pedro");
	    	medico6.setApellido("Moralez");
	    	medico6.setSexo("Hombre");
	    	medico6.setFechaNacimiento("1984-04-07");
	    	medico6.setDireccion("Calle 17 4150");
	    	medico6.setLocalidad("La Plata");
	    	medico6.setProvincia("Buenos Aires");
	    	medico6.setCorreoElectronico("pedro.moralez@gmail.com");
	    	medico6.setTelefono("11696335478");
	    	medico6.setEspecialidad(especialidad2);
	    	medico6.setEstado(true);
	    	medico6.setDiasTrabaja("Miercoles");
	    	medico6.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico6);
	    	
	    	Medico medico7 = (Medico) appContext.getBean("beanMedico");
	    	medico7.setUsuario(usuario7);
	    	medico7.setNombre("Juana");
	    	medico7.setApellido("Gutierrez");
	    	medico7.setSexo("Mujer");
	    	medico7.setFechaNacimiento("1976-10-01");
	    	medico7.setDireccion("Newton 333");
	    	medico7.setLocalidad("Rosario");
	    	medico7.setProvincia("Santa Fe");
	    	medico7.setCorreoElectronico("juanagutierrez76@gmail.com");
	    	medico7.setTelefono("11656994413");
	    	medico7.setEspecialidad(especialidad4);
	    	medico7.setEstado(true);
	    	medico7.setDiasTrabaja("Lunes,Jueves");
	    	medico7.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico7);
	    	
	    	Medico medico8 = (Medico) appContext.getBean("beanMedico");
	    	medico8.setUsuario(usuario8);
	    	medico8.setNombre("Rocio");
	    	medico8.setApellido("Castillo");
	    	medico8.setSexo("Mujer");
	    	medico8.setFechaNacimiento("1992-05-13");
	    	medico8.setDireccion("La rioja 435");
	    	medico8.setLocalidad("Mar del Plata");
	    	medico8.setProvincia("Buenos Aires");
	    	medico8.setCorreoElectronico("rocio.castillo@gmail.com");
	    	medico8.setTelefono("1191356746");
	    	medico8.setEspecialidad(Especialidad1);
	    	medico8.setEstado(true);
	    	medico8.setDiasTrabaja("Jueves,Viernes");
	    	medico8.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico8);
	    	
	    	Medico medico9 = (Medico) appContext.getBean("beanMedico");
	    	medico9.setUsuario(usuario9);
	    	medico9.setNombre("Belen");
	    	medico9.setApellido("Sanchez");
	    	medico9.setSexo("Mujer");
	    	medico9.setFechaNacimiento("1999-12-31");
	    	medico9.setDireccion("Avenida Villanueva 1619");
	    	medico9.setLocalidad("Tigre");
	    	medico9.setProvincia("Buenos Aires");
	    	medico9.setCorreoElectronico("sanchezbelen@gmail.com");
	    	medico9.setTelefono("33444555");
	    	medico9.setEspecialidad(especialidad3);
	    	medico9.setEstado(true);
	    	medico9.setDiasTrabaja("Martes,Jueves");
	    	medico9.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico9);
	    	
	    	Medico medico10 = (Medico) appContext.getBean("beanMedico");
	    	medico10.setUsuario(usuario10);
	    	medico10.setNombre("Fermin");
	    	medico10.setApellido("Romero");
	    	medico10.setSexo("Hombre");
	    	medico10.setFechaNacimiento("1985-03-26");
	    	medico10.setDireccion("Salta 1515");
	    	medico10.setLocalidad("Mendoza Capital");
	    	medico10.setProvincia("Mendoza");
	    	medico10.setCorreoElectronico("fromero@hotmail.com");
	    	medico10.setTelefono("541166257361");
	    	medico10.setEspecialidad(especialidad2);
	    	medico10.setEstado(true);
	    	medico10.setDiasTrabaja("Martes");
	    	medico10.setHorario("09:00,17:00");
	    	medicoNegocio.Add(medico10);
	    	
	    	Medico medico11 = (Medico) appContext.getBean("beanMedico");
	    	medico11.setUsuario(usuario11);
	    	medico11.setNombre("Roberto");
	    	medico11.setApellido("Valdez");
	    	medico11.setSexo("Hombre");
	    	medico11.setFechaNacimiento("1982-11-10");
	    	medico11.setDireccion("Estados Unidos 5133");
	    	medico11.setLocalidad("La Plata");
	    	medico11.setProvincia("Buenos Aires");
	    	medico11.setCorreoElectronico("carlosvaldez06@gmail.com");
	    	medico11.setTelefono("11223344");
	    	medico11.setEspecialidad(especialidad3);
	    	medico11.setDiasTrabaja("Miercoles,Viernes");
	    	medico11.setHorario("09:00,17:00");
	    	medico11.setEstado(true);
	    	medicoNegocio.Add(medico11);
	    	
	    	Medico medico12 = (Medico) appContext.getBean("beanMedico");
	    	medico12.setUsuario(usuario12);
	    	medico12.setNombre("Felipe");
	    	medico12.setApellido("Gomez");
	    	medico12.setSexo("Hombre");
	    	medico12.setFechaNacimiento("1980-05-15");
	    	medico12.setDireccion("Calle 123");
	    	medico12.setLocalidad("Mendoza Capital");
	    	medico12.setProvincia("Mendoza");
	    	medico12.setCorreoElectronico("felipegomez@hotmail.com");
	    	medico12.setTelefono("123456789");
	    	medico12.setEspecialidad(Especialidad1); 
	    	medico12.setDiasTrabaja("Lunes,Miércoles");
	    	medico12.setHorario("08:00,16:00");
	    	medico12.setEstado(true);
	    	medicoNegocio.Add(medico12);
	    	
	    	Medico medico13 = (Medico) appContext.getBean("beanMedico");
	    	medico13.setUsuario(usuario13);
	    	medico13.setNombre("Alfredo");
	    	medico13.setApellido("Arias");
	    	medico13.setSexo("Hombre");
	    	medico13.setFechaNacimiento("1975-08-20");
	    	medico13.setDireccion("Avenida 456");
	    	medico13.setLocalidad("Tigre");
	    	medico13.setProvincia("Buenos Aires");
	    	medico13.setCorreoElectronico("alfredoarias@gmail.com");
	    	medico13.setTelefono("987654321");
	    	medico13.setEspecialidad(especialidad2); 
	    	medico13.setDiasTrabaja("Martes,Jueves");
	    	medico13.setHorario("10:00,18:00");
	    	medico13.setEstado(true);
	    	medicoNegocio.Add(medico13);
	    	
	    	Medico medico14 = (Medico) appContext.getBean("beanMedico");
	    	medico14.setUsuario(usuario14);
	    	medico14.setNombre("Roberto");
	    	medico14.setApellido("Martinez");
	    	medico14.setSexo("Hombre");
	    	medico14.setFechaNacimiento("1988-12-30");
	    	medico14.setDireccion("Boulevard 789");
	    	medico14.setLocalidad("Mendoza Capital");
	    	medico14.setProvincia("Mendoza");
	    	medico14.setCorreoElectronico("robertomartinez@gmail.com");
	    	medico14.setTelefono("567890123");
	    	medico14.setEspecialidad(especialidad3); 
	    	medico14.setDiasTrabaja("Viernes,Sábado");
	    	medico14.setHorario("09:00,17:00");
	    	medico14.setEstado(true);
	    	medicoNegocio.Add(medico14);
	    	
	    	Medico medico15 = (Medico) appContext.getBean("beanMedico");
	    	medico15.setUsuario(usuario15);
	    	medico15.setNombre("Lucas");
	    	medico15.setApellido("Rodriguez");
	    	medico15.setSexo("Hombre");
	    	medico15.setFechaNacimiento("1992-03-22");
	    	medico15.setDireccion("Plaza 1010");
	    	medico15.setLocalidad("Tigre");
	    	medico15.setProvincia("Buenos Aires");
	    	medico15.setCorreoElectronico("lucasrodriguez@gmail.com");
	    	medico15.setTelefono("432109876");
	    	medico15.setEspecialidad(especialidad4); // Asigna la especialidad adecuada
	    	medico15.setDiasTrabaja("Lunes,Miércoles");
	    	medico15.setHorario("08:00,16:00");
	    	medico15.setEstado(true);
	    	medicoNegocio.Add(medico15);

			
			//turnos
			TurnoNegocio TurnoNegocio = (TurnoNegocio) appContext.getBean("beanTurnoNegocio");
			
			Turno Turno1 = (Turno) appContext.getBean("beanTurno");
			Turno1.setEstado("presente");
			Turno1.setFecha(Date.valueOf("2024-05-16"));
			Turno1.setHora("11:00");
			Turno1.setObservacion("turno pendiente");
			Turno1.setMedico(medico2);
			Turno1.setPaciente(paciente1);
			Turno1.setEstadoTurno(true);
			
			Turno turno = (Turno) appContext.getBean("beanTurno");
	        turno.setEstado("presente");
	        turno.setFecha(Date.valueOf("2024-05-16"));
	        turno.setHora("11:00");
	        turno.setObservacion("turno pendiente");
	        turno.setMedico(medico11);
	        turno.setPaciente(paciente1);
	        turno.setEstadoTurno(true);

	        Turno turno2 = (Turno) appContext.getBean("beanTurno");
	        turno2.setEstado("pendiente");
	        turno2.setFecha(Date.valueOf("2024-05-17"));
	        turno2.setHora("14:00");
	        turno2.setObservacion("consulta de rutina");
	        turno2.setMedico(medico10);
	        turno2.setPaciente(paciente2);
	        turno2.setEstadoTurno(true);

	        Turno turno3 = (Turno) appContext.getBean("beanTurno");
	        turno3.setEstado("pendiente");
	        turno3.setFecha(Date.valueOf("2024-05-18"));
	        turno3.setHora("10:00");
	        turno3.setObservacion("estudio de laboratorio");
	        turno3.setMedico(medico9);
	        turno3.setPaciente(paciente3);
	        turno3.setEstadoTurno(true);

	        Turno turno4 = (Turno) appContext.getBean("beanTurno");
	        turno4.setEstado("ausente");
	        turno4.setFecha(Date.valueOf("2024-05-19"));
	        turno4.setHora("15:00");
	        turno4.setObservacion("control postoperatorio");
	        turno4.setMedico(medico8);
	        turno4.setPaciente(paciente4);
	        turno4.setEstadoTurno(true);

	        Turno turno5 = (Turno) appContext.getBean("beanTurno");
	        turno5.setEstado("presente");
	        turno5.setFecha(Date.valueOf("2024-05-20"));
	        turno5.setHora("10:00");
	        turno5.setObservacion("consulta de seguimiento");
	        turno5.setMedico(medico7);
	        turno5.setPaciente(paciente5);
	        turno5.setEstadoTurno(true);

	        Turno turno6 = (Turno) appContext.getBean("beanTurno");
	        turno6.setEstado("ausente");
	        turno6.setFecha(Date.valueOf("2024-05-21"));
	        turno6.setHora("11:00");
	        turno6.setObservacion("revisión general");
	        turno6.setMedico(medico6);
	        turno6.setPaciente(paciente6);
	        turno6.setEstadoTurno(true);

	        Turno turno7 = (Turno) appContext.getBean("beanTurno");
	        turno7.setEstado("presente");
	        turno7.setFecha(Date.valueOf("2024-05-22"));
	        turno7.setHora("14:00");
	        turno7.setObservacion("consulta dermatológica");
	        turno7.setMedico(medico5);
	        turno7.setPaciente(paciente7);
	        turno7.setEstadoTurno(true);

	        Turno turno8 = (Turno) appContext.getBean("beanTurno");
	        turno8.setEstado("pendiente");
	        turno8.setFecha(Date.valueOf("2024-05-23"));
	        turno8.setHora("09:00");
	        turno8.setObservacion("examen anual");
	        turno8.setMedico(medico4);
	        turno8.setPaciente(paciente8);
	        turno8.setEstadoTurno(true);

	        Turno turno9 = (Turno) appContext.getBean("beanTurno");
	        turno9.setEstado("pendiente");
	        turno9.setFecha(Date.valueOf("2024-05-24"));
	        turno9.setHora("13:00");
	        turno9.setObservacion("consulta nutricional");
	        turno9.setMedico(medico3);
	        turno9.setPaciente(paciente9);
	        turno9.setEstadoTurno(true);

	        Turno turno10 = (Turno) appContext.getBean("beanTurno");
	        turno10.setEstado("presente");
	        turno10.setFecha(Date.valueOf("2024-02-28"));
	        turno10.setHora("16:00");
	        turno10.setObservacion("consulta psicológica");
	        turno10.setMedico(medico2);
	        turno10.setPaciente(paciente10);
	        turno10.setEstadoTurno(true);
	          
	        Turno turno11 = (Turno) appContext.getBean("beanTurno");
	        turno11.setEstado("ausente");
	        turno11.setFecha(Date.valueOf("2024-01-28"));
	        turno11.setHora("16:00");
	        turno11.setObservacion("consulta nutricional");
	        turno11.setMedico(medico3);
	        turno11.setPaciente(paciente9);
	        turno11.setEstadoTurno(true);
	        
	        Turno turno12 = (Turno) appContext.getBean("beanTurno");
	        turno12.setEstado("presente");
	        turno12.setFecha(Date.valueOf("2024-03-01"));
	        turno12.setHora("12:00");
	        turno12.setObservacion("consulta psicológica");
	        turno12.setMedico(medico2);
	        turno12.setPaciente(paciente10);
	        turno12.setEstadoTurno(true);
	        
	        Turno turno13 = (Turno) appContext.getBean("beanTurno");
	        turno13.setEstado("ausente");
	        turno13.setFecha(Date.valueOf("2024-02-22"));
	        turno13.setHora("14:00");
	        turno13.setObservacion("consulta dermatológica");
	        turno13.setMedico(medico5);
	        turno13.setPaciente(paciente7);
	        turno13.setEstadoTurno(true);
	        
	        Turno turno14 = (Turno) appContext.getBean("beanTurno");
	        turno14.setEstado("ausente");
	        turno14.setFecha(Date.valueOf("2024-01-23"));
	        turno14.setHora("09:00");
	        turno14.setObservacion("examen anual");
	        turno14.setMedico(medico4);
	        turno14.setPaciente(paciente3);
	        turno14.setEstadoTurno(true);

			
			TurnoNegocio.addOrUpdateTurno(Turno1);
			
			TurnoNegocio.addOrUpdateTurno(turno);
	        TurnoNegocio.addOrUpdateTurno(turno2);
	        TurnoNegocio.addOrUpdateTurno(turno3);
	        TurnoNegocio.addOrUpdateTurno(turno4); 
	        TurnoNegocio.addOrUpdateTurno(turno5);
	        TurnoNegocio.addOrUpdateTurno(turno6);
	        TurnoNegocio.addOrUpdateTurno(turno7);
	        TurnoNegocio.addOrUpdateTurno(turno8);
	        TurnoNegocio.addOrUpdateTurno(turno9);
	        TurnoNegocio.addOrUpdateTurno(turno10);
	        TurnoNegocio.addOrUpdateTurno(turno11);
	        TurnoNegocio.addOrUpdateTurno(turno12);
	        TurnoNegocio.addOrUpdateTurno(turno13);
	        TurnoNegocio.addOrUpdateTurno(turno14);
	}

}
