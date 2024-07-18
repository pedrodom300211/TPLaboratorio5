package frgp.utn.edu.ar.daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


import frgp.utn.edu.ar.dao.IDaoUsuario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Usuario;

public class DaoUsuario implements IDaoUsuario {

	private ConfigHibernate conexion;
	
	public DaoUsuario() {
		
	}

	@Override
	public boolean existsByUsername(String nombreUsuario) {
		conexion = new ConfigHibernate();
	    Session session = null;
	    try {
	    	session = conexion.abrirConexion();
	    	Query query = session.createQuery("SELECT count(*) FROM Usuario u WHERE u.NombreUsuario = :NombreUsuario");
	    	query.setParameter("NombreUsuario", nombreUsuario);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } catch (HibernateException e) {
            e.printStackTrace();
            return false;
	    } finally {
	        conexion.cerrarSession();
	    }
		
	}

	@Override
	public boolean validarContrasena(String nombreUsuario, String contrasena) {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    try {
	    	Query query = session.createQuery("SELECT contrasena c FROM usuario u WHERE u.NombreUsuario = :NombreUsuario");
	    	query.setParameter("NombreUsuario", nombreUsuario);
	    	String contrasenaDevuelta = (String) query.uniqueResult();
	        return contrasenaDevuelta.equals(contrasena);
	    } finally {
	        conexion.cerrarSession();
	    }
	}

	@Override
	public Usuario getUsuarioxUser(String usuario) {
		
		Usuario u = null;
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();

		try{
		
	        Query query = session.createQuery("SELECT u.NombreUsuario, u.ContrasenaUsuario, u.estado FROM Usuario WHERE NombreUsuario = :usuario");
	        query.setParameter("usuario", usuario);
	        Object[] result = (Object[]) query.uniqueResult();
	        
	        if (result != null) {
	            u.setNombreUsuario((String) result[0]);
	            u.setContrasenaUsuario((String) result[1]);
	            u.setEstado((Boolean)result[2]);
	            
	        }
	        session.getTransaction().commit();
	        
		 } catch (HibernateException e) {
		        if (session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.close();
		    }
		return u;
	}

	@Override
	public Usuario ReadOne(String nombreUsuario) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		
		Usuario usuario =(Usuario) session.get(Usuario.class, nombreUsuario);
		conexion.cerrarSession();
		return usuario;
	}

	public ConfigHibernate getConexion() {
		return conexion;
	}

	public void setConexion(ConfigHibernate conexion) {
		this.conexion = conexion;
	}
	public void Add(Usuario usuario) {
		
		System.out.println("Usuario del DAO:");
		System.out.println(usuario.toString());
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		conexion.cerrarSession();
		
	}
	
	
	
}
