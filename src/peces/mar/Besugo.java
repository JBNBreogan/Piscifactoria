package peces.mar;

import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import saves.DTOPez;

/**
 * Clase que representa al Besugo
 * @author Breogan
 */
public class Besugo extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Besugo(boolean hembra){
        super(AlmacenPropiedades.BESUGO);
        this.Sexo = hembra;
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public Besugo(DTOPez pes){
        super(pes, AlmacenPropiedades.BESUGO);
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Besugo(hembra);
    }
}
