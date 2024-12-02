package peces.rio;

import java.util.Random;

import peces.Pez;
import peces.propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Carpa comun
 * @author Breogan
 */
public class Carpa extends Omnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Carpa(boolean hembra){
        super(AlmacenPropiedades.CARPA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Carpa(hembra);
    }

    @Override
    public int comer(int cantidad) {
        Random comer = new Random();
        if (comer.nextInt(4) != 0){
            if (cantidad >= 2){
                this.Comido = true;
                return 2;
            }
        }
        return 0;
    }
}
