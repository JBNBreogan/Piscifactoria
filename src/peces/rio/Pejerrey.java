package peces.rio;

import dtos.DTOPez;
import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa al Pejerrey
 * @author Breogan
 */
public class Pejerrey extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public Pejerrey(boolean hembra){
        super(AlmacenPropiedades.PEJERREY);
        this.Sexo = hembra;
    }

    public Pejerrey(DTOPez pes){
        super(pes, AlmacenPropiedades.PEJERREY);
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new Pejerrey(hembra);
    }
}
