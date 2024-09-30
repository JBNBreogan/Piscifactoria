package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class PercaEuropea extends Pez{

    public PercaEuropea(char Sexo){
        this.Nombre = AlmacenPropiedades.PERCA_EUROPEA.getNombre();
        this.Cientifico = AlmacenPropiedades.PERCA_EUROPEA.getCientifico();
        this.Ciclo = AlmacenPropiedades.PERCA_EUROPEA.getCiclo();
        this.Coste = AlmacenPropiedades.PERCA_EUROPEA.getCoste();
        this.Huevos = AlmacenPropiedades.PERCA_EUROPEA.getHuevos();
        this.Madurez = AlmacenPropiedades.PERCA_EUROPEA.getMadurez();
        this.Monedas = AlmacenPropiedades.PERCA_EUROPEA.getMonedas();
        this.Optimo = AlmacenPropiedades.PERCA_EUROPEA.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.PERCA_EUROPEA.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.PERCA_EUROPEA.getPropiedades();
        this.Tipo = AlmacenPropiedades.PERCA_EUROPEA.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
