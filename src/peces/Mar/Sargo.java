package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Sargo extends Pez{

    public Sargo(boolean hembra){
        super(AlmacenPropiedades.SARGO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Sargo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
