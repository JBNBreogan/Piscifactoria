package peces.Rio;

import peces.Pez;
import peces.Propiedades.Omnivoro;
import peces.Propiedades.Voraz;
import propiedades.AlmacenPropiedades;


public class Carpa extends Pez implements Omnivoro,Voraz{

    public Carpa(boolean hembra){
        super(AlmacenPropiedades.CARPA);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Carpa(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
