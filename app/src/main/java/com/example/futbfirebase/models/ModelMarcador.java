package com.example.futbfirebase.models;

public class ModelMarcador {
    private String Texto;

    public ModelMarcador(){}

    public ModelMarcador(String Texto){
        this.Texto = Texto;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }
}
