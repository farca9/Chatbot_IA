package Modelo;

public class Celular {

    private String codigoModelo;
    private String marca;
    private Double dimPantalla;
    private Double cantidadRam;
    private Double cantidadStorage;
    private Double resolucionCamara;
    private Double precio;

    public Celular(String codigoModelo, String marca, Double dimPantalla, Double cantidadRam, Double cantidadStorage, Double resolucionCamara, Double precio) {
        this.codigoModelo = codigoModelo;
        this.marca = marca;
        this.dimPantalla = dimPantalla;
        this.cantidadRam = cantidadRam;
        this.cantidadStorage = cantidadStorage;
        this.resolucionCamara = resolucionCamara;
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

    public Double getCantidadRam() {
        return cantidadRam;
    }

    public void setCantidadRam(Double cantidadRam) {
        this.cantidadRam = cantidadRam;
    }

    public Double getCantidadStorage() {
        return cantidadStorage;
    }

    public void setCantidadStorage(Double cantidadStorage) {
        this.cantidadStorage = cantidadStorage;
    }

    public Double getResolucionCamara() {
        return resolucionCamara;
    }

    public void setResolucionCamara(Double resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
