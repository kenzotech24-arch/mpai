package com.exam.inchirieri.repository;

import com.exam.inchirieri.model.Notificare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificareRepository extends JpaRepository<Notificare, Long> {
    List<Notificare> findByUtilizatorEmailOrderByDataDesc(String email);
}
