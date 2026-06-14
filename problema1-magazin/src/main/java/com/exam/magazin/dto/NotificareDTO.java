package com.exam.magazin.dto;

import java.time.LocalDateTime;

public class NotificareDTO {

    private Long id;
    private String clientEmail;
    private String mesaj;
    private LocalDateTime data;

    public NotificareDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
    public String getMesaj() { return mesaj; }
    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
