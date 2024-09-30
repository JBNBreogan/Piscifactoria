package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;


public class Carpa extends Pez{

    public Carpa(char Sexo){
        this.Nombre = AlmacenPropiedades.CARPA.getNombre();
        this.Cientifico = AlmacenPropiedades.CARPA.getCientifico();
        this.Ciclo = AlmacenPropiedades.CARPA.getCiclo();
        this.Coste = AlmacenPropiedades.CARPA.getCoste();
        this.Huevos = AlmacenPropiedades.CARPA.getHuevos();
        this.Madurez = AlmacenPropiedades.CARPA.getMadurez();
        this.Monedas = AlmacenPropiedades.CARPA.getMonedas();
        this.Optimo = AlmacenPropiedades.CARPA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.CARPA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.CARPA.getPropiedades();
        this.Tipo = AlmacenPropiedades.CARPA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }

    
    //TODO Todo el pez
}
