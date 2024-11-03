package peces.Propiedades;

import java.util.Random;

import peces.Pez;
import propiedades.PecesDatos;

/**
 * Clase para peces omnivoros
 * @author Breogan
 */
public abstract class Omnivoro extends Pez{

    /**
     * Constructor parametrizado
     * @param data Datos del pez
     */
    protected Omnivoro(PecesDatos data) {
        super(data);
    }

    @Override
    public int comer(int cantidad) {
        Random comer = new Random();
        if (comer.nextInt(4) != 0){
            this.Comido = true;
            return 0;
        } else if (cantidad >= 1){
            this.Comido = true;
            return 1;
        }
        return 0;
    }
    
}
