package frgp.utn.edu.ar.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.IDaoMedico;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;

public class DaoMedico implements IDaoMedico {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root"; 
	private String dbName = "tp_integrador_grupo12";
	
	private ConfigHibernate conexion;
	
	public DaoMedico() {
	}
	
	public DaoMedico(ConfigHibernate conexion) {
		this.conexion = conexion;
	}
	
	public ConfigHibernate getConexion() {
		return conexion;
	}

	public void setConexion(ConfigHibernate conexion) {
		this.conexion = conexion;
	}

	
	public void Add(Medico med) {
		
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		session.save(med);
		session.getTransaction().commit();
		conexion.cerrarSession();
		}
	        

		
	

	public void Delete(Medico medico) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		medico.setEstado(false);
		
		session.update(medico);
		session.getTransaction().commit();
		conexion.cerrarSession();
	}

	public ArrayList<Medico> ReadAll() {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();

	    List<Medico> medicos = session.createQuery("FROM Medico WHERE estado=1").list();
	    
	    session.getTransaction().commit();
	    conexion.cerrarSession();
	    ArrayList<Medico> arrayListMedico = (ArrayList<Medico>) medicos;
	    return arrayListMedico;
	    
	   
	}
	
	public ArrayList<Medico> ReadMedicos() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		
		ArrayList<Medico> Lista = new ArrayList<Medico>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("\r\n" + 
					"\r\n" + 
					"select Legajo,medicos.nombre,Apellido,Sexo,FechaNacimiento,Direccion,Localidad,Provincia,CorreoElectronico,Telefono, e.Nombre,e.Id,DiasTrabaja,Horario,medicos.Estado FROM Medicos inner join especialidad e on medicos.ID_especialidad_e= e.Id where estado=1");
			
			while(rs.next()) {
				Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
				Medico MedicoL = (Medico) appContext.getBean("beanMedico");
				Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
				
				
				usuario.setNombreUsuario(rs.getString("e.Nombre"));
				
				MedicoL.setLegajo(rs.getInt("Legajo"));
				MedicoL.setNombre(rs.getString("Nombre"));
				MedicoL.setApellido(rs.getString("Apellido"));
				MedicoL.setSexo(rs.getString("Sexo"));
				MedicoL.setFechaNacimiento(rs.getString("FechaNacimiento"));
				MedicoL.setDireccion(rs.getString("Direccion"));
				MedicoL.setLocalidad(rs.getString("Localidad"));
				MedicoL.setProvincia(rs.getString("Provincia"));
				MedicoL.setCorreoElectronico(rs.getString("CorreoElectronico"));
				MedicoL.setTelefono(rs.getString("Telefono"));
				Especialidad.setId(rs.getInt("e.Id"));
				Especialidad.setNombre(rs.getString("e.Nombre"));
				MedicoL.setEspecialidad(Especialidad);
				MedicoL.setUsuario(usuario);
				MedicoL.setDiasTrabaja(rs.getString("DiasTrabaja"));
				MedicoL.setHorario(rs.getString("Horario"));
				MedicoL.setEstado(rs.getBoolean("Estado"));
				
				
				Lista.add(MedicoL);
				
			}
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}

		return Lista;
	}

	public Medico ReadOne(int id) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		
		Medico medico =(Medico) session.get(Medico.class, id);
		conexion.cerrarSession();
		return medico;
	}

	public void Update(Medico medico) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.update(medico);
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}

	public boolean existsByLegajo(int legajo) {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    try {
	    	Query query = session.createQuery("SELECT count(*) FROM Medico m WHERE estado=1 AND m.Legajo = :Legajo");
	    	query.setParameter("Legajo", legajo);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } finally {
	        conexion.cerrarSession();
	    }
	}
	///no funciona
	public boolean EstadoMedicobyLegajo(int legajo) {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    try {
	    	Query query = session.createQuery("SELECT count(*) FROM Medico m WHERE m.Legajo = :Legajo");
	    	query.setParameter("Legajo", legajo);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } finally {
	        conexion.cerrarSession();
	    }
	}
	
	
	public ArrayList<Medico> ObtenerMedicoFiltrados(int num){
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		ArrayList<Medico> Lista = new ArrayList<Medico>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			//ListarClientes ls = new ListarClientes();
			//String ddl = rs.get;
			ResultSet rs = st.executeQuery("select Legajo,medicos.nombre,Apellido,Sexo,FechaNacimiento,Direccion,Localidad,Provincia,CorreoElectronico,Telefono, e.Nombre,e.Id,DiasTrabaja,Horario,medicos.Estado FROM Medicos inner join especialidad e on medicos.ID_especialidad_e= e.Id WHERE medicos.Estado=1 AND Legajo LIKE '"+num+"%'");
			
			while(rs.next()) {
				
				Medico MedicoL =(Medico) appContext.getBean("beanMedico");
				Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
				Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
				
				
				usuario.setNombreUsuario(rs.getString("e.Nombre"));
				MedicoL.setLegajo(rs.getInt("Legajo"));
				MedicoL.setNombre(rs.getString("Nombre"));
				MedicoL.setApellido(rs.getString("Apellido"));
				MedicoL.setSexo(rs.getString("Sexo"));
				MedicoL.setFechaNacimiento(rs.getString("FechaNacimiento"));
				MedicoL.setDireccion(rs.getString("Direccion"));
				MedicoL.setLocalidad(rs.getString("Localidad"));
				MedicoL.setProvincia(rs.getString("Provincia"));
				MedicoL.setCorreoElectronico(rs.getString("CorreoElectronico"));
				MedicoL.setTelefono(rs.getString("Telefono"));
				Especialidad.setId(rs.getInt("e.Id"));
				Especialidad.setNombre(rs.getString("e.Nombre"));
				MedicoL.setEspecialidad(Especialidad);
				MedicoL.setUsuario(usuario);
				MedicoL.setDiasTrabaja(rs.getString("DiasTrabaja"));
				MedicoL.setHorario(rs.getString("Horario"));
				MedicoL.setEstado(rs.getBoolean("Estado"));
				
				
				Lista.add(MedicoL);
				
			}
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}

		return Lista;

		
	}

	
	public ArrayList<Medico> ObtenerMedicoFiltradosConDobleFiltro(String num, String Simbolo, int segundovalor) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		ArrayList<Medico> Lista = new ArrayList<Medico>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("select Legajo,medicos.nombre,Apellido,Sexo,FechaNacimiento,Direccion,Localidad,Provincia,CorreoElectronico,Telefono, e.Nombre,e.Id,DiasTrabaja,Horario,medicos.Estado FROM Medicos inner join especialidad e on medicos.ID_especialidad_e= e.Id  WHERE medicos.Estado=1 AND " + num + " " + Simbolo + " " + segundovalor);
			
			while(rs.next()) {
				
				Medico MedicoL =(Medico) appContext.getBean("beanMedico");
				Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
				Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
				
				
				usuario.setNombreUsuario(rs.getString("Nombre"));
				MedicoL.setLegajo(rs.getInt("Legajo"));
				MedicoL.setNombre(rs.getString("Nombre"));
				MedicoL.setApellido(rs.getString("Apellido"));
				MedicoL.setSexo(rs.getString("Sexo"));
				MedicoL.setFechaNacimiento(rs.getString("FechaNacimiento"));
				MedicoL.setDireccion(rs.getString("Direccion"));
				MedicoL.setLocalidad(rs.getString("Localidad"));
				MedicoL.setProvincia(rs.getString("Provincia"));
				MedicoL.setCorreoElectronico(rs.getString("CorreoElectronico"));
				MedicoL.setTelefono(rs.getString("Telefono"));
				Especialidad.setId(rs.getInt("Id"));
				Especialidad.setNombre(rs.getString("Nombre"));
				MedicoL.setEspecialidad(Especialidad);
				MedicoL.setUsuario(usuario);
				MedicoL.setDiasTrabaja(rs.getString("DiasTrabaja"));
				MedicoL.setHorario(rs.getString("Horario"));
				MedicoL.setEstado(rs.getBoolean("Estado"));
				
				
				Lista.add(MedicoL);
				
			}
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}

		return Lista;	
	}


	public ArrayList<Medico> ObtenerMedicoxEspecialidad(int num) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		ArrayList<Medico> Lista = new ArrayList<Medico>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = cn.createStatement();
			//ListarClientes ls = new ListarClientes();
			//String ddl = rs.get;
			ResultSet rs = st.executeQuery("select Legajo,medicos.nombre,Apellido,Sexo,FechaNacimiento,Direccion,Localidad,Provincia,CorreoElectronico,Telefono, e.Nombre,e.Id,DiasTrabaja,Horario,medicos.Estado FROM Medicos inner join especialidad e on medicos.ID_especialidad_e= e.Id WHERE e.Id= "+num+" AND medicos.Estado = 1;");
			
			while(rs.next()) {
				
				Medico MedicoL =(Medico) appContext.getBean("beanMedico");
				Especialidad Especialidad = (Especialidad) appContext.getBean("beanEspecialidad");
				Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
				
				
				usuario.setNombreUsuario(rs.getString("e.Nombre"));
				MedicoL.setLegajo(rs.getInt("Legajo"));
				MedicoL.setNombre(rs.getString("Nombre"));
				MedicoL.setApellido(rs.getString("Apellido"));
				MedicoL.setSexo(rs.getString("Sexo"));
				MedicoL.setFechaNacimiento(rs.getString("FechaNacimiento"));
				MedicoL.setDireccion(rs.getString("Direccion"));
				MedicoL.setLocalidad(rs.getString("Localidad"));
				MedicoL.setProvincia(rs.getString("Provincia"));
				MedicoL.setCorreoElectronico(rs.getString("CorreoElectronico"));
				MedicoL.setTelefono(rs.getString("Telefono"));
				Especialidad.setId(rs.getInt("e.Id"));
				Especialidad.setNombre(rs.getString("e.Nombre"));
				MedicoL.setEspecialidad(Especialidad);
				MedicoL.setUsuario(usuario);
				MedicoL.setDiasTrabaja(rs.getString("DiasTrabaja"));
				MedicoL.setHorario(rs.getString("Horario"));
				MedicoL.setEstado(rs.getBoolean("Estado"));
				
				
				Lista.add(MedicoL);
				
			}
			cn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}

		return Lista;
	}
	
	

}
