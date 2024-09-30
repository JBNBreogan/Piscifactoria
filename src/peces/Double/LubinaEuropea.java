package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LubinaEuropea extends Pez{

    public LubinaEuropea(char Sexo){
        super(AlmacenPropiedades.LUBINA_EUROPEA);
        this.Sexo = Sexo;
    }
    //TODO grow
}
