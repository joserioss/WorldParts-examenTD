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
import cl.jrios.model.Products;
import cl.jrios.service.IProductsService;

@RestController
@RequestMapping("/api/product")
public class ProductsRestController {
	
	@Autowired
	private IProductsService service;
	
	@GetMapping
	public ResponseEntity<List<Products>> listar(){
		 List<Products> lista = service.listar();
		return new ResponseEntity<List<Products>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> listarPorId(@PathVariable("id") Integer id){
		Products obj = service.leerPorId(id);
		if(obj.getProductId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Products>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Products paciente) {
		service.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getProductId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Products> modificar(@Valid @RequestBody Products consulta) {
		Products obj = service.modificar(consulta);
		return new ResponseEntity<Products>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Products obj = service.leerPorId(id);
		if(obj.getProductId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
