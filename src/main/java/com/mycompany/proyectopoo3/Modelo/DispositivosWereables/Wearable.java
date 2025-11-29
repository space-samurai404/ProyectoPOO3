package com.mycompany.proyectopoo3.Modelo.DispositivosWereables;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;
import java.io.Serializable;
import java.util.ArrayList;

public class Wearable implements Serializable {
    //Atributos de la clase Wereable
    private ArrayList<Metrica> metricasAsociadas;
    private TipoWearable tipoWearable;

    //Métodos de la clase Wereable
    public Wearable() {}
}
