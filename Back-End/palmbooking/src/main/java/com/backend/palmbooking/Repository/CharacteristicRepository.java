package com.backend.palmbooking.Repository;

import com.backend.palmbooking.Model.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic,Long> {
}
