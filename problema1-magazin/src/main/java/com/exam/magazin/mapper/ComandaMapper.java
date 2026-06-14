package com.exam.magazin.mapper;

import com.exam.magazin.dto.ComandaDTO;
import com.exam.magazin.model.Comanda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComandaMapper {
    ComandaDTO toDTO(Comanda comanda);
    Comanda toEntity(ComandaDTO dto);
}
