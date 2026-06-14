package com.exam.clinica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medici")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String specialitate;

    public Medic() {}

    public Medic(String nume, String specialitate) {
        this.nume = nume;
        this.specialitate = specialitate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getSpecialitate() { return specialitate; }
    public void setSpecialitate(String specialitate) { this.specialitate = specialitate; }
}
