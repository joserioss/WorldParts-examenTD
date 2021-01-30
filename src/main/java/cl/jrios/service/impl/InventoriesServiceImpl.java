package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.Inventories;
import cl.jrios.repo.IInventoriesRepo;
import cl.jrios.service.IInventoriesService;

@Service
public class InventoriesServiceImpl implements IInventoriesService{

	@Autowired
	private IInventoriesRepo repo;

	@Override
	public Inventories registrar(Inventories obj) {
		return repo.save(obj);
	}

	@Override
	public Inventories modificar(Inventories obj) {
		return repo.save(obj);
	}

	@Override
	public List<Inventories> listar() {
		return repo.findAll();
	}

	@Override
	public Inventories leerPorId(Integer id) {
		Optional<Inventories> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Inventories();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
