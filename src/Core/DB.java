package Core;

import Modelo.*;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private List<Notebook> notebookList;
    private List<Celular> celularList;
    private List<Tablet> tabletList;
    private List<Televisor> televisorList;

    //Singleton
    private static DB instance = new DB();
    public static DB getInstance(){
        return instance;
    }
    private DB(){

        //TODO VER SI CARGAR MANUALMENTE TODO O TRATAR DE EXPORTAR CON EXCEL (mejor a mano)

        notebookList = new ArrayList<>();
        celularList = new ArrayList<>();
        tabletList = new ArrayList<>();
        televisorList = new ArrayList<>();
    }
    //





}
