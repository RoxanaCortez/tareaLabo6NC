package com.uca.capas.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/contribuyentes")
	public ModelAndView contibuyentes() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		
		contribuyentes = contribuyenteService.findAll();
	
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("contribuyentes");
		return mav;
	}
	
	@PostMapping("/ingresarContribuyente")
	public ModelAndView ingresar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) { 
			List<Importancia> importancias= null;
			try {
				importancias =  importanciaService.findAll();
				
				mav.addObject("importancias",importancias);
				mav.setViewName("index");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {	
			try {
				ZoneId zona = ZoneId.systemDefault();
				LocalDate fechaActual = LocalDate.now();
				Date fecha = Date.from(fechaActual.atStartOfDay(zona).toInstant());
				contribuyente.setFecha(fecha);
				contribuyente.getFecha();
				contribuyenteService.insertar(contribuyente);
				
				mav.addObject("exito", "Contribuyente guardado con éxito");
				mav.setViewName("guardado");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return mav;
	
	}

}
