package com.mycompany.proyectopoo3.Modelo.DispositivosWereables;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Wereable implements Serializable {
    //Atributos de la clase Wereable
    protected ArrayList<Metrica> metricasAsociadas;

    //Métodos de la clase Wereable
    public Wereable() {}
}
