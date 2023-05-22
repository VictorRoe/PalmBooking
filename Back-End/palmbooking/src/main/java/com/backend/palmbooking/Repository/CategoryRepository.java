package com.backend.palmbooking.Repository;

import com.backend.palmbooking.Model.Category;
import com.backend.palmbooking.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     Query SQL if select one category id,
     will return all the products of that category
     **/
    @Query(
            value = "SELECT p.id,p.description,p.image,p.title FROM categories c" +
                    " INNER JOIN products p ON c.id = p.category_id" +
                    " WHERE category_id = :id_category", nativeQuery = true
    )
    List<Category> findProductByCategoryID(@Param("id_category") Long id);
}
