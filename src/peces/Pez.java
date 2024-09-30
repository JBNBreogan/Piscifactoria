package peces;
/**Clase padre de los peces*/

import propiedades.CriaTipo;
import propiedades.PecesProps;
import propiedades.PecesTipo;

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

    /**Propiedades del pez */
    protected PecesProps[] Propiedadas;

    /**Tipo de pez */
    protected PecesTipo Tipo;

    /**Edad del pez*/
    protected int Edad;

    /**Sexo del pez*/
    protected char Sexo;

    /**Fertilidad del pez*/
    protected boolean Fertil;

    /**Estado del pez*/
    protected boolean Vivo;

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
     * Devuelve el sexo del pez
     * @return El sexo como caracter (H o M)
     */
    public char getSex() {
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
     * Muestra el estado del pez 
     */
    public void showStatus(){
        System.out.println("---------------" + this.Nombre + "---------------");
        System.out.println("Edad: " + this.Edad + " días");
        System.out.println("Sexo: " + this.Sexo);
        System.out.println("Vivo: " + (this.Vivo ? "Si" : "No"));
        System.out.println("Alimentado: ");
        System.out.println("Fértil: ");
        //TODO Acabar esto
    }

    /**
     * Hace crecer el pez un día, teniendo en cuenta todos los factores
     */
    public void grow(){
        //TODO: Lógica de crecimiento del pez, si ha comido, edad, fertilidad...
    }

    public void reset(){
        //TODO: Lógica para resetear el pez
    }

}
