package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Pejerrey extends Pez{

    public Pejerrey(char Sexo){
        super(AlmacenPropiedades.PEJERREY);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
