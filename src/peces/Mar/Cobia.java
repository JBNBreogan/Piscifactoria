package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Cobia extends Pez{

    public Cobia(char Sexo){
        super(AlmacenPropiedades.COBIA);
        this.Sexo = Sexo;
    }
    //TODO Grow
}
