package com.mycompany.proyectopoo3.Modelo.Metricas;

public class HorasSuenno extends Metrica {
    //Atributos de la clase HorasSuenno
    private final static double VALOR_MIN = 0;
    private final static double VALOR_MAX = 1;

    //Métodos de la clase HorasSuenno
    //--Constructor
    public HorasSuenno() {}
    //--Métodos especiales
    public static String obtenerDescripcion() {
        return "Horas de sueño: " + VALOR_MIN + " - " + VALOR_MAX;
    }

}
