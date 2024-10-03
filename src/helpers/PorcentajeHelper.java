package helpers;

public class PorcentajeHelper {
    
    public static double hacerProcentaje(double numero, double max){

        double porcentaje;

        porcentaje=(numero/max)*100;

        return porcentaje;
    }
}
