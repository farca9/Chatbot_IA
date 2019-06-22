package Modelo;

public class Televisor {

    private String codigoModelo;
    private String marca;
    private Double dimPantalla;
    private boolean isSmart;
    private String resolucion;
    private Double precio;

    public Televisor(String codigoModelo, String marca, Double dimPantalla, boolean isSmart, String resolucion, Double precio) {
        this.codigoModelo = codigoModelo;
        this.marca = marca;
        this.dimPantalla = dimPantalla;
        this.isSmart = isSmart;
        this.resolucion = resolucion;
        this.precio = precio;
    }

    public String getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(String codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getDimPantalla() {
        return dimPantalla;
    }

    public void setDimPantalla(Double dimPantalla) {
        this.dimPantalla = dimPantalla;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
