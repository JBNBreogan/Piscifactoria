package granjas;
import java.util.ArrayList;
import java.util.List;

import dtos.DTOGranjaLangostinos;
import dtos.DTOTanqueLangostinos;

/**
 * La clase GranjaLangostinos representa una granja acuícola para la producción de langostinos.
 * Permite la gestión de tanques, alimentación de los langostinos y producción de alimento a partir de ellos.
 */
public class GranjaLangostinos {
    /**
     * Indica si la granja está comprada o no.
     */
    private boolean disponible; 
    /**
     * Indica el número de peces muertos almacenados.
     */
    private int muertos; 
    /**
     * Lista de los tanques de la granja.
     */
    private List<TanqueLangostinos> tanques; // Lista de tanques de la granja

    /**
     * Constructor de la GranjaLangostinos. Inicialmente, la granja no está disponible
     * y no tiene tanques ni langostinos muertos almacenados.
     */
    public GranjaLangostinos() {
        this.disponible = false;
        this.muertos = 0;
        this.tanques = new ArrayList<>();
    }

    /**
     * Método para comprar la granja. Una vez comprada, se inicializa con un tanque.
     */
    public void comprar() {
        this.disponible = true;
        tanques.add(new TanqueLangostinos());
        System.out.println("Comprada la granja de langostinos.");
    }

    /**
     * Método para mejorar la granja añadiendo un nuevo tanque.
     * Si la granja no ha sido comprada, no se puede mejorar.
     */
    public void mejorar() {
        if (!this.disponible) {
            System.out.println("La granja de langostinos no está disponible.");
            return;
        }
        TanqueLangostinos nuevoTanque = new TanqueLangostinos();
        this.tanques.add(nuevoTanque);
        System.out.println("Mejorada la granja de langostinos añadiendo un tanque. Total de tanques: " + this.tanques.size());
    }

    /**
     * Método para alimentar los tanques de langostinos con la cantidad de comida disponible.
     * Se distribuye la comida en lotes de 50 unidades por tanque, sin exceder el límite de almacenamiento de cada tanque.
     * 
     * @param comidaDisponible La cantidad total de comida disponible para distribuir.
     */
    public void alimentarTanques(int comidaDisponible) {
        if (!this.disponible) {
            System.out.println("La granja de langostinos no está disponible.");
            return;
        }

        int tanqueIndex = 0;
        while (comidaDisponible >= 50 && !tanques.isEmpty()) {
            TanqueLangostinos tanque = tanques.get(tanqueIndex % tanques.size());
            if (tanque.getComidaAlmacenada() < 150) { // Verificar que no exceda el límite
                tanque.addComidaTanque(50); // Añadir 50 unidades de comida
                comidaDisponible -= 50;
                System.out.println("Comida en tanque: "+tanque.getComidaAlmacenada());
            } else {
                System.out.println("Almacén del tanque de la granja de langostinos lleno.");
                break;
            }
            tanqueIndex++;
        }
    }

    /**
     * Método para producir alimento a partir de los tanques de langostinos.
     * 
     * @return La cantidad total de alimento producido en la granja.
     */
    public int producirAlimento() {
        int produccionTotal = 0;
        for (TanqueLangostinos tanque : this.tanques) {
            produccionTotal += tanque.producir();
        }
        return produccionTotal;
    }

    /**
     * Verifica si la granja está disponible (comprada y operativa).
     * 
     * @return true si la granja está disponible, false en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Obtiene el número de langostinos muertos almacenados en la granja.
     * 
     * @return El número de langostinos muertos.
     */
    public int getMuertos() {
        return muertos;
    }

    /**
     * Obtiene la lista de tanques de la granja.
     * 
     * @return Lista de tanques de langostinos.
     */
    public List<TanqueLangostinos> getTanques() {
        return tanques;
    }

    /**
     * Establece la disponibilidad de la granja.
     * 
     * @param disponible true si la granja está comprada y operativa, false en caso contrario.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Establece el número de langostinos muertos almacenados en la granja.
     * 
     * @param muertos La cantidad de langostinos muertos.
     */
    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    /**
     * Establece la lista de tanques en la granja.
     * 
     * @param tanques Lista de tanques de langostinos.
     */
    public void setTanques(List<TanqueLangostinos> tanques) {
        this.tanques = tanques;
    }

    /**
     * Carga los datos de la granja desde un objeto DTOGranjaLangostinos.
     * Se actualiza la cantidad de langostinos muertos y se reconstruyen los tanques desde sus DTOs.
     * 
     * @param granjal Objeto DTOGranjaLangostinos que contiene los datos de la granja a cargar.
     */
    public void load(DTOGranjaLangostinos granjal) {
        this.muertos = granjal.getMuertos();
        List<DTOTanqueLangostinos> aux = granjal.getTanques();
        for (DTOTanqueLangostinos dtoTanqueLangostinos : aux) {
            TanqueLangostinos tnkLa = new TanqueLangostinos();
            tnkLa.load(dtoTanqueLangostinos);
            this.tanques.add(tnkLa);
        }
    }
}
