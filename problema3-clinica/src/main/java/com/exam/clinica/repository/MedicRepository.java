package com.exam.clinica.repository;

import com.exam.clinica.model.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicRepository extends JpaRepository<Medic, Long> {
    List<Medic> findBySpecialitate(String specialitate);
}
