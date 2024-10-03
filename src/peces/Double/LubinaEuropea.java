package peces.Double;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LubinaEuropea extends Pez{

    public LubinaEuropea(boolean hembra){
        super(AlmacenPropiedades.LUBINA_EUROPEA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new LubinaEuropea(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
    }
    //TODO grow
}
