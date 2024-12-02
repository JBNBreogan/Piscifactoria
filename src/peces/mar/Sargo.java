package peces.mar;

import peces.Pez;
import peces.Propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

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

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Sargo(hembra);
    }
}
