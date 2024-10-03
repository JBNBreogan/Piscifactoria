package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LucioDelNorte extends Pez{

    public LucioDelNorte(boolean hembra){
        super(AlmacenPropiedades.LUCIO_NORTE);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new LucioDelNorte(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
