/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectopoo3.MainPruebas;

import com.mycompany.proyectopoo3.Controlador.Archivos_Excepciones.MiExcepcion;
import com.mycompany.proyectopoo3.Controlador.Control_Gestores.Control;
import com.mycompany.proyectopoo3.Modelo.DispositivosWereables.TipoWearable;
import com.mycompany.proyectopoo3.Modelo.DispositivosWereables.Wearable;
import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Usuario;

import java.util.ArrayList;

/**
 *
 * @author paula
 */
public class ProyectoPOO3 {

    public static void main(String[] args) {
        Control controlador = new Control();
        ArrayList<TipoWearable> conjuntoWearables = new ArrayList<>();
        conjuntoWearables.add(TipoWearable.BICICLETA_INTELIGENTE);
        conjuntoWearables.add(TipoWearable.RELOJ_INTELIGENTE);
        conjuntoWearables.add(TipoWearable.ROPA_INTELIGENTE);


        controlador.registrarUsuario("Marcela12", "Canelon12+", "Mar12@gmail.com", conjuntoWearables);
        Usuario usuarioActual = controlador.getGestorUsuarios().getUsuarioActual();
        System.out.println(usuarioActual.toString());

        try{
            controlador.registrarUsuario("EduardoM", "Luna12+", "Edu", conjuntoWearables);
            usuarioActual = controlador.getGestorUsuarios().getUsuarioActual();
            System.out.println(usuarioActual.toString());
        }
        catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

        try {
            controlador.iniciarSesion("Marcela12", "Canelon12+");
            usuarioActual = controlador.getGestorUsuarios().getUsuarioActual();
            System.out.println(usuarioActual.toString());
        }
        catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

        controlador.registrarUsuario("EduardoM", "Luna12+", "Edu@gmail.com", conjuntoWearables);
        usuarioActual = controlador.getGestorUsuarios().getUsuarioActual();
        System.out.println(usuarioActual.toString());

        try {
            controlador.iniciarSesion("Marcela12", "Canelon13+");
            usuarioActual = controlador.getGestorUsuarios().getUsuarioActual();
            System.out.println(usuarioActual.toString());
        }
        catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

    }
}
