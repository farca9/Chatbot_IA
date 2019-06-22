package Produccion;

public class MTEntry {

    public String nombre;
    public Object value;

    public MTEntry(String nombre, Object value) {
        this.nombre = nombre;
        this.value = value;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
