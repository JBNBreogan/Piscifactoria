package helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
     * @return El entero
     * @throws IOException
     */
    public static int GetIntWithBuffRead() throws IOException{
        int optionInt = 0;
        
        String optionStr = br.readLine();
        try {
            optionInt = Integer.parseInt(optionStr);
        } catch (Exception e) {
            System.out.println("Debe escoger un numero");
            return -1;
        }
        
        return optionInt;
    }

    /**
     * Devuelve un numero de coma flotante despues de comprobar
     * que lo pasado por pantalla es correcto
     * @return El número de coma flotante
     * @throws IOException
     */
    public static Float GetFloatWithBuffRead() throws IOException{

        Float optionFloat = 0f;
        
        String optionStr = br.readLine();
        try {
            optionFloat = Float.parseFloat(optionStr);
        } catch (Exception e) {
            System.out.println("Debe escoger un numero");
            return -1f;
        }
        
        return optionFloat;
    }

    /**
     * Devuelve un String pasado por teclado
     * @return El String
     * @throws IOException
     */
    public static String ReadStringWithBuffRead() throws IOException{
        return br.readLine();
    }

    /**
     * Cierra el flujo de BufferedReader
     * @throws IOException
     */
    public static void CloseBuffReader() throws IOException{
        br.close();
    }
}

