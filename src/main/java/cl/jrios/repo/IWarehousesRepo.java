package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Warehouses;

public interface IWarehousesRepo extends JpaRepository<Warehouses, Integer>{
}
