package com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;

public class Meta {
    //Atributos de la clase Meta
    private String descripcion;
    private double porcentaje;
    private Metrica metricaAsignada;

    //Métodos de la clase Meta
    //--Constructor y getters-setters
    public Meta() {}
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    public Metrica getMetricaAsignada() {
        return metricaAsignada;
    }
    public void setMetricaAsignada(Metrica metricaCorrespondiente) {
        this.metricaAsignada = metricaCorrespondiente;
    }


}
