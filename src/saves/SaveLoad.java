package saves;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import helpers.ErrorHelper;
import registros.Registros;

/**
 * Clase que gestiona la lógica de guardar partida en un JSON
 * @author Breogan
 */
public class SaveLoad {

    /**Directorio de guardados */
    static File saveDir = new File("saves");
        
    /**
     * Guarda la partida, dejando constancia de ello en el registro
     * @param sim Datos del simulador
     * @param archivo Archivo de guardado
     * @param reg Objeto de registros
     */
    public void save(DTOSimulador sim, File archivo, Registros reg) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(sim, writer);
            reg.registrarGuardado();
        } catch (IOException e) {
            ErrorHelper.writeError("Error generando el archivo de guardado");
            e.printStackTrace();
        }
    }
    
    /**
     * Crea la carpeta de guardado previa comprobación de su existencia.
     */
    public static void saveDirCreate(){
        if (!saveDir.exists()){
            saveDir.mkdir();
    }
    }

    /**
     * Carga la partida a partir de un fichero JSON
     * @param json El fichero
     */
    public void cargar(File json){
        //TODO
    }


    
}
