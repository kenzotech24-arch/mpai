package com.exam.clinica.dto;

import com.exam.clinica.model.StatusProgramare;
import java.time.LocalDateTime;

public class ProgramareDTO {

    private Long id;
    private String pacientNume;
    private String pacientEmail;
    private Long medicId;
    private String medicNume;
    private String medicSpecialitate;
    private LocalDateTime dataOra;
    private String motiv;
    private StatusProgramare status;

    public ProgramareDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPacientNume() { return pacientNume; }
    public void setPacientNume(String pacientNume) { this.pacientNume = pacientNume; }
    public String getPacientEmail() { return pacientEmail; }
    public void setPacientEmail(String pacientEmail) { this.pacientEmail = pacientEmail; }
    public Long getMedicId() { return medicId; }
    public void setMedicId(Long medicId) { this.medicId = medicId; }
    public String getMedicNume() { return medicNume; }
    public void setMedicNume(String medicNume) { this.medicNume = medicNume; }
    public String getMedicSpecialitate() { return medicSpecialitate; }
    public void setMedicSpecialitate(String medicSpecialitate) { this.medicSpecialitate = medicSpecialitate; }
    public LocalDateTime getDataOra() { return dataOra; }
    public void setDataOra(LocalDateTime dataOra) { this.dataOra = dataOra; }
    public String getMotiv() { return motiv; }
    public void setMotiv(String motiv) { this.motiv = motiv; }
    public StatusProgramare getStatus() { return status; }
    public void setStatus(StatusProgramare status) { this.status = status; }
}
