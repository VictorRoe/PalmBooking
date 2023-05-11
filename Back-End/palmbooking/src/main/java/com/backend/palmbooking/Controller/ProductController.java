package com.backend.palmbooking.Controller;


import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getProduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductByID(@PathVariable Long id){
        return productService.getProductByID(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping
    public ResponseEntity<Void> editProduct(@RequestBody Product product) {
        Optional<Product> searchProduct = productService.getProductByID(product.getId());

        if (searchProduct.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        productService.editProduct(product);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductByID(@PathVariable Long id) {
        Optional<Product> searchProduct = productService.getProductByID(id);

        if (searchProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productService.deleteProductByID(id);
        return ResponseEntity.status(204).build();
    }
}
