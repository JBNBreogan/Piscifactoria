package peces.Mar;

import peces.Pez;
import propiedades.AlmacenPropiedades;

public class Besugo extends Pez{

    public Besugo(char Sexo){
        this.Nombre = AlmacenPropiedades.BESUGO.getNombre();
        this.Cientifico = AlmacenPropiedades.BESUGO.getCientifico();
        this.Ciclo = AlmacenPropiedades.BESUGO.getCiclo();
        this.Coste = AlmacenPropiedades.BESUGO.getCoste();
        this.Huevos = AlmacenPropiedades.BESUGO.getHuevos();
        this.Madurez = AlmacenPropiedades.BESUGO.getMadurez();
        this.Monedas = AlmacenPropiedades.BESUGO.getMonedas();
        this.Optimo = AlmacenPropiedades.BESUGO.getOptimo();
        this.Piscifactoria = AlmacenPropiedades.BESUGO.getPiscifactoria();
        this.Propiedadas = AlmacenPropiedades.BESUGO.getPropiedades();
        this.Tipo = AlmacenPropiedades.BESUGO.getTipo();
        this.Sexo = Sexo;
        this.Fertil = false;
        this.Vivo = true;
        this.Edad = 0;
    }
    //TODO Todo el pez
}
