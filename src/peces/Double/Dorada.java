package peces.Double;

import peces.Pez;
import peces.Propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

public class Dorada extends Pez implements Omnivoro{

    public Dorada(boolean hembra){
        super(AlmacenPropiedades.DORADA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Dorada(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO grow
}
