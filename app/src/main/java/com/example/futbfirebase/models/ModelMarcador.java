package com.example.futbfirebase.models;

public class ModelMarcador {
    private String User;
    private String Marcador;

    public ModelMarcador(){}

    public ModelMarcador(String User, String Marcador){
        this.User = User;
        this.Marcador = Marcador;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getMarcador() {
        return Marcador;
    }

    public void setMarcador(String marcador) {
        Marcador = marcador;
    }
}
