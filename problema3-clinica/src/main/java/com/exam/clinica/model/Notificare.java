package com.exam.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificari")
public class Notificare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pacientEmail;
    private String mesaj;
    private LocalDateTime data;

    public Notificare() {}

    public Notificare(String pacientEmail, String mesaj) {
        this.pacientEmail = pacientEmail;
        this.mesaj = mesaj;
        this.data = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPacientEmail() { return pacientEmail; }
    public void setPacientEmail(String pacientEmail) { this.pacientEmail = pacientEmail; }
    public String getMesaj() { return mesaj; }
    public void setMesaj(String mesaj) { this.mesaj = mesaj; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
