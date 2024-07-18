package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name="Nombre")
	private String Nombre;
	@Column(name="Apellido")
	private String Apellido;
	@Id
	@Column(name="DNI")
	private int DNI;
	@Column(name="Telefono")
	private String Telefono;
	@Column(name="Direccion")
	private String Direccion;
	@Column(name="Localidad")
	private String Localidad;
	@Column(name="Provincia")
	private String Provincia;
	@Column(name="estado")
	private Boolean estado;
	
	@Column(name="Fecha_nacimiento")
	private String FechaNacimiento;
	
	@Column(name="Correo_electronico")
	private String CorreoElectronico;
	

	public Paciente() {
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

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
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

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getCorreoElectronico() {
		return CorreoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}

	@Override
	public String toString() {
		return "Paciente [Nombre=" + Nombre + ", Apellido=" + Apellido + ", DNI=" + DNI + ", Telefono=" + Telefono
				+ ", Direccion=" + Direccion + ", Localidad=" + Localidad + ", Provincia=" + Provincia
				+ ", FechaNacimiento=" + FechaNacimiento + ", CorreoElectronico=" + CorreoElectronico + "]";
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
		
}