package com.exam.magazin.mapper;

import com.exam.magazin.dto.NotificareDTO;
import com.exam.magazin.model.Notificare;
import org.springframework.stereotype.Component;

@Component
public class NotificareMapper {

    public NotificareDTO toDTO(Notificare notificare) {
        NotificareDTO dto = new NotificareDTO();
        dto.setId(notificare.getId());
        dto.setClientEmail(notificare.getClientEmail());
        dto.setMesaj(notificare.getMesaj());
        dto.setData(notificare.getData());
        return dto;
    }
}
