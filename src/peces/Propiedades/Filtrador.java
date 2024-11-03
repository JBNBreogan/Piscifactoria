package peces.Propiedades;

import java.util.Random;

import peces.Pez;
import propiedades.PecesDatos;

/**
 * Clase para peces filtradores
 * @author Breogan
 */
public abstract class Filtrador extends Pez{
    
    /**
     * Cosntructor paraetrizado
     * @param data datos del pez
     */
    public Filtrador(PecesDatos data){
        super(data);
    }

    @Override
    public int comer(int cantidad) {
        Random comer = new Random();
        if (comer.nextInt(2) != 0){
            this.Comido = true;
            return 0;
        } else if (cantidad >= 1){
            this.Comido = true;
            return 1;
        }
        return 0;
    }
}
