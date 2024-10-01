package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class SalmonChinook extends Pez{

    public SalmonChinook(char Sexo){
        super(AlmacenPropiedades.SALMON_CHINOOK);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
