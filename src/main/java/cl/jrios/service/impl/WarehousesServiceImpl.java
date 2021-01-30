package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.Warehouses;
import cl.jrios.repo.IWarehousesRepo;
import cl.jrios.service.IWarehousesService;

@Service
public class WarehousesServiceImpl implements IWarehousesService{

	@Autowired
	private IWarehousesRepo repo;

	@Override
	public Warehouses registrar(Warehouses obj) {
		return repo.save(obj);
	}

	@Override
	public Warehouses modificar(Warehouses obj) {
		return repo.save(obj);
	}

	@Override
	public List<Warehouses> listar() {
		return repo.findAll();
	}

	@Override
	public Warehouses leerPorId(Integer id) {
		Optional<Warehouses> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Warehouses();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
