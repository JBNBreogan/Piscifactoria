package simulador;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

import estadisticas.Estadisticas;
import helpers.*;
import peces.doble.*;
import peces.mar.*;
import peces.Pez;
import peces.rio.*;
import piscifactoria.Piscifactoria;
import propiedades.AlmacenPropiedades;
import propiedades.CriaTipo;
import recompensas.Recompensas;
import registros.Transcripciones;
import saves.DTOPiscifactoria;
import saves.DTOSimulador;
import saves.SaveLoad;
import tanque.Tanque;
import registros.Registros;

import java.util.Random;

import comun.AlmacenCentral;
import comun.Monedero;
/**
 * Clase simulador
 * @author Cristian
 */
public class Simulador {
    //**Días avanzados en el sistema */
    private int dias = 1;
    /**Nombre con el que se inicia el sistema */
    private String nombreEmpresa;
    /**Objeto AlmacenCentral que representa el almacén compartido de comida y se utiliza para el manejo de inventario de alimentos en la piscifactoría. */
    private AlmacenCentral almacenCentral=null;
    /**Lista de las piscifactorias del sistema */
    private static ArrayList<Piscifactoria> piscifactorias = new ArrayList<>();
    /**Objeto Monedero que se encarga de gestionar las monedas generadas por la piscifactoría.*/
    private Monedero monedero=Monedero.getInstance();
    /**Objeto de estadisticas de los peces seleccionados */
    private estadisticas.Estadisticas stats=new Estadisticas(new String[]{
        AlmacenPropiedades.LUCIO_NORTE.getNombre(),
        AlmacenPropiedades.CARPA_PLATEADA.getNombre(),
        AlmacenPropiedades.CARPA.getNombre(),
        AlmacenPropiedades.TILAPIA_NILO.getNombre(),
        AlmacenPropiedades.PEJERREY.getNombre(),
        AlmacenPropiedades.RODABALLO.getNombre(),
        AlmacenPropiedades.CABALLA.getNombre(),
        AlmacenPropiedades.BESUGO.getNombre(),
        AlmacenPropiedades.ABADEJO.getNombre(),
        AlmacenPropiedades.SARGO.getNombre(),
        AlmacenPropiedades.TRUCHA_ARCOIRIS.getNombre(),
        AlmacenPropiedades.DORADA.getNombre()
    });
    /**Objeto de la clase Transcripciones */
    private Registros registros=null;
    
        /**
         * Constructor vacío de la clase simulador.
         */
        public Simulador() {
        }
    
        public String getNombreEmpresa() {
            return nombreEmpresa;
        }
    
        public int getDias() {
            return dias;
        }
    
        public Monedero getMonedero() {
            return monedero;
        }
    
        public ArrayList<Piscifactoria> getPiscifactorias() {
            return piscifactorias;
        }
    
        public AlmacenCentral getAlmacenCentral() {
            return almacenCentral;
        }
    
        /**
         * Método que inicializa el sistema, asignando el nombre del sistema, creando una piscifactoria y añadiendo 100 monedas.
         */
        public void init(){
            System.out.println("Nombre de la empresa:");
            nombreEmpresa = InputHelper.readStringWithBuffRead();
            System.out.println("Nombre de la piscifactoria");
            String npisc= InputHelper.readStringWithBuffRead();
            piscifactorias.add(new Piscifactoria(npisc,true));
            Monedero.getInstance().setMonedas(100);  
            registros = new Registros(nombreEmpresa);
            registros.inicio(npisc, null, new String[]{AlmacenPropiedades.LUCIO_NORTE.getNombre(),
                                              AlmacenPropiedades.CARPA_PLATEADA.getNombre(),
                                              AlmacenPropiedades.CARPA.getNombre(),
                                              AlmacenPropiedades.TILAPIA_NILO.getNombre(),
                                              AlmacenPropiedades.PEJERREY.getNombre(),
                                              AlmacenPropiedades.RODABALLO.getNombre(),
                                              AlmacenPropiedades.CABALLA.getNombre(),
                                              AlmacenPropiedades.BESUGO.getNombre(),
                                              AlmacenPropiedades.ABADEJO.getNombre(),
                                              AlmacenPropiedades.SARGO.getNombre(),
                                              AlmacenPropiedades.TRUCHA_ARCOIRIS.getNombre(),
                                              AlmacenPropiedades.DORADA.getNombre()}, monedero.getMonedas(), nombreEmpresa);
            ErrorHelper.createErrorFile();
            ErrorHelper.writeError("prueba de error");
        }
    
        /**
         * Método que muestra un menú con las opciones a realizar en el sistema.
         */
        public void menu(){
            MenuHelper.mostrarMenu(new String[] {"Estado general.", 
                                                "Estado piscifactoría.", 
                                                "Estado tanques.", 
                                                "Informes.", 
                                                "Ictiopedia.", 
                                                "Pasar día.", 
                                                "Comprar comida.", 
                                                "Comprar peces.", 
                                                "Vender peces.", 
                                                "Limpiar tanques.",
                                                "Vaciar tanque.",
                                                "Mejorar.",
                                                "Pasar varios días.",
                                                "Salir."},
                                                 false);
        }
    
        /**
         * Método que muestra la lista de piscifactorías actuales en forma de menú, más una opción 0 para salir.
         */
        public void menuPisc(){
            int i=0;
            System.out.println("Selecciones una opcione:");
            System.out.println("--------------------------- Piscifactorías ---------------------------");
            System.out.println("[Peces vivos / Peces totales / Espacio total]");
          
            for (Piscifactoria piscifactoria : piscifactorias) {
                i+=1;
                System.out.println(i + ".- " + piscifactoria.getNombre() + " [" + pecesVivosEnSist() + "/" + pecesTotalesEnSist() + "/" + espacioEnPisci(piscifactoria)+"]");
            }
    
            
        }     
    
        /**
         * Método que muestra el menú de piscifactorías y permite seleccionar una de ellas.
         * @return El número que ocupa en las lista de piscifactorias la seleccionada
         */
        public int selectPisc(){
            menuPisc();
            int opcion = InputHelper.getIntRanges(piscifactorias.size());
            return opcion-1;
            
        }
        
        /**
         * Método que muestra el menú de tanques y permite seleccionar un tanque, mostrando un menú de los disponibles.
         * @return El número que ocupa en la lista de tanques de una pisicfactoria el tanque seleccionado
         */
        public Tanque selectTank(){
            Piscifactoria pisc = piscifactorias.get(selectPisc());
            Tanque tank= pisc.getTanques().get(pisc.selectTank());
            return tank;
        }
    
        /**
         * Método que muestra el día actual, las monedas del sistema, el estado de todas las piscifactorías del sistema y en caso de tener 
         * la mejora del almacén central, muestra el estado de este también.
         */
        public void showGeneralStatus() {
            System.out.println("Empresa: " + this.nombreEmpresa);
            System.out.println("Día: " + this.dias);
            System.out.println("Monedas disponibles: " + monedero.getMonedas());
            
            if (almacenCentral != null) {
                int comidaAnimalPorcentaje = (almacenCentral.getCapacidadComidaAnimal() != 0) ? ((almacenCentral.getComidaAnimal() * 100) / almacenCentral.getCapacidadComidaAnimal()) : 0;
                System.out.println("Deposito de comida animal del almacen central al " + comidaAnimalPorcentaje 
                        + "% de su capacidad. [" + almacenCentral.getComidaAnimal() + "/" + almacenCentral.getCapacidadComidaAnimal() + "]");
                
                int comidaVegetalPorcentaje = (almacenCentral.getCapacidadComidaVegetal() != 0) ? ((almacenCentral.getComidaVegetal() * 100) / almacenCentral.getCapacidadComidaVegetal()) : 0;
                System.out.println("Deposito de comida vegetal del almacen central al " + comidaVegetalPorcentaje 
                        + "% de su capacidad. [" + almacenCentral.getComidaVegetal() + "/" + almacenCentral.getCapacidadComidaVegetal() + "]");
            }
        
            // Mostrar el estado de cada piscifactoría
            for (Piscifactoria pisc : piscifactorias) {
                pisc.showStatus();
            }
        }
        
        /**
         * Método que permite seleccionar una piscifactoria y muestra su estado.
         */
        public void showSpecificStatus(){
            Piscifactoria pisc = piscifactorias.get(selectPisc());
            pisc.showTankStatus();
        }
    
        /**
         * Método que permite seleccionar un tanque y muestra su estado.
         */
        public void showTankStatus(){
    
            Piscifactoria pisc = piscifactorias.get(selectPisc());
    
            Tanque tank = pisc.getTanques().get(pisc.selectTank());
    
            tank.showStatus(pisc.getTanques().indexOf(tank));
        }
    
        /**
         * Método que muestra el estado de todos los peces del sistema el número de ellos nacidos, el número de vendidos y las monedas obtenidas con esto, 
         * y por último un mensaje del total de estos datos en toda la piscifactoria.
         */
        public void showStats(){
            stats.mostrar();
        }
    
        /**
         * Método que muestra una lista de los peces disponibles en el sistema y permite elegir uno.
         * @return El tipo de pez elegido
         */
        public Pez showIctio(){
            int opcion=0;
            do {
                try {
                    MenuHelper.mostrarMenu(new String[]{"Lucio del norte",
                                              "Carpa plateada",
                                              "Carpa",
                                              "Tilapia del nilo",
                                              "Pejerrey",
                                              "Rodaballo",
                                              "Caballa",
                                              "Besugo",
                                              "Abadejo",
                                              "Sargo",
                                              "Trucha arcoiris",
                                              "Dorada",
                                              "Salir."},
                                               false);
                    opcion=InputHelper.getIntRanges(13);
                    switch (opcion) {
                        case 1:
                            infoLib(AlmacenPropiedades.LUCIO_NORTE.getNombre());
                            return new LucioDelNorte(false);
                        case 2:
                            infoLib(AlmacenPropiedades.CARPA_PLATEADA.getNombre());
                            return new CarpaPlateada(false);
                        case 3:
                            infoLib(AlmacenPropiedades.CARPA.getNombre());
                            return new Carpa(false);
                        case 4:
                            infoLib(AlmacenPropiedades.TILAPIA_NILO.getNombre());
                            return new TilapiaDelNilo(false);
                        case 5:
                            infoLib(AlmacenPropiedades.PEJERREY.getNombre());
                            return new Pejerrey(false);
                        case 6:
                            infoLib(AlmacenPropiedades.RODABALLO.getNombre());
                            return new Rodaballo(false);
                        case 7:
                            infoLib(AlmacenPropiedades.CABALLA.getNombre());
                            return new Caballa(false);
                        case 8:
                            infoLib(AlmacenPropiedades.BESUGO.getNombre());
                            return new Besugo(false);
                        case 9:
                            infoLib(AlmacenPropiedades.ABADEJO.getNombre());
                            return new Abadejo(false);
                        case 10:
                            infoLib(AlmacenPropiedades.SARGO.getNombre());
                            return new Sargo(false);
                        case 11:
                            infoLib(AlmacenPropiedades.TRUCHA_ARCOIRIS.getNombre());
                            return new TruchaArcoiris(false);
                        case 12:
                            infoLib(AlmacenPropiedades.DORADA.getNombre());
                            return new Dorada(false);
                        case 13:
                            return null;
                        default:
                            System.out.println("Esta opcion no es correcta, eliga una opcion valida");
                            return null;
                    }
                }catch (InputMismatchException e) {
                    System.out.println("Esta opcion no es válida");
                    return null;
                }
            } while (opcion!=13);
        }
    
        /**
         * Método que avanza un día en el sistema, realiza el crecimiento de los peces, la reproducción y la venta de peces óptimos y por último muestra un mesaje de los peces vendidos 
         * en todo el sistema y las monedas obtenidas con ello.
         */
        public void nextDay(){
            dias++;
            if (almacenCentral!=null) {
                almacenCentral.repartir(piscifactorias);
            }
    
            int pecesVendidos=0;
            int monedasObtenidas=0;
            for (Piscifactoria piscifactoria : piscifactorias) {
                int[] currPiscValues=piscifactoria.nextDay(stats);
                pecesVendidos+=currPiscValues[1];
                monedasObtenidas+=currPiscValues[0];
            }
    
            System.out.println("Total piscifactorias: "+pecesVendidos + " peces óptimos vendidos por un total de "+monedasObtenidas+ " monedas");
        }
    
        /**
         * Método que permite seleccionar una piscifactoria, seleccionar el tipo de comida que quieres añadir, seleccionar la cantidad de comida, y la añade.
         */
        public void addFood(){
            if(almacenCentral!=null){
                anadirComidaAlm();
            }else{
                try {
                    Piscifactoria pisc = piscifactorias.get(selectPisc());
                    anadirComidaPisc(pisc);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Introduce un número válido, krak");
                }
            }
        }
    
        /**
         * Método que muestra las piscifactorias del sistema permite elegir una, despues muestra los tanques del sistema y permite elegir uno y después muestra
         * los posibles peces a añadir en ese tranque, permite elegir uno y lo añade.
         */
        public void addFish(){
            boolean llena=false;
    
            do {
                try {
                    Piscifactoria pisc= piscifactorias.get(selectPisc());
    
                    Tanque tank =pisc.getTanques().get(pisc.selectTank());
    
                    Pez pezEleg=tank.showCompatible();
    
                    if(pezEleg!=null){
                        if(Monedero.monedasSuficientes(pezEleg.getCoste())){
                            if(pisc.pecesEnPiscifactoria()<pisc.pecesMaxPiscifactoria()){
                                    if(tank.getPeces().size()<1){
                                        tank.getPeces().add(pezEleg);
                                        monedero.setMonedas(monedero.getMonedas()-pezEleg.getCoste());
                                        stats.registrarNacimiento(pezEleg.getName());
                                        if(pezEleg.isFemale()){
                                            registros.comprarPeces(pezEleg, 'H', pisc.getTanques().indexOf(tank), pisc, pezEleg.getCoste());
                                        }else{
                                            registros.comprarPeces(pezEleg, 'M', pisc.getTanques().indexOf(tank), pisc, pezEleg.getCoste());
                                        }
                                        tank.showCapacity(pisc.getTanques().indexOf(tank));
                                        break;
                                    }else{
                                        if(tank.getPeces().get(0).getName()==pezEleg.getName()){
                                            if(tank.getPeces().size()<tank.getMaxPeces()){
                                                tank.getPeces().add(pezEleg);
                                                monedero.setMonedas(monedero.getMonedas()-pezEleg.getCoste());
                                                stats.registrarNacimiento(pezEleg.getName());
                                                if(pezEleg.isFemale()){
                                                    registros.comprarPeces(pezEleg, 'H', pisc.getTanques().indexOf(tank), pisc, pezEleg.getCoste());
                                                }else{
                                                    registros.comprarPeces(pezEleg, 'M', pisc.getTanques().indexOf(tank), pisc, pezEleg.getCoste());
                                                }
                                                tank.showCapacity(pisc.getTanques().indexOf(tank));
                                                break;
                                            }
                                        }else{
                                            System.out.println("Este pez no es válido para este tanque, introduce un pez válido");
                                        }
                                    }
                                
                            }else{
                                llena=true;
                                System.out.println("Esta piscifactoria esta llena, eliga otra");
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Introduce un número válido, krak");
                }
            } while (llena);
        } 
    
        /**
         * Método que permite seleccionar una piscifactoría y vende todos los peces adultos de esta, mostrando al final un mensaje de los peces vendidos y las monedas obtenidas con ello.
         */
        public void sell(){
            try {
                Piscifactoria pisc = piscifactorias.get(selectPisc());
    
                int monedasOb=0;
                int pecesVend=0;
    
                for (Tanque tanque : pisc.getTanques()) {
                    Iterator<Pez> iterator = tanque.getPeces().iterator();
                    while (iterator.hasNext()) {
                        Pez pez = iterator.next();
                        if(pez!=null){
                            if (pez.isAlive() && pez.isAdulto()) {
                                iterator.remove();
                                pecesVend++;
                                monedasOb += (pez.getMonedas() / 2);
                                stats.registrarVenta(pez.getName(), monedasOb);
                            }
                        }
                    }
                }
                registros.venderPeces(pecesVend, monedasOb, pisc);
                System.out.println("Piscifactoría "+pisc.getNombre()+": "+pecesVend+" peces vendidos por "+monedasOb+" monedas");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Introduce un número válido, krak");
            }
        }
    
        /**
         * Método que elimina los peces muertos de todos los tanques.
         */
        public void cleanTank(){
            try {
                Piscifactoria pisc = piscifactorias.get(selectPisc());
    
                for (Tanque tanque : pisc.getTanques()) {
                    Iterator<Pez> iterator = tanque.getPeces().iterator();
                    while (iterator.hasNext()) {
                        Pez pez = iterator.next();
                        if(pez!=null){
                            if (!pez.isAlive()) {
                                iterator.remove();
                            }
                        }
                    }
                    this.registros.limpiarTanque(pisc.getTanques().indexOf(tanque), pisc);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Introduce un número válido, krak");
            }
        }
    
        /**
         * Método que permite seleccionar un tanque, y elimina todos los peces del mismo independientemente de su estado.
         */
        public void emptyTank(){
            try {
                Piscifactoria pisc = piscifactorias.get(selectPisc());
                Tanque tank=pisc.getTanques().get(pisc.selectTank());
    
                tank.getPeces().clear();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Introduce un número válido, krak");
            }
        }
    
        /**
         * Método que muestra un menú de mejoras disponibles para el sistema.
         */
        public void upgrade(){
    
            int op=0;
            int op2=0;
            int op3=0;
            do {
                try {
                    MenuHelper.mostrarMenu(new String[]{"Comprar edificios.",
                                                    "Mejorar edificios.",
                                                    "Cancelar."},
                                                     false);
                    op=InputHelper.getIntRanges(3,1);
    
                    switch (op) {
                        case 1:
                            System.out.println("1. Piscifactoría.");
                            if(almacenCentral==null){
                                System.out.println("2. Almacén central.");
                            }
                            op2=InputHelper.getIntRanges(2,1);
                            switch (op2) {
                                case 1:
                                    System.out.println("Nombre de la piscifactoria: ");
                                    String nombrePisc=InputHelper.readStringWithBuffRead();
                                    System.out.println("Tipo de la piscifactoria: (1.RIO, 2.MAR)");
                                    int tipoPisc=InputHelper.getIntRanges(2,1);
                                    boolean opcionValida=false;
                                    do {
                                        if(tipoPisc==1){
                                            if(Monedero.monedasSuficientes(500*piscifactorias.size())){
                                                opcionValida=true;
                                                piscifactorias.add(new Piscifactoria(nombrePisc, CriaTipo.RIO));
                                                System.out.println("Piscifactoria añadida");
                                            }else{
                                                break;
                                            }
                                        }else if (tipoPisc==2) {
                                            if (Monedero.monedasSuficientes(2000*piscifactorias.size())) {
                                                opcionValida=true;
                                                piscifactorias.add(new Piscifactoria(nombrePisc, CriaTipo.MAR));
                                                System.out.println("Piscifactoria añadida");
                                            }else{
                                                break;
                                            }
                                        }else{
                                            System.out.println("Ese tipo de piscifactoria no es válido, escoga uno válido");
                                            break;
                                        }
                                    } while (!opcionValida);
                                    break;
                                case 2:
                                    if(Monedero.monedasSuficientes(2000)){
                                        almacenCentral=AlmacenCentral.getInstance();
                                        monedero.setMonedas(monedero.getMonedas()-2000);
                                        System.out.println("Almacén central adquirido.");
                                    }
                                    break;
                                default:
                                    System.out.println("Esa opción no es válida.");
                                    op=0;
                                    op2=0;
                                    break;    
                            }
                            break;
                        case 2:
                            System.out.println("1. Piscifactoria.");
                            if(almacenCentral!=null){
                                System.out.println("2. Almacén central.");
                            }
                            op2=InputHelper.getIntRanges(2,1);
                            switch (op2) {
                                case 1:
                                    System.out.println("1. Comprar tanque.");
                                    System.out.println("2. Aumentar almacén comida.");
                                    op3=InputHelper.getIntRanges(2,1);
                                    switch (op3) {
                                        case 1:
                                            System.out.println("Elige la piscifactoria a la que le quieres añadir un tanque");
                                            Piscifactoria pisc =piscifactorias.get(selectPisc());
                                            if(pisc.getTipo()==CriaTipo.RIO){
                                                if (Monedero.monedasSuficientes(150) && pisc.getTanques().size()<10) {
                                                    pisc.getTanques().add(new Tanque(25,pisc.getTipo()));
                                                    System.out.println("Tanque añadido");
                                                }
                                            }else if (pisc.getTipo()==CriaTipo.MAR) {
                                                if (Monedero.monedasSuficientes(600) && pisc.getTanques().size()<10) {
                                                    pisc.getTanques().add(new Tanque(100,pisc.getTipo()));
                                                    System.out.println("Tanque añadido");
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Elige la piscifactoria a la que le quieres aumentar el almacen de comida");
                                            Piscifactoria pisc2 =piscifactorias.get(selectPisc());
                                            if(Monedero.monedasSuficientes(50)){
                                                pisc2.addFood(25, "Vegetal");
                                                pisc2.addFood(25, "Animal");
                                            }
                                            break;
                                        default:
                                            System.out.println("Esa opción no es válida.");
                                            op=0;
                                            op2=0;
                                            op3=0;
                                            break;
                                    }
                                    break;
                                case 2:
                                    System.out.println("1. Aumentar capacidad");
                                    op3=InputHelper.getIntRanges(1,1);
                                    switch (op3) {
                                        case 1:
                                            if(Monedero.monedasSuficientes(200)){
                                                almacenCentral.aumentarCapacidad(50);
                                            }
                                            break;
                                        default:
                                            System.out.println("Esa opción no es válida.");
                                            op=0;
                                            op2=0;
                                            op3=0;
                                            break;
                                    }
                                    break;
                                default:
                                    System.out.println("Esa opción no es válida.");
                                    op=0;
                                    op2=0;
                                    break;
                            }
                            break;
                        case 3:
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Esta opción no es válida");
                }
            } while (op!=3);
        }
    
        /**
         * Método que devuelve la información de la librería de un tipo de pez específico, pasado por parámetro.
         * @param tipoPez El tipo de pez del que queremos la información
         */
        public void infoLib(String tipoPez){
    
            System.out.println("Nombre : "+AlmacenPropiedades.getPropByName(tipoPez).getNombre());
            System.out.println("Nombre cientifico : "+AlmacenPropiedades.getPropByName(tipoPez).getCientifico());
            System.out.println("Coste : "+AlmacenPropiedades.getPropByName(tipoPez).getCoste());
            System.out.println("Ciclo : "+AlmacenPropiedades.getPropByName(tipoPez).getCiclo());
            System.out.println("Monedas al vender : "+AlmacenPropiedades.getPropByName(tipoPez).getMonedas());
            System.out.println("Huevos : "+AlmacenPropiedades.getPropByName(tipoPez).getHuevos());
            System.out.println("Madurez : "+AlmacenPropiedades.getPropByName(tipoPez).getMadurez());
            System.out.println("Edad optima : "+AlmacenPropiedades.getPropByName(tipoPez).getOptimo());
        }
    
        /**
         * Método que devuelve el número de peces vivos en el sistema.
         * @return Número de peces vivos en el sistema
         */
        public int pecesVivosEnSist(){
            int pecesEnSist=0;
            for (Piscifactoria piscifactoria : piscifactorias) {
                pecesEnSist += piscifactoria.pecesVivosPiscifactoria();
            }
            return pecesEnSist;
        }
    
        /**
         * Método que devuelve el total de espacios de una piscifactoría.
         * @param pisc Piscifactoría de la que quieres saber los espacios
         * @return Número de espacios de la piscifactoria
         */
        private int espacioEnPisci(Piscifactoria pisc) {
            int espacioEnPisci=0;
            for (Tanque tanque : pisc.getTanques()) {
                espacioEnPisci+=tanque.getMaxPeces();
            }
            return espacioEnPisci;
        }
    
        /**
         * Método que devuelve el número de peces en el sistema.
         * @return Número de peces en el sistema
         */
        public int pecesTotalesEnSist(){
            int pecesTotal=0;
            for (Piscifactoria piscifactoria : piscifactorias) {
                pecesTotal += piscifactoria.pecesEnPiscifactoria();
            }
            return pecesTotal;
        }
    
        /**
         * Método que devuelve el número de espacios disponibles en el sistema.
         * @return Número de espacios disponibles en el sistema
         */
        public int espacioTotalSist(){
            int espacioTotal=0;
            for (Piscifactoria piscifactoria : piscifactorias) {
                espacioTotal += piscifactoria.pecesMaxPiscifactoria();
            }
            return espacioTotal;
        }
    
        /**
         * Metodo que permite elegir el tipo de comida y la cantidad que quieres añadir.
         * @param pisc 
         * @return cantidad y tipo de comida
         */
        public int[] elegirComida(Piscifactoria pisc){
            int opciontipo;
            int opCant;
            int tipo=0;
            int cantComida=0;
            boolean a = false;
            boolean b=false;
            do {
                try {
                    System.out.println("Que tipo de comida quieres añadir?");
                    MenuHelper.mostrarMenu(new String[]{"Animal",
                                                        "Vegetal"},
                                                        false);
                    opciontipo=InputHelper.getIntRanges(2,1);
                    switch (opciontipo) {
                        case 1:
                            tipo=0;
                            a = true;
                            break;
                        case 2:
                            tipo=1;
                            a = true;
                            break;
                        default:
                            System.out.println("Esa opcion no esta disponible, eliga entre las opciones disponibles");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Esta opción no es válida");
                }
                
            } while (!a);
            
            do {
                try {
                    System.out.println("Cuanta comida quieres añadir?");
                    MenuHelper.mostrarMenu(new String[]{"5",
                                                        "10",
                                                        "25",
                                                        "llenar"},
                                                        false);
    
                    opCant=InputHelper.getIntRanges(4,1);
                    
                    switch (opCant) {
                        case 1:
                            cantComida=5;
                            if(Monedero.monedasSuficientes(cantComida)){
                                return new int[]{cantComida,tipo};
                            }
                            b=true;
                            break;
                        case 2:
                            cantComida=10;
                            if(Monedero.monedasSuficientes(cantComida)){
                                return new int[]{cantComida,tipo};
                            }
                            b=true;
                            break;
                        case 3:
                            cantComida=25;
                            if(Monedero.monedasSuficientes(cantComida)){
                                return new int[]{cantComida,tipo};
                            }
                            b=true;
                            break;
                        case 4:
                            if(almacenCentral==null){
                                if (tipo==0 && Monedero.monedasSuficientes(pisc.getMaxComidaAnimal()-pisc.getComidaAnimal())) {
                                    cantComida=pisc.getMaxComidaAnimal()-pisc.getComidaAnimal();
                                    return new int[]{cantComida,tipo};
                                }else if (tipo==1 && Monedero.monedasSuficientes(pisc.getMaxComidaVegetal()-pisc.getComidaVegetal())) {
                                    cantComida=pisc.getMaxComidaVegetal()-pisc.getComidaVegetal();
                                    return new int[]{cantComida,tipo};
                                }
                            }else if (almacenCentral!=null) {
                                if (tipo==0 && Monedero.monedasSuficientes(almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal())) {
                                    cantComida=almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal();
                                    return new int[]{cantComida,tipo};
                                }else if (tipo==1 && Monedero.monedasSuficientes(almacenCentral.getCapacidadComidaVegetal()-almacenCentral.getComidaVegetal())) {
                                    cantComida=almacenCentral.getCapacidadComidaVegetal()-almacenCentral.getComidaVegetal();
                                    return new int[]{cantComida,tipo};
                                }
                            }
                            b=true;
                            break;
                        default:
                            System.out.println("Esa opcion no esta disponible, eliga entre las opciones disponibles");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Esta opción no es válida");
                }
            } while (!b);
            return null;
        }
    
        /**
         * Método que añade a una piscifactoría la cantidad del tipo de comida pasado por parámetro
         * @param cant Número de comida a añadir
         * @param tipo Tipo de comida a añadir
         * @param pisc Piscifactoia en la que añadir la comida
         */
        public void anadirComidaPisc(Piscifactoria pisc){
            int[] cantTipo = elegirComida(pisc);
            int cant = cantTipo[0];
            String tipo = (cantTipo[1] == 0) ? "Animal" : "Vegetal";
        
            if (tipo.equals("Animal")) {
                cant = Math.min(cant, pisc.getMaxComidaAnimal() - pisc.getComidaAnimal());
            } else if (tipo.equals("Vegetal")) {
                cant = Math.min(cant, pisc.getMaxComidaVegetal() - pisc.getComidaVegetal());
            }
        
            int precioComida = Monedero.calcularDescuento(cant);
            monedero.setMonedas(monedero.getMonedas() - precioComida);
        
            System.out.println("Cantidad de comida añadida: ");
            System.out.println("Añadida " + cant + " de comida " + tipo);
        
            pisc.addFood(cant, tipo);
            registros.comprarComida(cant, tipo, precioComida, "piscifactoria", pisc);
    
        
            if (tipo.equals("Vegetal")) {
                int porcentaje = ((pisc.getComidaVegetal()/pisc.getMaxComidaVegetal())*100);
                System.out.println("Depósito de comida vegetal de la piscifactoría " + pisc.getNombre() +
                                   " al " + porcentaje + "% de su capacidad. [" +
                                   pisc.getComidaVegetal() + "/" + pisc.getMaxComidaVegetal() + "]");
            } else if (tipo.equals("Animal")) {
                int porcentaje = (pisc.getComidaAnimal()/pisc.getMaxComidaAnimal()*100);
                System.out.println("Depósito de comida animal de la piscifactoría " + pisc.getNombre() +
                                   " al " + porcentaje + "% de su capacidad. [" +
                                   pisc.getComidaAnimal() + "/" + pisc.getMaxComidaAnimal() + "]");
                                }
            }
    
        /**
         * Método que añade al almacén central la cantidad del tipo de comida pasado por parámetro.
         * @param cant Número de comida a añadir
         * @param tipo Tipo de comida a añadir
         * @param almacenCentral 
         */
        private void anadirComidaAlm(){
            int[] cantTipo = elegirComida(null);
    
            int cant = cantTipo[0];
            String tipo = ((cantTipo[1] == 0) ? "Animal" : "Vegetal");
    
            if(tipo=="Animal" && cant>almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal()){
                cant-=almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal();
            }else if (tipo=="Vegetal" && cant>almacenCentral.getCapacidadComidaVegetal()-almacenCentral.getComidaVegetal()) {
                cant-=almacenCentral.getCapacidadComidaVegetal()-almacenCentral.getComidaVegetal();
            }
    
            int precioComida=Monedero.calcularDescuento(cant);
    
            monedero.setMonedas(monedero.getMonedas()-precioComida);
            System.out.println("Cantidad de comida añadida: ");
            System.out.println("Añadida "+cant+" de comida "+tipo);
            if(tipo=="Vegetal"){
                almacenCentral.addFood(cant,tipo);
                registros.comprarComida(cant, tipo, precioComida, "almacen central", null);
                almacenCentral.repartir(piscifactorias);
                System.out.println("Deposito de comida vegetal del almacen central al "+((cant*100/almacenCentral.getCapacidadComidaVegetal()))
                +"% de su capacidad. [ "+almacenCentral.getComidaVegetal()+"/"+almacenCentral.getCapacidadComidaVegetal()+"]");
            }else if (tipo=="Animal") {
                almacenCentral.addFood(cant,tipo);
                registros.comprarComida(cant, tipo, precioComida, "almacen central", null);
                almacenCentral.repartir(piscifactorias);
                System.out.println("Deposito de comida animal del almacen central al "+((cant*100/almacenCentral.getCapacidadComidaAnimal()))
                +"% de su capacidad. [ "+almacenCentral.getComidaAnimal()+"/"+almacenCentral.getCapacidadComidaAnimal()+"]");
            }
        }
    
        /**
         * Método que añade cuatro peces aleatorios a una piscifactoria seleccionada.
         */
        public void truco98() {
            try {
                Piscifactoria pisc=piscifactorias.get(selectPisc());
                Random random=new Random();
                for (int i = 0; i < 4; i++) {
                    int randomNumber = random.nextInt(12) + 1;
                    for (Tanque tanque : pisc.getTanques()) {
                        switch (randomNumber) {
                            case 1:
                                if(tanque.getTipoPez().getNombre()=="Lucio del norte" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new LucioDelNorte(false));
                                }
                            break;   
                            case 2:
                                if(tanque.getTipoPez().getNombre()=="Carpa plateada" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new CarpaPlateada(false));
                                }
                            break;
                            case 3:
                                if(tanque.getTipoPez().getNombre()=="Carpa" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Carpa(false));
                                }
                            break;
                            case 4:
                                if(tanque.getTipoPez().getNombre()=="Tilapia del nilo" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new TilapiaDelNilo(false));
                                }
                            break;
                            case 5:
                                if(tanque.getTipoPez().getNombre()=="Pejerrey" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Pejerrey(false));
                                }
                            break;   
                            case 6:
                                if(tanque.getTipoPez().getNombre()=="Rodaballo" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Rodaballo(false));
                                }
                            break;
                            case 7:
                                if(tanque.getTipoPez().getNombre()=="Caballa" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Caballa(false));
                                }
                            break;
                            case 8:
                                if(tanque.getTipoPez().getNombre()=="Besugo" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Besugo(false));
                                }
                            break;
                            case 9:
                                if(tanque.getTipoPez().getNombre()=="Abadejo" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Abadejo(false));
                                }
                            break;   
                            case 10:
                                if(tanque.getTipoPez().getNombre()=="Sargo" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Sargo(false));
                                }
                            break;
                            case 11:
                                if(tanque.getTipoPez().getNombre()=="Trucha arcoiris" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new TruchaArcoiris(false));
                                }
                            break;
                            case 12:
                                if(tanque.getTipoPez().getNombre()=="Dorada" && tanque.getMaxPeces()<tanque.getPeces().size()){
                                    tanque.getPeces().add(new Dorada(false));
                                }
                            break;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Introduce un número válido, krak");
            }
        }
    
        
        public void truco99() {
            monedero.setMonedas(monedero.getMonedas() + 1000);
            this.registros.ocultas(null, 1000, monedero.getMonedas());
        System.out.println("Añadidas 1000 monedas");
    }

    /**
     * Permite seleccionar una recompensa disponible, primero las lista y el usuario elige la que quiere.
     */
    public void selectRecompensa(){
        Recompensas.listRecompensas();
        File f = new File("rewards/");
        File[] files = f.listFiles();
        int opcion = InputHelper.getIntRanges(files.length);
        Recompensas.reclamar(registros,files[opcion-1],piscifactorias);
    }


    /**
     * Metodo que permite crear una recompensa.
     * @param nombreArchivo nombre del archivo.
     * @param nivel Nivel de la recompensa.
     */
    public void truco97(String nombreArchivo, int nivel) {
        if (new File("rewards/" + nombreArchivo).exists()) {
            Recompensas.addQuantity(nombreArchivo);
        } else {
            Recompensas.monedasXml(2);
            this.registros.recompensaCreada(nombreArchivo);
        }
    
    }
    /**
     * Metodo que guarda la partida
     */
    public void save(){
        SaveLoad saves = new SaveLoad();
        saves.save(new DTOSimulador(this), new File("prueba.json"));
    }


    /**
     * Ejecuta toda la lógica del programa.
     * @param args
     */
    public static void main(String[] args){
        Monedero monedero=Monedero.getInstance();
        Simulador sim=new Simulador();
        sim.init();
        int opcion=0;
           
                try {
                    do {
                sim.menu();
                opcion = InputHelper.getIntRanges(15, 1, new int[] { 97, 98, 99, 100 });
                switch (opcion) {
                    case 1:
                        sim.showGeneralStatus();
                        break;
                    case 2:
                        sim.showSpecificStatus();
                        break;
                    case 3:
                        sim.showTankStatus();
                        break;
                    case 4:
                        sim.showStats();
                        break;
                    case 5:
                        sim.showIctio();
                        break;
                    case 6:
                        sim.nextDay();
                        break;
                    case 7:
                        sim.addFood();
                        break;
                    case 8:
                        sim.addFish();
                        break;
                    case 9:
                        sim.sell();
                        break;
                    case 10:
                        sim.cleanTank();
                        break;
                    case 11:
                        sim.emptyTank();
                        break;
                    case 12:
                        sim.upgrade();
                        break;
                    case 13:
                        sim.selectRecompensa();
                        break;
                    case 14:
                        System.out.println("Elige los dias que quieres pasar");
                        int numDias = InputHelper.getIntRanges(Integer.MAX_VALUE, 1);
                        for (int i = 0; i < numDias; i++) {
                            sim.nextDay();
                        }
                        break;
                    case 15:
                        break;
                    case 97:
                        sim.truco97("algas_2.xml", 2);
                        break;
                    case 98:
                        sim.truco98();
                        break;
                    case 99:
                        sim.truco99();
                        break;
                    case 100:
                        sim.save();
                        break;
                    default:
                        System.out.println("Esta opción no es válida");
                        break;
                }
            } while (opcion != 15);
        } catch (InputMismatchException e) {
            System.out.println("Has introducido un tipo de dato incorrecto, introduce un número");
        } finally {
            InputHelper.closeBuffReader();
            sim.registros.salir();
        }
    }
}
