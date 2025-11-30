package com.mycompany.proyectopoo3.Modelo.Metricas;

import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Recomendacion;

import java.util.ArrayList;

public class CantKilometros extends Metrica {
    //Atributos de la clase CantKm_Pasos
    private final static double VALOR_MIN = 7;
    private final static double VALOR_MAX = 10;

    //Métodos de la clase CantKm_Pasos
    //--Constructores
    public CantKilometros() {}
    public CantKilometros(String id) {
        this.id = id;
    }

    //--Métodos especiales
    public static String obtenerDescripcion() {
        return "Cantidad de kilometros: " + VALOR_MIN + " - " + VALOR_MAX;
    }
    @Override
    public Metrica clonar() {
        CantKilometros copia = new CantKilometros(this.id);
        return copia;
    }
    @Override
    public void normalizarDatos() {
        valorActual = (valorActual - VALOR_MIN) / (VALOR_MAX - VALOR_MAX);
    }
    @Override
    public ArrayList<Recomendacion> generarRecomendaciones() {
        ArrayList<Recomendacion> rec = new ArrayList<Recomendacion>();
        if (valorActual < VALOR_MIN)
            rec.add(new Recomendacion(id, "Pocos kilometros recorridos."));
        if (valorActual > VALOR_MAX)
            rec.add(new Recomendacion(id, "Muchos kilometros recorridos."));
        return rec;
    }

}
