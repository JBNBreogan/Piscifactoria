package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;


public class Carpa extends Pez{

    public Carpa(char Sexo){
        super(AlmacenPropiedades.CARPA);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
