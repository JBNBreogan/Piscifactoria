package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Pejerrey extends Pez{

    public Pejerrey(boolean hembra){
        super(AlmacenPropiedades.PEJERREY);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Pejerrey(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
