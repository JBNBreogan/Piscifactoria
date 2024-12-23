package peces.doble;

import peces.Pez;
import peces.propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Dorada
 * @author Breogan
 */
public class Dorada extends Omnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Dorada(boolean hembra){
        super(AlmacenPropiedades.DORADA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Dorada(hembra);
    }
}
