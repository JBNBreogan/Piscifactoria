package peces.Mar;

import peces.Pez;
import peces.Propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Sargo
 * @author Breogan
 */
public class Sargo extends Omnivoro{

    public Sargo(boolean hembra){
        super(AlmacenPropiedades.SARGO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Sargo(hembra);
    }
}
