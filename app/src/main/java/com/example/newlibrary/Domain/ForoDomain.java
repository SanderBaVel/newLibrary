package com.example.newlibrary.Domain;

public class ForoDomain {
    private String Username;
    private String Pregunta;

    public ForoDomain(String username, String pregunta) {
        Username = username;
        Pregunta = pregunta;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String pregunta) {
        this.Pregunta = pregunta;
    }
}
