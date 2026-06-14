package com.exam.magazin.service;

import com.exam.magazin.dto.ComandaDTO;
import com.exam.magazin.dto.NotificareDTO;
import com.exam.magazin.mapper.ComandaMapper;
import com.exam.magazin.mapper.NotificareMapper;
import com.exam.magazin.model.Comanda;
import com.exam.magazin.model.Notificare;
import com.exam.magazin.model.StatusComanda;
import com.exam.magazin.repository.ComandaRepository;
import com.exam.magazin.repository.NotificareRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final NotificareRepository notificareRepository;
    private final ComandaMapper comandaMapper;
    private final NotificareMapper notificareMapper;

    public ComandaService(ComandaRepository comandaRepository, NotificareRepository notificareRepository,
                          ComandaMapper comandaMapper, NotificareMapper notificareMapper) {
        this.comandaRepository = comandaRepository;
        this.notificareRepository = notificareRepository;
        this.comandaMapper = comandaMapper;
        this.notificareMapper = notificareMapper;
    }

    public List<ComandaDTO> getAll() {
        return comandaRepository.findAll().stream().map(comandaMapper::toDTO).collect(Collectors.toList());
    }

    public List<ComandaDTO> getByEmail(String email) {
        return comandaRepository.findByClientEmail(email).stream().map(comandaMapper::toDTO).collect(Collectors.toList());
    }

    public List<ComandaDTO> filter(String email, String status) {
        return comandaRepository.findAll().stream()
                .filter(c -> email == null || email.isBlank() || c.getClientEmail().equalsIgnoreCase(email))
                .filter(c -> status == null || status.isBlank() || c.getStatus().name().equalsIgnoreCase(status))
                .map(comandaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void adauga(ComandaDTO dto) {
        Comanda c = new Comanda(dto.getClientNume(), dto.getClientEmail(), dto.getProduse(), LocalDate.now(), StatusComanda.PLASATA, dto.getTotal());
        comandaRepository.save(c);
    }

    public void anuleaza(Long id) {
        Comanda c = comandaRepository.findById(id).orElseThrow();
        if (c.getStatus() == StatusComanda.PLASATA) {
            c.setStatus(StatusComanda.ANULATA);
            comandaRepository.save(c);
        }
    }

    public void schimbaStatus(Long id, StatusComanda status) {
        Comanda c = comandaRepository.findById(id).orElseThrow();
        c.setStatus(status);
        comandaRepository.save(c);
        notificareRepository.save(new Notificare(c.getClientEmail(), "Comanda #" + id + " are acum statusul: " + status));
    }

    public List<NotificareDTO> getNotificari(String email) {
        return notificareRepository.findByClientEmailOrderByDataDesc(email).stream()
                .map(notificareMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void salveazaComanda(Comanda c) {
        comandaRepository.save(c);
    }
}
