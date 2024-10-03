package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Corvina extends Pez{

    public Corvina(boolean hembra){
        super(AlmacenPropiedades.CORVINA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Corvina(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO Grow
}
