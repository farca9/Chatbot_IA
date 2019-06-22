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
        notebookList = agregarNotebooks();
        celularList = agregarCelulares();
        tabletList = agregarTablets();
        televisorList = agregarTelevisores();
    }


    private ArrayList<Notebook> agregarNotebooks(){
        ArrayList<Notebook> notebooks = new ArrayList<>();

        notebooks.add(new Notebook("Aspire 3", "Acer", "Celeron", "Intel", 15.6, "1 TB", 4, "Intel Graphics 520", 19999.0));
        notebooks.add(new Notebook("Aspire 5", "Acer", "i7", "Intel", 15.6, "1 TB", 8, "Intel Graphics 520", 49999.0 ));
        notebooks.add(new Notebook("X540MA", "Asus","Celeron", "Intel", 15.6, "500 GB", 4, "Intel Graphics 520", 19999.0 ));
        notebooks.add(new Notebook("X540UA", "Asus", "i3", "Intel", 15.6, "1 TB", 4, "Intel Graphics 620", 27999.0));
        notebooks.add(new Notebook("Cloud E15", "Exo", "Atom", "Intel", 14.1,"32 GB",	2, "Intel Graphics 520", 10999.0));
        notebooks.add(new Notebook("Smart E13X","Exo","Celeron", "Intel" ,13.3,"500 GB",4, "Intel Graphics 520",15999.0));
        notebooks.add(new Notebook("Envy 13", "HP", "i3", "Intel",13.3, "256 GB",8, "Intel Graphics 620", 46499.0));
        notebooks.add(new Notebook("Pavilion 15", "HP", "i5", "Intel",15.6, "1 TB",8, "NVIDIA GeForce GTX 1050",53999.0));
        notebooks.add(new Notebook("EliteBook 840","HP", "i7", "Intel", 14.1, "512 GB", 8,	"Intel Graphics 620",48999.0));
        notebooks.add(new Notebook("Omen X 2S", "HP", "i7", "Intel", 15.6, "256 GB",16, "NVIDIA GeForce RTX 2070",109999.0));
        notebooks.add(new Notebook("ThinkPad E590",	"Lenovo", "i3",	"Intel",	15.6,"256 GB",	8,"Intel Graphics 620",42499.0));
        notebooks.add(new Notebook("Legion Y530", "Lenovo","i7","Intel", 15.6, "1 TB" ,32,	"NVIDIA GeForce GTX 1050", 84999.0));
        notebooks.add(new Notebook("Yoga Book C930","Lenovo","i5","Intel",15.6,"512 GB",8, "NVIDIA GeForce GTX 1050",	63999.0));
        notebooks.add(new Notebook("Ideapad S145", "Lenovo", "A6", "AMD",15.6,"512 GB",4, "AMD Integrated", 20999.0));
        notebooks.add(new Notebook("MacBook Air","Apple", "i5", "Intel",13.3,"128 GB",8, "Intel Graphics 617"	, 88999.0));
        notebooks.add(new Notebook("MacBook","Apple", "i5", "Intel",12.0,	"512 GB",8,"Intel Graphics 5300",105899.0));
        notebooks.add(new Notebook("MacBook Pro", "Apple", "i7", "Intel", 15.4,"512 SSD",16,"ATI Radeon Pro 560X", 203999.0));
        notebooks.add(new Notebook("G5", "Bangho", "i3","Intel", 15.6,"1 TB",4, "Intel Graphics 620",34999.0));
        notebooks.add(new Notebook("GM-Z 17","Bangho", "i7", "Intel",17.3,"1 TB" ,16, "NVIDIA GeForce GTX 1070", 94999.0));
        notebooks.add(new Notebook("Inspiron Gamer 15","Dell", "i5", "Intel", 15.6, "1 TB",8, "NVIDIA GeForce GTX 1050", 59999.0));
        notebooks.add(new Notebook("Inspiron 5480", "Dell", "i5", "Intel",14.1, "256 SSD",8,"Intel Graphics 620", 67999.0));


        return notebooks;
    }


    private ArrayList<Celular> agregarCelulares(){
        ArrayList<Celular> celulares = new ArrayList<>();

        celulares.add(new Celular("J8", "Samsung", 6.0, 3, 32, 16, 15180.0));
        celulares.add(new Celular("J2 Core", "Samsung",5.0, 1,8,8,7649.0));
        celulares.add(new Celular("S10","Samsung",6.1,8,128,16,54999.0));
        celulares.add(new Celular("A50", "Samsung", 6.4, 4, 64, 25, 19999.0));
        celulares.add(new Celular("Note 9",	"Samsung", 6.4, 6, 128, 12,49999.0));
        celulares.add(new Celular("E5", "Motorola",5.7,2, 16,13,8999.0));
        celulares.add(new Celular("G7 Plus","Motorola",6.2,4,64,16,25999.0));
        celulares.add(new Celular("Z3 Play","Motorola",6.0,4,64,12,30999.0));
        celulares.add(new Celular("Q6",	"LG", 5.5, 3, 32, 13, 9999.0));
        celulares.add(new Celular("K11 Plus","LG", 5.3, 2, 32,13,12999.0));
        celulares.add(new Celular("G7 ThinQ","LG", 6.1,4,64,16,41999.0));
        celulares.add(new Celular("A3 XL","Alcatel",6.0,2,16,13,6599.0));
        celulares.add(new Celular("3V","Alcatel",6.0,2,16,12,10499.0));
        celulares.add(new Celular("XS Max","Apple",6.5,4,64,12,86999.0));
        celulares.add(new Celular("8 Plus","Apple",5.5,3,64,12,54999.0));
        celulares.add(new Celular("Pixel 3","Google",5.5,4,64,12,44000.0));
        celulares.add(new Celular("Y7","Huawei", 6.3,3,32,13, 12999.0));
        celulares.add(new Celular("Mate 10 Lite","Huawei", 5.9,4, 64,16,19499.0));

        return celulares;
    }


    private ArrayList<Tablet> agregarTablets(){
        ArrayList<Tablet> tablets = new ArrayList<>();

        tablets.add(new Tablet("YT3-850F","Lenovo",8.0,2,16,8.0,10999.0));
        tablets.add(new Tablet("TB3-710F","Lenovo",7.0,1,8,2.0,6499.0));
        tablets.add(new Tablet("N7526","NEXT TECHNOLOGIES",7.0,1,8,2.0,3199.0));
        tablets.add(new Tablet("MEDIAPAD T3","Huawei",10.0,2,16,2.0,13799.0));
        tablets.add(new Tablet("SM-T830","Samsung",10.5,4,64,13.0,49999.0));
        tablets.add(new Tablet("A2 8063","Alcatel",7.0,1,8,2.0, 3899.0));
        tablets.add(new Tablet("TP7A4N","Philco",7.0,1,8,2.0,3699.0));
        tablets.add(new Tablet("GALAXY TAB ACTIVE 2","Samsung",8.0,3,16,8.0, 53499.0));
        tablets.add(new Tablet("ION KIDS - 700475","ION",7.0,1,8,2.0,2499.0));
        tablets.add(new Tablet("LT7 PRIME",	"TCL",7.0,1,8,5.0,3499.0));
        tablets.add(new Tablet("YUBI", "Kanji",7.0,1,8,2.0,2699.0));
        tablets.add(new Tablet("1T","Alcatel",7.0,1,8,2.0,3899.0));
        tablets.add(new Tablet("TAB4 TB-X304L","Lenovo",10.1,2,16,5.0,18407.0));
        tablets.add(new Tablet("AW7M", "ViewSonic",7.0,1,8, 2.0,2999.0));
        tablets.add(new Tablet("PROTON AMBER","X-View",7.0,1,8,2.0,2999.0));
        tablets.add(new Tablet("Lt10","TCL",10.1,1,16,5.0,6499.0));
        tablets.add(new Tablet("Pixi3","Alcatel",10.0,1,16,5.0,5599.0));
        tablets.add(new Tablet("i007T",	"EXO",7.0,1,16,2.0,3499.0));
        tablets.add(new Tablet("pr7rktnf","Performance",7.0,1,8,0.3,2543.0));
        tablets.add(new Tablet("CATA","Kanji",7.0,1,8,2.0,2999.0));
        tablets.add(new Tablet("Proton Kids Big","X-View",9.0,1,8,2.0,4399.0));

        return tablets;
    }


    private ArrayList<Televisor> agregarTelevisores(){
        ArrayList<Televisor> televisores = new ArrayList<>();

        televisores.add(new Televisor("B3218H5","BGH",32.0,true,"HD",11999.0));
        televisores.add(new Televisor("H4318FH5","HISENSE",43.0, true,"FHD",18699.0));
        televisores.add(new Televisor("KB40S3000SA","KEN BROWN",40.0,true, "FHD",15999.0));
        televisores.add(new Televisor("32LJ600B.AWN","LG",32.0,true,"HD",13999.0));
        televisores.add(new Televisor("43UK6300","LG",43.0, true, "UHD",26999.0));
        televisores.add(new Televisor("OLED55B7P","LG",55.0, true, "UHD",79999.0));
        televisores.add(new Televisor("65SJ8000","LG",65.0,true,"UHD", 66999.0));
        televisores.add(new Televisor("91EE24X400","NOBLEX",24.0,false,	"HD",8999.0));
        televisores.add(new Televisor("EA50X6100X","NOBLEX",50.0,true,"FHD",22999.0));
        televisores.add(new Televisor("CPLD43FS8B", "PHILCO",43.0,true,"FHD",18999.0));
        televisores.add(new Televisor("49PFG5101/77","PHILIPS",49.0, false,"FHD",18999.0));
        televisores.add(new Televisor("24PHG4032/77","PHILIPS",24.0,false,"HD",9990.0));
        televisores.add(new Televisor("65PUG6703","PHILIPS",65.0, true,"UHD", 64999.0));
        televisores.add(new Televisor("75PUG8502/77","PHILIPS",75.0, true, "UHD",114999.0));
        televisores.add(new Televisor("50PUG6102/77","PHILIPS",50.0, true, "UHD",32499.0));
        televisores.add(new Televisor("UN55MU6300G","SAMSUNG",55.0, true,"UHD",49999.0));
        televisores.add(new Televisor("43MU6100","SAMSUNG",43.0, true,"UHD",28499.0));
        televisores.add(new Televisor("UN40J5200AG","SAMSUNG",40.0,true, "FHD",18999.0));
        televisores.add(new Televisor("L32S6500","TCL",32.0,true, "HD",12299.0));
        televisores.add(new Televisor("L55C2","TCL",55.0, true, "UHD",35999.0));

        return televisores;
    }



}
