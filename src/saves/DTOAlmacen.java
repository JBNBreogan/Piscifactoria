package saves;

import java.util.HashMap;
import java.util.Map;

import comun.AlmacenCentral;

public class DTOAlmacen {
    private boolean disponible;
    private int capacidad;
    private Map<String, Integer> comida;

    public DTOAlmacen(AlmacenCentral alm){
        this.comida = new HashMap<>();
        if (alm == null){
            disponible = false;
            capacidad = 200;
            comida.put("vegetal", 0);
            comida.put("animal", 0);
        } else {
            disponible = true;
            capacidad = alm.getCapacidadComidaAnimal();
            comida.put("vegetal", alm.getComidaVegetal());
            comida.put("animal", alm.getComidaAnimal());
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Map<String, Integer> getComida() {
        return comida;
    }
    
}