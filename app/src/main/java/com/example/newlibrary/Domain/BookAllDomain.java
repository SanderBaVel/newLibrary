package com.example.newlibrary.Domain;

public class BookAllDomain {
    private String Nombre;
    private String Autor;
    private String Etiqueta;
    private String Editorial;
    private String FiltroEtiqueta;
    private int id;

    public String getFiltroEtiqueta() {
        return FiltroEtiqueta;
    }

    public void setFiltroEtiqueta(String filtroEtiqueta) {
        FiltroEtiqueta = filtroEtiqueta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEtiqueta() {
        return Etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        Etiqueta = etiqueta;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }
}
