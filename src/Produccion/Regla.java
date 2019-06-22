package Produccion;

import NLP.Lema;

import java.util.List;

public class Regla {

    //Precondicion
    private Integer id;
    private List<Lema> lemasCondicion;
    private List<MTEntry> mtEntriesCondicion;

    //Consecuencia
    private List<MTEntry> mtEntriesConsecuencia;
    private String mensajeOutput;

    public int getEspecificidad(){
        return lemasCondicion.size()+mtEntriesCondicion.size();
    }
}
