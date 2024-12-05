package saves;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveLoad {
    
     public static void save(DTOPiscifactoria pisci, File archivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(pisci, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
