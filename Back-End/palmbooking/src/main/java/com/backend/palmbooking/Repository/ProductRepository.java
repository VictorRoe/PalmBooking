package com.backend.palmbooking.Repository;

import com.backend.palmbooking.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.id , p.title , p.description, p.image, p.city_id, p.category_id, p.location_id, c.city_name FROM products p" +
            " INNER JOIN cities c ON p.city_id = c.id" +
            " WHERE p.city_id = :id_city", nativeQuery = true)
    List<Product> findProductByCityID(@Param("id_city")Long id);
}
