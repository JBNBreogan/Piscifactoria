package saves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import piscifactoria.Piscifactoria;
import propiedades.CriaTipo;
import tanque.Tanque;

public class DTOPiscifactoria {
    private String nombre;
    private int tipo;
    private int capacidad;
    private Map<String, Integer> comida;
    private List<DTOTanque> tanques;

    public DTOPiscifactoria(Piscifactoria pisci){
        this.nombre = pisci.getNombre();
        
        if (pisci.getTipo() == CriaTipo.RIO){
            this.tipo = 0;
        } else {
            this.tipo = 1;
        }

        this.capacidad = pisci.pecesMaxPiscifactoria();

        this.comida = new HashMap<>();
        this.comida.put("vegetal", pisci.getComidaVegetal());
        this.comida.put("animal", pisci.getComidaAnimal());

        this.tanques = new ArrayList<DTOTanque>();
        for (Tanque tnk : pisci.getTanques()) {
            tanques.add(new DTOTanque(tnk));
        }
    }

    public int getCapacidad() {
        return capacidad;
    }
    public Map<String, Integer> getComida() {
        return comida;
    }
    public String getNombre() {
        return nombre;
    }
    public List<DTOTanque> getTanques() {
        return tanques;
    }
    public int getTipo() {
        return tipo;
    }
}
