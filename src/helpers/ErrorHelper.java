package helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase auxiliar para controlar los errores e introducirlos en un fichero log
 * @author Breogan
 */
public class ErrorHelper {
    
    private static File errorFile = new File("logs/0_errors.log"); 

    /**
     * Crea el fichero log de errores
     */
    public static void createErrorFile(){
        try {
            if (errorFile.getParentFile().mkdir());
            if (errorFile.createNewFile());
        } catch (IOException e) {
            System.out.println("errorcin");
        }
    }

    /**
     * Escribe el error en el log de errores con fecha y hora preformateada
     * @param error Error a escribir en el fichero
     */
    public static void writeError(String error){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = "[" + now.format(format) + "]";

        try (BufferedWriter wr = new BufferedWriter(new FileWriter(errorFile,true))) {
            wr.append(formattedTime + " " + error);
            wr.flush();
        } catch (IOException e){
            writeError("Error escribiendo en el log de errores\n");
        }
    }
}
