package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class CarpaPlateada extends Pez{

    public CarpaPlateada(char Sexo){
        super(AlmacenPropiedades.CARPA_PLATEADA);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
