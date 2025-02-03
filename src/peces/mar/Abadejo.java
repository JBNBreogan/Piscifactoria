package peces.mar;

import java.util.Random;

import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;
import saves.DTOPez;

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

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public Abadejo(DTOPez pes){
        super(pes, AlmacenPropiedades.ABADEJO);
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
