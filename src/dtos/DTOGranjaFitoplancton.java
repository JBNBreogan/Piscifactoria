package dtos;

import granjas.GranjaFitoplancton;


/**
 * Clase que guarda la información de la granja de fitoplancton. Extiende de DTOEdificios
 * @author Nicolas
 */
public class DTOGranjaFitoplancton extends DTOEdificios {
    /**
     * Cantidad de tanques.
     */
    int tanques;
    /**
     * Día de ciclo
     */
    int ciclo;
    
    /**
     * Constructor
     * @param granjaFitoplancton la granja de fitoplancton
     */
    public DTOGranjaFitoplancton(GranjaFitoplancton granjaFitoplancton) {
        super(granjaFitoplancton != null);
        if(granjaFitoplancton==null){
            tanques = 0;
            ciclo = 0;
        } else {
            tanques = granjaFitoplancton.getTanques();
            ciclo = granjaFitoplancton.getCiclo();
        }
    }

    /**
     * Devuelve el número de tanques de una granja
     * @return numero de tanques
     */
    public int getTanques() {
        return tanques;
    }

    /**
     * Establece el número de tanques de una granja
     * @param tanques numero de tanques
     */
    public void setTanques(int tanques) {
        this.tanques = tanques;
    }

    /**
     * Devuelve el día de ciclo de la granja
     * @return dia de ciclo
     */
    public int getCiclo() {
        return ciclo;
    }

    /**
     * Establece el día de ciclo de la granja
     * @param ciclo dia de ciclo.
     */
    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
    
    
}
