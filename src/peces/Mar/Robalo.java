package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Róbalo
 * @author Breogan
 */
public class Robalo extends Pez implements Carnivoro{

    public Robalo(boolean hembra){
        super(AlmacenPropiedades.ROBALO);
        this.Sexo = hembra;
    }
    
    @Override
    public Pez reproducirse(boolean hembra) {
        return new Robalo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
