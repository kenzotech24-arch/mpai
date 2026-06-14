package com.exam.magazin.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comenzi")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientNume;
    private String clientEmail;
    private String produse;
    private LocalDate dataComanda;

    @Enumerated(EnumType.STRING)
    private StatusComanda status;

    private Double total;

    public Comanda() {}

    public Comanda(String clientNume, String clientEmail, String produse, LocalDate dataComanda, StatusComanda status, Double total) {
        this.clientNume = clientNume;
        this.clientEmail = clientEmail;
        this.produse = produse;
        this.dataComanda = dataComanda;
        this.status = status;
        this.total = total;
    }

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
