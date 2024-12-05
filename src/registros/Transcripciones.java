package registros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import comun.AlmacenCentral;
import helpers.ErrorHelper;
import peces.Pez;
import piscifactoria.Piscifactoria;
import propiedades.AlmacenPropiedades;
import propiedades.CriaTipo;

/**
 * Clase encargada de hacer las transcripciones del sistema
 * 
 * @author Cristian
 */
public class Transcripciones {
    //**Instancia del objeto de Transacciones. */
    private static Transcripciones instance;
    //**Nombre de la carpeta de guardado */
    private static String ruta= "transacciones";
    /**objeto BuffererWriter para poder escribir en el archivo */
    private static BufferedWriter bw=null;

    /**
     * Constructor vacío de la clase Transacciones.
     */
    private Transcripciones() {
    }

    /**
     * Método que permite crear el objeto en caso de que no exista, y en caso de que exista solo devuelve la instancia.
     */
    public static Transcripciones getInstance(String nombrePartida) {
        if (instance == null) {
            instance = new Transcripciones();
            File carpeta= new File(ruta);
            if(!carpeta.exists()){
                carpeta.mkdir();
            }
            File archivo =new File(ruta + "/" + nombrePartida + ".tr");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException e) {
                    ErrorHelper.writeError("No se ha podido crear el archivo de transacciones");
                }
            }

            try {
                bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true),"UTF-8"));
            } catch (UnsupportedEncodingException | FileNotFoundException e) {
                ErrorHelper.writeError("Error la escritura en el archivo");
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
            ErrorHelper.writeError("No se ha podido escribir en el archivo de transcripciones");
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
        this.escribirArchivo("Inicio de la simulación " + nombrePartida + ".\n");

        this.escribirArchivo("========Dinero========\n");
        this.escribirArchivo("Dinero: " + monedas + " monedas.\n");

        this.escribirArchivo("========Peces========\n");
        this.escribirArchivo("Río: \n");
        
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.RIO){
                this.escribirArchivo("-" + pecesImplementasdos[i] + ".\n");
            }
        }

        this.escribirArchivo("Mar : \n");
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.MAR){
                this.escribirArchivo("-" + pecesImplementasdos[i] + ".\n");
            }
        }

        this.escribirArchivo("Rio y Mar : \n");
        for (int i = 0; i < pecesImplementasdos.length; i++) {
            if(AlmacenPropiedades.getPropByName(pecesImplementasdos[i])
            .getPiscifactoria()==CriaTipo.DOBLE){
                this.escribirArchivo("-" + pecesImplementasdos[i] + ".\n");
            }
        }

        if(extras!=null){
            this.escribirArchivo("========Extras========\n");
            for (int i = 0; i < extras.length; i++) {
                //Escribir nombre de los extras
            }
        }
        
        this.escribirArchivo("--------------------\n");

        this.escribirArchivo("Piscifactoria inicial: " + primeraPisc + ".\n");
    }

    /**
     * Metodo que escribe en el archivo la infromacion de las compras de comida.
     * @param cantComida Cantidad de comida.
     * @param tipoCom Tipo de comida.
     * @param monedas Monedas gastadas en la comida.
     * @param lugarGuardado Lugar donde se guardo.
     * @param pisc Piscifactoria en la que se guardo en caso de que no se haya guardado en el almacen central.
     */
    public void comprarComida(int cantComida, String tipoCom, int monedas, String lugarGuardado ,Piscifactoria pisc){
        if(lugarGuardado.equals("almacen central")){
            this.escribirArchivo(cantComida + " de comida de " + tipoCom + " comprada por " 
            + monedas + " monedas. Se almacena en el almacén central.\n");
        }else if (lugarGuardado.equals("piscifactoria")) {
            this.escribirArchivo(cantComida + " de comida de " + tipoCom + " comprada por " 
            + monedas + " monedas. Se almacena en la piscifactoria " + pisc.getNombre() + ".\n");
        }
    }
    
    /**
     * Metodo que escribe en el archivo la informacion de las compras de los peces.
     * @param pez Pez que se compra.
     * @param sexo Sexo de pez comprado.
     * @param tanque Tanque en el que se añade el pez.
     * @param pisc Piscifactoria en la que se añade el pez.
     * @param monedas Monedas gastadas en el pez.
     */
    public void comprarPeces(Pez pez, char sexo, int tanque, Piscifactoria pisc, int monedas){
        this.escribirArchivo(pez.getName() + "("+sexo+") comprado por " + monedas + 
        " monedas. Añadido al tanque " + (tanque+1) + " de la piscifactoria " 
        + pisc.getNombre() + ".\n");
    }

    /**
     * Metodo que escribe en el archivo la informacion de las ventas manuales de los peces.
     * @param cantPeces Numero de peces vendidos.
     * @param monedas Cantidad de monedas obtenidas.
     * @param pisc Piscifactoria de la que se vendieron los peces.
     */
    public void venderPeces(int cantPeces, int monedas, Piscifactoria pisc){
        this.escribirArchivo("Vendidos " + cantPeces + " peces de la piscifactoria "
        + pisc.getNombre() + " de forma manual por " + monedas + " monedas.\n");
    }

    /**
     * Metodo que escribe en el archivo la informacion de la limpieza de un tanque.
     * @param tanque Tanque limpiado.
     * @param pisc Piscifactoria a la que pertenece el tanque.
     */
    public void limpiarTanque(int tanque, Piscifactoria pisc){
        this.escribirArchivo("Limpiando el tanque " + (tanque+1) 
        + " de la piscifactoria " + pisc.getNombre() + ".\n");
    }

    /**
     * Metodo que escribe en el archivo la informacion del vaciado de los peces del tanque.
     * @param tanque Tanque vaciado.
     * @param pisc Piscifactoria a la que pertenece el tanque.
     */
    public void vaciarTanque(int tanque, Piscifactoria pisc){
        this.escribirArchivo("Vaciado el tanque " + (tanque+1) 
        + " de la piscifactoria " + pisc.getNombre() + ".\n");
    }

    /**
     * Metodo que escribe en el archivo la informacion de la compra de algun edificio.
     * @param pisc Edificio comprado.
     * @param monedas Monedas gastadas en el edificio.
     */
    public void comprarEdificio(Piscifactoria pisc, int monedas){
        if (pisc != null) {
            if(pisc.getTipo() == CriaTipo.MAR){
                this.escribirArchivo("Comprada la piscifactoria de " + CriaTipo.MAR.getName() + " " + pisc.getNombre() + " por " + monedas + " monedas.\n");
            }else if(pisc.getTipo() == CriaTipo.RIO){
                this.escribirArchivo("Comprada la piscifactoria de " + CriaTipo.RIO.getName() + " " + pisc.getNombre() + " por " + monedas + " monedas.\n");
            }
        }else{
            this.escribirArchivo("Comprado el almacen central.\n");

        }
    }

    /**
     * Metodo que escribe en el archivo la informacion de las mejoras de los edificios.
     * @param pisc Piscifactoria mejorada (en caso de mejorar un piscifactoria).
     * @param monedas Monedas gastadas en la mejora.
     * @param tanque Tanque de la piscifactoria añadido (en caso de añadir un tanque).
     * @param almacenCentral Almacen central (en caso de ser mejorado).
     */
    public void mejorarEdificio(Piscifactoria pisc, int monedas, int tanque, AlmacenCentral almacenCentral){
        if (pisc != null) {
            tanque++;
            if(tanque!=0){
                this.escribirArchivo("Mejorada la piscifactoria " + pisc.getNombre() + " añadiendo el tanque " + tanque + " por " + monedas + " monedas.\n");
            }else{
                this.escribirArchivo("Mejorada la piscifactoria " + pisc.getNombre() +
                " aumentando su capacidad de comida hasta un total de " + pisc.getMaxComidaAnimal() + " por " + monedas + " monedas.\n");
            }
        }else{
            this.escribirArchivo("Mejorado el almacen central aumentando su capacidad de comida hasta un total de " +
            almacenCentral.getCapacidadComidaAnimal() + " por " + monedas + " monedas.\n");
        }
    }

    /**
     * Metoto que escribe en el archivo la informacion de los peces totales al final del dia y las monedas obtenidas con la venta automatica y las monedas totales.
     * @param numDia Dia terminado.
     * @param pecesRio Número de peces de rio.
     * @param pecesMar Número de peces de mar.
     * @param monedasObtenidas Monedas obtenidas con la venta automatica.
     * @param monedasTotales Monedas totales.
     */
    public void pasarDia(int numDia, int pecesRio, int pecesMar, int monedasObtenidas, int monedasTotales){
        this.escribirArchivo("Fin del día " + numDia + ".\n" + "Peces actuales, " + pecesRio + " de río " + pecesMar + " de mar.\n" +
        monedasObtenidas + " monedas ganadas por un total de " + monedasTotales + ".\n" + "--------------------\n" + ">>>Inicio del día " + (numDia+1) + ".\n");
    }

    /**
     * Metodo que escribe en el archivo la informacion del uso de las opciones ocultas del programa
     * @param pisc Piscifactoria a la que se añaden los peces(en caso de ser la opcion 98)
     * @param monedasAñad Monedas añadidas(en caso de ser la opcion 99)
     * @param monedas Monedas totales(en caso de ser la opcion 99)
     */
    public void ocultas(Piscifactoria pisc, int monedasAñad, int monedas){
        if(pisc==null){
            this.escribirArchivo("Añadidas " + monedasAñad + " monedas mediante la opción oculta. Monedas actuales, " + monedas + ".\n");
        }else{
            this.escribirArchivo("Añadidos peces mediante la opción oculta a la piscifactoría " + pisc.getNombre() + ".\n");
        }
    }

    /**
     * Método que escribe en el archivo la informacion de la creacion de recompensas del programa.
     * @param nombreRec Nombre de la recompensa.
     */
    public void recompensaCreada(String nombreRec){
        this.escribirArchivo("Recompensa " + nombreRec + "creada.\n");
    }

    /**
     * Método que escribe en el archivo la informacion del uso de recompensas del programa.
     * @param nombreRec Nombre de la recompensa.
     */
    public void recompensaUsada(String nombreRec){
        this.escribirArchivo("Recompensa " + nombreRec + " usada.\n");
    }

    /**
     * Método que cierra el buffererWriter.
     */
    public void close(){
        try {
            bw.close();
        } catch (Exception e) {}
    }
}
