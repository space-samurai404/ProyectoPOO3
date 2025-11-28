package com.mycompany.proyectopoo3.Modelo.Usuario_Meta;
import com.mycompany.proyectopoo3.Modelo.DispositivosWereables.Wereable;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    //Atributos de la clase Usuario
    private String nombre;
    private String contrasenna;
    private String correo;
    private ArrayList<Wereable> wereablesAsociados;
    private ArrayList<Meta> metasActivas;

    //Métodos de la clase Usuario
    //--Constructores y getters-setters
    public Usuario() {}
    public Usuario(String nombre, String contrasenna, String correo, ArrayList<Wereable> wereablesAsociados) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.correo = correo;
        this.wereablesAsociados = wereablesAsociados;
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
    public ArrayList<Wereable> getWereablesAsociados() {
        return wereablesAsociados;
    }
    public void setWereablesAsociados(ArrayList<Wereable> wereablesAsociados) {
        this.wereablesAsociados = wereablesAsociados;
    }
    public ArrayList<Meta> getMetasActivas() {
        return metasActivas;
    }
    public void setMetasActivas(ArrayList<Meta> metasActivas) {
        this.metasActivas = metasActivas;
    }
}
