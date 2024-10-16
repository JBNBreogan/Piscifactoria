
import java.util.ArrayList;
import java.util.Scanner;

import Comun.Monedero;
import Tanque.Tanque;
import helpers.MenuHelper;
import helpers.MonederoHelper;
import helpers.PorcentajeHelper;
import propiedades.CriaTipo;

public class Simulador {
    private static int dias = 0;
    private static String nombreempresa;
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Piscifactoria> piscifactorias = new ArrayList<>();
    private Monedero monedero=Monedero.getInstance();

    public static void init(){
        System.out.println("Nombre de la empresa:");
        nombreempresa = sc.nextLine();
        System.out.println("Nombre de la piscifactoria");
        String npisc= sc.nextLine();
        piscifactorias.add(new Piscifactoria(npisc,CriaTipo.RIO));
        Monedero.getInstance().setMonedas(100);
    }

    public static void menu(){
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

    public static void menuPisc(){
        int i=0;
        System.out.println("Selecciones una opcione:");
        System.out.println("--------------------------- Piscifactorías ---------------------------");
        System.out.println("[Peces vivos / Peces totales / Espacio total]");
      
        for (Piscifactoria piscifactoria : piscifactorias) {
            i+=1;
            System.out.println(i + ".- " + piscifactoria.getNombre() + " [ " + pecesVivosEnSist() + "/" + pecesTotalesEnPisc() + "/" + espacioTotalPisci());
        }
        
    }     

    public static int selectPisc(){
        try {
            menuPisc();
            int opcion = sc.nextInt();
            return opcion-1;
        } catch (Exception e) {
            System.out.println("Introduce un valor correcto");
            return 0;
        }
    }

    
    public static int selectTank(){
        try {
            Piscifactoria pisc = piscifactorias.get(selectPisc());
            //TODO showstatus de los tanques de una pisc
            //pisc.showTankStatus();
            int opcion = sc.nextInt();
            return opcion-1;
        } catch (Exception e) {
            System.out.println("Introduce un valor correcto");
            return 0;
        }
    }

    public static void showGeneralStatus(){
        //Falta implementar almacen central

        for (Piscifactoria pisc : piscifactorias) {
            pisc.showStatus();
        }
    }

    public static void showSpecificStatus(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        
        pisc.showTankStatus();
    }

    public static void showTankStatus(){
        Piscifactoria pisc = piscifactorias.get(selectPisc());

        Tanque tank = pisc.getTanques().get(selectTank());

        tank.showFishStatus();
    }

    public static void showStats(){

    }

    public static void showIctio(){

    }

    public static void nextDay(){
        for (Piscifactoria piscifactoria : piscifactorias) {
            piscifactoria.nextDay();
        }

        int pecesVendidos=0;
        int monedasObtenidas=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            System.out.println("Piscifactoria "+ piscifactoria.getNombre()+": "+piscifactoria.pecesVendidos()+" peces vendidos por "+piscifactoria.monedasObtenidas()+" monedas");
            pecesVendidos+=piscifactoria.pecesVendidos();
            monedasObtenidas+=piscifactoria.monedasObtenidas();
        }
        System.out.println(pecesVendidos + " peces vendidos por un total de "+monedasObtenidas+ " monedas");
    }

    public void addFood(){
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
            switch (opCant) {
                case 1:
                    if(MonederoHelper.monedasSuficientes(5)){
                        if (tipoComidaEleg=="Animal") {
                            añadirComida(5,tipoComidaEleg,pisc);
                        }else if (tipoComidaEleg=="Vegetal") {
                            añadirComida(5, tipoComidaEleg,pisc);
                        }
                    }
                    break;
                case 2:
                    if(MonederoHelper.monedasSuficientes(10)){
                        if (tipoComidaEleg=="Animal") {
                            añadirComida(10, tipoComidaEleg,pisc);
                        }else if (tipoComidaEleg=="Vegetal") {
                            añadirComida(10, tipoComidaEleg,pisc);
                        }
                    }
                    break;
                case 3:
                    if(MonederoHelper.monedasSuficientes(25)){
                        if (tipoComidaEleg=="Animal") {
                            añadirComida(25, tipoComidaEleg,pisc);
                        }else if (tipoComidaEleg=="Vegetal") {
                            añadirComida(25, tipoComidaEleg,pisc);
                        }
                    }
                    break;
                case 4:
                    if (MonederoHelper.monedasSuficientes(pisc.getMaxComidaAnimal()-pisc.getComidaAnimal()) && tipoComidaEleg=="Animal") {
                        añadirComida(pisc.getMaxComidaAnimal()-pisc.getComidaAnimal(), tipoComidaEleg,pisc);
                    }else if (MonederoHelper.monedasSuficientes(pisc.getMaxComidaVegetal()-pisc.getComidaVegetal()) && tipoComidaEleg=="Vegetal") {
                        añadirComida(pisc.getMaxComidaVegetal()-pisc.getComidaVegetal(), tipoComidaEleg,pisc);
                    }
                    break;
                default:
                    System.out.println("Esa opcion no esta disponible, eliga entre las opciones disponibles");
                    break;
            }
        } while (opCant!=1 || opCant!=2 || opCant!=3 || opCant!=4);
    }















    public static int pecesVivosEnSist(){
        int pecesEnSist=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            pecesEnSist += piscifactoria.pecesVivosPiscifactoria();
        }
        return pecesEnSist;
    }

    public static int pecesTotalesEnPisc(){
        int pecesTotal=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            pecesTotal += piscifactoria.pecesEnPiscifactoria();
        }
        return pecesTotal;
    }

    public static int espacioTotalPisci(){
        int espacioTotal=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            espacioTotal += piscifactoria.pecesMaxPiscifactoria();
        }
        return espacioTotal;
    }

    public void añadirComida(int cant,String tipo,Piscifactoria pisc){
        //Falta lo de la cantidad de comida mayor al maximo de comida
        //Si la cantidad se comida introducida es mayor al maximo - el actual, lo que que falta para llenarse, solo se cobra la cantidad que falta

        
        int precioComida=MonederoHelper.calcularDescuento(cant);

        monedero.setMonedas(monedero.getMonedas()-cant);
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
        menu();
        init();
    }
}

