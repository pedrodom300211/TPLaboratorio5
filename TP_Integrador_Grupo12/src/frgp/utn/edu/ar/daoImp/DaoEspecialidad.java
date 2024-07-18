package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IDaoEspecialidades;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;

public class DaoEspecialidad implements IDaoEspecialidades{
	
	 private ConfigHibernate conexion;
	
	public ConfigHibernate getConexion() {
		return conexion;
	}
	public void setConexion(ConfigHibernate conexion) {
		this.conexion = conexion;
	}
	
	Session session = null;
	public List<Especialidad> ReadAll() {
		
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();

	    List<Especialidad> especialidad = session.createQuery("FROM Especialidad").list();
	    
	    session.getTransaction().commit();
	    conexion.cerrarSession();
	    
	    return especialidad;
	}
	@Override
	public Especialidad ReadOne(int id) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		
		Especialidad especialidad =(Especialidad)session.get(Especialidad.class, id);
		conexion.cerrarSession();
		return especialidad;
	}
}
