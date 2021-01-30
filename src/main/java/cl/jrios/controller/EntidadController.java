package cl.jrios.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.dto.EntidadFiltradoDTO;
import cl.jrios.model.Entidad;
import cl.jrios.service.impl.EntidadServiceImpl;

@Controller
@RequestMapping("/entidades")
public class EntidadController {
	
	@Autowired
	private EntidadServiceImpl servicioEntidad;
	
	@GetMapping()
	public String home(ModelMap mapa) {
		mapa.put("entidades", servicioEntidad.listar());
		return "pages/entidad";
	}
	
	@PostMapping
	public String registrar(ModelMap mapa, @Valid Entidad ent){
		servicioEntidad.registrar(ent);
		mapa.put("entidades", servicioEntidad.listar());
		return "pages/entidad";
	}

	
//	REcordar que requestBody es necesario para cuando hacemos post con postman, no con submit.
	@PutMapping
	public String modificar(ModelMap mapa, @Valid @RequestBody Entidad ent){
		servicioEntidad.modificar(ent);
		mapa.put("entidades", servicioEntidad.listar());
		return "pages/entidades";
	}
}
