package com.mycompany.proyectopoo3.Controlador.Control_Gestores;
import com.mycompany.proyectopoo3.Modelo.Usuario_Meta_RegistroMetricas.Meta;
import java.util.ArrayList;

public class GestorMetas {
    //Atributos de la clase GestorMetas
    private ArrayList<Meta> listaMetas;

    //Métodos de la clase GestorMetas
    //--Constructor y getter-setter
    GestorMetas() {
        listaMetas = new ArrayList<Meta>();
    }
    public ArrayList<Meta> getListaMetas() {
        return listaMetas;
    }
    public void setListaMetas(ArrayList<Meta> listaMetas) {
        this.listaMetas = listaMetas;
    }
}
