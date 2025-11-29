package com.mycompany.proyectopoo3.Modelo.DispositivosWereables;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;
import java.io.Serializable;
import java.util.ArrayList;

public class Wearable implements Serializable {
    //Atributos de la clase Wereable
    private ArrayList<Metrica> metricasAsociadas;
    private TipoWearable tipoWearable;

    //Métodos de la clase Wereable
    //--Constructores y getters-setters
    public Wearable() {}
    public Wearable(TipoWearable tipoWearable) {
        this.tipoWearable = tipoWearable;

    }
    public ArrayList<Metrica> getMetricasAsociadas() {
        return metricasAsociadas;
    }
    public void setMetricasAsociadas(ArrayList<Metrica> metricasAsociadas) {
        this.metricasAsociadas = metricasAsociadas;
    }
    public TipoWearable getTipoWearable() {
        return tipoWearable;
    }
    public void setTipoWearable(TipoWearable tipoWearable) {
        this.tipoWearable = tipoWearable;
    }
}
