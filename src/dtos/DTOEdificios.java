package dtos;

public class DTOEdificios {
    /** Disponibilidad del almacen */
    private boolean disponible;

    public DTOEdificios(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


}
