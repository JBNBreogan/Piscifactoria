package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class LubinaRayada extends Pez{

    public LubinaRayada(boolean hembra){
        super(AlmacenPropiedades.LUBINA_RAYADA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new LubinaRayada(hembra);
    }
    
    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
