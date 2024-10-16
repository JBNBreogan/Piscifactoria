package helpers;

public class PorcentajeHelper {
    /**
     * Hace el calculo del porcentaje de dos numeros dados
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
