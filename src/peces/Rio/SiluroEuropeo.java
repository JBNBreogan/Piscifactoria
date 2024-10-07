package peces.Rio;

import peces.Pez;
import peces.Propiedades.Carnivoro;
import peces.Propiedades.Longevo;
import peces.Propiedades.Voraz;
import propiedades.AlmacenPropiedades;

public class SiluroEuropeo extends Pez implements Carnivoro,Longevo,Voraz{

    public SiluroEuropeo(boolean hembra){
        super(AlmacenPropiedades.SILURO_EUROPEO);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new SiluroEuropeo(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comer'");
    }
}
