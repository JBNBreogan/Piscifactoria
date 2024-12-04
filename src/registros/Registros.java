package registros;

import comun.AlmacenCentral;
import peces.Pez;
import piscifactoria.Piscifactoria;

/**
 * Clase que se utiliza para la creacion de los reistros de la simulacion
 * @author Cristian
 */
public class Registros {
    /**Objeto de la clase transcripciones */
    Transcripciones transcripciones=null;
    /**Objeto de la clase logs */
    Logs logs=null;

    /**
     * Contructor que inicializa las instancias de las clases logs y transcripciones
     * @param nombrePartida Nombre de los archivos
     */
    public Registros(String nombrePartida) {
        transcripciones=Transcripciones.getInstance(nombrePartida);
        logs=Logs.getInstance(nombrePartida);
    }

    /**
     * Metodo que llama a los metodos de inicio de la clase transcripciones y logs.
     * @param primeraPisc Nombre de la primera piscifactoria.
     * @param extras Extras implementados en la piscifactoria.
     * @param pecesImplementasdos Peces implementados.
     * @param monedas Monedas al inicio de la partida.
     * @param nombrePartida Nombre del archivo.
     */
    public void inicio(String primeraPisc,String[] extras,String[] pecesImplementasdos,int monedas,String nombrePartida){
        transcripciones.inicio(primeraPisc, extras, pecesImplementasdos, monedas, nombrePartida);
        logs.inicio(primeraPisc, extras, pecesImplementasdos, nombrePartida);
    }
    
    /**
     * Metodo que llama a los metodos comprarComida de la clase transcripiciones y logs.
     * @param cantComida Cantidad de comida comprada.
     * @param tipoCom Tipo de comida.
     * @param monedas Monedas gastadas.
     * @param lugarGuardado Lugar en el que se guarda la comida.
     * @param pisc Piscifactoria en la que se guarda la comida(en que caso de guardarse en una pisicfactoria).
     */
    public void comprarComida(int cantComida, String tipoCom, int monedas, String lugarGuardado ,Piscifactoria pisc){
        transcripciones.comprarComida(cantComida, tipoCom, monedas, lugarGuardado, pisc);
        logs.comprarComida(cantComida, tipoCom, lugarGuardado, pisc);
    }
    
    /**
     * Metodo que llama a los metodos comprarPeces de la clase transcripiciones y logs.
     * @param pez Pez comprado.
     * @param sexo Sexo del pez.
     * @param tanque Tanque al que va el pez.
     * @param pisc Piscifactoria a la va el pez.
     * @param monedas Monedas gastadas en el pez.
     */
    public void comprarPeces(Pez pez, char sexo, int tanque, Piscifactoria pisc, int monedas){
        transcripciones.comprarPeces(pez, sexo, tanque, pisc, monedas);
        logs.comprarPeces(pez, sexo, tanque, pisc);
    }
    
    /**
     * Metodo que llama a los metodos venderPeces de la clase transcripiciones y logs.
     * @param cantPeces Peces vendidos.
     * @param monedas Monedas obtenidas.
     * @param pisc Piscifactoria de la que se vendieron los peces.
     */
    public void venderPeces(int cantPeces, int monedas, Piscifactoria pisc){
        transcripciones.venderPeces(cantPeces, monedas, pisc);
        logs.venderPeces(cantPeces, pisc);
    }
    
    /**
     * Metodo que llama a los metodos limpiarTanque de la clase transcripiciones y logs.
     * @param tanque Tanque limpiado.
     * @param pisc Piscifactoria a la que pertenece el tanque.
     */
    public void limpiarTanque(int tanque, Piscifactoria pisc){
        transcripciones.limpiarTanque(tanque, pisc);
        logs.limpiarTanque(tanque, pisc);
    }
    
    /**
     * Metodo que llama a los metodos vaciarTanque de la clase transcripiciones y logs.
     * @param tanque Tanque vaciado.
     * @param pisc Piscifactoria a la que pertenece el tanque.
     */
    public void vaciarTanque(int tanque, Piscifactoria pisc){
        transcripciones.vaciarTanque(tanque, pisc);
        logs.limpiarTanque(tanque, pisc);
    }

    /**
     * Metodo que llama a los metodos comprarEdificio de la clase transcripiciones y logs.
     * @param pisc Edificio comprado(en caso de ser almacen central, null).
     * @param monedas Monedas gastadas.
     */
    public void comprarEdificio(Piscifactoria pisc, int monedas){
        transcripciones.comprarEdificio(pisc, monedas);
        logs.comprarEdificio(pisc);
    }
    
    /**
     * Metodo que llama a los metodos mejorarEdificio de la clase transcripiciones y logs.
     * @param pisc Edificio mejorado (en caso de ser almacen central, null).
     * @param monedas Monedsas gastadas.
     * @param tanque Tanque comprado (en caso de que la mejora sea comrar un tanque).
     * @param almacenCentral Almacen central.
     */
    public void mejorarEdificio(Piscifactoria pisc, int monedas, int tanque, AlmacenCentral almacenCentral){
        transcripciones.mejorarEdificio(pisc, monedas, tanque, almacenCentral);
        logs.mejorarEdificio(pisc, tanque);
    }
    
    /**
     * Metodo que llama a los metodos pasarDia de la clase transcripiciones y logs.
     * @param numDia Día terminado.
     * @param pecesRio Peces de rio vendidos de forma automatica.
     * @param pecesMar Peces de mar vendidos de forma automatica.
     * @param monedasObtenidas Monedas obtenidas con la venta.
     * @param monedasTotales Monedas totales de la simulación.
     */
    public void pasarDia(int numDia, int pecesRio, int pecesMar, int monedasObtenidas, int monedasTotales){
        transcripciones.pasarDia(numDia, pecesRio, pecesMar, monedasObtenidas, monedasTotales);
        logs.pasarDia(numDia);
    }
    
    /**
     * Metodo que llama a los metodos ocultas de la clase transcripiciones y logs.
     * @param pisc Piscifactoria a la que se añaden los peces (en caso de ser la opcion 98).
     * @param monedasAñad Monedas añadidas (en caso de ser la opcion 99)
     * @param monedas Monedas totales.
     */
    public void ocultas(Piscifactoria pisc, int monedasAñad, int monedas){
        transcripciones.ocultas(pisc, monedasAñad, monedas);
        logs.ocultas(pisc);
    }

    /**
     * Método que llama a los metodos recompensaCreada de la clase transcripiciones y logs.
     * @param nombreRec Nombre de la recompensa.
     */
    public void recompensaCreada(String nombreRec){
        transcripciones.recompensaCreada(nombreRec);
        logs.recompensaCreada(nombreRec);
    }

    /**
     * Método que llama a los metodos recompensaUsada de la clase transcripiciones y logs.
     * @param nombreRec Nombre de la recompensa.
     */
    public void recompensaUsada(String nombreRec){
        transcripciones.recompensaUsada(nombreRec);
        logs.recompensaUsada(nombreRec);
    }

    /**
     * Metodo que llama al metodo salir de logs y al método close de logs y transcripciones.
     */
    public void salir(){
        logs.salir();
        transcripciones.close();
        logs.close();
    }
}
