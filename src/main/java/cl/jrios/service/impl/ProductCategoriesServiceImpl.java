package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.model.ProductCategories;
import cl.jrios.repo.IProductCategoriesRepo;
import cl.jrios.service.IProductCategoriesService;

@Service
public class ProductCategoriesServiceImpl implements IProductCategoriesService{

	@Autowired
	private IProductCategoriesRepo repo;

	@Override
	public ProductCategories registrar(ProductCategories obj) {
		return repo.save(obj);
	}

	@Override
	public ProductCategories modificar(ProductCategories obj) {
		return repo.save(obj);
	}

	@Override
	public List<ProductCategories> listar() {
		return repo.findAll();
	}

	@Override
	public ProductCategories leerPorId(Integer id) {
		Optional<ProductCategories> op = repo.findById(id);
		return op.isPresent() ? op.get() : new ProductCategories();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
