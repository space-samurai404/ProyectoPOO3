package ProyectoPOO3.Modelo.User_Meta_Recom_RegMet;
import ProyectoPOO3.Modelo.Metricas.Metrica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Meta implements Serializable {
    //Atributos de la clase Meta
    private String descripcion;
    private double porcentaje;
    private double meta;
    private Metrica metricaAsignada;

    //Métodos de la clase Meta
    //--Constructor y getters-setters
    public Meta() {}
    public Meta(String descripcion, double meta, Metrica metricaAsignada) {
        this.descripcion = descripcion;
        this.meta = meta;
        this.metricaAsignada = metricaAsignada;
        this.porcentaje = 0;
    }
    public Meta(Meta original, ArrayList<Metrica> metricasDelUsuario) {
        this.descripcion = original.descripcion;
        this.meta = original.meta;
        this.porcentaje = 0;

        // Debe enlazar a la métrica del usuario, NO la predeterminada
        this.metricaAsignada = buscarMetricaCorrespondiente(
                original.metricaAsignada.getClass(),
                metricasDelUsuario
        );
    }


    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
    public Metrica getMetricaAsignada() {
        return metricaAsignada;
    }
    public void setMetricaAsignada(Metrica metricaCorrespondiente) {
        this.metricaAsignada = metricaCorrespondiente;
    }
    public double getMeta() {return meta;}
    public void setMeta(double meta) {this.meta = meta;}

    //--Metodos especiales
    public void actualizarMeta() {
        if (metricaAsignada != null && meta > 0) {
            double progreso = metricaAsignada.getValorActual() / meta;
            if (progreso > 1.0) progreso = 1.0;
            this.porcentaje = progreso * 100;   // <-- AQUÍ !!!
        }
    }
    private Metrica buscarMetricaCorrespondiente(Class<?> tipo, ArrayList<Metrica> metricas) {
        for (Metrica m : metricas) {
            if (m.getClass().equals(tipo)) return m;
        }
        return null; // si no la encuentra
    }



    @Override
    public String toString() {
        return "Meta{" +
                "descripcion='" + descripcion + '\'' +
                ", porcentaje=" + porcentaje +
                ", meta=" + meta +
                ", metricaAsignada=" + metricaAsignada +
                '}';
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta1 = (Meta) o;
        return Double.compare(porcentaje, meta1.porcentaje) == 0 && Double.compare(meta, meta1.meta) == 0 && Objects.equals(descripcion, meta1.descripcion) && Objects.equals(metricaAsignada, meta1.metricaAsignada);
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(descripcion, porcentaje, meta, metricaAsignada);
    }
}
