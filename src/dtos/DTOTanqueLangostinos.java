package dtos;

import granjas.TanqueLangostinos;

public class DTOTanqueLangostinos {
    int comida;
    int descanso;
    
    public DTOTanqueLangostinos(TanqueLangostinos tanqueLangostinos) {
        this.comida = tanqueLangostinos.getComidaAlmacenada();
        this.descanso = tanqueLangostinos.getDiasDescanso();
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public int getDescanso() {
        return descanso;
    }

    public void setDescanso(int descanso) {
        this.descanso = descanso;
    }

    
}
