package saves;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import peces.Pez;
import tanque.Tanque;

/**
 * Clase que guarda la información a guardar de los tanques
 * @author Breogan
 */
public class DTOTanque {
    /**Nombre del pez que hay en el tanque*/
    private String pez;

    /**Numero de peces en el tanque */
    private int num;

    /**Datos de los peces del tanque */
    private Map<String, Integer> datos;

    /**Lista de peces en el tanque */
    private List<DTOPez> peces;

    /**
     * Constructor
     * @param tanque Tanque del que coger la información
     */
    public DTOTanque(Tanque tanque) {
        if (!tanque.getPeces().isEmpty()){
            this.pez = tanque.getPeces().get(0).getName();
        } else {
            this.pez = "Vacío";
        }

        this.num = tanque.pecesEnTanque();
        
        this.datos = new HashMap<>();
        this.datos.put("vivos", tanque.pecesVivos());
        this.datos.put("maduros", tanque.pecesAdultos());
        this.datos.put("fertiles", tanque.pecesFertiles());

        this.peces = new ArrayList<DTOPez>();
        for (Pez pescao : tanque.getPeces()) {
            this.peces.add(new DTOPez(pescao));
        }

    }

    /**
     * Getter del nombre del pez
     * @return Nombre del pez
     */
    public String getPez() {
        return pez;
    }

    /**
     * Getter del numero de peces disponibles
     * @return
     */
    public int getNum() {
        return num;
    }

    /**
     * Getter de los datos
     * @return Datos de los peces
     */
    public Map<String, Integer> getDatos() {
        return datos;
    }

    /**
     * Getter de la lista de peces
     * @return Peces
     */
    public List<DTOPez> getPeces() {
        return peces;
    }
}
