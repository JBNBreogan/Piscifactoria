package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class BagreDeCanal extends Pez{
    
    public BagreDeCanal(boolean hembra){
        super(AlmacenPropiedades.BAGRE_CANAL);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new BagreDeCanal(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO todo el pez
}
