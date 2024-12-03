package registros;

import comun.AlmacenCentral;
import peces.Pez;
import piscifactoria.Piscifactoria;

public class Registros {
    Transcripciones transcripciones=null;
    Logs logs=null;

    public Registros(String nombrePartida) {
        transcripciones=Transcripciones.getInstance(nombrePartida);
        logs=Logs.getInstance(nombrePartida);
    }

    public void inicio(String primeraPisc,String[] extras,String[] pecesImplementasdos,int monedas,String nombrePartida){
        transcripciones.inicio(primeraPisc, extras, pecesImplementasdos, monedas, nombrePartida);
        logs.inicio(primeraPisc, extras, pecesImplementasdos, nombrePartida);
    }
    
    public void comprarComida(int cantComida, String tipoCom, int monedas, String lugarGuardado ,Piscifactoria pisc){
        transcripciones.comprarComida(cantComida, tipoCom, monedas, lugarGuardado, pisc);
        logs.comprarComida(cantComida, tipoCom, lugarGuardado, pisc);
    }
    
    public void comprarPeces(Pez pez, char sexo, int tanque, Piscifactoria pisc, int monedas){
        transcripciones.comprarPeces(pez, sexo, tanque, pisc, monedas);
        logs.comprarPeces(pez, sexo, tanque, pisc);
    }
    
    public void venderPeces(int cantPeces, int monedas, Piscifactoria pisc){
        transcripciones.venderPeces(cantPeces, monedas, pisc);
        logs.venderPeces(cantPeces, pisc);
    }
    
    public void limpiarTanque(int tanque, Piscifactoria pisc){
        transcripciones.limpiarTanque(tanque, pisc);
        logs.limpiarTanque(tanque, pisc);
    }
    
    public void vaciarTanque(int tanque, Piscifactoria pisc){
        transcripciones.vaciarTanque(tanque, pisc);
        logs.limpiarTanque(tanque, pisc);
    }

    public void comprarEdificio(Piscifactoria pisc, int monedas){
        transcripciones.comprarEdificio(pisc, monedas);
        logs.comprarEdificio(pisc);
    }
    
    public void mejorarEdificio(Piscifactoria pisc, int monedas, int tanque, AlmacenCentral almacenCentral){
        transcripciones.mejorarEdificio(pisc, monedas, tanque, almacenCentral);
        logs.mejorarEdificio(pisc, tanque);
    }
    
    public void pasarDia(int numDia, int pecesRio, int pecesMar, int monedasObtenidas, int monedasTotales){
        transcripciones.pasarDia(numDia, pecesRio, pecesMar, monedasObtenidas, monedasTotales);
        logs.pasarDia(numDia);
    }
    
    public void ocultas(Piscifactoria pisc, int monedasAñad, int monedas){
        transcripciones.ocultas(pisc, monedasAñad, monedas);
        logs.ocultas(pisc);
    }

    public void salir(){
        logs.salir();
    }
}
