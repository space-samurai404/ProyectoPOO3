package ProyectoPOO3.Modelo.Metricas;

import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.Recomendacion;

import java.util.ArrayList;

public class RitmoCardiaco extends Metrica {
    //Atributos de la clase RitmoCardiaco
    private final static double VALOR_MIN = 50;
    private final static double VALOR_MAX = 100;

    //Métodos de la clase RitmoCardiaco
    //--Constructores
    public RitmoCardiaco() {}
    public RitmoCardiaco(String id) {
        this.id = id;
    }

    //--Métodos especiales
    public static String obtenerDescripcion() {
        return "Ritmo cardiaco: " + VALOR_MIN + " - " + VALOR_MAX;
    }
    @Override
    public Metrica clonar() {
        RitmoCardiaco copia = new RitmoCardiaco(this.id);
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
            rec.add(new Recomendacion(id, "Ritmo cardiaco muy bajo"));
        if (valorActual > VALOR_MAX)
            rec.add(new Recomendacion(id, "Ritmo cardiaco muy alto."));
        return rec;
    }


}
