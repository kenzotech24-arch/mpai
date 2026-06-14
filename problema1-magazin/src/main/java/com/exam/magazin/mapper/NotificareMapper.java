package com.exam.magazin.mapper;

import com.exam.magazin.dto.NotificareDTO;
import com.exam.magazin.model.Notificare;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificareMapper {
    NotificareDTO toDTO(Notificare notificare);
}
