package peces.propiedades;

import dtos.DTOPez;
import peces.Pez;
import propiedades.PecesDatos;

/**
 * Clase para peces carnívoros
 * @author Breogan
 */
public abstract class Carnivoro extends Pez{

    /**
     * Constructor parametrizado
     * @param data Datos del Pez
     */
    protected Carnivoro(PecesDatos data) {
        super(data);
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    protected Carnivoro(DTOPez pes, PecesDatos data){
        super(pes, data);
    }

    @Override
    public int comer(int cantidad) {
        if (cantidad >= 1){
            this.Comido = true;
            return 1;
        }
        return 0;
    }
    
}
