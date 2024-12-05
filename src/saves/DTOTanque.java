package saves;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import peces.Pez;
import tanque.Tanque;

public class DTOTanque {
    private String pez;
    private int num;
    private Map<String, Integer> datos;
    private List<DTOPez> peces;

    public DTOTanque(Tanque tanque) {
        //this.pez = tanque.getTipoPez().getNombre();
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

    public String getPez() {
        return pez;
    }

    public int getNum() {
        return num;
    }

    public Map<String, Integer> getDatos() {
        return datos;
    }

    public List<DTOPez> getPeces() {
        return peces;
    }
}
