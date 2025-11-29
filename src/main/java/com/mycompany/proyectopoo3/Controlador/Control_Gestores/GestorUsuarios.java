package com.mycompany.proyectopoo3.Controlador.Control_Gestores;
import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Usuario;
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
    //--Métodos especiales
    /**
     * Metodo que verifica si existe un nombre, contrasenna o correo en el registro de usuarios.
     * @param aVerificar: Atributo tipo String que es el dato a verificar.
     * @param codigo: Atributo tipo int que sirve para indicar el dato a verificar.
     * @return: Retorna un atributo booleano true si existe, false si lo contrario.
     */
    public boolean verificarDatos(String aVerificar, int codigo) {
        if (codigo == 1) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombre() == aVerificar)
                    return true;
            }
            return false;
        }
        if (codigo == 2) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getContrasenna() == aVerificar)
                    return true;
            }
            return false;
        }
        else {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getCorreo() == aVerificar && aVerificar.contains("@gmail,com"))
                    return true;
            }
            return false;
        }
    }
    /**
     * Metodo que agrega un usuario a la lista de usuarios.
     * @param usuario: Atributo tipo Usuario que es el dato a agregar.
     * @return: Retorna un atributo bolleano true, mostrando que se agregó correctamente.
     */
    public boolean agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        return true;
    }
    /**
     * Metodo que busca un usario por medio de su nombre y contraseña.
     * @param nombre: Atributo String que representa el nombre del usuario a buscar.
     * @param contrasenna: Atributo String que representa la contraseña del usuario a buscar.
     * @return: Retorna el usuario encontrado, si no retorna null.
     */
    public Usuario buscarUsuario(String nombre, String contrasenna) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre() == nombre && usuario.getContrasenna() == contrasenna) {
                return usuario;
            }
        }
        return null;
    }
}
