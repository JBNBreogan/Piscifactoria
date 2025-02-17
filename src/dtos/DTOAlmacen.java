package dtos;

import java.util.HashMap;
import java.util.Map;

import comun.AlmacenCentral;

/**
 * Clase que guarda la información del almacen central
 * @author Breogan
 */
public class DTOAlmacen extends DTOEdificios{

  

    /** Capacidad de comida del almacen */
    private int capacidad;

    /** Cantidad de comida actual del almacen */
    private Map<String, Integer> comida;

    /**
     * Constructor
     * @param alm Almacen de donde sacar información
     */
    public DTOAlmacen(AlmacenCentral alm){
        super(alm != null);
        this.comida = new HashMap<>();
        if (alm == null){
            capacidad = 0;
            comida.put("vegetal", 0);
            comida.put("animal", 0);
        } else {
            capacidad = alm.getCapacidadComidaAnimal();
            comida.put("vegetal", alm.getComidaVegetal());
            comida.put("animal", alm.getComidaAnimal());
        }
    }

    /**
     * Getter de capacidad del almacen
     * @return la capacidad de la comida del almacen
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Getter de la cantidad de comida actual del almacen
     * @return la comida del almacen en clave-valor
     */
    public Map<String, Integer> getComida() {
        return comida;
    }

  
    
}