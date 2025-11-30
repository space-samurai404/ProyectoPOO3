package ProyectoPOO3.Modelo.User_Meta_Recom_RegMet;
import ProyectoPOO3.Modelo.Metricas.Metrica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class RegistroMetricas implements Serializable {
    //Atributos de la clase RegistroMetricas
    private ArrayList<Metrica> metricasDiarias;
    private LocalDate fecha;

    //Métodos de la clase RegistroMetricas
    //--Constructores y getters-setters
    public RegistroMetricas() {}
    public RegistroMetricas(ArrayList<Metrica> metricasDiarias, LocalDate fecha) {
        this.metricasDiarias = metricasDiarias;
        this.fecha = fecha;
    }
    public ArrayList<Metrica> getMetricasDiarias() {
        return metricasDiarias;
    }
    public void setMetricasDiarias(ArrayList<Metrica> metricasDiarias) {
        this.metricasDiarias = metricasDiarias;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "RegistroMetricas{" +
                "metricasDiarias=" + metricasDiarias +
                ", fecha=" + fecha +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RegistroMetricas that = (RegistroMetricas) o;
        return Objects.equals(metricasDiarias, that.metricasDiarias) && Objects.equals(fecha, that.fecha);
    }
    @Override
    public int hashCode() {
        return Objects.hash(metricasDiarias, fecha);
    }
}
