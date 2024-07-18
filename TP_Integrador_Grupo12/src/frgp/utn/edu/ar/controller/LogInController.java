package frgp.utn.edu.ar.controller;

import javax.servlet.RequestDispatcher;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

@Controller
public class LogInController {
	
	
	@RequestMapping("redireccionar_LogIn.html")
	public ModelAndView eventoRedireccionarLogIn(String txtNombre, String txtContrasena) {
		ModelAndView MV = new ModelAndView();
		////
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		String errorMessage = "";
		
        
        UsuarioNegocio usuarioNeg = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
        Usuario usuario = usuarioNeg.ReadOne(txtNombre);
        
        if (!txtNombre.isEmpty() && !txtContrasena.isEmpty()) {
        	if (usuario != null) {
        		if(usuario.getContrasenaUsuario().equals(txtContrasena)) {
        			if(usuario.getIsAdmin()) {
        				MV.addObject("nombreUsuario", txtNombre);
        				MV.setViewName("InicioAdmin");
        				return MV;
        			}else {
        				MV.addObject("nombreUsuario", txtNombre);
        				MV.setViewName("InicioMedico");
        				return MV;
        				
        			}
        		} else {
        			errorMessage= "Contraseña incorrecta";
        			MV.addObject("mensajeError", errorMessage);
        			MV.setViewName("LogIn");
        			return MV;
        		}
        	} else {
			 errorMessage= "El usuario ingresado no existe";
			 MV.addObject("mensajeError", errorMessage);
			 MV.setViewName("LogIn");
			 return MV;
			 
		 }
        } else {
        	errorMessage= "Debe completar los campos";
        	MV.addObject("mensajeError", errorMessage);
        	MV.setViewName("LogIn");
        	return MV;
        	
        }
		////
		
		
	}
	
	

}
