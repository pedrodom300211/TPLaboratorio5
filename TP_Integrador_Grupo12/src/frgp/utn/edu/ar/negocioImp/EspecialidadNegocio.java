package frgp.utn.edu.ar.negocioImp;

import java.util.List;

import frgp.utn.edu.ar.dao.IDaoEspecialidades;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.negocio.IEspecialidadNegocio;

public class EspecialidadNegocio implements IEspecialidadNegocio{
	
	private IDaoEspecialidades daoEspecialidades;

	

	public IDaoEspecialidades getDaoEspecialidades() {
		return daoEspecialidades;
	}

	public void setDaoEspecialidades(IDaoEspecialidades daoEspecialidades) {
		this.daoEspecialidades = daoEspecialidades;
	}
	
	public List<Especialidad> ReadAll() {
		return daoEspecialidades.ReadAll();
	}

	@Override
	public Especialidad ReadOne(int id) {
		return daoEspecialidades.ReadOne(id);
		}
	
}
