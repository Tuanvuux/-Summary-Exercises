package mvc.service;

import mvc.entity.Products;
import mvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Products getProductById(int productId) {
        Optional<Products> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }
}