package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class SalmonAtlantico extends Pez{

    public SalmonAtlantico(boolean hembra){
        super(AlmacenPropiedades.SALMON_ATLANTICO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new SalmonAtlantico(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO grow
}
