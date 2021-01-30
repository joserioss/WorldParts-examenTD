package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.Products;

public interface IProductsRepo extends JpaRepository<Products, Integer>{
}
