package Registros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import Piscifactoria.Piscifactoria;
import Tanque.Tanque;
import peces.Pez;
import propiedades.AlmacenPropiedades;
import propiedades.CriaTipo;

public class Transacciones {
    //**Instancia del objeto de monedero. */
    private static Transacciones instance;

    private static String ruta= "transacciones";

    private static BufferedWriter bw=null;

    /**
     * Constructor vacío de la clase Monedero.
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

    public void escribirArchivo(String texto){
        try {
            bw.write(texto);
            bw.flush();
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el archivo");
        }
        
    }

    public void inicio(String primeraPisc,String[] extras,String[] pecesImplementasdos,int monedas,String nombrePartida){
        escribirArchivo("========Inicio========\n");
        escribirArchivo("Inicio de la simulación " + nombrePartida + "\n");

        escribirArchivo("========Dinero========\n");
        escribirArchivo("Dinero: " + monedas + " monedas\n");

        escribirArchivo("========Peces========\n");
        escribirArchivo("Río: \n");
        
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.RIO){
                escribirArchivo("-" + pecesImplementasdos[i] + "\n");
            }
        }

        escribirArchivo("Mar : \n");
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.MAR){
                escribirArchivo("-" + pecesImplementasdos[i] + "\n");
            }
        }

        escribirArchivo("Rio y Mar : \n");
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.DOBLE){
                escribirArchivo("-" + pecesImplementasdos[i] + "\n");
            }
        }

        if(extras!=null){
            escribirArchivo("========Extras========");
            for (int i = 0; i < extras.length; i++) {
                //Escribir nombre de los extras
            }
        }
        
        escribirArchivo("--------------------\n");

        escribirArchivo("Piscifactoria inicial: " + primeraPisc + "\n");
    }

    
}
