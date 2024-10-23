package peces.Rio;

import peces.Pez;
import peces.Propiedades.Filtrador;
import propiedades.AlmacenPropiedades;

/**
 * Clase que representa a una Carpa Plateada
 * @author Breogan
 */
public class CarpaPlateada extends Filtrador{

    public CarpaPlateada(boolean hembra){
        super(AlmacenPropiedades.CARPA_PLATEADA);
        this.Sexo = hembra;
    }

    @Override
    public Pez reproducirse(boolean hembra) {
        return new CarpaPlateada(hembra);
    }
}
