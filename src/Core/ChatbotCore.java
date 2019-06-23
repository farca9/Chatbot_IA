package Core;

import Exceptions.NoLemasException;
import Exceptions.NoRulesException;
import Modelo.Celular;
import Modelo.Notebook;
import Modelo.Tablet;
import Modelo.Televisor;
import NLP.Lema;
import NLP.NLPTool;
import Produccion.MP;
import Produccion.MT;
import Produccion.MTEntry;
import Produccion.Regla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatbotCore {

    private Regla reglaPrevia=null;

    //Singleton
    private static ChatbotCore instance = new ChatbotCore();
    public static ChatbotCore getInstance(){
        return instance;
    }
    private ChatbotCore(){}

    public static String generarNoComprendo() {

        ArrayList<String> s = new ArrayList<>();

        s.add("Perdon, no te entiendo");
        s.add("Podrias intentar de nuevo?");
        s.add("No pude comprender tu respuesta");
        s.add("Podrias tratar de responderme de otra forma?");
        s.add("Lo siento, no pude interpretar tu respuesta");
        s.add("Necesito que me respondas de otra forma");
        s.add("Me es dificil entender lo que quisiste decir");
        s.add("Vuelva a epxlicarse por favor");
        s.add("Podria hablar mas claramente?");

        return s.get(new Random(System.currentTimeMillis()).nextInt(s.size()));

    }
    //

    public String hacerRecomendacion(){

        //Cuando el cliente presiona el boton de recomendar resultados
        //Se asume que cuanto mucho se ofrecen 3 productos
        List<MTEntry> mt = MT.getInstance().getElementosMT();
        /*List<Notebook> notebookResults = new ArrayList<Notebook>();
        List<Celular> celularResults = new ArrayList<Celular>();
        List<Tablet> tabletResults = new ArrayList<Tablet>();
        List<Televisor> televisorResults = new ArrayList<Televisor>();*/
        DB dbInstance = DB.getInstance();
        String results = "RESULTADOS:\n==========\n";

        if(mt.contains(new MTEntry("tipoProducto","notebook"))) {

            for(Notebook n : dbInstance.getNotebookList()){
                if(n.filtrar(mt)) results += n.toString();
            }

        }
        else if(mt.contains(new MTEntry("tipoProducto","celular"))) {

            for(Celular n : dbInstance.getCelularList()){
                if(n.filtrar(mt)) results += n.toString();
            }

        }
        else if (mt.contains(new MTEntry("tipoProducto","tablet"))) {

            for(Tablet n : dbInstance.getTabletList()){
                if(n.filtrar(mt)) results += n.toString();
            }

        }
        else if (mt.contains(new MTEntry("tipoProducto","televisor"))) {

            for(Televisor n : dbInstance.getTelevisorList()){
                if(n.filtrar(mt)) results += n.toString();
            }



        }
        else {

            return "Lo lamento, no he podido encontrar ningun resultado";
        }

        return "asd";
    }

    public String sendAndReceive(String input) throws NoRulesException, NoLemasException {

        String output="";
        //NLP -> Lemas
        NLPTool nlp = NLPTool.getInstance();
        List<Lema> lemasDetectados=nlp.detectarLemas(input);
        if(lemasDetectados.isEmpty()){
            throw new NoLemasException();
        }


        //Cotejo
        List<Regla> reglasActivas=new ArrayList<>();
        for(Regla regla : MP.getInstance().getReglas()){
            if(regla.cotejar((ArrayList)lemasDetectados)){
                reglasActivas.add(regla);
            }
        }

        if(reglasActivas.isEmpty()){
            throw new NoRulesException();
        }

        System.out.println("Reglas activas:");
        for(Regla r: reglasActivas) {
            System.out.println(r.toString());
        }

        //Resolucion de conflictos
        Regla reglaSeleccionada = this.solveConflict(reglasActivas);
        System.out.println("Regla seleccionada: "+reglaSeleccionada.toString());

        //Ejecucion
        output=reglaSeleccionada.execute();

        return output;

    }

    public String innerSendAndReceive () throws NoRulesException {

        String output="";

        //Cotejo
        List<Regla> reglasActivas=new ArrayList<>();
        for(Regla regla : MP.getInstance().getReglas()){
            if(regla.cotejar(new ArrayList<>())){
                reglasActivas.add(regla);
            }
        }

        if(reglasActivas.isEmpty()){
            throw new NoRulesException();
        }

        System.out.println("Inner Reglas activas:");
        for(Regla r: reglasActivas) {
            System.out.println(r.toString());
        }

        //Resolucion de conflictos
        Regla reglaSeleccionada = this.solveConflict(reglasActivas);
        System.out.println("Inner Regla seleccionada: "+reglaSeleccionada.toString());

        //Ejecucion
        output=reglaSeleccionada.execute();

        return output;

    }

    private Regla solveConflict(List<Regla> reglasActivas) {

        List<Regla> aux1=new ArrayList<>();
        List<Regla> aux2=new ArrayList<>();

        //No duplicacion
        for (Regla r: reglasActivas){
            if(!r.equals(reglaPrevia)){
                aux1.add(r);
            }
        }

        //Especifidad
        int maximaEspecificidad=0;
        for(Regla r: aux1){ //Se obtiene cual es la especificidad maxima
            if(r.getEspecificidad()>maximaEspecificidad){
                maximaEspecificidad = r.getEspecificidad();
            }
        }
        for(Regla r:aux1){ //Se queda con las reglas mas especificas
            if(r.getEspecificidad()==maximaEspecificidad){
                aux2.add(r);
            }
        }

        aux1=aux2;
        aux2=new ArrayList<>();

        //Novedad
        ArrayList<MTEntry> mt = (ArrayList)MT.getInstance().getElementosMT();
        for(MTEntry mtEntry : mt){
            for(Regla r: aux1){
                if(r.getMtEntriesPresente().contains(mtEntry)){
                    aux2.add(r);
                }
            }
            if(!aux2.isEmpty()){
                break;
            }
        }
        if(!aux2.isEmpty()){
            aux1=aux2;
            aux2=new ArrayList<>();
        }

        //Prioridad
        /*int candidatePriority=Integer.MAX_VALUE;
        for(Regla r: aux1){
            if(r.getId()<candidatePriority){
                candidatePriority=r.getId().intValue();
                aux2=new ArrayList<>();
                aux2.add(r);
            } else if (r.getId()==candidatePriority){
                aux2.add(r);
            } else {
                //Se descarta por tener prioridad menos relevante que alguna otra regla
            }
        }

        aux1=aux2;
        */


        if(aux1.isEmpty()) return null;

        //Aleatorio
        return aux1.get(new Random().nextInt(aux1.size()));
    }

    public void clearChat(){
        MT.getInstance().clear();
    }



}
