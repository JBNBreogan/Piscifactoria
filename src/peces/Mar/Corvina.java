package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import peces.Propiedades.Voraz;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Corvina
 * @author Breogan
 */
public class Corvina extends Pez implements Carnivoro,Voraz{

    public Corvina(boolean hembra){
        super(AlmacenPropiedades.CORVINA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Corvina(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO Grow
}
