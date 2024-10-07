package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

public class LenguadoEuropeo extends Pez implements Carnivoro{

    public LenguadoEuropeo(boolean hembra){
        super(AlmacenPropiedades.LENGUADO_EUROPEO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new LenguadoEuropeo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    
    //TODO Grow
}
