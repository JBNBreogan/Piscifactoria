package peces.propiedades;

import java.util.Random;

import peces.Pez;
import propiedades.PecesDatos;
import saves.DTOPez;

/**
 * Clase para peces filtradores
 * @author Breogan
 */
public abstract class Filtrador extends Pez{
    
    /**
     * Cosntructor paraetrizado
     * @param data datos del pez
     */
    protected Filtrador(PecesDatos data){
        super(data);
    }
    
    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    protected Filtrador(DTOPez pes, PecesDatos data){
        super(pes, data);
    }
    

    @Override
    public int comer(int cantidad) {
        Random comer = new Random();
        if (comer.nextInt(2) != 0){
            this.Comido = true;
            return 0;
        } else if (cantidad >= 1){
            this.Comido = true;
            return 1;
        }
        return 0;
    }
}
