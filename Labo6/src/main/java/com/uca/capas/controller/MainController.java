package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;



@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@Autowired
	private ImportanciaService importanciaService;
	
	@GetMapping ("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia> importancias = null;
		importancias = importanciaService.findAll();
		mav.addObject("contribuyente", contribuyente);
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		return mav;
		
	}

}
