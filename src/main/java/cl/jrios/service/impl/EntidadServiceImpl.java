package cl.jrios.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jrios.dto.EntidadFiltradoDTO;
import cl.jrios.model.Entidad;
import cl.jrios.repo.IEntidadRepo;
import cl.jrios.service.IEntidadService;

@Service
public class EntidadServiceImpl implements IEntidadService{

	@Autowired
	private IEntidadRepo repo;

	@Override
	public Entidad registrar(Entidad obj) {
		return repo.save(obj);
	}

	@Override
	public Entidad modificar(Entidad obj) {
		return repo.save(obj);
	}

	@Override
	public List<Entidad> listar() {
		return repo.findAll();
	}

	@Override
	public Entidad leerPorId(Integer id) {
		Optional<Entidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Entidad();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Entidad> filtrar(EntidadFiltradoDTO dto) {
		return repo.findAllByFechaBetween(dto.getFecha_desde(), dto.getFecha_hasta());
	}
}
