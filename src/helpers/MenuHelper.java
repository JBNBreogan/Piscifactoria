package helpers;

public class MenuHelper {
    /**
     * Crea un menú con los parámetros introducidos
     * @param opciones
     * @param salir
     */
    public static void mostrarMenu(String[] opciones, boolean salir){
        System.out.println();
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(i+1+".- "+opciones[i]);
        }
        if (salir){
            System.out.println("0. Salir");
        }
    }
}
