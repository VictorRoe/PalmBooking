package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.ProductNotFoundExcepction;
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

    public Product getProductByID(Long id) throws ProductNotFoundExcepction {
        Optional<Product> searchProduct = productRepository.findById(id);
        if (searchProduct.isPresent()){
            return searchProduct.get();
        } else {
                throw new ProductNotFoundExcepction("ID NOT FOUND");
        }
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product editProduct(Product product) throws ProductNotFoundExcepction {
        Optional<Product> editProduct = productRepository.findById(product.getId());
         if (editProduct.isPresent()) {
            return productRepository.save(product);
        } else {
            throw new ProductNotFoundExcepction("ID NOT FOUND");
        }

    }

    public void deleteProductByID(Long id) throws ProductNotFoundExcepction {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundExcepction("ID NOT FOUND");
        }
    }
}
