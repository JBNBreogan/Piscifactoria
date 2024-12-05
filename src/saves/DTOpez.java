package saves;

import peces.Pez;

public class DTOPez {
    private int edad;
    private boolean sexo;
    private boolean vivo;
    private boolean maduro;
    private boolean fertil;
    private int ciclo;
    private boolean alimentado;
    
    public DTOPez(Pez pez){
        this.edad = pez.getAge();
        this.sexo = pez.isFemale();
        this.vivo = pez.isAlive();
        this.maduro = pez.isAdulto();
        this.fertil = pez.isFertile();
        this.ciclo = pez.getUltimaPuesta();
        this.alimentado = pez.isAlimentado();
    }

    public boolean isAlimentado() {
        return alimentado;
    }
    public boolean isFertil() {
        return fertil;
    }
    public boolean isMaduro() {
        return maduro;
    }
    public boolean isSexo() {
        return sexo;
    }
    public boolean isVivo() {
        return vivo;
    }
    public int getCiclo() {
        return ciclo;
    }
    public int getEdad() {
        return edad;
    }
}
