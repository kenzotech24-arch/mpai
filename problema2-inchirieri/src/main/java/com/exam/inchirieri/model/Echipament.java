package com.exam.inchirieri.model;

import jakarta.persistence.*;

@Entity
@Table(name = "echipamente")
public class Echipament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String descriere;
    private boolean disponibil;

    public Echipament() {}

    public Echipament(String nume, String descriere, boolean disponibil) {
        this.nume = nume;
        this.descriere = descriere;
        this.disponibil = disponibil;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }
    public boolean isDisponibil() { return disponibil; }
    public void setDisponibil(boolean disponibil) { this.disponibil = disponibil; }
}
