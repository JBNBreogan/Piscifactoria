package Tanque;

import java.util.ArrayList;

public class Tanque {

    private int numTanque;
    private ArrayList<Pez> peces;
    private int maxPeces;
    
    public Tanque(int maxPeces) {
        this.maxPeces = maxPeces;
    }

    public void showStatus(){
        System.out.println("============Tanque "+ numTanque + "============");
        System.out.println("Ocupación: " + pecesEnTanque() +" / "+ maxPeces + " (" + porcentajeOcupacion + "%)");
        System.out.println("Peces vivos: " + pecesVivos(peces) +" / "+pecesEnTanque() + " (" + porcentajeVivos + "%)" );
        System.out.println("Peces alimentados: " + pecesAlimentados(peces) +" / "+ pecesVivos(peces) + " (" + porcentajeAlimentados + "%)");
        System.out.println("Peces adultos: " + pecesAdultos(peces) +" / "+ pecesVivos(peces) + " (" + porcentajeAlimentados + "%)");
        System.out.println(pecesHembra(peces)+" / "+pecesMacho(peces) + "H/M");
        System.out.println("Fértiles: " + pecesFertiles(peces)+" / "+pecesVivos(peces));
    }
    
    public void showFishStatus(ArrayList<Pez> peces){
        for (Pez pez : peces) {
            pez.showStatus();
        }
    }

    public void showCapacity(Piscifactoria piscifactoria){
        System.out.println("Tanque " + numTanque +" de la piscifactoria "+ piscifactoria.getNum() + "al " + porcentajeOcupacion + "% de capacidad [" + pecesEnTanque +"/"+ maxPeces + "].");
    }

    public void nextDay(ArrayList<Pez> peces){
        for (Pez pez : peces) {
            pez.nextDay();
        }
    }

    public static int pecesEnTanque(){
        peces.lenght();
    }

    public static int pecesVivos(ArrayList<Pez> peces){
        int contadorPecesVivos=0;
        for (Pez pez : peces) {
            if(pez.isVivo()){
                contadorPecesVivos+=1;
            }
        }
        return contadorPecesVivos;
    }

    public static int pecesAlimentados(ArrayList<Pez> peces){
        int contadorPecesAlimentados=0;
        for (Pez pez : peces) {
            if(pez.isAlimentado()){
                contadorPecesAlimentados+=1;
            }
        }
        return contadorPecesAlimentados;
    }

    public static int pecesAdultos(ArrayList<Pez> peces){
        int contadorPecesAdultos=0;
        for (Pez pez : peces) {
            if(pez.isAdulto()){
                contadorPecesAdultos+=1;
            }
        }
        return contadorPecesAdultos;
    }

    public static int pecesHembra(ArrayList<Pez> peces){
        int contadorPecesHembra=0;
        for (Pez pez : peces) {
            if(pez.isHembra()){
                contadorPecesHembra+=1;
            }
        }
        return contadorPecesHembra;
    }

    public static int pecesMacho(ArrayList<Pez> peces){
        int contadorPecesMacho=0;
        for (Pez pez : peces) {
            if(!pez.isHembra()){
                contadorPecesMacho+=1;
            }
        }
        return contadorPecesMacho;
    }

    public static int pecesFertiles(ArrayList<Pez> peces){
        int contadorPecesFertiles=0;
        for (Pez pez : peces) {
            if(pez.isFertil()){
                contadorPecesFertiles+=1;
            }
        }
        return contadorPecesFertiles;
    }
}
