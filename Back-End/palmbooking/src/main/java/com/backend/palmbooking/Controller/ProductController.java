package com.backend.palmbooking.Controller;


import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Product> getProductByID(@PathVariable Long id) throws GlobalExcepction {
        Product product = productService.getProductByID(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping
    public ResponseEntity<Product> editProduct(@RequestBody Product product) throws GlobalExcepction {
        Product searchProduct = productService.getProductByID(product.getId());
        if (searchProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
          return ResponseEntity.status(HttpStatus.OK).body(productService.editProduct(product));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductByID(@PathVariable Long id) throws GlobalExcepction {
        Product searchProduct = productService.getProductByID(id);
        if (searchProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productService.deleteProductByID(id);
        return ResponseEntity.noContent().build();
    }
}
