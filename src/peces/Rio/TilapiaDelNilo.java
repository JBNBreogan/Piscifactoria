package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class TilapiaDelNilo extends Pez{

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
