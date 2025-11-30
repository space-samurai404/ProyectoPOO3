/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ProyectoPOO3.MainPruebas;

import ProyectoPOO3.Controlador.Archivos_Excepciones.MiExcepcion;
import ProyectoPOO3.Controlador.Control_Gestores.Control;
import ProyectoPOO3.Modelo.Wearables.TipoWearable;
import ProyectoPOO3.Modelo.Metricas.HorasSuenno;
import ProyectoPOO3.Modelo.Metricas.Metrica;
import ProyectoPOO3.Modelo.Metricas.RitmoCardiaco;
import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.RegistroMetricas;
import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.Usuario;

import java.time.LocalDate;
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

        ArrayList<Metrica> metricas = new ArrayList<>();
        metricas.add(new HorasSuenno("HS"));
        metricas.add(new RitmoCardiaco("RC"));
        RegistroMetricas registro = new RegistroMetricas(metricas, LocalDate.now());
        usuarioActual.setFechaUltRegistro(LocalDate.now());
        usuarioActual.getHistorial().add(registro);
        try {
            controlador.exportarReporteParaProfesional();
        }
        catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

        controlador.guardarUsuarios();
    }
}
