package peces.Rio;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Koi extends Pez{

    public Koi(char Sexo){
        this.Nombre = AlmacenPropiedades.KOI.getNombre();
        this.Cientifico = AlmacenPropiedades.KOI.getCientifico();
        this.Ciclo = AlmacenPropiedades.KOI.getCiclo();
        this.Coste = AlmacenPropiedades.KOI.getCoste();
        this.Huevos = AlmacenPropiedades.KOI.getHuevos();
        this.Madurez = AlmacenPropiedades.KOI.getMadurez();
        this.Monedas = AlmacenPropiedades.KOI.getMonedas();
        this.Optimo = AlmacenPropiedades.KOI.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.KOI.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.KOI.getPropiedades();
        this.Tipo = AlmacenPropiedades.KOI.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
