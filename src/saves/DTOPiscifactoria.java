package saves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import piscifactoria.Piscifactoria;
import propiedades.CriaTipo;
import tanque.Tanque;

/**
 * Clase que guarda la información de la piscifactoría
 * @author Breogan
 */
public class DTOPiscifactoria {

    /** Nombre de la piscifactoría */
    private String nombre;

    /** Tipo de piscifactoría (Mar, Rio) */
    private int tipo;

    /** Capacidad de los peces de la piscifactoría */
    private int capacidad;

    /** Cantidades de comida en clave-valor */
    private Map<String, Integer> comida;

    /** Lista de tanques de la piscifactoría */
    private List<DTOTanque> tanques;

    /**
     * Constructor
     * @param pisci Piscifactoría de donde conseguir los datos
     */
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

    /**
     * Getter de capacidad de los peces
     * @return Capacidad de peces de la piscifactoría
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Getter de la comida de la piscifactoría
     * @return
     */
    public Map<String, Integer> getComida() {
        return comida;
    }

    /**
     * Getter del nombre de la piscifactoría
     * @return Nombre de la piscifactoría
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de los tanques de la piscifactoría
     * @return Lista de tanques
     */
    public List<DTOTanque> getTanques() {
        return tanques;
    }

    /**
     * Getter del tipo de piscifactoría
     * @return Tipo de piscifactoria en formato numérico
     */
    public int getTipo() {
        return tipo;
    }
}
