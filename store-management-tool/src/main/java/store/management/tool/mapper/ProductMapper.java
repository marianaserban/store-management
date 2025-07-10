package store.management.tool.mapper;


import store.management.tool.dto.ProductDTO;
import store.management.tool.entity.Product;

public class ProductMapper {

    public static ProductDTO mapToProductDTO(Product product){
        ProductDTO productDTO=new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
        return productDTO;
    }

    public static Product mapToProduct(ProductDTO productDTO){
        Product product=new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getDescription(),
                productDTO.getPrice(),
                productDTO.getQuantity()
        );
        return product;
    }
}
