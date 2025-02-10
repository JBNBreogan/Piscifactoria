package peces.doble;

import dtos.DTOPez;
import peces.Pez;
import peces.propiedades.Carnivoro;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a la Trucha Arcoíris
 * @author Breogan
 */
public class TruchaArcoiris extends Carnivoro{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public TruchaArcoiris(boolean hembra){
        super(AlmacenPropiedades.TRUCHA_ARCOIRIS);
        this.Sexo = hembra;
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public TruchaArcoiris(DTOPez pes){
        super(pes, AlmacenPropiedades.TRUCHA_ARCOIRIS);
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new TruchaArcoiris(hembra);
    }
}
