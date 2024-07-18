package frgp.utn.edu.ar.daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import frgp.utn.edu.ar.dao.IDaoPaciente;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Usuario;

public class DaoPaciente implements IDaoPaciente{
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root"; 
	private String dbName = "tp_integrador_grupo12";
	 private ConfigHibernate conexion;
	 
	 public DaoPaciente() {
		}
		
		public DaoPaciente(ConfigHibernate conexion) {
			this.conexion = conexion;
		}
		
		public ConfigHibernate getConexion() {
			return conexion;
		}

		public void setConexion(ConfigHibernate conexion) {
			this.conexion = conexion;
		}
		
	    public void add(Paciente pac) {
	        conexion = new ConfigHibernate();
	        Session session = conexion.abrirConexion();
	        
	        session.beginTransaction();
	        session.save(pac);
	        session.getTransaction().commit();
	        
	        conexion.cerrarSession();
	    }
	    
		public void Delete(Paciente pac) {
			conexion = new ConfigHibernate();
			Session session = conexion.abrirConexion();
			session.beginTransaction();
			pac.setEstado(false);
			
			session.update(pac);
			session.getTransaction().commit();
			conexion.cerrarSession();
		}
		
		public Paciente ReadOne(int DNI) {
			conexion = new ConfigHibernate();
			Session session = conexion.abrirConexion();
			session.beginTransaction();
			
			Paciente paciente =(Paciente) session.get(Paciente.class, DNI);
			conexion.cerrarSession();
			return paciente;
		}
		
		public ArrayList<Paciente> ReadAll() {
			conexion = new ConfigHibernate();
		    Session session = conexion.abrirConexion();
		    session.beginTransaction();

		    List <Paciente> paciente = session.createQuery("FROM Paciente WHERE estado=1").list();
		    
		    session.getTransaction().commit();
		    conexion.cerrarSession();
		    ArrayList<Paciente> arrayListPaciente = (ArrayList<Paciente>) paciente;
		    return arrayListPaciente;
		}

		
		public void Update(Paciente paciente) {
			ConfigHibernate ch = new ConfigHibernate();
			Session session = ch.abrirConexion();
			session.beginTransaction();
			session.update(paciente);
			session.getTransaction().commit();
			
			ch.cerrarSession();
			
		}

		
		public ArrayList<Paciente> ObtenerPacientesFiltrados(int num) {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
			ArrayList<Paciente> Lista = new ArrayList<Paciente>();
			Connection cn = null;
			try {
				cn = DriverManager.getConnection(host+dbName, user, pass);
				Statement st = cn.createStatement();
				//ListarClientes ls = new ListarClientes();
				//String ddl = rs.get;
				ResultSet rs = st.executeQuery("select DNI , Apellido, Correo_electronico,Direccion,Fecha_nacimiento,Localidad,Nombre,Provincia,Telefono,estado from paciente where DNI LIKE  '"+num+"%' AND estado = 1");
				
				while(rs.next()) {
					
					Paciente paciente =(Paciente) appContext.getBean("beanPaciente");
					
					
					
					paciente.setDNI(rs.getInt("DNI"));
					paciente.setNombre(rs.getString("Nombre"));
					paciente.setApellido(rs.getString("Apellido"));
					paciente.setFechaNacimiento(rs.getString("Fecha_nacimiento"));
					paciente.setDireccion(rs.getString("Direccion"));
					paciente.setLocalidad(rs.getString("Localidad"));
					paciente.setCorreoElectronico(rs.getString("Correo_electronico"));
					paciente.setTelefono(rs.getString("Telefono"));
					paciente.setProvincia("Provincia");
					paciente.setEstado(rs.getBoolean("Estado"));
					
					
					Lista.add(paciente);
					
				}
				cn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
				
			}

			return Lista;
		}

		
		public ArrayList<Paciente> ObtenerPacientesFiltradosConDobleFiltro(String num, String Simbolo, int segundovalor) {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
			ArrayList<Paciente> Lista = new ArrayList<Paciente>();
			Connection cn = null;
			try {
				cn = DriverManager.getConnection(host+dbName, user, pass);
				Statement st = cn.createStatement();
			
				ResultSet rs = st.executeQuery("SELECT DNI, Apellido, Correo_electronico, Direccion, Fecha_nacimiento, Localidad, Nombre, Provincia, Telefono, estado " + "FROM paciente " +"WHERE " + num + " " + Simbolo + " '" +segundovalor + "' AND estado = 1");

				while(rs.next()) {
					
					Paciente paciente =(Paciente) appContext.getBean("beanPaciente");
					
					paciente.setDNI(rs.getInt("DNI"));
					paciente.setNombre(rs.getString("Nombre"));
					paciente.setApellido(rs.getString("Apellido"));
					paciente.setFechaNacimiento(rs.getString("Fecha_nacimiento"));
					paciente.setDireccion(rs.getString("Direccion"));
					paciente.setLocalidad(rs.getString("Localidad"));
					paciente.setCorreoElectronico(rs.getString("Correo_electronico"));
					paciente.setTelefono(rs.getString("Telefono"));
					paciente.setProvincia(rs.getString("Provincia"));
					paciente.setEstado(rs.getBoolean("Estado"));
					
					
					
					Lista.add(paciente);
					
				}
				cn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
				
			}

			return Lista;	
		}

}
