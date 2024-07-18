package frgp.utn.edu.ar.daoImp;


import org.hibernate.Session;

import frgp.utn.edu.ar.daoImp.ConfigHibernate;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;

import java.util.List;
import org.hibernate.Query;



public class daoHibernate {
	//paciente
	public static void AddPaciente(Paciente paciente)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(paciente);
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}
	
	public static void UpdatePaciente(Paciente paciente) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.update(paciente);
		session.getTransaction().commit();
		
		ch.cerrarSession();
		}
	
	public static void addOrUpdatePaciente(Paciente paciente) {
	    if (!existsByLegajo(paciente.getDNI())) {
	    	AddPaciente(paciente);
	    } else {
	        UpdatePaciente(paciente); 
	    }
	}
	
	//usuario
	public static void Updateusuario(Usuario usuario) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.update(usuario);
		session.getTransaction().commit();
		
		ch.cerrarSession();
		}
	
	public static void AddUsuario(Usuario usuario)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		ch.cerrarSession();
	}
	

	
	public static void addOrUpdateUsuario(Usuario usuario) {
	    if (!existsByNombreUsuario(usuario.getNombreUsuario())) {
	    	AddUsuario(usuario);
	    } else {
	        Updateusuario(usuario); 
	    }
	}
	
	public static boolean existsByNombreUsuario(String NombreUsuario) {
	    ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();
	    try {
	       
	    	Query query = session.createQuery("SELECT count(*) FROM Usuario m WHERE m.NombreUsuario = :NombreUsuario");
	    	query.setParameter("NombreUsuario", NombreUsuario);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } finally {
	        ch.cerrarSession();
	    }
	}
	
	//especialidad
	public static void UpdateEspecialidad(Especialidad especialidad) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.update(especialidad);
		session.getTransaction().commit();
		
		ch.cerrarSession();
		}

	public static void AddEspecialidad(Especialidad especialidad)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(especialidad);
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}
	
	public static void addOrUpdateEspecialidad(Especialidad especialidad) {
	    if (!existsById(especialidad.getId())) {
	    	AddEspecialidad(especialidad);
	    } else {
	        UpdateEspecialidad(especialidad); 
	    }
	}
	
	public static boolean existsById(int Id) {
	    ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();
	    try {
	       
	    	Query query = session.createQuery("SELECT count(*) FROM Especialidad m WHERE m.Id = :Id");
	    	query.setParameter("Id", Id);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } finally {
	        ch.cerrarSession();
	    }
	}
	//medico
	public static void Add(Medico medico)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(medico);
		session.getTransaction().commit();
		
		ch.cerrarSession();
	}
	
	public static void addOrUpdateMedico(Medico medico) {
	    if (!existsByLegajo(medico.getLegajo())) {
	        Add(medico);
	    } else {
	        Update(medico); // Esto asume que quieres actualizar si el médico ya existe.
	    }
	}

	public static void delete(Medico medico) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		
		session.delete(medico);
		session.getTransaction().commit();
		ch.cerrarSession();
	}
	
	public static List<Medico> readAll() {
	    ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();
	    session.beginTransaction();

	    List<Medico> medicos = session.createQuery("FROM Medico").list();
	    
	    session.getTransaction().commit();
	    ch.cerrarSession();
	    
	    return medicos;
    }
	
	public static Medico readOne(int id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		
		Medico medico =(Medico) session.get(Medico.class, id);
		ch.cerrarSession();
		return medico;
		
	}
	
	public static void Update(Medico medico) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.update(medico);
		session.getTransaction().commit();
		
		ch.cerrarSession();
		
		
	}
	
	/*public static boolean existsByNombre(String Nombre) {
	    ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();
	    try {
	        // Asegúrate de que el nombre del parámetro coincida entre la consulta y setParameter
	    	Query query = session.createQuery("SELECT count(*) FROM Medico m WHERE m.Nombre = :Nombre");
	    	query.setParameter("Nombre", Nombre);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } finally {
	        ch.cerrarSession();
	    }
	}*/
		
	public static boolean existsByLegajo(int Legajo) {
	    ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();
	    try {
	        // Asegúrate de que el nombre del parámetro coincida entre la consulta y setParameter
	    	Query query = session.createQuery("SELECT count(*) FROM Medico m WHERE m.Legajo = :Legajo");
	    	query.setParameter("Legajo", Legajo);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } finally {
	        ch.cerrarSession();
	    }
	}
	
}

		

