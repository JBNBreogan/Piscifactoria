package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import peces.Propiedades.Comedido;
import peces.Propiedades.Voraz;
import propiedades.AlmacenPropiedades;

public class Cobia extends Pez implements Carnivoro,Voraz,Comedido{

    public Cobia(boolean hembra){
        super(AlmacenPropiedades.COBIA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Cobia(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO Grow
}
