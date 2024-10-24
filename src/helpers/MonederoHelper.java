package helpers;

import Comun.Monedero;

public class MonederoHelper {

    /**
     * Verifica si hay monedas suficientes en el monedero
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
     * Calcula el descunto aplicable para la compra de comida
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
