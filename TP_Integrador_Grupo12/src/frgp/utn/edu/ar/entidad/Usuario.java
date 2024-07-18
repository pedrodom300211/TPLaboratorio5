package frgp.utn.edu.ar.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "NombreUsuario")
    private String NombreUsuario;

    @Column(name = "ContrasenaUsuario")
    private String ContrasenaUsuario;

    @Column(name = "Estado")
    private Boolean estado;

    @Column(name = "IsAdmin")
    private Boolean isAdmin;



@OneToOne(mappedBy="usuario", fetch=FetchType.EAGER)
private Medico medico;

public Usuario() {}

public Usuario(String nombreUsuario, String contrasenaUsuario,Boolean estado1,Boolean isAdmin1) {
	super();
	NombreUsuario = nombreUsuario;
	ContrasenaUsuario = contrasenaUsuario;
	this.estado=estado1;
	this.isAdmin=isAdmin1;
}

public String getNombreUsuario() {
	return NombreUsuario;
}
public void setNombreUsuario(String nombreUsuario) {
	NombreUsuario = nombreUsuario;
}
public String getContrasenaUsuario() {
	return ContrasenaUsuario;
}
public void setContrasenaUsuario(String contrasenaUsuario) {
	ContrasenaUsuario = contrasenaUsuario;
}

public Medico getMedico() {
	return medico;
}

public void setMedico(Medico medico) {
	this.medico = medico;
}
public Boolean getIsAdmin() {
	return isAdmin;
}

public void setIsAdmin(Boolean isAdmin) {
	this.isAdmin = isAdmin;
}

@Override
public String toString() {
    return "Usuario{" +
            " nombreUsuario='" + NombreUsuario + '\'' +
            ", contrasenaUsuario='" + ContrasenaUsuario + '\'' +
            ", isAdmin=" + isAdmin +
            ", estado=" + estado +
            '}';
}

public Boolean getEstado() {
	return estado;
}

public void setEstado(Boolean estado) {
	this.estado = estado;
}


}
