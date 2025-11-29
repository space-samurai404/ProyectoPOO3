package com.mycompany.proyectopoo3.Modelo.Usuario_Meta_RegistroMetricas;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegistroMetricas {
    //Atributos de la clase RegistroMetricas
    private ArrayList<Metrica> metricasDiarias;
    private LocalDate fecha;

    //Métodos de la clase RegistroMetricas
    //--Constructor y getters-setters
    public RegistroMetricas() {}
    public ArrayList<Metrica> getMetricasDiarias() {
        return metricasDiarias;
    }
    public void setMetricasDiarias(ArrayList<Metrica> metricasDiarias) {
        this.metricasDiarias = metricasDiarias;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
