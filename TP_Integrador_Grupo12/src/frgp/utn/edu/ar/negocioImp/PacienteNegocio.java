package frgp.utn.edu.ar.negocioImp;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.dao.IDaoPaciente;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.negocio.IPacienteNegocio;

public class PacienteNegocio implements IPacienteNegocio{
	private IDaoPaciente daoPaciente;

    public PacienteNegocio() {
    }

    public PacienteNegocio(IDaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public IDaoPaciente getDaoPaciente() {
        return daoPaciente;
    }

    public void setDaoPaciente(IDaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }
    
    public void add (Paciente paciente) {
        daoPaciente.add(paciente);
    }
    
    public void Delete (Paciente paciente) {
        daoPaciente.Delete(paciente);
    }

	
	public Paciente ReadOne(int DNI) {
		 return daoPaciente.ReadOne(DNI);
	}
	public ArrayList<Paciente> ReadAll() {
		return daoPaciente.ReadAll();
	}

	
	public void Update(Paciente paciente) {
		daoPaciente.Update(paciente);
		
	}

	@Override
	public ArrayList<Paciente> ObtenerPacientesFiltrados(int num) {
		return daoPaciente.ObtenerPacientesFiltrados(num);
	}

	
	
	public ArrayList<Paciente> ObtenerPacientesFiltradosConDobleFiltro(String num, String Simbolo, int segundovalor) {
		return daoPaciente.ObtenerPacientesFiltradosConDobleFiltro( num,Simbolo,segundovalor);
	}

}
