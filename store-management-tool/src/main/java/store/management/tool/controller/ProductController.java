package store.management.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.management.tool.dto.ProductDTO;
import store.management.tool.service.ProductService;

import java.util.List;

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

    //Get all products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllUsers(){
        List<ProductDTO> users = productService.getAllProducts();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Find product by ID
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getUserById(@PathVariable("id") Long productId){
        ProductDTO user = productService.getProductById(productId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
}

