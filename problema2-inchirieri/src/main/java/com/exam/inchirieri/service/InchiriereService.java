package com.exam.inchirieri.service;

import com.exam.inchirieri.dto.InchiriereDTO;
import com.exam.inchirieri.dto.NotificareDTO;
import com.exam.inchirieri.model.Echipament;
import com.exam.inchirieri.model.Inchiriere;
import com.exam.inchirieri.model.Notificare;
import com.exam.inchirieri.model.StatusInchiriere;
import com.exam.inchirieri.repository.InchiriereRepository;
import com.exam.inchirieri.repository.NotificareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InchiriereService {

    private final InchiriereRepository inchiriereRepository;
    private final NotificareRepository notificareRepository;
    private final EchipamentService echipamentService;

    public InchiriereService(InchiriereRepository inchiriereRepository,
                             NotificareRepository notificareRepository,
                             EchipamentService echipamentService) {
        this.inchiriereRepository = inchiriereRepository;
        this.notificareRepository = notificareRepository;
        this.echipamentService = echipamentService;
    }

    public List<InchiriereDTO> getAll() {
        return inchiriereRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<InchiriereDTO> getByEmail(String email) {
        return inchiriereRepository.findByUtilizatorEmail(email).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<InchiriereDTO> filter(String email, String status, String echipamentNume) {
        return inchiriereRepository.findAll().stream()
                .filter(i -> email == null || email.isBlank() || i.getUtilizatorEmail().equalsIgnoreCase(email))
                .filter(i -> status == null || status.isBlank() || i.getStatus().name().equalsIgnoreCase(status))
                .filter(i -> echipamentNume == null || echipamentNume.isBlank() || i.getEchipament().getNume().toLowerCase().contains(echipamentNume.toLowerCase()))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void adaugaCerere(InchiriereDTO dto) {
        Echipament e = echipamentService.findById(dto.getEchipamentId());
        Inchiriere i = new Inchiriere(dto.getUtilizatorNume(), dto.getUtilizatorEmail(), e,
                dto.getDataStart(), dto.getDataFinal(), dto.getScop(), StatusInchiriere.CERUUTA);
        inchiriereRepository.save(i);
    }

    public void anuleaza(Long id) {
        Inchiriere i = inchiriereRepository.findById(id).orElseThrow();
        if (i.getStatus() == StatusInchiriere.CERUUTA) {
            i.setStatus(StatusInchiriere.RESPINSA);
            inchiriereRepository.save(i);
        }
    }

    public void schimbaStatus(Long id, StatusInchiriere status) {
        Inchiriere i = inchiriereRepository.findById(id).orElseThrow();
        i.setStatus(status);
        inchiriereRepository.save(i);
        notificareRepository.save(new Notificare(i.getUtilizatorEmail(),
                "Cererea de inchiriere #" + id + " are acum statusul: " + status));
    }

    public List<NotificareDTO> getNotificari(String email) {
        return notificareRepository.findByUtilizatorEmailOrderByDataDesc(email).stream().map(n -> {
            NotificareDTO dto = new NotificareDTO();
            dto.setId(n.getId());
            dto.setUtilizatorEmail(n.getUtilizatorEmail());
            dto.setMesaj(n.getMesaj());
            dto.setData(n.getData());
            return dto;
        }).collect(Collectors.toList());
    }

    public void salveaza(Inchiriere i) {
        inchiriereRepository.save(i);
    }

    private InchiriereDTO toDTO(Inchiriere i) {
        InchiriereDTO dto = new InchiriereDTO();
        dto.setId(i.getId());
        dto.setUtilizatorNume(i.getUtilizatorNume());
        dto.setUtilizatorEmail(i.getUtilizatorEmail());
        dto.setEchipamentId(i.getEchipament().getId());
        dto.setEchipamentNume(i.getEchipament().getNume());
        dto.setDataStart(i.getDataStart());
        dto.setDataFinal(i.getDataFinal());
        dto.setScop(i.getScop());
        dto.setStatus(i.getStatus());
        return dto;
    }
}
