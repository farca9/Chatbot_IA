package Modelo;

import Produccion.MTEntry;

import java.util.List;

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

    public String getTamanioPantalla(){

        String resultado;

        if(dimPantalla <= 7.0) resultado = "pequenio";
        else if(dimPantalla > 10.0) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public String getTamanioRam(){

        String resultado;

        if(cantidadRam <= 1) resultado = "pequenio";
        else if(cantidadRam > 2) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public String getTamanioAlmacenamiento(){

        String resultado;

        if(cantidadStorage <= 8) resultado = "pequenio";
        else if(cantidadStorage > 16) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public String getResolucionMP(){

        String resultado;

        if(resolucionCamara <= 2.0) resultado = "pequenio";
        else if(resolucionCamara > 6) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public String getClasePrecio(){

        String resultado;

        if(precio <= 3000.0) resultado = "pequenio";
        else if(precio > 8000.0) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public boolean filtrar(List<MTEntry> parametros) {
        boolean flag = true;
        int i = 0;

        while (flag && i < parametros.size()) {
            if (parametros.get(i).nombre.equals("marca")) {
                if (!parametros.get(i).value.toString().equals(marca)) {
                    flag = false;
                }
            }

            if (parametros.get(i).nombre.equals("dimPantalla")) {
                if (!parametros.get(i).value.toString().equals(getTamanioPantalla())) {
                    flag = false;
                }
            }

            if (parametros.get(i).nombre.equals("ram")) {
                if (!parametros.get(i).value.toString().equals(getTamanioRam())) {
                    flag = false;
                }
            }

            if (parametros.get(i).nombre.equals("almacenamiento")) {
                if (!parametros.get(i).value.toString().equals(getTamanioAlmacenamiento())) {
                    flag = false;
                }
            }

            if (parametros.get(i).nombre.equals("camara")) {
                if (!parametros.get(i).value.toString().equals(getResolucionMP())) {
                    flag = false;
                }
            }

            if (parametros.get(i).nombre.equals("precio")) {
                if (!parametros.get(i).value.toString().equals(getClasePrecio())) {
                    flag = false;
                }
            }
            i++;
        }

        return flag;
    }

    public String toString(){
        return "\nMODELO: " + codigoModelo + "\nMARCA: " + marca + "\nPRECIO: $" + precio + "\n";
    }

}
