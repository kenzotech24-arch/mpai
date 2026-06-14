package com.exam.clinica.mapper;

import com.exam.clinica.dto.NotificareDTO;
import com.exam.clinica.model.Notificare;
import org.springframework.stereotype.Component;

@Component
public class NotificareMapper {
    public NotificareDTO toDTO(Notificare n) {
        NotificareDTO dto = new NotificareDTO();
        dto.setId(n.getId());
        dto.setPacientEmail(n.getPacientEmail());
        dto.setMesaj(n.getMesaj());
        dto.setData(n.getData());
        return dto;
    }
}
