package Comun;
import java.util.ArrayList;

import Piscifactoria.Piscifactoria;

public class AlmacenCentral {

    private int comidaAnimal = 0;
    private int comidaVegetal = 0;

    private int capacidadcomidaanimal;
    private int capacidadcomidavegetal;

    private AlmacenCentral(){
        this.capacidadcomidaanimal = 200;
        this.capacidadcomidavegetal = 200;
    }

    
    public int getComidaAnimal() {
        return comidaAnimal;
    }

    public int getComidaVegetal() {
        return comidaVegetal;
    }

    public int getCapacidadComidaAnimal() {
        return capacidadcomidaanimal;
    }

    public int getCapacidadComidaVegetal() {
        return capacidadcomidavegetal;
    }

    public int cogerComidaAnimal(int cantidad) {
        if(comidaAnimal>=cantidad){
            comidaAnimal-=cantidad;
            return cantidad;
        }
            return 0;
    }
    
   
    public int cogerComidaVegetal(int cantidad) {
        if(comidaVegetal>=cantidad){
            comidaVegetal-=cantidad;
            return cantidad;
        }
            return 0;
    }

    public void addFood(int cantidad, String tipo){
        if(tipo == "Animal"){
            comidaAnimal+=cantidad;
        } else if (tipo == "Vegetal"){
            comidaVegetal+=cantidad;
        }
    }


    public void repartir(ArrayList<Piscifactoria> piscifactorias){
        
        int comidaanimalarepartir=comidaAnimal/piscifactorias.size();
        int comidavegetalarepartir=comidaVegetal/piscifactorias.size();
      
        for (Piscifactoria piscifactoria : piscifactorias) {
            piscifactoria.addFood(comidaanimalarepartir, "Animal");
            piscifactoria.addFood(comidavegetalarepartir, "Vegetal");
        }
    }
    
    public void aumentarCapacidad(int capacidad){
        this.capacidadcomidaanimal+=capacidad;
        this.capacidadcomidavegetal+=capacidad;
    }

    
}