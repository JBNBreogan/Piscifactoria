import java.util.ArrayList;
import Tanque.Tanque;
import propiedades.CriaTipo;

public class Piscifactoria {
    
    private String nombre;
    private CriaTipo tipo;
    private ArrayList<Tanque> tanques;

    public Piscifactoria(String nombre, CriaTipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public void selectTank(){
        for (Tanque tanque : tanques) {
            System.out.println(tanque.getNum()+": "+tanque.getTipoPez().getNombre());
        }
    }
    public void showTankStatus(){
        for (Tanque tanque : tanques) {
            tanque.showStatus();
        }
    }

    public void showFishStatus(){
        for (Tanque tanque : tanques) {
            tanque.showFishStatus();
        }
    }

    public void showCapacity(){
        
    }
    

}
