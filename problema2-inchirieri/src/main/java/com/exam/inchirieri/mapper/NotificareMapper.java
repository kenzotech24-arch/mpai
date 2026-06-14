package com.exam.inchirieri.mapper;

import com.exam.inchirieri.dto.NotificareDTO;
import com.exam.inchirieri.model.Notificare;
import org.springframework.stereotype.Component;

@Component
public class NotificareMapper {

    public NotificareDTO toDTO(Notificare notificare) {
        NotificareDTO dto = new NotificareDTO();
        dto.setId(notificare.getId());
        dto.setUtilizatorEmail(notificare.getUtilizatorEmail());
        dto.setMesaj(notificare.getMesaj());
        dto.setData(notificare.getData());
        return dto;
    }
}
