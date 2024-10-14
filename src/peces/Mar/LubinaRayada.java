package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Lubina Rayada
 * @author Breogan
 */
public class LubinaRayada extends Pez implements Carnivoro{

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
