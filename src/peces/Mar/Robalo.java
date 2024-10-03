package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Robalo extends Pez{

    public Robalo(boolean hembra){
        super(AlmacenPropiedades.ROBALO);
        this.Sexo = hembra;
    }
    
    @Override
    public Pez reproducirse(boolean hembra) {
        return new Robalo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
