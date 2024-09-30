package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Dorada extends Pez{

    public Dorada(char Sexo){
        super(AlmacenPropiedades.DORADA);
        this.Sexo = Sexo;
    }
    //TODO grow
}
