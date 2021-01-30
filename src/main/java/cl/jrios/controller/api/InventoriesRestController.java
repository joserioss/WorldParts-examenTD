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
import cl.jrios.model.Inventories;
import cl.jrios.service.IInventoriesService;

@RestController
@RequestMapping("/api/inventorie")
public class InventoriesRestController {
	
	@Autowired
	private IInventoriesService service;
	
	@GetMapping
	public ResponseEntity<List<Inventories>> listar(){
		 List<Inventories> lista = service.listar();
		return new ResponseEntity<List<Inventories>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Inventories> listarPorId(@PathVariable("id") Integer id){
		Inventories obj = service.leerPorId(id);
		if(obj.getInventoriesId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Inventories>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Inventories paciente) {
		service.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getInventoriesId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Inventories> modificar(@Valid @RequestBody Inventories consulta) {
		Inventories obj = service.modificar(consulta);
		return new ResponseEntity<Inventories>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Inventories obj = service.leerPorId(id);
		if(obj.getInventoriesId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
