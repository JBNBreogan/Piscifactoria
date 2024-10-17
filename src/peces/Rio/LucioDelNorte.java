package peces.Rio;

import peces.Pez;
import peces.Propiedades.Activo;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Lucio del Norte
 * @author Breogan
 */
public class LucioDelNorte extends Pez implements Carnivoro,Activo{

    public LucioDelNorte(boolean hembra){
        super(AlmacenPropiedades.LUCIO_NORTE);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new LucioDelNorte(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
