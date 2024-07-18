package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;

public interface IDaoPaciente {
	void add(Paciente paciente);
	void Delete(Paciente paciente);
	public Paciente ReadOne(int DNI);
	public void Update(Paciente paciente);
	public ArrayList<Paciente> ReadAll();
	public ArrayList<Paciente> ObtenerPacientesFiltrados(int num);
	public ArrayList<Paciente> ObtenerPacientesFiltradosConDobleFiltro(String num, String Simbolo, int segundovalor);

}
