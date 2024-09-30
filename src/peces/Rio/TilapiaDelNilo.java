package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class TilapiaDelNilo extends Pez{

    public TilapiaDelNilo(char Sexo){
        super(AlmacenPropiedades.TILAPIA_NILO);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
