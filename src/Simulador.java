
import java.util.ArrayList;
import java.util.Scanner;

import helpers.MenuHelper;

public class Simulador {
    private static int dias = 0;
    private static String nombreempresa;
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Piscifactoria> piscifactorias = new ArrayList<>();

    public static void init(){
        System.out.println("Nombre de la empresa:");
        nombreempresa = sc.nextLine();
        System.out.println("Nombre de la piscifactoria");
        String npisc= sc.nextLine();
        piscifactorias.add(new Piscifactoria(npisc));
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
        System.out.println("Selecciones una opcione:");
        System.out.println("--------------------------- Piscifactorías ---------------------------");
        System.out.println("[Peces vivos / Peces totales / Espacio total]");
      
         //for (int i = 0; i < piscifactoria.length; i++) {
         //   if (piscifactoria[i] != null){
         //  System.out.println(i+1+".- "+"[I]"+piscifactoria[i].getName()+" ["+piscifactoria[i].getAlive()+"/"+piscifactoria[i].getNum()+"/"+piscifactoria[i].getTiles()+" ]");
         //   } 
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


}

