package peces.Double;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Lubina Europea
 * @author Breogan
 */
public class LubinaEuropea extends Pez implements Carnivoro{

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
