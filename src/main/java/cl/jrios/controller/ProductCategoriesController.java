package cl.jrios.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.jrios.model.ProductCategories;
import cl.jrios.service.impl.ProductCategoriesServiceImpl;

@Controller
@RequestMapping("/catProductos")
public class ProductCategoriesController {
	
	@Autowired
	private ProductCategoriesServiceImpl servicioProductCategories;
	
	@GetMapping()
	public String home(ModelMap mapa) {
		mapa.put("catProductos", servicioProductCategories.listar());
		return "pages/entidad";
	}
	
	@PostMapping
	public String registrar(ModelMap mapa, @Valid ProductCategories ent){
		servicioProductCategories.registrar(ent);
		mapa.put("catProductos", servicioProductCategories.listar());
		return "pages/entidad";
	}

	
//	REcordar que requestBody es necesario para cuando hacemos post con postman, no con submit.
	@PutMapping
	public String modificar(ModelMap mapa, @Valid @RequestBody ProductCategories ent){
		servicioProductCategories.modificar(ent);
		mapa.put("catProductos", servicioProductCategories.listar());
		return "pages/entidades";
	}
}
