package com.mycompany.proyectopoo3.Modelo.Metricas;
import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Recomendacion;
import java.util.ArrayList;

public abstract class Metrica implements IRecomendaciones {
    //Atributos de la clase Metrica
    protected String id;
    protected double valorActual;

    //Métodos de la clase Metrica
    //--Constructores y setters-getters
    public Metrica() {}
    public Metrica(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getValorActual() {
        return valorActual;
    }
    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }
    //--Métodos especiales

}
