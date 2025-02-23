package tanque;

import helpers.InputHelper;
import helpers.MenuHelper;
import peces.Pez;
import peces.doble.Dorada;
import peces.doble.TruchaArcoiris;
import peces.mar.Abadejo;
import peces.mar.Besugo;
import peces.mar.Caballa;
import peces.mar.Rodaballo;
import peces.mar.Sargo;
import peces.rio.Carpa;
import peces.rio.CarpaPlateada;
import peces.rio.LucioDelNorte;
import peces.rio.Pejerrey;
import peces.rio.TilapiaDelNilo;
import piscifactoria.Piscifactoria;
import propiedades.CriaTipo;

public class TanqueCria {

    /** Pareja de peces que crian */
    private Pez[] pez;

    /** piscifactoría a la que pertenece */
    private Piscifactoria pisc;

    /**
     * Constructor
     */
    public TanqueCria(Piscifactoria pisc) {
        this.pez = new Pez[2];
        this.pisc = pisc;
        Pez peskaito = showCompatible();
        this.pez[0] = peskaito.reproducirse(true);
        this.pez[1] = peskaito.reproducirse(false);
    }

    /**
     * Hace pasar un día en el tanque
     * 
     * @param comida comida disponible de la piscifactoría
     * @return comida consumida en total
     */
    public int nextDay(int comida) {
        int comidaConsumida = 0;
        for (int i = 0; i < pez.length; i++) {
            if (pez[i].growInBreed(comida)) {
                comidaConsumida += 2;
            }
        }
        return comidaConsumida;
    }

    /**
     * Vacía el tanque si hay algun pez
     */
    public void vaciar() {
        if (hayElementos()) {
            for (int i = 0; i < pez.length; i++) {
                pez[i] = null;
            }
            System.out.println("Peces vaciados");
        } else {
            System.out.println("Tanque vacio, no hay nada que vaciar");
        }
    }

    /**
     * Comprueba si hay algun elemento en el array de peces
     * 
     * @return
     */
    private boolean hayElementos() {
        for (int i = 0; i < pez.length; i++) {
            if (!(pez[i].equals(null))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite seleccionar los peces para el tanque de cria
     * 
     * @return Pez seleccionado
     */
    public Pez showCompatible() {
        int op = 0;
        CriaTipo tipo = pisc.getTipo();
        switch (tipo) {
            case RIO:
                MenuHelper.mostrarMenu(new String[] {
                        "Lucio del norte",
                        "Carpa plateada",
                        "Carpa",
                        "Tilapia del nilo",
                        "Pejerrey",
                        "Dorada",
                        "Trucha arcoiris" },
                        false);
                op = InputHelper.getIntRanges(7, 1);
                switch (op) {
                    case 1:
                        return new LucioDelNorte(false);
                    case 2:
                        return new CarpaPlateada(false);
                    case 3:
                        return new Carpa(false);
                    case 4:
                        return new TilapiaDelNilo(false);
                    case 5:
                        return new Pejerrey(false);
                    case 6:
                        return new Dorada(false);
                    case 7:
                        return new TruchaArcoiris(false);
                    case 0:
                        return null;
                    default:
                        System.out.println("Escoge un número válido");
                        return null;
                }
            case MAR:
                MenuHelper.mostrarMenu(
                        new String[] { "Abadejo",
                                "Besugo",
                                "Caballa",
                                "Rodaballo",
                                "Sargo",
                                "Dorada",
                                "Trucha arcoiris" },
                        false);
                op = InputHelper.getIntRanges(7, 1);
                switch (op) {
                    case 1:
                        return new Abadejo(false);
                    case 2:
                        return new Besugo(false);
                    case 3:
                        return new Caballa(false);
                    case 4:
                        return new Rodaballo(false);
                    case 5:
                        return new Sargo(false);
                    case 6:
                        return new Dorada(false);
                    case 7:
                        return new TruchaArcoiris(false);
                    case 0:
                        return null;
                    default:
                        System.out.println("Escoge un número válido");
                        return null;
                }
            default:
                return null;
        }
    }

    /**
     * @return Array de peces
     */
    public Pez[] getPez() {
        return pez;
    }

    /**
     * @return Piscifactoria a la que pertenece
     */
    public Piscifactoria getPisc() {
        return pisc;
    }

    /**
     * @param pez Array de peces
     */
    public void setPez(Pez[] pez) {
        this.pez = pez;
    }

    /**
     * @param pisc piscifactoría
     */
    public void setPisc(Piscifactoria pisc) {
        this.pisc = pisc;
    }

}
