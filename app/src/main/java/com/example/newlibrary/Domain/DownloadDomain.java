package com.example.newlibrary.Domain;

public class DownloadDomain {

    private String Nombre;
    private String Correo;
    public DownloadDomain(String nombre, String correo) {
        this.Nombre = nombre;
        this.Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
