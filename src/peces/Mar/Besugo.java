package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Besugo extends Pez{

    public Besugo(boolean hembra){
        super(AlmacenPropiedades.BESUGO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Besugo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
