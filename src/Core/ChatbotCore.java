package Core;

import NLP.NLPTool;

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
        output=nlp.detectarLemas(input).toString();

        //MT

        //MP

        return output;

    }

    public void clearChat(){
        //TODO Esta funcion deberia entre otras cosas borrar la memoria de trabajo
    }

}
