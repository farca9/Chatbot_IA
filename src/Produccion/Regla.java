package Produccion;

import NLP.Lema;

import java.util.ArrayList;
import java.util.List;

public class Regla {

    //Precondicion
    private Integer id;
    private List<Lema> lemasCondicion;
    private List<MTEntry> mtEntriesPresente;
    private List<MTEntry> mtEntriesAusente;

    //Consecuencia
    private List<MTEntry> mtEntriesConsecuencia;
    private String mensajeOutput;

    public int getEspecificidad(){
        return lemasCondicion.size()+mtEntriesPresente.size()+mtEntriesAusente.size();
    }

    public boolean cotejar(ArrayList<Lema> lemasInput){

        //TODO VER SI DEJAR CONTAINS O EQUALS

        //Primero se controla la verificacion entre los lemas que necesito y los que estan
        if(!lemasInput.containsAll(lemasCondicion)){
            return false;
        }

        ArrayList<MTEntry> MTCompleta = (ArrayList)MT.getInstance().getElementosMT();

        if(!MTCompleta.containsAll(mtEntriesPresente)){
            return false;
        }
        for(MTEntry mtEntry : mtEntriesAusente){
            if(MTCompleta.contains(mtEntry)){
                return false;
            }
        }

        return true;

    }

    public String execute(){

        for(MTEntry mtEntry : mtEntriesConsecuencia){
            MT.getInstance().add(mtEntry);
        }

        return mensajeOutput;
    }

}
