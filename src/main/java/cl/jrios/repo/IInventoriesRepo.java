package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Inventories;

public interface IInventoriesRepo extends JpaRepository<Inventories, Integer>{
}
