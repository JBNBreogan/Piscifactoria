package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Rodaballo extends Pez{

    public Rodaballo(boolean hembra){
        super(AlmacenPropiedades.RODABALLO);
        this.Sexo = hembra;
    }
    
    @Override
    public Pez reproducirse(boolean hembra) {
        return new Rodaballo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
