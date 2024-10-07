import java.util.ArrayList;
import java.util.Scanner;

import Comun.Monedero;
import Tanque.Tanque;
import peces.Pez;
import propiedades.CriaTipo;

public class Piscifactoria {
    
    private String nombre;
    private CriaTipo tipo;
    private ArrayList<Tanque> tanques;
    private Scanner sc;
    private int comidaVegetal = 0;
    private int comidaAnimal = 0;
    private int maxComidaAnimal;
    private int maxComidaVegetal;
    private Monedero monedero=Monedero.getInstance();

    public Piscifactoria(String nombre, CriaTipo tipo) {
        this.nombre = nombre;
        if(tipo == CriaTipo.RIO ){
            tanques.add(new Tanque(25));
            this.maxComidaVegetal = 25;
            this.maxComidaAnimal = 25;
        } else if(tipo == CriaTipo.MAR){
            tanques.add(new Tanque(100));
            this.maxComidaVegetal = 100;
            this.maxComidaAnimal = 100;
        }
    }

    public int selectTank(){
        for (Tanque tanque : tanques) {
            System.out.println(tanque.getNumTanque()+": "+tanque.getTipoPez().getNombre());
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
        for (Tanque tanque : tanques) {
            for (Pez pez : tanque.getPeces()) {
                if(pez.isAdulto() && pez.isAlive()){
                    monedero.setMonedas(monedero.getMonedas()+pez.getMonedas());
                    tanque.getPeces().remove(pez);
                }
            }
        }
    }

    public void upgradeFood(){
        if(tipo == CriaTipo.RIO){
            this.maxComidaAnimal=+25;
            this.maxComidaVegetal=+25;
        } else if(tipo == CriaTipo.MAR){
            this.maxComidaAnimal=+100;
            this.maxComidaVegetal=+100;
        }
        System.out.println("Almacén de comida de la piscifactoría"+this.nombre+" mejorado. Su capacidad ha aumentado en"+ ((tipo == CriaTipo.RIO) ? "25" : "100") +"hasta un total de "+maxComidaAnimal);
    }

    public String getNombre() {
        return nombre;
    }

    public CriaTipo getTipo() {
        return tipo;
    }

    public ArrayList<Tanque> getTanques() {
        return tanques;
    }

    public Scanner getSc() {
        return sc;
    }

    public int getComidaVegetal() {
        return comidaVegetal;
    }

    public int getComidaAnimal() {
        return comidaAnimal;
    }

    public int getMaxComidaAnimal() {
        return maxComidaAnimal;
    }

    public int getMaxComidaVegetal() {
        return maxComidaVegetal;
    }

    public Monedero getMonedero() {
        return monedero;
    }
}
