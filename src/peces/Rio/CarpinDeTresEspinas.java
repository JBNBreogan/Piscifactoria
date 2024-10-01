package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class CarpinDeTresEspinas extends Pez{

    public CarpinDeTresEspinas(char Sexo){
        super(AlmacenPropiedades.CARPIN_TRES_ESPINAS);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
