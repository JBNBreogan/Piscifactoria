package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LenguadoEuropeo extends Pez{

    public LenguadoEuropeo(char Sexo){
        super(AlmacenPropiedades.LENGUADO_EUROPEO);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
