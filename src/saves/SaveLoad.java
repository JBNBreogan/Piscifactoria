package saves;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import helpers.ErrorHelper;

public class SaveLoad {
    
    public void save(DTOSimulador sim, File archivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(sim, writer);
        } catch (IOException e) {
            ErrorHelper.writeError("Error generando el archivo de guardado");
            e.printStackTrace();
        }
    }
    
}
