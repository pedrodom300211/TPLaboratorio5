package frgp.utn.edu.ar.negocio;

import frgp.utn.edu.ar.entidad.Usuario;

public interface IUsuarioNegocio {
	public void Add(Usuario usuario);
	public boolean existsByUsername(String nombreUsuario);
	public boolean validarContrasena(String nombreUsuario, String contrasena);
	public Usuario getUsuarioxUser (String usuario);
	public Usuario ReadOne(String nombreUsuario);
}
