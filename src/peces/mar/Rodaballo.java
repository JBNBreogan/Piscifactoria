package peces.mar;

import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import saves.DTOPez;

/**
 * Clase que representa al Rodaballo
 * @author Breogan
 */
public class Rodaballo extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Rodaballo(boolean hembra){
        super(AlmacenPropiedades.RODABALLO);
        this.Sexo = hembra;
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public Rodaballo(DTOPez pes){
        super(pes, AlmacenPropiedades.RODABALLO);
    }
    
    @Override
    public Pez reproducirse(boolean hembra) {
        return new Rodaballo(hembra);
    }

    @Override
    public int comer(int cantidad) {
        if (cantidad >= 2){
            this.Comido = true;
            return 2;
        }
        return 0;
    }
}
