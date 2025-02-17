package granjas;
import java.util.ArrayList;
import java.util.List;

import dtos.DTOGranjaLangostinos;
import dtos.DTOTanqueLangostinos;


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

        int tanqueIndex = 0;
        while (comidaDisponible >= 50 && !tanques.isEmpty()) {
            TanqueLangostinos tanque = tanques.get(tanqueIndex % tanques.size());
            if (tanque.getComidaAlmacenada() < 150) { // Verificar que no exceda el límite
                tanque.addComidaTanque(50); // Añadir 50 unidades de comida
                comidaDisponible -= 50;
            } else{
                System.out.println("Almacen del tanque de la granja de langostinos lleno.");
                break;
            }
            tanqueIndex++;
        }
    }

    // Método para producir alimento
    public int producirAlimento() {
        int produccionTotal = 0;
        for (TanqueLangostinos tanque : this.tanques) {
            produccionTotal += tanque.producir();
        }
        return produccionTotal;
    }

    // Getters
    public boolean isDisponible() {
        return disponible;
    }

    public int getMuertos() {
        return muertos;
    }

    public List<TanqueLangostinos> getTanques() {
        return tanques;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    public void setTanques(List<TanqueLangostinos> tanques) {
        this.tanques = tanques;
    }

    public void load(DTOGranjaLangostinos granjal) {
        this.muertos = granjal.getMuertos();
        List<DTOTanqueLangostinos> aux = granjal.getTanques();
        for (DTOTanqueLangostinos dtoTanqueLangostinos : aux) {
            TanqueLangostinos tnkLa = new TanqueLangostinos();
            tnkLa.load(dtoTanqueLangostinos);
            this.tanques.add(tnkLa);
        }
    }
}

