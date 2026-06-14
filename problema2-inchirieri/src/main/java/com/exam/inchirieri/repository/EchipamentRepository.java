package com.exam.inchirieri.repository;

import com.exam.inchirieri.model.Echipament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EchipamentRepository extends JpaRepository<Echipament, Long> {
    List<Echipament> findByDisponibil(boolean disponibil);
}
