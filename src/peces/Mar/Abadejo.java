package peces.Mar;

import java.util.Random;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Abadejo
 * @author Breogan
 */
public class Abadejo extends Carnivoro{
    
    public Abadejo(boolean hembra){
        super(AlmacenPropiedades.ABADEJO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Abadejo(hembra);
    }
    
    @Override
    public void comer(int cantidad) {
        Random rnd = new Random();
        if(rnd.nextInt(4) <= 2){
            this.Comido = true;
        } else if (cantidad >= 1){
            this.Comido = true;
        }
        
    }
}
