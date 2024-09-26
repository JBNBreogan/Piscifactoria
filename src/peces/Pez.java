package peces;
/**Clase padre de los peces*/
public abstract class Pez {

    /**Nombre común del pez*/
    protected String CommonName;

    /**Nombre científico del pez*/
    protected String ScientificName;

    /**Edad del pez*/
    protected int Age;

    /**Sexo del pez*/
    protected char Sex;

    /**Fertilidad del pez*/
    protected boolean Fertile;

    /**Estado del pez*/
    protected boolean Alive;

    /**
     * Devuelve el nombre comun del pez
     * @return El nombre comun
     */
    public String getCommonName() {
        return CommonName;
    }

    /**
     * Devuleve el nombre cientifico del pez
     * @return El nombre cientifico
     */
    public String getScientificName() {
        return ScientificName;
    }

    /**
     * Devuelve la edad del pez
     * @return La edad en días
     */
    public int getAge() {
        return Age;
    }

    /**
     * Devuelve el sexo del pez
     * @return El sexo como caracter (H o M)
     */
    public char getSex() {
        return Sex;
    }

    /**
     * Devuelve el estado del pez
     * @return Si está vivo o no
     */
    public boolean isAlive() {
        return Alive;
    }

    /**
     * Devuelve la fertilidad del pez
     * @return Si es fertil o no
     */
    public boolean isFertile() {
        return Fertile;
    }

    /**
     * Muestra el estado del pez 
     */
    public void showStatus(){
        System.out.println("---------------" + this.CommonName + "---------------");
        System.out.println("Edad: " + this.Age + " días");
        System.out.println("Sexo: " + this.Sex);
        System.out.println("Vivo: " + (this.Alive ? "Si" : "No"));
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
