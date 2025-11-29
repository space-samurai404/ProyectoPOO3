package com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet;

public class Recomendacion {
    //Atributo de la clase Recomendacion
    private String idMetrica;
    private String descripcion;

    //Métodos de la clase Recomendacion
    //--Constructor y getters-setters
    public Recomendacion() {}
    public Recomendacion(String idMetrica, String descripcion) {
        this.idMetrica = idMetrica;
        this.descripcion = descripcion;
    }
    public String getIdMetrica() {
        return idMetrica;
    }
    public void setIdMetrica(String idMetrica) {
        this.idMetrica = idMetrica;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
