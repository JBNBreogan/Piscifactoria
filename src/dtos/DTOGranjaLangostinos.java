package dtos;

import java.util.ArrayList;
import java.util.List;

import granjas.GranjaLangostinos;
import granjas.TanqueLangostinos;

/**
 * Clase que guarda la información de la granja de langostinos. Extiende de
 * DTOEdificios
 * 
 * @author Nicolas
 */
public class DTOGranjaLangostinos extends DTOEdificios {
    /** Lista de tanques de la granja de langostinos */
    private List<DTOTanqueLangostinos> tanques;
    /** Peces muertos en la granja de langostinos */
    private int muertos;

    /**
     * Constructos
     * @param granjaLangostinos granja de langostinos.
     */
    public DTOGranjaLangostinos(GranjaLangostinos granjaLangostinos) {
        super(granjaLangostinos != null);

        if (granjaLangostinos != null) {
            this.tanques = new ArrayList<>();
            this.muertos = granjaLangostinos.getMuertos();
            List<TanqueLangostinos> aux = granjaLangostinos.getTanques();
            for (TanqueLangostinos tanqueLangostinos : aux) {
                tanques.add(new DTOTanqueLangostinos(tanqueLangostinos));
            }
        } else {
            this.muertos = 0;

        }
    }

    /**
     * Devuelve la lista de tanque de una granja de langostinos
     * @return lista de tanques
     */
    public List<DTOTanqueLangostinos> getTanques() {
        return tanques;
    }

    /**
     * Establece los tanques de una granja de langostinos
     * @param tanques La lista de tanques.
     */
    public void setTanques(ArrayList<DTOTanqueLangostinos> tanques) {
        this.tanques = tanques;
    }
    /**
     * Establece los tanques de una granja de langostinos
     * @param tanques La lista de tanques.
     */
    public void setTanques(List<DTOTanqueLangostinos> tanques) {
        this.tanques = tanques;
    }

    /**
     * Devuelve la cantidad de peces muertos de una granja de langostinos.
     * @return el numero de peces muertos
     */
    public int getMuertos() {
        return muertos;
    }
    
    /**
     * Establece el número de peces muertos de una granja de langostinos
     * @param muertos numero de peces muertos.
     */
    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

}
