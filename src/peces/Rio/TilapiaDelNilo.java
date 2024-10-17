package peces.Rio;

import peces.Pez;
import peces.Propiedades.Filtrador;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Tilapia del Nilo
 * @author Breogan
 */
public class TilapiaDelNilo extends Pez implements Filtrador{

    public TilapiaDelNilo(boolean hembra){
        super(AlmacenPropiedades.TILAPIA_NILO);
        this.Sexo = hembra;
    }

    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new TilapiaDelNilo(hembra);
    }


    @Override
    public void comer(int cantidad) {
        // TODO comer
    }
}
