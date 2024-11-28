package registros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import peces.Pez;
import piscifactoria.Piscifactoria;
import propiedades.AlmacenPropiedades;
import propiedades.CriaTipo;

/**
 * Clase encargada de hacer las transacciones del sistema
 * 
 * @author Cristian
 */
public class Transacciones {
    //**Instancia del objeto de Transacciones. */
    private static Transacciones instance;
    //**Nombre de la carpeta de guardado */
    private static String ruta= "transacciones";
    /**objeto BuffererWriter para poder escribir en el archivo */
    private static BufferedWriter bw=null;

    /**
     * Constructor vacío de la clase Transacciones.
     */
    private Transacciones() {
    }

    /**
     * Método que permite crear el objeto en caso de que no exista, y en caso de que exista solo devuelve la instancia.
     */
    public static Transacciones getInstance(String nombrePartida) {
        if (instance == null) {
            instance = new Transacciones();
            File carpeta= new File(ruta);
            if(!carpeta.exists()){
                carpeta.mkdir();
            }
            File archivo =new File(ruta + "/" + nombrePartida + ".tr");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException e) {
                    System.out.println("No se ha podido crear el archivo de transacciones");
                }
            }

            try {
                bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true),"UTF-8"));
            } catch (UnsupportedEncodingException | FileNotFoundException e) {
                System.out.println("Error la escritura en el archivo");
            }

        }
        return instance;
    }

    /**
     * Metodo que escribe un linea de texto pasada por parametro en el archivo.
     * @param texto Linea que quieras escribir.
     */
    private void escribirArchivo(String texto){
        try {
            bw.write(texto);
            bw.flush();
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el archivo");
        }
        
    }

    /**
     * Metodo que escribe en el archivo todos los parametros del inicio del programa.
     * @param primeraPisc Nombre de la piscifactoria.
     * @param extras Extras implementados.
     * @param pecesImplementasdos Peces implementados en el sistema.
     * @param monedas Numero de monedas iniciales.
     * @param nombrePartida Nombre de la empresa.
     */
    public void inicio(String primeraPisc,String[] extras,String[] pecesImplementasdos,int monedas,String nombrePartida){
        this.escribirArchivo("========Inicio========\n");
        this.escribirArchivo("Inicio de la simulación " + nombrePartida + "\n");

        this.escribirArchivo("========Dinero========\n");
        this.escribirArchivo("Dinero: " + monedas + " monedas\n");

        this.escribirArchivo("========Peces========\n");
        this.escribirArchivo("Río: \n");
        
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.RIO){
                this.escribirArchivo("-" + pecesImplementasdos[i] + "\n");
            }
        }

        this.escribirArchivo("Mar : \n");
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.MAR){
                this.escribirArchivo("-" + pecesImplementasdos[i] + "\n");
            }
        }

        this.escribirArchivo("Rio y Mar : \n");
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.DOBLE){
                this.escribirArchivo("-" + pecesImplementasdos[i] + "\n");
            }
        }

        if(extras!=null){
            this.escribirArchivo("========Extras========\n");
            for (int i = 0; i < extras.length; i++) {
                //Escribir nombre de los extras
            }
        }
        
        this.escribirArchivo("--------------------\n");

        this.escribirArchivo("Piscifactoria inicial: " + primeraPisc + "\n");
    }

    /**
     * Metodo que escribe en el archivo la infromacion de las compras de comida.
     * @param cantComida Cantidad de comida
     * @param tipoCom Tipo de comida
     * @param monedas Monedas gastadas
     * @param lugarGuardado Lugar donde se guardo
     * @param pisc Piscifactoria en la que se guardo en caso de que no se haya guardado en el almacen central
     */
    public void comprarComida(int cantComida, String tipoCom, int monedas, String lugarGuardado ,Piscifactoria pisc){
        this.escribirArchivo("========Comprar comida========\n");
        if(lugarGuardado.equals("almacen central")){
            this.escribirArchivo(cantComida + " de comida de " + tipoCom + " comprada por " 
            + monedas + " monedas. Se almacena en el almacén central.\n");
        }else if (lugarGuardado.equals("piscifactoria")) {
            this.escribirArchivo(cantComida + " de comida de " + tipoCom + " comprada por " 
            + monedas + " monedas. Se almacena en la piscifactoria " + pisc.getNombre() + "\n");
        }
    }
    
    /**
     * Metodo que escribe en el archivo la informacion de las compras de los peces.
     * @param pez
     * @param sexo
     * @param tanque
     * @param pisc
     * @param monedas
     */
    public void comprarPeces(Pez pez, char sexo, int tanque, Piscifactoria pisc, int monedas){
        this.escribirArchivo("========Comprar peces========\n" 
        + pez.getName() + "("+sexo+") comprado por " + monedas + 
        " monedas. Añadido al tanque " + (tanque+1) + " de la piscifactoria " 
        + pisc.getNombre() + "\n");
    }
}
