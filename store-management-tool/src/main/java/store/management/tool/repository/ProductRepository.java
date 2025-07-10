package store.management.tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.management.tool.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}