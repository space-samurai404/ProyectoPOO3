package com.mycompany.proyectopoo3.Modelo.DispositivosWereables;
import com.mycompany.proyectopoo3.Modelo.Metricas.CantKilometros;
import com.mycompany.proyectopoo3.Modelo.Metricas.HorasSuenno;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;
import com.mycompany.proyectopoo3.Modelo.Metricas.RitmoCardiaco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Wearable implements Serializable {
    //Atributos de la clase Wereable
    private ArrayList<Metrica> metricasAsociadas;
    private TipoWearable tipoWearable;

    //Métodos de la clase Wereable
    //--Constructores y getters-setters
    public Wearable() {}
    public Wearable(TipoWearable tipoWearable) {
        this.tipoWearable = tipoWearable;
        this.metricasAsociadas = new ArrayList<>();
        metricasAsociadas.add(new RitmoCardiaco("HR"));
        metricasAsociadas.add(new CantKilometros("KM"));
        metricasAsociadas.add(new HorasSuenno("HS"));
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
    @Override
    public String toString() {
        return "Wearable{" +
                "metricasAsociadas=" + metricasAsociadas +
                ", tipoWearable=" + tipoWearable +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Wearable wearable = (Wearable) o;
        return Objects.equals(metricasAsociadas, wearable.metricasAsociadas) && tipoWearable == wearable.tipoWearable;
    }
    @Override
    public int hashCode() {
        return Objects.hash(metricasAsociadas, tipoWearable);
    }


}
