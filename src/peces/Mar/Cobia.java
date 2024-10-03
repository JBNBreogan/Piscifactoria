package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Cobia extends Pez{

    public Cobia(boolean hembra){
        super(AlmacenPropiedades.COBIA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Cobia(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO Grow
}
