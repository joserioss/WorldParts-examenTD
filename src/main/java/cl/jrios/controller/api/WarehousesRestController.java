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
import cl.jrios.model.Warehouses;
import cl.jrios.service.IWarehousesService;

@RestController
@RequestMapping("/api/warehouse")
public class WarehousesRestController {
	
	@Autowired
	private IWarehousesService service;
	
	@GetMapping
	public ResponseEntity<List<Warehouses>> listar(){
		 List<Warehouses> lista = service.listar();
		return new ResponseEntity<List<Warehouses>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Warehouses> listarPorId(@PathVariable("id") Integer id){
		Warehouses obj = service.leerPorId(id);
		if(obj.getWarehouseId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Warehouses>(obj, HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Warehouses paciente) {
		service.registrar(paciente);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getWarehouseId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Warehouses> modificar(@Valid @RequestBody Warehouses consulta) {
		Warehouses obj = service.modificar(consulta);
		return new ResponseEntity<Warehouses>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Warehouses obj = service.leerPorId(id);
		if(obj.getWarehouseId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
