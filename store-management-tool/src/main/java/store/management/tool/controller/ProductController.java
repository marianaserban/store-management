package store.management.tool.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.management.tool.dto.ProductDTO;
import store.management.tool.service.ProductService;

@RestController
@RequestMapping("api/products/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Save product REST API
    @PostMapping
    public ResponseEntity<ProductDTO>saveProduct(@RequestBody ProductDTO productDTO){
        ProductDTO savedProduct = productService.saveProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}

