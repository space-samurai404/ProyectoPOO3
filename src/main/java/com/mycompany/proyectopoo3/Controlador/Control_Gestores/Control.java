package com.mycompany.proyectopoo3.Controlador.Control_Gestores;
import com.mycompany.proyectopoo3.Controlador.Archivos_Excepciones.ICodigos;
import com.mycompany.proyectopoo3.Controlador.Archivos_Excepciones.MiExcepcion;
import com.mycompany.proyectopoo3.Modelo.Metricas.CantKilometros;
import com.mycompany.proyectopoo3.Modelo.Metricas.HorasSuenno;
import com.mycompany.proyectopoo3.Modelo.Metricas.Metrica;
import com.mycompany.proyectopoo3.Modelo.Metricas.RitmoCardiaco;
import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Recomendacion;
import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.RegistroMetricas;
import com.mycompany.proyectopoo3.Modelo.User_Meta_Recom_RegMet.Usuario;
import com.mycompany.proyectopoo3.Modelo.DispositivosWereables.Wearable;

import java.time.LocalDate;
import java.util.ArrayList;

public class Control {
    //Atributos de la clase control
    GestorUsuarios gestorUsuarios;

    //Métodos de la clase control
    //--Constructor y getter
    public Control() {
        gestorUsuarios = new GestorUsuarios();
    }
    public GestorUsuarios getGestorUsuarios() {
        return gestorUsuarios;
    }
    //--Métodos especiales
    /**
     * Metodo que crea un usuario según los datos del parametro. Verificando si existe el nombre, contrasenna
     * y correo en algún usuario del registro. Si los datos son válidos crea un usuario y lo agrega al registro.
     * @param nombre: Atributo String que es el nombre del usuario.
     * @param contrasenna: Atributo String que es la contrasenna del usuario.
     * @param correo: Atributo String que es el correo del usuario.
     * @param listaWereables: Atributo ArrayList de elementos tipo Wereable, que son los wereables elegidos por el usuario.
     * @return: Retorna true si se hace correctamente, lanza una excepcion si no.
     * @throws MiExcepcion
     */
    public boolean registrarUsuario(String nombre, String contrasenna, String correo, ArrayList<Wearable> listaWereables) throws MiExcepcion {
        if (gestorUsuarios.verificarDatos(nombre, 1)) {
            throw new MiExcepcion(ICodigos.ERROR_USUARIO_INVALIDO);
        }
        if (gestorUsuarios.verificarDatos(contrasenna,2)) {
            throw new MiExcepcion(ICodigos.ERROR_CONTRASENNA_INVALIDA);
        }
        if (gestorUsuarios.verificarDatos(correo,3)) {
            throw new MiExcepcion(ICodigos.ERROR_CORREO_INVALIDO);
        }
        Usuario usuario = new Usuario(nombre, contrasenna, correo, listaWereables);
        gestorUsuarios.setUsuarioActual(usuario);
        return gestorUsuarios.agregarUsuario(usuario);
    }
    /**
     * Metodo que inicia sesión, poniendolo como usuario actual del sistema.
     * @param nombre: Atributo String de la cuenta a iniciar sesión.
     * @param contrasenna: Atributo String que representa la contraseña de la cuenta a iniciar sesión.
     * @throws MiExcepcion
     */
    public void iniciarSesion(String nombre, String contrasenna) throws MiExcepcion {
        if (gestorUsuarios.verificarDatos(nombre, 1)) {
            throw new MiExcepcion(ICodigos.ERROR_USUARIO_INVALIDO);
        }
        if (gestorUsuarios.verificarDatos(contrasenna, 2)) {
            throw new MiExcepcion(ICodigos.ERROR_CONTRASENNA_INVALIDA);
        }
        Usuario usuario = gestorUsuarios.buscarUsuario(nombre,contrasenna);
        gestorUsuarios.setUsuarioActual(usuario);
    }
    /**
     * Metodo que muestra la información de las referencias de las 3 métricas medibles del sistema
     * @return: Retorna un ArrayList de elementos String, cada elemento siendo la descripcion de la métrica.
     * @throws MiExcepcion
     */
    public String mostrarReferenciasMetricas() {
        ArrayList<String> datosMetricas = new ArrayList<String>();
        datosMetricas.add(CantKilometros.obtenerDescripcion());
        datosMetricas.add(RitmoCardiaco.obtenerDescripcion());
        datosMetricas.add(HorasSuenno.obtenerDescripcion());
        return String.join("\n", datosMetricas);
    }
    /**
     * Metodo que obtiene el ultimo registro de metricas realizado por la aplicación.
     * @return : Retorna un atributo RegistroMetricas si encuentra el registro, si no lanza una excepción.
     * @throws MiExcepcion
     */
    public RegistroMetricas obtenerRegistroDelDia() throws MiExcepcion {
        Usuario usuarioActual = gestorUsuarios.getUsuarioActual();
        LocalDate hoy = usuarioActual.getFechaUltRegistro();
        for (RegistroMetricas registro : usuarioActual.getHistorial()) {
            if (registro.getFecha().equals(hoy)) {
                return registro;
            }
        }
        throw new MiExcepcion(ICodigos.ERROR_REGISTRO_NO_EXISTE);
    }
    /**
     * Metodo que genera un reporte consolidado a partir del ultimo registro de Metrica, que es equivalente
     * de la ultima simulación realizada.
     * @return : Retorna un String que es el reporte generado.
     */
    public String generarReporteConsolidado() throws MiExcepcion{
        RegistroMetricas registro = obtenerRegistroDelDia();
        Usuario usuarioActual = gestorUsuarios.getUsuarioActual();
        StringBuilder reporte = new StringBuilder();
        for (Metrica metrica : usuarioActual.getMetricasDiarias()) {
            reporte.append(metrica.getId())
                    .append(": ")
                    .append(metrica.getValorActual())
                    .append("\n");
        }
        return reporte.toString();
    }

    public void generarRecomendacionesDelDia() {
        Usuario u = gestorUsuarios.getUsuarioActual();
        u.getRecomendacionesDiarias().clear();
        RegistroMetricas registro = obtenerRegistroDelDia();
        for (Metrica m : registro.getMetricasDiarias()) {
            u.getRecomendacionesDiarias().addAll(m.generarRecomendaciones());
        }
    }

    public String obtenerRecomendacionesDelDia() {
        Usuario usuarioActual = gestorUsuarios.getUsuarioActual();
        StringBuilder recomendaciones = new StringBuilder();
        for (Recomendacion r : usuarioActual.getRecomendacionesDiarias()) {
            recomendaciones.append(r.getDescripcion()).append("\n");
        }
        return recomendaciones.toString();
    }

    public String mostrarHistorial() {
        Usuario usuarioActual = gestorUsuarios.getUsuarioActual();
        StringBuilder historial = new StringBuilder();
        for (RegistroMetricas registro : usuarioActual.getHistorial()) {
            historial.append("Fecha: ").append(registro.getFecha()).append("\n");
            for (Metrica metrica : registro.getMetricasDiarias()) {
                historial.append("  - ")
                        .append(metrica.getId())
                        .append(": ")
                        .append(metrica.getValorActual())
                        .append("\n");
            }

            historial.append("\n");
        }
        return historial.toString();
    }


}
