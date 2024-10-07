package peces.Rio;

import peces.Pez;
import peces.Propiedades.Comedido;
import peces.Propiedades.Omnivoro;
import propiedades.AlmacenPropiedades;

public class CarpinDeTresEspinas extends Pez implements Omnivoro,Comedido{

    public CarpinDeTresEspinas(boolean hembra){
        super(AlmacenPropiedades.CARPIN_TRES_ESPINAS);
        this.Sexo = hembra;
    }
    //TODO Grow

    @Override
    public Pez reproducirse(boolean hembra) {
        return new CarpinDeTresEspinas(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
}
