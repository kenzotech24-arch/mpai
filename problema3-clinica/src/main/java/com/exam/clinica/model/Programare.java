package com.exam.clinica.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "programari")
public class Programare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pacientNume;
    private String pacientEmail;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medic;

    private LocalDateTime dataOra;
    private String motiv;

    @Enumerated(EnumType.STRING)
    private StatusProgramare status;

    public Programare() {}

    public Programare(String pacientNume, String pacientEmail, Medic medic, LocalDateTime dataOra, String motiv, StatusProgramare status) {
        this.pacientNume = pacientNume;
        this.pacientEmail = pacientEmail;
        this.medic = medic;
        this.dataOra = dataOra;
        this.motiv = motiv;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPacientNume() { return pacientNume; }
    public void setPacientNume(String pacientNume) { this.pacientNume = pacientNume; }
    public String getPacientEmail() { return pacientEmail; }
    public void setPacientEmail(String pacientEmail) { this.pacientEmail = pacientEmail; }
    public Medic getMedic() { return medic; }
    public void setMedic(Medic medic) { this.medic = medic; }
    public LocalDateTime getDataOra() { return dataOra; }
    public void setDataOra(LocalDateTime dataOra) { this.dataOra = dataOra; }
    public String getMotiv() { return motiv; }
    public void setMotiv(String motiv) { this.motiv = motiv; }
    public StatusProgramare getStatus() { return status; }
    public void setStatus(StatusProgramare status) { this.status = status; }
}
