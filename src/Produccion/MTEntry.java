package Produccion;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTEntry mtEntry = (MTEntry) o;
        return Objects.equals(nombre, mtEntry.nombre) &&
                Objects.equals(value, mtEntry.value);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
