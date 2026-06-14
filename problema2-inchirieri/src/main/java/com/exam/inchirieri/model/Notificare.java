package com.exam.inchirieri.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificari")
public class Notificare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String utilizatorEmail;
    private String mesaj;
    private LocalDateTime data;

    public Notificare() {}

    public Notificare(String utilizatorEmail, String mesaj) {
        this.utilizatorEmail = utilizatorEmail;
        this.mesaj = mesaj;
        this.data = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUtilizatorEmail() { return utilizatorEmail; }
    public void setUtilizatorEmail(String utilizatorEmail) { this.utilizatorEmail = utilizatorEmail; }
    public String getMesaj() { return mesaj; }
    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
