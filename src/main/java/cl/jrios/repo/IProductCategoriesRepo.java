package cl.jrios.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.jrios.model.ProductCategories;

public interface IProductCategoriesRepo extends JpaRepository<ProductCategories, Integer>{
}
