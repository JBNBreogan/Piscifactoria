package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class SalmonChinook extends Pez{

    public SalmonChinook(char Sexo){
        this.Nombre = AlmacenPropiedades.SALMON_CHINOOK.getNombre();
        this.Cientifico = AlmacenPropiedades.SALMON_CHINOOK.getCientifico();
        this.Ciclo = AlmacenPropiedades.SALMON_CHINOOK.getCiclo();
        this.Coste = AlmacenPropiedades.SALMON_CHINOOK.getCoste();
        this.Huevos = AlmacenPropiedades.SALMON_CHINOOK.getHuevos();
        this.Madurez = AlmacenPropiedades.SALMON_CHINOOK.getMadurez();
        this.Monedas = AlmacenPropiedades.SALMON_CHINOOK.getMonedas();
        this.Optimo = AlmacenPropiedades.SALMON_CHINOOK.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.SALMON_CHINOOK.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.SALMON_CHINOOK.getPropiedades();
        this.Tipo = AlmacenPropiedades.SALMON_CHINOOK.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
