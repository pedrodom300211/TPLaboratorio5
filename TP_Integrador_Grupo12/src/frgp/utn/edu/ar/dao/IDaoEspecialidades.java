package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Especialidad;
//import frgp.utn.edu.ar.entidad.Medico;



public interface IDaoEspecialidades {
	public List<Especialidad> ReadAll();
	public Especialidad ReadOne(int id);
}
