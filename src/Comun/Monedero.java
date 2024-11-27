package comun;

//Patron singleton

/**
 * Clase singleton que representa el monedero del sistema. Se encarga de almacenar las monedas obtenidas gracias a ir avanzando en el uso del sistema. 
 */
public class Monedero {
    //**Instancia del objeto de monedero. */
    private static Monedero instance;
    //**Cantidad de monedas. */ 
    public int monedas;

    /**
     * Constructor vacío de la clase Monedero.
     */
    private Monedero() {
    }

    /**
     * Método que permite crear el objeto en caso de que no exista, y en caso de que exista solo devuelve la instancia.
     */
    public static Monedero getInstance() {
        if (instance == null) {
            instance = new Monedero();
        }
        return instance;
    }

    /**
     * Obtiene la cantidad de monedas.
     * @return Número de monedas
     */
    public int getMonedas() {
        return monedas;
    }

    /**
     * Permite cambiar la cantidad de monedas.
     * @param monedas Número de monedas que se va a establecer
     */
    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    /**
     * Verifica si hay monedas suficientes en el monedero.
     * @param cant
     * @return true o false dependiendo de si hay monedas suficientes o no
     */

     public static boolean monedasSuficientes(int cant){
        Monedero monedero=Monedero.getInstance();

        if(monedero.getMonedas()>cant){
            return true;
        }else{
            System.out.println("Monedas insuficientes");
            return false;
        }
    }

    /**
     * Calcula el descuento aplicable para la compra de comida.
     * @param precio
     * @return el precio despues de aplicarle el descuento
     */
    public static int calcularDescuento(int precio){
        int precioBase = precio;

        int descuentosAplicables = precio / 25; 
        int descuentoTotal = descuentosAplicables * 5; 

        int precioFinal = precioBase - descuentoTotal;

        return precioFinal;
    }

}
