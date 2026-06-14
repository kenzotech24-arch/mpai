package com.exam.inchirieri.mapper;

import com.exam.inchirieri.dto.EchipamentDTO;
import com.exam.inchirieri.model.Echipament;
import org.springframework.stereotype.Component;

@Component
public class EchipamentMapper {

    public EchipamentDTO toDTO(Echipament echipament) {
        EchipamentDTO dto = new EchipamentDTO();
        dto.setId(echipament.getId());
        dto.setNume(echipament.getNume());
        dto.setDescriere(echipament.getDescriere());
        dto.setDisponibil(echipament.isDisponibil());
        return dto;
    }
}
