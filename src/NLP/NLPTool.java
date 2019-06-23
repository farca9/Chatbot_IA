package NLP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NLPTool {

    private List<Lema> lemas;


    //Singleton
    private static NLPTool instance = new NLPTool();
    public static NLPTool getInstance(){
        return instance;
    }
    private NLPTool(){

        lemas = new ArrayList<>();

        //TODO AGREGAR LOS LEMAS MANUALMENTE, JUNTO CON SUS SINONIMOS
        // lemas.add("Bueno", new ArrayList("Copado","Piola","Buenisimo",...)
    }
    //

    public List<Lema> detectarLemas(String userInput){

        userInput = " "+userInput+" ";

        ArrayList<Lema> lemasDetectados = new ArrayList<>();

        for(Lema lema : lemas){
            if(lema.match(userInput)){
                lemasDetectados.add(lema);
            }
        }

        return lemasDetectados;
    }

    public List<Lema> getLemas() {
        return lemas;
    }
}
