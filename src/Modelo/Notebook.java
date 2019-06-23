package Modelo;

import Produccion.MTEntry;

import java.util.List;

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

    public String getTamanioPantalla(){

        String resultado;

        if(dimPantalla <= 14.0) resultado = "pequenio";
        else if(dimPantalla > 16.0) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public String getTamanioAlmacenamiento(){

        String resultado;

        switch(cantidadStorage){
            case "1 TB + 256 GB SSD": resultado = "grande"; break;
            case "1 TB + 128 GB SSD": resultado = "grande"; break;
            case "1 TB + 16 GB SSD": resultado = "grande"; break;
            case "1 TB": resultado = "normal"; break;
            case "512 GB": resultado = "normal"; break;
            case "512 GB SSD": resultado = "normal"; break;
            case "256 GB SSD": resultado = "pequenio"; break;
            case "128 GB SSD": resultado = "pequenio"; break;
            case "32 GB SSD": resultado = "pequenio"; break;
            default: resultado = "";
        }

        return resultado;

    }

    public String getTamanioRam(){

        String resultado;

        if(cantidadRam <= 4) resultado = "pequenio";
        else if(cantidadRam > 8) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public String getTipoGPU(){

        String resultado;

        if(gpu.contains("Intel") || gpu.contains("AMD")) resultado = "integrada";
        else resultado = "dedicada";

        return resultado;

    }

    public String getClasePrecio(){

        String resultado;

        if(precio <= 30000.0) resultado = "pequenio";
        else if(precio > 70000.0) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public boolean filtrar(List<MTEntry> parametros) {

        boolean flag = true;
        int i = 0;

        while (flag && i < parametros.size()) {

            if (parametros.get(i).nombre.equals("marca") && !parametros.get(i).value.toString().equals(this.marca)) flag = false;
            if (parametros.get(i).nombre.equals("cpu") && !parametros.get(i).value.toString().equals(this.procesador)) flag = false;
            if (parametros.get(i).nombre.equals("dimPantalla") && !parametros.get(i).value.toString().equals(this.getTamanioPantalla())) flag = false;
            if (parametros.get(i).nombre.equals("almacenamiento") && !parametros.get(i).value.toString().equals(this.getTamanioAlmacenamiento())) flag = false;
            if (parametros.get(i).nombre.equals("ram") && !parametros.get(i).value.toString().equals(this.getTamanioRam())) flag = false;
            if (parametros.get(i).nombre.equals("gpu") && !parametros.get(i).value.toString().equals(this.getTipoGPU())) flag = false;
            if (parametros.get(i).nombre.equals("precio") && !parametros.get(i).value.toString().equals(this.getClasePrecio())) flag = false;

            i++;
        }

        return flag;
    }

    public String toString(){

        return "MODELO: "+this.codigoModelo+"\nMARCA: "+this.marca+"\nPRECIO: $"+this.precio+"\n";

    }

}
