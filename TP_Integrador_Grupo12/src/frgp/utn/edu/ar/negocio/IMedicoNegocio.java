package frgp.utn.edu.ar.negocio;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.entidad.Medico;


public interface IMedicoNegocio {
	public void Add(Medico med);
	public void Delete(Medico medico);
	public ArrayList<Medico> ReadAll();
	public Medico ReadOne(int id);
	public void Update(Medico medico);
	public boolean existsByLegajo(int legajo);
	public ArrayList<Medico> ObtenerMedicoFiltrados(int num);
	public ArrayList<Medico> ObtenerMedicoFiltradosConDobleFiltro(String num, String Simbolo, int segundovalor);
	public ArrayList<Medico> ObtenerMedicoxEspecialidad(int num);
	
}
