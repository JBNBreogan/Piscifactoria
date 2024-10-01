package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class SiluroEuropeo extends Pez{

    public SiluroEuropeo(char Sexo){
        super(AlmacenPropiedades.SILURO_EUROPEO);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
