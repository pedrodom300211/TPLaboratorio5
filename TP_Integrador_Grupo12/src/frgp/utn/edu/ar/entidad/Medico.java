package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Medicos")
public class Medico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Legajo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Legajo;
	@Column(name="Nombre")
	private String Nombre;
	@Column(name="Apellido")
	private String Apellido;
	@Column(name="Sexo")
	private String sexo;
	@Column(name="FechaNacimiento")
	private String FechaNacimiento;
	@Column(name="Direccion")
	private String Direccion;
	@Column(name="Localidad")
	private String Localidad;
	@Column(name="Provincia")
	private String Provincia;
	public String getProvincia() {
		return Provincia;
	}


	public void setProvincia(String provincia) {
		Provincia = provincia;
	}


	@Column(name="CorreoElectronico")
	private String CorreoElectronico;
	@Column(name="Telefono")
	private String Telefono;
	@Column(name="DiasTrabaja")
	private String DiasTrabaja;
	@Column(name="Horario")
	private String Horario;
	@Column(name="Estado")
	private Boolean estado;
	
	@OneToOne(cascade= {CascadeType.ALL}) 
	@JoinColumn(name="NombreUsuario")
	private Usuario usuario;
	
	@ManyToOne(cascade= {CascadeType.ALL}) 
	@JoinColumn(name="ID_especialidad_e")
	private Especialidad especialidad;

	public Medico() {
		
	}


	public Medico(int legajo, String nombre, String apellido, String sexo, String fechaNacimiento, String direccion,
			String localidad, String correoElectronico, String telefono, Usuario usuario, Especialidad especialidad) {
		super();
		Legajo = legajo;
		Nombre = nombre;
		Apellido = apellido;
		this.sexo = sexo;
		FechaNacimiento = fechaNacimiento;
		Direccion = direccion;
		Localidad = localidad;
		CorreoElectronico = correoElectronico;
		Telefono = telefono;
		this.usuario = usuario;
		this.especialidad = especialidad;
	}



	public void setLegajo(int legajo) {
		Legajo = legajo;
	}


	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getLegajo() {
		return Legajo;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getCorreoElectronico() {
		return CorreoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	

	
	public String getDiasTrabaja() {
		return DiasTrabaja;
	}


	public void setDiasTrabaja(String diasTrabaja) {
		this.DiasTrabaja = diasTrabaja;
	}


	public String getHorario() {
		return Horario;
	}


	public void setHorario(String horario) {
		Horario = horario;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
	    String mensaje= "Medico [Legajo=" + Legajo + ", Nombre=" + Nombre + ", Apellido=" + Apellido +
	            ", Sexo=" + sexo + ", FechaNacimiento=" + FechaNacimiento + ", Direccion=" + Direccion +
	            ", Localidad=" + Localidad + ", CorreoElectronico=" + CorreoElectronico +
	            ", Telefono=" + Telefono + ", usuario=";
	    if (usuario != null) {
	        mensaje += usuario.getNombreUsuario();
	    }
	    
	    mensaje += ", especialidad=";
	    
	    if (especialidad != null) {
	        mensaje += especialidad.getNombre();
	    }
	    
	    mensaje += "]";
	    return mensaje;
	}
	
}
