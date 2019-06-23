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

    public Regla(Integer id, List<Lema> lemasCondicion, List<MTEntry> mtEntriesPresente, List<MTEntry> mtEntriesAusente, List<MTEntry> mtEntriesConsecuencia, String mensajeOutput) {
        this.id = id;
        this.lemasCondicion = lemasCondicion;
        this.mtEntriesPresente = mtEntriesPresente;
        this.mtEntriesAusente = mtEntriesAusente;
        this.mtEntriesConsecuencia = mtEntriesConsecuencia;
        this.mensajeOutput = mensajeOutput;
    }

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

    public List<MTEntry> getMtEntriesPresente() {
        return mtEntriesPresente;
    }

    @Override
    public String toString() {
        String retorno="";
        retorno+="R#"+id+" [";
        boolean e1=true, e2=true, e3=true, e4=true;
        for(Lema l: lemasCondicion){
            retorno+=l.getConcepto()+", ";
            e1=false;
        }
        if(!e1) retorno=retorno.substring(0,retorno.length()-2);
        retorno+="] <";
        for(MTEntry mtEntry: mtEntriesPresente){
            retorno+=mtEntry.toString()+", ";
            e2=false;
        }
        if(!e2)retorno=retorno.substring(0,retorno.length()-2);
        for(MTEntry mtEntry: mtEntriesAusente){
            retorno+="!"+mtEntry.toString()+", ";
            e3=false;
        }
        if(!e3)retorno=retorno.substring(0,retorno.length()-2);
        retorno+="> --> <";
        for(MTEntry mtEntry: mtEntriesConsecuencia){
            retorno+=mtEntry.toString()+", ";
            e4=false;
        }
        if(!e4)retorno=retorno.substring(0,retorno.length()-2);
        retorno+="> '"+mensajeOutput+"'";
        return retorno;


    }

    public Integer getId() {
        return id;
    }
}
