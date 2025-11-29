package com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet;
import com.mycompany.proyectopoo3.Modelo.DispositivosWereables.Wearable;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    //Atributos de la clase Usuario
    private String nombre;
    private String contrasenna;
    private String correo;
    private ArrayList<Wearable> weareblesAsociados;
    private ArrayList<Meta> metasActivas;
    private ArrayList<RegistroMetricas> registroMetricas;
    private ArrayList<Recomendacion> recomendacionesDiarias;

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
    public ArrayList<RegistroMetricas> getRegistroMetricas() {return registroMetricas;}
    public void setRegistroMetricas(ArrayList<RegistroMetricas> registroMetricas) {this.registroMetricas = registroMetricas;}
    public ArrayList<Recomendacion> getRecomendacionesDiarias() {return recomendacionesDiarias;}
    public void setRecomendacionesDiarias(ArrayList<Recomendacion> recomendacionesDiarias) {this.recomendacionesDiarias = recomendacionesDiarias;}




}
