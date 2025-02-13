package granjas;

public class GranjaFitoplancton {

    private static final int CICLO_DIAS = 5; // Duración del ciclo (al sexto día se produce)
    private static final int PRODUCCION_POR_TANQUE = 500; // Unidades de alimento producidas por tanque

    private boolean disponible;
    private int tanques;
    private int ciclo;

    // Constructor: la granja no está disponible hasta que se compre.
    public GranjaFitoplancton() {
        this.disponible = false;
        this.tanques = 0;
        this.ciclo = 0;
    }

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

    // Método para avanzar un día en el ciclo de reproducción.
    // Si se completa el ciclo (día 6), se produce alimento y se reinicia el ciclo.
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

    // Método para mejorar la granja: añade un nuevo tanque y reinicia el ciclo.
    public void mejorar() {
        if (!disponible) {
            System.out.println("La granja no está disponible. Primero cómprala.");
            return;
        }
        tanques++;
        ciclo = 1; // Reiniciar ciclo tras la mejora.
        System.out.println("Granja mejorada: ahora dispone de " + tanques + " tanques. El ciclo se ha reiniciado.");
    }

    // Métodos getters para acceder a los atributos si es necesario.
    public boolean isDisponible() {
        return disponible;
    }

    public int getTanques() {
        return tanques;
    }

    public int getCiclo() {
        return ciclo;
    }

    // Método toString para representar el estado actual de la granja.
    @Override
    public String toString() {
        return "GranjaFitoplancton{" +
                "disponible=" + disponible +
                ", tanques=" + tanques +
                ", ciclo=" + ciclo +
                '}';
    }
}
