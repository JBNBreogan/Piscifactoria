package dtos;

/**
 * Clase que guarda la información de edificios.
 * 
 * @author Nicolás
 */
public class DTOEdificios {
    /** Disponibilidad del almacen */
    private boolean disponible;

    /**
     * Construcor
     * 
     * @param disponible indica si está disponible o no un edificio.
     */
    public DTOEdificios(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Indica si está disponible o no
     * 
     * @return true si está disponible, false en caso contrario
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece si está disponible o no un edificio.
     * 
     * @param disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
