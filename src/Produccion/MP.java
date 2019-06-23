package Produccion;

import NLP.Lema;

import java.util.ArrayList;
import java.util.Arrays;

public class MP {

    ArrayList<Regla> reglas;

    //Singleton
    private static MP instance = new MP();
    public static MP getInstance(){
        return instance;
    }
    private MP(){
        reglas=new ArrayList<>();

        Integer idp = 1;

        reglas.add(new Regla(
                idp
                ,new ArrayList<>(Arrays.asList(new Lema("Concepto"))) //Lista de lemas a cotejar
                ,new ArrayList<>(Arrays.asList((new MTEntry("nombre",123)))) //Lista de MTEntry presentes
                ,new ArrayList<>(Arrays.asList((new MTEntry("nombre",123)))) //Lista de MTEntry ausentes
                ,new ArrayList<>(Arrays.asList((new MTEntry("nombre",123)))) //Lista de MTEntry a agregar en la ejecucion
                ,"mensaje output") //Mensaje salida
        ); idp++;


    }

    public void add(Regla regla){
        reglas.add(regla);
    }

    public ArrayList<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(ArrayList<Regla> reglas) {
        this.reglas = reglas;
    }

    //



}
