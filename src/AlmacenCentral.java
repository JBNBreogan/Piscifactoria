import java.util.ArrayList;

public class AlmacenCentral {
    
    private int capacidadcomidaanimal = 200;
    private int capacidadcomidavegetal = 200;

    public void repartir(ArrayList<Piscifactoria> piscifactorias){
        int comidaanimalarepartir=capacidadcomidaanimal/piscifactorias.size();
        int comidavegetalarepartir=capacidadcomidavegetal/piscifactorias.size();
      
        for (Piscifactoria piscifactoria : piscifactorias) {
            piscifactoria.addFood(comidaanimalarepartir, "Animal");
            piscifactoria.addFood(comidavegetalarepartir, "Vegetal");
        }
    }
}
