
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Comun.Monedero;
import Tanque.Tanque;
import helpers.MenuHelper;
import helpers.MonederoHelper;
import helpers.PorcentajeHelper;
import peces.Pez;
import peces.Double.Dorada;
import peces.Double.TruchaArcoiris;
import peces.Mar.Abadejo;
import peces.Mar.Besugo;
import peces.Mar.Caballa;
import peces.Mar.Rodaballo;
import peces.Mar.Sargo;
import peces.Rio.Carpa;
import peces.Rio.CarpaPlateada;
import peces.Rio.LucioDelNorte;
import peces.Rio.Pejerrey;
import peces.Rio.TilapiaDelNilo;
import propiedades.AlmacenPropiedades;
import propiedades.CriaTipo;
import propiedades.PecesDatos;
import propiedades.PecesProps;
import propiedades.PecesTipo;

public class Simulador {
    private static int dias = 0;
    private static String nombreempresa;
    private AlmacenCentral almacenCentral=null;
    private static ArrayList<Piscifactoria> piscifactorias = new ArrayList<>();
    private Monedero monedero=Monedero.getInstance();

    public void init(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nombre de la empresa:");
        nombreempresa = sc.nextLine();
        System.out.println("Nombre de la piscifactoria");
        String npisc= sc.nextLine();
        piscifactorias.add(new Piscifactoria(npisc,CriaTipo.RIO));
        Monedero.getInstance().setMonedas(100);
    }

    public void menu(){
        MenuHelper.mostrarMenu(new String[] {"Estado general.", 
                                            "Estado piscifactoría.", 
                                            "Estado tanques.", 
                                            "Informes.", 
                                            "Ictiopedia.", 
                                            "Pasar día.", 
                                            "Comprar comida.", 
                                            "Comprar peces.", 
                                            "Vender pedes.", 
                                            "Limpiar tanques.",
                                            "Mejorar.",
                                            "Pasar varios días.",
                                            "Salir."},
                                             false);
    }

    public void menuPisc(){
        int i=0;
        System.out.println("Selecciones una opcione:");
        System.out.println("--------------------------- Piscifactorías ---------------------------");
        System.out.println("[Peces vivos / Peces totales / Espacio total]");
      
        for (Piscifactoria piscifactoria : piscifactorias) {
            i+=1;
            System.out.println(i + ".- " + piscifactoria.getNombre() + " [ " + pecesVivosEnSist() + "/" + pecesTotalesEnSist() + "/" + espacioTotalSist());
        }
        
    }     

    public int selectPisc(){
        Scanner sc=new Scanner(System.in);
        try {
            menuPisc();
            int opcion = sc.nextInt();
            return opcion-1;
        } catch (Exception e) {
            System.out.println("Introduce un valor correcto");
            return 0;
        }
    }
    
    public int selectTank(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        return pisc.selectTank()-1;
    }

    public void showGeneralStatus(){
        //Falta implementar almacen central

        for (Piscifactoria pisc : piscifactorias) {
            pisc.showStatus();
        }
    }

    public void showSpecificStatus(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        
        pisc.showTankStatus();
    }

    public void showTankStatus(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());

        Tanque tank = pisc.getTanques().get(selectTank());

        tank.showFishStatus();
    }

    public void showStats(){
        //Necesito por parametros,peces comprados, peces nacidos, peces vendidos, monedas obtenidas
        int pecesComp=0;
        int pecesNac=0;
        int pecesVend=0;
        int monedasOb=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            piscifactoria.showFishStatus();
            pecesComp+=pecesComp;;
            pecesNac+=pecesNac;
            pecesVend+=pecesVend;
            monedasOb+=monedasOb;
        }

        System.out.println("Se han comprado "+pecesComp+" han nacido "+pecesNac+" se han vendido "+pecesVend+" y se han obtenido"+monedasOb);
    }

    public Pez showIctio(){
        int opcion;
        Scanner sc=new Scanner(System.in);
        do {
            MenuHelper.mostrarMenu(new String[]{"Lucio del norte",
                                          "Carpa plateada",
                                          "Carpa",
                                          "Tilapia del nilo",
                                          "Pejerrey",
                                          "Rodaballo",
                                          "Caballa",
                                          "Besugo",
                                          "Abadejo",
                                          "Sargo",
                                          "Trucha arcoiris",
                                          "Dorada",
                                          "Salir."},
                                           false);
            opcion=sc.nextInt();
            switch (opcion) {
                case 1:
                    infoLib("Lucio del norte");
                    return new LucioDelNorte(false);
                case 2:
                    infoLib("Carpa plateada");
                    return new CarpaPlateada(false);
                case 3:
                    infoLib("Carpa");
                    return new Carpa(false);
                case 4:
                    infoLib("Tilapia del nilo");
                    return new TilapiaDelNilo(false);
                case 5:
                    infoLib("Pejerrey");
                    return new Pejerrey(false);
                case 6:
                    infoLib("Rodaballo");
                    return new Rodaballo(false);
                case 7:
                    infoLib("Caballa");
                    return new Caballa(false);
                case 8:
                    infoLib("Besugo");
                    return new Besugo(false);
                case 9:
                    infoLib("Abadejo");
                    return new Abadejo(false);
                case 10:
                    infoLib("Sargo");
                    return new Sargo(false);
                case 11:
                    infoLib("Trucha arcoiris");
                    return new TruchaArcoiris(false);
                case 12:
                    infoLib("Dorada");
                    return new Dorada(false);
                case 0:
                    return null;
                default:
                    System.out.println("Esta opcion no es correcta, eliga una opcion valida");
                    return null;
            }
        } while (opcion!=0);
        
    }

    public void nextDay(){
        dias++;
        for (Piscifactoria piscifactoria : piscifactorias) {
            piscifactoria.nextDay();
        }

        int pecesVendidos=0;
        int monedasObtenidas=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            int[] currPiscValues=piscifactoria.venta();
            pecesVendidos+=currPiscValues[0];
            monedasObtenidas+=currPiscValues[1];
        }
        System.out.println(pecesVendidos + " peces vendidos por un total de "+monedasObtenidas+ " monedas");
    }

    public void addFood(){
        Scanner sc=new Scanner(System.in);
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        //Falta implementar almacen central
        int opcion;
        String tipoComidaEleg="";
        do {
            System.out.println("Que tipo de comida quieres añadir?");
            MenuHelper.mostrarMenu(new String[]{"Animal",
                                                "Vegetal"},
                                                false);
            opcion=sc.nextInt();
            switch (opcion) {
                case 1:
                    tipoComidaEleg="Animal";
                    break;
                case 2:
                    tipoComidaEleg="Vegetal";
                    break;
                default:
                    System.out.println("Esa opcion no esta disponible, eliga entre las opciones disponibles");
                    break;
            }
        } while (opcion!= 1 || opcion!=2);
        
        int opCant;
        do {
            System.out.println("Cuanta comida quieres añadir?");
            MenuHelper.mostrarMenu(new String[]{"5",
                                                "10",
                                                "25",
                                                "llenar"},
                                                false);

            opCant=sc.nextInt();
            int cantComida=0;
            switch (opCant) {
                case 1:
                    cantComida=5;
                    if(MonederoHelper.monedasSuficientes(cantComida)){
                        if (tipoComidaEleg=="Animal") {
                            añadirComida(cantComida,tipoComidaEleg,pisc);
                        }else if (tipoComidaEleg=="Vegetal") {
                            añadirComida(cantComida, tipoComidaEleg,pisc);
                        }
                    }
                    break;
                case 2:
                    cantComida=10;
                    if(MonederoHelper.monedasSuficientes(cantComida)){
                        if (tipoComidaEleg=="Animal") {
                            añadirComida(cantComida, tipoComidaEleg,pisc);
                        }else if (tipoComidaEleg=="Vegetal") {
                            añadirComida(cantComida, tipoComidaEleg,pisc);
                        }
                    }
                    break;
                case 3:
                    cantComida=25;
                    if(MonederoHelper.monedasSuficientes(cantComida)){
                        if (tipoComidaEleg=="Animal") {
                            añadirComida(cantComida, tipoComidaEleg,pisc);
                        }else if (tipoComidaEleg=="Vegetal") {
                            añadirComida(cantComida, tipoComidaEleg,pisc);
                        }
                    }
                    break;
                case 4:
                    if (tipoComidaEleg=="Animal" && MonederoHelper.monedasSuficientes(pisc.getMaxComidaAnimal()-pisc.getComidaAnimal())) {
                        cantComida=pisc.getMaxComidaAnimal()-pisc.getComidaAnimal();
                        añadirComida(cantComida, tipoComidaEleg,pisc);
                    }else if (tipoComidaEleg=="Vegetal" && MonederoHelper.monedasSuficientes(pisc.getMaxComidaVegetal()-pisc.getComidaVegetal())) {
                        cantComida=pisc.getMaxComidaVegetal()-pisc.getComidaVegetal();
                        añadirComida(cantComida, tipoComidaEleg,pisc);
                    }
                    break;
                default:
                    System.out.println("Esa opcion no esta disponible, eliga entre las opciones disponibles");
                    break;
            }
        } while (opCant!=1 || opCant!=2 || opCant!=3 || opCant!=4);
    }

    public void addFish(){
        Pez pezEleg=showIctio();
        boolean llena=false;

        do {
            Piscifactoria pisc = piscifactorias.get(selectPisc());

            if(pisc.pecesEnPiscifactoria()<pisc.pecesMaxPiscifactoria()){
                for (Tanque tanque : pisc.getTanques()) {
                    if(tanque.getPeces().size()<tanque.getMaxPeces()){
                        //Falta lo del sexo
                        tanque.getPeces().add(pezEleg);
                        tanque.showCapacity();
                    }
                }
            }else{
                llena=true;
                System.out.println("Esta piscifactoria esta llena, eliga otra");
            }
        } while (llena);
    } 

    public void sell(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());

        int monedasOb=0;
        int pecesVend=0;

        for (Tanque tanque : pisc.getTanques()) {
            for (Pez pez : tanque.getPeces()) {
                if(pez.isAlive() && pez.isAdulto()){
                    tanque.getPeces().remove(pez);
                    pecesVend++;
                    monedasOb+=(pez.getMonedas()/2);
                }
            }
        }
        System.out.println("Piscifactoría "+pisc.getNombre()+": "+pecesVend+" peces vendidos por "+monedasOb+" monedas");
    }

    public void cleanTank(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());

        for (Tanque tanque : pisc.getTanques()) {
            for (Pez pez : tanque.getPeces()) {
                if(!pez.isAlive()){
                    tanque.getPeces().remove(pez);
                }
            }
        }
    }

    public void emptyTank(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        Tanque tank=pisc.getTanques().get(selectTank());

        tank.getPeces().removeAll(tank.getPeces());
    }

    public void upgrade(){
        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        Scanner sc3=new Scanner(System.in);

        int op=0;
        String op2="";
        String op3="";
        do {
            MenuHelper.mostrarMenu(new String[]{"Comprar edificios.",
                                                "Mejorar edificios.",
                                                "Cancelar."},
                                                 false);
            op=sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("a. Piscifactoría.");
                    System.out.println("b. Almacén central.");
                    op2=sc.next();
                    switch (op2) {
                        case "a":
                            //Crear piscifactoria
                            break;
                        case "b":
                            //Crear almacen central 
                            break;
                        default:
                            System.out.println("Esa opción no es válida.");
                            op=0;
                            op2="";
                            break;    
                    }
                    break;
                case 2:
                    System.out.println("a. Piscifactoria.");
                    if(almacenCentral!=null){
                        System.out.println("b. Almacén central.");
                    }
                    op2=sc.next();
                    switch (op2) {
                        case "a":
                            System.out.println("i.  Comprar tanque.");
                            System.out.println("ii. Aumentar almacén comida.");
                            op3=sc.next();
                            switch (op3) {
                                case "i":
                                    //Añadir un tanque
                                    break;
                                case "ii":
                                    //Aumentar almacén de comida
                                    break;
                                default:
                                    System.out.println("Esa opción no es válida.");
                                    op=0;
                                    op2="c";
                                    op3="";
                                    break;
                            }
                            break;
                        case "b":
                            System.out.println("i. Aumentar capacidad");
                            op3=sc.next();
                            switch (op3) {
                                case "i":
                                    //Aumentar capacidad del almacen central
                                    break;
                                default:
                                    System.out.println("Esa opción no es válida.");
                                    op=0;
                                    op2="c";
                                    op3="";
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Esa opción no es válida.");
                            op=0;
                            op2="";
                            break;
                    }
                    break;
                case 3:
                    break;
            }
        } while (op!=1 || op!=2 || op!=3);
    }

    public void infoLib(String tipoPez){

        System.out.println("Nombre : "+AlmacenPropiedades.getPropByName(tipoPez).getNombre());
        System.out.println("Nombre cientifico : "+AlmacenPropiedades.getPropByName(tipoPez).getCientifico());
        System.out.println("Coste : "+AlmacenPropiedades.getPropByName(tipoPez).getCoste());
        System.out.println("Ciclo : "+AlmacenPropiedades.getPropByName(tipoPez).getCiclo());
        System.out.println("Monedas al vender : "+AlmacenPropiedades.getPropByName(tipoPez).getMonedas());
        System.out.println("Huevos : "+AlmacenPropiedades.getPropByName(tipoPez).getHuevos());
        System.out.println("Madurez : "+AlmacenPropiedades.getPropByName(tipoPez).getMadurez());
        System.out.println("Edad optima : "+AlmacenPropiedades.getPropByName(tipoPez).getOptimo());
    }

    public int pecesVivosEnSist(){
        int pecesEnSist=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            pecesEnSist += piscifactoria.pecesVivosPiscifactoria();
        }
        return pecesEnSist;
    }

    public int pecesTotalesEnSist(){
        int pecesTotal=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            pecesTotal += piscifactoria.pecesEnPiscifactoria();
        }
        return pecesTotal;
    }

    public int espacioTotalSist(){
        int espacioTotal=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            espacioTotal += piscifactoria.pecesMaxPiscifactoria();
        }
        return espacioTotal;
    }

    public void añadirComida(int cant,String tipo,Piscifactoria pisc){
        
        if(tipo=="Animal" && cant>pisc.getMaxComidaAnimal()-pisc.getComidaAnimal()){
            cant-=pisc.getMaxComidaAnimal()-pisc.getComidaAnimal();
        }else if (tipo=="Vegetal" && cant>pisc.getMaxComidaVegetal()-pisc.getComidaVegetal()) {
            cant-=pisc.getMaxComidaVegetal()-pisc.getComidaVegetal();
        }

        int precioComida=MonederoHelper.calcularDescuento(cant);

        monedero.setMonedas(monedero.getMonedas()-precioComida);
        System.out.println("Cantidad de comida añadida: ");
        System.out.println("Añadida "+cant+" de comida "+tipo);
        if(tipo=="Vegetal"){
            pisc.addFood(cant,tipo);
            System.out.println("Deposito de comida X del la piscifactoria "+pisc.getNombre()+" al"+PorcentajeHelper.hacerProcentaje(cant, pisc.getMaxComidaVegetal())
            +"% de su capacidad. [ "+pisc.getComidaVegetal()+"/"+pisc.getMaxComidaVegetal()+"]");
        }else if (tipo=="Animal") {
            pisc.addFood(cant,tipo);
            System.out.println("Deposito de comida X del la piscifactoria "+pisc.getNombre()+" al"+PorcentajeHelper.hacerProcentaje(cant, pisc.getMaxComidaAnimal())
            +"% de su capacidad. [ "+pisc.getComidaAnimal()+"/"+pisc.getMaxComidaAnimal()+"]");
        }
        
    }















    public static void main(String[] args) {
        Monedero monedero=Monedero.getInstance();
        Scanner sc=new Scanner(System.in);
        Simulador sim=new Simulador();
        sim.init();
        int opcion;
        do {
            sim.menu();
            opcion=sc.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        sim.showGeneralStatus();
                        break;
                    case 2:
                        sim.showSpecificStatus();
                        break;
                    case 3:
                        sim.showTankStatus();
                        break;
                    case 4:
                        sim.showStats();
                        break;
                    case 5:
                        sim.showIctio();
                        break;
                    case 6:
                        sim.nextDay();
                        break;
                    case 7:
                        sim.addFood();
                        break;
                    case 8:
                        sim.addFish();
                        break;
                    case 9:
                        sim.sell();
                        break;
                    case 10:
                        sim.cleanTank();
                        break;
                    case 11:
                        sim.emptyTank();
                        break;
                    case 12:
                        sim.upgrade();
                        break;
                    case 13:
                        //Pasar varios dias
                        break;
                    case 98:
                    //Añade cuatro peces al azar en una piscifactoria seleccionada
                        break;
                    case 99:
                        monedero.setMonedas(1000);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Esta opción no es válida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Has introducido un tipo de dato incorrecto, introduce un número");
            }
        } while (opcion!=0);
    }
}

