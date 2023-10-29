package com.example.newlibrary.Domain;

import java.io.Serializable;

public class BookDomain implements Serializable {

private String nameBook;
private String etiqueta;
private String autor;
private String editorial;
private String picUrl;
private String description;
private int numberinCart;
private int id;

    public BookDomain(String nameBook, String etiqueta, String autor, String editorial,String picUrl, int id) {
        this.nameBook = nameBook;
        this.etiqueta = etiqueta;
        this.autor = autor;
        this.editorial = editorial;
        this.picUrl = picUrl;
        this.id = id;
        this.description = description;

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberinCart() {
        return numberinCart;
    }

    public void setNumberinCart(int numberinCart) {
        this.numberinCart = numberinCart;
    }
    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
