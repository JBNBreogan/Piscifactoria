package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Besugo
 * @author Breogan
 */
public class Besugo extends Carnivoro{

    public Besugo(boolean hembra){
        super(AlmacenPropiedades.BESUGO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Besugo(hembra);
    }
}
