package dtos;

import granjas.TanqueLangostinos;

/**
 * Clase que guarda la información de los tanques de langostinos de la granja de langostinos.
 * 
 * @author Nicolás
 */
public class DTOTanqueLangostinos {
    /**
     * Cantidad de comida
     */
    int comida;
    /**
     * Días de descanso.
     */
    int descanso;
    
    /**
     * Constructot
     * @param tanqueLangostinos el tanque de langostinos
     */
    public DTOTanqueLangostinos(TanqueLangostinos tanqueLangostinos) {
        this.comida = tanqueLangostinos.getComidaAlmacenada();
        this.descanso = tanqueLangostinos.getDiasDescanso();
    }

    /**
     * Devuelve la cantidad de comida de un tanque de langostinos.
     * @return la cantidad de comida
     */
    public int getComida() {
        return comida;
    }

    /**
     * Establece la cantidad de comida de un tanque de langostinos.
     * @param comida la cantidad de comida
     */
    public void setComida(int comida) {
        this.comida = comida;
    }

   /**
     * Devuelve los días de descanso de un tanque de langostinos
     * @return los días de descanso.
     */
    public int getDescanso() {
        return descanso;
    }

    /**
     * Establece los días de descanso de un tanque.
     * @param descanso días de descanso.
     */
    public void setDescanso(int descanso) {
        this.descanso = descanso;
    }

    
}
