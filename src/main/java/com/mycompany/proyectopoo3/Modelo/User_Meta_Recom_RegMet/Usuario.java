package com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet;
import com.mycompany.proyectopoo3.Modelo.DispositivosWereables.Wearable;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements Serializable {
    //Atributos de la clase Usuario
    private String nombre;
    private String contrasenna;
    private String correo;
    private ArrayList<Wearable> weareblesAsociados;
    private ArrayList<Meta> metasActivas;
    private ArrayList<RegistroMetricas> historial;
    private ArrayList<Recomendacion> recomendacionesDiarias;
    private ArrayList<Metrica> metricasDiarias;
    private LocalDate fechaUltRegistro;

    //Métodos de la clase Usuario
    //--Constructores y getters-setters
    public Usuario() {}
    public Usuario(String nombre, String contrasenna, String correo, ArrayList<Wearable> wereablesAsociados) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.correo = correo;
        this.weareblesAsociados = wereablesAsociados;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasenna() {
        return contrasenna;
    }
    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public ArrayList<Wearable> getWeareblesAsociados() {
        return weareblesAsociados;
    }
    public void setWeareblesAsociados(ArrayList<Wearable> wereablesAsociados) {this.weareblesAsociados = wereablesAsociados;}
    public ArrayList<Meta> getMetasActivas() {
        return metasActivas;
    }
    public void setMetasActivas(ArrayList<Meta> metasActivas) {
        this.metasActivas = metasActivas;
    }
    public ArrayList<RegistroMetricas> getHistorial() {return historial;}
    public void setHistorial(ArrayList<RegistroMetricas> registroMetricas) {this.historial = registroMetricas;}
    public ArrayList<Recomendacion> getRecomendacionesDiarias() {return recomendacionesDiarias;}
    public void setRecomendacionesDiarias(ArrayList<Recomendacion> recomendacionesDiarias) {this.recomendacionesDiarias = recomendacionesDiarias;}
    public ArrayList<Metrica> getMetricasDiarias() {return metricasDiarias;}
    public void setMetricasDiarias(ArrayList<Metrica> metricas) {this.metricasDiarias = metricas;}
    public LocalDate getFechaUltRegistro() {return fechaUltRegistro;}
    public void setFechaUltRegistro(LocalDate fechaUltRegistro) {this.fechaUltRegistro = fechaUltRegistro;}



}
