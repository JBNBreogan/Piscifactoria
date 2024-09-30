package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Robalo extends Pez{

    public Robalo(char Sexo){
        this.Nombre = AlmacenPropiedades.ROBALO.getNombre();
        this.Cientifico = AlmacenPropiedades.ROBALO.getCientifico();
        this.Ciclo = AlmacenPropiedades.ROBALO.getCiclo();
        this.Coste = AlmacenPropiedades.ROBALO.getCoste();
        this.Huevos = AlmacenPropiedades.ROBALO.getHuevos();
        this.Madurez = AlmacenPropiedades.ROBALO.getMadurez();
        this.Monedas = AlmacenPropiedades.ROBALO.getMonedas();
        this.Optimo = AlmacenPropiedades.ROBALO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.ROBALO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.ROBALO.getPropiedades();
        this.Tipo = AlmacenPropiedades.ROBALO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;

    }
    //TODO Todo el pez
}
