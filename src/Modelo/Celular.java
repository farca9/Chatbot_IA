package Modelo;

//TODO para todos las clases de modelo habria que definir metodos boolean como isMuchaRam, hardcodeado segun el numero

public class Celular {

    private String codigoModelo;
    private String marca;
    private Double dimPantalla;
    private Integer cantidadRam;
    private Integer cantidadStorage;
    private Integer resolucionCamara;
    private Double precio;

    public Celular(String codigoModelo, String marca, Double dimPantalla, Integer cantidadRam, Integer cantidadStorage, Integer resolucionCamara, Double precio) {
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

    public Integer getResolucionCamara() {
        return resolucionCamara;
    }

    public void setResolucionCamara(Integer resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
