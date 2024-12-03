package tanque;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

import comun.*;
import peces.Pez;
import peces.doble.*;
import peces.mar.*;
import peces.propiedades.*;
import peces.rio.*;
import piscifactoria.Piscifactoria;
import propiedades.AlmacenPropiedades;
import propiedades.CriaTipo;
import propiedades.PecesDatos;
import helpers.InputHelper;
import helpers.MenuHelper;

/**
 * Clase que representa los tanques que albergan a los peces de una
 * piscifactoría.
 * 
 * @author Cristian
 */
public class Tanque {
    
    // **Lista de peces en el tanque **/
    private ArrayList<Pez> peces;
    // **Número máximo de peces que puede haber en el tanque **/
    private int maxPeces;
    // **Tipo de pez existente en el tanque **/
    private PecesDatos tipoPez;
    // **Objeto Monedero que se encarga de gestionar las monedas generadas por la
    // piscifactoría. **/
    private Monedero monedero = Monedero.getInstance();
    // **Tipo de tanque, RIO o MAR */
    private CriaTipo tipoT;
    /**
     * Objeto AlmacenCentral que representa el almacén compartido de comida y se
     * utiliza para el manejo de inventario de alimentos en la piscifactoría.
     */
    private AlmacenCentral almacenCentral = AlmacenCentral.getInstance();

    /**
     * Constructor que crea el tanque y asigna el máximo de peces y el tipo del
     * tanque.
     * 
     * @param maxPeces
     * @param tipoT
     */
    public Tanque(int maxPeces, CriaTipo tipoT) {
        this.peces = new ArrayList<>();
        this.maxPeces = maxPeces;
        this.tipoT = tipoT;
    }

    /**
     * Metodo que muestra las estadísticas del tanque.
     */
    public void showStatus(int numTanque) {
        System.out.println("============Tanque " + (numTanque + 1) + "============");

        int pecesEnTanque=this.pecesEnTanque();
        int pecesVivos = this.pecesVivos();
        int pecesAlimentados = this.pecesAlimentados();
        int pecesAdultos = this.pecesAdultos();
    
        int ocupacionPorcentaje = (this.maxPeces != 0) ? ((pecesEnTanque * 100) / this.maxPeces) : 0;
        System.out.println("Ocupación: " + pecesEnTanque + "/" + this.maxPeces + " (" + ocupacionPorcentaje + "%)");
    
        int pecesVivosPorcentaje = (pecesEnTanque != 0) ? ((pecesVivos * 100) / pecesEnTanque) : 0;
        System.out.println("Peces vivos: " + pecesVivos + "/" + pecesEnTanque + " (" + pecesVivosPorcentaje + "%)");
    
        int pecesAlimentadosPorcentaje = (pecesVivos != 0) ? ((pecesAlimentados * 100) / pecesVivos) : 0;
        System.out.println("Peces alimentados: " + pecesAlimentados + "/" + pecesVivos + " (" + pecesAlimentadosPorcentaje + "%)");
    
        int pecesAdultosPorcentaje = (pecesVivos != 0) ? ((pecesAdultos * 100) / pecesVivos) : 0;
        System.out.println("Peces adultos: " + pecesAdultos + "/" + pecesVivos + " (" + pecesAdultosPorcentaje + "%)");
    
        System.out.println("H/M: " + pecesHembra() + "/" + pecesMacho());
    
        System.out.println("Fértiles: " + this.pecesFertiles() + "/" + pecesVivos);
    }
    

    /**
     * Método que muestra las estadísticas de todos los peces del tanque.
     */
    public void showFishStatus() {
        for (Pez pez : peces) {
            pez.showStatus();
        }
    }

    /**
     * Metodo que muestra información de la capacidad del tanque.
     */
    public void showCapacity(int numTanque) {
        System.out.println("Tanque " + (numTanque+1) + " al " + ((pecesEnTanque()/maxPeces)*100)
                + "% de capacidad [" + pecesEnTanque() + "/" + maxPeces + "].");
    }

    /**
     * Método que avanza un día, alimenta los peces del tanque, reproduce los peces
     * y vende los peces que estén en su estado óptimo.
     * 
     * @param comida Cantidad de comida disponible en la piscifactoria
     */
    public int[] nextDay(Piscifactoria pisci,estadisticas.Estadisticas stats) {
        int pecesHembraFertiles = 0;
        int pecesMachoFertiles = 0;

        boolean vegetal = true;
        if (this.peces.size() != 0) {
            if (this.peces.get(0) instanceof Carnivoro) {
                vegetal = false;
            } else if (this.peces.get(0) instanceof Filtrador) {
                vegetal = true;
            } else if (this.peces.get(0) instanceof Omnivoro) {
                if (pisci.getComidaAnimal() >= pisci.getComidaVegetal()) {
                    vegetal = false;
                } else {
                    vegetal = true;
                }
            }
        }

        for (Pez pez : peces) {
            int comidaCons = pez.grow(vegetal ? pisci.getComidaVegetal() : pisci.getComidaAnimal());
            pisci.restFood(comidaCons, vegetal ? "Vegetal" : "Animal");
            if (vegetal && pisci.comidaVegetalVacia()) {
                pisci.addFood(almacenCentral.cogerComidaVegetal(2), "Vegetal");
            } else if (!vegetal && pisci.comidaAnimalVacia()) {
                pisci.addFood(almacenCentral.cogerComidaAnimal(2), "Animal");
            }

            if (pez.isFemale() && pez.isFertile() && pez.isAlive()) {
                pecesHembraFertiles ++;
            } else if (!pez.isFemale() && pez.isFertile() && pez.isAlive()) {
                pecesMachoFertiles ++;
            }
        }

        ArrayList<Pez> nuevosPeces = new ArrayList<>();

        
        if (pecesHembra() > pecesMacho()) {
            int pecesEnTanque=peces.size();
            if (pecesHembraFertiles >= 1 && pecesMachoFertiles >= 1) {
                Iterator<Pez> iterator = peces.iterator();
                while (iterator.hasNext()) {
                    Pez pez = iterator.next();
                    if (pez.isFemale() && pez.isFertile() && pez.isAlive()) {
                        for (int i = 0; i < pez.getHuevos(); i++) {
                            if (i % 2 == 0) {
                                if(pecesEnTanque<maxPeces){
                                    nuevosPeces.add(pez.reproducirse(true));
                                    pecesEnTanque++;
                                    stats.registrarNacimiento(pez.getName());
                                    pez.notFertil();
                                    pez.resetPuesta();
                                }
                            } else {
                                if(pecesEnTanque<maxPeces){
                                    pecesEnTanque++;
                                    nuevosPeces.add(pez.reproducirse(false));
                                    stats.registrarNacimiento(pez.getName());
                                    pez.notFertil();
                                    pez.resetPuesta();
                                }
                            }
                        }
                    }
                }
            }
        } else {
            int pecesEnTanque=peces.size();
            if (pecesHembraFertiles >= 1 && pecesMachoFertiles >= 1) {
                Iterator<Pez> iterator = peces.iterator();
                while (iterator.hasNext()) {
                    Pez pez = iterator.next();
                    if (pez.isFemale() && pez.isFertile()) {
                        for (int i = 0; i < pez.getHuevos(); i++) {
                            if (i % 2 == 0) {
                                if(pecesEnTanque<maxPeces){
                                    nuevosPeces.add(pez.reproducirse(true));
                                    pecesEnTanque++;
                                    stats.registrarNacimiento(pez.getName());
                                    pez.notFertil();
                                    pez.resetPuesta();
                                }
                            } else {
                                if(pecesEnTanque<maxPeces){
                                    pecesEnTanque++;
                                    nuevosPeces.add(pez.reproducirse(false));
                                    stats.registrarNacimiento(pez.getName());
                                    pez.notFertil();
                                    pez.resetPuesta();
                                }
                            }
                        }
                    }
                }
            }
        }
        peces.addAll(nuevosPeces);
     
        return ventaPecesOptimos(stats);
    }

    /**
     * Método que devuelve la cantidad de peces que hay en el tanque.
     * 
     * @return Número de peces
     */
    public int pecesEnTanque() {
        return peces.size();
    }

    /**
     * Método que devuelve la cantidad de peces vivos en el tanque.
     * 
     * @return Número de peces vivos
     */
    public int pecesVivos() {
        int contadorPecesVivos = 0;
        for (Pez pez : peces) {
            if (pez.isAlive()) {
                contadorPecesVivos += 1;
            }
        }
        return contadorPecesVivos;
    }

    /**
     * Método que devuelve la cantidad de peces alimentados en el tanque.
     * 
     * @return Número de peces alimentados
     */
    public int pecesAlimentados() {
        int contadorPecesAlimentados = 0;
        for (Pez pez : peces) {
            if (pez.isAlimentado()) {
                contadorPecesAlimentados += 1;
            }
        }
        return contadorPecesAlimentados;
    }

    /**
     * Método que devuelve la cantidad de peces adultos en el tanque.
     * 
     * @return Número de peces adultos
     */
    public int pecesAdultos() {
        int contadorPecesAdultos = 0;
        for (Pez pez : peces) {
            if (pez.isAdulto()) {
                contadorPecesAdultos += 1;
            }
        }
        return contadorPecesAdultos;
    }

    /**
     * Método que devuelve la cantidad de peces hembra en el tanque.
     * 
     * @return Número de peces hembra
     */
    public int pecesHembra() {
        int contadorPecesHembra = 0;
        for (Pez pez : peces) {
            if (pez.isFemale()) {
                contadorPecesHembra += 1;
            }
        }
        return contadorPecesHembra;
    }

    /**
     * Método que devuelve la cantidad de peces macho en el tanque.
     * 
     * @return Número de peces macho
     */
    public int pecesMacho() {
        int contadorPecesMacho = 0;
        for (Pez pez : peces) {
            if (!pez.isFemale()) {
                contadorPecesMacho += 1;
            }
        }
        return contadorPecesMacho;
    }

    /**
     * Método que devuelve la cantidad de peces fértiles en el tanque.
     * 
     * @return Número de peces fértiles
     */
    public int pecesFertiles() {
        int contadorPecesFertiles = 0;
        for (Pez pez : peces) {
            if (pez.isFertile()) {
                contadorPecesFertiles += 1;
            }
        }
        return contadorPecesFertiles;
    }

    /**
     * Método que vende todos los peces óptimos del tanque.
     * 
     * @return Valores de monedas obtenidas con la venta y número de peces vendidos
     */
    public int[] ventaPecesOptimos(estadisticas.Estadisticas stats) {
        int[] valores = new int[2];
    
        int monedasObtenidas = 0;
        int pecesVendidos = 0;
    
        Iterator<Pez> iterator = peces.iterator();
        while (iterator.hasNext()) {
            Pez pez = iterator.next();
            if (pez.getAge() == pez.getOptimo()) {
                monedasObtenidas += pez.getMonedas();
                iterator.remove();
                pecesVendidos++;
                stats.registrarVenta(pez.getName(), monedasObtenidas);
            }
        }
    
        monedero.setMonedas(monedero.getMonedas() + monedasObtenidas);
        valores[0] = monedasObtenidas;
        valores[1] = pecesVendidos;
        return valores;
    }
    

    /**
     * Método que permite elegir entre los peces compatibles con el tanque.
     * 
     * @return El pez elegido
     */
    public Pez showCompatible(){
        int op = 0;

        do {
            try {
                if(this.peces.size()==0){
                    switch (tipoT) {
                        case RIO:
                            MenuHelper.mostrarMenu(new String[] {
                                    "Lucio del norte" + "(" + AlmacenPropiedades.LUCIO_NORTE.getCoste() + ")",
                                    "Carpa plateada" + "(" + AlmacenPropiedades.CARPA_PLATEADA.getCoste() + ")",
                                    "Carpa" + "(" + AlmacenPropiedades.CARPA.getCoste() + ")",
                                    "Tilapia del nilo" + "(" + AlmacenPropiedades.TILAPIA_NILO.getCoste() + ")",
                                    "Pejerrey" + "(" + AlmacenPropiedades.PEJERREY.getCoste() + ")",
                                    "Dorada" + "(" + AlmacenPropiedades.DORADA.getCoste() + ")",
                                    "Trucha arcoiris" + "(" + AlmacenPropiedades.TRUCHA_ARCOIRIS.getCoste() + ")" },
                                    false);
                            op = InputHelper.getIntRanges(7,1);
                            switch (op) {
                                case 1:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new LucioDelNorte(true);
                                    } else {
                                        return new LucioDelNorte(false);
                                    }
                                case 2:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new CarpaPlateada(true);
                                    } else {
                                        return new CarpaPlateada(false);
                                    }
                                case 3:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Carpa(true);
                                    } else {
                                        return new Carpa(false);
                                    }
                                case 4:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new TilapiaDelNilo(true);
                                    } else {
                                        return new TilapiaDelNilo(false);
                                    }
                                case 5:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Pejerrey(true);
                                    } else {
                                        return new Pejerrey(false);
                                    }
                                case 6:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Dorada(true);
                                    } else {
                                        return new Dorada(false);
                                    }
                                case 7:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new TruchaArcoiris(true);
                                    } else {
                                        return new TruchaArcoiris(false);
                                    }
                                case 0:
                                    return null;
                                default:
                                    System.out.println("Escoge un número válido");
                                    return null;
                            }
                        case MAR:
                            MenuHelper.mostrarMenu(
                                    new String[] { "Abadejo" + "(" + AlmacenPropiedades.ABADEJO.getCoste() + ")",
                                            "Besugo" + "(" + AlmacenPropiedades.BESUGO.getCoste() + ")",
                                            "Caballa" + "(" + AlmacenPropiedades.CABALLA.getCoste() + ")",
                                            "Rodaballo" + "(" + AlmacenPropiedades.RODABALLO.getCoste() + ")",
                                            "Sargo" + "(" + AlmacenPropiedades.SARGO.getCoste() + ")",
                                            "Dorada" + "(" + AlmacenPropiedades.DORADA.getCoste() + ")",
                                            "Trucha arcoiris" + "(" + AlmacenPropiedades.TRUCHA_ARCOIRIS.getCoste()
                                                    + ")" },
                                    false);
                            op = InputHelper.getIntRanges(7,1);
                            switch (op) {
                                case 1:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Abadejo(true);
                                    } else {
                                        return new Abadejo(false);
                                    }
                                case 2:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Besugo(true);
                                    } else {
                                        return new Besugo(false);
                                    }
                                case 3:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Caballa(true);
                                    } else {
                                        return new Caballa(false);
                                    }
                                case 4:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Rodaballo(true);
                                    } else {
                                        return new Rodaballo(false);
                                    }
                                case 5:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Sargo(true);
                                    } else {
                                        return new Sargo(false);
                                    }
                                case 6:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new Dorada(true);
                                    } else {
                                        return new Dorada(false);
                                    }
                                case 7:
                                    if (this.pecesHembra() <= this.pecesMacho()) {
                                        return new TruchaArcoiris(true);
                                    } else {
                                        return new TruchaArcoiris(false);
                                    }
                                case 0:
                                    return null;
                                default:
                                    System.out.println("Escoge un número válido");
                                    return null;
                            }
                        default:
                            break;
                    }
                } else if (this.peces.size()==this.maxPeces) {
                    System.out.println("Este tanque esta lleno");
                    return null;
                }else{
                    System.out.println("1. " + this.peces.get(0).getName());
                    System.out.println("0. Salir");
                    op = InputHelper.getIntRanges(1);
                    if (op == 1) {
                        if (this.pecesHembra() <= this.pecesMacho()) {
                            return peces.get(0).reproducirse(true);
                        } else {
                            return peces.get(0).reproducirse(false);
                        }
                    } else if (op == 0) {
                        return null;
                    } else {
                        System.out.println("Escribe un dato correcto");
                        return null;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Escribe un número");
                return null;
            }
        } while (op == 0);
        return null;
    }

    /**
     * Devuelve la lista de peces en el tanque.
     * 
     * @return una lista de peces
     */
    public ArrayList<Pez> getPeces() {
        return peces;
    }

    /**
     * Devuelve la capacidad máxima de peces permitidos en el tanque.
     * 
     * @return el número máximo de peces que el tanque puede contener.
     */
    public int getMaxPeces() {
        return maxPeces;
    }

    /**
     * Devuelve el tipo de pez del tanque.
     * 
     * @return el tipo de pez del tanque
     */
    public PecesDatos getTipoPez() {
        return tipoPez;
    }

    /**
     * Devuelve el tipo de tanque (RIO, MAR, DOUBLE).
     * 
     * @return el tipo de tanque 
     */
    public CriaTipo getTipoT() {
        return tipoT;
    }    
}
