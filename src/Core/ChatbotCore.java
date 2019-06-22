package Core;

public class ChatbotCore {

    //Singleton
    private static ChatbotCore instance = new ChatbotCore();

    public static ChatbotCore getInstance(){
        return instance;
    }

    private ChatbotCore(){}

    public String sendAndReceive(String input){

        //NLP -> Lemas

        //MT

        //MP

        return "testString";

    }

    public void clearChat(){
        //TODO Esta funcion deberia entre otras cosas borrar la memoria de trabajo
    }

}
