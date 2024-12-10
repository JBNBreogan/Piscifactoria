package saves;

import peces.Pez;

/**
 * Clase que guarda la información de los peces
 * @author Breogan
 */
public class DTOPez {
    
    /** Edad del pez en días */
    private int edad;

    /** Sexo del pez */
    private boolean sexo;

    /** Estado del pez */
    private boolean vivo;

    /** Madurez del pez */
    private boolean maduro;

    /** Fertilidad del pez */
    private boolean fertil;

    /** Dias de ciclo del pez */
    private int ciclo;

    /** Alimentación del pez */
    private boolean alimentado;
    
    /**
     * Constructor
     * @param pez Pez del que conseguir la información
     */
    public DTOPez(Pez pez){
        this.edad = pez.getAge();
        this.sexo = pez.isFemale();
        this.vivo = pez.isAlive();
        this.maduro = pez.isAdulto();
        this.fertil = pez.isFertile();
        this.ciclo = pez.getUltimaPuesta();
        this.alimentado = pez.isAlimentado();
    }

    /**
     * Getter del estado de alimentación del pez
     * @return Estado de alimentación
     */
    public boolean isAlimentado() {
        return alimentado;
    }

    /**
     * Getter del estado de fertilidad del pez
     * @return Estado de fertilidad
     */
    public boolean isFertil() {
        return fertil;
    }

    /**
     * Getter del estado de madurez del pez
     * @return Estado de madurez
     */
    public boolean isMaduro() {
        return maduro;
    }

    /**
     * Getter del sexo del pez
     * @return El sexo, true si es hembra
     */
    public boolean isSexo() {
        return sexo;
    }

    /**
     * Getter del estado de vitalidad del pez
     * @return Estado de vitalidad
     */
    public boolean isVivo() {
        return vivo;
    }

    /**
     * Getter de días de ciclo de reproducción del pez
     * @return Días desde su ultima reproducción
     */
    public int getCiclo() {
        return ciclo;
    }

    /**
     * Getter de la edad del pez
     * @return Edad del pez
     */
    public int getEdad() {
        return edad;
    }
}
