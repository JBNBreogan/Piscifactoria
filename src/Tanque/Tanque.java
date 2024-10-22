package Tanque;

import java.util.ArrayList;
import peces.Pez;
import peces.Propiedades.Carnivoro;
import peces.Propiedades.Filtrador;
import peces.Propiedades.Omnivoro;
import propiedades.CriaTipo;
import propiedades.PecesDatos;
import helpers.PorcentajeHelper;
import Comun.AlmacenCentral;
import Comun.Monedero;
import Piscifactoria.Piscifactoria;

/**
 * Clase tanque 
 * @author Cristian
 */
public class Tanque {

    //**Número del tanque en la piscifactoria **/
    private int numTanque;
    //**Lista de peces en el tanque **/
    private ArrayList<Pez> peces;
    //**Número máximo de peces que puede haber en el tanque **/
    private int maxPeces;
    //**Tipo de pez existente en el tanque **/
    private PecesDatos tipoPez;
    //**Monedero **/
    private Monedero monedero=Monedero.getInstance();

    private AlmacenCentral almacenCentral=AlmacenCentral.getInstance();

    public Tanque(int maxPeces) {
        this.maxPeces = maxPeces;
    }

    /**
     * Metodo que muestra las estadisiticas del tanque 
     */
    public void showStatus(){
        System.out.println("============Tanque "+ numTanque + "============");
        System.out.println("Ocupación: " + pecesEnTanque() +" / "+ maxPeces + " (" + PorcentajeHelper.hacerProcentaje(pecesEnTanque(), maxPeces) + "%)");
        System.out.println("Peces vivos: " + pecesVivos() +" / "+pecesEnTanque() + " (" + PorcentajeHelper.hacerProcentaje(pecesVivos(), pecesEnTanque()) + "%)" );
        System.out.println("Peces alimentados: " + pecesAlimentados() +" / "+ pecesVivos() + " (" + PorcentajeHelper.hacerProcentaje(pecesAlimentados(), pecesVivos()) + "%)");
        System.out.println("Peces adultos: " + pecesAdultos() +" / "+ pecesVivos() + " (" + PorcentajeHelper.hacerProcentaje(pecesAdultos(), pecesVivos()) + "%)");
        System.out.println(pecesHembra()+" / "+pecesMacho() + "H/M");
        System.out.println("Fértiles: " + pecesFertiles()+" / "+pecesVivos());
    }

    /**
     * Método que muestra las estadisticas de todos los peces del tanque
     */
    public void showFishStatus(){
        for (Pez pez : peces) {
            pez.showStatus();
        }
    }

    /**
     * Metodo que muestra informacion de la capacidad del tanque 
     */
    public void showCapacity(){
        System.out.println("Tanque " + numTanque +"al "+ PorcentajeHelper.hacerProcentaje(pecesEnTanque(), maxPeces) + "% de capacidad [" + pecesEnTanque() +"/"+ maxPeces + "].");
    }

    /**
     * Método que avanza un día, alimenta los peces del tanque, reproduce los peces y vende los peces que esten en su estado optimo.
     * @param comida Cantidad de comida disponible en la piscifactoria
     */
    public void nextDay(Piscifactoria pisci){
        int pecesHembraFertiles=0;
        int pecesMachoFertiles=0;

        boolean vegetal=true;
            if(this.peces.get(0) instanceof Carnivoro){
                vegetal=false;
            }else if(this.peces.get(0) instanceof Filtrador){
                vegetal=true;
            }else if(this.peces.get(0) instanceof Omnivoro){
                if(pisci.getComidaAnimal()>=pisci.getComidaVegetal()){
                    vegetal=false;
                } else {
                    vegetal=true;
                }
            }

        /*
         * Recorro la lista de peces y 
         * compruebo si hay peces hembra y macho fertiles.
         */
        for (Pez pez : peces) {
            int comidaCons = pez.grow(vegetal ? pisci.getComidaVegetal() : pisci.getComidaAnimal());
            pisci.restFood(comidaCons, vegetal ? "Vegetal" : "Animal");
            if(vegetal && pisci.comidaVegetalVacia()){
                pisci.addFood(almacenCentral.cogerComidaVegetal(2), "Vegetal");
            }else if(!vegetal && pisci.comidaAnimalVacia()){
                pisci.addFood(almacenCentral.cogerComidaAnimal(2), "Animal");
           }

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
                                pez.notFertil();
                                pez.resetPuesta();
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

    /**
     * Método que devuelve la cantidad de peces que hay en el tanque
     * @return Número de peces
     */
    public int pecesEnTanque(){
        return peces.size();
    }

    /**
     * Método que devuelve la cantidad de peces vivos en el tanque
     * @return Número de peces vivos
     */
    public  int pecesVivos(){
        int contadorPecesVivos=0;
        for (Pez pez : peces) {
            if(pez.isAlive()){
                contadorPecesVivos+=1;
            }
        }
        return contadorPecesVivos;
    }

    /**
     * Método que devuelve la cantidad de peces alimentados en el tanque 
     * @return Número de peces alimentados
     */
    public  int pecesAlimentados(){
        int contadorPecesAlimentados=0;
        for (Pez pez : peces) {
            if(pez.isAlimentado()){
                contadorPecesAlimentados+=1;
            }
        }
        return contadorPecesAlimentados;
    }

    /**
     * Método que devuelve la cantidad de peces adultos en el tanque 
     * @return Número de peces adultos
     */
    public  int pecesAdultos(){
        int contadorPecesAdultos=0;
        for (Pez pez : peces) {
            if(pez.isAdulto()){
                contadorPecesAdultos+=1;
            }
        }
        return contadorPecesAdultos;
    }

    /**
     * Método que devuelve la cantidad de peces hembra en el tanque 
     * @return Número de peces hembra
     */
    public  int pecesHembra(){
        int contadorPecesHembra=0;
        for (Pez pez : peces) {
            if(pez.isFemale()){
                contadorPecesHembra+=1;
            }
        }
        return contadorPecesHembra;
    }

    /**
     * Método que devuelve la cantidad de peces macho en el tanque 
     * @return Número de peces macho
     */
    public  int pecesMacho(){
        int contadorPecesMacho=0;
        for (Pez pez : peces) {
            if(!pez.isFemale()){
                contadorPecesMacho+=1;
            }
        }
        return contadorPecesMacho;
    }

    /**
     * Método que devuelve la cantidad de peces fértiles en el tanque 
     * @return Número de peces fértiles
     */
    public int pecesFertiles(){
        int contadorPecesFertiles=0;
        for (Pez pez : peces) {
            if(pez.isFertile()){
                contadorPecesFertiles+=1;
            }
        }
        return contadorPecesFertiles;
    }

    /**
     * Método que vende todos los peces optimos del tanque 
     * @return Valores de monedas obtenidas con la venta y númerod de peces vendidos
     */
    public int[] ventaPecesOptimos(){
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

    //Getters

    public int getNumTanque() {
        return numTanque;
    }

    public ArrayList<Pez> getPeces() {
        return peces;
    }

    public int getMaxPeces() {
        return maxPeces;
    }

    public PecesDatos getTipoPez() {
        return tipoPez;
    }
}
