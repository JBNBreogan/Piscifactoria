package helpers;

public class PorcentajeHelper {
    /**
     * Hace el cálculo del porcentaje de dos números pasados por parámetro.
     * @param numero
     * @param max
     * @return porcentaje calculado
     */
    
    public static double hacerProcentaje(double numero, double max){

        double porcentaje;

        porcentaje=(numero/max)*100;

        return porcentaje;
    }
}
