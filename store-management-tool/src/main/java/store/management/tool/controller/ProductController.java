package store.management.tool.controller;

import jakarta.validation.Valid;
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
    public ResponseEntity<ProductDTO>saveProduct(@Valid @RequestBody ProductDTO productDTO){
        ProductDTO savedProduct = productService.saveProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    //Get all products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //Find product by ID
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long productId){
        ProductDTO productDTO = productService.getProductById(productId);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    //Update product
    @PutMapping("{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") Long productId,
                                                 @Valid @RequestBody ProductDTO productDTO){
        productDTO.setId(productId);
        ProductDTO updatedProduct = productService.updateProduct(productDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    //Delete product
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }
}

