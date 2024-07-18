package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Turno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name="Fecha")
	private Date Fecha;
	@Column(name="Hora")
	private String Hora;
	@Column(name="Observacion")
	private String Observacion;
	@Column(name="estado")
	private String Estado;//(pendiente,presente,ausente)
	@Column(name="estadoTruno")
	private Boolean estadoTurno;///para dar de baja logica
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ID_medico")
	private Medico Medico;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="DNI_paciente")
	private Paciente Paciente;
	
	public Turno() {
		
	}
	
	public Turno(Date fecha, String hora, String observacion, String estado, Medico medico, Paciente paciente) {
		Fecha = fecha;
		Hora = hora;
		Observacion = observacion;
		Estado = estado;
		Medico = medico;
		Paciente = paciente;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public Medico getMedico() {
		return Medico;
	}

	public void setMedico(Medico medico) {
		Medico = medico;
	}

	public Paciente getPaciente() {
		return Paciente;
	}

	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}

	public int getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Turno [Id=" + Id + ", Fecha=" + Fecha + ", Hora=" + Hora + ", Observacion=" + Observacion + ", Estado="
				+ Estado + ", Medico=" + Medico + ", Paciente=" + Paciente + "]";
	}

	public Boolean getEstadoTurno() {
		return estadoTurno;
	}

	public void setEstadoTurno(Boolean estadoTurno) {
		this.estadoTurno = estadoTurno;
	}
	
	
}