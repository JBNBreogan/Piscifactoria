package saves;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import helpers.ErrorHelper;
import registros.Registros;

public class SaveLoad {
    static File saveDir = new File("saves");
        
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

    public void cargar(){
        //TODO
    }


    
}
