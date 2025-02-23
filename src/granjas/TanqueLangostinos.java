package granjas;

import dtos.DTOTanqueLangostinos;

/**
 * La clase TanqueLangostinos representa un tanque de cría de langostinos.
 * Maneja el almacenamiento de comida, los días de descanso y la producción de alimento.
 * @author Nicolás
 */
public class TanqueLangostinos {
    
    /**
     * Cantidad de comida almacenada en el tanque. 
     * El valor máximo permitido es de 150 unidades.
     */
    private int comidaAlmacenada;

    /**
     * Número de días de descanso antes de que el tanque vuelva a producir.
     * Su valor puede oscilar entre 0 y 3 días.
     */
    private int diasDescanso;

    /**
     * Número de días consecutivos en los que los langostinos no han recibido comida.
     */
    private int diasSinComer;

    /**
     * Constructor de la clase.
     * Inicializa el tanque sin comida almacenada, sin días de descanso y sin días sin comer.
     */
    public TanqueLangostinos() {
        this.comidaAlmacenada = 0;
        this.diasDescanso = 0;
        this.diasSinComer = 0;
    }

    /**
     * Añade una cantidad específica de comida al tanque.
     * La cantidad total de comida almacenada no puede exceder las 150 unidades.
     * Si se añade comida, se reinician los días sin comer.
     *
     * @param cantidadComida La cantidad de comida a añadir.
     */
    public void addComidaTanque(int cantidadComida) {
        this.comidaAlmacenada = Math.min(this.comidaAlmacenada + cantidadComida, 150);
        this.diasSinComer = 0; // Reinicia los días sin comer al recibir comida
    }

    /**
     * Consume 50 unidades de comida del tanque si hay suficiente disponible.
     * Si no hay suficiente comida, incrementa el contador de días sin comer.
     * Si el tanque pasa más de 3 días sin comida, se establece un periodo de descanso.
     *
     * @return {@code true} si el tanque pudo ser alimentado, {@code false} en caso contrario.
     */
    public boolean consumirComida() {
        if (this.comidaAlmacenada >= 50) {
            this.comidaAlmacenada -= 50;
            this.diasSinComer = 0;
            return true;
        } else {
            this.diasSinComer++;
            this.diasDescanso = Math.min(this.diasSinComer, 3); // Corregido aquí
            return false;
        }
    }
    
    /**
     * Calcula la producción de alimento del tanque.
     * La producción solo ocurre si el tanque no está en periodo de descanso y ha sido alimentado recientemente.
     * Si el tanque está en descanso, disminuye el contador de días de descanso y no produce alimento.
     *
     * @return La cantidad de alimento producido (entre 100 y 200 unidades) o 0 si no se produce.
     */
    public int producir() {
        if (this.diasDescanso > 0) {
            this.diasDescanso--; // Reducir días de descanso
            return 0; // No se produce alimento en días de descanso
        }
    
        // Consumir 50 unidades de comida para producir
        if (this.consumirComida()) {
            // Generar producción aleatoria entre 100 y 200 unidades
            return (int) (Math.random() * 101) + 100;
        } else {
            return 0; // No se produce alimento si no hay suficiente comida
        }
    }
    

    /**
     * Obtiene la cantidad de comida almacenada en el tanque.
     *
     * @return La cantidad de comida almacenada.
     */
    public int getComidaAlmacenada() {
        return comidaAlmacenada;
    }

    /**
     * Obtiene la cantidad de días de descanso restantes antes de poder producir alimento.
     *
     * @return El número de días de descanso.
     */
    public int getDiasDescanso() {
        return diasDescanso;
    }

    /**
     * Obtiene la cantidad de días consecutivos en los que los langostinos no han sido alimentados.
     *
     * @return El número de días sin comer.
     */
    public int getDiasSinComer() {
        return diasSinComer;
    }

    /**
     * Carga los datos del tanque desde un objeto {@code DTOTanqueLangostinos}.
     * Se actualiza la cantidad de comida almacenada y los días de descanso.
     *
     * @param tla Objeto DTO que contiene los datos del tanque a cargar.
     */
    public void load(DTOTanqueLangostinos tla) {
        this.comidaAlmacenada = tla.getComida();
        this.diasDescanso = tla.getDescanso();
    }

    /**
     * Establece la comida almacenada del tanque
     * @param comidaAlmacenada cantidad de comida
     */
    public void setComidaAlmacenada(int comidaAlmacenada) {
        this.comidaAlmacenada = comidaAlmacenada;
    }

     /**
     * Establece los días de descanso.
     * @param diasDescanso los días de descanso
     */
    public void setDiasDescanso(int diasDescanso) {
        this.diasDescanso = diasDescanso;
    }
    /**
     * Establece los días sin comer
     * @param diasDescanso los días sin comer.
     */
    public void setDiasSinComer(int diasSinComer) {
        this.diasSinComer = diasSinComer;
    }
}
