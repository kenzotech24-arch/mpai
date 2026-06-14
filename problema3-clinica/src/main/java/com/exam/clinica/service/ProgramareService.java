package com.exam.clinica.service;

import com.exam.clinica.dto.NotificareDTO;
import com.exam.clinica.dto.ProgramareDTO;
import com.exam.clinica.mapper.NotificareMapper;
import com.exam.clinica.mapper.ProgramareMapper;
import com.exam.clinica.model.Medic;
import com.exam.clinica.model.Notificare;
import com.exam.clinica.model.Programare;
import com.exam.clinica.model.StatusProgramare;
import com.exam.clinica.repository.NotificareRepository;
import com.exam.clinica.repository.ProgramareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramareService {

    private final ProgramareRepository programareRepository;
    private final NotificareRepository notificareRepository;
    private final MedicService medicService;
    private final ProgramareMapper programareMapper;
    private final NotificareMapper notificareMapper;

    public ProgramareService(ProgramareRepository programareRepository,
                             NotificareRepository notificareRepository,
                             MedicService medicService,
                             ProgramareMapper programareMapper,
                             NotificareMapper notificareMapper) {
        this.programareRepository = programareRepository;
        this.notificareRepository = notificareRepository;
        this.medicService = medicService;
        this.programareMapper = programareMapper;
        this.notificareMapper = notificareMapper;
    }

    public List<ProgramareDTO> getAll() {
        return programareRepository.findAll().stream().map(programareMapper::toDTO).toList();
    }

    public List<ProgramareDTO> getByEmail(String email) {
        return programareRepository.findByPacientEmail(email).stream().map(programareMapper::toDTO).toList();
    }

    public List<ProgramareDTO> filter(String email, String status, String medicNume) {
        return programareRepository.findAll().stream()
                .filter(p -> email == null || email.isBlank() || p.getPacientEmail().equalsIgnoreCase(email))
                .filter(p -> status == null || status.isBlank() || p.getStatus().name().equalsIgnoreCase(status))
                .filter(p -> medicNume == null || medicNume.isBlank() || p.getMedic().getNume().toLowerCase().contains(medicNume.toLowerCase()))
                .map(programareMapper::toDTO)
                .toList();
    }

    public void adauga(ProgramareDTO dto) {
        Medic m = medicService.findById(dto.getMedicId());
        Programare p = new Programare(dto.getPacientNume(), dto.getPacientEmail(), m, dto.getDataOra(), dto.getMotiv(), StatusProgramare.SOLICITATA);
        programareRepository.save(p);
    }

    public void anuleaza(Long id) {
        Programare p = programareRepository.findById(id).orElseThrow();
        if (p.getStatus() == StatusProgramare.SOLICITATA || p.getStatus() == StatusProgramare.CONFIRMATA) {
            p.setStatus(StatusProgramare.ANULATA);
            programareRepository.save(p);
            notificareRepository.save(new Notificare(p.getPacientEmail(), "Programarea #" + id + " a fost anulata."));
        }
    }

    public void schimbaStatus(Long id, StatusProgramare status) {
        Programare p = programareRepository.findById(id).orElseThrow();
        p.setStatus(status);
        programareRepository.save(p);
        notificareRepository.save(new Notificare(p.getPacientEmail(), "Programarea #" + id + " are acum statusul: " + status));
    }

    public List<NotificareDTO> getNotificari(String email) {
        return notificareRepository.findByPacientEmailOrderByDataDesc(email).stream().map(notificareMapper::toDTO).toList();
    }

    public void salveaza(Programare p) {
        programareRepository.save(p);
    }
}
