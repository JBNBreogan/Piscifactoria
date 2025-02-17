package dtos;

import granjas.GranjaFitoplancton;

public class DTOGranjaFitoplancton extends DTOEdificios {
    int tanques;
    int ciclo;
    
    public DTOGranjaFitoplancton(GranjaFitoplancton granjaFitoplancton) {
        super(granjaFitoplancton != null);
        if(granjaFitoplancton==null){
            tanques = 0;
            ciclo = 0;
        } else {
            tanques = granjaFitoplancton.getTanques();
            ciclo = granjaFitoplancton.getCiclo();
        }
    }

    public int getTanques() {
        return tanques;
    }

    public void setTanques(int tanques) {
        this.tanques = tanques;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
    
    
}
