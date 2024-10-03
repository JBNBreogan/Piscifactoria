package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Abadejo extends Pez{
    
    public Abadejo(boolean hembra){
        super(AlmacenPropiedades.ABADEJO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Abadejo(hembra);
    }
    
    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO Grow
}
