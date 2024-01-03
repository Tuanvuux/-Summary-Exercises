package mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mvc.entity.Products;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Products, Integer> {
    @Override
    Iterable<Products> findAll();

    List<Products> findByProductName(String productName);

    Optional<Products> findById(int id);
}