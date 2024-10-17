package Tanque;

import java.util.ArrayList;
import peces.Pez;
import propiedades.PecesDatos;
import helpers.PorcentajeHelper;
import Comun.Monedero;

public class Tanque {

    private int numTanque;
    private ArrayList<Pez> peces;
    private int maxPeces;
    private PecesDatos tipoPez;
    private Monedero monedero=Monedero.getInstance();

    public Tanque(int maxPeces) {
        this.maxPeces = maxPeces;
    }

    public void showStatus(){
        System.out.println("============Tanque "+ numTanque + "============");
        System.out.println("Ocupación: " + pecesEnTanque() +" / "+ maxPeces + " (" + PorcentajeHelper.hacerProcentaje(pecesEnTanque(), maxPeces) + "%)");
        System.out.println("Peces vivos: " + pecesVivos() +" / "+pecesEnTanque() + " (" + PorcentajeHelper.hacerProcentaje(pecesVivos(), pecesEnTanque()) + "%)" );
        System.out.println("Peces alimentados: " + pecesAlimentados() +" / "+ pecesVivos() + " (" + PorcentajeHelper.hacerProcentaje(pecesAlimentados(), pecesVivos()) + "%)");
        System.out.println("Peces adultos: " + pecesAdultos() +" / "+ pecesVivos() + " (" + PorcentajeHelper.hacerProcentaje(pecesAdultos(), pecesVivos()) + "%)");
        System.out.println(pecesHembra()+" / "+pecesMacho() + "H/M");
        System.out.println("Fértiles: " + pecesFertiles()+" / "+pecesVivos());
    }

    public void showFishStatus(){
        for (Pez pez : peces) {
            pez.showStatus();
        }
    }

    public void showCapacity(){
        System.out.println("Tanque " + numTanque +"al "+ PorcentajeHelper.hacerProcentaje(pecesEnTanque(), maxPeces) + "% de capacidad [" + pecesEnTanque() +"/"+ maxPeces + "].");
    }

    public void nextDay(int comida){
        int pecesHembraFertiles=0;
        int pecesMachoFertiles=0;

        /*
         * Recorro la lista de peces y 
         * compruebo si hay peces hembra y macho fertiles.
         */
        for (Pez pez : peces) {
            pez.grow(comida);
            if (pez.isFemale() && pez.isFertile()) {
                pecesHembraFertiles+=1;
            }else if(!pez.isFemale() && pez.isFertile()){
                pecesMachoFertiles+=1;
            }
        }

        /*
         * Si hay alguna hembra y macho fertil cada una de las
         * hembras fertiles pone la cantidad de huevos de su
         * tipo de pez.
         */

        
        if(pecesHembra() > pecesMacho()){
            if(pecesHembraFertiles>=1 && pecesMachoFertiles>=1){
                for (Pez pez : peces) {
                    if(pez.isFemale() && pez.isFertile()){
                        for (int i = 0; i < pez.getHuevos(); i++) {
                            if(i%2==0){
                                pez.reproducirse(false);
                                //poner que no es fertil
                                //llamar a resetPuesta
                            }else{
                                pez.reproducirse(true);
                            }
                        }
                    }
                }
            }
        } else {
            if(pecesHembraFertiles>=1 && pecesMachoFertiles>=1){
                for (Pez pez : peces) {
                    if(pez.isFemale() && pez.isFertile()){
                        for (int i = 0; i < pez.getHuevos(); i++) {
                            if(i%2==0){
                                pez.reproducirse(true);
                            }else{
                                pez.reproducirse(false);
                            }
                        }
                    }
                }
            }
        }

        ventaPecesOptimos();
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
            if(pez.isFemale()){
                contadorPecesHembra+=1;
            }
        }
        return contadorPecesHembra;
    }

    public  int pecesMacho(){
        int contadorPecesMacho=0;
        for (Pez pez : peces) {
            if(!pez.isFemale()){
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

    public int[] ventaPecesOptimos(){
        /*
        * Recorre la lista de peces y vende los que esten
        * en su edad optima.
        */
        int[]valores=new int[2];
        
        int monedasObtenidas=0;
        int pecesVendidos=0;
        for (Pez pez : peces) {
            if(pez.getAge()==pez.getOptimo()){
                monedasObtenidas+=pez.getMonedas();
                peces.remove(pez);
                pecesVendidos++;
            }
        }
        monedero.setMonedas(monedero.getMonedas()+monedasObtenidas);
        valores[0]=monedasObtenidas;
        valores[1]=pecesVendidos;
        return valores;
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
