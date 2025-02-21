package tanque;

import peces.Pez;
import piscifactoria.Piscifactoria;

public class TanqueCria {
    private Pez[] pez;

    /** piscifactoría a la que pertenece */
    private Piscifactoria pisc;


    public TanqueCria(){
        this.pez = new Pez[2];
    }

    public int nextDay(int comida){
        int comidaConsumida = 0;
        for (int i = 0; i < pez.length; i++) {
            if(pez[i].growInBreed(comida)){
                comidaConsumida+=2;
            }
        }
        return comidaConsumida;
    }

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

    private boolean hayElementos(){
        for (int i = 0; i < pez.length; i++) {
            if (!(pez[i].equals(null))){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Pez[] getPez() {
        return pez;
    }

    public Piscifactoria getPisc() {
        return pisc;
    }
    public void setPez(Pez[] pez) {
        this.pez = pez;
    }
    public void setPisc(Piscifactoria pisc) {
        this.pisc = pisc;
    }



}
