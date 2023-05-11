package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Product;
import com.backend.palmbooking.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductByID(Long id) {
        return productRepository.findById(id);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product editProduct(Product product) {
        Optional<Product> editProduct = productRepository.findById(product.getId());

        if (editProduct.isPresent()) {
            return productRepository.save(product);
        } else {
            System.out.println("No se encontro el producto");
        }
        return product;
    }

    public void deleteProductByID(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        }
    }
}
