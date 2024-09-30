package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Robalo extends Pez{

    public Robalo(char Sexo){
        super(AlmacenPropiedades.ROBALO);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
