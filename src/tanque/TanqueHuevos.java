package tanque;

import java.util.ArrayList;

import peces.Pez;

public class TanqueHuevos {

    /** Huevos de peces */
    Pez[] huevos;

    /**
     * Constructor genérico
     */
    public TanqueHuevos(){
        this.huevos = new Pez[25];
    }


    /**
     * Al pasar el día, comprueba todos los huevos del tanque, y los tanques de la piscifactoría, añadiendo
     * los peces a los posibles tanques.
     * @param tanques Los tanques de la piscifactoría;
     */
    public void nextDay(ArrayList<Tanque> tanques) {
        for (int i = 0; i < huevos.length; i++) {
            Pez huevo = huevos[i];
            if (huevo != null) { 
                boolean transferido = false;
                for (Tanque tanque : tanques) {
                    if (!tanque.getPeces().isEmpty() && !tanque.isFull()) {
                        ArrayList<Pez> pecesTanque = tanque.getPeces();
                        if (!pecesTanque.isEmpty()) {
                            for (Pez pezTanque : pecesTanque) {
                                if (huevo.getName().equals(pezTanque.getName())) {
                                    tanque.addPez(huevo);
                                    huevos[i] = null;
                                    transferido = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (transferido) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Añade un huevo al tanque de huevos si hay espacio
     * @param webo El huevo de pez
     * @return Si ha sido añadido
     */
    public boolean addWebo(Pez webo){
        for (int i = 0; i < huevos.length; i++) {
            if (huevos[i] == null){
                huevos[i] = webo;
                return true;
            }
        }
        System.out.println("No hay espacio en el tanque de huevos");
        return false;
    }

    /**
     * @return Array de huevos
     */
    public Pez[] getHuevos() {
        return huevos;
    }

    /**
     * @param huevos Array de huevos
     */
    public void setHuevos(Pez[] huevos) {
        this.huevos = huevos;
    }

    
}
