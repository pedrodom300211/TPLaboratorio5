package frgp.utn.edu.ar.negocio;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.entidad.Turno;

public interface ITurnoNegocio {
	public void AddTurno(Turno turno);
	public void addOrUpdateTurno(Turno turno);
	public boolean existsById(int id);
	public void UpdateTurno(Turno turno);
	public void Delete(Turno turno);
	public List<Turno> ReadAll();
	public List<Turno> ReadAllxUsuario(String usuario);
	public Turno ReadOne(int id);
	public List<Turno> ReadAllXDniPaciente(String dni, String nombreUsuario);
	public List<Turno> ReadAllXEstadoTurno(String estado, String nombreUsuario);
	public Boolean ValidarFechaHoraMedico(String fecha, String hora,String legajo);
	List<Turno> ReadAllXDosFechasTurno( String FechaDesde, String FechaHasta);
	}
