package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Caballa extends Pez{

    public Caballa(boolean hembra){
        super(AlmacenPropiedades.CABALLA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Caballa(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
