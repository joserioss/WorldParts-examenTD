package cl.jrios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.dto.EntidadFiltradoDTO;
import cl.jrios.service.impl.EntidadServiceImpl;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private EntidadServiceImpl servicioEntidad;
	
	@GetMapping
	public String home() {
		return "home";
	}
	
	@PostMapping("/filtrado")
	public String filtrar(ModelMap mapa, @ModelAttribute EntidadFiltradoDTO dto){
		mapa.put("entidades", servicioEntidad.filtrar(dto));
		return "pages/filtrado";
	}
	
}
