package peces.mar;

import java.util.Random;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Abadejo
 * @author Breogan
 */
public class Abadejo extends Carnivoro{
    
    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Abadejo(boolean hembra){
        super(AlmacenPropiedades.ABADEJO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Abadejo(hembra);
    }
    
    @Override
    public int comer(int cantidad) {
        Random rnd = new Random();
        if(rnd.nextInt(4) <= 2  && cantidad>=2){
            this.Comido = true;
            return 2;
        } else if (cantidad >= 1){
            this.Comido = true;
            return 1;
        }
        return 0;
    }
}
