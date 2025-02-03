package peces.mar;

import peces.Pez;
import peces.propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;
import saves.DTOPez;

/**
 * Clase que representa al Sargo
 * @author Breogan
 */
public class Sargo extends Omnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Sargo(boolean hembra){
        super(AlmacenPropiedades.SARGO);
        this.Sexo = hembra;
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public Sargo(DTOPez pes){
        super(pes, AlmacenPropiedades.SARGO);
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Sargo(hembra);
    }
}
