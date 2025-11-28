package com.mycompany.proyectopoo3.Controlador;
import com.mycompany.proyectopoo3.Modelo.Usuario;
import java.util.ArrayList;

public class GestorUsuarios {
    //Atributos de la clase GestorUsuarios
    private ArrayList<Usuario> listaUsuarios;

    //Métodos de la clase GestorUsuarios
    //--Constructor y getters-setters
    public GestorUsuarios() {
        listaUsuarios = new ArrayList<Usuario>();
    }
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
