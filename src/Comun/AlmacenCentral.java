package Comun;
import java.util.ArrayList;

import Piscifactoria.Piscifactoria;

public class AlmacenCentral {

    private static AlmacenCentral instance;
    private int comidaAnimal = 0;
    private int comidaVegetal = 0;

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
        boolean todasllenas = false;
        int comidaanimalarepartir=comidaAnimal/piscifactorias.size();
        int comidavegetalarepartir=comidaVegetal/piscifactorias.size();

        for (Piscifactoria piscifactoria : piscifactorias) {
            if(piscifactoria.comidaAnimalLlena() && piscifactoria.comidaVegetalLlena()){
                todasllenas = true;
            } else {
                todasllenas = false;
                break;
            }
        }
        if(!todasllenas || !(comidaAnimal == 0 && comidaVegetal == 0)){
            for (Piscifactoria piscifactoria : piscifactorias) {
                if(piscifactoria.getMaxComidaAnimal()>comidaanimalarepartir+piscifactoria.getComidaAnimal()){
                   
                    int restar = (piscifactoria.getMaxComidaAnimal()-piscifactoria.getComidaAnimal());
                    if(restar>comidaanimalarepartir){
                        comidaAnimal=-comidaanimalarepartir;
                        piscifactoria.addFood(comidaanimalarepartir, "Animal");
                    } else{
                        comidaAnimal=-restar;
                        piscifactoria.addFood(restar, "Animal");
                    }
                }
                
                if(piscifactoria.getMaxComidaVegetal()>comidaanimalarepartir+piscifactoria.getComidaVegetal()){
                    int restar = (piscifactoria.getMaxComidaVegetal()-piscifactoria.getComidaVegetal());
                    if(restar>comidavegetalarepartir){
                        comidaVegetal=-comidavegetalarepartir;
                        piscifactoria.addFood(comidavegetalarepartir, "Vegetal");
                    } else{
                        comidaVegetal=-restar;
                        piscifactoria.addFood(restar, "Vegetal");
                    }

                }
                repartir(piscifactorias);
            }
        }
        
    }
    
    public void aumentarCapacidad(int capacidad){
        this.capacidadcomidaanimal+=capacidad;
        this.capacidadcomidavegetal+=capacidad;

    }
}
