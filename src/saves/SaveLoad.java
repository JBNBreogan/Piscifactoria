package saves;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import helpers.ErrorHelper;
import registros.Registros;

/**
 * Clase que gestiona la lógica de guardar partida en un JSON
 * 
 * @author Breogan
 */
public class SaveLoad {

    /** Directorio de guardados */
    static File saveDir = new File("saves");

    public void save(DTOSimulador sim, File archivo, Registros reg) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(archivo, StandardCharsets.UTF_8)) {
            gson.toJson(sim, writer);
            try {
                reg.registrarGuardado();
            } catch (Exception e) {
                ErrorHelper.writeError("Error registrando el guardado: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println("Archivo guardado correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            ErrorHelper.writeError("Error generando el archivo de guardado en: " + archivo.getAbsolutePath());
            e.printStackTrace();
        }
    }

    /**
     * Crea la carpeta de guardado previa comprobación de su existencia.
     */
    public static void saveDirCreate() {
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
    }

    /**
     * Carga la partida a partir de un fichero JSON
     * 
     * @param json El fichero
     */
    public static DTOSimulador cargar(File json, Registros reg) {
        Gson gson = new Gson();

        if (json.exists() && json.isFile()) {
            try (FileReader reader = new FileReader(json, StandardCharsets.UTF_8)) {
                DTOSimulador sim = gson.fromJson(reader, DTOSimulador.class);
                if (sim != null) {
                    System.out.println("Carga exitosa.");
                    reg.registrarCarga();
                } else {
                    System.out.println("Error: El archivo JSON no contiene datos válidos.");
                }
                return sim;
            } catch (IOException e) {
                ErrorHelper.writeError("Error al cargar el archivo de guardado: " + json.getAbsolutePath());
                e.printStackTrace();
                return null;
            }
        } else {
            ErrorHelper.writeError("El archivo de guardado no existe: " + json.getAbsolutePath());
            return null;
        }
    }

}
