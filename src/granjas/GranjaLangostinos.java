package granjas;
import java.util.ArrayList;
import java.util.List;


public class GranjaLangostinos {
    private boolean disponible;
    private int muertos; // Número de peces muertos almacenados
    private List<TanqueLangostinos> tanques; // Lista de tanques de langostinos

    public GranjaLangostinos() {
        this.disponible = false; // Inicialmente no está disponible
        this.muertos = 0;
        this.tanques = new ArrayList<>();
    }

    // Método para comprar la granja
    public void comprar() {
        this.disponible = true;
        tanques.add(new TanqueLangostinos());
        System.out.println("Comprada la granja de langostinos.");
    }

    // Método para añadir un tanque
    public void mejorar() {
        if (!this.disponible) {
            System.out.println("La granja de langostinos no está disponible.");
            return;
        }
        TanqueLangostinos nuevoTanque = new TanqueLangostinos();
        this.tanques.add(nuevoTanque);
        System.out.println("Mejorada la granja de langostinos añadiendo un tanque. Total de tanques: " + this.tanques.size());
    }

    // Método para alimentar los tanques
    public void alimentarTanques(int comidaDisponible) {
        if (!this.disponible) {
            System.out.println("La granja de langostinos no está disponible.");
            return;
        }

        for (TanqueLangostinos tanque : this.tanques) {
            if (comidaDisponible >= 50) {
                tanque.addComidaTanque(50);
                comidaDisponible -= 50;
            } else {
                tanque.incrementarDiasSinComer();
            }
        }
    }

    // Método para procesar la muerte de un pez
    public void procesarMuertePez() {
        if (!this.disponible) {
            System.out.println("La granja de langostinos no está disponible.");
            return;
        }
        this.muertos++;
        System.out.println("Peces muertos almacenados: " + this.muertos);
    }

    // Método para producir alimento
    public int producirAlimento() {
        int devolver = 0;
        if (!this.disponible) {
            System.out.println("La granja de langostinos no está disponible.");
            return devolver;
        } else {
            for (TanqueLangostinos tanque : this.tanques) {
                devolver += tanque.producir();
            }
            return devolver;
        }
    }

    // Getters y setters
    public boolean isDisponible() {
        return disponible;
    }

    public int getMuertos() {
        return muertos;
    }

    public List<TanqueLangostinos> getTanques() {
        return tanques;
    }
}

class TanqueLangostinos {
    private int comidaAlmacenada; // Cantidad de comida almacenada (0-3 días)
    private int diasDescanso; // Días de descanso antes de volver a producir (0-3)
    private int diasSinComer; // Días consecutivos sin comer

    public TanqueLangostinos() {
        this.comidaAlmacenada = 0;
        this.diasDescanso = 0;
        this.diasSinComer = 0;
    }

    // Método para alimentar el tanque
    public void addComidaTanque(int cantidadComida) {
        if (cantidadComida >= 50) {
            this.comidaAlmacenada++;
            this.diasSinComer = 0; // Reinicia los días sin comer
        }
    }

    // Método para incrementar los días sin comer
    public void incrementarDiasSinComer() {
        this.diasSinComer++;
        if (this.diasSinComer > 3) {
            this.diasSinComer = 3; // Máximo 3 días sin comer
        }
    }

    // Método para producir alimento
    public int producir() {
        if (this.diasDescanso > 0) {
            this.diasDescanso--;
            return 0;
        }
        if (this.comidaAlmacenada > 0) {
            this.comidaAlmacenada--;
            int produccion = (int) (Math.random() * 101) + 100; // Producción entre 100 y 200
            System.out.println("Producción de alimento: " + produccion);
            return produccion;
        } else {
            this.diasDescanso = this.diasSinComer; // Descansa los días que no comió
            this.diasSinComer = 0;
            return 0;
        }
    }

    // Getters y setters
    public int getComidaAlmacenada() {
        return comidaAlmacenada;
    }

    public int getDiasDescanso() {
        return diasDescanso;
    }

    public int getDiasSinComer() {
        return diasSinComer;
    }
}
