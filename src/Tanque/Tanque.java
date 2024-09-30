package Tanque;

import java.util.ArrayList;

public class Tanque {

    private int numTanque;
    

    public void showStatus(){
        System.out.println("============Tanque "+ numTanque + "============");
        System.out.println("Ocupación: " + pecesEnTanque +" / "+ maxPeces + " (" + porcentajeOcupacion + "%)");
        System.out.println("Peces vivos: " + pecesVivos +" / "+pecesEnTanque + " (" + porcentajeVivos + "%)" );
        System.out.println("Peces alimentados: " + pecesAlimentados +" / "+ pecesVivos + " (" + porcentajeAlimentados + "%)");
        System.out.println("Peces adultos: " + pecesAdultos +" / "+ pecesVivos + " (" + porcentajeAlimentados + "%)");
        System.out.println(pecesHembra+" / "+pecesMacho + "H/M");
        System.out.println("Fértiles: " + pecesFertiles+" / "+pecesVivos);
    }
    
    public void showFishStatus(Pez pez){
        pez.showStatus();
    }

    public void showCapacity(Piscifactoria piscifactoria){
        System.out.println("Tanque " + numTanque +" de la piscifactoria "+ piscifactoria.getNum() + "al " + porcentajeOcupacion + "% de capacidad [" + pecesEnTanque +"/"+ maxPeces + "].");
    }

    public void nextDay(){
        //Llama al nextDay de todos los peces el tanque
    }
}
