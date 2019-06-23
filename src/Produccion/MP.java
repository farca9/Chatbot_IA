package Produccion;

import NLP.Lema;

import java.util.ArrayList;
import java.util.Arrays;

public class MP {

    ArrayList<Regla> reglas;
    //id prioridad
    Integer idp = 1;


    //Singleton
    private static MP instance = new MP();
    public static MP getInstance(){
        return instance;
    }
    private MP(){
        reglas=new ArrayList<>();

        cargarReglas();


    }

    public void add(Regla regla){
        reglas.add(regla);
    }

    public ArrayList<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(ArrayList<Regla> reglas) {
        this.reglas = reglas;
    }

    public void cargarReglas(){
        cargarReglasGenerales();
        cargarReglasComputadoras();
        cargarReglasCelulares();

    }

    private void cargarReglasGenerales() {

        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"), new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"))),
                "Que producto esta buscando?")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "notebook"))),
                "Perfecto, buscaremos computadoras portatiles")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "celular"))),
                "Perfecto, buscaremos celulares")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "tablet"))),
                "Perfecto, buscaremos tablets")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "televisor"))),
                "Perfecto, buscaremos televisores")); idp++;




    }


    public void cargarReglasComputadoras(){

        //COMPUTADORA


        //////////////PREGUNTA INICIAL///////////////
        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //CPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                "Que procesador quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande o chica?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, poco o normal?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha o poca?")); idp++;


        //GPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"))),
                "Quiere GPU integrada o dedicada?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;



        //////////////OTRAS PREGUNTAS///////////////

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //CPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "cpu"))),
                "Que procesador quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande o chica?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho o poca?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha o poca?")); idp++;

        //GPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("ask", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "gpu"))),
                "Quiere GPU integrada o dedicada?")); idp++;


        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;



        //////////////REGLAS RESPUESTA///////////////

        //////MARCA//////

        //ACER
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("acer"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "acer"))),
                "Perfecto. Buscare marcas Acer")); idp++;

        //ASUS
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("asus"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "asus"))),
                "Perfecto. Buscare marcas Asus")); idp++;

        //EXO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "exo"))),
                "Perfecto. Buscare marcas Exo")); idp++;

        //HP
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("hp"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "hp"))),
                "Perfecto. Buscare marcas HP")); idp++;

        //LENOVO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lenovo"))),
                "Perfecto. Buscare marcas Lenovo")); idp++;

        //APPLE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "apple"))),
                "Perfecto. Buscare marcas Apple")); idp++;

        //BANGHO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("bangho"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "bangho"))),
                "Perfecto. Buscare marcas Bangho")); idp++;

        //DELL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("dell"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "dell"))),
                "Perfecto. Buscare marcas Dell")); idp++;


        //////PROCESADOR//////

        //i3
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i3"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i3"))),
                "Perfecto. Buscare procesadores i3")); idp++;

        //i5
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i5"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i5"))),
                "Perfecto. Buscare procesadores i5")); idp++;

        //i7
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i7"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i7"))),
                "Perfecto. Buscare procesadores i7")); idp++;

        //ATOM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("atom"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "atom"))),
                "Perfecto. Buscare procesadores Atom")); idp++;

        //CELERON
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celeron"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "celeron"))),
                "Perfecto. Buscare procesadores Celeron")); idp++;

        //A6
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("a6"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "a6"))),
                "Perfecto. Buscare procesadores A6")); idp++;


        //////PANTALLA//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Perfecto. Buscare pantalla grande")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Perfecto. Buscare pantalla normal")); idp++;


        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Perfecto. Buscare pantalla pequeño")); idp++;


        //////ALMACENAMIENTO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Perfecto. Buscare con mucho almacenamiento")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Perfecto. Buscare con almacenamiento normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Perfecto. Buscare con poco almacenamiento")); idp++;


        //////RAM//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Perfecto. Buscare con mucha RAM")); idp++;

        //MEDIANO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Perfecto. Buscare con RAM normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Perfecto. Buscare con poca RAM")); idp++;


        //////GPU//////

        //INTEGRADA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("integrada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "integrada"))),
                "Perfecto. Buscare con gpu integrada")); idp++;

        //DEDICADA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("dedicada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "dedicada"))),
                "Perfecto. Buscare con gpu dedicada")); idp++;



        //////PRECIO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Perfecto. Buscare con precios altos")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Perfecto. Buscare con precios medianos")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Perfecto. Buscare con precios bajos")); idp++;
    }

    public void cargarReglasCelulares(){
        //CELULARES

        //////////////PREGUNTA INICIAL///////////////

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande o chica?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha o poca?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, poco o normal?")); idp++;


        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("camara"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"))),
                "Quiere la camara con alta o baja resolucion?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;

        //////////////OTRAS PREGUNTAS///////////////

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande o chica?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho o poco?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha o poca?")); idp++;

        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("ask", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"))),
                "Quiere la camara con alta o baja resolucion?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;



        //////////////REGLAS RESPUESTA///////////////

        //////MARCA//////

        //SAMSUNG
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "samsung"))),
                "Perfecto. Buscare marcas Samsung")); idp++;

        //MOTOROLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("motorola"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "motorola"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "motorola"))),
                "Perfecto. Buscare marcas Motorola")); idp++;

        //LG
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lg"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lg"))),
                "Perfecto. Buscare marcas LG")); idp++;

        //ALCATEL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "alcatel"))),
                "Perfecto. Buscare marcas Alcatel")); idp++;

        //APPLE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "apple"))),
                "Perfecto. Buscare marcas Apple")); idp++;

         //GOOGLE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("google"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "google"))),
                "Perfecto. Buscare marcas Google")); idp++;



        //////PANTALLA//////
        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Perfecto. Buscare pantalla grande")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Perfecto. Buscare pantalla normal")); idp++;


        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Perfecto. Buscare pantalla pequeño")); idp++;


        //////RAM//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Perfecto. Buscare con mucha RAM")); idp++;

        //MEDIANO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Perfecto. Buscare con RAM normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Perfecto. Buscare con poca RAM")); idp++;


        //////ALMACENAMIENTO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Perfecto. Buscare con mucho almacenamiento")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Perfecto. Buscare con almacenamiento normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Perfecto. Buscare con poco almacenamiento")); idp++;


        //////RES CAMARA//////

        //ALTA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "grande"))),
                "Perfecto. Buscare con alta resolucion")); idp++;

        //BAJA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "pequenio"))),
                "Perfecto. Buscare con baja resolucion")); idp++;

        //////PRECIO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Perfecto. Buscare con precios altos")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Perfecto. Buscare con precios medianos")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Perfecto. Buscare con precios bajos")); idp++;


                
    }

    //



}
