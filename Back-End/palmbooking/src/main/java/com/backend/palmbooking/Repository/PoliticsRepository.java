package com.backend.palmbooking.Repository;

import com.backend.palmbooking.Model.Politics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliticsRepository extends JpaRepository<Politics,Long> {

    @Query(value = "SELECT p.id , pp.politics FROM policies pp" +
            " INNER JOIN products p ON pp.id = p.policy_id" +
            " WHERE p.id = :id_product",nativeQuery = true)
    List<Politics> findPoliticsByProductID(@Param("id_product")Long id);
}
