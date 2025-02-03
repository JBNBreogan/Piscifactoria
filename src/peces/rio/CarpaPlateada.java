package peces.rio;

import peces.Pez;
import peces.propiedades.Filtrador;
import propiedades.AlmacenPropiedades;
import saves.DTOPez;

/**
 * Clase que representa a una Carpa Plateada
 * @author Breogan
 */
public class CarpaPlateada extends Filtrador{

    /**
     * Constructor parametrizado
     * @param hembra Si es hembra
     */
    public CarpaPlateada(boolean hembra){
        super(AlmacenPropiedades.CARPA_PLATEADA);
        this.Sexo = hembra;
    }

    /**
     * Constructor de carga
     * @param pes DTO del pez
     */
    public CarpaPlateada(DTOPez pes){
        super(pes, AlmacenPropiedades.CARPA_PLATEADA);
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new CarpaPlateada(hembra);
    }
}
