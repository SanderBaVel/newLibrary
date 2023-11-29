package com.example.newlibrary.Domain;

public class DownloadDomain {
    private int id;
    private int volumen;
    private String carrera;
    private String materia;
    private String titulolb;
    private String autor;

    public DownloadDomain(int id, int volumen, String carrera, String materia, String titulolb, String autor) {
        this.id = id;
        this.volumen = volumen;
        this.carrera = carrera;
        this.materia = materia;
        this.titulolb = titulolb;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTitulolb() {
        return titulolb;
    }

    public void setTitulolb(String titulolb) {
        this.titulolb = titulolb;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
