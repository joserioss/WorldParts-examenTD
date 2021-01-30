package cl.jrios.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Entidad;

public interface IEntidadRepo extends JpaRepository<Entidad, Integer>{

	List<Entidad> findAllByFechaBetween(String desde, String hasta);
}
