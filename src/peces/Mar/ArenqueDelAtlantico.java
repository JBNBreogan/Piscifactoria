package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class ArenqueDelAtlantico extends Pez{

    public ArenqueDelAtlantico(boolean hembra){
        super(AlmacenPropiedades.ARENQUE_ATLANTICO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new ArenqueDelAtlantico(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO Grow
}
