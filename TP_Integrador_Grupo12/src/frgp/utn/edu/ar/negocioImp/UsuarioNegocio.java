package frgp.utn.edu.ar.negocioImp;

import frgp.utn.edu.ar.negocio.IUsuarioNegocio;
import frgp.utn.edu.ar.dao.IDaoUsuario;
import frgp.utn.edu.ar.daoImp.DaoUsuario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Usuario;

public class UsuarioNegocio implements IUsuarioNegocio {
	
	private IDaoUsuario daoUsuario; 
	
	 public UsuarioNegocio() {
	        
	    }
	 
	 public UsuarioNegocio(DaoUsuario daoUsuario) {
		    this.daoUsuario = daoUsuario;
		}
	    
	@Override
	public boolean existsByUsername(String userName) {
		return daoUsuario.existsByUsername(userName);
	}

	@Override
	public boolean validarContrasena(String nombreUsuario, String contrasena) {
		return daoUsuario.validarContrasena(nombreUsuario, contrasena);
	}

	@Override
	public Usuario getUsuarioxUser(String usuario) {
		return daoUsuario.getUsuarioxUser(usuario);
	}

	@Override
	public Usuario ReadOne(String nombreUsuario) {
		return daoUsuario.ReadOne(nombreUsuario);
	}

	public IDaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(IDaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	public void Add(Usuario usuario) {
		daoUsuario.Add(usuario);
	}

	

}
