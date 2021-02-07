package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.dto.EntidadFiltradoDTO;
import cl.jrios.model.Inventories;
import cl.jrios.model.ProductCategories;
import cl.jrios.model.Products;
import cl.jrios.model.Warehouses;
import cl.jrios.repo.IInventoriesRepo;
import cl.jrios.repo.IProductCategoriesRepo;
import cl.jrios.repo.IProductsRepo;
import cl.jrios.repo.IWarehousesRepo;
import cl.jrios.service.IInventoriesService;

@Service
public class InventoriesServiceImpl implements IInventoriesService{

	@Autowired
	private IInventoriesRepo repoI;
	
	@Autowired
	private IWarehousesRepo repoW;
	
	@Autowired
	private IProductCategoriesRepo repoPc;
	
	@Autowired
	private IProductsRepo repoP;

	@Override
	public Inventories registrar(Inventories obj) {
		return repoI.save(obj);
	}

	@Override
	public Inventories modificar(Inventories obj) {
		return repoI.save(obj);
	}

	@Override
	public List<Inventories> listar() {
		return repoI.findAll();
	}

	@Override
	public Inventories leerPorId(Integer id) {
		Optional<Inventories> op = repoI.findById(id);
		return op.isPresent() ? op.get() : new Inventories();
	}

	@Override
	public boolean eliminar(Integer id) {
		repoI.deleteById(id);
		return true;
	}

//	@Override
//	public List<Inventories> filtrar(EntidadFiltradoDTO dto) {
//		Warehouses w = repoW.findById(dto.getWarehouseId()).orElse(null);
//		ProductCategories pc = repoPc.findById(dto.getProductCategoriesId()).orElse(null);
//
//		return repoI.findAllWarehousesAndProducts(w, pc);
//	}

}
