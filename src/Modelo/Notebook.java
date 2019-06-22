package Modelo;

public class Notebook {

    private String codigoModelo;
    private String marca;
    private String procesador;
    private String marcaProcesador;
    private Double dimPantalla;
    private String cantidadStorage; //Solo numero sin tipo
    private Integer cantidadRam;
    private String gpu;
    private Double precio;

    public Notebook(String codigoModelo, String marca, String procesador, String marcaProcesador, Double dimPantalla, String cantidadStorage, Integer cantidadRam, String gpu, Double precio) {
        this.codigoModelo = codigoModelo;
        this.marca = marca;
        this.procesador = procesador;
        this.marcaProcesador = marcaProcesador;
        this.dimPantalla = dimPantalla;
        this.cantidadStorage = cantidadStorage;
        this.cantidadRam = cantidadRam;
        this.gpu = gpu;
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

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getMarcaProcesador() {
        return marcaProcesador;
    }

    public void setMarcaProcesador(String marcaProcesador) {
        this.marcaProcesador = marcaProcesador;
    }

    public Double getDimPantalla() {
        return dimPantalla;
    }

    public void setDimPantalla(Double dimPantalla) {
        this.dimPantalla = dimPantalla;
    }

    public String getCantidadStorage() {
        return cantidadStorage;
    }

    public void setCantidadStorage(String cantidadStorage) {
        this.cantidadStorage = cantidadStorage;
    }

    public Integer getCantidadRam() {
        return cantidadRam;
    }

    public void setCantidadRam(Integer cantidadRam) {
        this.cantidadRam = cantidadRam;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
