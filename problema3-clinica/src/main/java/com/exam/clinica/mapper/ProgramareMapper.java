package com.exam.clinica.mapper;

import com.exam.clinica.dto.ProgramareDTO;
import com.exam.clinica.model.Programare;
import org.springframework.stereotype.Component;

@Component
public class ProgramareMapper {
    public ProgramareDTO toDTO(Programare p) {
        ProgramareDTO dto = new ProgramareDTO();
        dto.setId(p.getId());
        dto.setPacientNume(p.getPacientNume());
        dto.setPacientEmail(p.getPacientEmail());
        dto.setMedicId(p.getMedic().getId());
        dto.setMedicNume(p.getMedic().getNume());
        dto.setMedicSpecialitate(p.getMedic().getSpecialitate());
        dto.setDataOra(p.getDataOra());
        dto.setMotiv(p.getMotiv());
        dto.setStatus(p.getStatus());
        return dto;
    }
}
