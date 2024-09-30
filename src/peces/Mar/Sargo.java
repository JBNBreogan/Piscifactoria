package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Sargo extends Pez{

    public Sargo(char Sexo){
        super(AlmacenPropiedades.SARGO);
        this.Sexo = Sexo;
    }
    //TODO grow
}
