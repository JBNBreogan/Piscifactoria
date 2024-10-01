package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Caballa extends Pez{

    public Caballa(char Sexo){
        super(AlmacenPropiedades.CABALLA);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
