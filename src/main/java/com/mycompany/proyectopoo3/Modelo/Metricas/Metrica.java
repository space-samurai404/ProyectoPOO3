package com.mycompany.proyectopoo3.Modelo.Metricas;

public abstract class Metrica {
    //Atributos de la clase Metrica
    protected String id;
    protected double valorActual;

    //Métodos de la clase Metrica
    //--Constructor y setters-getters
    public Metrica() {}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getValorActual() {
        return valorActual;
    }
    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }
    //--Métodos especiales

}
