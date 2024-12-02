package peces.Double;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Trucha Arcoíris
 * @author Breogan
 */
public class TruchaArcoiris extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public TruchaArcoiris(boolean hembra){
        super(AlmacenPropiedades.TRUCHA_ARCOIRIS);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new TruchaArcoiris(hembra);
    }
}
