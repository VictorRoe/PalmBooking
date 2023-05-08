package com.backend.palmbooking.Repository;

import com.backend.palmbooking.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
