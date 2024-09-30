package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Caballa extends Pez{

    public Caballa(char Sexo){
        this.Nombre = AlmacenPropiedades.CABALLA.getNombre();
        this.Cientifico = AlmacenPropiedades.CABALLA.getCientifico();
        this.Ciclo = AlmacenPropiedades.CABALLA.getCiclo();
        this.Coste = AlmacenPropiedades.CABALLA.getCoste();
        this.Huevos = AlmacenPropiedades.CABALLA.getHuevos();
        this.Madurez = AlmacenPropiedades.CABALLA.getMadurez();
        this.Monedas = AlmacenPropiedades.CABALLA.getMonedas();
        this.Optimo = AlmacenPropiedades.CABALLA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.CABALLA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.CABALLA.getPropiedades();
        this.Tipo = AlmacenPropiedades.CABALLA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
