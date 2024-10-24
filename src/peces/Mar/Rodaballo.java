package peces.Mar;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Rodaballo
 * @author Breogan
 */
public class Rodaballo extends Carnivoro{

    public Rodaballo(boolean hembra){
        super(AlmacenPropiedades.RODABALLO);
        this.Sexo = hembra;
    }
    
    @Override
    public Pez reproducirse(boolean hembra) {
        return new Rodaballo(hembra);
    }

    @Override
    public int comer(int cantidad) {
        if (cantidad >= 2){
            this.Comido = true;
            return 2;
        }
        return 0;
    }
}
