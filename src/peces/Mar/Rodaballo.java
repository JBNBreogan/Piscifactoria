package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Rodaballo extends Pez{

    public Rodaballo(char Sexo){
        super(AlmacenPropiedades.RODABALLO);
        this.Sexo = Sexo;
    }
    //TODO grow
}
