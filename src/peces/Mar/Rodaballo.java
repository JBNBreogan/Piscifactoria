package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import peces.Propiedades.Voraz;
import propiedades.AlmacenPropiedades;

public class Rodaballo extends Pez implements Carnivoro,Voraz{

    public Rodaballo(boolean hembra){
        super(AlmacenPropiedades.RODABALLO);
        this.Sexo = hembra;
    }
    
    @Override
    public Pez reproducirse(boolean hembra) {
        return new Rodaballo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
