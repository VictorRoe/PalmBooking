package com.backend.palmbooking.Repository;

import com.backend.palmbooking.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(
            value = "SELECT i.id, i.image_url, i.product_image_id FROM products p" +
                    " INNER JOIN images i ON p.id = i.product_image_id" +
                    " WHERE i.product_image_id = :idListImages", nativeQuery = true
    )
    List<Image> findImagesByProductID(@Param("idListImages") Long id);
}
