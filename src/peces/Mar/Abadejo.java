package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Abadejo extends Pez{
    
    public Abadejo(char Sexo){
        super(AlmacenPropiedades.ABADEJO);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
