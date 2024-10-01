package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Besugo extends Pez{

    public Besugo(char Sexo){
        super(AlmacenPropiedades.BESUGO);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
