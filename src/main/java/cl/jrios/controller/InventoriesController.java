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

import cl.jrios.model.Inventories;
import cl.jrios.service.impl.InventoriesServiceImpl;
import cl.jrios.service.impl.ProductCategoriesServiceImpl;
import cl.jrios.service.impl.ProductsServiceImpl;
import cl.jrios.service.impl.WarehousesServiceImpl;

@Controller
@RequestMapping("/inventario")
public class InventoriesController {
	
	@Autowired
	private InventoriesServiceImpl servicioInventories;
	
	@Autowired
	private WarehousesServiceImpl servicioWarehouses;
	
	@Autowired
	private ProductCategoriesServiceImpl servicioCategories;
	

	@Autowired
	private ProductsServiceImpl servicioProducts;
	
	@GetMapping()
	public String home(ModelMap mapa) {
		mapa.put("inventarios", servicioInventories.listar());
		mapa.put("categorias", servicioCategories.listar());
		mapa.put("almacenes", servicioWarehouses.listar());
		mapa.put("productos", servicioProducts.listar());
		return "pages/inventario";
	}
	
	@PostMapping
	public String registrar(ModelMap mapa, @Valid Inventories ent){
		servicioInventories.registrar(ent);
		mapa.put("inventarios", servicioInventories.listar());
		return "pages/inventario";
	}

	
//	REcordar que requestBody es necesario para cuando hacemos post con postman, no con submit.
	@PutMapping
	public String modificar(ModelMap mapa, @Valid @RequestBody Inventories ent){
		servicioInventories.modificar(ent);
		mapa.put("inventarios", servicioInventories.listar());
		return "pages/inventarios";
	}
}
