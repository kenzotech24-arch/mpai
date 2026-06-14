package com.exam.inchirieri.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inchirieri")
public class Inchiriere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String utilizatorNume;
    private String utilizatorEmail;

    @ManyToOne
    @JoinColumn(name = "echipament_id")
    private Echipament echipament;

    private LocalDate dataStart;
    private LocalDate dataFinal;
    private String scop;

    @Enumerated(EnumType.STRING)
    private StatusInchiriere status;

    public Inchiriere() {}

    public Inchiriere(String utilizatorNume, String utilizatorEmail, Echipament echipament,
                      LocalDate dataStart, LocalDate dataFinal, String scop, StatusInchiriere status) {
        this.utilizatorNume = utilizatorNume;
        this.utilizatorEmail = utilizatorEmail;
        this.echipament = echipament;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.scop = scop;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUtilizatorNume() { return utilizatorNume; }
    public void setUtilizatorNume(String utilizatorNume) { this.utilizatorNume = utilizatorNume; }
    public String getUtilizatorEmail() { return utilizatorEmail; }
    public void setUtilizatorEmail(String utilizatorEmail) { this.utilizatorEmail = utilizatorEmail; }
    public Echipament getEchipament() { return echipament; }
    public void setEchipament(Echipament echipament) { this.echipament = echipament; }
    public LocalDate getDataStart() { return dataStart; }
    public void setDataStart(LocalDate dataStart) { this.dataStart = dataStart; }
    public LocalDate getDataFinal() { return dataFinal; }
    public void setDataFinal(LocalDate dataFinal) { this.dataFinal = dataFinal; }
    public String getScop() { return scop; }
    public void setScop(String scop) { this.scop = scop; }
    public StatusInchiriere getStatus() { return status; }
    public void setStatus(StatusInchiriere status) { this.status = status; }
}
