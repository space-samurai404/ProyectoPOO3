package com.mycompany.proyectopoo3.Modelo.Metricas;

public class CantKilometros extends Metrica {
    //Atributos de la clase CantKm_Pasos
    private final static double VALOR_MIN = 0;
    private final static double VALOR_MAX = 1;

    //Métodos de la clase CantKm_Pasos
    //--Constructor
    public CantKilometros() {}
    //--Métodos especiales
    public static String obtenerDescripcion() {
        return "Cantidad de kilometros: " + VALOR_MIN + " - " + VALOR_MAX;
    }



}
