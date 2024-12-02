package piscifactoria;
import java.io.IOException;
import java.util.ArrayList;

import comun.*;
import peces.Pez;
import propiedades.CriaTipo;
import tanque.Tanque;
import helpers.*;

/**
 * Clase que representa una piscifactoría, contiene uno o varios tanques de peces, donde se gestiona todas las operaciones relacionados con ellos.
 * 
 * @author Nicolás
 */

public class Piscifactoria {
    
    /**
     * Nombre de la piscifactoría
     */
    private String nombre;
    /**
     * Tipo de la piscifactoría
     */
    private CriaTipo tipo;
    /**
     * Tanques de la piscifactoría
     */
    private ArrayList<Tanque> tanques;
    /**
     * Cantidad de comidad vegetal
     */
    private int comidaVegetal = 0;
    /**
     * Cantidad de comida animal
     */
    private int comidaAnimal = 0;
    /**
     * Cantidad máxima de comida animal
     */
    private int maxComidaAnimal;
    /**
     * Cantidad máxima de comida vegetal
     */
    private int maxComidaVegetal;
    /**
    * Objeto Monedero que se encarga de gestionar el sistema de monedas de la piscifactoría.
    */
    private Monedero monedero=Monedero.getInstance();


    /**
     * Constructor para una piscifactoría de tipo RIO con cantidades iniciales
     * de alimento si es la primera vez que se crea.
     * 
     * @param nombre El nombre de la piscifactoría.
     * @param tipo El tipo de cría, puede ser de río o de mar.
     * @param primera Si es la primera vez que se crea la piscifactoría.
     */
    public Piscifactoria(String nombre, boolean primera) {
        this.nombre = nombre;
        this.tipo = CriaTipo.RIO;
        tanques = new ArrayList<>();
        tanques.add(new Tanque(25,CriaTipo.RIO));
        this.maxComidaVegetal = 25;
        this.maxComidaAnimal = 25;
        this.comidaAnimal = 25;
        this.comidaVegetal = 25; 
    }
   
    /**
     * Constructor para crear una piscifactoría de tipo específico, sin cantidades
     * iniciales de comida.
     * 
     * @param nombre El nombre de la piscifactoría.
     * @param tipo El tipo de cría: puede ser RIO o MAAR.
     */
    public Piscifactoria(String nombre, CriaTipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        if(tipo == CriaTipo.RIO ){
            tanques = new ArrayList<>();
            tanques.add(new Tanque(25,CriaTipo.RIO));
            this.maxComidaVegetal = 25;
            this.maxComidaAnimal = 25;
        } else if(tipo == CriaTipo.MAR){
            tanques = new ArrayList<>();
            tanques.add(new Tanque(100,CriaTipo.MAR));
            this.maxComidaVegetal = 100;
            this.maxComidaAnimal = 100;
        }
    }

     /**
     * Devuelve el nombre de la piscifactoría.
     * @return El nombre de la piscifactoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el tipo de cría de la piscifactoría. 
     * @return El tipo de cría.
     */
    public CriaTipo getTipo() {
        return tipo;
    }
    
    /**
     * Devuelve la lista de tanques en la piscifactoría.
     * @return Lista de tanques.
     */
    public ArrayList<Tanque> getTanques() {
        return tanques;
    }

    /**
     * Devuelve la cantidad de comida vegetal disponible.
     * @return La cantidad de comida vegetal.
     */
    public int getComidaVegetal() {
        return comidaVegetal;
    }

    /**
     * Devuelve la cantidad de comida animal disponible.
     * @return La cantidad de comida animal.
     */
    public int getComidaAnimal() {
        return comidaAnimal;
    }

    /**
     * Devuelve la capacidad máxima de comida animal. 
     * @return La capacidad máxima de comida animal.
     */
    public int getMaxComidaAnimal() {
        return maxComidaAnimal;
    }

    /**
     * Devuelve la capacidad máxima de comida vegetal.
     * @return La capacidad máxima de comida vegetal.
     */
    public int getMaxComidaVegetal() {
        return maxComidaVegetal;
    }

     /**
     * Devuelve el monedero asociado a la piscifactoría.
     * @return El monedero.
     */
    public Monedero getMonedero() {
        return monedero;
    }


    /**
     * Muestra el estado general de la piscifactoría, incluyendo el número de peces
     * totales, alimentados, adultos y fértiles.
     */
    public void showStatus(){
        System.out.println("=============== "+getNombre()+" ===============");
        System.out.println("Tanques: "+tanques.size());
        int pecesMaxEnPisc=this.pecesMaxPiscifactoria();
        int pecesEnPisc=this.pecesEnPiscifactoria();
        int pecesVivosEnPisc=this.pecesVivosPiscifactoria();
        int pecesAlimentEnPisc=this.pecesAlimentadosPiscifactoria();
        int peceAdultEnPisc=this.pecesAdultosPiscifactoria();
    
        int ocupacionPorcentaje = (pecesMaxEnPisc != 0) ? ((pecesEnPisc * 100) / pecesMaxEnPisc) : 0;
        System.out.println("Ocupación: "+pecesEnPisc+"/"+pecesMaxEnPisc+"("+ocupacionPorcentaje+"%)");
    
        int pecesVivosPorcentaje = (pecesEnPisc != 0) ? ((pecesVivosEnPisc * 100) / pecesEnPisc) : 0;
        System.out.println("Peces vivos: "+pecesVivosEnPisc+"/"+pecesEnPisc+"("+pecesVivosPorcentaje+"%)");
    
        int pecesAlimentadosPorcentaje = ((pecesVivosEnPisc != 0) ? ((pecesAlimentEnPisc * 100) / pecesVivosEnPisc)  : 0);
        System.out.println("Peces alimentados: "+pecesAlimentEnPisc+"/"+pecesVivosEnPisc+"("+pecesAlimentadosPorcentaje+"%)");
    
        int pecesAdultosPorcentaje = (pecesVivosEnPisc != 0) ? ((peceAdultEnPisc * 100) / pecesVivosEnPisc) : 0;
        System.out.println("Peces adultos: "+peceAdultEnPisc+"/"+pecesVivosEnPisc+"("+pecesAdultosPorcentaje+"%)");
    
        System.out.println("Hembras/Machos: "+this.pecesHembraPiscifactoria()+"/"+this.pecesMachoPiscifactoria());
    
        System.out.println("Fértiles: "+this.pecesFertilesPiscifactoria()+"/"+pecesVivosEnPisc);
    
        int comidaAnimalPorcentaje = (this.maxComidaAnimal != 0) ? ((this.comidaAnimal * 100) / this.maxComidaAnimal) : 0;
        System.out.println("Almacén de comida animal: "+ this.comidaAnimal+"/"+this.maxComidaAnimal+"("+comidaAnimalPorcentaje+"%)");
    
        int comidaVegetalPorcentaje = (this.maxComidaVegetal != 0) ? ((this.comidaVegetal * 100) / this.maxComidaVegetal) : 0;
        System.out.println("Almacén de comida vegetal: "+ this.comidaVegetal+"/"+this.maxComidaVegetal+"("+comidaVegetalPorcentaje+"%)");
    }    

    /**
     * Permite al usuario seleccionar un tanque de la piscifactoría. 
     * @return El índice del tanque seleccionado.
     * @throws IOException 
     */
    public int selectTank() throws IOException{
        for (Tanque tanque : tanques) {
            System.out.println("Tanque "+(tanques.indexOf(tanque)+1)+": "+tipo);
        }
        int opcion = InputHelper.GetIntWithBuffRead();
        return opcion-1;
    }

    /**
     * Muestra el estado de cada tanque de la piscifactoría.
     */
    public void showTankStatus(){
        for (Tanque tanque : tanques) {
            tanque.showStatus(tanques.indexOf(tanque));
        }
    }

    /**
     * Muestra el estado de los peces en cada tanque.
     */
    public void showFishStatus(){
        for (Tanque tanque : tanques) {
            tanque.showFishStatus();
        }
    }

     /**
     * Muestra la capacidad del tanque seleccionado por el usuario.
     * @throws IOException 
     */
    public void showCapacity() throws IOException{
        Tanque t = tanques.get(selectTank());
        t.showCapacity(tanques.indexOf(t));
    }
    
    /**
    * Avanza un día en la piscifactoría, actualizando los tanques y el estado de los peces.
    */
    public int[] nextDay(estadisticas.Estadisticas stats){
        int totalpeces = 0;
        int totalmonedastanques = 0;        
        for (Tanque tanque : tanques) {
            int[] currTankValues = tanque.nextDay(this,stats);
            totalmonedastanques += currTankValues[0];
            totalpeces += currTankValues[1];
        }
        System.out.println("Piscifactoria "+getNombre()+": "+totalpeces+" peces vendidos por "+totalmonedastanques+" monedas");
        int[] retorno = {totalmonedastanques,totalpeces};
        return retorno;
    }

     /**
     * Vende los peces adultos y vivos de la piscifactoría, actualizando las monedas.
     */
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

    /**
     * Mejora la capacidad de almacenamiento de comida de la piscifactoría.
     */
    public void upgradeFood(){
        if(tipo == CriaTipo.RIO){
            this.maxComidaAnimal=+25;
            this.maxComidaVegetal=+25;
        } else if(tipo == CriaTipo.MAR){
            this.maxComidaAnimal=+100;
            this.maxComidaVegetal=+100;
        }
        System.out.println("Almacén de comida de la piscifactoría "+this.nombre+" mejorado. Su capacidad ha aumentado en "+ ((tipo == CriaTipo.RIO) ? "25" : "100") +" hasta un total de "+maxComidaAnimal);
    }

    /**
     * Calcula el número total de peces en la piscifactoría.
     * @return El número total de peces.
     */
    public int pecesEnPiscifactoria(){
        int pecestotales = 0;
        for (Tanque tanque : tanques) {
            pecestotales += tanque.getPeces().size();
        }
        return pecestotales;
    }

     /**
     * Calcula el número máximo de peces que pueden vivir en la piscifactoría.
     * @return El número máximo de peces.
     */
    public int pecesMaxPiscifactoria(){
        int pecesmaxtotales = 0;
        for (Tanque tanque : tanques) {
            pecesmaxtotales += tanque.getMaxPeces();
        }
        return pecesmaxtotales;
    }

    /**
     * Calcula el número de peces vivos en la piscifactoría.
     * @return El número de peces vivos.
     */
    public int pecesVivosPiscifactoria(){
        int pecesvivos = 0;
        for (Tanque tanque : tanques) {
            pecesvivos += tanque.pecesVivos();
        }
        return pecesvivos;
    }

      /**
     * Calcula el número de peces alimentados en la piscifactoría.
     * @return El número de peces alimentados.
     */
    public int pecesAlimentadosPiscifactoria(){
        int pecesalimentadostotales = 0;
        for (Tanque tanque : tanques) {
            pecesalimentadostotales += tanque.pecesAlimentados();
        }
        return pecesalimentadostotales;
    }

    /**
     * Calcula el número de peces adultos en la piscifactoría.
     * @return El número de peces adultos.
     */
    public int pecesAdultosPiscifactoria(){
        int pecesadultostotales = 0;
        for (Tanque tanque : tanques) {
            pecesadultostotales += tanque.pecesAdultos();
        }
        return pecesadultostotales;
    }

    /**
     * Calcula el número de peces machos en la piscifactoría.
     * @return El número de peces machos.
     */
    public int pecesMachoPiscifactoria(){
        int pecesmachototales = 0;
        for (Tanque tanque : tanques) {
            pecesmachototales += tanque.pecesMacho();
        }
        return pecesmachototales;
    }

    /**
     * Calcula el número de peces hembras en la piscifactoría.
     * @return El número de peces hembras.
     */
    public int pecesHembraPiscifactoria(){
        int peceshembratotales = 0;
        for (Tanque tanque : tanques) {
            peceshembratotales += tanque.pecesHembra();
        }
        return peceshembratotales;
    }

    /**
     * Calcula el número de peces fértiles en la piscifactoría. 
     * @return El número de peces fértiles.
     */
    public int pecesFertilesPiscifactoria(){
        int pecesfertilestotales = 0;
        for (Tanque tanque : tanques) {
            pecesfertilestotales += tanque.pecesFertiles();
        }
        return pecesfertilestotales;
    }


    /**
     * Añade una cantidad de comida a la piscifactoría.
     * @param cantidad La cantidad de comida a añadir.
     * @param tipo El tipo de comida (Animal o Vegetal).
     */
    public void addFood(int cantidad, String tipo){
        if(tipo == "Animal"){
            comidaAnimal+=cantidad;
        } else if (tipo == "Vegetal"){
            comidaVegetal+=cantidad;
        }
    }

     /**
     * Reduce la cantidad de comida en la piscifactoría.
     * @param cantidad La cantidad de comida a reducir.
     * @param tipo El tipo de comida (Animal o Vegetal).
     */
    public void restFood(int cantidad, String tipo){
        if(tipo == "Animal"){
            comidaAnimal-=cantidad;
        } else if (tipo == "Vegetal"){
            comidaVegetal-=cantidad;
        }
    }

    /**
     * Vende los peces más óptimos (adultos y vivos) y devuelve el número total de peces vendidos
     * y la cantidad de monedas obtenidas.
     * @return Un array de dos enteros: la cantidad de monedas y el número de peces vendidos.
     */
    public int[] venta(estadisticas.Estadisticas stats){
        int totalpeces = 0;
        int totalmonedastanques = 0;
        for (Tanque tanque : tanques) {
            int[] currTankValues = tanque.ventaPecesOptimos(stats);
            totalmonedastanques += currTankValues[0];
            totalpeces += currTankValues[1];
        }
        System.out.println("Piscifactoria "+getNombre()+": "+totalpeces+" peces vendidos por "+totalmonedastanques+" monedas");
        int[] retorno = {totalmonedastanques,totalpeces};
        return retorno;
    }

    /**
     * Verifica si la capacidad de comida animal ha alcanzado su límite.
     * @return True si la capacidad está llena, de lo contrario False.
     */
    public boolean comidaAnimalLlena(){
        if(comidaAnimal<maxComidaAnimal){
            return false;
        } else {
            return true;
        }
    }

     /**
     * Verifica si la capacidad de comida vegetal ha alcanzado su límite.
     * @return True si la capacidad está llena, de lo contrario False.
     */
    public boolean comidaVegetalLlena(){
        if(comidaVegetal<maxComidaVegetal){
            return false;
        } else {
            return true;
        }
    }


    /**
     * Verifica si la comida animal se ha agotado. 
     * @return True si no queda comida animal, de lo contrario False.
     */
    public boolean comidaAnimalVacia(){
        if(comidaAnimal==0){
            return true;
        }
        return false;
    }

     /**
     * Verifica si la comida vegetal se ha agotado. 
     * @return True si no queda comida vegetal, de lo contrario False.
     */
    public boolean comidaVegetalVacia(){
        if(comidaVegetal==0){
            return true;
        }
        return false;
    }

    
}
