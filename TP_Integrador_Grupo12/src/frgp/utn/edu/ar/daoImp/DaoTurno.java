package frgp.utn.edu.ar.daoImp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.entidad.Turno;

public class DaoTurno implements IDaoTurno{

private ConfigHibernate conexion;
	
	public DaoTurno() {
	}
	
	public DaoTurno(ConfigHibernate conexion) {
		this.conexion = conexion;
	}
	
	public ConfigHibernate getConexion() {
		return conexion;
	}

	public void setConexion(ConfigHibernate conexion) {
		this.conexion = conexion;
	}

	public void AddTurno(Turno turno) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		session.save(turno);
		session.getTransaction().commit();
		conexion.cerrarSession();
	}

	public void UpdateTurno(Turno turno) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		session.update(turno);
		session.getTransaction().commit();
		
		conexion.cerrarSession();
	}

	public void Delete(Turno turno) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		
		session.delete(turno);
		session.getTransaction().commit();
		conexion.cerrarSession();
	}

	public List<Turno> ReadAll() {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();

	    List<Turno> turnos = session.createQuery("FROM Turno").list();
	    
	    session.getTransaction().commit();
	    conexion.cerrarSession();
	    
	    return turnos;
	}

	public Turno ReadOne(int id) {
		conexion = new ConfigHibernate();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		
		Turno turno =(Turno)session.get(Turno.class, id);
		conexion.cerrarSession();
		return turno;
	}

	public void addOrUpdateTurno(Turno turno) {
		if (!existsById(turno.getId())) {
	    	AddTurno(turno);	
	    } else {
	        UpdateTurno(turno); 
	    }
	}
	
	public boolean existsById(int Id) {
	    conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    try {
	       
	    	Query query = session.createQuery("SELECT count(*) FROM Turno t WHERE t.Id = :Id");
	    	query.setParameter("Id", Id);
	    	Long count = (Long) query.uniqueResult();
	        return count != null && count > 0;
	    } finally {
	        conexion.cerrarSession();
	    }
	}

	@Override
	public List<Turno> ReadAllxUsuario(String nombreUsuario) {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();

	    Query query = session.createQuery("FROM Turno t WHERE t.Medico.usuario.NombreUsuario = :nombreUsuario");
	    query.setParameter("nombreUsuario", nombreUsuario);
	    List<Turno> turnos = query.list();
	    
	    session.getTransaction().commit();
	    conexion.cerrarSession();
	    
	    return turnos;
	}

	@Override
	public List<Turno> ReadAllXDniPaciente(String dni, String nombreUsuario) {
	    conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();

	    Query query = session.createQuery("FROM Turno t WHERE t.Medico.usuario.NombreUsuario = :nombreUsuario");
	    query.setParameter("nombreUsuario", nombreUsuario);
	   
	    List<Turno> turnos = query.list();
	    // Nueva lista para los resultados filtrados
	    List<Turno> turnosFiltrados = new ArrayList<>();

	    for (Turno turno : turnos) {
	    	String dniStr = String.valueOf(turno.getPaciente().getDNI());
	        if (dniStr.contains(dni)) {
	            turnosFiltrados.add(turno);
	        }
	    }
	    
	    session.getTransaction().commit();
	    conexion.cerrarSession();

	    return turnosFiltrados;
	}


	@Override
	public List<Turno> ReadAllXEstadoTurno(String estado, String nombreUsuario) {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();
	    
	    Query query = session.createQuery("FROM Turno t WHERE t.Medico.usuario.NombreUsuario = :nombreUsuario AND t.Estado LIKE :estado");
	    query.setParameter("nombreUsuario", nombreUsuario);
	    query.setParameter("estado", estado);
	    
	    List<Turno> turnos = query.list();
	    
	    session.getTransaction().commit();
	    conexion.cerrarSession();
	    
	    return turnos;
	}
	@Override
	public Boolean ValidarFechaHoraMedico(String fecha, String hora,String Legajo) {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();
	    try {
	    	Integer medicoId = Integer.parseInt(Legajo);
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date utilDate = formatter.parse(fecha);
	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	        System.out.println("DaoTurno:"+sqlDate);
	        
	    	Query query = session.createQuery("SELECT COUNT(t) FROM Turno t WHERE t.Fecha = :fecha AND t.Hora = :hora AND t.Medico.id = :ID");
	    	query.setParameter("hora", hora);
			query.setParameter("fecha", sqlDate);
			query.setParameter("ID", medicoId);
			System.out.println(query);
	    
	    Long count = (Long) query.uniqueResult();
	    System.out.println("Resultado del conteo: " + count);
	    
	    if (count == 0) {
	        return true;
	    } else {
	        return false;
	    }
		} catch (Exception e) {
			// TODO: handle exception
		}
	    
		return false;
		
		
		
//		 conexion = new ConfigHibernate();
//		    Session session = conexion.abrirConexion();
//		    session.beginTransaction();
//		    Boolean bandera=false;
//		    List<Turno> turnos = null;
//		    try {
//		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		        java.util.Date utilDate = formatter.parse(fecha);
//		        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//		        Integer medicoId = Integer.parseInt(Legajo);
//		       
//		        LocalTime horaActual = LocalTime.parse(hora);
//		        
//		   
//		    for(int i =0; i<60; i ++) {
//		    	  
//	            horaActual = horaActual.plusMinutes(1);
//
//	            Query query = session.createQuery("FROM Turno t WHERE t.Fecha = :fecha AND t.Hora = :hora AND t.Medico.id = :ID");
//	            String nuevaHoraStr = horaActual.format(DateTimeFormatter.ofPattern("HH:mm"));
//	            query.setParameter("hora", nuevaHoraStr);
//	            query.setParameter("fecha", sqlDate);
//	            query.setParameter("ID", medicoId);
//
//	            turnos = query.list();
//	            System.out.println(turnos);
//	            System.out.println(sqlDate);
//	            System.out.println(medicoId);
//	            System.out.println(horaActual);
//		        if(turnos.isEmpty()) {
//				    bandera=true;
//				    }else {
//				    bandera= false;
//				    break;
//				    }
//		}
//		    horaActual = LocalTime.parse(hora);
//		    for(int i =0; i<60; i ++) {
//		    	  
//	            horaActual = horaActual.minusMinutes(1);
//
//	            Query query = session.createQuery("FROM Turno t WHERE t.Fecha = :fecha AND t.Hora = :hora AND t.Medico.id = :ID");
//	            String nuevaHoraStr = horaActual.format(DateTimeFormatter.ofPattern("HH:mm"));
//	            query.setParameter("hora", nuevaHoraStr);
//	            query.setParameter("fecha", sqlDate);
//	            query.setParameter("ID", medicoId);
//
//	            turnos = query.list();
//	            System.out.println(turnos);
//	            System.out.println(sqlDate);
//	            System.out.println(medicoId);
//	            System.out.println(horaActual);
//		        if(turnos.isEmpty()) {
//				    bandera=true;
//				    }else {
//				    bandera= false;
//				    break;
//				    }
//		}
//		    
//		    
//		    
//		    
//		    
//    }
//		    catch (ParseException e) {
//		        e.printStackTrace();
//		    } finally {
//		        session.getTransaction().commit();
//		        conexion.cerrarSession();
//		    }
//		    
//		    
//		    
//		   
//	    if(bandera) {
//	    return false;
//	    }else {return true;}
	}
	
	@Override
	public List<Turno> ReadAllXDosFechasTurno(String FechaDesde, String FechaHasta) {
		conexion = new ConfigHibernate();
	    Session session = conexion.abrirConexion();
	    session.beginTransaction();
	    
	    Query query = session.createQuery("FROM Turno t WHERE t.Fecha BETWEEN '"+FechaDesde+"' AND '"+FechaHasta+"'");
	   
	 
	    
	    List<Turno> turnos = query.list();
	    
	    session.getTransaction().commit();
	    conexion.cerrarSession();
	    
	    return turnos;
	}


}
