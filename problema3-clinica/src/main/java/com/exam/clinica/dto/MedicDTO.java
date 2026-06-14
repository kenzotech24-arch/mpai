package com.exam.clinica.dto;

public class MedicDTO {

    private Long id;
    private String nume;
    private String specialitate;

    public MedicDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getSpecialitate() { return specialitate; }
    public void setSpecialitate(String specialitate) { this.specialitate = specialitate; }
}
