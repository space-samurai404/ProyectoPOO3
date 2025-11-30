package ProyectoPOO3.Modelo.Metricas;
import java.io.Serializable;
import java.util.Objects;

public abstract class Metrica implements IRecomendaciones, Serializable {
    //Atributos de la clase Metrica
    protected String id;
    protected double valorActual;

    //Métodos de la clase Metrica
    //--Constructores
    public Metrica() {}
    public Metrica(String id) {
        this.id = id;
        this.valorActual = 0;
    }

    //--Getters y setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getValorActual() {
        return valorActual;
    }
    public void setValorActual(double valorActual) {
        this.valorActual = valorActual;
    }

    //--Métodos especiales
    public abstract Metrica clonar();
    public abstract void normalizarDatos();

    @Override
    public String toString() {
        return "Metrica{" +
                "id='" + id + '\'' +
                ", valorActual=" + valorActual +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Metrica metrica = (Metrica) o;
        return Double.compare(valorActual, metrica.valorActual) == 0 && Objects.equals(id, metrica.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, valorActual);
    }

}
