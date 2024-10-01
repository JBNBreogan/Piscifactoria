package Tanque;

import java.util.ArrayList;
import peces.Pez;
import propiedades.PecesDatos;

public class Tanque {

    private int numTanque;
    private ArrayList<Pez> peces;
    private int maxPeces;
    private PecesDatos tipoPez;

    public Tanque(int maxPeces) {
        this.maxPeces = maxPeces;
    }

    public void showStatus(){
        System.out.println("============Tanque "+ numTanque + "============");
        System.out.println("Ocupación: " + pecesEnTanque() +" / "+ maxPeces + " (" + porcentajeOcupacion + "%)");
        System.out.println("Peces vivos: " + pecesVivos() +" / "+pecesEnTanque() + " (" + porcentajeVivos + "%)" );
        System.out.println("Peces alimentados: " + pecesAlimentados() +" / "+ pecesVivos() + " (" + porcentajeAlimentados + "%)");
        System.out.println("Peces adultos: " + pecesAdultos() +" / "+ pecesVivos() + " (" + porcentajeAlimentados + "%)");
        System.out.println(pecesHembra()+" / "+pecesMacho() + "H/M");
        System.out.println("Fértiles: " + pecesFertiles()+" / "+pecesVivos());
    }

    public void showFishStatus(){
        for (Pez pez : peces) {
            pez.showStatus();
        }
    }

    public void showCapacity(){
        System.out.println("Tanque " + numTanque +"al "+ porcentajeOcupacion + "% de capacidad [" + pecesEnTanque +"/"+ maxPeces + "].");
    }

    public void nextDay(){
        for (Pez pez : peces) {
            pez.nextDay();
        }
    }

    public int pecesEnTanque(){
        return peces.size();
    }

    public  int pecesVivos(){
        int contadorPecesVivos=0;
        for (Pez pez : peces) {
            if(pez.isAlive()){
                contadorPecesVivos+=1;
            }
        }
        return contadorPecesVivos;
    }

    public  int pecesAlimentados(){
        int contadorPecesAlimentados=0;
        for (Pez pez : peces) {
            if(pez.isAlimentado()){
                contadorPecesAlimentados+=1;
            }
        }
        return contadorPecesAlimentados;
    }

    public  int pecesAdultos(){
        int contadorPecesAdultos=0;
        for (Pez pez : peces) {
            if(pez.isAdulto()){
                contadorPecesAdultos+=1;
            }
        }
        return contadorPecesAdultos;
    }

    public  int pecesHembra(){
        int contadorPecesHembra=0;
        for (Pez pez : peces) {
            if(pez.getSex()=='H'){
                contadorPecesHembra+=1;
            }
        }
        return contadorPecesHembra;
    }

    public  int pecesMacho(){
        int contadorPecesMacho=0;
        for (Pez pez : peces) {
            if(pez.getSex()=='M'){
                contadorPecesMacho+=1;
            }
        }
        return contadorPecesMacho;
    }

    public int pecesFertiles(){
        int contadorPecesFertiles=0;
        for (Pez pez : peces) {
            if(pez.isFertile()){
                contadorPecesFertiles+=1;
            }
        }
        return contadorPecesFertiles;
    }

    public int getNumTanque() {
        return numTanque;
    }

    public void setNumTanque(int numTanque) {
        this.numTanque = numTanque;
    }

    public ArrayList<Pez> getPeces() {
        return peces;
    }

    public void setPeces(ArrayList<Pez> peces) {
        this.peces = peces;
    }

    public int getMaxPeces() {
        return maxPeces;
    }

    public void setMaxPeces(int maxPeces) {
        this.maxPeces = maxPeces;
    }

    public PecesDatos getTipoPez() {
        return tipoPez;
    }

    public void setTipoPez(PecesDatos tipoPez) {
        this.tipoPez = tipoPez;
    }
}
