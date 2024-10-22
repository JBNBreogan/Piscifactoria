package peces.Double;

import peces.Pez;
import peces.Propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Dorada
 * @author Breogan
 */
public class Dorada extends Omnivoro{

    public Dorada(boolean hembra){
        super(AlmacenPropiedades.DORADA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Dorada(hembra);
    }
}
