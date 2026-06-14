package com.exam.magazin.dto;

import com.exam.magazin.model.StatusComanda;
import java.time.LocalDate;

public class ComandaDTO {

    private Long id;
    private String clientNume;
    private String clientEmail;
    private String produse;
    private LocalDate dataComanda;
    private StatusComanda status;
    private Double total;

    public ComandaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClientNume() { return clientNume; }
    public void setClientNume(String clientNume) { this.clientNume = clientNume; }
    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
    public String getProduse() { return produse; }
    public void setProduse(String produse) { this.produse = produse; }
    public LocalDate getDataComanda() { return dataComanda; }
    public void setDataComanda(LocalDate dataComanda) { this.dataComanda = dataComanda; }
    public StatusComanda getStatus() { return status; }
    public void setStatus(StatusComanda status) { this.status = status; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
