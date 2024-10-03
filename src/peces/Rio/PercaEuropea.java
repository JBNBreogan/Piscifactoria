package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class PercaEuropea extends Pez{

    public PercaEuropea(boolean hembra){
        super(AlmacenPropiedades.PERCA_EUROPEA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new PercaEuropea(hembra);
    }
    //TODO Todo el pez

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comer'");
    }
}
