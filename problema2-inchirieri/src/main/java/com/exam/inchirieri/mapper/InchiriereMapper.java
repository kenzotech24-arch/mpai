package com.exam.inchirieri.mapper;

import com.exam.inchirieri.dto.InchiriereDTO;
import com.exam.inchirieri.model.Inchiriere;
import org.springframework.stereotype.Component;

@Component
public class InchiriereMapper {

    public InchiriereDTO toDTO(Inchiriere inchiriere) {
        InchiriereDTO dto = new InchiriereDTO();
        dto.setId(inchiriere.getId());
        dto.setUtilizatorNume(inchiriere.getUtilizatorNume());
        dto.setUtilizatorEmail(inchiriere.getUtilizatorEmail());
        dto.setEchipamentId(inchiriere.getEchipament().getId());
        dto.setEchipamentNume(inchiriere.getEchipament().getNume());
        dto.setDataStart(inchiriere.getDataStart());
        dto.setDataFinal(inchiriere.getDataFinal());
        dto.setScop(inchiriere.getScop());
        dto.setStatus(inchiriere.getStatus());
        return dto;
    }
}
