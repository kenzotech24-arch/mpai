package com.exam.inchirieri.service;

import com.exam.inchirieri.dto.EchipamentDTO;
import com.exam.inchirieri.model.Echipament;
import com.exam.inchirieri.repository.EchipamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EchipamentService {

    private final EchipamentRepository echipamentRepository;

    public EchipamentService(EchipamentRepository echipamentRepository) {
        this.echipamentRepository = echipamentRepository;
    }

    public List<EchipamentDTO> getAll() {
        return echipamentRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<EchipamentDTO> getDisponibile() {
        return echipamentRepository.findByDisponibil(true).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public void salveaza(EchipamentDTO dto) {
        Echipament e = new Echipament(dto.getNume(), dto.getDescriere(), dto.isDisponibil());
        echipamentRepository.save(e);
    }

    public void salveazaModel(Echipament e) {
        echipamentRepository.save(e);
    }

    public Echipament findById(Long id) {
        return echipamentRepository.findById(id).orElseThrow();
    }

    private EchipamentDTO toDTO(Echipament e) {
        EchipamentDTO dto = new EchipamentDTO();
        dto.setId(e.getId());
        dto.setNume(e.getNume());
        dto.setDescriere(e.getDescriere());
        dto.setDisponibil(e.isDisponibil());
        return dto;
    }
}
