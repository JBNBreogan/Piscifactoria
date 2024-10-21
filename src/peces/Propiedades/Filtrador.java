package peces.Propiedades;

import java.util.Random;

import peces.Pez;
import propiedades.PecesDatos;

/**
 * Clase para peces filtradores
 * @author Breogan
 */
public abstract class Filtrador extends Pez{
    
    public Filtrador(PecesDatos data){
        super(data);
    }

    @Override
    public void comer(int cantidad) {
        Random comer = new Random();
        if (comer.nextInt(2) != 0){
            this.Comido = true;
        } else if (cantidad >= 1){
            this.Comido = true;
        }
    }
}
