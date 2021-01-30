package cl.jrios.controller.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.jrios.exception.ModelNotFoundException;
import cl.jrios.model.ProductCategories;
import cl.jrios.service.IProductCategoriesService;

@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoriesRestController {
	
	@Autowired
	private IProductCategoriesService service;
	
	@GetMapping
	public ResponseEntity<List<ProductCategories>> listar(){
		 List<ProductCategories> lista = service.listar();
		return new ResponseEntity<List<ProductCategories>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductCategories> listarPorId(@PathVariable("id") Integer id){
		ProductCategories obj = service.leerPorId(id);
		if(obj.getCategoryId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<ProductCategories>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody ProductCategories paciente) {
		service.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getCategoryId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<ProductCategories> modificar(@Valid @RequestBody ProductCategories consulta) {
		ProductCategories obj = service.modificar(consulta);
		return new ResponseEntity<ProductCategories>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		ProductCategories obj = service.leerPorId(id);
		if(obj.getCategoryId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
