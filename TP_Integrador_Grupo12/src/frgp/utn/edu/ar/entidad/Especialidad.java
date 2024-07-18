package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Especialidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name="Nombre")
	private String Nombre;
	@Column(name="estado")
	private Boolean estado;
	
	public Especialidad() {
	}
	
	public Especialidad(int id, String nombre) {
		super();
		Id = id;
		Nombre = nombre;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Especialidad [Id=" + Id + ", Nombre=" + Nombre + ", estado=" + estado + "]";
	}
	
	
	
	

}
