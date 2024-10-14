package peces.Mar;

import peces.Pez;
import peces.Propiedades.Filtrador;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Arenque del Atlantico
 * @author Breogan
 */
public class ArenqueDelAtlantico extends Pez implements Filtrador{

    public ArenqueDelAtlantico(boolean hembra){
        super(AlmacenPropiedades.ARENQUE_ATLANTICO);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new ArenqueDelAtlantico(hembra);
    }

    @Override
    public void comer(int cantidad) {
        // TODO Auto-generated method stub
        
    }
    //TODO Grow
}
