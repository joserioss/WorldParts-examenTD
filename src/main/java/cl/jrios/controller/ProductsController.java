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

import cl.jrios.model.Products;
import cl.jrios.service.impl.ProductsServiceImpl;

@Controller
@RequestMapping("/productos")
public class ProductsController {
	
	@Autowired
	private ProductsServiceImpl servicioProducts;
	
	@GetMapping()
	public String home(ModelMap mapa) {
		mapa.put("productos", servicioProducts.listar());
		return "pages/entidad";
	}
	
	@PostMapping
	public String registrar(ModelMap mapa, @Valid Products ent){
		servicioProducts.registrar(ent);
		mapa.put("productos", servicioProducts.listar());
		return "pages/entidad";
	}

	
//	REcordar que requestBody es necesario para cuando hacemos post con postman, no con submit.
	@PutMapping
	public String modificar(ModelMap mapa, @Valid @RequestBody Products ent){
		servicioProducts.modificar(ent);
		mapa.put("productos", servicioProducts.listar());
		return "pages/entidades";
	}
}
