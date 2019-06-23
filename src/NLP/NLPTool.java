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

        lemas.add(new Lema("notebook", new ArrayList<>(Arrays.asList("computadora","ordenador","laptop","portatil", "compu"))));
        lemas.add(new Lema("celular", new ArrayList<>(Arrays.asList("smartphone","telefono","movil"))));
        lemas.add(new Lema("tablet", new ArrayList<>(Arrays.asList("tableta"))));
        lemas.add(new Lema("televisor", new ArrayList<>(Arrays.asList("tv","television"))));

        lemas.add(new Lema("marca", new ArrayList<>(Arrays.asList("samsung","motorola","lg","alcatel","apple","google","huawei","acer","asus","exo","hp","lenovo","apple","bangho","dell","next technologies","next","philco","ion","tcl","kanju","viewsonic","xview","bgh","hisense","ken brown","noblex","philips","tcl"))));
        lemas.add(new Lema("acer", new ArrayList<>(Arrays.asList(" acer "))));
        lemas.add(new Lema("alcatel", new ArrayList<>(Arrays.asList(" alcatel "))));
        lemas.add(new Lema("apple", new ArrayList<>(Arrays.asList(" apple "))));
        lemas.add(new Lema("asus", new ArrayList<>(Arrays.asList(" asus "))));
        lemas.add(new Lema("bangho", new ArrayList<>(Arrays.asList(" bangho "))));
        lemas.add(new Lema("bgh", new ArrayList<>(Arrays.asList(" bgh "))));
        lemas.add(new Lema("dell", new ArrayList<>(Arrays.asList(" dell "))));
        lemas.add(new Lema("exo", new ArrayList<>(Arrays.asList(" exo "))));
        lemas.add(new Lema("google", new ArrayList<>(Arrays.asList(" google "))));
        lemas.add(new Lema("hisense", new ArrayList<>(Arrays.asList(" hisense "))));
        lemas.add(new Lema("hp", new ArrayList<>(Arrays.asList(" hp "))));
        lemas.add(new Lema("huawei", new ArrayList<>(Arrays.asList(" huawei "))));
        lemas.add(new Lema("ion", new ArrayList<>(Arrays.asList(" ion "))));
        lemas.add(new Lema("kanju", new ArrayList<>(Arrays.asList(" kanju "))));
        lemas.add(new Lema("ken brown", new ArrayList<>(Arrays.asList(" ken brown "))));
        lemas.add(new Lema("lenovo", new ArrayList<>(Arrays.asList(" lenovo "))));
        lemas.add(new Lema("lg", new ArrayList<>(Arrays.asList(" lg "))));
        lemas.add(new Lema("motorola", new ArrayList<>(Arrays.asList(" motorola "))));
        lemas.add(new Lema("next technologies", new ArrayList<>(Arrays.asList(" next technologies "))));
        lemas.add(new Lema("next", new ArrayList<>(Arrays.asList(" next "))));
        lemas.add(new Lema("noblex", new ArrayList<>(Arrays.asList(" acer "))));
        lemas.add(new Lema("philco", new ArrayList<>(Arrays.asList(" philco "))));
        lemas.add(new Lema("philips", new ArrayList<>(Arrays.asList(" philips "))));
        lemas.add(new Lema("samsung", new ArrayList<>(Arrays.asList(" samsung "))));
        lemas.add(new Lema("tcl", new ArrayList<>(Arrays.asList(" tcl "))));
        lemas.add(new Lema("viewsonic", new ArrayList<>(Arrays.asList(" viewsonic "))));
        lemas.add(new Lema("xview", new ArrayList<>(Arrays.asList(" xview "))));

        lemas.add(new Lema("procesador", new ArrayList<>(Arrays.asList("cpu","intel","amd"))));
        lemas.add(new Lema("i3", new ArrayList<>(Arrays.asList("intel i3"))));
        lemas.add(new Lema("i5", new ArrayList<>(Arrays.asList("intel i5"))));
        lemas.add(new Lema("i7", new ArrayList<>(Arrays.asList("intel i7"))));
        lemas.add(new Lema("atom", new ArrayList<>(Arrays.asList("intel atom"))));
        lemas.add(new Lema("celeron", new ArrayList<>(Arrays.asList("intel celeron"))));
        lemas.add(new Lema("a6", new ArrayList<>(Arrays.asList("amd a6"))));

        lemas.add(new Lema("pantalla", new ArrayList<>(Arrays.asList("screen"))));
        lemas.add(new Lema("almacenamiento", new ArrayList<>(Arrays.asList("storage","disco","memoria fisica", "ssd"))));
        lemas.add(new Lema("ram", new ArrayList<>(Arrays.asList("ram"))));
        lemas.add(new Lema("precio", new ArrayList<>(Arrays.asList("gastar","presupuesto","monto","estiro","gasto","$"))));
        lemas.add(new Lema("camara", new ArrayList<>(Arrays.asList("resolucion camara"))));
        lemas.add(new Lema("grande", new ArrayList<>(Arrays.asList("gran","amplia","larga","extensa","mucho","alto","abundante","bastante","alta","ilimitado", "mucha", "gigante"))));
        lemas.add(new Lema("normal", new ArrayList<>(Arrays.asList("media","normal","estandar","promedio","regular","medio"))));
        lemas.add(new Lema("pequenio", new ArrayList<>(Arrays.asList("pequeña","pequeño","reducida","limitado","escaso","corta","economica","barata","economico","barato", "poca", "limitada","escasa", "poco", "no grande", "pequenia", "pequenio"))));

        lemas.add(new Lema("gpu", new ArrayList<>(Arrays.asList("placa de video","graficas"))));
        lemas.add(new Lema("integrada", new ArrayList<>(Arrays.asList("intel graphics","amd"))));
        lemas.add(new Lema("dedicada", new ArrayList<>(Arrays.asList("nvidia","geforce"," ati "))));

        lemas.add(new Lema("tecnologia",new ArrayList<>(Arrays.asList("smart","led"))));
        lemas.add(new Lema("smart", new ArrayList<>(Arrays.asList("smart","inteligente"))));
        lemas.add(new Lema("led", new ArrayList<>(Arrays.asList("led", "lcd"))));

        lemas.add(new Lema("resolucion",new ArrayList<>(Arrays.asList("pixelado"))));
        lemas.add(new Lema("fhd", new ArrayList<>(Arrays.asList("full hd","full"))));
        lemas.add(new Lema("uhd", new ArrayList<>(Arrays.asList("ultra hd","4k"))));
        lemas.add(new Lema("hd", new ArrayList<>(Arrays.asList("hd"))));
        
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
