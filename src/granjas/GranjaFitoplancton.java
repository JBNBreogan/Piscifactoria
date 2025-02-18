package granjas;

import dtos.DTOGranjaFitoplancton;

/**
 * La clase GranjaFitoplancton representa una granja que produce alimento vegetal (fitoplancton) en ciclos de producción.
 * Cada ciclo tiene una duración de 5 días, y al sexto día se produce una cantidad de alimento por cada tanque disponible.
 * La granja puede ser mejorada añadiendo tanques y reiniciando el ciclo de producción.
 */
public class GranjaFitoplancton {

    /**
     *  Duración del ciclo de producción en días
     */
    private static final int CICLO_DIAS = 5;
    
    /**  
     * Cantidad de unidades de alimento producidas por tanque
     */
    private static final int PRODUCCION_POR_TANQUE = 500;

    /**
     *  Indica si la granja está disponible (comprada)
     */
    private boolean disponible;
    
    /** 
    *  Número de tanques de producción
    */
    private int tanques;
    
    /**
    *  Día actual del ciclo de producción
    */
    private int ciclo;

    /**
     * Constructor de la granja de fitoplancton. Inicialmente no está disponible.
     * Al ser comprada, se comienza con un tanque y el ciclo en el día 1.
     */
    public GranjaFitoplancton() {
        this.disponible = false;
        this.tanques = 0;
        this.ciclo = 0;
    }

    /**
     * Método para comprar la granja. Una vez comprada, la granja comienza con un tanque
     * y se inicia el ciclo de producción en el día 1.
     * Si la granja ya ha sido comprada, se informa al usuario.
     */
    public void comprar() {
        if (!disponible) {
            disponible = true;
            tanques = 1;
            ciclo = 1;
            System.out.println("Granja de fitoplancton comprada. Se ha iniciado con 1 tanque y el ciclo en 1.");
        } else {
            System.out.println("La granja ya está comprada.");
        }
    }

    /**
     * Método para avanzar un día en el ciclo de producción.
     * Si se completa el ciclo (día 6), se produce alimento en función del número de tanques.
     * El ciclo se reinicia al día 1 después de la producción.
     * 
     * @return La cantidad de alimento producida en ese día. Si no es día de producción, retorna 0.
     */
    public int avanzarDia() {
        ciclo++;
        if (ciclo > CICLO_DIAS) {
            int produccion = tanques * PRODUCCION_POR_TANQUE;
            System.out.println("Producción realizada: " + produccion + " unidades de alimento vegetal producidas. Se ha añadido al almacen central.");
            ciclo = 1; // Reiniciar el ciclo para todos los tanques.
            return produccion;
        } else {
            System.out.println("Día " + ciclo + " del ciclo. No se produce alimento hoy.");
            return 0;
        }
    }

    /**
     * Método para mejorar la granja, agregando un nuevo tanque.
     * Cada vez que se añade un tanque, el ciclo de producción se reinicia al día 1.
     * Si la granja no está disponible (no ha sido comprada), no es posible mejorarla.
     */
    public void mejorar() {
        if (!disponible) {
            System.out.println("La granja no está disponible. Primero cómprala.");
            return;
        }
        tanques++;
        ciclo = 1; // Reiniciar ciclo tras la mejora.
        System.out.println("Granja mejorada: ahora dispone de " + tanques + " tanques. El ciclo se ha reiniciado.");
    }

    /**
     * Verifica si la granja está disponible (comprada).
     * 
     * @return true si la granja está comprada, false en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Obtiene el número de tanques en la granja.
     * 
     * @return El número de tanques en la granja.
     */
    public int getTanques() {
        return tanques;
    }

    /**
     * Obtiene el día actual del ciclo de producción.
     * 
     * @return El día actual del ciclo de producción.
     */
    public int getCiclo() {
        return ciclo;
    }


    /**
     * Carga los datos de la granja desde un objeto DTOGranjaFitoplancton.
     * 
     * @param gfp El objeto DTOGranjaFitoplancton que contiene los datos a cargar.
     */
    public void load(DTOGranjaFitoplancton gfp) {
        this.tanques = gfp.getTanques();
        this.ciclo = gfp.getCiclo();
    }
}
