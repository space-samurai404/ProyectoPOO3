package ProyectoPOO3.Controlador.Control_Gestores;
import ProyectoPOO3.Controlador.Archivos_Excepciones.GestorArchivos;
import ProyectoPOO3.Controlador.Archivos_Excepciones.ICodigos;
import ProyectoPOO3.Controlador.Archivos_Excepciones.MiExcepcion;
import ProyectoPOO3.Modelo.Wearables.TipoWearable;
import ProyectoPOO3.Modelo.Metricas.CantKilometros;
import ProyectoPOO3.Modelo.Metricas.HorasSuenno;
import ProyectoPOO3.Modelo.Metricas.Metrica;
import ProyectoPOO3.Modelo.Metricas.RitmoCardiaco;
import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.Meta;
import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.Recomendacion;
import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.RegistroMetricas;
import ProyectoPOO3.Modelo.User_Meta_Recom_RegMet.Usuario;
import ProyectoPOO3.Modelo.Wearables.Wearable;

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
    public boolean registrarUsuario(String nombre, String contrasenna, String correo, ArrayList<TipoWearable> listaTipos) throws MiExcepcion {
        if (!correo.contains("@gmail.com")) {
            // Lanza excepción por formato incorrecto (ej. 'Edu' o 'test@hotmail.com')
            throw new MiExcepcion(ICodigos.ERROR_CORREO_INVALIDO);
        }
        if (gestorUsuarios.verificarDatos(nombre, 1)) {
            throw new MiExcepcion(ICodigos.ERROR_USUARIO_INVALIDO);
        }
        if (gestorUsuarios.verificarDatos(contrasenna,2)) {
            throw new MiExcepcion(ICodigos.ERROR_CONTRASENNA_INVALIDA);
        }
        if (gestorUsuarios.verificarDatos(correo,3)) {
            throw new MiExcepcion(ICodigos.ERROR_CORREO_INVALIDO);
        }
        ArrayList<Wearable> listaWearables = new ArrayList<>();
        for (TipoWearable tipo : listaTipos) {
            Wearable w = new Wearable(tipo);
            listaWearables.add(w);
        }
        Usuario usuario = new Usuario(nombre, contrasenna, correo, listaWearables);
        gestorUsuarios.setUsuarioActual(usuario);
        return gestorUsuarios.agregarUsuario(usuario);
    }
    /**
     * Metodo que inicia sesión, poniendolo como usuario actual del sistema.
     * @param nombre: Atributo String de la cuenta a iniciar sesión.
     * @param contrasenna: Atributo String que representa la contraseña de la cuenta a iniciar sesión.
     * @return: Atributo true si se logra bien, si no lanza una excepción.
     * @throws MiExcepcion
     */
    public boolean iniciarSesion(String nombre, String contrasenna) throws MiExcepcion {
        if (!gestorUsuarios.verificarDatos(nombre, 1)) {
            throw new MiExcepcion(ICodigos.ERROR_USUARIO_INVALIDO);
        }
        if (!gestorUsuarios.verificarDatos(contrasenna, 2)) {
            throw new MiExcepcion(ICodigos.ERROR_CONTRASENNA_INVALIDA);
        }
        Usuario usuario = gestorUsuarios.buscarUsuario(nombre,contrasenna);
        gestorUsuarios.setUsuarioActual(usuario);
        return true;
    }
    /**
     * Metodo que guarda la información de todos los usuarios de la acplicación en un archivo binario.
     * @return : Retorna true si se guarda correctamente, si no lanza una excepción.
     * @throws MiExcepcion
     */
    public boolean guardarUsuarios() throws MiExcepcion {
        GestorArchivos gestor = new GestorArchivos();
        gestor.setListaUsuarios(gestorUsuarios.getListaUsuarios());
        gestor.guardarUsuarios("Usuarios.bin");
        return true;
    }
    /**
     * Metodo que carga la informacion de los usuarios de un archivo binario.
     * @return : Retorna true si se carga adecuadamente, si no lanza excepción.
     * @throws MiExcepcion
     */
    public boolean cargarUsuario() throws MiExcepcion {
        GestorArchivos gestor = new GestorArchivos();
        gestor.cargarUsuarios("Usuarios.bin");
        gestorUsuarios.setListaUsuarios(gestor.getListaUsuarios());
        return true;
    }
    /**
     * Metodo que procesa los valores obtenidos de la simulacion, y agrega un registroMetricas al historial del usuarioActual.
     * @throws MiExcepcion
     */
    public void procesarMetricas() throws MiExcepcion {
        Usuario usuarioActual = gestorUsuarios.getUsuarioActual();
        LocalDate fechaNueva = usuarioActual.getFechaUltRegistro().plusDays(1);
        RegistroMetricas registro = new RegistroMetricas();
        usuarioActual.setFechaUltRegistro(fechaNueva);
        registro.setFecha(fechaNueva);
        usuarioActual.getRecomendacionesDiarias().clear();

        for (Metrica metrica : usuarioActual.getMetricasDiarias()) {
            metrica.normalizarDatos();
            // Guardar copia de la métrica en el registro del día
            registro.getMetricasDiarias().add(metrica.clonar());
            // Generar recomendaciones basadas en esa métrica
            ArrayList<Recomendacion> recs = metrica.generarRecomendaciones();
            usuarioActual.getRecomendacionesDiarias().addAll(recs);
        }
        usuarioActual.getHistorial().add(registro);
    }
    /**
     * Metodo que muestra la información de las referencias de las 3 métricas medibles del sistema
     * @return: Retorna un ArrayList de elementos String, cada elemento siendo la descripcion de la métrica.
     * @throws MiExcepcion
     */
    public String mostrarReferenciasMetricas() {
        StringBuilder metricasDatos = new StringBuilder();
        metricasDatos.append(CantKilometros.obtenerDescripcion()).append("\n");
        metricasDatos.append(RitmoCardiaco.obtenerDescripcion()).append("\n");
        metricasDatos.append(HorasSuenno.obtenerDescripcion());
        return metricasDatos.toString();
    }
    /**
     * Metodo que crea las metas prediseñadas y las crea con sus parametros
     * @return
     */
    public ArrayList<Meta> obtenerMetasPredeterminadas() {
        ArrayList<Meta> metas = new ArrayList<>();
        metas.add(new Meta("Caminar 5 km al día", 5, new CantKilometros()));
        metas.add(new Meta("Dormir 8 horas", 8, new HorasSuenno()));
        metas.add(new Meta("Llegar a 100 latidos en ejercicio",100, new RitmoCardiaco()));
        return metas;
    }
    /**
     * Metodo que recibe un indice y busca con ese mismo una meta de las opciones de metas.
     * @param indiceMeta
     * @throws MiExcepcion
     */
    public void asignarMeta(int indiceMeta) throws MiExcepcion {
        Usuario usuarioActual = gestorUsuarios.getUsuarioActual();
        ArrayList<Meta> pred = obtenerMetasPredeterminadas();
        Meta elegida = pred.get(indiceMeta);
        usuarioActual.getMetasActivas().add(elegida);
    }
    /**
     * Metodo que obtiene el ultimo registro del historial y a partir de eso crea un String para ser exportado
     * a un archivo de texto para el profesional.
     * @throws MiExcepcion
     */
    public void exportarReporteParaProfesional() throws MiExcepcion {
        Usuario usuario = gestorUsuarios.getUsuarioActual();
        RegistroMetricas registro = obtenerRegistroDelDia();

        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte Clínico para profesional\n");
        reporte.append("Usuario: ").append(usuario.getNombre()).append("\n");
        reporte.append("Fecha del registro: ").append(registro.getFecha()).append("\n");
        reporte.append("\n-Métricas del día:\n");
        for (Metrica m : registro.getMetricasDiarias()) {
            reporte.append(" - ").append(m.getId())
                    .append(": ").append(m.getValorActual())
                    .append("\n");
        }
        GestorArchivos gestor = new GestorArchivos();
        gestor.guardarReporteProfesional("ReporteProfesional.ttx", reporte.toString());
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
        Usuario usuarioActual = gestorUsuarios.getUsuarioActual();
        RegistroMetricas registro = obtenerRegistroDelDia();

        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte Consolidado \n");
        reporte.append("Usuario: ").append(usuarioActual.getNombre()).append("\n");
        reporte.append("Fecha: ").append(registro.getFecha()).append("\n\n");
        reporte.append("--Métricas del día\n");
        for (Metrica m : registro.getMetricasDiarias()) {
            reporte.append(" - ").append(m.getId())
                    .append(": ").append(m.getValorActual()).append("\n");
        }
        if (!usuarioActual.getMetasActivas().isEmpty()) {
            reporte.append("\n--Metas activas\n");
            for (Meta meta : usuarioActual.getMetasActivas()) {
                meta.actualizarMeta();
                reporte.append(" - ").append(meta.getDescripcion())
                        .append(" (Progreso: ").append(meta.getPorcentaje()).append("%)\n");
            }
        }
        if (!usuarioActual.getRecomendacionesDiarias().isEmpty()) {
            reporte.append("\n--Recomendaciones\n");
            for (Recomendacion r : usuarioActual.getRecomendacionesDiarias()) {
                reporte.append(" -> ").append(r.getDescripcion()).append("\n");
            }
        }
        return reporte.toString();
    }
    /**
     * Metodo que muestra el historial de registroMetricas del usuario
     * @return : Retorna un String que es el historial generado.
     */
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
    
    /**
     * Metodo que muestra el historial de registroMetricas del usuario
     * @return : Retorna un String que es el historial generado.
     */
    public String Simulacion() {
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
