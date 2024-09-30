package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class SalmonAtlantico extends Pez{

    public SalmonAtlantico(char Sexo){
        super(AlmacenPropiedades.SALMON_ATLANTICO);
        this.Sexo = Sexo;
    }
    //TODO grow
}
