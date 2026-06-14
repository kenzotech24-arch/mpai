package com.exam.clinica.repository;

import com.exam.clinica.model.Programare;
import com.exam.clinica.model.StatusProgramare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramareRepository extends JpaRepository<Programare, Long> {
    List<Programare> findByPacientEmail(String email);
    List<Programare> findByStatus(StatusProgramare status);
    List<Programare> findByMedicId(Long medicId);
}
