package registros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import helpers.ErrorHelper;
import peces.Pez;
import piscifactoria.Piscifactoria;
import propiedades.CriaTipo;

/**
 * Clase encargada de hacer las transacciones del sistema
 * 
 * @author Cristian
 */
public class Logs {
    //**Instancia del objeto de Transacciones. */
    private static Logs instance;
    //**Nombre de la carpeta de guardado */
    private static String ruta= "logs";
    /**Objeto BuffererWriter para poder escribir en el archivo */
    private static BufferedWriter bw=null;

    /**
     * Constructor vacío de la clase Transacciones.
     */
    private Logs() {
    }

    /**
     * Método que permite crear el objeto en caso de que no exista, y en caso de que exista solo devuelve la instancia.
     */
    public static Logs getInstance(String nombrePartida) {
        if (instance == null) {
            instance = new Logs();
            File carpeta= new File(ruta);
            if(!carpeta.exists()){
                carpeta.mkdir();
            }
            File archivo =new File(ruta + "/" + nombrePartida + ".log");
            if(!archivo.exists()){
                try {
                    archivo.createNewFile();
                } catch (IOException e) {
                    ErrorHelper.writeError("No se ha podido crear el archivo de logs");
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
     * Método que escribe un linea de texto pasada por parametro en el archivo.
     * @param texto Linea que quieras escribir.
     */
    private void escribirArchivo(String texto){
        try {
            bw.write(texto);
            bw.flush();
        } catch (IOException e) {
            ErrorHelper.writeError("No se ha podido escribir en el archivo de logs");
        }
        
    }

    /**
     * Método que registrar en el archivo la hora del inicio del programa.
     * @param primeraPisc Nombre de la piscifactoria.
     * @param extras Extras implementados.
     * @param pecesImplementasdos Peces implementados en el sistema.
     * @param nombrePartida Nombre de la empresa.
     */
    public void inicio(String primeraPisc,String[] extras,String[] pecesImplementasdo,String nombrePartida){
        this.escribirArchivo(this.fechaActual() + " Inicio de la simulación " + nombrePartida + ".\n" + this.fechaActual() + " Piscifactoría inicial: " + primeraPisc + ".\n");
    }

    /**
     * Método que registrar en el archivo la hora de las compras de comida.
     * @param cantComida Cantidad de comida.
     * @param tipoCom Tipo de comida.
     * @param lugarGuardado Lugar donde se guardo.
     * @param pisc Piscifactoria en la que se guardo en caso de que no se haya guardado en el almacen central.
     */
    public void comprarComida(int cantComida, String tipoCom, String lugarGuardado ,Piscifactoria pisc){
        if(lugarGuardado.equals("almacen central")){
            this.escribirArchivo(this.fechaActual()+cantComida + " de comida " + tipoCom + ". Se almacena en el almacén central.\n");
        }else if (lugarGuardado.equals("piscifactoria")) {
            this.escribirArchivo(this.fechaActual()+cantComida + " de comida " + tipoCom + ". Se almacena en la piscifactoria " + pisc.getNombre() + ".\n");
        }
    }
    
    /**
     * Método que registrar en el archivo la hora de las compras de los peces.
     * @param pez Pez que se compra.
     * @param sexo Sexo de pez comprado.
     * @param tanque Tanque en el que se añade el pez.
     * @param pisc Piscifactoria en la que se añade el pez.
     */
    public void comprarPeces(Pez pez, char sexo, int tanque, Piscifactoria pisc){
        this.escribirArchivo(this.fechaActual()+pez.getName() + "("+sexo+") comprado. Añadido al tanque " + (tanque+1) + " de la piscifactoria " 
        + pisc.getNombre() + ".\n");
    }

    /**
     * Método que registrar en el archivo la hora de las ventas manuales de los peces.
     * @param cantPeces Numero de peces vendidos.
     * @param pisc Piscifactoria de la que se vendieron los peces.
     */
    public void venderPeces(int cantPeces, Piscifactoria pisc){
        this.escribirArchivo(this.fechaActual()+"Vendidos " + cantPeces + " peces de la piscifactoria "
        + pisc.getNombre() + " de forma manual.\n");
    }

    /**
     * Método que registrar en el archivo la hora de la limpieza de un tanque.
     * @param tanque Tanque limpiado.
     * @param pisc Piscifactoria a la que pertenece el tanque.
     */
    public void limpiarTanque(int tanque, Piscifactoria pisc){
        this.escribirArchivo(this.fechaActual()+"Limpiado el tanque " + (tanque+1) 
        + " de la piscifactoria " + pisc.getNombre() + ".\n");
    }

    /**
     * Método que registrar en el archivo la hora del vaciado de los peces del tanque.
     * @param tanque Tanque vaciado.
     * @param pisc Piscifactoria a la que pertenece el tanque.
     */
    public void vaciarTanque(int tanque, Piscifactoria pisc){
        this.escribirArchivo(this.fechaActual()+"Vaciado el tanque " + (tanque+1) 
        + " de la piscifactoria " + pisc.getNombre() + ".\n");
    }

    /**
     * Método que registrar en el archivo la hora de la compra de algun edificio.
     * @param pisc Edificio comprado.
     */
    public void comprarEdificio(Piscifactoria pisc){
        if (pisc != null) {
            if(pisc.getTipo() == CriaTipo.MAR){
                this.escribirArchivo(this.fechaActual()+"Comprada la piscifactoria de " + CriaTipo.MAR.getName() + " " + pisc.getNombre() + ".\n");
            }else if(pisc.getTipo() == CriaTipo.RIO){
                this.escribirArchivo(this.fechaActual()+"Comprada la piscifactoria de " + CriaTipo.RIO.getName() + " " + pisc.getNombre() + ".\n");
            }
        }else{
            this.escribirArchivo(this.fechaActual()+"Comprado el almacén central.\n");

        }
    }

    /**
     * Método que registrar en el archivo la hora de las mejoras de los edificios.
     * @param pisc Piscifactoria mejorada (en caso de mejorar un piscifactoria).
     * @param tanque Tanque de la piscifactoria añadido (en caso de añadir un tanque).
     */
    public void mejorarEdificio(Piscifactoria pisc, int tanque){
        if (pisc != null) {
            tanque++;
            if(tanque!=0){
                this.escribirArchivo(this.fechaActual()+"Mejorada la piscifactoria " + pisc.getNombre() + " añadiendo el tanque " + tanque + ".\n");
            }else{
                this.escribirArchivo(this.fechaActual()+"Mejorada la piscifactoria " + pisc.getNombre() +
                " aumentando su capacidad de comida.\n");
            }
        }else{
            this.escribirArchivo(this.fechaActual()+"Mejorado el almacen central aumentando su capacidad de comida.\n");
        }
    }

    /**
     * Método que registrar en el archivo la hora de en la que se paso un día.
     * @param numDia Dia terminado.
     */
    public void pasarDia(int numDia){
        this.escribirArchivo(this.fechaActual()+"Fin del día " + numDia + ".\n");
    }

    /**
     * Método que registrar en el archivo la hora del uso de las opciones ocultas del programa
     * @param pisc Piscifactoria a la que se añaden los peces
     */
    public void ocultas(Piscifactoria pisc){
        if(pisc==null){
            this.escribirArchivo(this.fechaActual()+"Añadidas monedas mediante la opción oculta.\n");
        }else{
            this.escribirArchivo(this.fechaActual()+"Añadidos peces mediante la opción oculta a la piscifactoría " + pisc.getNombre() + ".\n");
        }
    }

    /**
     * Método que registrar en el archivo la hora de finalización de la partida
     */
    public void salir(){
        this.escribirArchivo(this.fechaActual()+"Cierre de la partida.\n");
    }

    /**
     * Método que obtiene la fecha actual
     * @return Fecha 
     */
    private String fechaActual(){
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
        String fechaAc = "["+fechaActual.format(formato)+"] ";
        return fechaAc;
    }
}

