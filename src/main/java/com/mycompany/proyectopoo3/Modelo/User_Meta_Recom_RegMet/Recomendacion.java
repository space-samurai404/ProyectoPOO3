package com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet;
import java.io.Serializable;
import java.util.Objects;

public class Recomendacion implements Serializable {
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
    @Override
    public String toString() {
        return "Recomendacion{" +
                "idMetrica='" + idMetrica + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recomendacion that = (Recomendacion) o;
        return Objects.equals(idMetrica, that.idMetrica) && Objects.equals(descripcion, that.descripcion);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idMetrica, descripcion);
    }
}
