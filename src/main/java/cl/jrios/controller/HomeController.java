package cl.jrios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
//	@Autowired
//	private InventoriesServiceImpl servicioInventories;
	
	@GetMapping
	public String home() {
		return "home";
	}
	
//	@PostMapping("/filtrado")
//	public String filtrar(ModelMap mapa, @ModelAttribute EntidadFiltradoDTO dto){
//		mapa.put("inventarios", servicioInventories.filtrar(dto));
//		return "pages/filtrado";
//	}
	
}
