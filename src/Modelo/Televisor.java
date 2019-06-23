package Modelo;

import Produccion.MTEntry;

import java.util.List;

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

    public String getTamanioPantalla(){

        String resultado;

        if(dimPantalla <= 32.0) resultado = "pequenio";
        else if(dimPantalla > 55.0) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public String getClasePrecio(){

        String resultado;

        if(precio <= 12000.0) resultado = "pequenio";
        else if(precio > 35000.0) resultado = "grande";
        else resultado = "normal";

        return resultado;

    }

    public boolean filtrar(List<MTEntry> parametros) {
        boolean flag = true;
        int i = 0;

        while (flag && i < parametros.size()) {
            if (parametros.get(i).nombre.equals("marca")) {
                if (!parametros.get(i).value.toString().equals(marca.toLowerCase())) {
                    flag = false;
                }
            }

            if (parametros.get(i).nombre.equals("dimPantalla")) {
                if (!parametros.get(i).value.toString().equals(getTamanioPantalla())) {
                    flag = false;
                }
            }

            if (parametros.get(i).nombre.equals("tecnologia")) {
                if(isSmart()){
                    if (!parametros.get(i).value.toString().equals("smart")) {
                        flag = false;
                    }
                }
                else{
                    if (!parametros.get(i).value.toString().equals("led")) {
                        flag = false;
                    }
                }

            }

            if (parametros.get(i).nombre.equals("resolucion")) {
                if (!parametros.get(i).value.toString().equals(resolucion.toLowerCase())) {
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
