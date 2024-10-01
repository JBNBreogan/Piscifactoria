package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Corvina extends Pez{

    public Corvina(char Sexo){
        super(AlmacenPropiedades.CORVINA);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
