package com.exam.magazin.repository;

import com.exam.magazin.model.Comanda;
import com.exam.magazin.model.StatusComanda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    List<Comanda> findByClientEmail(String clientEmail);
    List<Comanda> findByStatus(StatusComanda status);
}
