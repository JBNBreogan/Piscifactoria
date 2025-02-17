package dtos;

import java.util.ArrayList;
import java.util.List;

import granjas.GranjaLangostinos;
import granjas.TanqueLangostinos;

public class DTOGranjaLangostinos extends DTOEdificios {

        private List<DTOTanqueLangostinos> tanques;

        private int muertos;

    public DTOGranjaLangostinos(GranjaLangostinos granjaLangostinos) {
        super(granjaLangostinos != null);

        if(granjaLangostinos != null){
            this.tanques = new ArrayList<>();
            this.muertos = granjaLangostinos.getMuertos();
            List<TanqueLangostinos> aux = granjaLangostinos.getTanques();
            for (TanqueLangostinos tanqueLangostinos : aux) {
                tanques.add(new DTOTanqueLangostinos(tanqueLangostinos));
            }
        } else {
            this.muertos = 0;
            
        }
    }

    public List<DTOTanqueLangostinos> getTanques() {
        return tanques;
    }

    public void setTanques(ArrayList<DTOTanqueLangostinos> tanques) {
        this.tanques = tanques;
    }

    public void setTanques(List<DTOTanqueLangostinos> tanques) {
        this.tanques = tanques;
    }

    public int getMuertos() {
        return muertos;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }
    
}
