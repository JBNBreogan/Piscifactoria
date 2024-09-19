package Comun;

//Patron singleton

public class Monedero {
    private static Monedero instance;
    public int monedas;

    private Monedero() {
    }

    public static Monedero getInstance() {
        if (instance == null) {
            instance = new Monedero();
        }
        return instance;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

}
