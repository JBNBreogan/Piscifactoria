package Simulador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

import Comun.Monedero;
import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import estadisticas.Estadisticas;
import helpers.*;
import peces.Double.*;
import peces.Mar.*;
import peces.Pez;
import peces.Rio.*;
import propiedades.AlmacenPropiedades;
import propiedades.CriaTipo;
import Comun.AlmacenCentral;
import java.util.Random;
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

    /**
     * Constructor vacío de la clase simulador.
     */
    public Simulador() {
    }

    /**
     * Método que inicializa el sistema, asignando el nombre del sistema, creando una piscifactoria y añadiendo 100 monedas.
     * @throws IOException 
     */
    public void init() throws IOException{
        System.out.println("Nombre de la empresa:");
        nombreEmpresa = InputHelper.ReadStringWithBuffRead();
        System.out.println("Nombre de la piscifactoria");
        String npisc= InputHelper.ReadStringWithBuffRead();
        piscifactorias.add(new Piscifactoria(npisc,CriaTipo.RIO));
        Monedero.getInstance().setMonedas(100);
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
                                            "Vender pedes.", 
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
            System.out.println(i + ".- " + piscifactoria.getNombre() + " [" + pecesVivosEnSist() + "/" + pecesTotalesEnSist() + "/" + espacioTotalSist()+"]");
        }
        
    }     

    /**
     * Método que muestra el menú de piscifactorías y permite seleccionar una de ellas.
     * @return El número que ocupa en las lista de piscifactorias la seleccionada
     * @throws IOException 
     */
    public int selectPisc() throws IOException{
        try {
            menuPisc();
            int opcion = InputHelper.GetIntWithBuffRead();
            return opcion-1;
        } catch (InputMismatchException e) {
            System.out.println("Introduce un valor correcto");
            selectPisc();
            return 0;
        }
    }
    
    /**
     * Método que muestra el menú de tanques y permite seleccionar un tanque, mostrando un menú de los disponibles.
     * @return El número que ocupa en la lista de tanques de una pisicfactoria el tanque seleccionado
     * @throws IOException 
     */
    public Tanque selectTank() throws IOException{
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        Tanque tank= pisc.getTanques().get(pisc.selectTank());
        return tank;
    }

    /**
     * Método que muestra el día actual, las monedas del sistema, el estado de todas las piscifactorías del sistema y en caso de tener 
     * la mejora del almacén central, muestra el estado de este también.
     */
    public void showGeneralStatus(){

        System.out.println("Empresa: " + this.nombreEmpresa);
        System.out.println("Día: "+this.dias);
        System.out.println("Monedas disponibles: "+monedero.getMonedas());
        if(almacenCentral!=null){
            System.out.println("Deposito de comida vegetal del almacen central al "+PorcentajeHelper.hacerProcentaje(almacenCentral.getComidaAnimal(), almacenCentral.getCapacidadComidaAnimal())
            +"% de su capacidad. ["+almacenCentral.getComidaAnimal()+"/"+almacenCentral.getCapacidadComidaAnimal()+"]");
            System.out.println("Deposito de comida vegetal del almacen central al "+PorcentajeHelper.hacerProcentaje(almacenCentral.getComidaVegetal(), almacenCentral.getCapacidadComidaVegetal())
            +"% de su capacidad. ["+almacenCentral.getComidaVegetal()+"/"+almacenCentral.getCapacidadComidaVegetal()+"]");
        }
        for (Piscifactoria pisc : piscifactorias) {
            pisc.showStatus();
        }
    }

    /**
     * Método que permite seleccionar una piscifactoria y muestra su estado.
     * @throws IOException 
     */
    public void showSpecificStatus() throws IOException{
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        
        pisc.showTankStatus();
    }

    /**
     * Método que permite seleccionar un tanque y muestra su estado.
     * @throws IOException 
     */
    public void showTankStatus() throws IOException{
        Piscifactoria pisc = piscifactorias.get(selectPisc());

        Tanque tank = pisc.getTanques().get(pisc.selectTank());

        tank.showStatus();
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
     * @throws IOException 
     */
    public Pez showIctio() throws IOException{
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
                opcion=InputHelper.GetIntWithBuffRead();
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

        for (Piscifactoria piscifactoria : piscifactorias) {
            piscifactoria.nextDay();
        }

        int pecesVendidos=0;
        int monedasObtenidas=0;
        for (Piscifactoria piscifactoria : piscifactorias) {
            int[] currPiscValues=piscifactoria.venta();
            pecesVendidos+=currPiscValues[1];
            monedasObtenidas+=currPiscValues[0];
        }
        System.out.println(pecesVendidos + " peces optimos vendidos por un total de "+monedasObtenidas+ " monedas");
    }

    /**
     * Método que permite seleccionar una piscifactoria, seleccionar el tipo de comida que quieres añadir, seleccionar la cantidad de comida, y la añade.
     * @throws IOException 
     */
    public void addFood() throws IOException{
        if(almacenCentral!=null){
            anadirComidaAlm();
        }else{
            Piscifactoria pisc = piscifactorias.get(selectPisc());
            anadirComidaPisc(pisc);
        }
    }

    /**
     * Método que muestra las piscifactorias del sistema permite elegir una, despues muestra los tanques del sistema y permite elegir uno y después muestra
     * los posibles peces a añadir en ese tranque, permite elegir uno y lo añade.
     * @throws IOException 
     */
    public void addFish() throws IOException{
        boolean llena=false;

        do {
            Piscifactoria pisc= piscifactorias.get(selectPisc());

            Tanque tank =pisc.getTanques().get(pisc.selectTank());

            Pez pezEleg=tank.showCompatible();

            if(pezEleg.getCoste()>monedero.getMonedas()){
                System.out.println("Monedas insuficientes");
            }else{
                if(pisc.pecesEnPiscifactoria()<pisc.pecesMaxPiscifactoria()){
                    for (Tanque tanque : pisc.getTanques()) {
                        if(tanque.getPeces().size()<1){
                            tanque.getPeces().add(pezEleg);
                            monedero.setMonedas(monedero.getMonedas()-pezEleg.getCoste());
                            stats.registrarNacimiento(pezEleg.getName());
                            tanque.showCapacity();
                        }else{
                            if(tanque.getPeces().get(0).getName()==pezEleg.getName()){
                                if(tanque.getPeces().size()<tanque.getMaxPeces()){
                                    tanque.getPeces().add(pezEleg);
                                    monedero.setMonedas(monedero.getMonedas()-pezEleg.getCoste());
                                    stats.registrarNacimiento(pezEleg.getName());
                                    tanque.showCapacity();
                                }
                            }else{
                                System.out.println("Este pez no es válido para este tanque, introduce un pez válido");
                                break;
                            }
                        }
                    }
                }else{
                    llena=true;
                    System.out.println("Esta piscifactoria esta llena, eliga otra");
                }
            }
        } while (llena);
    } 

    /**
     * Método que permite seleccionar una piscifactoría y vende todos los peces adultos de esta, mostrando al final un mensaje de los peces vendidos y las monedas obtenidas con ello.
     * @throws IOException 
     */
    public void sell() throws IOException{
        Piscifactoria pisc = piscifactorias.get(selectPisc());

        int monedasOb=0;
        int pecesVend=0;

        for (Tanque tanque : pisc.getTanques()) {
            Iterator<Pez> iterator = tanque.getPeces().iterator();
            while (iterator.hasNext()) {
                Pez pez = iterator.next();
                if (pez.isAlive() && pez.isAdulto()) {
                    iterator.remove();
                    pecesVend++;
                    monedasOb += (pez.getMonedas() / 2);
                    stats.registrarVenta(pez.getName(), monedasOb);
                }
            }
        }
        
        System.out.println("Piscifactoría "+pisc.getNombre()+": "+pecesVend+" peces vendidos por "+monedasOb+" monedas");
    }

    /**
     * Método que elimina los peces muertos de todos los tanques.
     * @throws IOException 
     */
    public void cleanTank() throws IOException{
        Piscifactoria pisc = piscifactorias.get(selectPisc());

        for (Tanque tanque : pisc.getTanques()) {
            Iterator<Pez> iterator = tanque.getPeces().iterator();
            while (iterator.hasNext()) {
                Pez pez = iterator.next();
                if (!pez.isAlive()) {
                    iterator.remove();
                }
            }
        }
        
    }

    /**
     * Método que permite seleccionar un tanque, y elimina todos los peces del mismo independientemente de su estado.
     * @throws IOException 
     */
    public void emptyTank() throws IOException{
        Piscifactoria pisc = piscifactorias.get(selectPisc());
        Tanque tank=pisc.getTanques().get(pisc.selectTank());

        tank.getPeces().clear();
    }

    /**
     * Método que muestra un menú de mejoras disponibles para el sistema.
     * @throws IOException 
     */
    public void upgrade() throws IOException{

        int op=0;
        String op2="";
        String op3="";
        do {
            try {
                MenuHelper.mostrarMenu(new String[]{"Comprar edificios.",
                                                "Mejorar edificios.",
                                                "Cancelar."},
                                                 false);
                op=InputHelper.GetIntWithBuffRead();

                switch (op) {
                    case 1:
                        System.out.println("a. Piscifactoría.");
                        System.out.println("b. Almacén central.");
                        op2=InputHelper.ReadStringWithBuffRead();
                        switch (op2) {
                            case "a":
                                System.out.println("Nombre de la piscifactoria: ");
                                String nombrePisc=InputHelper.ReadStringWithBuffRead();
                                System.out.println("Tipo de la piscifactoria: (RIO, MAR o DOBLE)");
                                String tipoPisc=InputHelper.ReadStringWithBuffRead();
                                boolean opcionValida=false;
                                do {
                                    if(tipoPisc.equals("RIO")){
                                        if(MonederoHelper.monedasSuficientes(500*piscifactorias.size())){
                                            opcionValida=true;
                                            piscifactorias.add(new Piscifactoria(nombrePisc, CriaTipo.RIO));
                                            System.out.println("Piscifactoria añadida");
                                        }else{
                                            break;
                                        }
                                    }else if (tipoPisc.equals("MAR")) {
                                        if (MonederoHelper.monedasSuficientes(2000*piscifactorias.size())) {
                                            opcionValida=true;
                                            piscifactorias.add(new Piscifactoria(nombrePisc, CriaTipo.MAR));
                                            System.out.println("Piscifactoria añadida");
                                        }else{
                                            break;
                                        }
                                    }else{
                                        System.out.println("Ese tipo de piscifactoria no es válido, escoga uno válido");
                                    }
                                } while (!opcionValida);
                                break;
                            case "b":
                                if(MonederoHelper.monedasSuficientes(2000)){
                                    almacenCentral=AlmacenCentral.getInstance();
                                    monedero.setMonedas(monedero.getMonedas()-2000);
                                    System.out.println("Almacén central adquirido.");
                                }
                                break;
                            default:
                                System.out.println("Esa opción no es válida.");
                                op=0;
                                op2="";
                                break;    
                        }
                        break;
                    case 2:
                        System.out.println("a. Piscifactoria.");
                        if(almacenCentral==null){
                            System.out.println("b. Almacén central.");
                        }
                        op2=InputHelper.ReadStringWithBuffRead();
                        switch (op2) {
                            case "a":
                                System.out.println("i.  Comprar tanque.");
                                System.out.println("ii. Aumentar almacén comida.");
                                op3=InputHelper.ReadStringWithBuffRead();
                                switch (op3) {
                                    case "i":
                                        System.out.println("Elige la piscifactoria a la que le quieres añadir un tanque");
                                        Piscifactoria pisc =piscifactorias.get(selectPisc());
                                        if(pisc.getTipo()==CriaTipo.RIO){
                                            if (MonederoHelper.monedasSuficientes(150) && pisc.getTanques().size()<10) {
                                                pisc.getTanques().add(new Tanque(25,pisc.getTipo()));
                                                System.out.println("Tanque añadido");
                                            }
                                        }else if (pisc.getTipo()==CriaTipo.MAR) {
                                            if (MonederoHelper.monedasSuficientes(600) && pisc.getTanques().size()<10) {
                                                pisc.getTanques().add(new Tanque(100,pisc.getTipo()));
                                                System.out.println("Tanque añadido");
                                            }
                                        }
                                        break;
                                    case "ii":
                                        System.out.println("Elige la piscifactoria a la que le quieres aumentar el almacen de comida");
                                        Piscifactoria pisc2 =piscifactorias.get(selectPisc());
                                        if(MonederoHelper.monedasSuficientes(50)){
                                            pisc2.addFood(25, "Vegetal");
                                            pisc2.addFood(25, "Animal");
                                        }
                                        break;
                                    default:
                                        System.out.println("Esa opción no es válida.");
                                        op=0;
                                        op2="c";
                                        op3="";
                                        break;
                                }
                                break;
                            case "b":
                                System.out.println("i. Aumentar capacidad");
                                op3=InputHelper.ReadStringWithBuffRead();
                                switch (op3) {
                                    case "i":
                                        if(MonederoHelper.monedasSuficientes(200)){
                                            almacenCentral.aumentarCapacidad(50);
                                        }
                                        break;
                                    default:
                                        System.out.println("Esa opción no es válida.");
                                        op=0;
                                        op2="c";
                                        op3="";
                                        break;
                                }
                                break;
                            default:
                                System.out.println("Esa opción no es válida.");
                                op=0;
                                op2="";
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
     * Mçetodo que permite elegir el tipo de comida y la cantidad que quieres añadir.
     * @param pisc 
     * @return cantidad y tipo de comida
     * @throws IOException 
     */
    public int[] elegirComida(Piscifactoria pisc) throws IOException{
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
                opciontipo=InputHelper.GetIntWithBuffRead();
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

                opCant=InputHelper.GetIntWithBuffRead();
                
                switch (opCant) {
                    case 1:
                        cantComida=5;
                        if(MonederoHelper.monedasSuficientes(cantComida)){
                            return new int[]{cantComida,tipo};
                        }
                        b=true;
                        break;
                    case 2:
                        cantComida=10;
                        if(MonederoHelper.monedasSuficientes(cantComida)){
                            return new int[]{cantComida,tipo};
                        }
                        b=true;
                        break;
                    case 3:
                        cantComida=25;
                        if(MonederoHelper.monedasSuficientes(cantComida)){
                            return new int[]{cantComida,tipo};
                        }
                        b=true;
                        break;
                    case 4:
                        if(almacenCentral==null){
                            if (tipo==0 && MonederoHelper.monedasSuficientes(pisc.getMaxComidaAnimal()-pisc.getComidaAnimal())) {
                                cantComida=pisc.getMaxComidaAnimal()-pisc.getComidaAnimal();
                                return new int[]{cantComida,tipo};
                            }else if (tipo==1 && MonederoHelper.monedasSuficientes(pisc.getMaxComidaVegetal()-pisc.getComidaVegetal())) {
                                cantComida=pisc.getMaxComidaVegetal()-pisc.getComidaVegetal();
                                return new int[]{cantComida,tipo};
                            }
                        }else if (almacenCentral!=null) {
                            if (tipo==0 && MonederoHelper.monedasSuficientes(almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal())) {
                                cantComida=almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal();
                                return new int[]{cantComida,tipo};
                            }else if (tipo==1 && MonederoHelper.monedasSuficientes(almacenCentral.getCapacidadComidaVegetal()-almacenCentral.getComidaVegetal())) {
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
                System.out.println("esta opción noes válida");
            }
        } while (!b);
        return null;
    }

    /**
     * Método que añade a una piscifactoría la cantidad del tipo de comida pasado por parámetro
     * @param cant Número de comida a añadir
     * @param tipo Tipo de comida a añadir
     * @param pisc Piscifactoia en la que añadir la comida
     * @throws IOException 
     */
    public void anadirComidaPisc(Piscifactoria pisc) throws IOException{

        int[] cantTipo = elegirComida(pisc);

        int cant = cantTipo[0];
        String tipo = ((cantTipo[1] == 0) ? "Animal" : "Vegetal");
        if(tipo=="Animal" && cant>pisc.getMaxComidaAnimal()-pisc.getComidaAnimal()){
            cant-=pisc.getMaxComidaAnimal()-pisc.getComidaAnimal();
        }else if (tipo=="Vegetal" && cant>pisc.getMaxComidaVegetal()-pisc.getComidaVegetal()) {
            cant-=pisc.getMaxComidaVegetal()-pisc.getComidaVegetal();
        }

        int precioComida=MonederoHelper.calcularDescuento(cant);

        monedero.setMonedas(monedero.getMonedas()-precioComida);
        System.out.println("Cantidad de comida añadida: ");
        System.out.println("Añadida "+cant+" de comida "+tipo);
        if(tipo=="Vegetal"){
            pisc.addFood(cant,tipo);
            System.out.println("Deposito de comida vegetal del la piscifactoria "+pisc.getNombre()+" al "+PorcentajeHelper.hacerProcentaje(cant, pisc.getMaxComidaVegetal())
            +"% de su capacidad. ["+pisc.getComidaVegetal()+"/"+pisc.getMaxComidaVegetal()+"]");
        }else if (tipo=="Animal") {
            pisc.addFood(cant,tipo);
            System.out.println("Deposito de comida animal del la piscifactoria "+pisc.getNombre()+" al "+PorcentajeHelper.hacerProcentaje(cant, pisc.getMaxComidaAnimal())
            +"% de su capacidad. ["+pisc.getComidaAnimal()+"/"+pisc.getMaxComidaAnimal()+"]");
        }   
    }

    /**
     * Método que añade al almacén central la cantidad del tipo de comida pasado por parámetro.
     * @param cant Número de comida a añadir
     * @param tipo Tipo de comida a añadir
     * @param almacenCentral 
     * @throws IOException 
     */
    private void anadirComidaAlm() throws IOException {
        int[] cantTipo = elegirComida(null);

        int cant = cantTipo[0];
        String tipo = ((cantTipo[1] == 0) ? "Animal" : "Vegetal");

        if(tipo=="Animal" && cant>almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal()){
            cant-=almacenCentral.getCapacidadComidaAnimal()-almacenCentral.getComidaAnimal();
        }else if (tipo=="Vegetal" && cant>almacenCentral.getCapacidadComidaVegetal()-almacenCentral.getComidaVegetal()) {
            cant-=almacenCentral.getCapacidadComidaVegetal()-almacenCentral.getComidaVegetal();
        }

        int precioComida=MonederoHelper.calcularDescuento(cant);

        monedero.setMonedas(monedero.getMonedas()-precioComida);
        System.out.println("Cantidad de comida añadida: ");
        System.out.println("Añadida "+cant+" de comida "+tipo);
        if(tipo=="Vegetal"){
            almacenCentral.addFood(cant,tipo);
            System.out.println("Deposito de comida vegetal del almacen central al"+PorcentajeHelper.hacerProcentaje(cant, almacenCentral.getCapacidadComidaVegetal())
            +"% de su capacidad. [ "+almacenCentral.getComidaVegetal()+"/"+almacenCentral.getCapacidadComidaVegetal()+"]");
        }else if (tipo=="Animal") {
            almacenCentral.addFood(cant,tipo);
            System.out.println("Deposito de comida animal del almacen central al"+PorcentajeHelper.hacerProcentaje(cant, almacenCentral.getCapacidadComidaAnimal())
            +"% de su capacidad. [ "+almacenCentral.getComidaAnimal()+"/"+almacenCentral.getCapacidadComidaAnimal()+"]");
        }
    }

    /**
     * Método que añade cuatro peces aleatorios a una piscifactoria seleccionada.
     * @throws IOException 
     */
    public void truco98() throws IOException{
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
    }

    /**
     * Ejecuta toda la lógica del programa.
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        Monedero monedero=Monedero.getInstance();
        Simulador sim=new Simulador();
        sim.init();
        int opcion=0;
            do {
                try {
                sim.menu();
                opcion=InputHelper.GetIntWithBuffRead();
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
                            System.out.println("Elige los dias que quieres pasar");
                            int numDias=InputHelper.GetIntWithBuffRead();
                            for (int i = 0; i < numDias; i++) {
                                sim.nextDay();
                            }
                            break;
                        case 14:
                            break;
                        case 98:
                            sim.truco98();
                            break;
                        case 99:
                            monedero.setMonedas(monedero.getMonedas()+1000);
                            System.out.println("Añadidas 1000 monedas");
                            break;
                        default:
                            System.out.println("Esta opción no es válida");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Has introducido un tipo de dato incorrecto, introduce un número");
                } finally {
                    InputHelper.CloseBuffReader();
                }
        } while (opcion!=14);
    }
}
