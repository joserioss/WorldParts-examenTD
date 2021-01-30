package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.Products;
import cl.jrios.repo.IProductsRepo;
import cl.jrios.service.IProductsService;

@Service
public class ProductsServiceImpl implements IProductsService{

	@Autowired
	private IProductsRepo repo;

	@Override
	public Products registrar(Products obj) {
		return repo.save(obj);
	}

	@Override
	public Products modificar(Products obj) {
		return repo.save(obj);
	}

	@Override
	public List<Products> listar() {
		return repo.findAll();
	}

	@Override
	public Products leerPorId(Integer id) {
		Optional<Products> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Products();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
