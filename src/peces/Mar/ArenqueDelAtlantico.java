package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class ArenqueDelAtlantico extends Pez{

    public ArenqueDelAtlantico(char Sexo){
        super(AlmacenPropiedades.ARENQUE_ATLANTICO);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
