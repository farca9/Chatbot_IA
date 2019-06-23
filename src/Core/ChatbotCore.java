package Core;

import NLP.Lema;
import NLP.NLPTool;
import Produccion.MP;
import Produccion.Regla;

import java.util.ArrayList;
import java.util.List;

public class ChatbotCore {

    //Singleton
    private static ChatbotCore instance = new ChatbotCore();
    public static ChatbotCore getInstance(){
        return instance;
    }
    private ChatbotCore(){}
    //

    public String sendAndReceive(String input){

        String output="";
        //NLP -> Lemas
        NLPTool nlp = NLPTool.getInstance();
        List<Lema> lemasDetectados=nlp.detectarLemas(input);

        //Cotejo
        List<Regla> reglasActivas=new ArrayList<>();
        for(Regla regla : MP.getInstance().getReglas()){
            if(regla.cotejar((ArrayList)lemasDetectados)){
                reglasActivas.add(regla);
            }
        }

        System.out.println(reglasActivas);

        //Resolucion de conflictos

        //Ejecucion


        return output;

    }

    public void clearChat(){
        //TODO Esta funcion deberia entre otras cosas borrar la memoria de trabajo
    }

}
