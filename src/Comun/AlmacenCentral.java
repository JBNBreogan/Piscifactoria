package Comun;
import java.util.ArrayList;

import Piscifactoria.Piscifactoria;

public class AlmacenCentral {

    private static AlmacenCentral instance;
    private int comidaanimal = 0;
    private int comidavegetal = 0;

    private int capacidadcomidaanimal = 200;
    private int capacidadcomidavegetal = 200;

    private AlmacenCentral(){

    }

    public static AlmacenCentral getInstance() {
        if (instance == null) {
            instance = new AlmacenCentral();
        }
        return instance;
    }

    public int getComidaanimal() {
        return comidaanimal;
    }

    public int getComidavegetal() {
        return comidavegetal;
    }

    public int getCapacidadcomidaanimal() {
        return capacidadcomidaanimal;
    }

    public int getCapacidadcomidavegetal() {
        return capacidadcomidavegetal;
    }

    public int cogerComidaAnimal(int cantidad) {
        if(comidaanimal>=cantidad){
            comidaanimal-=cantidad;
            return cantidad;
        }
            return 0;
    }
    
   
    public int cogerComidaVegetal(int cantidad) {
        if(comidavegetal>=cantidad){
            comidavegetal-=cantidad;
            return cantidad;
        }
            return 0;
    }


    public void repartir(ArrayList<Piscifactoria> piscifactorias){
        
        int comidaanimalarepartir=comidaanimal/piscifactorias.size();
        int comidavegetalarepartir=comidavegetal/piscifactorias.size();
      
        for (Piscifactoria piscifactoria : piscifactorias) {
            piscifactoria.addFood(comidaanimalarepartir, "Animal");
            piscifactoria.addFood(comidavegetalarepartir, "Vegetal");
        }
    }

    
}
