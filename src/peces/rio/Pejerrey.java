package peces.rio;

import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Pejerrey
 * @author Breogan
 */
public class Pejerrey extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Pejerrey(boolean hembra){
        super(AlmacenPropiedades.PEJERREY);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Pejerrey(hembra);
    }
}
