package Modelo;

public class Tablet {

    private String codigoModelo;
    private String marca;
    private Double dimPantalla;
    private Integer cantidadRam;
    private Integer cantidadStorage;
    private Double resolucionCamara;
    private Double precio;

    public Tablet(String codigoModelo, String marca, Double dimPantalla, Integer cantidadRam, Integer cantidadStorage, Double resolucionCamara, Double precio) {
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

    public Integer getCantidadRam() {
        return cantidadRam;
    }

    public void setCantidadRam(Integer cantidadRam) {
        this.cantidadRam = cantidadRam;
    }

    public Integer getCantidadStorage() {
        return cantidadStorage;
    }

    public void setCantidadStorage(Integer cantidadStorage) {
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
