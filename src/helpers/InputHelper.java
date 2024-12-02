package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase auxiliar para ayudar en la entrada de datos.
 * @author Breogán Fernández Tacón
 */
public class InputHelper {

    /** BufferedReader para leer datos pasados por pantalla **/
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Devuelve un entero despues de comprobar que lo pasado por pantalla
     * es correcto.
     * @param maxRange Rango maximo
     * @param minRange Rango minimo
     * @param extra Opciones extra
     * @return Número requerido
     */
    public static int getIntRanges(int maxRange, int minRange, int[] extra){
        int optionInt = 0;
        Boolean right = false;
        List<Integer> lista = Arrays.stream(extra)
                                    .boxed()
                                    .collect(Collectors.toList());
        do {
            try {
                String optionStr = br.readLine();
                optionInt = Integer.parseInt(optionStr);

                if ((optionInt <= maxRange && optionInt >=minRange) || lista.contains(optionInt)){
                    right = true;
                    return optionInt;
                } else {
                    System.out.println("Introduzca un número válido");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un valor entero");                
            } catch (IOException e) {
                System.out.println("Introduzca un valor numérico");
            }
        } while (!right);

        return 0;
    }

    /**
     * Devuelve un entero despues de comprobar que lo pasado por pantalla
     * es correcto.
     * @param maxRange Rango máximo
     * @return Número requerido
     */
    public static int getIntRanges(int maxRange){
        return InputHelper.getIntRanges(maxRange, 0, new int[0]);
    }

    /**
     * Devuelve un entero despues de comprobar que lo pasado por pantalla
     * es correcto.
     * @param maxRange Rango maximo
     * @param minRange Rango minimo
     * @return Número requerido
     */
    public static int getIntRanges(int maxRange, int minRange){
        return InputHelper.getIntRanges(maxRange, minRange, new int[0]);
    }

    /**
     * Devuelve un entero despues de comprobar que lo pasado por pantalla
     * es correcto.
     * @param maxRange Rango maximo
     * @param extra Opciones extra
     * @return Número requerido
     */
    public static int getIntRanges(int maxRange, int[] extra){
        return InputHelper.getIntRanges(maxRange, 0, extra);
    }


    /**
     * Devuelve un String pasado por teclado
     * @return El String
     * @throws IOException
     */
    public static String readStringWithBuffRead(){
        try {
            return br.readLine();
        } catch (IOException e) {}
        return "";
    }

    /**
     * Cierra el flujo de BufferedReader
     * @throws IOException
     */
    public static void closeBuffReader(){
        try {
            br.close();
        } catch (IOException e) {}
    }
}

