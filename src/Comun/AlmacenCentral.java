package Comun;
import java.util.ArrayList;

import Piscifactoria.Piscifactoria;

public class AlmacenCentral {
    
    private int comidaanimal = 0;
    private int comidavegetal = 0;

    private int capacidadcomidaanimal;
    private int capacidadcomidavegetal;

    public AlmacenCentral() {
        this.capacidadcomidaanimal = 200;
        this.capacidadcomidavegetal = 200;
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
