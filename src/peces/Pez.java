package peces;

import java.util.Random;

import propiedades.CriaTipo;
import propiedades.PecesDatos;
import propiedades.PecesTipo;

/**
 * Clase padre de los peces
 * @author Breogan
 */
public abstract class Pez {

    /**Nombre común del pez*/
    protected String Nombre;

    /**Nombre científico del pez*/
    protected String Cientifico;

    /**Numero de dias tras los que puede volver a reproducirse */
    protected int Ciclo;

    /**Precio de compra del pez */
    protected int Coste;

    /**Cantidad de huevos que pone */
    protected int Huevos;

    /**Tiempo que tarda en llegar a edad adulta */
    protected int Madurez;

    /**Cantidad de monedas que da al venderlo */
    protected int Monedas;

    /**Numero de dias que tarda en venderse */
    protected int Optimo;

    /**Tipo de piscifactoría en la que puede criarse */
    protected CriaTipo Piscifactoria;

    /**Tipo de pez */
    protected PecesTipo Tipo;

    /**Edad del pez*/
    protected int Edad;

    /**Sexo del pez, true si es hembra*/
    protected boolean Sexo;

    /**Si el pez ha comido en el dia actual */
    protected boolean Comido;

    /**Fertilidad del pez*/
    protected boolean Fertil;

    /**Estado del pez*/
    protected boolean Vivo;

    /**Ultimo ciclo de puesta (Empieza en el máximo para que la primera vez sea fertil) */
    protected int UltimaPuesta;

    /**
     * Constructor parametrizado
     * @param data Datos del pez
     */
    protected Pez (PecesDatos data){
        this.Nombre = data.getNombre();
        this.Cientifico = data.getCientifico();
        this.Ciclo = data.getCiclo();
        this.Coste = data.getCoste();
        this.Huevos = data.getHuevos();
        this.Madurez = data.getMadurez();
        this.Monedas = data.getMonedas();
        this.Optimo = data.getOptimo();
        this.Piscifactoria = data.getPiscifactoria();
        this.Tipo = data.getTipo();
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
        this.Comido = false;
        this.UltimaPuesta = data.getCiclo();
    }

    /**
     * Devuelve el nombre comun del pez
     * @return El nombre comun
     */
    public String getName() {
        return Nombre;
    }

    /**
     * Devuleve el nombre cientifico del pez
     * @return El nombre cientifico
     */
    public String getCientifico() {
        return Cientifico;
    }

    /**
     * Devuelve la edad del pez
     * @return La edad en días
     */
    public int getAge() {
        return Edad;
    }

    /**
     * Devuelve si el pez es hembra
     * @return True si es hembra, false si es macho
     */
    public boolean isFemale() {
        return Sexo;
    }

    /**
     * Devuelve el estado del pez
     * @return Si está vivo o no
     */
    public boolean isAlive() {
        return Vivo;
    }

    /**
     * Devuelve la fertilidad del pez
     * @return Si es fertil o no
     */
    public boolean isFertile() {
        return Fertil;
    }

    /**
     * Devuelve si el pez es maduro
     * @return Si es maduro o no
     */
    public boolean isAdulto() {
        if (this.Edad >= this.Madurez){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve la cantidad de huevos que pone
     * @return Los huevos
     */
    public int getHuevos() {
        return Huevos;
    }
    
    /**
     * Devuelve el coste de compra del pez
     * @return El coste de compra
     */
    public int getCoste() {
        return Coste;
    }

    /**
     * Devuelve cuantas monedas te da al vender el pez
     * @return El valor de venta
     */
    public int getMonedas() {
        return Monedas;
    }

    /**
     * El tipo de piscifactoría a la que pertenece
     * @return Si es de mar, de rio o doble
     */
    public CriaTipo getPiscifactoria() {
        return Piscifactoria;
    }

    /**
     * Devuelve si el pez esta alimentado
     * @return Si esta alimentado o no
     */
    public boolean isAlimentado() {
        return Comido;
    }

    /**
     * Devuelve la edad optima para vender el pez
     * @return La edad optima de venta
     */
    public int getOptimo() {
        return Optimo;
    }

    /**
     * Devuelve la cantidad de dias desde la ultima
     * reproduccion.
     * @return Dias de la ultima puesta de huevos.
     */
    public int getUltimaPuesta() {
        return UltimaPuesta;
    }

    /**
     * Hace que el pez deje de ser fertil
     */
    public void notFertil(){
        this.Fertil = false;
    }

    /**
     * Hace que se resetee la puesta
     */
    public void resetPuesta(){
        this.UltimaPuesta = 0;
    }

    /**
     * Muestra el estado del pez 
     */
    public void showStatus(){
        System.out.println("---------------" + this.Nombre + "---------------");
        System.out.println("Edad: " + this.Edad + " días");
        System.out.println("Sexo: " + (isFemale() ? "H" : "M"));
        System.out.println("Vivo: " + (this.Vivo ? "Si" : "No"));
        System.out.println("Alimentado: " + (this.Comido ? "Si" : "No")) ;
        System.out.println("Fértil: " + (this.Fertil ? "Si" : "No"));
    }

    /**
     * Hace crecer el pez un día, teniendo en cuenta todos los factores, y devolviendo la cantidad de comida que consume
     * @param comida Comida de la que dispone la piscifactoría
     * @return Comida consumida
     */
    public int grow(int comida){
        this.Comido = false;
        Random morir = new Random();
        int comidaConsumida = 0;
        if (isAlive()){
            comidaConsumida = comer(comida); 
            if (this.Comido){
                this.Edad++;
                this.UltimaPuesta++;
                if (isAdulto() && this.UltimaPuesta >= this.Ciclo){
                    this.Fertil = true;
                }
                
            } else {
                if (morir.nextInt(2) == 0){
                    this.Vivo = false;
                } else {
                    this.Edad++;
                    this.UltimaPuesta++;
                    if (isAdulto() && this.UltimaPuesta >= this.Ciclo){
                        this.Fertil = true;
                    }
                }
            }
        }
        return comidaConsumida;
    }

    /**
     * Devuelve una cría del pez.
     * @param hembra Si el pez es hembra.
     * @return Una cria del pez.
     */
    public abstract Pez reproducirse(boolean hembra);

    
    /**
     * Hace comer al pez si hay comida suficiente, y devuelve la cantidad que consume.
     * @param cantidad Cantidad de comida disponible.
     * @return Cantidad de comida consumida.
     */
    public abstract int comer(int cantidad);

    /**
     * Resetea todo el pez, pero dejando los valores
     * característicos igual
     */
    public void reset(){
        this.Edad = 0;
        this.Vivo = true;
        this.Fertil = false;
        this.Comido = false;
    }

    
}
