package frgp.utn.edu.ar.dao;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Usuario;

public interface IDaoUsuario {
	public void Add(Usuario med);
	public boolean existsByUsername(String nombreUsuario);
	public boolean validarContrasena(String nombreUsuario, String contrasena);
	public Usuario getUsuarioxUser (String usuario);	
	public Usuario ReadOne(String nombreUsuario);
}
