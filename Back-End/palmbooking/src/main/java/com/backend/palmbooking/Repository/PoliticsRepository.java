package com.backend.palmbooking.Repository;

import com.backend.palmbooking.Model.Politics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticsRepository extends JpaRepository<Politics,Long> {
}
