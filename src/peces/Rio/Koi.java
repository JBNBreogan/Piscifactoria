package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Koi extends Pez{

    public Koi(char Sexo){
        super(AlmacenPropiedades.KOI);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
