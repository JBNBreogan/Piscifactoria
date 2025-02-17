package granjas;

import dtos.DTOTanqueLangostinos;

public class TanqueLangostinos {
    private int comidaAlmacenada; // Cantidad de comida almacenada (máximo 150 unidades)
    private int diasDescanso; // Días de descanso antes de volver a producir (0-3)
    private int diasSinComer; // Días consecutivos sin comer

    public TanqueLangostinos() {
        this.comidaAlmacenada = 0;
        this.diasDescanso = 0;
        this.diasSinComer = 0;
    }

    // Método para añadir comida al tanque
    public void addComidaTanque(int cantidadComida) {
        this.comidaAlmacenada = Math.min(this.comidaAlmacenada + cantidadComida, 150); // Límite de 150 unidades
        this.diasSinComer = 0; // Reinicia los días sin comer
    }

    // Método para consumir 50 unidades de comida
    public boolean consumirComida() {
        if (this.comidaAlmacenada >= 50) {
            this.comidaAlmacenada -= 50; // Consumir 50 unidades
            this.diasSinComer = 0; // Reiniciar días sin comer
            return true; // El tanque fue alimentado
        } else {
            this.diasSinComer++; // Incrementar días sin comer
            if (this.diasSinComer > 3) {
                this.diasDescanso = Math.min(this.diasSinComer - 3, 3); // Máximo 3 días de descanso
            }
            return false; // El tanque no fue alimentado
        }
    }

    // Método para producir alimento
    public int producir() {
        if (this.diasDescanso > 0) {
            this.diasDescanso--;
            return 0; // No se produce alimento
        }

        // Si el tanque ha sido alimentado y no está en descanso, produce alimento
        if (this.diasSinComer == 0) {
            int produccion = (int) (Math.random() * 101) + 100; // Producción entre 100 y 200
            System.out.println("Producción de alimento: " + produccion);
            return produccion;
        } else {
            return 0; // No se produce alimento
        }
    }

    // Getters
    public int getComidaAlmacenada() {
        return comidaAlmacenada;
    }

    public int getDiasDescanso() {
        return diasDescanso;
    }

    public int getDiasSinComer() {
        return diasSinComer;
    }

    public void load(DTOTanqueLangostinos tla){
        this.comidaAlmacenada = tla.getComida();
        this.diasDescanso = tla.getDescanso();
    
    }
}