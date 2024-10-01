package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LucioDelNorte extends Pez{

    public LucioDelNorte(char Sexo){
        super(AlmacenPropiedades.LUCIO_NORTE);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
