package peces.mar;

import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import saves.DTOPez;

/**
 * Clase que representa a la Caballa
 * @author Breogan
 */
public class Caballa extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Caballa(boolean hembra){
        super(AlmacenPropiedades.CABALLA);
        this.Sexo = hembra;
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public Caballa(DTOPez pes){
        super(pes, AlmacenPropiedades.CABALLA);
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Caballa(hembra);
    }
}
