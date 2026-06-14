package com.exam.inchirieri.repository;

import com.exam.inchirieri.model.Inchiriere;
import com.exam.inchirieri.model.StatusInchiriere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InchiriereRepository extends JpaRepository<Inchiriere, Long> {
    List<Inchiriere> findByUtilizatorEmail(String email);
    List<Inchiriere> findByStatus(StatusInchiriere status);
}
