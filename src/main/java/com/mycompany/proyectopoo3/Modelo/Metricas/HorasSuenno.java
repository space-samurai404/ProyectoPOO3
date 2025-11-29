package com.mycompany.proyectopoo3.Modelo.Metricas;

import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Recomendacion;

import java.util.ArrayList;

public class HorasSuenno extends Metrica {
    //Atributos de la clase HorasSuenno
    private final static double VALOR_MIN = 6;
    private final static double VALOR_MAX = 9;

    //Métodos de la clase HorasSuenno
    //--Constructores
    public HorasSuenno() {}
    public HorasSuenno(String id) {
        this.id = id;
    }
    //--Métodos especiales
    public static String obtenerDescripcion() {
        return "Horas de sueño: " + VALOR_MIN + " - " + VALOR_MAX;
    }

    @Override
    public ArrayList<Recomendacion> generarRecomendaciones() {
        ArrayList<Recomendacion> rec = new ArrayList<Recomendacion>();
        if (valorActual < VALOR_MIN)
            rec.add(new Recomendacion(id, "Dormiste poco hoy."));
        if (valorActual > VALOR_MAX)
            rec.add(new Recomendacion(id, "Dormiste demasiado."));
        return rec;
    }
}
