package Produccion;

import NLP.Lema;

import java.util.ArrayList;
import java.util.Arrays;

public class MP {

    ArrayList<Regla> reglas;

    //Singleton
    private static MP instance = new MP();
    public static MP getInstance(){
        return instance;
    }
    private MP(){
        reglas=new ArrayList<>();

        Integer idp = 1;

        cargarReglas();

        idp++;


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

        //COMPUTADORA


        //////////////PREGUNTA INICIAL///////////////
        //MARCA
        reglas.add(new Regla(
                1,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                "Que marca quiere?"));

        //CPU
        reglas.add(new Regla(
                2,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                "Que procesador quiere?"));

        //DIM PANTALLA
        reglas.add(new Regla(
                3,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande o chica?"));

        //ALMACENAMIENTO
        reglas.add(new Regla(
                4,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho, poco o normal?"));

        //RAM
        reglas.add(new Regla(
                5,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha o poca?"));


        //GPU
        reglas.add(new Regla(
                6,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"))),
                "Quiere GPU integrada o dedicada?"));

        //PRECIO
        reglas.add(new Regla(
                6,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?"));



        //////////////OTRAS PREGUNTAS///////////////

        //MARCA
        reglas.add(new Regla(
                7,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "marca"))),
                "Que marca quiere?"));

        //CPU
        reglas.add(new Regla(
                8,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "cpu"))),
                "Que procesador quiere?"));

        //DIM PANTALLA
        reglas.add(new Regla(
                9,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "dimPantalla"))),
                "Quiere una pantalla grande o chica?"));

        //ALMACENAMIENTO
        reglas.add(new Regla(
                10,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "almacenamiento"))),
                "Cuanto almacenamiento quiere? Mucho o poca?"));

        //RAM
        reglas.add(new Regla(
                11,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "ram"))),
                "Cuanta RAM quiere? Mucha o poca?"));

        //GPU
        reglas.add(new Regla(
                12,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "gpu"))),
                "Quiere GPU integrada o dedicada?"));


        //PRECIO
        reglas.add(new Regla(
                13,
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ask", "precio"))),
                "Cuanto esta dispuesto a gastar?"));



        //////////////REGLAS RESPUESTA///////////////

        //////MARCA//////

        //ACER
        reglas.add(new Regla(
                14,
                new ArrayList<>(Arrays.asList(new Lema("acer"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "acer"))),
                "Perfecto. Buscare marcas Acer"));

        //ASUS
        reglas.add(new Regla(
                15,
                new ArrayList<>(Arrays.asList(new Lema("asus"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "asus"))),
                "Perfecto. Buscare marcas Asus"));

        //EXO
        reglas.add(new Regla(
                16,
                new ArrayList<>(Arrays.asList(new Lema("exo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "exo"))),
                "Perfecto. Buscare marcas Exo"));

        //HP
        reglas.add(new Regla(
                17,
                new ArrayList<>(Arrays.asList(new Lema("hp"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "hp"))),
                "Perfecto. Buscare marcas HP"));

        //LENOVO
        reglas.add(new Regla(
                18,
                new ArrayList<>(Arrays.asList(new Lema("lenovo"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "lenovo"))),
                "Perfecto. Buscare marcas Lenovo"));

        //APPLE
        reglas.add(new Regla(
                19,
                new ArrayList<>(Arrays.asList(new Lema("apple"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "apple"))),
                "Perfecto. Buscare marcas Apple"));

        //BANGHO
        reglas.add(new Regla(
                20,
                new ArrayList<>(Arrays.asList(new Lema("bangho"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "bangho"))),
                "Perfecto. Buscare marcas Bangho"));

        //DELL
        reglas.add(new Regla(
                21,
                new ArrayList<>(Arrays.asList(new Lema("dell"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("marca", "dell"))),
                "Perfecto. Buscare marcas Dell"));


        //////PROCESADOR//////

        //i3
        reglas.add(new Regla(
                22,
                new ArrayList<>(Arrays.asList(new Lema("i3"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i3"))),
                "Perfecto. Buscare procesadores i3"));

        //i5
        reglas.add(new Regla(
                23,
                new ArrayList<>(Arrays.asList(new Lema("i5"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i5"))),
                "Perfecto. Buscare procesadores i5"));

        //i7
        reglas.add(new Regla(
                24,
                new ArrayList<>(Arrays.asList(new Lema("i7"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "i7"))),
                "Perfecto. Buscare procesadores i7"));

        //ATOM
        reglas.add(new Regla(
                25,
                new ArrayList<>(Arrays.asList(new Lema("atom"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "atom"))),
                "Perfecto. Buscare procesadores Atom"));

        //CELERON
        reglas.add(new Regla(
                26,
                new ArrayList<>(Arrays.asList(new Lema("celeron"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "celeron"))),
                "Perfecto. Buscare procesadores Celeron"));

        //A6
        reglas.add(new Regla(
                27,
                new ArrayList<>(Arrays.asList(new Lema("a6"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "cpu"), new MTEntry("cpu", "a6"))),
                "Perfecto. Buscare procesadores A6"));


        //////PANTALLA//////

        //GRANDE
        reglas.add(new Regla(
                28,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "grande"))),
                "Perfecto. Buscare pantalla grande"));

        //NORMAL
        reglas.add(new Regla(
                29,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "normal"))),
                "Perfecto. Buscare pantalla normal"));


        //PEQUENIO
        reglas.add(new Regla(
                30,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "dimPantalla"), new MTEntry("dimPantalla", "pequenio"))),
                "Perfecto. Buscare pantalla pequeño"));


        //////ALMACENAMIENTO//////

        //GRANDE
        reglas.add(new Regla(
                31,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "grande"))),
                "Perfecto. Buscare con mucho almacenamiento"));

        //NORMAL
        reglas.add(new Regla(
                32,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "normal"))),
                "Perfecto. Buscare con almacenamiento normal"));

        //PEQUENIO
        reglas.add(new Regla(
                33,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "almacenamiento"), new MTEntry("almacenamiento", "pequenio"))),
                "Perfecto. Buscare con poco almacenamiento"));


        //////RAM//////

        //GRANDE
        reglas.add(new Regla(
                34,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "grande"))),
                "Perfecto. Buscare con mucha RAM"));

        //MEDIANO
        reglas.add(new Regla(
                35,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "normal"))),
                "Perfecto. Buscare con RAM normal"));

        //PEQUENIO
        reglas.add(new Regla(
                36,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "ram"), new MTEntry("ram", "pequenio"))),
                "Perfecto. Buscare con poca RAM"));


        //////GPU//////

        //INTEGRADA
        reglas.add(new Regla(
                37,
                new ArrayList<>(Arrays.asList(new Lema("integrada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "integrada"))),
                "Perfecto. Buscare con gpu integrada"));

        //DEDICADA
        reglas.add(new Regla(
                38,
                new ArrayList<>(Arrays.asList(new Lema("dedicada"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "gpu"), new MTEntry("gpu", "dedicada"))),
                "Perfecto. Buscare con gpu dedicada"));



        //////PRECIO//////

        //GRANDE
        reglas.add(new Regla(
                39,
                new ArrayList<>(Arrays.asList(new Lema("grande"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "grande"))),
                "Perfecto. Buscare con precios altos"));

        //NORMAL
        reglas.add(new Regla(
                40,
                new ArrayList<>(Arrays.asList(new Lema("normal"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "normal"))),
                "Perfecto. Buscare con precios medianos"));

        //PEQUENIO
        reglas.add(new Regla(
                41,
                new ArrayList<>(Arrays.asList(new Lema("pequenio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"))),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "precio"), new MTEntry("precio", "pequenio"))),
                "Perfecto. Buscare con precios bajos"));
        
    }



    //



}
