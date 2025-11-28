package com.mycompany.proyectopoo3.Controlador;

public class Control {
    //Atributos de la clase control
    GestorUsuarios gestorUsuarios;

    //Métodos de la clase control
    //--Constructor y getters
    public Control() {
        gestorUsuarios = new GestorUsuarios();
    }
    public GestorUsuarios getGestorUsuarios() {
        return gestorUsuarios;
    }

}
