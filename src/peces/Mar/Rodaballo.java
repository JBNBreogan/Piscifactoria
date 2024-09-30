package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Rodaballo extends Pez{

    public Rodaballo(char Sexo){
        this.Nombre = AlmacenPropiedades.RODABALLO.getNombre();
        this.Cientifico = AlmacenPropiedades.RODABALLO.getCientifico();
        this.Ciclo = AlmacenPropiedades.RODABALLO.getCiclo();
        this.Coste = AlmacenPropiedades.RODABALLO.getCoste();
        this.Huevos = AlmacenPropiedades.RODABALLO.getHuevos();
        this.Madurez = AlmacenPropiedades.RODABALLO.getMadurez();
        this.Monedas = AlmacenPropiedades.RODABALLO.getMonedas();
        this.Optimo = AlmacenPropiedades.RODABALLO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.RODABALLO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.RODABALLO.getPropiedades();
        this.Tipo = AlmacenPropiedades.RODABALLO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
