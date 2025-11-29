package com.mycompany.proyectopoo3.Controlador.Control_Gestores;
import com.mycompany.proyectopoo3.Controlador.Archivos_Excepciones.ICodigos;
import com.mycompany.proyectopoo3.Controlador.Archivos_Excepciones.MiExcepcion;
import com.mycompany.proyectopoo3.Modelo.Metricas.CantKilometros;
import com.mycompany.proyectopoo3.Modelo.Metricas.HorasSuenno;
import com.mycompany.proyectopoo3.Modelo.Metricas.RitmoCardiaco;
import com.mycompany.proyectopoo3.Modelo.Usuario_Meta_RegistroMetricas.Usuario;
import com.mycompany.proyectopoo3.Modelo.DispositivosWereables.Wearable;
import java.util.ArrayList;

public class Control {
    //Atributos de la clase control
    GestorUsuarios gestorUsuarios;
    GestorMetas gestorMetas;
    Usuario usuarioActual;

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
        usuarioActual = usuario;
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
        usuarioActual = gestorUsuarios.buscarUsuario(nombre,contrasenna);
    }
    /**
     * Metodo que muestra la información de las referencias de las 3 métricas medibles del sistema
     * @return: Retorna un ArrayList de eleemntos String, cada elemento siendo la descripcion de la métrica.
     * @throws MiExcepcion
     */
    public String mostrarReferenciasMetricas() {
        ArrayList<String> datosMetricas = new ArrayList<String>();
        datosMetricas.add(CantKilometros.obtenerDescripcion());
        datosMetricas.add(RitmoCardiaco.obtenerDescripcion());
        datosMetricas.add(HorasSuenno.obtenerDescripcion());
        return datosMetricas.toString();
    }



}
