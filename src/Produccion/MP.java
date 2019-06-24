package Produccion;

import Core.ChatbotCore;
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

    private void cargarReglasVendedor() {
        cargarReglasComputadorasVendedor();
        cargarReglasCelularesVendedor();
        cargarReglasTabletsVendedor();
        cargarReglasTelevisoresVendedor();
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
        cargarReglasTablets();
        cargarReglasTelevisores();
        cargarReglasVendedor();

    }

    private void cargarReglasGenerales() {

        //Primera, pregunta si es cliente o vendedor
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "user"), new MTEntry("ans", "user"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "user"))),
                "Es usted cliente o vendedor?")); idp++;

        //Respuesta, es vendedor o cliente
        //Cliente input
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "user"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "user"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                "Bienvenido cliente")); idp++;
        //Cliente inner
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("user","cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"), new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tipoProducto"))),
                "Que producto esta buscando?")); idp++;

        //Vendedor input
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "user"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "user"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                "Bienvenido vendedor")); idp++;

        //Vendedor inner
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend","in"))),
                new ArrayList<>(),
                "Ingrese que tipo de producto busca y con que caracteristica en particular")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user","cliente"), new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "notebook"))),
                "Perfecto, buscaremos computadoras portatiles")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user","cliente"), new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "celular"))),
                "Perfecto, buscaremos celulares")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user","cliente"), new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "tablet"))),
                "Perfecto, buscaremos tablets")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user","cliente"), new MTEntry("ask", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tipoProducto"), new MTEntry("tipoProducto", "televisor"))),
                "Perfecto, buscaremos televisores")); idp++;

    }

    public void cargarReglasComputadoras(){

        //COMPUTADORA


        //////////////PREGUNTA INICIAL///////////////
        //MARCA
        /*reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //CPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("tipoProducto", null), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                "Que procesador quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("tipoProducto", null), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("tipoProducto", null), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, poco o normal?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("tipoProducto", null), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha, normal o poca?")); idp++;


        //GPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("tipoProducto", null), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"))),
                "Quiere GPU integrada o dedicada?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("tipoProducto", null), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar? Mucho o poco?")); idp++;

*/

        //////////////OTRAS PREGUNTAS///////////////

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //CPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "cpu"))),
                "Que procesador quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, regular o poca?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha, mediana o poca?")); idp++;

        //GPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("ask", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "gpu"))),
                "Quiere GPU integrada o dedicada?")); idp++;


        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar? Mucho o poco?")); idp++;



        //////////////REGLAS RESPUESTA///////////////

        //////MARCA//////

        //ACER
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("acer"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "acer"))),
                "Perfecto. Buscare marcas Acer")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("acer"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "acer"))),
                "Buenisimo! Ahora buscare computadoras marca Acer")); idp++;

        //ASUS
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("asus"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "asus"))),
                "Perfecto. Buscare marcas Asus")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("asus"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "asus"))),
                "Buenisimo! Ahora buscare computadoras marca Asus")); idp++;

        //EXO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "exo"))),
                "Perfecto. Buscare marcas Exo")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "exo"))),
                "Buenisimo! Ahora buscare computadoras marca Exo")); idp++;

        //HP
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("hp"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "hp"))),
                "Perfecto. Buscare marcas HP")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("hp"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "hp"))),
                "Buenisimo! Ahora buscare computadoras marca HP")); idp++;

        //LENOVO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lenovo"))),
                "Perfecto. Buscare marcas Lenovo")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lenovo"))),
                "Buenisimo! Ahora buscare computadoras marca Lenovo")); idp++;

        //APPLE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "apple"))),
                "Perfecto. Buscare marcas Apple")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "apple"))),
                "Buenisimo! Ahora buscare computadoras marca Lenovo")); idp++;

        //BANGHO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("bangho"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "bangho"))),
                "Perfecto. Buscare marcas Bangho")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("bangho"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "bangho"))),
                "Buenisimo! Ahora buscare computadoras marca Bangho")); idp++;

        //DELL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("dell"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "dell"))),
                "Perfecto. Buscare marcas Dell")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("dell"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "dell"))),
                "Buenisimo! Ahora buscare computadoras marca Bangho")); idp++;


        //////PROCESADOR//////

        //i3
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i3"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i3"))),
                "Perfecto. Buscare procesadores i3")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i3"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i3"))),
                "Buenisimo! Ahora buscare computadoras con i3")); idp++;

        //i5
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i5"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i5"))),
                "Perfecto. Buscare procesadores i5")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i5"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i5"))),
                "Buenisimo! Ahora buscare computadoras con i5")); idp++;

        //i7
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i7"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i7"))),
                "Perfecto. Buscare procesadores i7")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("i7"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i7"))),
                "Buenisimo! Ahora buscare computadoras con i7")); idp++;

        //ATOM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("atom"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "atom"))),
                "Perfecto. Buscare procesadores Atom")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("atom"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "atom"))),
                "Buenisimo! Ahora buscare computadoras con Atom")); idp++;

        //CELERON
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celeron"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "celeron"))),
                "Perfecto. Buscare procesadores Celeron")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celeron"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "celeron"))),
                "Buenisimo! Ahora buscare computadoras con Celeron")); idp++;

        //A6
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("a6"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "a6"))),
                "Perfecto. Buscare procesadores A6")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("a6"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "a6"))),
                "Buenisimo! Ahora buscare computadoras con A6")); idp++;


        //////PANTALLA//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Perfecto. Buscare pantalla grande")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Buenisimo! Ahora buscare computadoras con pantalla grande")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Perfecto. Buscare pantalla normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Buenisimo! Ahora buscare computadoras con pantalla normal")); idp++;


        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Perfecto. Buscare pantalla pequeño")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Buenisimo! Ahora buscare computadoras con pantalla pequeño")); idp++;


        //////ALMACENAMIENTO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Perfecto. Buscare con mucho almacenamiento")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Buenisimo! Ahora buscare computadoras con mucho almacenamiento")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Perfecto. Buscare con almacenamiento normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Buenisimo! Ahora buscare computadoras con almacenamiento normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Perfecto. Buscare con poco almacenamiento")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Buenisimo! Ahora buscare computadoras con poco almacenamiento")); idp++;


        //////RAM//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Perfecto. Buscare con mucha RAM")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Buenisimo! Ahora buscare computadoras con una RAM grande")); idp++;

        //MEDIANO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Perfecto. Buscare con RAM normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Buenisimo! Ahora buscare computadoras con una RAM normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Perfecto. Buscare con poca RAM")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Buenisimo! Ahora buscare computadoras con poca RAM")); idp++;


        //////GPU//////

        //INTEGRADA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("integrada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "integrada"))),
                "Perfecto. Buscare con gpu integrada")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("integrada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "integrada"))),
                "Buenisimo! Ahora buscare computadoras con GPU integrada")); idp++;

        //DEDICADA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("dedicada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "dedicada"))),
                "Perfecto. Buscare con gpu dedicada")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("dedicada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "dedicada"))),
                "Buenisimo! Ahora buscare computadoras con GPU dedicada")); idp++;



        //////PRECIO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Perfecto. Buscare con precios altos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Buenisimo! Buscare computadoras de precio alto")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Perfecto. Buscare con precios medianos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Buenisimo! Buscare computadoras de precio medio")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Perfecto. Buscare con precios bajos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Buenisimo! Buscare computadoras de precio bajo")); idp++;
    }

    public void cargarReglasCelulares(){
        //CELULARES

        //////////////PREGUNTA INICIAL///////////////

        //MARCA
        /*reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha, media o poca?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, poco o normal?")); idp++;


        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"))),
                "Quiere la camara con alta o baja resolucion?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;

                */

        //////////////OTRAS PREGUNTAS///////////////

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho o poco?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha, media o poca?")); idp++;

        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("ask", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"))),
                "Quiere la camara con alta o baja resolucion?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;



        //////////////REGLAS RESPUESTA///////////////

        //////MARCA//////

        //SAMSUNG
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "samsung"))),
                "Perfecto. Buscare marcas Samsung")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "samsung"))),
                "Que buena eleccion! Buscare celulares Samsung")); idp++;

        //MOTOROLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("motorola"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "motorola"))),
                "Perfecto. Buscare marcas Motorola")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("motorola"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "motorola"))),
                "Que buena eleccion! Buscare celulares Motorola")); idp++;

        //LG
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lg"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lg"))),
                "Perfecto. Buscare marcas LG")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lg"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lg"))),
                "Que buena eleccion! Buscare celulares Motorola")); idp++;

        //ALCATEL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "alcatel"))),
                "Perfecto. Buscare marcas Alcatel")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "alcatel"))),
                "Que buena eleccion! Buscare celulares Alcatel")); idp++;

        //APPLE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "apple"))),
                "Perfecto. Buscare marcas Apple")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "apple"))),
                "Que buena eleccion! Buscare celulares Apple")); idp++;

         //GOOGLE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("google"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "google"))),
                "Perfecto. Buscare marcas Google")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("google"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "google"))),
                "Que buena eleccion! Buscare celulares Google")); idp++;



        //////PANTALLA//////
        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Perfecto. Buscare pantalla grande")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Buenisimo! Buscare celulares con pantalla grande")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Perfecto. Buscare pantalla normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Buenisimo! Buscare celulares con pantalla normal")); idp++;


        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Perfecto. Buscare pantalla pequeño")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Buenisimo! Buscare celulares con pantalla pequeño")); idp++;


        //////RAM//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Perfecto. Buscare con mucha RAM")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Buenisimo! Seleccionare celulares con mucha RAM")); idp++;

        //MEDIANO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Perfecto. Buscare con RAM normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Buenisimo! Seleccionare celulares con RAM media")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Perfecto. Buscare con poca RAM")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Buenisimo! Seleccionare celulares con mucha RAM")); idp++;


        //////ALMACENAMIENTO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Perfecto. Buscare con mucho almacenamiento")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Buenisimo! Buscare con almacenamiento grande")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Perfecto. Buscare con almacenamiento normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Buenisimo! Buscare con almacenamiento medio")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Perfecto. Buscare con poco almacenamiento")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Buenisimo! Buscare con almacenamiento bajo")); idp++;


        //////RES CAMARA//////

        //ALTA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "grande"))),
                "Perfecto. Buscare con alta resolucion")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "grande"))),
                "Buenisimo! Buscare celulares con camaras con alta resolucion")); idp++;

        //BAJA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "pequenio"))),
                "Perfecto. Buscare con baja resolucion")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "pequenio"))),
                "Buenisimo! Buscare celulares con camaras con baja resolucion")); idp++;

        //////PRECIO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Perfecto. Buscare con precios altos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Buenisimo! Buscare celulares de altos precios")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Perfecto. Buscare con precios medianos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Buenisimo! Buscare celulares de precios medianos")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Perfecto. Buscare con precios bajos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Buenisimo! Buscare celulares de precios bajos")); idp++;




    }

    public void cargarReglasTablets(){
        //TABLETS


        //////////////PREGUNTA INICIAL///////////////
        //MARCA
        /*reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha, media o poca?")); idp++;


        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, poco o normal?")); idp++;

        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "tablet"))),
                "Quiere la camara con alta o baja resolucion?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;


*/
        //////////////OTRAS PREGUNTAS///////////////

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;

        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha, media o poca?")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, poco o normal?")); idp++;

        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("ask", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "celular"), new MTEntry("ask", "camara"))),
                "Quiere la camara con alta o baja resolucion?")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;

        //////////////REGLAS RESPUESTA///////////////

        //////MARCA//////

        //LENOVO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "tablet"))),
                "Perfecto. Buscare marcas Lenovo")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "tablet"))),
                "Buenisimo! Buscare tablets marca Lenovo")); idp++;

        //NEXT
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("next"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "next"))),
                "Perfecto. Buscare marcas Next")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("next"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "next"))),
                "Buenisimo! Buscare tablets marca NEXT")); idp++;

        //HUAWEI
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("huawei"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "huawei"))),
                "Perfecto. Buscare marcas Huawei")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("huawei"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "huawei"))),
                "Buenisimo! Buscare tablets marca Huawei")); idp++;

        //SAMSUNG
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "samsung"))),
                "Perfecto. Buscare marcas Samsung")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "samsung"))),
                "Buenisimo! Buscare tablets marca Samsung")); idp++;

        //ALCATEL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "alcatel"))),
                "Perfecto. Buscare marcas Alcatel")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "alcatel"))),
                "Buenisimo! Buscare tablets marca Alcatel")); idp++;

        //PHILCO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("philco"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "philco"))),
                "Perfecto. Buscare marcas Philco")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("philco"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "philco"))),
                "Buenisimo! Buscare tablets marca Philco")); idp++;

        //ION
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("ion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "ion"))),
                "Perfecto. Buscare marcas ION")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("ion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "ion"))),
                "Buenisimo! Buscare tablets marca ION")); idp++;

        //TCL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tcl"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "tcl"))),
                "Perfecto. Buscare marcas TCL")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tcl"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "tcl"))),
                "Buenisimo! Buscare tablets marca TCL")); idp++;

        //KANJI
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("kanji"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "kanji"))),
                "Perfecto. Buscare marcas Kanji")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("kanji"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "kanji"))),
                "Buenisimo! Buscare tablets marca Kanji")); idp++;

        //VIEWSONIC
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("viewsonic"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "viewsonic"))),
                "Perfecto. Buscare marcas View Sonic")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("viewsonic"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "viewsonic"))),
                "Buenisimo! Buscare tablets marca View Sonic")); idp++;

        //XVIEW
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("xview"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "xview"))),
                "Perfecto. Buscare marcas X-View")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("xview"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "xview"))),
                "Buenisimo! Buscare tablets marca X-View")); idp++;


        //EXO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "exo"))),
                "Perfecto. Buscare marcas EXO")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "exo"))),
                "Buenisimo! Buscare tablets marca EXO")); idp++;

        //PERFORMANCE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("performance"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "performance"))),
                "Perfecto. Buscare marcas Performance")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("performance"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "performance"))),
                "Buenisimo! Buscare tablets marca Performance")); idp++;



        //////PANTALLA//////
        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Perfecto. Buscare pantalla grande")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Buenisimo! Buscare tablets con pantalla grande")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Perfecto. Buscare pantalla normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Buenisimo! Buscare tablets con pantalla normal")); idp++;


        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Perfecto. Buscare pantalla pequeña")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Buenisimo! Buscare tablets con pantalla pequeña")); idp++;


        //////RAM//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Perfecto. Buscare con mucha RAM")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Buenisimo! Ahora buscare tablets con mucha RAM")); idp++;

        //MEDIANO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Perfecto. Buscare con RAM normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Buenisimo! Ahora buscare tablets con RAM normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Perfecto. Buscare con poca RAM")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "ram"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Buenisimo! Ahora buscare tablets con poca RAM")); idp++;


        //////ALMACENAMIENTO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Perfecto. Buscare con mucho almacenamiento")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Buenisimo! Buscare tablets con mucho almacenamiento")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Perfecto. Buscare con almacenamiento normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Buenisimo! Buscare tablets con almacenamiento normal")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Perfecto. Buscare con poco almacenamiento")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "almacenamiento"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Buenisimo! Buscare tablets con poco almacenamiento")); idp++;


        //////RES CAMARA//////

        //ALTA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "grande"))),
                "Perfecto. Buscare con alta resolucion")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "grande"))),
                "Buenisimo! Buscare la camara con alta resolucion")); idp++;

        //BAJA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "pequenio"))),
                "Perfecto. Buscare con baja resolucion")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "camara"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "camara"), new MTEntry("camara", "pequenio"))),
                "Buenisimo! Buscare la camara con baja resolucion")); idp++;

        //////PRECIO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Perfecto. Buscare con precios altos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Buenisimo! Buscare precios altos para la tablet")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Perfecto. Buscare con precios medianos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Buenisimo! Buscare precios medianos para la tablet")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Perfecto. Buscare con precios bajos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "tablet"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Buenisimo! Buscare precios bajos para la tablet")); idp++;


    }

    public void cargarReglasTelevisores(){
        //TELEVISORES

        //////////////PREGUNTA INICIAL///////////////
        //MARCA
        /*reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;


        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //TECNOLOGIA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "tecnologia"))),
                "Que tecnologia desea (SMART o LED)?")); idp++;

        //RESOLUCION
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "resolucion"))),
                "Que resolucion desea (HD, FHD, UHD)?")); idp++;


        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;
*/


        //////////////OTRAS PREGUNTAS///////////////

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "marca"))),
                "Que marca quiere?")); idp++;


        //DIM PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande, mediana o chica?")); idp++;

        //TECNOLOGIA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"), new MTEntry("ask", "tecnologia"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "tecnologia"))),
                "Que tecnologia desea (SMART o LED)?")); idp++;

        //RESOLUCION
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("ask", "resolucion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "resolucion"))),
                "Que resolucion quiere (HD, FHD, UHD)?")); idp++;


        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?")); idp++;



        //////////////REGLAS RESPUESTA///////////////

        //////MARCA//////

        //BGH
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("bgh"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "bgh"))),
                "Perfecto. Buscare marcas BGH")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("bgh"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "bgh"))),
                "Buenisimo! Buscare televisores BGH")); idp++;

        //HISENSE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("hisense"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "hisense"))),
                "Perfecto. Buscare marcas Hisense")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("hisense"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "hisense"))),
                "Buenisimo! Buscare televisores Hisense")); idp++;


        //KEN BROWN
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("ken brown"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "ken brown"))),
                "Perfecto. Buscare marcas Ken Brown")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("ken brown"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "ken brown"))),
                "Buenisimo! Buscare televisores Ken Brown")); idp++;

        //LG
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lg"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lg"))),
                "Perfecto. Buscare marcas LG")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("lg"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lg"))),
                "Buenisimo! Buscare televisores LG")); idp++;

        //NOBLEX
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("noblex"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "noblex"))),
                "Perfecto. Buscare marcas Noblex")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("noblex"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "noblex"))),
                "Buenisimo! Buscare televisores Noblex")); idp++;

        //PHILCO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("philco"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "philco"))),
                "Perfecto. Buscare marcas Philco")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("philco"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "philco"))),
                "Buenisimo! Buscare televisores Philco")); idp++;

        //SAMSUNG
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "samsung"))),
                "Perfecto. Buscare marcas Samsung")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "samsung"))),
                "Buenisimo! Buscare televisores Samsung")); idp++;

        //TCL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tcl"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "tcl"))),
                "Perfecto. Buscare marcas TCL")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tcl"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "marca"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "tcl"))),
                "Buenisimo! Buscare televisores TCL")); idp++;


        //////PANTALLA//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Perfecto. Buscare pantalla grande")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Buenisimo! Buscare televisores con pantalla grande")); idp++;

        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Perfecto. Buscare pantalla normal")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Buenisimo! Buscare televisores con pantalla normal")); idp++;


        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Perfecto. Buscare pantalla pequeño")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "dimPantalla"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Buenisimo! Buscare televisores con pantalla pequeño")); idp++;

        //////TECNOLOGIA//////

        //SMART
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("smart"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "tecnologia"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"), new MTEntry("tecnologia", "smart"))),
                "Perfecto. Buscare televisores SMART")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("smart"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "tecnologia"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"), new MTEntry("tecnologia", "smart"))),
                "Buenisimo! Buscare televisores que sean SMART")); idp++;

        //LED
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("led"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "tecnologia"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"), new MTEntry("tecnologia", "led"))),
                "Perfecto. Buscare televisores LED")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("led"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "tecnologia"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "tecnologia"), new MTEntry("tecnologia", "led"))),
                "Buenisimo! Buscare televisores que sean LED")); idp++;

        //////RESOLUCION//////

        //HD
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("hd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "resolucion"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("resolucion", "hd"))),
                "Perfecto. Buscare televisores HD")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("hd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "resolucion"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("resolucion", "hd"))),
                "Buenisimo! Buscare televisores que sean HD")); idp++;

        //FHD
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("fhd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "resolucion"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("resolucion", "fhd"))),
                "Perfecto. Buscare televisores FHD")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("fhd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "resolucion"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("resolucion", "fhd"))),
                "Buenisimo! Buscare televisores que sean FHD")); idp++;

        //UHD
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("uhd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "resolucion"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("resolucion", "uhd"))),
                "Perfecto. Buscare televisores UHD")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("uhd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "resolucion"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "resolucion"), new MTEntry("resolucion", "uhd"))),
                "Buenisimo! Buscare televisores que sean UHD")); idp++;



        //////PRECIO//////

        //GRANDE
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Perfecto. Buscare con precios altos")); idp++;


        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Buenisimo! Buscare televisores con precios altos")); idp++;


        //NORMAL
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Perfecto. Buscare con precios medianos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Buenisimo! Buscare televisores con precios medianos")); idp++;

        //PEQUENIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Perfecto. Buscare con precios bajos")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "televisor"), new MTEntry("ask", "precio"), new MTEntry("user", "cliente"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Buenisimo! Buscare televisores con precios bajos")); idp++;
    }

    public void cargarReglasComputadorasVendedor(){
        /*reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"),new Lema("i5"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto","notebook"), new MTEntry("cpu","i5"))),
                "Buscando resultados....")); idp++;*/


        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("acer"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "acer"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("asus"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "asus"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "exo"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("hp"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "hp"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "lenovo"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "apple"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("bangho"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "bangho"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("dell"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("marca", "dell"))),
                "Buscando resultados....")); idp++;


        //PROCESADOR
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("i3"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("cpu", "i3"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("i5"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("cpu", "i5"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("i7"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("cpu", "i7"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("atom"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("cpu", "atom"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("celeron"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("cpu", "celeron"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("a6"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("cpu", "a6"))),
                "Buscando resultados....")); idp++;

        //PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("grande"),  new Lema("pantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("dimPantalla", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("normal"),  new Lema("pantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("dimPantalla", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("pequenio"),  new Lema("pantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("dimPantalla", "pequenio"))),
                "Buscando resultados....")); idp++;

        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("grande"),  new Lema("almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("almacenamiento", "grande"))),
                "Buscando resultados....")); idp++;


        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("normal"),  new Lema("almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("almacenamiento", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("pequenio"),  new Lema("almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("almacenamiento", "pequenio"))),
                "Buscando resultados....")); idp++;


        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("grande"),  new Lema("ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("ram", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("normal"),  new Lema("ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("ram", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("pequenio"),  new Lema("ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("ram", "pequenio"))),
                "Buscando resultados....")); idp++;

        //GPU
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("grande"),  new Lema("gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("gpu", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("normal"),  new Lema("gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("gpu", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("pequenio"),  new Lema("gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("gpu", "pequenio"))),
                "Buscando resultados....")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("grande"),  new Lema("precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("precio", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("normal"),  new Lema("precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("precio", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("notebook"), new Lema("pequenio"),  new Lema("precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"),new MTEntry("tipoProducto", "notebook"), new MTEntry("precio", "pequenio"))),
                "Buscando resultados....")); idp++;



    }

    public void cargarReglasCelularesVendedor(){
        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("marca", "samsung"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("motorola"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("marca", "motorola"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("lg"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("marca", "lg"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("marca", "alcatel"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("marca", "apple"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("google"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("marca", "google"))),
                "Buscando resultados....")); idp++;

        //PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("pantalla"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("dimPantalla", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("pantalla"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("dimPantalla", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("pantalla"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("dimPantalla", "pequenio"))),
                "Buscando resultados....")); idp++;

        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("ram"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("ram", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("ram"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("ram", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("ram"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("ram", "pequenio"))),
                "Buscando resultados....")); idp++;


        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("almacenamiento"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("almacenamiento", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("almacenamiento"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("almacenamiento", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("almacenamiento"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("almacenamiento", "pequenio"))),
                "Buscando resultados....")); idp++;

        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("camara"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("camara", "grande"))),
                "Buscando resultados....")); idp++;


        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("camara"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("camara", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("camara"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("camara", "pequenio"))),
                "Buscando resultados....")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("precio"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("precio", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("precio"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("precio", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("celular"), new Lema("precio"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "celular"), new MTEntry("precio", "pequenio"))),
                "Buscando resultados....")); idp++;
    }

    public void cargarReglasTabletsVendedor(){
        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "lenovo"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("next"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "next"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("huawei"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "huawei"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "samsung"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("alcatel"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "alcatel"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("philco"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "philco"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("ion"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "ion"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("tcl"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "tcl"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("kanji"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "kanji"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("viewsonic"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "viewsonic"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("xview"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "xview"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "exo"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("performance"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("marca", "performance"))),
                "Buscando resultados....")); idp++;


        //PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("pantalla"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("dimPantalla", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("pantalla"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("dimPantalla", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("pantalla"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("dimPantalla", "pequenio"))),
                "Buscando resultados....")); idp++;


        //RAM
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("ram"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("ram", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("ram"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("ram", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("ram"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("ram", "pequenio"))),
                "Buscando resultados....")); idp++;


        //ALMACENAMIENTO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("almacenamiento"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("almacenamiento", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("almacenamiento"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("almacenamiento", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("almacenamiento"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("almacenamiento", "pequenio"))),
                "Buscando resultados....")); idp++;

        //RES CAMARA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("camara"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("camara", "grande"))),
                "Buscando resultados....")); idp++;


        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("camara"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("camara", "pequenio"))),
                "Buscando resultados....")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("precio"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("precio", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("precio"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("precio", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("tablet"), new Lema("precio"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "tablet"), new MTEntry("precio", "pequenio"))),
                "Buscando resultados....")); idp++;



    }

    public void cargarReglasTelevisoresVendedor(){

        //MARCA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("bgh"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "bgh"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("hisense"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "hisense"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("ken brown"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "ken brown"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("lg"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "lg"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("noblex"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "noblex"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("philco"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "philco"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("philips"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "philips"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("samsung"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "samsung"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("tcl"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("marca", "tcl"))),
                "Buscando resultados....")); idp++;


        //PANTALLA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("pantalla"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("dimPantalla", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("pantalla"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("dimPantalla", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("pantalla"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("dimPantalla", "pequenio"))),
                "Buscando resultados....")); idp++;


        //TECNOLOGIA
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("smart"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("tecnologia", "smart"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("led"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("tecnologia", "led"))),
                "Buscando resultados....")); idp++;

        //RESOLUCION
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("hd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("resolucion", "hd"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("fhd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("resolucion", "fhd"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("uhd"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("resolucion", "uhd"))),
                "Buscando resultados....")); idp++;

        //PRECIO
        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("precio"), new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("precio", "grande"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("precio"), new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("precio", "normal"))),
                "Buscando resultados....")); idp++;

        reglas.add(new Regla(
                idp,
                new ArrayList<>(Arrays.asList(new Lema("televisor"), new Lema("precio"), new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("user", "vendedor"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"))),
                new ArrayList<>(Arrays.asList(new MTEntry("vend", "in"), new MTEntry("tipoProducto", "televisor"), new MTEntry("precio", "pequenio"))),
                "Buscando resultados....")); idp++;

    }
    //



}
