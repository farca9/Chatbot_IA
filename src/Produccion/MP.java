package Produccion;

import java.util.ArrayList;

public class MP {

    ArrayList<Regla> reglas;

    //Singleton
    private static MP instance = new MP();
    public static MP getInstance(){
        return instance;
    }
    private MP(){
        reglas=new ArrayList<>();
    }

    public void add(Regla regla){
        reglas.add(regla);
    }
    //



}
