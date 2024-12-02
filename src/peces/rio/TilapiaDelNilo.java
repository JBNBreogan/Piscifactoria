package peces.rio;

import peces.Pez;
import peces.Propiedades.Filtrador;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Tilapia del Nilo
 * @author Breogan
 */
public class TilapiaDelNilo extends Filtrador{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public TilapiaDelNilo(boolean hembra){
        super(AlmacenPropiedades.TILAPIA_NILO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new TilapiaDelNilo(hembra);
    }
}
