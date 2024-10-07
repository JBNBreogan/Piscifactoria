package peces.Rio;

import peces.Pez;
import peces.Propiedades.Longevo;
import peces.Propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

public class Koi extends Pez implements Omnivoro,Longevo{

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
