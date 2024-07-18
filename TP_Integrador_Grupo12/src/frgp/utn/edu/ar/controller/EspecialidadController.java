package frgp.utn.edu.ar.controller;

import org.springframework.stereotype.Controller;

import frgp.utn.edu.ar.daoImp.DaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;

import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;


import java.util.ArrayList;
import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EspecialidadController {

 	
    
	@RequestMapping("Cargar_Ddl_Especialidad.html")
	public ModelAndView eventoCargarDdlEspecialidades(String txtUsuario) {
		ModelAndView MV = new ModelAndView();
		MV.addObject("nombreUsuario", txtUsuario);
		ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/beans.xml");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
     	ArrayList<Especialidad> listaEspecialidades = (ArrayList<Especialidad>) especialidadNegocio.ReadAll();
     	
     		MV.addObject("listaEspecialidades", listaEspecialidades);
     		
			MV.setViewName("AsignacionTurnos");
			return MV;
		 
		  
		 
		 
	
	}

}
