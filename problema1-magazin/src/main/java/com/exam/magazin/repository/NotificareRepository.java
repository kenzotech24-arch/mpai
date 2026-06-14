package com.exam.magazin.repository;

import com.exam.magazin.model.Notificare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificareRepository extends JpaRepository<Notificare, Long> {
    List<Notificare> findByClientEmailOrderByDataDesc(String clientEmail);
}
