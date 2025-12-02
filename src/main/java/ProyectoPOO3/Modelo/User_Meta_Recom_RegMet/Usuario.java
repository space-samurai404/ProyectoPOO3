package ProyectoPOO3.Modelo.User_Meta_Recom_RegMet;
import ProyectoPOO3.Modelo.Wearables.Wearable;
import ProyectoPOO3.Modelo.Metricas.Metrica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Usuario implements Serializable {
    //Atributos de la clase Usuario
    private String nombre;
    private String contrasenna;
    private String correo;
    private ArrayList<Wearable> wearablesAsociados;
    private ArrayList<Meta> metasActivas;
    private ArrayList<RegistroMetricas> historial;
    private ArrayList<Recomendacion> recomendacionesDiarias;
    private ArrayList<Metrica> metricasDiarias;
    private LocalDate fechaUltRegistro;

    //Métodos de la clase Usuario
    //--Constructores
    public Usuario() {}
    public Usuario(String nombre, String contrasenna, String correo, ArrayList<Wearable> wereablesAsociados) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.correo = correo;
        this.wearablesAsociados = wereablesAsociados;
        this.fechaUltRegistro = LocalDate.of(2025,12,4);
        //Colecciones vacías del usuario al inicio
        this.metasActivas = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.recomendacionesDiarias = new ArrayList<>();
        this.metricasDiarias = new ArrayList<>();
        // Por cada wearable recibido, copiar sus métricas al usuario
        for (Wearable wearable : wearablesAsociados) {
            for (Metrica metrica : wearable.getMetricasAsociadas()) {
                // Si el usuario NO tiene esta métrica aún...
                if (!existeMetrica(metrica.getClass())) {
                    this.metricasDiarias.add(metrica.clonar());
                }
            }
        }
    }

    //--Getters y setters
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
    public ArrayList<Wearable> getWearablesAsociados() {
        return wearablesAsociados;
    }
    public void setWearablesAsociados(ArrayList<Wearable> wereablesAsociados) {this.wearablesAsociados = wereablesAsociados;}
    public ArrayList<Meta> getMetasActivas() {
        return metasActivas;
    }
    public void setMetasActivas(ArrayList<Meta> metasActivas) {
        this.metasActivas = metasActivas;
    }
    public ArrayList<RegistroMetricas> getHistorial() {return historial;}
    public void setHistorial(ArrayList<RegistroMetricas> registroMetricas) {this.historial = registroMetricas;}
    public ArrayList<Recomendacion> getRecomendacionesDiarias() {return recomendacionesDiarias;}
    public void setRecomendacionesDiarias(ArrayList<Recomendacion> recomendacionesDiarias) {this.recomendacionesDiarias = recomendacionesDiarias;}
    public ArrayList<Metrica> getMetricasDiarias() {return metricasDiarias;}
    public void setMetricasDiarias(ArrayList<Metrica> metricas) {
        this.metricasDiarias = new ArrayList<>();
        for (Metrica m : metricas) {
            this.metricasDiarias.add(m.clonar());
        }
    }
    public LocalDate getFechaUltRegistro() {return fechaUltRegistro;}
    public void setFechaUltRegistro(LocalDate fechaUltRegistro) {this.fechaUltRegistro = fechaUltRegistro;}

    //--Métodos especiales
    private boolean existeMetrica(Class<?> tipo) {
        for (Metrica m : this.metricasDiarias) {
            if (m.getClass().equals(tipo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contrasenna='" + contrasenna + '\'' +
                ", correo='" + correo + '\'' +
                ", wearablesAsociados=" + wearablesAsociados +
                ", metasActivas=" + metasActivas +
                ", historial=" + historial +
                ", recomendacionesDiarias=" + recomendacionesDiarias +
                ", metricasDiarias=" + metricasDiarias +
                ", fechaUltRegistro=" + fechaUltRegistro +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(contrasenna, usuario.contrasenna) && Objects.equals(correo, usuario.correo) && Objects.equals(wearablesAsociados, usuario.wearablesAsociados) && Objects.equals(metasActivas, usuario.metasActivas) && Objects.equals(historial, usuario.historial) && Objects.equals(recomendacionesDiarias, usuario.recomendacionesDiarias) && Objects.equals(metricasDiarias, usuario.metricasDiarias) && Objects.equals(fechaUltRegistro, usuario.fechaUltRegistro);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, contrasenna, correo, wearablesAsociados, metasActivas, historial, recomendacionesDiarias, metricasDiarias, fechaUltRegistro);
    }
}
