package ProyectoPOO3.Modelo.Metricas;

import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.Recomendacion;

import java.io.Serializable;
import java.util.ArrayList;

public class CantKilometros extends Metrica implements Serializable {
    //Atributos de la clase CantKm_Pasos
    private final static double VALOR_MIN = 3;
    

    //Métodos de la clase CantKm_Pasos
    //--Constructores
    public CantKilometros() {}
    public CantKilometros(String id) {
        this.id = id;
    }
    
    

    //--Métodos especiales
    public static String obtenerDescripcion() {
        return "Cantidad de kilometros: " + VALOR_MIN ;
    }
    @Override
    public Metrica clonar() {
        CantKilometros copia = new CantKilometros(this.id);
        return copia;
    }
    @Override
    public void normalizarDatos() {
        valorActual = (valorActual - VALOR_MIN) / VALOR_MIN;
    }
    @Override
    public ArrayList<Recomendacion> generarRecomendaciones() {
        ArrayList<Recomendacion> rec = new ArrayList<Recomendacion>();
        if (valorActual < VALOR_MIN)
            rec.add(new Recomendacion(id, "Pocos kilometros recorridos."));
        
        return rec;
    }

}
