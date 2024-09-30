package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LubinaRayada extends Pez{

    public LubinaRayada(char Sexo){
        super(AlmacenPropiedades.LUBINA_RAYADA);
        this.Sexo = Sexo;
    }
    //TODO grow
}
