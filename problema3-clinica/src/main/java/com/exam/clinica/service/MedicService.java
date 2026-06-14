package com.exam.clinica.service;

import com.exam.clinica.dto.MedicDTO;
import com.exam.clinica.model.Medic;
import com.exam.clinica.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicService {

    private final MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    public List<MedicDTO> getAll() {
        return medicRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Medic findById(Long id) {
        return medicRepository.findById(id).orElseThrow();
    }

    public void salveaza(Medic m) {
        medicRepository.save(m);
    }

    private MedicDTO toDTO(Medic m) {
        MedicDTO dto = new MedicDTO();
        dto.setId(m.getId());
        dto.setNume(m.getNume());
        dto.setSpecialitate(m.getSpecialitate());
        return dto;
    }
}
