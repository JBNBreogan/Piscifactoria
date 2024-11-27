package comun;

import java.util.ArrayList;
import Piscifactoria.Piscifactoria;

/**
 * Clase singleton que representa un almacén central para el manejo de comida animal
 * y vegetal en una piscifactoría. Se encarga de almacenar, distribuir y gestionar
 * la capacidad de ambos tipos de alimentos entre múltiples instancias de piscifactorías.
 */
public class AlmacenCentral {

    /**
     * Instancia del almacén central.
     */
    private static AlmacenCentral instance;
    /**
     * Comida animal disponible en el almacén
     */
    private int comidaAnimal = 0;
    /**
     * Comida vegetal disponible en el almacén
     */
    private int comidaVegetal = 0;
    /**
     * Capacidad máxima de la comida animal
     */
    private int capacidadcomidaanimal = 200;
    /**
     * Capacidad máxima de la comida vegetal
     */
    private int capacidadcomidavegetal = 200;

    /**
    * Constructor privado para implementar el patrón Singleton.
    */
    private AlmacenCentral() {
    }

    /**
    * Método estático que proporciona la instancia única de AlmacenCentral.
    *
    * @return La instancia única de AlmacenCentral.
    */
    public static AlmacenCentral getInstance() {
        if (instance == null) {
            instance = new AlmacenCentral();
        }
        return instance;
    }

    /**
    * Obtiene la cantidad actual de comida animal disponible en el almacén.
    *
    * @return Cantidad de comida animal disponible.
    */
    public int getComidaAnimal() {
        return comidaAnimal;
    }

    /**
    * Obtiene la cantidad actual de comida vegetal disponible en el almacén.
    *
    * @return Cantidad de comida vegetal disponible.
    */
    public int getComidaVegetal() {
        return comidaVegetal;
    }

    /**
    * Obtiene la capacidad máxima de almacenamiento de comida animal en el almacén.
    *
    * @return Capacidad máxima de comida animal.
    */
    public int getCapacidadComidaAnimal() {
        return capacidadcomidaanimal;
    }

    /**
    * Obtiene la capacidad máxima de almacenamiento de comida vegetal en el almacén.
    *
    * @return Capacidad máxima de comida vegetal.
    */
    public int getCapacidadComidaVegetal() {
        return capacidadcomidavegetal;
    }

    /**
    * Reduce la cantidad de comida animal en el almacén si hay suficiente disponible.
    *
    * @param cantidad Cantidad de comida animal solicitada.
    * @return La cantidad de comida animal retirada; 0 si no hay suficiente comida.
    */
    public int cogerComidaAnimal(int cantidad) {
        if (comidaAnimal >= cantidad) {
            comidaAnimal -= cantidad;
            return cantidad;
        }
        return 0;
    }

    /**
    * Reduce la cantidad de comida vegetal en el almacén si hay suficiente disponible.
    *
    * @param cantidad Cantidad de comida vegetal solicitada.
    * @return La cantidad de comida vegetal retirada; 0 si no hay suficiente comida.
    */
    public int cogerComidaVegetal(int cantidad) {
        if (comidaVegetal >= cantidad) {
            comidaVegetal -= cantidad;
            return cantidad;
        }
        return 0;
    }

    /**
    * Agrega una cantidad específica de alimento (animal o vegetal) al almacén.
    *
    * @param cantidad Cantidad de alimento a agregar.
    * @param tipo     Tipo de alimento ("Animal" o "Vegetal").
    */
    public void addFood(int cantidad, String tipo) {
        if (tipo.equals("Animal")) {
            comidaAnimal += cantidad;
        } else if (tipo.equals("Vegetal")) {
            comidaVegetal += cantidad;
        }
    }

    /**
    * Distribuye proporcionalmente la comida animal y vegetal disponible en el almacén
    * entre las piscifactorías especificadas, si estas no están llenas.
    *
    * @param piscifactorias Lista de instancias de Piscifactoria para repartir alimentos.
    */
    public void repartir(ArrayList<Piscifactoria> piscifactorias) {
        boolean todasllenas = false;
        int comidaanimalarepartir = comidaAnimal / piscifactorias.size();
        int comidavegetalarepartir = comidaVegetal / piscifactorias.size();

        for (Piscifactoria piscifactoria : piscifactorias) {
            if (piscifactoria.comidaAnimalLlena() && piscifactoria.comidaVegetalLlena()) {
                todasllenas = true;
            } else {
                todasllenas = false;
                break;
            }
        }
        if (!todasllenas || !(comidaAnimal == 0 && comidaVegetal == 0)) {
            for (Piscifactoria piscifactoria : piscifactorias) {
                if (piscifactoria.getMaxComidaAnimal() > comidaanimalarepartir + piscifactoria.getComidaAnimal()) {
                    int restar = (piscifactoria.getMaxComidaAnimal() - piscifactoria.getComidaAnimal());
                    if (restar > comidaanimalarepartir) {
                        comidaAnimal -= comidaanimalarepartir;
                        piscifactoria.addFood(comidaanimalarepartir, "Animal");
                    } else {
                        comidaAnimal -= restar;
                        piscifactoria.addFood(restar, "Animal");
                    }
                }

                if (piscifactoria.getMaxComidaVegetal() > comidavegetalarepartir + piscifactoria.getComidaVegetal()) {
                    int restar = (piscifactoria.getMaxComidaVegetal() - piscifactoria.getComidaVegetal());
                    if (restar > comidavegetalarepartir) {
                        comidaVegetal -= comidavegetalarepartir;
                        piscifactoria.addFood(comidavegetalarepartir, "Vegetal");
                    } else {
                        comidaVegetal -= restar;
                        piscifactoria.addFood(restar, "Vegetal");
                    }
                }
                repartir(piscifactorias);
            }
        }
    }

    /**
    * Aumenta la capacidad máxima de almacenamiento de comida animal y vegetal en el almacén.
    *
    * @param capacidad Cantidad a aumentar en ambas capacidades.
    */
    public void aumentarCapacidad(int capacidad) {
        this.capacidadcomidaanimal += capacidad;
        this.capacidadcomidavegetal += capacidad;
        System.out.println("Capacidad aumentada en "+capacidad+". Capacidad total: "+capacidadcomidaanimal);
    }
}
