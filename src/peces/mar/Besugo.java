package peces.mar;

import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

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

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Besugo(hembra);
    }
}
