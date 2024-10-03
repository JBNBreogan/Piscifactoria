package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class CarpaPlateada extends Pez{

    public CarpaPlateada(boolean hembra){
        super(AlmacenPropiedades.CARPA_PLATEADA);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new CarpaPlateada(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
