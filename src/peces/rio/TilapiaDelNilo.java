package peces.rio;

import peces.Pez;
import peces.propiedades.Filtrador;
import propiedades.AlmacenPropiedades;
import saves.DTOPez;

/**
 * Clase que representa a la Tilapia del Nilo
 * @author Breogan
 */
public class TilapiaDelNilo extends Filtrador{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public TilapiaDelNilo(boolean hembra){
        super(AlmacenPropiedades.TILAPIA_NILO);
        this.Sexo = hembra;
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public TilapiaDelNilo(DTOPez pes){
        super(pes, AlmacenPropiedades.TILAPIA_NILO);
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new TilapiaDelNilo(hembra);
    }
}
