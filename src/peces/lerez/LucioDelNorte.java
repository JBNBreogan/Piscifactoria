package peces.Rio;

import java.util.Random;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Lucio del Norte
 * @author Breogan
 */
public class LucioDelNorte extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public LucioDelNorte(boolean hembra){
        super(AlmacenPropiedades.LUCIO_NORTE);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new LucioDelNorte(hembra);
    }

    @Override
    public int comer(int cantidad) {
        Random comer = new Random();
        if (comer.nextInt(2) != 0){
            if (cantidad >= 2){
                this.Comido = true;
                return 2;
            }
        } else {
            if (cantidad >= 1){
                this.Comido = true;
                return 1;
            }
        }
        return 0;
    }
}
