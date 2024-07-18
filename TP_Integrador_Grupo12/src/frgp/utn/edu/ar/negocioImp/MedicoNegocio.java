package frgp.utn.edu.ar.negocioImp;

import java.util.ArrayList;
import java.util.List;


import frgp.utn.edu.ar.dao.IDaoMedico;
import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.daoImp.DaoMedico;
import frgp.utn.edu.ar.daoImp.DaoTurno;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocio.IMedicoNegocio;

public class MedicoNegocio implements IMedicoNegocio{
	
	private IDaoMedico daoMedico;

public MedicoNegocio() {
		
	}

	public MedicoNegocio(DaoMedico daoMedico) {
		this.daoMedico= daoMedico;
	}
	
	public IDaoMedico getDaoMedico() {
		return daoMedico;
	}
	
	public void setDaoMedico(IDaoMedico daoMedico) {
		this.daoMedico= daoMedico;
	}
	
	public void Add(Medico med) {
		daoMedico.Add(med);
	}

	public void Delete(Medico medico) {
		daoMedico.Delete(medico);
	}

	public ArrayList<Medico> ReadAll() {
		return daoMedico.ReadAll();
	}

	public Medico ReadOne(int id) {
		return daoMedico.ReadOne(id);
	}

	public void Update(Medico medico) {
		daoMedico.Update(medico);
	}

	public boolean existsByLegajo(int legajo) {
		return daoMedico.existsByLegajo(legajo);
	}

	
	public ArrayList<Medico> ObtenerMedicoFiltrados(int num) {
		return daoMedico.ObtenerMedicoFiltrados(num);
	}

	
	public ArrayList<Medico> ObtenerMedicoFiltradosConDobleFiltro(String num, String Simbolo, int segundovalor) {
		return daoMedico.ObtenerMedicoFiltradosConDobleFiltro( num,Simbolo,segundovalor);
	}

	
	public ArrayList<Medico> ObtenerMedicoxEspecialidad(int num) {
		return daoMedico.ObtenerMedicoxEspecialidad(num);
	}

}



