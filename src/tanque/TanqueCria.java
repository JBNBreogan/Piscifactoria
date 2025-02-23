package tanque;

import peces.Pez;
import piscifactoria.Piscifactoria;

public class TanqueCria {

    /** Pareja de peces que crian */
    private Pez[] pez;

    /** piscifactoría a la que pertenece */
    private Piscifactoria pisc;

    /**
     * Constructor
     */
    public TanqueCria(Pez pez){
        this.pez = new Pez[2];
        this.pez[0] = pez.reproducirse(true);
        this.pez[1] = pez.reproducirse(false);
    }

    /**
     * Hace pasar un día en el tanque
     * @param comida comida disponible de la piscifactoría
     * @return comida consumida en total
     */
    public int nextDay(int comida){
        int comidaConsumida = 0;
        for (int i = 0; i < pez.length; i++) {
            if(pez[i].growInBreed(comida)){
                comidaConsumida+=2;
            }
        }
        return comidaConsumida;
    }

    /**
     * Vacía el tanque si hay algun pez
     */
    public void vaciar(){
        if (hayElementos()){
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
     * @return
     */
    private boolean hayElementos(){
        for (int i = 0; i < pez.length; i++) {
            if (!(pez[i].equals(null))){
                return true;
            }
        }
        return false;
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
