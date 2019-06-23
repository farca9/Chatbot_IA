package Produccion;

import java.util.ArrayList;
import java.util.List;

public class MT {

    private List<MTEntry> elementosMT;

    //Singleton
    private static MT instance = new MT();
    public static MT getInstance(){
        return instance;
    }
    private MT(){
        elementosMT=new ArrayList<>();
    }
    //

    public void add(MTEntry mtEntry){
        if(!elementosMT.contains(mtEntry)){
            elementosMT.add(mtEntry);
        }
    }

    public List<MTEntry> getElementosMT() {
        return elementosMT;
    }

    public void clear(){
        elementosMT=new ArrayList<>();
    }

    public void setElementosMT(List<MTEntry> elementosMT) {
        this.elementosMT = elementosMT;
    }
}
