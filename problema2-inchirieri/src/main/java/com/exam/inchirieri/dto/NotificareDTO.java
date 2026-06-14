package com.exam.inchirieri.dto;

import java.time.LocalDateTime;

public class NotificareDTO {

    private Long id;
    private String utilizatorEmail;
    private String mesaj;
    private LocalDateTime data;

    public NotificareDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUtilizatorEmail() { return utilizatorEmail; }
    public void setUtilizatorEmail(String utilizatorEmail) { this.utilizatorEmail = utilizatorEmail; }
    public String getMesaj() { return mesaj; }
    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
