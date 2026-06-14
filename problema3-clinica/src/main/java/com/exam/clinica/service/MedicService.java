package com.exam.clinica.service;

import com.exam.clinica.dto.MedicDTO;
import com.exam.clinica.mapper.MedicMapper;
import com.exam.clinica.model.Medic;
import com.exam.clinica.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {

    private final MedicRepository medicRepository;
    private final MedicMapper medicMapper;

    public MedicService(MedicRepository medicRepository, MedicMapper medicMapper) {
        this.medicRepository = medicRepository;
        this.medicMapper = medicMapper;
    }

    public List<MedicDTO> getAll() {
        return medicRepository.findAll().stream().map(medicMapper::toDTO).toList();
    }

    public Medic findById(Long id) {
        return medicRepository.findById(id).orElseThrow();
    }

    public void salveaza(Medic m) {
        medicRepository.save(m);
    }
}
