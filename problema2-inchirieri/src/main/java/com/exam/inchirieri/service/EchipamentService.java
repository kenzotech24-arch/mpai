package com.exam.inchirieri.service;

import com.exam.inchirieri.dto.EchipamentDTO;
import com.exam.inchirieri.mapper.EchipamentMapper;
import com.exam.inchirieri.model.Echipament;
import com.exam.inchirieri.repository.EchipamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchipamentService {

    private final EchipamentRepository echipamentRepository;
    private final EchipamentMapper echipamentMapper;

    public EchipamentService(EchipamentRepository echipamentRepository, EchipamentMapper echipamentMapper) {
        this.echipamentRepository = echipamentRepository;
        this.echipamentMapper = echipamentMapper;
    }

    public List<EchipamentDTO> getAll() {
        return echipamentRepository.findAll().stream().map(echipamentMapper::toDTO).toList();
    }

    public List<EchipamentDTO> getDisponibile() {
        return echipamentRepository.findByDisponibil(true).stream().map(echipamentMapper::toDTO).toList();
    }

    public void salveaza(EchipamentDTO dto) {
        echipamentRepository.save(new Echipament(dto.getNume(), dto.getDescriere(), dto.isDisponibil()));
    }

    public void salveazaModel(Echipament e) {
        echipamentRepository.save(e);
    }

    public Echipament findById(Long id) {
        return echipamentRepository.findById(id).orElseThrow();
    }
}
