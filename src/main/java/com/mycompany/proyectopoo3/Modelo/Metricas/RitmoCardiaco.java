package com.mycompany.proyectopoo3.Modelo.Metricas;

public class RitmoCardiaco extends Metrica {
    //Atributos de la clase RitmoCardiaco
    private final static double VALOR_MIN = 0;
    private final static double VALOR_MAX = 1;

    //Métodos de la clase RitmoCardiaco
    //--Constructor
    public RitmoCardiaco() {}
    //--Métodos especiales
    public static String obtenerDescripcion() {
        return "Ritmo cardiaco: " + VALOR_MIN + " - " + VALOR_MAX;
    }

}
