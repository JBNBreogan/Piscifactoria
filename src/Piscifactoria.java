import java.util.ArrayList;
import java.util.Scanner;

import Tanque.Tanque;
import propiedades.CriaTipo;

public class Piscifactoria {
    
    private String nombre;
    private CriaTipo tipo;
    private ArrayList<Tanque> tanques;
    private Scanner sc;
    private int comida;

    public Piscifactoria(String nombre, CriaTipo tipo) {
        this.nombre = nombre;
        if(tipo == CriaTipo.RIO ){
            tanques.add(new Tanque(25));
            this.comida = 25;
        } else if(tipo == CriaTipo.MAR){
            tanques.add(new Tanque(100));
            this.comida = 100;
        }
    }

    public int selectTank(){
        for (Tanque tanque : tanques) {
            System.out.println(tanque.getNum()+": "+tanque.getTipoPez().getNombre());
        }
        int opcion = sc.nextInt();
        return opcion-1;
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
        Tanque t = tanques.get(selectTank());
        t.showCapacity();
    }
    
    public void nextDay(){
        for (Tanque tanque : tanques) {
            tanque.nextDay();
        }
    }

    public void sellFish(){

    }

    public void upgradeFood(){

    }
}
