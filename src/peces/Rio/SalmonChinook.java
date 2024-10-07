package peces.Rio;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class SalmonChinook extends Pez implements Carnivoro{

    public SalmonChinook(boolean hembra){
        super(AlmacenPropiedades.SALMON_CHINOOK);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new SalmonChinook(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comer'");
    }
}
