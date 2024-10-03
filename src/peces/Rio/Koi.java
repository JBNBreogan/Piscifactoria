package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Koi extends Pez{

    public Koi(boolean hembra){
        super(AlmacenPropiedades.KOI);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Koi(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
