package com.exam.clinica.mapper;

import com.exam.clinica.dto.MedicDTO;
import com.exam.clinica.model.Medic;
import org.springframework.stereotype.Component;

@Component
public class MedicMapper {
    public MedicDTO toDTO(Medic m) {
        MedicDTO dto = new MedicDTO();
        dto.setId(m.getId());
        dto.setNume(m.getNume());
        dto.setSpecialitate(m.getSpecialitate());
        return dto;
    }
}
