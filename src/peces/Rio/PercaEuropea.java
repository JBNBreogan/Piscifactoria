package peces.Rio;

import peces.Pez;
import peces.Propiedades.Activo;
import peces.Propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Perca Europea
 * @author Breogan
 */
public class PercaEuropea extends Pez implements Carnivoro,Activo{

    public PercaEuropea(boolean hembra){
        super(AlmacenPropiedades.PERCA_EUROPEA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new PercaEuropea(hembra);
    }
    //TODO Todo el pez

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comer'");
    }
}
