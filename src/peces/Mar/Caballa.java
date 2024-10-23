package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Caballa
 * @author Breogan
 */
public class Caballa extends Carnivoro{

    public Caballa(boolean hembra){
        super(AlmacenPropiedades.CABALLA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Caballa(hembra);
    }
}
