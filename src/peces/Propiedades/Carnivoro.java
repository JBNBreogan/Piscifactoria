package peces.Propiedades;

import peces.Pez;
import propiedades.PecesDatos;

/**
 * clase para peces carnívoros
 * @author Breogan
 */
public abstract class Carnivoro extends Pez{

    protected Carnivoro(PecesDatos data) {
        super(data);
    }

    @Override
    public int comer(int cantidad) {
        if (cantidad >= 1){
            this.Comido = true;
            return 1;
        }
        return 0;
    }
    
}
