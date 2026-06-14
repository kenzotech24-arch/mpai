package com.exam.inchirieri.dto;

import com.exam.inchirieri.model.StatusInchiriere;
import java.time.LocalDate;

public class InchiriereDTO {

    private Long id;
    private String utilizatorNume;
    private String utilizatorEmail;
    private Long echipamentId;
    private String echipamentNume;
    private LocalDate dataStart;
    private LocalDate dataFinal;
    private String scop;
    private StatusInchiriere status;

    public InchiriereDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUtilizatorNume() { return utilizatorNume; }
    public void setUtilizatorNume(String utilizatorNume) { this.utilizatorNume = utilizatorNume; }
    public String getUtilizatorEmail() { return utilizatorEmail; }
    public void setUtilizatorEmail(String utilizatorEmail) { this.utilizatorEmail = utilizatorEmail; }
    public Long getEchipamentId() { return echipamentId; }
    public void setEchipamentId(Long echipamentId) { this.echipamentId = echipamentId; }
    public String getEchipamentNume() { return echipamentNume; }
    public void setEchipamentNume(String echipamentNume) { this.echipamentNume = echipamentNume; }
    public LocalDate getDataStart() { return dataStart; }
    public void setDataStart(LocalDate dataStart) { this.dataStart = dataStart; }
    public LocalDate getDataFinal() { return dataFinal; }
    public void setDataFinal(LocalDate dataFinal) { this.dataFinal = dataFinal; }
    public String getScop() { return scop; }
    public void setScop(String scop) { this.scop = scop; }
    public StatusInchiriere getStatus() { return status; }
    public void setStatus(StatusInchiriere status) { this.status = status; }
}
