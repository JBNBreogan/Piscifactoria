import java.util.ArrayList;
import java.util.Scanner;

import Comun.Monedero;
import Tanque.Tanque;
import peces.Pez;
import peces.Propiedades.Carnivoro;
import peces.Propiedades.Filtrador;
import peces.Propiedades.Omnivoro;
import propiedades.CriaTipo;
import helpers.*;

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

    public void showStatus(){
        System.out.println("=============== "+getNombre()+" ===============");
        System.out.println("Tanques: "+tanques.size());
        System.out.println("Ocupación: "+pecesEnPiscifactoria()+"/"+pecesMaxPiscifactoria()+"("+PorcentajeHelper.hacerProcentaje(pecesEnPiscifactoria(), pecesMaxPiscifactoria())+")");
        System.out.println("Peces vivos: "+pecesVivosPiscifactoria()+"/"+pecesEnPiscifactoria()+"("+PorcentajeHelper.hacerProcentaje(pecesVivosPiscifactoria(), pecesEnPiscifactoria())+")");
        System.out.println("Peces alimentados: "+pecesAlimentadosPiscifactoria()+"/"+pecesVivosPiscifactoria()+"("+PorcentajeHelper.hacerProcentaje(pecesAlimentadosPiscifactoria(), pecesVivosPiscifactoria())+")");
        System.out.println("Peces adultos: "+pecesAdultosPiscifactoria()+"/"+pecesVivosPiscifactoria()+"("+PorcentajeHelper.hacerProcentaje(pecesAdultosPiscifactoria(), pecesVivosPiscifactoria())+")");
        System.out.println("Hembras/Machos: "+pecesMachoPiscifactoria()+"/"+pecesHembraPiscifactoria()+"("+PorcentajeHelper.hacerProcentaje(pecesEnPiscifactoria(), pecesMaxPiscifactoria())+")");
        System.out.println("Fértiles: "+pecesFertilesPiscifactoria()+"/"+pecesVivosPiscifactoria()+"("+PorcentajeHelper.hacerProcentaje(pecesEnPiscifactoria(), pecesMaxPiscifactoria())+")");
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
            for (Pez pez : tanque.getPeces()) {
                if(pez instanceof Carnivoro){
                    tanque.nextDay(comidaAnimal);
                }
                if(pez instanceof Filtrador){
                    tanque.nextDay(comidaVegetal);
                }
                if(pez instanceof Omnivoro){
                    if(comidaAnimal>=comidaVegetal){
                        tanque.nextDay(comidaAnimal);
                    } else {
                        tanque.nextDay(comidaVegetal);
                    }
                }
            }
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

    public int pecesEnPiscifactoria(){
        int pecestotales = 0;
        for (Tanque tanque : tanques) {
            pecestotales += tanque.getPeces().size();
        }
        return pecestotales;
    }

    public int pecesMaxPiscifactoria(){
        int pecesmaxtotales = 0;
        for (Tanque tanque : tanques) {
            pecesmaxtotales += tanque.getMaxPeces();
        }
        return pecesmaxtotales;
    }

    public int pecesVivosPiscifactoria(){
        int pecesvivos = 0;
        for (Tanque tanque : tanques) {
            pecesvivos += tanque.pecesVivos();
        }
        return pecesvivos;
    }

    public int pecesAlimentadosPiscifactoria(){
        int pecesalimentadostotales = 0;
        for (Tanque tanque : tanques) {
            pecesalimentadostotales += tanque.pecesAlimentados();
        }
        return pecesalimentadostotales;
    }

    public int pecesAdultosPiscifactoria(){
        int pecesadultostotales = 0;
        for (Tanque tanque : tanques) {
            pecesadultostotales += tanque.pecesAdultos();
        }
        return pecesadultostotales;
    }

    public int pecesMachoPiscifactoria(){
        int pecesmachototales = 0;
        for (Tanque tanque : tanques) {
            pecesmachototales += tanque.pecesMacho();
        }
        return pecesmachototales;
    }

    public int pecesHembraPiscifactoria(){
        int peceshembratotales = 0;
        for (Tanque tanque : tanques) {
            peceshembratotales += tanque.pecesHembra();
        }
        return peceshembratotales;
    }

    public int pecesFertilesPiscifactoria(){
        int pecesfertilestotales = 0;
        for (Tanque tanque : tanques) {
            pecesfertilestotales += tanque.pecesFertiles();
        }
        return pecesfertilestotales;
    }

    public void addFood(int cantidad, String tipo){
        if(tipo == "Animal"){
            comidaAnimal+=cantidad;
        } else if (tipo == "Vegetal"){
            comidaVegetal+=cantidad;
        }
    }
    
    public int[] venta(){
        int totalpeces = 0;
        int totalmonedastanques = 0;
        for (Tanque tanque : tanques) {
            int[] currTankValues = tanque.ventaPecesOptimos();
            totalmonedastanques += currTankValues[0];
            totalpeces += currTankValues[1];
        }
        System.out.println("Piscifactoria "+getNombre()+": "+totalpeces+" peces vendidos por "+totalmonedastanques+" monedas");
        int[] retorno = {totalmonedastanques,totalpeces};
        return retorno;
    }

    public boolean comidaAnimalLlena(){
        if(comidaAnimal<maxComidaAnimal){
            return false;
        } else {
            return true;
        }
    }

    public boolean comidaVegetalLlena(){
        if(comidaVegetal<maxComidaVegetal){
            return false;
        } else {
            return true;
        }
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
