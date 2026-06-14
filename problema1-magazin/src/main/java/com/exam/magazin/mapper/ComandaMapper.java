package com.exam.magazin.mapper;

import com.exam.magazin.dto.ComandaDTO;
import com.exam.magazin.model.Comanda;
import org.springframework.stereotype.Component;

@Component
public class ComandaMapper {

    public ComandaDTO toDTO(Comanda comanda) {
        ComandaDTO dto = new ComandaDTO();
        dto.setId(comanda.getId());
        dto.setClientNume(comanda.getClientNume());
        dto.setClientEmail(comanda.getClientEmail());
        dto.setProduse(comanda.getProduse());
        dto.setDataComanda(comanda.getDataComanda());
        dto.setStatus(comanda.getStatus());
        dto.setTotal(comanda.getTotal());
        return dto;
    }

}
