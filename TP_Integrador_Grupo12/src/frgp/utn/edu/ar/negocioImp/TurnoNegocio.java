package frgp.utn.edu.ar.negocioImp;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.daoImp.DaoTurno;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.negocio.ITurnoNegocio;

public class TurnoNegocio implements ITurnoNegocio{
	private IDaoTurno daoTurno;
	
	public TurnoNegocio() {
		
	}
	
	public TurnoNegocio(DaoTurno daoTurno) {
		this.daoTurno= daoTurno;
	}
	
	public IDaoTurno getDaoTurno() {
		return daoTurno;
	}
	
	public void setDaoTurno(IDaoTurno daoTurno) {
		this.daoTurno= daoTurno;
	}

	public void AddTurno(Turno turno) {
		daoTurno.AddTurno(turno);
	}

	public void addOrUpdateTurno(Turno turno) {
		daoTurno.addOrUpdateTurno(turno);
	}

	public void UpdateTurno(Turno turno) {
		daoTurno.UpdateTurno(turno);
	}

	public void Delete(Turno turno) {
		daoTurno.Delete(turno);
	}

	public List<Turno> ReadAll() {
		return daoTurno.ReadAll();
	}

	public Turno ReadOne(int id) {
		return daoTurno.ReadOne(id);
	}

	public boolean existsById(int id) {
		return daoTurno.existsById(id);
	}

	@Override
	public List<Turno> ReadAllxUsuario(String usuario) {
		return daoTurno.ReadAllxUsuario(usuario);
	}

	@Override
	public List<Turno> ReadAllXDniPaciente(String dni, String nombreUsuario) {
		return daoTurno.ReadAllXDniPaciente(dni,nombreUsuario);
		}

	@Override
	public List<Turno> ReadAllXEstadoTurno(String estado, String nombreUsuario) {
		return daoTurno.ReadAllXEstadoTurno(estado,nombreUsuario);
		}

	@Override
	public Boolean ValidarFechaHoraMedico(String fecha, String hora,String Legajo) {
		return daoTurno.ValidarFechaHoraMedico(fecha, hora,Legajo);
	}

	@Override
	public List<Turno> ReadAllXDosFechasTurno( String FechaDesde, String FechaHasta) {
		return daoTurno.ReadAllXDosFechasTurno( FechaDesde, FechaHasta);
	}

	

	
}
