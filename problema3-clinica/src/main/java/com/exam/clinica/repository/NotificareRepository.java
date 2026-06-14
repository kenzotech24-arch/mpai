package com.exam.clinica.repository;

import com.exam.clinica.model.Notificare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificareRepository extends JpaRepository<Notificare, Long> {
    List<Notificare> findByPacientEmailOrderByDataDesc(String email);
}
