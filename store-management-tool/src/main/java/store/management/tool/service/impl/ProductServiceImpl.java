package store.management.tool.service.impl;

import org.springframework.stereotype.Service;
import store.management.tool.dto.ProductDTO;
import store.management.tool.entity.Product;
import store.management.tool.mapper.ProductMapper;
import store.management.tool.repository.ProductRepository;
import store.management.tool.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = ProductMapper.mapToProduct(productDTO);

        Product savedProduct=productRepository.save(product);

        ProductDTO savedProductDTO=ProductMapper.mapToProductDTO(savedProduct);

        return savedProductDTO;
    }
}
